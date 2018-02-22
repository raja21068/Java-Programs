import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class HelloServer extends UnicastRemoteObject implements HelloInterface{

    public HelloServer()throws RemoteException{
      //call super class to export this Object
      super();
   }

   public String sayHello()throws RemoteException{
      return "Hello World , the current time is "+new Date();
  }
}
