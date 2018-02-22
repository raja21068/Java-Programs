import java.sql.*;
import java.io.*;

public class DatabaseManagerServlet{
	private static String dbPath="";
	private static Connection con=null; 

		public static void connect(){
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con = DriverManager.getConnection("jdbc:odbc:data");
			 con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\Tomcat6.0\\webapps\\ROOT\\WEB-INF\\data.mdb");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
                        System.out.println("DatabasePath: "+dbPath);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

//                        con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
			System.out.println("Connection : "+con);
			}catch(Exception ex){
                            System.out.println("Connection : Failed with data");
			}
		}
		public static void setDBPath(String path , PrintWriter out){
			dbPath= path;
			out.println(path+"<br />");
			int index = path.indexOf("\\");
//                        while(index != -1){
//                            
//                        }
			//dbPath= path.replaceAll("\\","\\\\");
			out.println("index : "+index);
		}
		public static int addRecord(PrintWriter out , String name , String fname, String surname, String roll , String cell)throws Exception{
			connect();
			String sql = "insert into student (name , father_name , surname , roll_no , cell_no) values ('"+name+"', '"+fname+"', '"+surname+"', '"+roll+"', '"+cell+"')";
			out.println(sql);
			Statement st = con.createStatement();
			out.println("Statement created...");
			int i = st.executeUpdate(sql);
			out.println("Query Excuted..");
			return i;
		}
		public static int deleteRecord(PrintWriter out , int id)throws Exception{
			connect();
			String sql="delete from student where id="+id;
			out.println(sql);
			Statement st = con.createStatement();
			out.println("Statement created...");
			int i = st.executeUpdate(sql);
			out.println("Query Excuted..");
			return i;
		}
		public static java.util.ArrayList getRecords()throws Exception{
			connect();
			java.util.ArrayList list = new java.util.ArrayList();
			
			String sql = "select * from student";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				RecordBean bean = new RecordBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setFatherName(rs.getString("father_name"));
				bean.setSurname(rs.getString("surname"));
				bean.setRollNo(rs.getString("roll_no"));
				bean.setCellNo(rs.getString("cell_no"));
				list.add(bean);
			}
			return list;
		}
}
