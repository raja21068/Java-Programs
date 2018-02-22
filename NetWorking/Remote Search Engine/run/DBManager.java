

/**
 *
 * @author jay
 */
import java.sql.*;
import java.util.Vector;
public class DBManager {
	private static Connection con = null;
	
	static{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=IP_Data.mdb");
		}catch(Exception e){ e.printStackTrace();}
	}
	public static  void addIP(String IP)throws Exception{
		String query = "INSERT into IPs (IP_Address) values ('"+IP+"')";
		System.out.println(query);
		Statement st = con.createStatement();
		int r = st.executeUpdate(query);
	}
	public static Vector getAllIps()throws Exception{
		String query = "SELECT IP_Address from IPs";
		System.out.println(query);
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		Vector vector =new Vector(); 
		while(result.next()){
			vector.addElement(result.getString("IP_Address"));
		}
		return vector;
	}
	public static void deleteIp(String IP)throws Exception{
		String query ="DELETE from IPs where IP_Address = '"+IP+"'";
		System.out.println(query);
		Statement st = con.createStatement();
		int r = st.executeUpdate(query);
	}
        public static void addFile(String filePath)throws Exception{
            String query = "INSERT into SharedFiles (Shared_Files) values ('"+filePath+"')";
            System.out.println(query);
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        public static void deleteFile(String filePath)throws Exception{
            String query = "DELETE from SharedFiles where Shared_Files  = '"+filePath+"' ";
            System.out.println(query);
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        public static Vector getAllFiles()throws Exception{
            String query = "SELECT * from SharedFiles";
            Vector vector = new Vector();
            Statement st = con.createStatement();
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                vector.addElement(result.getString("Shared_Files"));
            }
            return vector;
        }
        
}
