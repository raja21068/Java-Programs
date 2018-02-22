import java.io.*;

class FileReadDemo{
public static void main(String arg[])throws Exception {
File f=new File("test.java");
DataInputStream in=new DataInputStream(new FileInputStream(f));
String str="";

while((str=in.readLine())!=null){
System.out.println(str);
}
}

}