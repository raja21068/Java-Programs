
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
 * @author Raja Kumar
 */
public class CSharpMthodGenerator {
    public static void createCsBean(String driver,String url,String username,String password ,String desPath,JLabel status)throws Exception{
        Class.forName(driver);    
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
            while(rs.next()){
                String tableName = rs.getString(3);
                String beanName = CamelNotationHandler.getTableType(tableName)+"Bean";
                
                //setting status
                status.setText(beanName);
                
                PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+beanName+".cs"));
                
                fos.println("// ** author @Jay K  **");
                fos.println("");
                fos.println("public class "+beanName+"{");
                
                Statement st = connection.createStatement();
                ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
                ResultSetMetaData rsMetaData = tableRS.getMetaData();
                
                String variables = "";
                String setterMethods = "";
                String getterMethods = "";
                for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
                    String type = TypeHandler.getCSharpType(rsMetaData.getColumnTypeName(i));
                    
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
     public static void createSelectMethod(PrintStream out ,ResultSetMetaData rsMetaData ,String tableName, String className)throws Exception{
        out.println("    // "+tableName+" methods");
        out.println("    public static ArrayList getAll"+className+"(){");
        out.println("        ArrayList v = new ArrayList();");
        out.println("        try{");
        out.print("              OleDbCommand command = new OleDbCommand( ");
        out.println("            \"SELECT * from "+tableName+"\");");
        out.println("            cnn.Open();");
        out.println("            OleDbDataReader rs = command.ExecuteReader();");
        out.println("            while (rs.Read()){");
        out.println("                "+className+"Bean bean = new "+className+"Bean();") ;
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getVbMethodType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            out.println("                if (!(rs.IsDBNull("+(i-1)+")))  bean.set"+CamelNotationHandler.getTableType(originalName)+"( rs.Get"+type+"("+(i-1)+"));");  
        
        }
        out.println("                 v.Add(rec);");        
        out.println("            }");
        out.println("         cnn.Close();");
        out.println("         }catch (Exception ex){");
        out.println("            System.Windows.Forms.MessageBox.Show(\"Error: \" + ex.Message + \"\" + ex.StackTrace);}");
        out.println("         return v;");
         out.println("    }//  end of "+tableName);
      
    }

    public static void createInsertMethod(PrintStream out ,ResultSetMetaData rsMetaData,String tableName ,String className , String primaryKey)throws Exception{
        out.print("    public static int add"+className+"(");
        String columns = "";
        String variables = "";
        
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getCSharpType(rsMetaData.getColumnTypeName(i));
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
        out.println(") {     ");
        out.println("        int rows = 0;");
        out.println("        try{");
        out.println("            String query = \"Insert into "+tableName+" ("+columns+") values ("+variables+")\";");
        out.println("            Console.WriteLine(query);");
        out.println("            OleDbCommand command = new OleDbCommand(query,cnn);");
        out.println("            cnn.Open();");
        out.println("            rows= command.ExecuteNonQuery();");
        out.println("            cnn.Close();");
        out.println("        }catch(System.Exception e){");
        out.println("            System.Windows.Forms.MessageBox.Show(\"Error: \"+e); } ");
        out.println("        return rows; ");
        out.println("   } //End Add");
        
     }

    public static void createDeleteMethod(PrintStream out,ResultSetMetaData rsMetaData ,String tableName ,String className,String primaryKey)throws Exception{
        out.print("    public static int delete"+className+"(");
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getCSharpType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            if(originalName.equals(primaryKey)){
                out.print(type+" "+colVarType);
            }
        }    
        out.println("){");
        out.println("        int rows = 0;");
        out.println("        try{");
        out.println("            String query = \"DELETE from "+tableName+" WHERE "+primaryKey+" = \"+"+CamelNotationHandler.getVariableType(primaryKey)+";") ;
        out.println("            Console.WriteLine(query);");
        out.println("            OleDbCommand command = new OleDbCommand(query,cnn);");
        out.println("            cnn.Open();");
        out.println("            rows = command.ExecuteNonQuery();");
        out.println("            cnn.Close();");
        out.println("        }catch(System.Exception e){");
        out.println("            System.Windows.Forms.MessageBox.Show(\"Error: \"+e); } ");
        out.println("        return rows; ");
        out.println("    } //End Method");

    }
    
    public static void createUpdateMethod(PrintStream out,ResultSetMetaData rsMetaData,String tableName ,String className, String primaryKey)throws Exception{
        out.print("    public static int update"+className+"(");
        String  updateValues = "";   
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getCSharpType(rsMetaData.getColumnTypeName(i));
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


        out.println("){");
        out.println("        int rows = 0;");
        out.println("        try{");
        out.println("            String query = \"UPDATE "+tableName+" SET "+updateValues+" WHERE "+primaryKey+" =\"+ "+CamelNotationHandler.getVariableType(primaryKey)+";");
        out.println("            Console.WriteLine(query);");
        out.println("            OleDbCommand command = new OleDbCommand(query,cnn);");
        out.println("            cnn.Open();");
        out.println("            rows = command.ExecuteNonQuery();");
        out.println("            cnn.Close();");
        out.println("        }catch(System.Exception e){");
        out.println("            System.Windows.Forms.MessageBox.Show(\"Error: \"+e); } ");
        out.println("        return rows; ");
        out.println("    } //End Function");
    
    }
    
    public static void generateDBM(String desPath, String dbPath, JLabel status)throws Exception{
        ArrayList tableNames = new ArrayList();
        
        Connection connection= DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        
        PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+"DatabaseManager.cs"));
        fos.println("// ** author @Jay K  ** \n");
        fos.println("using System;");
	fos.println("using System.Collections.Generic;");
        fos.println("using System.Linq;");
        fos.println("using System.Text;");
        fos.println("using System.Data.OleDb;");
        fos.println("using System.Collections;");
        fos.println("class DatabaseManager{");
        fos.println("    public static OleDbConnection cnn;");
        fos.println("");

        fos.println("    static DatabaseManager(){");
        fos.println("        try{");
        fos.println("            string path = \"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=library.mdb\";");
        fos.println("            cnn = new OleDbConnection(path);");
        fos.println("            //connection.Open();");
        fos.println("         }catch (Exception e)");
        fos.println("         {");
        fos.println("           System.Windows.Forms.MessageBox.Show(\"Error: \" + e);");
        fos.println("         }   //  end of tryCatch");
        fos.println("     }   // end of connectionLoad method");
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
            
            createSelectMethod(fos, rsMetaData, tableName, className);
            createInsertMethod(fos, rsMetaData, tableName, className, primaryKey);
            createDeleteMethod(fos, rsMetaData, tableName, className, primaryKey);
            createUpdateMethod(fos, rsMetaData, tableName, className, primaryKey);
        }
        fos.println("}//end of class");
        fos.close();
        rs.close();
        connection.close();
    }
}
