import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;

public class Setup{
	public static void main(String args[])throws Exception{
		System.setSecurityManager(new RMISecurityManager());
		System.out.println("1");

		Properties props = new Properties();
		props.put("java.security.policy","Sachal.policy");
		System.out.println("2");

		ActivationGroupDesc.CommandEnvironment ace = null;
		System.out.println("2A");
		ActivationGroupDesc exampleGroup = new ActivationGroupDesc(props , ace);		
		System.out.println("2B");
		ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(exampleGroup);
		System.out.println("3");

		String location = "file://E:/Java/jdk1.7.0/bin";
		MarshalledObject data = null;
		System.out.println("4");
		ActivationDesc desc = new ActivationDesc(agi , "ActivatableImplementation" , location , data);
		System.out.println("5");
		MyRemoteInterface mri = (MyRemoteInterface)Activatable.register(desc);
		System.out.println("Got the stub for the ActivatableImplementation");
		Naming.rebind("ActivatableImplementation" , mri);
		System.out.println("Exported ActivatableImplementation");
		System.exit(0); 
	}//main

}//class setup