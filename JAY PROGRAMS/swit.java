import java.util.*;
class swit{

public static void main(String arg []){
Scanner ob=new Scanner(System.in);

System.out.print("Enter 1st value: "); int a=ob.nextInt();
System.out.print("Enter 2nd vlaue: "); int b=ob.nextInt();
System.out.print("Enter Operator: ");  char op=ob.next().charAt(0);

switch(op){
case '+':System.out.print("\nAddition is: "+(a+b)); break;
	
case '-':System.out.print("\nSubstraction is: "+(a-b)); break;
	
case 'X':
case 'x':
case '*':System.out.print("\nMultiplicatioon is: "+a*b); break;
	
case '/':
case'\\': System.out.print("\nDivision is: "+a/b); break;
	

default:
	System.out.println("Invlaid operator..");
}


 }
}