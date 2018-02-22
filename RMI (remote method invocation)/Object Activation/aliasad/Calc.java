import java.rmi.*;


interface Calc extends Remote{
	int add(int a, int b)throws RemoteException;
}