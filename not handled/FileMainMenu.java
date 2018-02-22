import java.io.*;
import java.util.*;
class FileMainMenu{
	File f=new File("E:/Data.txt");
	String st;
	Scanner ob=new Scanner(System.in);
	PrintStream prnt=new PrintStream(new FileOutputStream(f));
	 
	 FileMainMenu()throws Exception{
	  try{
	   if(!f.exists()){
		f.createNewFile();}}catch(Exception e){}
	   menu();
	}

	void menu()throws Exception{
	DataInputStream in=new DataInputStream(new FileInputStream(f));
	
	while((st=in.readLine())!=null){
		System.out.println(st);
		//st+=st;
		} 
	 //PrintStream prnt=new PrintStream(new FileOutputStream(f));
	 if(st!=null)prnt.println(st);
	 int sel=0;
	 while(sel!=6){
	 System.out.println("1.Add Record\n2.Delete Record\n3.Update Record\n4.search Record\n5.Traversing\n6.Exit");
	 System.out.print("Enter Selection: ");
	 sel=ob.nextInt();
	
	 if(sel==1){
	 System.out.print("Enter Name:");
	 String s=ob.next();
	 st=ob.nextLine();
	 prnt.append(s+st+",");
	 System.out.print("Enter f/name:");
	 st=ob.nextLine();
	 prnt.print(st+",");
	 System.out.print("Enter nic:");
	 st=ob.nextLine();
	 prnt.print(st+",");
	 System.out.print("Enter rollno:");
	 st=ob.nextLine();
	 prnt.print(st+",");
	 System.out.print("Enter Contact#:");
	 st=ob.nextLine();
	 prnt.print(st+",");
	 ob.nextLine();
	 System.out.print("Enter dep:");
	 st=ob.nextLine();
	 prnt.println(st+"||");
	 
	 }
  	 if(sel==2){ deleteRecord(); }
	 if(sel==3){ update(); }
	 if(sel==4){ search(); }
	 if(sel==5){traverse();}
	 if(sel==6){ Exit(); }
		}}
	//void addRecord(){
	//}
	void deleteRecord(){}
	void update(){}
	void search(){}
	void traverse()throws Exception{ 
		DataInputStream input=new DataInputStream(new FileInputStream(f));
		int count=0;
		String str="";
		String s[];
		while((str=input.readLine())!=null){
			count++;
		}
		DataInputStream input2=new DataInputStream(new FileInputStream(f));
		s=new String[count];
		str="";
		count=-1;
		while((str=input2.readLine())!=null){
			s[++count]=str;
		}
		for(int i=0;i<s.length;i++){
			StringTokenizer tk=new StringTokenizer(s[i],",");
			System.out.println("Name:"+tk.nextToken());
			System.out.println("f/Name:"+tk.nextToken());
			System.out.println("Nic :"+tk.nextToken());
			System.out.println("rollno: "+tk.nextToken());
			System.out.println("contact# :"+tk.nextToken());
			System.out.println("dep: "+tk.nextToken());
			System.out.println("********************");
		}	
}
	void Exit(){}
	public static void main(String arg[])throws Exception{
	
	new FileMainMenu();

	}
}