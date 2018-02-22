
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
 * @author Jay k
 */
public class VisualBasicMethodGenerator {
    public static void createVbBean(String driver,String url,String username,String password ,String desPath,JLabel status)throws Exception{
        Class.forName(driver);    
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
            while(rs.next()){
                String tableName = rs.getString(3);
                String beanName = CamelNotationHandler.getTableType(tableName)+"Bean";
                
                //setting status
                status.setText(beanName);
                
                PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+beanName+".vb"));
                
                fos.println("' ** author @Jay K  **");
                fos.println("");
                fos.println("class "+beanName+"");
                
                Statement st = connection.createStatement();
                ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
                ResultSetMetaData rsMetaData = tableRS.getMetaData();
                
                String variables = "";
                String setterMethods = "";
                String getterMethods = "";
                for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
                    String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
                    String originalName = rsMetaData.getColumnName(i);
                    String var = CamelNotationHandler.getVariableType(originalName);
                    
                    variables += "    private "+var+" "+type +"\n"; 
                    setterMethods += "    Public Sub set"+CamelNotationHandler.getTableType(originalName)+"(ByVal "+var+" "+type+")"
                            + "\n        Me."+var+" = "+var+" "
                            + "\n    End Sub\n";
                    getterMethods += "    Public Function get"+CamelNotationHandler.getTableType(originalName)+"() "+type+""
                            + "\n        Return Me."+var+" "
                            + "\n    End Function\n";
                    
                    
                }
                
                fos.println("  ' Variables declaration - do not modify");
                fos.println(variables);
                fos.println("\n\n");
                fos.println("'Setter Methods Generated");
                fos.println(setterMethods);
                fos.println("\n\n");
                fos.println("'Getter Methods Generated");
                fos.println(getterMethods);
                printToString(fos);
                fos.println("End Class");
                fos.close();
            }
            connection.close();
    }
    public static void printToString(PrintStream fos) {
        fos.println("    Public Overrides Function ToString() As String");
        fos.println("        Return \"\"");
        fos.println("       End Function");
    }
    public static void generateDBM(String desPath, String driver,String url,String username,String password,JLabel status)throws Exception{
        ArrayList tableNames = new ArrayList();
        
        Class.forName(driver);
        Connection connection= DriverManager.getConnection(url,username,password);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        
        PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+"DatabaseManager.vb"));
        fos.println("' ** author @Jay K  ** \n");
        fos.println("'* @author Raja ");
        fos.println("Public Class DatabaseManager ");
        fos.println("      Private Shared cnn As OleDb.OleDbConnection");
        fos.println("       Public Shared Sub init()");
        fos.println("      cnn = New System.Data.OleDb.OleDbConnection(\"Provider=Microsoft.Jet.OLEDB.4.0; Ole DB Services=-4; Data Source= file.mdb \")");
        fos.println("      End Sub");
                   
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
        fos.println("End Class");
        fos.close();
        rs.close();
        connection.close();
    }
    
    public static void createSelectMethod(PrintStream out ,ResultSetMetaData rsMetaData ,String tableName, String className)throws Exception{
        out.println("    ' "+tableName+" methods");
        out.println("Public Shared Function getAll"+className+"() As ArrayList  ");
        out.println("        Dim query As String =\"SELECT * from "+tableName+"\"");
        out.println("      Console.WriteLine(query)");
        out.println("      If Not cnn.State = ConnectionState.Open Then cnn.Open()");
        out.println("      Dim cmd As OleDb.OleDbCommand = cnn.CreateCommand()");
        out.println("      cmd.CommandText = query");
        out.println("      Dim r As OleDb.OleDbDataReader = cmd.ExecuteReader()");
        out.println("      Dim v As New ArrayList()");
        out.println("      While r.Read()");
        out.println("      Dim rec As New "+className+"Bean()");
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
            String methodType = TypeHandler.getVbMethodType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            out.println("           If Not r.IsDBNull("+(i-1)+") Then rec.set"+CamelNotationHandler.getTableType(originalName) +"( r.Get"+methodType+"("+(i-1)+"))");
        }
        out.println("       v.Add(rec)");        
        out.println("      End While");
        out.println("     cnn.close()");
        out.println("     Return v");
        out.println("   End Function");
    }
    
    public static void createInsertMethod(PrintStream out ,ResultSetMetaData rsMetaData,String tableName ,String className , String primaryKey)throws Exception{
        out.print("    Public Shared Function add"+className+"(");
        String columns = "";
        String variables = "";
        
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);
                
            if(!originalName.equals(primaryKey)){
                out.print("ByVal "+colVarType+" "+type);
                variables += "'\" & "+colVarType+" & \"'";
                columns+= originalName;
                
                if(i!=rsMetaData.getColumnCount()){
                    out.print(", ");
                    columns+= ", ";
                    variables+= ", ";
                }
            }  
        }
        out.println(") As Integer");
        out.println("        Dim query As String = \"Insert into "+tableName+" ("+columns+") values ("+variables+")\"");
        out.println("       Console.WriteLine(query)");
        out.println("       Dim ROW As Integer");
        out.println("       Dim cmd As New OleDb.OleDbCommand");
        out.println("       If Not cnn.State = ConnectionState.Open Then cnn.Open()");
        out.println("       cmd.Connection = cnn");
        out.println("       cmd.CommandText = query");
        out.println("       ROW = cmd.ExecuteNonQuery()");
        out.println("       cnn.Close()");
        out.println("       Return ROW");
        out.println("      End Function");
        out.println();
            
     }
    
    public static void createDeleteMethod(PrintStream out,ResultSetMetaData rsMetaData ,String tableName ,String className,String primaryKey)throws Exception{
        out.print("    Public Shared Function delete"+className+"(");
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            if(originalName.equals(primaryKey)){
                out.print("Dim "+colVarType+" "+type);
            }
        }    
        out.println(")As Integer");
        out.println("        Dim query As String = \"DELETE from "+tableName+" WHERE "+primaryKey+" = \" & "+CamelNotationHandler.getVariableType(primaryKey)) ;
        out.println("        Console.WriteLine(query)");
        out.println("        Dim ROW As Integer");
        out.println("        Dim cmd As New OleDb.OleDbCommand");
        out.println("        If Not cnn.State = ConnectionState.Open Then cnn.Open()");
        out.println("        cmd.Connection = cnn");
        out.println("        cmd.CommandText = query");
        out.println("        ROW = cmd.ExecuteNonQuery()");
        out.println("        cnn.Close()");
        out.println("        Return ROW");
        out.println("      End Function");
        out.println();
    }
    
    public static void createUpdateMethod(PrintStream out,ResultSetMetaData rsMetaData,String tableName ,String className, String primaryKey)throws Exception{
        out.print("    Public Shared Function update"+className+"(");
        String  updateValues = "";   
        for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
            String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
            String originalName = rsMetaData.getColumnName(i);
            String colVarType = CamelNotationHandler.getVariableType(originalName);

            out.print("ByVal "+colVarType+" "+type+"");
            if(i!=rsMetaData.getColumnCount()){
                out.print(", ");
            }
            if(!originalName.equals(primaryKey)){
                updateValues += originalName+" = "+"'\" & "+colVarType+" & \"'";
                if(i!=rsMetaData.getColumnCount()){
                    updateValues+= ", ";
                }
            }
            
        }    


        out.println(")As Integer\n");
        out.println("        Dim query As String  = \"UPDATE "+tableName+" SET "+updateValues+" WHERE "+primaryKey+" =\" & "+CamelNotationHandler.getVariableType(primaryKey)+"");
        out.println("       Console.WriteLine(query)");
        out.println("       Dim ROW As Integer");
        out.println("       Dim cmd As New OleDb.OleDbCommand");
        out.println("       If Not cnn.State = ConnectionState.Open Then cnn.Open()");
        out.println("       cmd.Connection = cnn");
        out.println("       cmd.CommandText = query");
        out.println("       ROW = cmd.ExecuteNonQuery()");
        out.println("       cnn.Close()");
        out.println("       Return ROW");
        out.println("      End Function");
        out.println();        
    }
}
