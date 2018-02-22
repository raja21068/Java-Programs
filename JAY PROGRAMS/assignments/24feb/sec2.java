import java.util.*;

class sec2{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("Enter Seconds:");  int second=ob.nextInt();

int hr=second/3600;
int hr1=second%3600;

int min=hr1/60;
int sec=hr1%60;

if(hr>0)  { System.out.print("Hours="+hr);  }
if(min>0) { System.out.print("\nMinutes="+min);}
if(sec>0) { System.out.print("\nSeconds="+sec);}
 }
}