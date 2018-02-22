import java.util.Scanner;

/**
 *
 * @author Aahil Mehboob
 */
public class Main {
    public static void main(String arg[]){
        
        Scanner in = new Scanner(System.in);
        
        int k=0;
        do{
            
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("? ");
            try{
                k = in.nextInt();
            }catch(NumberFormatException ex){System.err.println("Wrong entry.");}
            
            if(k==1){
                Scanner in2 = new Scanner(System.in);
                System.out.print("Enter Name: ");
                String name = in2.nextLine();
                System.out.print("Enter Rollno: ");
                String rollno = in2.nextLine();
                System.out.print("Enter Subject: ");
                String subject = in2.nextLine();
                System.out.print("Enter Marks: ");
                String marks = in2.nextLine();
                
                try{
                    ModifyXML.write(name, rollno, subject, marks);
                }catch(Exception ex){ex.printStackTrace();}
            }
            
            else if(k==2){
                Scanner in2 = new Scanner(System.in);
                System.out.print("Enter Name: ");
                String name = in2.nextLine();
                
                try{
                    ModifyXML.delete(name);
                }catch(Exception ex){ex.printStackTrace();}
            }
            
            else if(k==3){
                Scanner in2 = new Scanner(System.in);
                System.out.print("Enter Old Name: ");
                String oldName = in2.nextLine();
                System.out.print("Enter New Name: ");
                String newName = in2.nextLine();
                System.out.print("Enter Rollno: ");
                String rollno = in2.nextLine();
                System.out.print("Enter Subject: ");
                String subject = in2.nextLine();
                System.out.print("Enter Marks: ");
                String marks = in2.nextLine();
                
                try{
                    ModifyXML.update(oldName, newName, rollno, subject, marks);
                }catch(Exception ex){ex.printStackTrace();}
            }
            
            else if(k==4){
                try{
                    ModifyXML.showAll();
                }catch(Exception ex){ex.printStackTrace();}
            }
            
        }while(k!=5);
        
        System.out.println("Good Bye!");
    }
}
