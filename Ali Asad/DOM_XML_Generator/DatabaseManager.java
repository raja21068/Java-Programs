
import java.sql.*;
import java.sql.DriverManager;
import java.util.Vector;

public class DatabaseManager {
    private Connection con;
    private DatabaseMetaData metaData;
    DatabaseManager(String filePath){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("Jdbc:Odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+filePath);
            metaData = con.getMetaData();
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    public void disconnect()throws Exception{
        con.close();
    }
    
    public Vector<String> getTables()throws Exception{
        Vector<String> v = new Vector();
        ResultSet rs = metaData.getTables(null, null, null, new String[]{"TABLE"});
        while(rs.next()){
            String tableName = rs.getString("TABLE_NAME");
            v.addElement(tableName);
        }
        rs.close();
        return v;
    }
    
    public Vector<String> getColumns(String tableName)throws Exception{
        String query = "SELECT * FROM "+tableName;
        System.out.println("Query : " + query);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        Vector<String> v = new Vector();
        
        for(int k=1 ; k<=rsmd.getColumnCount() ; k++){
            String s = rsmd.getColumnName(k);
            v.addElement(s);
        }
        
        rs.close();
        st.close();
        
        return v;
    }
    
    public Vector<String> getData(String tableName, int totalColumns)throws Exception{
        String query = "SELECT * FROM "+tableName;
        System.out.println("Query: " + query);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        Vector<String> v = new Vector();
        while(rs.next()){
            StringBuffer buffer = new StringBuffer();
            for(int k=1 ; k<=totalColumns ; k++){
                String data = rs.getString(k);
                if(data==null || data.isEmpty())
                    data = " ";
                buffer.append(data);
                if(k<totalColumns)
                    buffer.append(",");
            }
            System.out.println(buffer);
            v.addElement(buffer.toString());
        }
        rs.close();
        st.close();
        return v;
    }
}
