import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DynamicClient {

     public static void main(String arg[]){
       if(System.getSecurityManager()==null)
	System.setSecurityManager(new RMISecurityManager());
	Properties p = System.getProperties();
	String url = p.getProperty("java.rmi.server.codebase");
	
	try{
	    Class client = RMIClassLoader.loadClass(url,"MainFrame");
	    client.newInstance();
		
      }catch(Exception ex){ex.printStackTrace();}
    }
}
