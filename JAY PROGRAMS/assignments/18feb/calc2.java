import java.util.*;

class calc2{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter operator:  "); String c=ob.nextLine();
char op=c.charAt(0);
if(op!='+'&&op!='-'&&op!='*'&&op!='x'&&op!='X'&&op!='/'&&op!='\\'&&op!='%'){ System.out.print("**Invalid Operator**");  }

if (op=='+'){
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Addition is : "+(a+b)); 
}
 
if (op=='-'){
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("substraction is : "+(a-b)); 
}

if (op=='*'||op=='x'||op=='X'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Multiplication is : "+a*b); 
}

if (op=='/'||op=='\\'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Division is : "+a/b ); 
}

if (op=='%'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Remainder is : "+a%b); 
}


 }
}