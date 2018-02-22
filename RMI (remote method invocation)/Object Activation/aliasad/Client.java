import java.rmi.*;

public class Client {
	public static void main(String args[])throws Exception {	
		System.setSecurityManager(new RMISecurityManager());

		String location = "rmi://localhost:1099/ali";
		Calc ob = (Calc)Naming.lookup(location);

		System.out.println("Making remote call to the server");
		int num = ob.add(5, 10);
		System.out.println("Returned from remote call");
		System.out.println("Result: " + num);
	}
}