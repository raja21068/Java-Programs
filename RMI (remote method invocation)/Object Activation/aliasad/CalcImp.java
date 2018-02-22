import java.rmi.*;
import java.rmi.activation.*;

public class CalcImp extends Activatable implements Calc{
	public CalcImp(ActivationID id, MarshalledObject data)throws RemoteException{
		super(id, 0);
	}

	public int add(int a, int b)throws RemoteException{
		return a+b;
	}
}