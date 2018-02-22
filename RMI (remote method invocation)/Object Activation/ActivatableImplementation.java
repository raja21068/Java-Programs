import java.rmi.*;
import java.rmi.activation.*;

public class ActivatableImplementation extends Activatable implements MyRemoteInterface{
	public ActivatableImplementation(ActivationID id  , MarshalledObject data)throws RemoteException{
		super(id,0);

}
	public Object callMeRemotely()throws RemoteException{
		return "Success";
	}
}