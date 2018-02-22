
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
public class DatabaseHandler {
    
    static Connection connection;
    public static void DBToXml(String dbPath , File destination , String format)throws Exception{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection connection= java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, null, null, new String[]{"TABLE"});
        while(result.next()){
            String tableName=result.getString(3);        
            ArrayList columns = getColumnName(connection, tableName);
            File xmlFile = new File(destination.getAbsolutePath()+File.separator+tableName+"."+format);
            xmlFile.createNewFile();
            if(format.equals("xml")){
                handleXML(connection,xmlFile ,columns , tableName);
            }else if(format.equals("csv")){
                csvHandler(connection,xmlFile,columns,tableName);
            }
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
    
    public static void handleXML(Connection con ,File xmlFile , ArrayList<String> columns , String tableName)throws Exception{       
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
    
    public static ArrayList<String> getTableName(String dbPath)throws Exception{
        ArrayList<String> names = new ArrayList();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection connection= java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet result = meta.getTables(null, null, null, new String[]{"TABLE"});
        while(result.next()){
            names.add(result.getString(3));
        }
        return names;
    }

    private static void csvHandler(Connection con, File xmlFile, ArrayList<String> columns, String tableName)throws Exception {
        PrintStream fos = new PrintStream(new FileOutputStream(xmlFile));
        
        String query = "SELECT * from "+tableName;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        for(int i=0;i<columns.size()-1;i++){
                fos.print(columns.get(i)+",");
        }
        fos.println(columns.get(columns.size()-1));
        
        while(rs.next()){
           for(int i=0;i<columns.size()-1;i++){
                fos.print(rs.getString(columns.get(i))+",");
           }
           fos.println(rs.getString(columns.get(columns.size()-1)));
        }
        st.close();
    }
    
    public static void loadInDatabase(String dbPath ,String query)throws Exception{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection= java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        Statement st = connection.createStatement();
        System.out.println(query);
        st.executeUpdate(query);
        st.close();
    }
}
