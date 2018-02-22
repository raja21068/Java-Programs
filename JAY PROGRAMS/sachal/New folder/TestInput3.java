import java.util.*;


import java.io.*;
import java.net.*;

class TestInput3{
   public static void main(String arg[]){
  try{

       URL url=new URL("http://www.google.com/index.html");
       InputStream remoteFile=url.openStream();

       Scanner ob=new Scanner(remoteFile);

       String line1=ob.nextLine();
       String line2=ob.nextLine();
       String line3=ob.nextLine();

       System.out.println(line1);
       System.out.println(line2);
       System.out.println(line3);

  }catch(Exception e){
       System.out.println("File Not Found: "+e);
  }


   }
}
