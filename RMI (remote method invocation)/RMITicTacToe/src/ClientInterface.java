import java.rmi.*;
public interface ClientInterface extends Remote{
      public void setClientButton(String s , int buttonNo)throws RemoteException;
      public void winMessage(String s)throws RemoteException;
}
