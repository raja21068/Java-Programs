import java.util.*;

class luck{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter Your Luck no 1 to 20: ");   int a=ob.nextInt();

if(a==5||a==9||a==13||a==19){ 
System.out.println("You Won the game,\nPlease recieve your Prize from Recieptionist."); 
}

else{ 
System.out.println("You lose The Game,\nPlease Recieve Your Return fair from The Receptionist.. "); } 

 }
}