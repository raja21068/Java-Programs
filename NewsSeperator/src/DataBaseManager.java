import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataBaseManager {
	private static Connection con = null;
	private ResultSet result;
	
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
		Statement st = con.createStatement();
		try{
			ResultSet result = st.executeQuery(query);
			while(result.next()){
				CategoryBean b = new CategoryBean();
				b.setCatID(result.getInt("CatID"));
				b.setCatName(result.getString("Cat_Name"));
				v.add(b);
			} 
		}
		finally{
			
		if(st!=null)st.close();
		}
		return v;
	}
	
	public static int addCategory(String catName) throws SQLException{
		String query = "INSERT into Categories (Cat_Name)values('"+catName+"')"; 
		System.out.println(query);
		int b=0; 
		try{
		Statement st = con.createStatement();
		b = st.executeUpdate(query);
		}catch(SQLException e){e.printStackTrace(); }
		
		return b;
	}
	
	public static int removeCategory(int catID) throws SQLException{
		String query = "DELETE * from Categories where CatID = "+catID; 
		System.out.println(query);
		int b=0; 
		try{
			Statement st  = con.createStatement();
			b = st.executeUpdate(query);
		}catch(SQLException e){e.printStackTrace(); }
	
		return b;
	}
	
	public static int updateCategory( int catID, String catName) throws SQLException{
		String query = "UPDATE Categories SET Cat_Name = '"+ catName+"' where CatID = "+catID; 
		System.out.println(query);
		int b=0; 
		try{
			Statement st  = con.createStatement();
			b = st.executeUpdate(query);
		}catch(SQLException e){e.printStackTrace(); }
		return b;
	}
	
	public static int addGrams(int catID, String s)throws SQLException{
		int i=0;
		try{
			Statement st = con.createStatement();
				i = st.executeUpdate("INSERT INTO Grams(CatID, Grams) Values('" + catID + "', '"+s+"')");
		}
		catch(Exception e){}
		return i;
	}
	
	public static Vector getGramFromCategory(int CatID)throws Exception{
		String query = "SELECT Grams From Grams where CatID ="+CatID;
		System.out.println(query);
		Vector v = new Vector();
		Statement st  = con.createStatement();
		ResultSet result = st.executeQuery(query);
		while(result.next()){
			String s= result.getString("Grams");
//			System.out.println(s);
			v.addElement(s);
		}
		return v;
	}
	
	public static Vector CompareNGram(String filePath) throws Exception{
		String query = "SELECT CatID from Categories";
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		String IDs="";
		while(result.next()){
			int id = result.getInt("CatID");
			IDs+=""+id+" ";
		}
		String s[]=IDs.split(" ");
		int[] Id = new int[s.length];//having all CatID
		for(int i=0;i<s.length; i++){
			Id[i]=Integer.parseInt(s[i]);
		}
		Vector[] v =new Vector[Id.length];//having all grams of all category
		for(int i=0 ; i<Id.length; i++){
			v[i]=DataBaseManager.getGramFromCategory(Id[i]);
		}
		java.io.DataInputStream fileIn = new java.io.DataInputStream(new java.io.FileInputStream(filePath));
		String fileTxt="";
		String str="";
		while((str=fileIn.readLine())!=null){
			fileTxt+=str;
		}
		s=N_Gram.nGram(fileTxt, 3);//having all grams of file
		Vector vreturn = new Vector();
		for(int h=0 ; h<v.length; h++){
			CatMatchBean cb = new CatMatchBean();
			cb.category = getCategoryName(Id[h]);
			int match=0;
			for(int i=0;i<s.length;i++){//looping for next gram from file
				System.out.println(s[i]);
				for(int k=0;k<v[h].size();k++){
					if(s[i].contains((String)v[h].elementAt(k))){ match++;}
					System.out.println(k+" : "+v[h].elementAt(k));
				}
			}
			cb.matches = match;
			vreturn.addElement(cb);
			System.out.println(match);
		}
		
		return vreturn;
	}//end of compare gram
	
	public static String getCategoryName(int CatID)throws SQLException{
		String query="SELECT Cat_Name from Categories where CatID = "+CatID;
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		String name="";
		while(result.next()){ name = result.getString("Cat_Name"); }
		return name;
	}
}