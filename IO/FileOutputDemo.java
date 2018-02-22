import java.io.*;
 class FileOutputDemo{
	public static void main(String arg[])throws Exception{
	 File f=new File("E:/test.txt");
	 if(!f.exists()){
	   f.createNewFile(); 	}
	//PrintStream out=new PrintStream(new FileOutputStream(f));
     //FileInputStream out=new FileInputStream(f);
	//out.println("hello txt file");
	//out.println("In new text in your file");
	 //  System.out.println(out.read());
	DataInputStream reed=new DataInputStream(new FileInputStream(f));
	String str;
	while((str=reed.readLine())!=null){
	System.out.println(str);}
	}

}