import java.rmi.*;

public interface HelloInterface extends Remote{
  String sayHello()throws RemoteException;
}
