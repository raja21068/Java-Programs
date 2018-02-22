	import java.sql.*;
	import java.util.*;
public class GuiMainMenuDataBase {
		
	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	      Scanner scan = new Scanner(System.in);
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  Connection con = DriverManager.getConnection("jdbc:odbc:Students");
		  Statement st = con.createStatement();
		  
		  ResultSet rs; 
	    int select=0;
	     while(true){
		 System.out.println("\n*******************************");
	    	 System.out.print("1.Insert New Student\n2.Delete\n3.Update\n4.Select\n5.Exit");
	    	 System.out.print("\nEnter Selection:");
	    	 select = scan.nextInt();

	    	 if(select==1){
			scan.nextLine();
			System.out.print("\nEnter Name: ");
			String name =scan.nextLine();
			System.out.print("\nEnter F/Name:  ");
			String fname =scan.nextLine();
			System.out.print("\nEnter roll No:");
			String roll =scan.nextLine();
			System.out.print("\nEnter Cast: ");
			String cast =scan.nextLine();
			System.out.print("\nEnter Nic: ");
			String nic =scan.nextLine();
			System.out.print("\nEnter address: ");
			String address =scan.nextLine();
			System.out.print("\nEnter e-mail: ");
			String mail =scan.nextLine();
			System.out.print("\nEnter mob: ");
			String mob =scan.nextLine();
			int r = st.executeUpdate("INSERT into Data(name, f_Name, Cast, roll_No, Nic, address, mob_No, e_mail)values('"+name+"', '"+fname+"', '"+cast+"','"+roll+"','"+nic+"','"+address+"','"+mob+"','"+mail+"')");
			System.out.println(r);
			}//end of insertion

	    	 else if(select==2){
				System.out.print("\nEnter student id want to delete: ");
				int id=scan.nextInt();
				 st.executeUpdate("DELETE from Data where ID ="+id);
				}//end of deletion

	    	 else if(select==3){
			System.out.print("\nEnter ID want to update: ");
			int id = scan.nextInt();
			String arr[]={"name","f_Name","Cast","Nic","roll_No","address","mob_No","e_mail"};
				for(int i=0;i<arr.length;i++){
				rs = st.executeQuery("SELECT " +arr[i] +" from Data where ID= "+id);
				while(rs.next())System.out.print(rs.getString(arr[i])+"  ");}
				System.out.println("\n\nNow Enter New Record.....");
				scan.nextLine();
				//*****************updating****************//
				System.out.print("\nEnter Name: ");
				String name =scan.nextLine();
				System.out.print("\nEnter F/Name:  ");
				String fname =scan.nextLine();
				System.out.print("\nEnter roll No:");
				String roll =scan.nextLine();
				System.out.print("\nEnter Cast: ");
				String cast =scan.nextLine();
				System.out.print("\nEnter Nic: ");
				String nic =scan.nextLine();
				System.out.print("\nEnter address: ");
				String address =scan.nextLine();
				System.out.print("\nEnter e-mail: ");
				String mail =scan.nextLine();
				System.out.print("\nEnter mob: ");
				String mob =scan.nextLine();
				try{
				rs = st.executeQuery("UPDATE Data SET name ='"+name+"' ,f_Name='"+fname+"', Cast= '"+cast+"', roll_No='"+roll+"', Nic ='"+nic+"', address='"+address+"',mob_No='"+mob+"',e_mail='"+mail+"' where ID="+id);
				}catch(Exception e){System.out.println("Some problem occured....");}
				}//end of update

	    	 //*************************************************************//
	    	 else if(select==4){
	    		 int trav=0;
	    		 System.out.print("\n1.All\n2.Single\nEnter Selection: ");
	    		 trav = scan.nextInt();

	    		 if(trav==1){
				rs = st.executeQuery("SELECT * from Data");            
	            		while(rs.next()){
	                	System.out.println(rs.getInt("ID")+" . "+rs.getString("name")+" . "+rs.getString("f_Name")+" . "+rs.getString("roll_No"));
	           			}
				}

	    		 else if(trav==2){
				System.out.print("\n\nEnter student Id:");
				int id=scan.nextInt();
				String arr[]={"name","f_Name","Cast","Nic","roll_No","address","mob_No","e_mail"};
				for(int i=0;i<arr.length;i++){
				rs = st.executeQuery("SELECT " +arr[i] +" from Data where ID= "+id);
				while(rs.next())System.out.print(rs.getString(arr[i])+"  ");}
					}

	    		 else {System.out.println("< Invalid Choice >"); }
	    	 }
	    	 ///***********************end of traverse************//

	    	 else if(select==5){ System.out.println("Good Bye..."); System.exit(0); }

	    	 else { System.out.println("< Invalid Choice >"); }

		try{Thread.sleep(2000);}catch(Exception e){}
	     }//end of while
	    }
	}


