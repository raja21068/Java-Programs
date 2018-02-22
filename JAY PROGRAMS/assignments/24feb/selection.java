//Jay Kumar
//21-2-2012
//This program is selection program, have variable choice
//(Given By Sir Sachal Joyo)


import java.util.*;

class selection{
public static void main(String arg[]){

Scanner ob=new Scanner(System.in);
System.out.print("1.Calculator\n2.Unit Converter\n3.Age Calculator\n4.Season\n5.Trolyload\n6.Marksheet\n7.ATM(Rupees conversion)\n8.Lucky Game\n9.Doctor(Diet Sugestion)\n10.HESCO\n11.Exit");
System.out.print("\nEnter Selection: "); byte frst=ob.nextByte();

if(frst>11||frst<0) { System.out.print("***Invalid Selection***"); } 



//********************************************************************************************
if(frst==1) {
System.out.print("\n****CALCULATOR****\n1.Calculator(Menu)\n2.Calculator(Operator)\n3.Exit");
System.out.print("\nEnter selection: "); byte second=ob.nextByte();

if(second<0||second>3) {System.out.print("**Invalid selection**");}
if(second==1){
System.out.print("\n\n\n1.Addition\n2.Substraction\n3.Multiplication\n4.Division\n5.Remaider\n6.Exit");
System.out.print("\nEnter your Selection: "); int v1=ob.nextInt();

System.out.print("Enter 1st value: "); int a=ob.nextInt();
System.out.print("Enter 2nd value: "); int b=ob.nextInt();

if (v1>6||v1<0) { System.out.print("**Invalid Selection**"); }

if (v1==1){ System.out.println("Addition is : "+(a+b)); }

if (v1==2){ System.out.println("Substraction is: "+(a-b)); }

if (v1==3){ System.out.println("Multiplication is : "+a*b); }  

if(v1==4){ System.out.println("Division is: "+a/b); }

if(v1==5){ System.out.println("Remaider is: "+a%b); }
if(v1==6){ System.out.println("***Good Bye***"); }
}




if(second==2){
System.out.print("Enter operator:  "); char op=ob.next().charAt(0);
if(op!='+'&&op!='-'&&op!='*'&&op!='x'&&op!='X'&&op!='/'&&op!='\\'&&op!='%'){ System.out.print("**Invalid Operator**");  }

if (op=='+'){
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Addition is : "+(a+b)); 
}
 
if (op=='-'){
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("substraction is : "+(a-b)); 
}

if (op=='*'||op=='x'||op=='X'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Multiplication is : "+a*b); 
}

if (op=='/'||op=='\\'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Division is : "+a/b ); 
}

if (op=='%'){ 
System.out.print("Enter 1st value:  ");  int a=ob.nextInt();
System.out.print("Enter 2nd value:  ");  int b=ob.nextInt();
System.out.println("Remainder is : "+a%b); 
}
}


if(second==3){ System.out.print("***Good Bye***"); }
}
//********************************************************************************************
if(frst==2) {
System.out.print("\n\n***UNIT CONVERTER***");
System.out.print("\n1.feet to inch\n2.gram to kilogram\n3.years to days\n4.minutes to hours\n5.Exit");
System.out.print("\nEnter your selection:"); byte second=ob.nextByte();
if(second>5||second<0) { System.out.print("***Invalid Selection***"); }

if(second==1) { System.out.print("\nEnter Feets: "); int feet=ob.nextInt(); int inch=feet*12; System.out.print("Inch will be:"+inch);}

if(second==2) { System.out.print("\nEnter Gram: "); float grams=ob.nextFloat(); float kilo=grams/1000; System.out.print("kilo will be:"+kilo);}

if(second==3) { System.out.print("\nEnter year:"); int year=ob.nextInt(); int days=year*356; System.out.print("days will be:"+days);}

if(second==4) {System.out.print("\nEnter minutes:"); int min=ob.nextInt(); int hour=min/60; System.out.print("Hours will be:"+hour);}

if(second==5) { System.out.print("***Good Bye***"); }

}
//********************************************************************************************
if(frst==3) {
System.out.print("***Age Comparative***");
System.out.print("Enter 1st age: "); int a=ob.nextInt();
System.out.print("Enter 2nd age: "); int b=ob.nextInt();
System.out.print("Enter 3rd age: "); int c=ob.nextInt();

if(a>b && a>c) { System.out.print("1st age is greater...!"); }

if(b>a && b>c) { System.out.print("2nd age is greater...!"); }

if(c>a && c>b) { System.out.print("3rd age is greater...!"); }

if(a==b) { System.out.print("\n1st and 2nd are equal..."); }
if(b==c) { System.out.print("\n2nd and 3rd are equal..."); }
if(a==c) { System.out.print("\n1st and 3rd are equal..."); }
if(a==b&& b==c) { System.out.print("1st ,2nd and 3rd are equal..."); }
}
//********************************************************************************************
if(frst==4) {System.out.print("\nEnter month no 1 to 12: "); int a=ob.nextInt();

if (a==11||a==12||a==1){ System.out.println("Season : Winter"); }

if (a==2||a==3||a==4){ System.out.println("Season : Spring"); }

if (a==5||a==6||a==7){ System.out.println("Season : Summer"); }  

if(a==8||a==9||a==10){ System.out.println("Season : Automn"); }

if(a>12||a<0){ System.out.println("...Invalid Month No..."); }
}
//********************************************************************************************
if(frst==5) {
System.out.print("\n\n\n***Transport Calculation***");
System.out.print("\nEnter Troly load: ");
Double t=ob.nextDouble();
System.out.print("\nEnter recent price of Diesel per litre:");
Double d=ob.nextDouble();

Double total=800*t;
Double driver=150*t;
Double tax=total/10;
Double diesel=2*t*d;
Double profit=total-driver-tax-diesel;

System.out.print("Total Income="+total+"\nDriver="+driver+"\nTax 10%="+tax+"\nDiesel="+diesel+"\nprofit="+profit);}
//********************************************************************************************
if(frst==6) {
System.out.print("\n\n***MARKSHEET***");

System.out.print("\nEnter jam Marks: ");
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
System.out.print("\nYour obatined marks: "+obtain+"\nyour total marks: 500\nYour percentage : "+per+"\nGrade:");

if (per>=90){ System.out.print("'A1'\n ***PASS***"); }
if (per>=80 && per<=89){ System.out.print("'A'\n***PASS***"); }
if (per>=70 && per<=79){ System.out.print("'B'\n***PASS***"); }
if (per>=60 && per<=69){ System.out.print("'C'\n***PASS***"); }
if (per>=50 && per<=59){ System.out.print("'D'\n***PASS***"); }
if (per>=40 && per<=49){ System.out.print("'E'\n***PASS***"); }
if (per<40) { System.out.print("'F'\n***FAIL***"); }
}
//********************************************************************************************
if(frst==7) {
System.out.print("\n\n***ATM (Rupess Conversion)***");
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

//********************************************************************************************
if(frst==8) {
System.out.print("\n\n***Luck Game***");
System.out.print("\nEnter Your Luck no 1 to 20: ");   int a=ob.nextInt();

if(a==5||a==9||a==13||a==19){ 
System.out.println("You Won the game,\nPlease recieve your Prize from Recieptionist."); 
}

else{ 
System.out.println("You lose The Game,\nPlease Recieve Your Return fair from The Receptionist.. "); } 
}



//********************************************************************************************
if(frst==9) {
System.out.print("\n\n\n***Doctor's Advice***");
System.out.print("\nEnter your age: "); short age=ob.nextShort();

if(age>0 && age<=12) { System.out.print("you are a kid..! Take a lolly pop.."); }

if(age>12 && age<=30){ System.out.print("You are young, enjoy your life...!eat chicken, meat etc..");}

if(age>30 && age<=40) { System.out.print("You should avoid to eat oily and sweet...!"); }

if(age>40) { System.out.print("You are aged, eat only jelly..!"); }
}

//********************************************************************************************
if(frst==10){
System.out.print("\n\n***HESCO Bill Calculation System***");
System.out.print("\nEnter Electricity unit? "); int u=ob.nextInt();
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
//********************************************************************************************
if(frst==11){ System.out.print("***Good Bye***"); }

}
}