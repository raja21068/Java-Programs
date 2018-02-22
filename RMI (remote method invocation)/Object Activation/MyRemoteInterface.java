import java.rmi.*;

public interface MyRemoteInterface extends Remote{
	public Object callMeRemotely()throws RemoteException;

}