
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Jay K
 */
public class DatabaseManager {

    public static Connection getConnect()throws Exception{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        return DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=hide.mdb");
    }
    
    public static Vector getFiles()throws Exception{
        String query = "SELECT * from files";
        System.out.println(query);
        Connection con = getConnect();
        Statement st = con.createStatement();
        ResultSet set = st.executeQuery(query);
        Vector v = new Vector();
        while(set.next()){
            v.addElement(set.getString("file_path"));
        }
        
        con.close();
        return v;
        
    }
    
    public static void deletePath(String s)throws Exception{
        String query = "DELETE from files WHERE file_path='"+s+"'";
        System.out.println(query);
        Connection con = getConnect();
        System.out.println("Connection : "+con);
        Statement st = con.createStatement();
        System.out.println("Statement : "+st);
        st.executeUpdate(query);
        
        con.close();
    }
    
    public static void add(String s)throws Exception{
        String query = "INSERT INTO files (file_path) values ('"+s+"')";
        System.out.println(query);
        Connection con = getConnect();
        System.out.println("Connection : "+con);
        Statement st = con.createStatement();
        System.out.println("Statement : "+st);
        st.executeUpdate(query);
       
        con.close();
    }
    
    public static User getUser(String username, String password)throws Exception{
        String query = "SELECT * from user WHERE username ='"+username+"' AND password = '"+password+"' ";
        System.out.println(query);
        
        Connection con = getConnect();
        System.out.println("Connection : "+con);
        
        Statement st = con.createStatement();
        System.out.println("Statement : "+st);
        
        ResultSet set = st.executeQuery(query);
        User bean  = null;
        if(set.next()){
            bean = new User();
            bean.setId(set.getInt("ID"));
            bean.setUserName(username);
        }
        return bean;
    }
}
