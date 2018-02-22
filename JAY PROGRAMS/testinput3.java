import java.io.*;

class testinput3{
public static void main(String arg[])throws Exception{

DataInputStream ob=new DataInputStream(System.in);
System.out.print("Enter your name:");  String name=ob.readLine();

System.out.println("Your Name is:"+name);
 }
}