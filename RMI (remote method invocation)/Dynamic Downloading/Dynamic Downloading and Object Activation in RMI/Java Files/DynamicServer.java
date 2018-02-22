import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DynamicServer{
  public static void main(String arg[]){

   if(System.getSecurityManager()==null)
   System.setSecurityManager(new RMISecurityManager());

   Properties p=System.getProperties();
   String url=p.getProperty("java.rmi.server.codebase");

   try{
        Class server=RMIClassLoader.loadClass(url,"HelloServer");
        Naming.rebind("rmi://localhost:1099/HelloService",(Remote)server.newInstance());
        System.out.println("HelloServer bound in registry");
  }catch(Exception e){
    e.printStackTrace();
  }	

  }  
}
