
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Jay Kumar
 */
public class XMLGenerator {
    static Connection connection;
    public static void DBToXml(String driver,String url , String username,String password , File destination , String format,JLabel status)throws Exception{
        Class.forName(driver);
        Connection connection= java.sql.DriverManager.getConnection(url,username,password);
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, null, null, new String[]{"TABLE"});
        while(result.next()){
            String tableName=result.getString(3);        
            ArrayList columns = getColumnName(connection, tableName);
            File xmlFile = new File(destination.getAbsolutePath()+File.separator+tableName+"."+format);
            xmlFile.createNewFile();
            
            //setting status 
            status.setText(xmlFile.getName());
            
            handleXML(connection,xmlFile ,columns , tableName);
            
        }
    }
    
    public static ArrayList<String> getColumnName(Connection conn , String tableName)throws Exception{
        String query ="SELECT * from "+tableName;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(query);
        ResultSetMetaData md = result.getMetaData();
        ArrayList<String> list = new ArrayList();
        for(int i=1;i<=md.getColumnCount();i++){
            list.add(md.getColumnName(i));
        }
        return list;
    }
        
    private static void handleXML(Connection con ,File xmlFile , ArrayList<String> columns , String tableName)throws Exception{       
        PrintStream fos = new PrintStream(new FileOutputStream(xmlFile));
        fos.println("<xml>");
        String query = "SELECT * from "+tableName;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            fos.println("<"+tableName+">");
            for(int i=0;i<columns.size();i++){
                fos.print("         <"+columns.get(i)+">");
                fos.print(rs.getString(columns.get(i)));
                fos.println("</"+columns.get(i)+">");
            }
            fos.println("</"+tableName+">");
        }
        fos.println("</xml>");
        
    }
    
}
