import java.util.*;

class days1{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);
System.out.print("Enter days:");
int days=ob.nextInt();

int d1=days/365;
int d2=days%365;

int d3=d2/7;
int d4=d2%7;
System.out.print("Years="+d1+"\nWeaks="+d3+"\ndays="+d4); 
 }
}