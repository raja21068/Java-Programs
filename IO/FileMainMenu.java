/**@JAY KUMAR 2k11/CSM/25
 => This is a menu based program.. this program belongs to file system.
 => This program is made for the students records.
 => Main method is at the end of the Program.
 => Every Option has its separate method except adding a record at the last of program.
 */
import java.io.*;
import java.util.*;

class FileMainMenu{
	File f=new File("Data.txt");
	String st;
	Scanner ob=new Scanner(System.in);
	
	PrintStream prnt=new PrintStream(new FileOutputStream(f,true));
	 
	//**********************************************
	FileMainMenu()throws Exception{
	  try{
	   if(!f.exists()){
		f.createNewFile();}}catch(Exception e){}
	   menu();
	   }
	
	
	
	//TODO*************MAIN MENU********************
	void menu()throws Exception{
	
	
		
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
	 prnt.append(st+",");
	 System.out.print("Enter nic:");
	 st=ob.nextLine();
	 prnt.append(st+",");
	 System.out.print("Enter rollno:");
	 st=ob.nextLine();
	 prnt.append(st+",");
	 System.out.print("Enter Contact#:");
	 st=ob.nextLine();
	 prnt.append(st+",");
	 System.out.print("Enter dep:");
	 st=ob.nextLine();
	 prnt.println(st+"||");
	 System.out.println("Your Record is Succesfully added..../nPress any key:");
	 ob.nextLine();
	 }
  	 if(sel==2){ deleteRecord(); }
	 if(sel==3){ update(); }
	 if(sel==4){ search(); }
	 if(sel==5){traverse();}
		}}
	
	//void addRecord(){}
	//TODO**********DELETE****************
	void deleteRecord()throws Exception{
			
		DataInputStream input=new DataInputStream(new FileInputStream(f));
		System.out.print("\n1.Nic\n2.Name\nEnter Selection:");
		int s=ob.nextInt();
		if(s==1){System.out.print("\nEnter Nic:");	}
		else if(s==2){System.out.print("\nEnter Name:");	}
		else{System.out.println("***Invalid choice***"); return;}
		String name=new Scanner(System.in).nextLine();
		String s2;
		File nf=new File("temp.txt");
		nf.delete();
		nf.createNewFile();
		PrintStream newprint=new PrintStream(new FileOutputStream(nf));
		while((s2=input.readLine())!=null){
				
				if(s2.contains(name)){ 
				}//end of if
				else { newprint.println(s2); }
		}//end of while
		
		s2="";
		DataInputStream newf=new DataInputStream(new FileInputStream(nf));
		PrintStream pint=new PrintStream(new FileOutputStream(f));
		while((s2=newf.readLine())!=null){
			pint.println(s2);
		}
		nf.delete();
		System.out.println("Your Record is succesfully deleted...");
		new Scanner(System.in).nextLine();
	
	}
	//TODO**********UPDATE****************
	void update()throws Exception{
		DataInputStream input=new DataInputStream(new FileInputStream(f));
		System.out.print("\n1.Nic\n2.Name\nEnter Selection:");
		int s=ob.nextInt();
		if(s==1){System.out.print("\nEnter Nic:");	}
		else if(s==2){System.out.print("\nEnter Name:");	}
		else{System.out.println("***Invalid choice***"); return;}
		String name=new Scanner(System.in).nextLine();
		String s2;
		File nf=new File("temp.txt");
		nf.delete();
		nf.createNewFile();
		PrintStream newprint=new PrintStream(new FileOutputStream(nf));
		while((s2=input.readLine())!=null){
				
				if(s2.contains(name)){ 
				System.out.print("Enter new Name:");
				name=new Scanner(System.in)+",";
				System.out.print("Enter f/name:");
				name+=new Scanner(System.in).nextLine()+",";
				System.out.print("Enter nic:");
				name+=new Scanner(System.in).nextLine()+",";
				System.out.print("Enter rollno:");
				name+=new Scanner(System.in).nextLine()+",";
				System.out.print("Enter contact#:");
				name+=new Scanner(System.in).nextLine()+",";
				System.out.print("Enter dep:");
				name+=new Scanner(System.in).nextLine()+"||";
				newprint.print(name);
				}//end of if
				else { newprint.println(s2); }
		}
		
		s2="";
		DataInputStream newf=new DataInputStream(new FileInputStream(nf));
		PrintStream pint=new PrintStream(new FileOutputStream(f));
		while((s2=newf.readLine())!=null){
			pint.println(s2);
		}
		nf.delete();
	}//end of Update
	
	//TODO***********SEARCH***************
	void search()throws Exception{
		DataInputStream input=new DataInputStream(new FileInputStream(f));
		System.out.print("\n1.Nic\n2.Name\n3.Contact\nEnter Selection:");
		int s=ob.nextInt();
		if(s==1){System.out.print("\nEnter Nic:");}
		else if(s==2){System.out.print("\nEnter Name:");}
		else if(s==3){System.out.print("\nEnter Conatct:");}
		else{System.out.println("***Invalid choice***"); return;}
		String serch=new Scanner(System.in).nextLine();
		String s2;
		s=0;
		while((s2=input.readLine())!=null){
				if(s2.contains(serch)){ 
					s=1;
					String[] token=s2.split(",");
					System.out.println("Name:"+token[0]);
					System.out.println("f/Name:"+token[1]);
					System.out.println("Nic :"+token[2]);
					System.out.println("rollno: "+token[3]);
					System.out.println("contact# :"+token[4]);
					System.out.println("dep: "+token[5]);
					System.out.println("********************");
				}//end of if
		}//end of while
			if(s==0){ System.out.println("**Not Found**"); }
			new Scanner(System.in).nextLine();
	}//end of search
	//TODO ********TRAVERSE***************
	void traverse()throws Exception{ 
		DataInputStream input=new DataInputStream(new FileInputStream(f));
		String str="";
		while((str=input.readLine())!=null){
	    
			StringTokenizer tk=new StringTokenizer(str,",");
			System.out.println("Name:"+tk.nextToken());
			System.out.println("f/Name:"+tk.nextToken());
			System.out.println("Nic :"+tk.nextToken());
			System.out.println("rollno: "+tk.nextToken());
			System.out.println("contact# :"+tk.nextToken());
			System.out.println("dep: "+tk.nextToken());
			System.out.println("********************");
			} new Scanner(System.in).nextLine(); }
	public static void main(String arg[])throws Exception{
	
	new FileMainMenu();

	}
}