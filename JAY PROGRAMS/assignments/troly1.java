import java.util.*;

class troly1{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter Troly load: ");
Double t=ob.nextDouble();

System.out.print("Enter recent price of Diesel per litre:");
Double d=ob.nextDouble();

Double total=800*t;
Double driver=150*t;
Double tax=total/10;
Double diesel=2*t*d;
Double profit=total-driver-tax-diesel;

System.out.print("Total Income="+total+"\nDriver="+driver+"\nTax 10%="+tax+"\nDiesel="+diesel+"\nprofit="+profit); 
 }
}