/*this program is for HESCO..*/
import java.util.*;

class hesco2{
public static void main(String arg[]){
Scanner ob=new Scanner(System.in);
System.out.print("\n\n***HESCO Bill Calculation System***");
System.out.print("Enter Electricity unit? "); int u=ob.nextInt();
System.out.print("Charge: ");
int a=100*2;
int b=a+(100*4);
int c=b+(100*6);
int d=c+(100*8);
if(u>=1 && u<=100){ System.out.print(""+u*2); }
if(u>=101 && u<=200){ int rem=u-100;
System.out.print(""+((rem*4)+a)); }
if(u>=201 && u<=300) { int rem=u-200;
System.out.print(""+((rem*6)+b)); }
if(u>=301 && u<=400) { int rem=u-300;
System.out.print(""+((rem*8)+c)); }
if(u>=401) { int rem=u-400;
System.out.print(""+((rem*10)+d));  }

}
}