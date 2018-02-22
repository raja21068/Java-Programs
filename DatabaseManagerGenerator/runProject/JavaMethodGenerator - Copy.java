
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Jay Kumar
 */
public class JavaMethodGenerator {
    public static void createBean(String driver,String url,String username,String password ,String desPath,JLabel status)throws Exception{
        Class.forName(driver);    
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
            while(rs.next()){
                String tableName = rs.getString(3);
                String beanName = CamelNotationHandler.getTableType(tableName)+"Bean";
                
                //setting status
                status.setText(beanName);
                
                PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+beanName+".java"));
                
                fos.println("// ** author @Jay K  **");
                fos.println("");
                fos.println("class "+beanName+"{");
                
                Statement st = connection.createStatement();
                ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
                ResultSetMetaData rsMetaData = tableRS.getMetaData();
                
                String variables = "";
                String setterMethods = "";
                String getterMethods = "";
                for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
                    String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
                    if(type.equals("Date")){
                        type = "java.util.Date";
                    }
                    String originalName = rsMetaData.getColumnName(i);
                    String var = CamelNotationHandler.getVariableType(originalName);
                    
                    variables += "    private "+type+" "+var +";\n"; 
                    setterMethods += "    public void set"+CamelNotationHandler.getTableType(originalName)+"("+type+" "+var+"){"
                            + "\n        this."+var+" = "+var+" ;"
                            + "\n    }\n";
                    getterMethods += "    public "+type+" get"+CamelNotationHandler.getTableType(originalName)+"(){"
                            + "\n        return this."+var+" ;"
                            + "\n    }\n";
                    
                    
                }
                
                fos.println("  // Variables declaration - do not modify");
                fos.println(variables);
                fos.println("\n\n");
                fos.println("//Setter Methods Generated");
                fos.println(setterMethods);
                fos.println("\n\n");
                fos.println("//Getter Methods Generated");
                fos.println(getterMethods);
                printToString(fos);
                fos.println("}");
                fos.close();
            }
            connection.close();
    }
    public static void printToString(PrintStream fos) {
        fos.println("    public String toString(){");
        fos.println("        return \"\";");
        fos.println("       }");
    }
    
  
    
    public static void createJavaSelectMethod(PrintStream out ,ResultSetMetaData rsMetaData ,String tableName, String className)throws Exception{
        out.println("    // "+tableName+" methods");
        out.println("    public static ArrayList getAll"+className+"()throws Exception{");
        out.println("        ArrayList list = new ArrayList();");
        out.println("        String query=\"SELECT * from "+tableName+"\";");
        out.println("        Statement st = connection.createStatement();");
        out.println("        ResultSet rs = st.executeQuery(query);");
        out.println("        while(rs.next()){");
        out.println("            "+className+"Bean bean = new "+className+"Bean();") ;
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            out.println("            bean.set"+CamelNotationHandler.getTableType(originalName)+"(rs.get"+CamelNotationHandler.firstLetterCapital(type)+"(\""+originalName+"\") );");     
        }
        out.println("            list.add(bean);\n");
        out.println("        }\n");
        out.println("        st.close();\n");
        out.println("        return list;\n");
        out.println("    }\n");
    }

    public static void createJaveInsertMethod(PrintStream out ,ResultSetMetaData rsMetaData,String tableName ,String className , String primaryKey)throws Exception{
        out.print("    public static int add"+className+"(");
        String columns = "";
        String variables = "";
        
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);
                
            if(!originalName.equals(primaryKey)){
                out.print(type+" "+colVarType);
                variables += "'\"+"+colVarType+"+\"'";
                columns+= originalName;
                
                if(i!=rsMetaData.getColumnCount()){
                    out.print(", ");
                    columns+= ", ";
                    variables+= ", ";
                }
            }  
        }
            out.println(")throws Exception{");
            out.println("        String query = \"Insert into "+tableName+" ("+columns+") values ("+variables+")\";");
            out.println("        Statement st = connection.createStatement();");
            out.println("        int r = st.executeUpdate(query);");
            out.println("        st.close();");
            out.println("        return r;");
            out.println("    }");
            
     }

    public static void createJavaDeleteMethod(PrintStream out,ResultSetMetaData rsMetaData ,String tableName ,String className,String primaryKey)throws Exception{
        out.print("    public static int delete"+className+"(");
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            if(originalName.equals(primaryKey)){
                out.print(type+" "+colVarType);
            }
        }    
        out.println(")throws Exception{");
        out.println("        String query = \"DELETE from "+tableName+" WHERE "+primaryKey+" = \"+"+CamelNotationHandler.getVariableType(primaryKey)+";") ;
        out.println("        Statement st = connection.createStatement();");
        out.println("        int r = st.executeUpdate(query);");
        out.println("        return r;");
        out.println("    }");
    }
    
    public static void createJavaUpdateMethod(PrintStream out,ResultSetMetaData rsMetaData,String tableName ,String className, String primaryKey)throws Exception{
        out.print("    public static int update"+className+"(");
        String  updateValues = "";   
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            out.print(type+" "+colVarType+"");
            if(i!=rsMetaData.getColumnCount()){
                out.print(", ");
            }
            if(!originalName.equals(primaryKey)){
                updateValues += originalName+" = "+"'\"+"+colVarType+"+\"'";
                if(i!=rsMetaData.getColumnCount()){
                    updateValues+= ", ";
                }
            }
            
        }    


        out.println(")throws Exception{\n");
        out.println("        String query = \"UPDATE "+tableName+" SET "+updateValues+" WHERE "+primaryKey+" =\"+ "+CamelNotationHandler.getVariableType(primaryKey)+";");
        out.println("        Statement st = connection.createStatement();");
        out.println("        int r = st.executeUpdate(query);");
        out.println("        return r;");
        out.println("    }");
            
    }
    
    public static void generateDBM(String desPath, String dbPath,JLabel status)throws Exception{
        ArrayList tableNames = new ArrayList();
        
        Connection connection= DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        
        PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+"DatabaseManager.java"));
        fos.println("// ** author @Jay K  ** \n");
        fos.println("import java.util.*; ");
        fos.println("import java.sql.Connection;\n" +
                    "import java.sql.DatabaseMetaData;\n" +
                    "import java.sql.ResultSet;\n" +"import java.sql.ResultSetMetaData;\n" +
                    "import java.sql.Statement;\n");
        fos.println("class DatabaseManager{");
        fos.println("    static java.sql.Connection connection;");
        fos.println("    static{");
        fos.println("        try{");
        fos.println("             Class.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");\n" +
"            connection = java.sql.DriverManager.getConnection(\"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=database/database.mdb\");");        
        fos.println("        } catch(Exception e){ e.printStackTrace(); }\n" +
                    "    }");
        while(rs.next()){
            String tableName = rs.getString(3);
            
            //setting status
                status.setText(tableName);
            
            // Checking if the table is repeated
            // Some times is happens that a table is repeated
            if(tableNames.contains(tableName)){
               continue; 
            }else{
                tableNames.add(tableName);
            }
            
            Statement st = connection.createStatement();
            ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
            String className = CamelNotationHandler.getTableType(tableName);
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
            
            JavaMethodGenerator.createJavaSelectMethod(fos, rsMetaData, tableName, className);
            JavaMethodGenerator.createJaveInsertMethod(fos, rsMetaData, tableName, className, primaryKey);
            JavaMethodGenerator.createJavaDeleteMethod(fos, rsMetaData, tableName, className, primaryKey);
            JavaMethodGenerator.createJavaUpdateMethod(fos, rsMetaData, tableName, className, primaryKey);
        }
        fos.println("}//end of class");
        fos.close();
        rs.close();
        connection.close();
    }
}
