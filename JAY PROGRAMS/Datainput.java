import java.io.*;

class Datainput{
public static void main(String arg[])throws Exception{

DataInputStream ob=new DataInputStream(System.in);

System.out.print("Enter 1st value:");  String s1=ob.readLine();
System.out.print("Enter 2nd value:");  String s2=ob.readLine();

int a=Integer.parseInt(s1);
int b=Integer.parseInt(s2);

System.out.println("Addition of "+a+" and "+b+" is:"+(a+b));
 }
}