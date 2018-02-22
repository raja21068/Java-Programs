import java.sql.*;
import java.util.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.*;
/**
 * @author Jay Kumar
 */
public class DatabaseManager extends UnicastRemoteObject implements DatabaseManagerInterface{
   public  Connection connection;
    DatabaseManager()throws RemoteException{
	super();
   	try{
     		// Class.forName("sun.odbc.jdbc.JdbcOdbcDriver");
   	}catch(Exception e){e.printStackTrace();}
   	try{
   		connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=UniOfSindh.mdb");
   	}catch(Exception e){e.printStackTrace();}
   }
    public  Vector getAllFaculty()throws RemoteException,Exception{
        Vector vec= new Vector();
        ArrayList array = new ArrayList();
        String query = "SELECT * from Faculty";
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            FacultyBean fb = new FacultyBean();
            fb.factID = result.getInt("Fact_ID");
            fb.factName = result.getString("Fact_Name");
            fb.remarks = result.getString("Remarks");
            
            vec.addElement(fb);
        }
        st.close();

        return vec;
    }
    
    public  int updateFaculty(String facName, String remarks , int id)throws RemoteException,Exception{
        String query = "UPDATE Faculty SET Fact_Name = '"+facName+"' , Remarks = '"+remarks+"'  where Fact_ID ="+id;
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//      connection.close();
        return i;
    }
    public  int deleteFaculty(int id)throws RemoteException,Exception{
        String query = "DELETE from Faculty where Fact_ID = "+id;
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
        return i;
    }
    public  int addFaculty(FacultyBean bean)throws RemoteException,Exception{
        String query = "INSERT into Faculty (Fact_Name , Remarks) values ('"+bean.factName+" ' , '"+bean.remarks+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
        return i;
    }
    
     public  Vector getAllDept(int facID)throws RemoteException,Exception{
        Vector vec= new Vector();
        String query = "SELECT * from Department where Fact_ID = "+facID;
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            DepartmentBean db = new DepartmentBean();
            db.setfacultyID(result.getInt("Fact_ID")); 
            db.setDeptID(result.getInt("Dept_ID"));
            db.setDeptName(result.getString("Dept_Name"));
            db.setRemarks(result.getString("Remarks"));
            vec.addElement(db);
        }
       st.close();
//       connection.close();
        return vec;
    }
    
    public  void addDepartment(DepartmentBean dBean)throws RemoteException,Exception{
        String query = "INSERT into Department (Fact_ID , Dept_Name , Remarks ) "
                + "values('"+dBean.getFacultyID()+"' , '"+dBean.getDeptName()+"' , '"+dBean.getRemarks()+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    
    public  void deleteDepartment(String depName)throws RemoteException,Exception{
        String query = "DELETE from Department where Dept_Name = '"+depName+"'";
        System.out.println(query);
        Statement st = connection.createStatement();
        int  i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
     
    public  void updateDepartment(DepartmentBean dBean)throws RemoteException,Exception{
        String query = "UPDATE Department SET  Fact_ID = '"+dBean.getFacultyID()+"' , Dept_Name = '"+dBean.getDeptName()+"' , Remarks = '"+dBean.getRemarks()+"' where Dept_ID = "+dBean.getDeptID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
            
    public  Vector getAllProgram(int dep_ID)throws RemoteException,Exception{
        Vector vec= new Vector();
        String query = "SELECT * from Program where Dept_ID = "+dep_ID;
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            ProgramBean pb = new ProgramBean();
            pb.setDeptID(result.getInt("Dept_ID"));
            pb.setProgID(result.getInt("Prog_ID"));
            pb.setProgName(result.getString("Prog_Name"));
            pb.setDuration(result.getInt("Duration"));
            pb.setRemarks(result.getString("Remarks"));
            vec.addElement(pb);
        }
        st.close();
//        connection.close();
        return vec;
    }
    
    public  void addProgram(ProgramBean progBean)throws RemoteException,Exception{
        String query = "INSERT into Program (Dept_ID , Prog_Name , Duration , Remarks) values "
                + "('"+progBean.getDeptID()+"' , '"+progBean.getProgName() +"' , '"+progBean.getDuration()+"' , '"+progBean.getRemarks()+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void deleteProgram(ProgramBean progBean)throws RemoteException,Exception{
        String query ="DELETE from Program where Prog_ID = "+progBean.getProgID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void updateProgram(ProgramBean progBean)throws RemoteException,Exception{
        String query = "UPDATE Program SET Dept_ID = '"+progBean.getDeptID()+"' , Prog_Name = '"+progBean.getProgName()
            +"' , Duration = '"+progBean.getDuration()+"' , Remarks = '"+progBean.getRemarks()+"' where Prog_ID = "+progBean.getProgID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  Vector getAllBatches(int prog_Id)throws RemoteException,Exception{
        String query = "SELECT * from Batch where Prog_ID = "+prog_Id ;
        System.out.println(query);
        Vector v = new Vector();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        while(result.next()){
            BatchBean batBean = new BatchBean();
            batBean.setProgId(result.getInt("Prog_ID"));
            batBean.setBatId(result.getInt("Batch_ID"));
            batBean.setBatYear(result.getInt("Batch_year"));
            batBean.setShift(result.getString("Shift"));
            batBean.setGroup(result.getString("Group"));
            batBean.setRemarks(result.getString("Remarks"));
            v.addElement(batBean);
        }
        st.close();
//        connection.close();
        return v;
    }
    
    public  void addBatch(BatchBean batBean)throws RemoteException,Exception{
        String query = "INSERT INTO Batch ( Prog_ID, Batch_year, Shift, [Group], Remarks )  values"
                + " ("+batBean.getProgID()+" , "+batBean.getBatYear()+" , '"+batBean.getShift()+"' , "
                + "'"+batBean.getGroup()+"' ,'"+batBean.getRemarks()+"' )";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void deleteBatch(BatchBean batBean)throws RemoteException,Exception{
        String query = "DELETE from Batch where Batch_ID = "+batBean.getBatID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void updateBatch(BatchBean batBean)throws RemoteException,Exception{
        String query = "UPDATE Batch SET Prog_ID= "+batBean.getProgID()+" , Batch_year= "+batBean.getBatYear() +" , "
                + "Shift='"+batBean.getShift()+"' , [Group] ='"+batBean.getGroup()+"' , Remarks='"+batBean.getRemarks()+"' where Batch_ID = "+batBean.getBatID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    
    public  Vector getAllStudents(int batId)throws RemoteException,Exception{
        String query = "SELECT * from Student where Batch_ID = "+batId;
        System.out.println(query);
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        Vector vec = new Vector();
        while(result.next()){
            StudentBean stdBean = new StudentBean();
           
            stdBean.setBatchId(result.getInt("Batch_ID"));
            stdBean.setStudentId(result.getInt("Std_ID"));
            stdBean.setStudentName(result.getString("Std_Name"));
            stdBean.setFName(result.getString("FName"));
            stdBean.setSurname(result.getString("Surname"));
            stdBean.setCNIC(result.getString("CNIC"));
            stdBean.setRollNo(result.getString("Roll_No"));
            stdBean.setGroup(result.getString("Group"));
            stdBean.setShift(result.getString("Shift"));
            stdBean.setAddress(result.getString("Address"));
            stdBean.setRemarks(result.getString("Remarks"));
            
            vec.addElement(stdBean);
        }
        st.close();
//        connection.close();
        return vec;
    }
    public  void addStudent(StudentBean bean)throws RemoteException,Exception{
        String query = "INSERT INTO Student (Batch_ID , Std_Name , FName , Surname , CNIC , Roll_No , [Group], Shift , Address , Remarks)"
                + " values ( "+bean.getBatchId()+" , '"+bean.getStudentName()+"' , '"+bean.getFName()+"' , '"+bean.getSurname()
                +"' , '"+bean.getCNIC()+"' ,'"+bean.getRollNo()+"' , '"+bean.getGroup()+"' ,'"+bean.getShift()+"' , '"+bean.getAddress()+"' , '"+bean.getRemarks()+"') ";
        
        System.out.println(query);
        Statement st = connection.createStatement();
        int i =st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void deleteStudent(StudentBean bean)throws RemoteException,Exception{
        String query = "DELETE from Student where Std_ID = "+bean.getStudentID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void updateStudent(StudentBean bean)throws RemoteException,Exception{
        String query = "UPDATE Student SET Batch_ID = "+bean.getBatchId()+", Std_Name = '"+bean.getStudentName()+"', FName = '"+bean.getFName()+"', Surname = '"+bean.getSurname()+"', CNIC = '"+bean.getCNIC()+"' , Roll_No = '"+bean.getRollNo()+"' , "
                + "[Group] ='"+bean.getGroup()+"', Shift='"+bean.getShift()+"' , Address='"+bean.getAddress()+"' , Remarks='"+bean.getRemarks()+"' where  Std_ID = "+bean.getStudentID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public  void connectionClose()throws RemoteException,Exception{
        connection.close();
    }

    
}
