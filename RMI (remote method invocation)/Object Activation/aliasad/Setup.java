import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;

class Setup{
	public static void main(String arg[])throws Exception{
		System.setSecurityManager(new RMISecurityManager());

		Properties p = new Properties();
		p.put("java.security.policy", "sachal.policy");
		System.out.println("1");

		ActivationGroupDesc.CommandEnvironment ace = null;
		ActivationGroupDesc exampleGroup = new ActivationGroupDesc(p, ace);
		ActivationGroupID id = ActivationGroup.getSystem().registerGroup(exampleGroup);	
		System.out.println("2");

		String location = "file://E:/Java/jdk1.7.0/bin";
		MarshalledObject data = null;
		ActivationDesc desc = new ActivationDesc(id, "CalcImp", location, data);
		System.out.println("3");

		Calc ob = (Calc)Activatable.register(desc);
		System.out.println("Got stub of CalcImp");

		Naming.rebind("ali", ob);
		System.out.println("Exported CalcImp");
		System.exit(0);
	}
}