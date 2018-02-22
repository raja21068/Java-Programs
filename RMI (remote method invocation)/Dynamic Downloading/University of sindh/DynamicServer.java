import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DynamicServer {

     public static void main(String arg[]){
	if(System.getSecurityManager()==null){
		System.setSecurityManager(new RMISecurityManager());
       }
       Properties p = System.getProperties();
       String url = p.getProperty("java.rmi.server.codebase");

       try{
		Class server = RMIClassLoader.loadClass(url,"DatabaseManager");
		Naming.rebind("rmi://localhost:1099/Service",(Remote)server.newInstance());
		System.out.println("RMIServer bound in registry");
      }catch(Exception ex){ex.printStackTrace();}
    }
}
