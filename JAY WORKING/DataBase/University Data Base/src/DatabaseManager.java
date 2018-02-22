import java.sql.*;
import java.util.*;
/**
 * @author Jay Kumar
 */
public class DatabaseManager {
   static Connection con;
    static {
   try{
     // Class.forName("sun.odbc.jdbc.JdbcOdbcDriver");
   }catch(Exception e){e.printStackTrace();}
   try{
   con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=UniOfSindh.mdb");
   }catch(Exception e){e.printStackTrace();}
   } 
    public static Vector getAllFaculty()throws Exception{
        Vector vec= new Vector();
        String query = "SELECT * from Faculty";
        Statement st =con.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            FacultyBean fb = new FacultyBean();
            fb.factID = result.getInt("Fact_ID");
            fb.factName = result.getString("Fact_Name");
            fb.remarks = result.getString("Remarks");
            vec.addElement(fb);
        }
        return vec;
    }
    public static Vector getAllDept()throws Exception{
    Vector vec= new Vector();
        String query = "SELECT * from Department";
       
        Statement st =con.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            DepartmentBean db = new DepartmentBean();
            db.deptID = result.getInt("Dept_ID");
            db.deptName = result.getString("Dept_Name");
            db.remarks = result.getString("Remarks");
            vec.addElement(db);
        }
       
        return vec;
    } 
    public static Vector getAllProgram()throws Exception{
    Vector vec= new Vector();
        String query = "SELECT * from Program";
        Statement st =con.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            ProgramBean pb = new ProgramBean();
            pb.progID = result.getInt("Prog_ID");
            pb.progName = result.getString("Prog_Name");
            pb.duration = result.getString("Duration");
            pb.remarks = result.getString("Remarks");
            vec.addElement(pb);
        }
        
        return vec;
    }
    public static int updateFaculty(String facName, String remarks , int id)throws Exception{
        String query = "UPDATE Faculty SET Fact_Name = '"+facName+"' , Remarks = '"+remarks+"'  where Fact_ID ="+id;
        Statement st = con.createStatement();
        int i = st.executeUpdate(query);
        return i;
    }
    public static int deleteFaculty(int id)throws Exception{
        String query = "DELETE from Faculty where Fact_ID = "+id;
        Statement st = con.createStatement();
        int i = st.executeUpdate(query);
        return i;
    }
    public static int addFaculty(FacultyBean bean)throws Exception{
        String query = "INSERT into Faculty (Fact_Name , Remarks) values ('"+bean.factName+" ' , '"+bean.remarks+"')";
        Statement st = con.createStatement();
        int i = st.executeUpdate(query);
        return i;
    }
    public static void addDepartment(DepartmentBean dBean){
        String query = "";
    }
}
