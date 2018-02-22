import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

interface DatabaseManager extends Remote{

    int add(String n, String  s, String r)throws RemoteException,SQLException;
    
    int delete(String name)throws RemoteException,SQLException;
    
    public ArrayList getAllData()throws RemoteException , SQLException;
}
class DatabaseImp implements DatabaseManager{
    
    Connection con ;
    
    DatabaseImp(){
        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        System.out.println("driver loaded..");
        try{
		con = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=biodata.mdb");
        	System.out.println("connection stablished with database");
	}catch(Exception ex){JOptionPane.showMessageDialog(null,"Exception in connection...");}
    }
    @Override
    public int add(String n, String s, String r) throws RemoteException, SQLException {
        String sql = "Insert into biodata ( std_name ,subject ,rollNo )"
                + " values ('"+n+"','"+s+"','"+r+" ')";
        System.out.println(sql);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(sql);
        st.close();
        return rows;
    }
   public ArrayList getAllData()throws RemoteException , SQLException{
	
	String sql = "SELECT * from biodata";
	System.out.println(sql);
	Statement st = con.createStatement();
	ArrayList dataList = new ArrayList();
	ResultSet set = st.executeQuery(sql);
        while(set.next()){
            BiodataBean bean = new BiodataBean();
            bean.setStudentName(set.getString("std_name"));
            bean.setSubject(set.getString("subject"));
            bean.setRollNo(set.getString("rollNo"));
            dataList.add(bean);
        }
	return dataList;
   }

    @Override
    public int delete(String name) throws RemoteException, SQLException {
        String sql ="Delete from biodata where std_name = '"+name+"'";
        System.out.println(sql);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(sql);
        st.close();
        return rows;
    }

}

public class RMIServer {
    public static void main(String arg[])throws Exception{
        DatabaseImp ob = new DatabaseImp();
        UnicastRemoteObject .exportObject(ob);
        System.out.println("Object exported..");
	Naming .rebind("rmi://localhost:1099/ali", ob);
        System.out.println("Rmi server is started...");
    }
}
