import java.util.*;

class atm2{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);
System.out.print("\nEnter Rupees: "); int rupee=ob.nextInt();

int a1=rupee/5000;
int a2=rupee%5000;

int a3=a2/1000;
int a4=a2%1000;

int a5=a4/500;
int a6=a4%500;

int a7=a6/100;
int a8=a6%100;

int a9=a8/50;
int a10=a8%50;

int a11=a10/20;
int a12=a10%20;

int a13=a12/10;
int a14=a12%10;

int a15=a14/5;
int a16=a14%5;

int a17=a16/2;
int a18=a16%2;

if (a1>0)  { System.out.print("5000="+a1);  }
if (a3>0)  { System.out.print("\n1000="+a3);}
if (a5>0)  { System.out.print("\n500="+a5); }
if (a7>0)  { System.out.print("\n100="+a7); } 
if (a9>0)  { System.out.print("\n50="+a9);  }
if (a11>0) { System.out.print("\n20="+a11); }
if (a13>0) { System.out.print("\n10="+a13); }
if (a15>0) { System.out.print("\n5="+a15);  }
if (a17>0) { System.out.print("\n2="+a17);  }
if (a18>0) { System.out.print("\n1="+a18);  }
 }
}