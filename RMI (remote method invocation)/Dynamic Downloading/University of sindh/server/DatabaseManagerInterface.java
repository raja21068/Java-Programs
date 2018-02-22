import java.util.*;
import java.rmi.*;
public interface DatabaseManagerInterface extends Remote{
	public Vector getAllFaculty()throws RemoteException,Exception;
	public  int updateFaculty(String facName, String remarks , int id)throws RemoteException,Exception;
	public  int deleteFaculty(int id)throws RemoteException,Exception;
	public  int addFaculty(FacultyBean bean)throws RemoteException,Exception;
	public Vector getAllDept(int facID)throws RemoteException,Exception;
	public  void addDepartment(DepartmentBean dBean)throws RemoteException,Exception;
	public  void deleteDepartment(String depName)throws RemoteException,Exception;
	public  void updateDepartment(DepartmentBean dBean)throws RemoteException,Exception;
	public Vector getAllProgram(int dep_ID)throws RemoteException,Exception;
	public  void addProgram(ProgramBean progBean)throws RemoteException,Exception;
	public  void deleteProgram(ProgramBean progBean)throws RemoteException,Exception;
	public  void updateProgram(ProgramBean progBean)throws RemoteException,Exception;
	public Vector getAllBatches(int prog_Id)throws RemoteException,Exception;
	public  void addBatch(BatchBean batBean)throws RemoteException,Exception;
	public  void deleteBatch(BatchBean batBean)throws RemoteException,Exception;
	public  void updateBatch(BatchBean batBean)throws RemoteException,Exception;
	public Vector getAllStudents(int batId)throws RemoteException,Exception;
	public  void addStudent(StudentBean bean)throws RemoteException,Exception;
	public  void deleteStudent(StudentBean bean)throws RemoteException,Exception;
	public  void updateStudent(StudentBean bean)throws RemoteException,Exception;
	public  void connectionClose()throws RemoteException,Exception;

}
