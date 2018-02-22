import java.rmi.*;
interface TicTacInterface extends Remote{
      public void setButton(String s , int button)throws RemoteException;
      public void winMessage(String s)throws RemoteException;
}

