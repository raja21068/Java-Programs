import java.util.*;

class table{

public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
char ch='y';
while(ch=='y'||ch=='Y'){
System.out.print("Enter Last table Number: "); 
int tab=ob.nextInt();
System.out.print("Enter counter number:"); 
int count=ob.nextInt();
int i=2;
while(i<=tab){
System.out.println("Table No:"+i);
int j=1;
    while(j<=count){
     System.out.println(i+"x"+j+"="+i*j);
        j++;     }
   i++;
}
System.out.print("Do you want to Continue...Y/N..?");
ch=ob.next().charAt(0);}

 }
  }