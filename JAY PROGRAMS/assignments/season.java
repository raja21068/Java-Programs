import java.util.*;

class season{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter month no 1 to 12: "); int a=ob.nextInt();

if (a==11||a==12||a==1){ System.out.println("Season : Winter"); }

if (a==2||a==3||a==4){ System.out.println("Season : Spring"); }

if (a==5||a==6||a==7){ System.out.println("Season : Summer"); }  

if(a==8||a==9||a==10){ System.out.println("Season : Automn"); }

if(a>12){ System.out.println("...Invalid Month No..."); }
 }
} 