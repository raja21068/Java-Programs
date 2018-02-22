import java.util.*;

class invalid{
	invalid(){
		System.out.println("Invalid Selection");
	}
	void bye(){
		System.out.println("**Good Bye**");
	}
}	
class Cal{
	Cal(){
		Scanner ob=new Scanner(System.in);
		System.out.print("\n****CALCULATOR****\n1.Calculator(Menu)\n2.Calculator(Operator)\n3.Exit");
		System.out.print("\nEnter selection: "); byte second=ob.nextByte();

		
		if(second==1){new MenuCalculator().input();}
		else if(second==2){ new OperatCalc().Input();  }
		
		else if(second==3){ new invalid().bye(); }
		else { new invalid(); }
	}
}
class MenuCalculator {
	void input(){
		Scanner ob=new Scanner(System.in);
		System.out.print("1.Addition\n2.Substraction\n3.Multiplication\n4.Division\n5.Reaminder\n6.Exit\nEnter Selection");
		int sel=ob.nextInt();
		if(sel==1){ addition(); }
		else if(sel==2) { subs(); }
		else if(sel==3) { multi(); }
		else if(sel==4) { division();}
		else if(sel==5) { remain(); }
		else if(sel==6) { new invalid().bye(); }
		else{ new invalid(); }
	}
	void addition(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int a=ob.nextInt();
		System.out.print("Enter 2st value: ");
		int b=ob.nextInt();
		System.out.println("Addition is: "+(a+b));
	}
	void subs(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int a=ob.nextInt();
		System.out.print("Enter 2st value: ");
		int b=ob.nextInt();
		System.out.println("Substraction is: "+(a-b));
	}
	void multi(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int a=ob.nextInt();
		System.out.print("Enter 2st value: ");
		int b=ob.nextInt();
		System.out.println("Multiplication is: "+(a*b));
	}
	void division(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int a=ob.nextInt();
		System.out.print("Enter 2st value: ");
		int b=ob.nextInt();
		System.out.println("Division is: "+(a/b));
	}
	void remain(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int a=ob.nextInt();
		System.out.print("Enter 2st value: ");
		int b=ob.nextInt();
		System.out.println("Remainder is: "+(a%b));
	}
}//end of menuCalcultor***************************************************************
class OperatCalc{
	void Input(){
		Scanner ob=new Scanner(System.in);
		System.out.print("Enter operator: ");
		char ch=ob.next().charAt(0);
			switch(ch){
			case '+': new MenuCalculator().addition(); break;
			case '-':	new MenuCalculator().subs(); break;
			case 'x':
			case 'X':
			case '*': new MenuCalculator().multi(); break;
			case '/':
			case '\\':new MenuCalculator().division(); break;
			case '%':new MenuCalculator().remain(); break;
			default: System.out.println("**Inavlid Operator**");
			}
		
	}}//end of operator calculator
//************************************************************************************
class Converter{
	
	Converter(){
		Scanner ob=new Scanner(System.in);
		System.out.print("\n\n***UNIT CONVERTER***");
		System.out.print("\n1.length\n2.Temp\n3.weight\n4.Exit");
		System.out.print("\nEnter your selection:"); byte sel=ob.nextByte();
		if(sel==1){ System.out.println("\n***LENGTH***\n1.centimeter into inch\n2.feet to inch\n3.inch to cm\n4.inch to feet\n5.km into m\n6.exit");
					System.out.print("Enter selection");
					int s2=ob.nextInt();
					if(s2==1){ cmtoinch(); }
					else if(s2==2){ ftoinch(); }
					else if(s2==3){ intocm(); }
					else if(s2==4){ intofeet(); }
					else if(s2==5){ kmtom();  }
					else if(s2==6){ new invalid().bye();}
					else { new invalid(); }
		}//end of length 
		
		else if(sel==2){
			System.out.println("**Temperature**\n1.c to F\n2.K to F\n3.C to k\n4.exit");
			System.out.print("Enter selection: "); int s3=ob.nextInt();
			if(s3==1){ centitof(); }
			else if(s3==2){ ktof(); }
			else if(s3==3){ ctok(); }
			else if(s3==4){ new invalid().bye(); }
			else { new invalid(); }
		}//end of temp
		
		else if(sel==3){ System.out.print("\n**Weight**\n1.Carat to gram\n2.grams to kilogram\n3.kilograms to stone\n4.Exit");
		System.out.print("Enter selection: ");
		int s4=ob.nextInt();
		if(s4==1){ carattogm(); }
		else if(s4==2){ gmtokilo(); }
		else if(s4==3){ kilotostn();}
		else if(s4==4){}
		else { new invalid(); }
		}//end of wieght
		else if(sel==4){ }//exit
		else { new invalid(); }
	}//end of constructor
	
	void cmtoinch(){
		Scanner obj=new Scanner(System.in);
		System.out.print("enter centimeter: "); int cm=obj.nextInt();
		System.out.println("Inches will be: "+(cm/2.54));
	}//end of centimeter into inch

	void ftoinch(){
		Scanner obj=new Scanner(System.in);
		System.out.print("enter feets: "); int feet=obj.nextInt();
		System.out.println("Inches will be: "+(feet*12));
	}//end of feet into inch
	
	void intocm(){
		Scanner obj=new Scanner(System.in);
		System.out.print("enter inch: "); int inch=obj.nextInt();
		System.out.println("centimeter will be: "+(inch*2.54));
	}//end of inch into centimeter
	
	void intofeet(){
		Scanner obj=new Scanner(System.in);
		System.out.print("enter inches: "); int inch=obj.nextInt();
		System.out.println("feet will be: "+(inch/12));
	}//end of inch to feet
	
	void kmtom(){
		Scanner obj=new Scanner(System.in);
		System.out.print("enter kilometer: "); int km=obj.nextInt();
		System.out.println("meter will be: "+(km*1000));
	}
	
	void centitof(){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter centigrade: "); int c=obj.nextInt();
		System.out.println("fehrenheit will be: "+((c+32)*180)/100);
	}//end of centigrade to fahrenheit

	void ktof(){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter Kelvin: "); int k=obj.nextInt();
		int c=k-274;
		System.out.println("fehrenheit will be: "+((c+32)*180)/100);	
	}
	void ctok(){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter centigrade: "); int c=obj.nextInt();
		System.out.println("kelvin will be: "+(c+274));	
	}
	void carattogm(){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter carat: "); int c=obj.nextInt();
		System.out.println("grams will be: "+(c*0.2));		
	}
	void gmtokilo(){
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter Grams: "); int g=obj.nextInt();
		System.out.println("kilo will be: "+(g/1000));	
	}
	void kilotostn(){
		Scanner obj=new Scanner(System.in);
		System.out.print("kilo Grams: "); int k=obj.nextInt();
		System.out.println("stone will be: "+(k*0.1574));
	}																		  //****
}//end of class converter														****
//**********************************************************************************
class Age{
	Age(){
		Scanner ob=new Scanner(System.in);
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
}//end of age*****************************************************************
//******************************************************************************
class Season{
	Season(){
	Scanner ob=new Scanner(System.in);	
	System.out.print("\nEnter month no 1 to 12: "); int a=ob.nextInt();

	if (a==11||a==12||a==1){ System.out.println("Season : Winter"); }

	if (a==2||a==3||a==4){ System.out.println("Season : Spring"); }

	if (a==5||a==6||a==7){ System.out.println("Season : Summer"); }  

	if(a==8||a==9||a==10){ System.out.println("Season : Automn"); }

	if(a>12||a<0){ System.out.println("...Invalid Month No..."); }
	}
}//end of season*************************************************************
//*******************************************************************************
class Troaly{
	Troaly(){
		Scanner ob=new Scanner(System.in);
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

		System.out.print("Total Income="+total+"\nDriver="+driver+"\nTax 10%="+tax+"\nDiesel="+diesel+"\nprofit="+profit);
			
	}
}//end of Troaly********************************************************************
//***********************************************************************************
class Marksh{
	Marksh(){
		Scanner ob=new Scanner(System.in);
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
}
//******************************************************************************
class Atm{
	Atm(){
		Scanner ob=new Scanner(System.in);
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
}//end of atm
//************************************************************************************
class Luck{
	Luck(){
		Scanner ob=new Scanner(System.in);
		System.out.print("\n\n***Luck Game***");
		System.out.print("\nEnter Your Luck no 1 to 20: ");   int a=ob.nextInt();

		if(a==5||a==9||a==13||a==19){ 
		System.out.println("You Won the game,\nPlease recieve your Prize from Recieptionist."); 
		}

		else{ 
		System.out.println("You lose The Game,\nPlease Recieve Your Return fair from The Receptionist.. "); } 
			
	}
}//END OF LUCK
//************************************************************************************
class Doctor{
	Doctor(){
		Scanner ob=new Scanner(System.in);
		System.out.print("\n\n\n***Doctor's Advice***");
		System.out.print("\nEnter your age: "); short age=ob.nextShort();

		if(age>0 && age<=12) { System.out.print("you are a kid..! Take a lolly pop.."); }

		if(age>12 && age<=30){ System.out.print("You are young, enjoy your life...!eat chicken, meat etc..");}

		if(age>30 && age<=40) { System.out.print("You should avoid to eat oily and sweet...!"); }

		if(age>40) { System.out.print("You are aged, eat only jelly..!"); }
			
	}
}//End of Doctor
//*********************************************************************************
class HescoBill{
	HescoBill(){
		Scanner ob=new Scanner(System.in);
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
}

class MiniProject {
	public static void main(String arg[]){

		Scanner ob=new Scanner(System.in);
		System.out.print("1.Calculator\n2.Unit Converter\n3.Age Calculator\n4.Season\n5.Trolyload\n6.Marksheet\n7.ATM(Rupees conversion)\n8.Lucky Game\n9.Doctor(Diet Sugestion)\n10.HESCO\n11.Exit");
		System.out.print("\nEnter Selection: "); int frst=ob.nextByte();

 
		switch(frst){
		
		case 1: new Cal(); break;
		
		case 2: new Converter(); break;
		
		case 3: new Age(); break;
		
		case 4: new Season(); break;
		
		case 5: new Troaly(); break;
		
		case 6:	new Marksh(); break;
	
		case 7:	new Atm(); break;
		
		case 8:	new Luck(); break;

		case 9:	new Doctor(); break;
		
		case 10:new HescoBill(); break;
		
		case 11: new invalid().bye(); ;break; 
		
		default: new invalid();

		}//end of switch
		}
        }
