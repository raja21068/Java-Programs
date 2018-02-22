import java.util.*;
import java.io.*;

class file{
public static void main(String arg[]){
try{
FileInputStream file=new FileInputStream("d:abc.txt");

Scanner ob=new Scanner(file);

String line1=ob.nextLine();
String line2=ob.nextLine();
String line3=ob.nextLine();

System.out.println(line1);
System.out.println(line2);
System.out.println(line3);
 } catch(Exception e){
System.out.println("File not found....!"+e);
}

System.out.println("===THIS IS THE RESULT== ");
}
}