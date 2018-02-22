
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface Calcu extends Remote{
    int add(int a, int b)throws RemoteException;
    int mul(int a, int b)throws RemoteException;
}
class CalcuImp extends UnicastRemoteObject implements Calcu{
    CalcuImp()throws RemoteException{
        System.out.println("RMI server started...");
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a*b;
    }

}
public class RMIServer2 {
  public static void main(String arg[])throws Exception{
      CalcImp ob = new CalcImp();
      Naming.rebind("ali", ob);
  }
}
