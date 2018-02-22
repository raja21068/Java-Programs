import java.sql.*;
import java.util.Vector;
public class DBManager {
	private static Connection con = null;
	
	static{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("Jdbc:Odbc:IP_Data");
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
}
