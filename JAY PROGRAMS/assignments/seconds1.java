import java.util.*;

class seconds1{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter Seconds");
int sec=ob.nextInt();

int s1=sec/3600;
int s2=sec%3600;

int s3=s2/60;
int s4=s2%60;

System.out.print("Hours="+s1+"\nMinutes="+s3+"\nsecond="+s4); 
 }
}