import java.util.*;

class brek{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("Enter any no: ");
int n=ob.nextInt();
int j=1;
for (int i=1;i<=n;i++){
j=j+1;
System.out.println(i);
   if(j>20){ 
     System.out.print("Press Enter key to Continue.. ");
       char ch=ob.nextLine().charAt(0);
           j=1;    
           if(ch=='a')continue;
         
       }

}
}
}