import java.rmi.*;
import java.rmi.server.*;

class RMIServer{
	public static void main(String arg[])throws Exception{
		CalcImp ob = new CalcImp();
		UnicastRemoteObject.exportObject(ob);
		Naming.rebind("rmi://localhost:1099/ali",ob);
		System.out.println("RMI server is started...");
	}

}