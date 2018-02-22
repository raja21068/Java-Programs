
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jay Kumar
 */
public class HybernetMethods {
    public static void generateHibernetCnfXml(String driver,String url,String username,String password,String desFolder,String dialact)throws Exception{
        ArrayList list = getAllTables(driver, url, username, password);
        PrintStream out = new PrintStream(new FileOutputStream(desFolder+File.separator+"hibernate.cfg.xml"));
        out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        out.println("<!DOCTYPE hibernate-configuration SYSTEM ");
        out.println("\"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd\">");

        out.println("<hibernate-configuration>");
        out.println("<session-factory>");
        out.println("<property name=\"hibernate.dialect\">");
        out.println(dialact);
        out.println("</property>");
        out.println("<property name=\"hibernate.connection.driver_class\">");
        out.println(driver);//com.mysql.jdbc.Driver
        out.println("</property>");

        out.println("<!-- Assume test is the database name -->");
        out.println("<property name=\"hibernate.connection.url\">");
        out.println(url);//jdbc:mysql://localhost/test
        out.println("</property>");
        out.println("<property name=\"hibernate.connection.username\">");
        out.println(username);//root
        out.println("</property>");
        out.println("<property name=\"hibernate.connection.password\">");
        out.println(password);
        out.println("</property>");

        out.println("<!-- List of XML mapping files -->");
        for(int i=0;i<list.size();i++){
            out.println("<mapping resource=\""+CamelNotationHandler.getTableType(list.get(i).toString()) +".hbm.xml\"/>");
        }
        
        out.println("</session-factory>");
        out.println("</hibernate-configuration>");
    }
    public static ArrayList getAllTables(String driver,String url,String username,String password)throws Exception{
        Class.forName(driver);
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        ArrayList tableList = new ArrayList();
        while(rs.next()){
            String tableName = rs.getString(3);
            if(!tableList.contains(tableName)){
                tableList.add(tableName);
            }
        }
        connection.close();
        return tableList;
    }
    
    public static String generateTableXml(String driver,String url,String username,String password,String desFolder)throws Exception{
        Class.forName(driver);
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = connection.getMetaData();
        
        ArrayList list = getAllTables(driver, url, username, password);
        String fileInfo="";
        for(int i=0;i<list.size();i++){
            String tableName = list.get(i).toString();
            String className = CamelNotationHandler.getTableType(list.get(i).toString());
            
            ResultSet primaryKeys = metaData.getIndexInfo(null, null, tableName, false, false);
            String primaryKey = "";
            
            if(primaryKeys!=null){
                while(primaryKeys.next()){
                    String type = primaryKeys.getString("INDEX_NAME");
                    if(type!=null && (type.equals("PrimaryKey")||type.equals("PRIMARY"))){
                        primaryKey = primaryKeys.getString("COLUMN_NAME");
                        break;
                    }
                }
            }
            
            PrintStream out = new PrintStream(new FileOutputStream(desFolder+File.separator+className+".hbm.xml"));
            Statement st = connection.createStatement();
            ResultSet tableRS = st.executeQuery("SELECT * from "+list.get(i).toString());
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
            
            
            out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            out.println("<!DOCTYPE hibernate-mapping PUBLIC");
            out.println("\"-//Hibernate/Hibernate Mapping DTD//EN\"");
            out.println("\"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">"); 

            out.println("      <hibernate-mapping>");
            out.println("          <class name=\""+className+"\" table=\""+tableName.toUpperCase()+"\">");
            out.println("               <meta attribute=\"class-description\">");
            out.println("               </meta>");
            
            String primary = "";
            String cols = "";
            
            for(int j=1;j<=rsMetaData.getColumnCount();j++){ 
                String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(j));
                String originalName = rsMetaData.getColumnName(j);
                String var = CamelNotationHandler.getVariableType(originalName);

                if(!originalName.equals(primaryKey)){
                    cols += ("               <property name=\""+var+"\" column=\""+originalName+"\" type=\""+type.toLowerCase()+"\"/>\n");
                }else{
                    out.println("               <id name=\""+var+"\" type=\""+type.toLowerCase()+"\" column=\""+originalName+"\">");
                    out.println("                     <generator class=\"native\"/>");
                    out.println("               </id>");
                }
            }
            out.println(cols);
            out.println("           </class>");
            out.println("      </hibernate-mapping>");
        
            //This String send the info of generated file to the caller
            fileInfo+= (className+".hbm.xml\n");
            
        }
        
        //This returns the name of files which has been created
        return fileInfo;
    }
    
    public static String generateTableDotJava(String driver,String url,String username,String password,String desFolder)throws Exception{
        Class.forName(driver);
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = connection.getMetaData();
        String fileInfo="";
        
        ArrayList list = getAllTables(driver, url, username, password);
        for(int i=0;i<list.size();i++){
            String className = CamelNotationHandler.getTableType(list.get(i).toString());
            String beanName = className;
            fileInfo += className+".java\n";
            String tableName = list.get(i).toString();
            
            ResultSet primaryKeys = metaData.getIndexInfo(null, null, tableName, false, false);
            String primaryKey = "";
            
            if(primaryKeys!=null){
                while(primaryKeys.next()){
                    String type = primaryKeys.getString("INDEX_NAME");
                    if(type!=null && (type.equals("PrimaryKey")||type.equals("PRIMARY"))){
                        primaryKey = primaryKeys.getString("COLUMN_NAME");
                        break;
                    }
                }
            }

            
            PrintStream fos = new PrintStream(new FileOutputStream(desFolder+File.separator+className+".java"));
            fos.println("class "+beanName+"{");
                
            Statement st = connection.createStatement();
            ResultSet tableRS = st.executeQuery("SELECT * from "+list.get(i).toString());
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
                
            String variables = "";
            String setterMethods = "";
            String getterMethods = "";
            String constructor = "    public "+beanName+"(){}\npublic "+beanName+"(";
            String constructorBody="";
                
            for(int j=1;j<=rsMetaData.getColumnCount();j++){ 
                String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(j));
                if(type.equals("Date")){
                    type = "java.util.Date";
                }

                String originalName = rsMetaData.getColumnName(j);
                String var = CamelNotationHandler.getVariableType(originalName);

                if(!originalName.equals(primaryKey)){
                    constructor+= type+" "+var;
                    constructorBody+= "\nthis."+var+" = "+var+";";
                    if(j!=rsMetaData.getColumnCount()){
                        constructor+= ", ";
                    }
                }

                variables += "    private "+type+" "+var +";\n"; 
                setterMethods += "    public void set"+CamelNotationHandler.getTableType(originalName)+"("+type+" "+var+"){"
                        + "\n        this."+var+" = "+var+" ;"
                        + "\n    }\n";
                getterMethods += "    public "+type+" get"+CamelNotationHandler.getTableType(originalName)+"(){"
                        + "\n        return this."+var+" ;"
                        + "\n    }\n";


            }
            constructor +="){"+constructorBody+"}";

            fos.println("  // Variables declaration - do not modify");
            fos.println(variables);
            fos.println(constructor);
            fos.println("\n\n");
            fos.println("//Setter Methods Generated");
            fos.println(setterMethods);
            fos.println("\n\n");
            fos.println("//Getter Methods Generated");
            fos.println(getterMethods);
            JavaMethodGenerator.printToString(fos);
            fos.println("}");
            fos.close();
        }
        
        connection.close();
        //This returns the name of files which has been created
        return fileInfo;
    }
    
    public static void generateDBM(String driver,String url,String username,String password,String desFolder,boolean delete , boolean update,boolean insert, boolean select)throws Exception{
        Class.forName(driver);
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = connection.getMetaData();
        
        
        ArrayList list = getAllTables(driver, url, username, password);
        PrintStream out = new PrintStream(new FileOutputStream(desFolder+File.separator+"DatabaseManager.java"));
        Statement st = connection.createStatement();
        
        out.println("import java.util.*;"); 
        out.println("import org.hibernate.HibernateException;"); 
        out.println("import org.hibernate.Session; ");
        out.println("import org.hibernate.Transaction;");
        out.println("import org.hibernate.SessionFactory;");
        out.println("import org.hibernate.cfg.Configuration;");
        out.println("import org.hibernate.dialect.SybaseAnywhereDialect;");
        out.println("class DatabaseManager{");
        out.println("    private static SessionFactory factory; ");
        out.println("    static{"
                + "        try{\n"
                + "            factory = new Configuration().configure().buildSessionFactory();\n"
                + "        }catch(Exception ex){ex.printStackTrace();}\n"
                + "    }\n");
        
        String deleteMethod = "";
        String updateMethod = "";
        String insertMethod = "";
                
        for(int i=0;i<list.size();i++){
            String tableName = list.get(i).toString();
            String className = CamelNotationHandler.getTableType(list.get(i).toString());
            String settingValues = "";
            String insertValues = "";
            String insertParam = "";
            deleteMethod = "    public static void delete"+className+"(";
            updateMethod = "    public static void update"+className+"(";
            insertMethod = "    public static Integer add"+className+"(";
            
            ResultSet primaryKeys = metaData.getIndexInfo(null, null, tableName, false, false);
            String primaryKey = "";
            
            if(primaryKeys!=null){
                while(primaryKeys.next()){
                    String type = primaryKeys.getString("INDEX_NAME");
                    if(type!=null && (type.equals("PrimaryKey")||type.equals("PRIMARY"))){
                        primaryKey = primaryKeys.getString("COLUMN_NAME");
                        break;
                    }
                }
            }
            
            ResultSet tableRS = st.executeQuery("SELECT * from "+list.get(i).toString());
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
            
            for(int j=1;j<=rsMetaData.getColumnCount();j++){ 
                String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(j));
                String originalName = rsMetaData.getColumnName(j);
                String var = CamelNotationHandler.getVariableType(originalName);
                 
               
                if(originalName.equals(primaryKey)){
                    deleteMethod += type+" id";
                    updateMethod += type+" id";
                    settingValues += "        ob.set"+CamelNotationHandler.firstLetterCapital(var)+"(id);\n";
                }else{
                    updateMethod += type+" "+var;
                    settingValues += "        ob.set"+CamelNotationHandler.firstLetterCapital(var)+"( "+var+");\n";
                    insertParam += type+" "+var;
                    insertValues += var;
                    if(j!=rsMetaData.getColumnCount()){
                        insertValues += ", ";
                        insertParam += ", ";
                    }
                }
                if(j!=rsMetaData.getColumnCount()){
                        updateMethod += ", ";
                        
                }
                
            }
            deleteMethod += "){\n"
                    + "        Session ses = factory.openSession();\n"
                    + "        Transaction tx = null;\n"
                    + "        try{ \n"
                    + "            tx = ses.beginTransaction(); \n"
                    + "            "+className+" ob = ("+className+")ses.get("+className+".class, id); \n"
                    + "            ses.delete(ob); \n"
                    + "            tx.commit();\n"
                    + "        }catch (HibernateException e) {\n"
                    + "        if (tx!=null) tx.rollback();\n"
                    + "            e.printStackTrace(); \n"
                    + "        }finally { \n"
                    + "           ses.close(); \n"
                    + "        } \n"
                    + "    } \n";
            
            updateMethod += "){\n"
                    + "        Session ses = factory.openSession();\n"
                    + "        Transaction tx = null;\n"
                    + "        try{ \n"
                    + "            tx = ses.beginTransaction(); \n"
                    + "            "+className+" ob = ("+className+")ses.get("+className+".class, id); \n"
                    +settingValues
                    + "            ses.update(ob); \n"
                    + "            tx.commit();\n"
                    + "        }catch (HibernateException e) {\n"
                    + "            if (tx!=null) tx.rollback();\n"
                    + "                e.printStackTrace(); \n"
                    + "        }finally { \n"
                    + "           ses.close(); \n"
                    + "        } \n"
                    + "    } \n";
            
            insertMethod += insertParam+"){ \n";
            insertMethod += "        Session ses = factory.openSession();\n"
                    + "        Transaction tx = null;\n"
                    + "        Integer id = null;\n"
                    + "        try{\n"
                    + "            tx = ses.beginTransaction();\n"
                    + "            "+className+" ob = new "+className+"("+insertValues+");\n"
                    + "            id = (Integer) ses.save(ob);\n"
                    + "            tx.commit();\n"
                    + "        }catch (HibernateException e) {\n"
                    + "            if (tx!=null) tx.rollback();\n"
                    + "            e.printStackTrace();\n "
                    + "        }finally {\n"
                    + "            ses.close();\n "
                    + "        };\n"
                    + "        return id;\n";
            insertMethod += "    }\n";
            
            if(select){
                out.println("    public static java.util.ArrayList get"+className+"(){");
                out.println("        Session session = factory.openSession();");
                out.println("        Transaction tx = null;");
                out.println("        java.util.ArrayList list = new java.util.ArrayList();");
                out.println("        try{");
                out.println("             tx = session.beginTransaction();");
                out.println("             List employees = session.createQuery(\"FROM "+className+"\").list(); ");
                out.println("             for (Iterator iterator = employees.iterator(); iterator.hasNext();){");
                out.println("                  "+className+" bean = ("+className+") iterator.next();");
                out.println("                  list.add(bean);");
                out.println("             }");
                out.println("             tx.commit();");
                out.println("          }catch (HibernateException e) {");
                out.println("              if (tx!=null) tx.rollback();");
                out.println("                  e.printStackTrace(); ");
                out.println("          }finally {");
                out.println("               session.close();"); 
                out.println("          }");
                out.println("          return list;");
                out.println("       }");
     
            }      
            
            if(insert){
                out.println(insertMethod);
            }
            if(delete){
                out.println(deleteMethod);
            }
            if(update){
                out.println(updateMethod);
            }
            
        }
        out.println("}");
        }
        
    }