import java.rmi.*;
import java.rmi.server.*;

interface Box extends Remote{
	void task()throws RemoteException;	
}

class BoxImp extends UnicastRemoteObject implements java.io.Serializable , Box{
	public void task()throws RemoteException{
		System.out.println("Reached at task");
	}

}