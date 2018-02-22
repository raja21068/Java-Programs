import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class HelloClient {
  public HelloClient(){
	try{
	HelloInterface obj = (HelloInterface)Naming.lookup("rmi://localhost:1099/HelloService");
       String message = obj.sayHello();
	System.out.println(message);
	}catch(Exception ex){ex.printStackTrace();}
 }
 
}
