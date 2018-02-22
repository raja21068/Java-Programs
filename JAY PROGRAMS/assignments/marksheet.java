import java.util.*;

class marksheet{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter jam Marks: ");
Double jm=ob.nextDouble();

System.out.print("Enter Visual Basic Marks: ");
Double vm=ob.nextDouble();

System.out.print("Enter Oracle Marks: ");
Double om=ob.nextDouble();

System.out.print("Enter c++ Marks: ");
Double cm=ob.nextDouble();

System.out.print("Enter Assembly Marks: ");
Double am=ob.nextDouble();

Double obtain=jm+vm+om+cm+am;
Double per=(obtain*100)/500;

System.out.print("==========================");
System.out.print("\nYour obatined marks: "+obtain+"\nyour total marks: 500\nYour percentage : "+per);
}
}