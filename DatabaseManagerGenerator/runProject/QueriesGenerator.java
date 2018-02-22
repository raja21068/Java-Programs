
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
public class QueriesGenerator {
    
    public static void createSelectQuery(PrintStream out ,ResultSetMetaData rsMetaData ,String tableName, String className)throws Exception{
        out.println("    // "+tableName+" Queries");
        out.println("    SELECT * from "+tableName);   
    }

    public static void createInsertQuery(PrintStream out ,ResultSetMetaData rsMetaData,String tableName ,String className , String primaryKey)throws Exception{
        String columns = "";
        String variables = "";
        
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);
                
            if(!originalName.equals(primaryKey)){
                variables += "'\"+"+colVarType+"+\"'";
                columns+= originalName;
                
                if(i!=rsMetaData.getColumnCount()){
                    out.print(", ");
                    columns+= ", ";
                    variables+= ", ";
                }
            }  
        }
            out.println("        Insert into "+tableName+" ("+columns+") values ("+variables+")");
            
     }

    public static void createDeleteQuery(PrintStream out,ResultSetMetaData rsMetaData ,String tableName ,String className,String primaryKey)throws Exception{
        
        out.println("        DELETE from "+tableName+" WHERE "+primaryKey+" = \"+"+CamelNotationHandler.getVariableType(primaryKey)) ;
        
    }
    
    public static void createUpdateQuery(PrintStream out,ResultSetMetaData rsMetaData,String tableName ,String className, String primaryKey)throws Exception{
        String  updateValues = "";   
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getJavaType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            if(!originalName.equals(primaryKey)){
                updateValues += originalName+" = "+"'\"+"+colVarType+"+\"'";
                if(i!=rsMetaData.getColumnCount()){
                    updateValues+= ", ";
                }
            }
            
        }    

        out.println("        String query = \"UPDATE "+tableName+" SET "+updateValues+" WHERE "+primaryKey+" =\"+ "+CamelNotationHandler.getVariableType(primaryKey)+";");
            
    }
    
    public static void generateDBM(String desPath, String dbPath,JLabel status)throws Exception{
        ArrayList tableNames = new ArrayList();
        
        Connection connection= DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        
        PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+"DatabaseManager.java"));
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
            
            createSelectQuery(fos, rsMetaData, tableName, className);
            createInsertQuery(fos, rsMetaData, tableName, className, primaryKey);
            createDeleteQuery(fos, rsMetaData, tableName, className, primaryKey);
            createUpdateQuery(fos, rsMetaData, tableName, className, primaryKey);
        }
        fos.close();
        rs.close();
        connection.close();
    }
}
