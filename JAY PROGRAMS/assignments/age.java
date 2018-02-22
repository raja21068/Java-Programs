import java.util.*;

class age{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter 1st age: "); int a=ob.nextInt();
System.out.print("Enter 2nd age: "); int b=ob.nextInt();
System.out.print("Enter 3rd age: "); int c=ob.nextInt();

if(a>b && a>c) { System.out.print("1st age is greater...!"); }

if(b>a && b>c) { System.out.print("2nd age is greater...!"); }

if(c>a && c>b) { System.out.print("3rd age is greater...!"); }

if(a==b) { System.out.print("\n1st and 2nd are equal..."); }
if(b==c) { System.out.print("\n2nd and 3rd are equal..."); }
if(a==c) { System.out.print("\n1st and 3rd are equal..."); }
if(a==b&& b==c) { System.out.print("1st ,2nd and 3rd are equal..."); }
}
}
