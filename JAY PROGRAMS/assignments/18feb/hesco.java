/*this program is for HESCO..*/
import java.util.*;

class hesco{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("HESCO Bill Calculation System");
System.out.print("Enter Electricity unit? "); int u=ob.nextInt();
System.out.print("Charge: ");
if(u>=1 && u<=100){ System.out.print(""+u*2); }
if(u>=101 && u<=200){ int rem=u-100;
System.out.print(""+((rem*4)+200)); }
if(u>=201 && u<=300) { int rem=u-200;
int a=(100*2)+(100*4);
System.out.print(""+((rem*6)+a)); }
if(u>=301 && u<=400) { int rem=u-300;
int a=(100*2)+(100*4)+(100*6);
System.out.print(""+((rem*8)+a)); }
if(u>=401) { int rem=u-400;
int a=(100*2)+(100*4)+(100*6)+(100*8);
System.out.print(""+((rem*10)+a));  }

}
}