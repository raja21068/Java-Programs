import java.rmi.*;

public class Client{
	public static void main(String args[]){
		String server = "localhost";
		System.setSecurityManager(new RMISecurityManager());
		try{
			String location = "rmi://"+server+":1099/ActivatableImplementation";
			MyRemoteInterface mri = (MyRemoteInterface)Naming.lookup(location);
			String result = "failure";
			System.out.println("Making remote calll to the server");
			result = (String)mri.callMeRemotely();
			System.out.println("Returned from remote call");
			System.out.println("Result: "+result);
			
		}catch(Exception ex){ex.printStackTrace();}
	}
}