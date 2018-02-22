import java.util.*;
class swit2{

public static void main(String arg []){
Scanner ob=new Scanner(System.in);

System.out.print("Enter your secret code: "); String code=ob.nextLine();

switch(code){
case "x125":
case "9xk5":
case "kw49": System.out.print("....WELCOME...."); break;
	

default:
	System.out.println("You are unauthorized");
}


 }
}