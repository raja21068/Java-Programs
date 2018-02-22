import java.rmi.*;
import java.rmi.server.*;
public class RMIServer {
    public static void main(String arg[])throws Exception{
        DatabaseManager ob = new DatabaseManager();
        UnicastRemoteObject .exportObject(ob);
        System.out.println("Object exported..");
	Naming .rebind("rmi://localhost:1099/ali", ob);
        System.out.println("Rmi server is started...");
    }
}