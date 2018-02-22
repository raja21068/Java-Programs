import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataBaseManager {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet result;
	static{
		try {
			initDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void initDriver()throws Exception{
		//Class.forName("sun.odbc.jdbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("Jdbc:Odbc:NewsPaper");
	}
	public static Vector getCategories()throws SQLException{
		String query = "SELECT CatID ,Cat_Name from Categories";
		System.out.println(query);
		Vector v = new Vector();
		st = con.createStatement();
		try{
			result = st.executeQuery(query);
			while(result.next()){
				CategoryBean b = new CategoryBean();
				b.setCatID(result.getInt("CatID"));
				b.setCatName(result.getString("Cat_Name"));
				v.add(b);
			} 
		}
		finally{
		if(result!=null)result.close();
		if(st!=null)st.close();
		}
		return v;
	}
	
	public static int addCategory(String catName) throws SQLException{
		String query = "INSERT into Categories (Cat_Name)values('"+catName+"')"; 
		System.out.println(query);
		st = null;
		int b=0; 
		try{
		st = con.createStatement();
		b = st.executeUpdate(query);
		}catch(SQLException e){e.printStackTrace(); }
		finally{ st.close(); }
		return b;
	}
}
