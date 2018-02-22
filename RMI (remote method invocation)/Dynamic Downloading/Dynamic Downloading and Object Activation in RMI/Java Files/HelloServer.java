import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class HelloServer extends UnicastRemoteObject implements 
					  	      HelloInterface{
        public HelloServer()throws RemoteException{
	        //Call super class constructor to export this object   
		super();	   	
	}

	public String sayHello()throws RemoteException{
	  return "Hello World, the current system time is "+ new Date();
	}   

}
