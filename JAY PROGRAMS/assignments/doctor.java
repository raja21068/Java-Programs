import java.util.*;

class doctor{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);
System.out.print("Enter your age: "); short age=ob.nextShort();

if(age>0 && age<=12) { System.out.print("you are a kid..! Take a lolly pop.."); }

if(age>12 && age<=30){ System.out.print("You are young, enjoy your life...!eat chicken, meat etc..");}

if(age>30 && age<=40) { System.out.print("You should avoid to eat oily and sweet...!"); }

if(age>40) { System.out.print("You are aged, eat only jelly..!"); }
}
}