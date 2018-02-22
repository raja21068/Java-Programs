import java.util.*;

class select{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);

System.out.print("1.Marksheet\n2.Transport Company(Troly load)\n3.Finance Biling(Employee salary)\n4.ATM(Rupees Conversion)");
System.out.print("\nEnter your Selection: "); int v1=ob.nextInt();

if (v1==1){ 
System.out.print("Enter jam Marks: ");
Double jm=ob.nextDouble();

System.out.print("Enter Visual Basic Marks: ");
Double vm=ob.nextDouble();

System.out.print("Enter Oracle Marks: ");
Double om=ob.nextDouble();

System.out.print("Enter c++ Marks: ");
Double cm=ob.nextDouble();

System.out.print("Enter Assembly Marks: ");
Double am=ob.nextDouble();

Double obtain=jm+vm+om+cm+am;
Double per=(obtain*100)/500;

System.out.print("==========================");
System.out.print("\nYour obatined marks: "+obtain+"\nyour total marks: 500\nYour percentage : "+per); 
}

if (v1==2){
System.out.print("Enter Troly load: ");
Double t=ob.nextDouble();

System.out.print("Enter recent price of Diesel per litre:");
Double d=ob.nextDouble();

Double total=800*t;
Double driver=150*t;
Double tax=total/10;
Double diesel=2*t*d;
Double profit=total-driver-tax-diesel;

System.out.print("Total Income="+total+"\nDriver="+driver+"\nTax 10%="+tax+"\nDiesel="+diesel+"\nprofit="+profit); 
 
}

if (v1==3){ 
System.out.print("Enter Employee basic salary?"); int sal=ob.nextInt();
int per=sal/100; /*this is 1% of salary*/
int halfp=per/2;
int ma=per*15;
int hr=per*45;
int bo=per*5;
int grospay=sal+ma+hr+bo;
int tax=per*8;
int ca=per*15;
int zak=halfp+(per*2);
int net=grospay-tax-ca-zak;
System.out.println("Basic pay= "+sal+"\nMedical allounce 15%= "+ma+"\nHouse rent 45%= "+hr+"\nBonus 5%= "+bo+"\nGross pay= "+grospay+"\nIncome tax 8%="+tax+"\nConvence Allounce 15%="+ca+"\nZakwat 2.5%="+zak+"\nNet Income:"+net);
}  

if(v1==4){ 
System.out.print("Enter Rupees: "); int rupee=ob.nextInt();

int t1=rupee/5000;
int t2=rupee%5000;

int t3=t2/1000;
int t4=t2%1000;

int t5=t4/500;
int t6=t4%500;

int t7=t6/100;
int t8=t6%100;

int t9=t8/50;
int t10=t8%50;

int t11=t10/20;
int t12=t10%20;

int t13=t12/10;
int t14=t12%10;

int t15=t14/5;
int t16=t14%5;


int t17=t16/2;
int t18=t16%2;

System.out.println("5000="+t1+"\n1000="+t3+"\n500="+t5+"\n100="+t7+"\n50="+t9+"\n20="+t11+"\n10="+t13+"\n5="+t15+"\n2="+t17+"\n1="+t18); 
}

 }
} 