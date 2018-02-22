

import java.rmi.Naming;

/**
 *
 * @author DELL
 */
public class RMIClient {
    public static void main(String arg[])throws Exception{
        DatabaseManager ob = (DatabaseManager) Naming.lookup("ali");
        int num = ob.add("gaffar", "java", "21");
        System.out.println("Record is added successfully");
    }
}
