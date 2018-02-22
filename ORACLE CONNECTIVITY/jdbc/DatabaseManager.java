
import java.sql.*;
import java.util.*;

public class DatabaseManager {
private static Connection con;

static{
    init();
  }

public static void init(){
  try{
       Class.forName("oracle.jdbc.driver.OracleDriver");
       con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","hr");
  }catch(Exception e){
    e.printStackTrace();
  }
 }//end init()

public static void getDepartments()throws Exception{
  Statement st = null;
  ResultSet result=null;

  String query="select DEPARTMENT_ID,DEPARTMENT_NAME from DEPARTMENTS";
  System.out.println(query);
  try{
        st = con.createStatement();
        result=st.executeQuery(query);

        while(result.next()){

           String DEPT_ID=  result.getString("DEPARTMENT_ID");
           String DEPT_NAME=result.getString("DEPARTMENT_NAME").toUpperCase();
           //String REMARKS=  result.getString("REMARKS");

	   System.out.println(DEPT_ID);
	   System.out.println(DEPT_NAME);
	   //System.out.println(REMARKS);

        }//end while()
 }finally{
   if(result!=null)result.close();
   if(st!=null)st.close();
 }
}//end getDeptNames()

	public static void main(String arg[])throws Exception{

		DatabaseManager.getDepartments();
	}
}