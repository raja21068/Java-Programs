
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JLabel;

/**
 *
 * @author Raja Kumar
 */
public class VisualBasicGUIGenerator {
    
    public static void createGUI(String driver,String url,String username,String password ,String desPath,JLabel status)throws Exception{
        Class.forName(driver);    
        Connection connection= java.sql.DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        while(rs.next()){
            String tableName = rs.getString(3);
            String className = CamelNotationHandler.getTableType(tableName);

            //setting status 
            status.setText(className); 
            
            PrintStream out = new PrintStream( new FileOutputStream(desPath+File.separator+className+"Form.vb"));

            Statement st = connection.createStatement();
            ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
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
            
            String variables = "";
            String clearVariables = "";
            String listVariables = "";
            out.println("Private Sub AddButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AddButton.Click");
            out.println("    Try");
            out.print("        Dim rows As Integer = DataBaseManager.add" +className+"(");
            
            for(int i=1;i<=rsMetaData.getColumnCount();i++){ 
                String type = TypeHandler.getVbType(rsMetaData.getColumnTypeName(i));
                String originalName = rsMetaData.getColumnName(i);
                String var = CamelNotationHandler.getVariableType(originalName);
                
                variables += var+"TextBox.Text";
                clearVariables += var+"TextBox.Text= \"\" \n";
                listVariables += "    "+var+"TextBox.Text= bean.get"+CamelNotationHandler.firstLetterCapital(var) +"() \n";
             
                if(i!=rsMetaData.getColumnCount()){
                    variables+= (", ");
                }
            }
            out.println(variables+")");
            out.println("        If rows >= 1 Then");
            out.println("            MsgBox(\" record saved......\")");
            out.println("            get"+className+"()");    
            out.println("            clearAll()");
            out.println("        End If");
            out.println("    Catch ex As Exception");
            out.println("        MsgBox(ex.StackTrace)");
            out.println("    End Try");
            out.println("End Sub");
            out.println("");
            
            
           out.println("Private Sub DeleteButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DeleteButton.Click");
           out.println("    Try");
           out.println("        Dim rec As "+className+"Bean = "+className+"ListBox.SelectedItem");
           out.println("        Dim rows As Integer = DataBaseManager.delete"+className+"(rec.get"+CamelNotationHandler.getTableType(primaryKey) +"())");
           out.println("        If rows >= 1 Then");
           out.println("            MsgBox(\" Record Removed......\")");
           out.println("            get"+className+"()");    
           out.println("            clearAll()");
           out.println("        End If");
           out.println("    Catch ex As Exception");
           out.println("        MsgBox(ex.StackTrace)");
           out.println("    End Try");
           out.println("End Sub");
   
            out.println("Private Sub UpdateButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles UpdateButton.Click");
            out.println("    Try");
            out.println("        Dim rec As "+className+"Bean = "+className+"ListBox.SelectedItem");
            out.println("        Dim rows As Integer = DataBaseManager.update"+className+"("+variables+")");
            out.println("        If rows >= 1 Then");
            out.println("            MsgBox(\" Record Upadate......\")");
            out.println("            get"+className+"()");    
            out.println("            clearAll()");
            out.println("        End If");
            out.println("     Catch ex As Exception");
            out.println("         MsgBox(ex.StackTrace)");
            out.println("     End Try");
            out.println("End Sub");
            out.println("");
            
            out.println("Private Sub ClearButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ClearButton.Click");
            out.println("    ClearAll()");
            out.println("End Sub");
            out.println("");
            
            out.println("Private Sub clearAll()");
            out.println(clearVariables);
            out.println("End Sub");
            out.println("");
        
            out.println("Public Sub get"+className+"()");
            out.println("    Dim v As ArrayList = DataBaseManager.getAll"+className+"()");
            out.println("    "+className+"ListBox.Items.Clear()");
            out.println("    Dim size As Integer = v.Count");
            out.println("    Dim index As Integer");
            out.println("    For index = 0 To size - 1");
            out.println("        "+className+"ListBox.Items.Add(v.Item(index))");
            out.println("    Next");
            out.println("End Sub");
            out.println("");
            
            out.println("Private Sub "+className+"ListBox_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles "+className+"ListBox.SelectedIndexChanged");
            out.println("    Dim bean As "+className+"Bean = "+className+"ListBox.SelectedItem");
            out.println("    If IsNothing(bean) Then Exit Sub");
            out.println(listVariables);
            out.println("End Sub");
        
            
            out.close();
        
        }
        connection.close();
    }

}
/*
        
        
    }
 
 
 */