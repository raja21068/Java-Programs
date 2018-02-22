import java.rmi.*;
import java.rmi.server.*;

interface Calc extends Remote{
	void test(Box ob)throws RemoteException;
	void test(Rectangle r)throws RemoteException;
	void test()throws RemoteException;	
}

class CalcImp implements Calc{
	public void test(Box ob)throws RemoteException{
		System.out.println("reached at one argument test");	
		//ob.task();
	}
	public void test()throws RemoteException{
		System.out.println("reached at no arg test");
	}

	public void test(Rectangle r){
		r.recTest();
	}	

}