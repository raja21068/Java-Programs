import java.util.*;

class calcu{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("1.Addition\n2.Substraction\n3.Multiplication\n4.Division\n5.Remaider");
System.out.println("Enter your Selection: "); int v1=ob.nextInt();

System.out.print("Enter 1st value: "); int a=ob.nextInt();
System.out.print("Enter 2nd value: "); int b=ob.nextInt();

if (v1==1){ System.out.println("Addition is : "+(a+b)); }

if (v1==2){ System.out.println("Substraction is: "+(a-b)); }

if (v1==3){ System.out.println("Multiplication is : "+a*b); }  

if(v1==4){ System.out.println("Division is: "+a/b); }

if(v1==5){ System.out.println("Remaider is: "+a%b); }


 }
} 