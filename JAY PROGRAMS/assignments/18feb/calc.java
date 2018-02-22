import java.util.*;

class calc{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter 1st value:  ");  String v1=ob.nextLine();
System.out.print("Enter 2nd value:  ");  String v2=ob.nextLine();

System.out.print("Enter operator:  "); String c=ob.nextLine();
Double a=Double.parseDouble(v1);
Double b=Double.parseDouble(v2);
char op=c.charAt(0);
if (op=='+'){ System.out.println("Addition is : "+(a+b)); }
 
if (op=='-'){ System.out.println("substraction is : "+(a-b)); }

if (op=='*'||op=='x'||op=='X'){ System.out.println("Multiplication is : "+a*b); }

if (op=='/'||op=='\\'){ System.out.println("Division is : "+a/b ); }

if (op=='%'){ System.out.println("Remainder is : "+a%b); }

 }
}