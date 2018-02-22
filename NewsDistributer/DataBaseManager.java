import java.sql.*;
import java.util.Vector;

class DataBaseManager
{
	private static Connection con;
	
	// ======================= INSERTION ============================ //
	
	static int insertCategory(String catName)throws Exception
	{
		connect();
		int i=0;
			Statement st = con.createStatement();
			i = st.executeUpdate("INSERT INTO Categories(Cat_Name) Values('"+catName+"')");
			st.close();
		disconnect();
		return i;
	}
	
	static int insertGrams(int catID, String gram)throws Exception
	{
		connect();
		int i = 0;
			Statement st = con.createStatement();
			i = st.executeUpdate("INSERT INTO Grams(Cat_ID,Gram) Values('"+catID+"', '"+gram+"')");
			st.close();
		disconnect();
		return i;
	}
	
	// ====================== DELETION ===========================//
	
	static int deleteCategory(int catID)throws Exception
	{
		connect();
		int i=0;
			Statement st = con.createStatement();
			i = st.executeUpdate("DELETE FROM Categories WHERE Cat_ID="+catID);
			st.close();
		disconnect();
		return i;
	}
	
	// ====================== UPDATE =========================== //
	
	static int updateCategory(int catID, String catName)throws Exception
	{
		connect();
		int i=0;
			Statement st = con.createStatement();
			i = st.executeUpdate("UPDATE Categories SET Cat_Name='"+catName+"' WHERE Cat_ID="+catID);
			st.close();
		disconnect();
		return i;
	}
	
	// ====================== GET CATEGORY / GRAMS ====================//
	
	static Vector getCategory()throws Exception
	{
		connect();
		Vector v = new Vector();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Categories");
			while(rs.next()){
				CategoryBean bean = new CategoryBean();
				bean.setCatID(rs.getInt("Cat_ID"));
				bean.setCatName(rs.getString("Cat_Name"));
				v.addElement(bean);
			}
			rs.close();
			st.close();
		disconnect();
		return v;
	}
	
	static Vector getGrams(int catID)throws Exception
	{
		connect();
		Vector v = new Vector();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Gram FROM Grams WHERE Cat_ID="+catID);
			while(rs.next()){
				GramBean bean = new GramBean();
				bean.setGramID(rs.getInt("Gram_ID"));
				bean.setGram(rs.getString("Gram"));
				v.addElement(bean);
			}
			rs.close();
			st.close();
		disconnect();
		return v;
	}
	
	// ====================== CONNECT ======================== //
	private static void connect()throws Exception
	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Ngrams");
	}
	
	
	// ====================DISCONNECT ======================= //
	private static void disconnect()throws Exception
	{
			con.close();
	}
}
