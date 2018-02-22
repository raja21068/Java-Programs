import java.rmi.*;
import java.rmi.server.*;

interface Calc extends Remote{
	int add(Box ob)throws RemoteException;
	int mul(Box ob)throws RemoteException;
}

class CalcImp implements Calc{
	public int add(Box ob)throws RemoteException{
		int result = ob.add();
		return result;
	}
	public int mul(Box ob)throws RemoteException{
		int result = ob.mul();
		return result;
	}

}

class RMIServer{
	public static void main(String arg[])throws Exception{
		CalcImp ob = new CalcImp();
		UnicastRemoteObject.exportObject(ob);
		Naming.rebind("ali",ob);
		System.out.println("RMI server is started...");
	}

}