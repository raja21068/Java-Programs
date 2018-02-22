import java.util.*;

class byt{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);
System.out.print("Enter bytes:");  long b=ob.nextLong();

long gb=b/1000000000;
long gb1=b%1000000000;

long mb=gb1/1000000;
long mb1=gb1%1000000;
long kb=mb1/1000;
long bt=mb1%1000;
if(gb>0) { System.out.print("GegaBytes="+gb);}
if(mb>0) { System.out.print("\nMegaBytes="+mb);}
if(kb>0) { System.out.print("\nKiloBytes="+kb);}
if(bt>0) { System.out.print("\nBytes="+bt);    }
 }
}