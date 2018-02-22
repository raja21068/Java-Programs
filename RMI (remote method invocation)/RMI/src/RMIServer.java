import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

interface Calc extends Remote{
    int add(int a , int b)throws RemoteException;
    int mul(int a , int b)throws RemoteException;
}

class CalcImp implements Calc{

    @Override
    public int add(int a, int b) throws RemoteException {
        int c = a+b;
        return c;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        int c = a+b;
        return c;
    }

}

public class RMIServer {
    public static void main(String arg[])throws Exception{
        CalcImp ob = new CalcImp();
        UnicastRemoteObject.exportObject(ob);
        Naming.bind("ali", ob);
        System.out.println("Rmi server started..");
    }
}
