
import java.rmi.Naming;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */

public class Client {
    public static void main(String arg[])throws Exception{
        Calc ob = (Calc)Naming.lookup("ali");
        int num1 = ob.add(10, 5);
        int num2 = ob.mul(10, 5);
        System.out.println("Addition: "+num1);
        System.out.println("Multiplication: "+num2);
    } 
}
