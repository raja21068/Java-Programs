import java.util.*;
class ReturnMethod{
	boolean isEven(int num){
		boolean b=false;
		if(num%2==0){ b=true; }
		return b;
	}

	boolean isPositive(int num){
		boolean b=false;
		if(num>=0){ b=!b; }
		return b;
	}
	
	int factorial(int num){
	int f=1;
		for(int i=num;i>0;i--){ f*=i;  }	
	return f;
	}
	
	boolean isPrime(int num){
		boolean b=true;
		for(int i=1;i<num;i++){
			if(num%2==0){
				b=false;}
		}
		return b;
	}
	
	int sqr(int num){
		return num*num;
	}
	
	int cube(int num){
		return num*num*num;
	}
	
	long power(int base,int power){
		long p=base;
		for(int i=1;i<power;i++){
			p*=base;
		}
		return p;
	}	




	public static void main(String arg[]){
	Scanner ob=new Scanner(System.in);
	System.out.println("\n1.EVEN\n2.POSITIVE\n3.FACTORIAL\n4.SQUARE\n5.CUBE\n6.PRIME\n7.POWER");
	System.out.print("Enter Selection:");
	int sel=ob.nextInt();
	System.out.print("Enter number: ");
	int num=ob.nextInt();
	ReturnMethod obj=new ReturnMethod();
	switch(sel){
	
	case 1: if(obj.isEven(num)){ System.out.println("Even"); }
				else{ System.out.println("Odd"); }break;
	case 2: if(obj.isPositive(num)){ System.out.println("Positive"); }
				else{ System.out.println("Negative"); }break;
	case 3: int f=obj.factorial(num);
			System.out.println("Factorial: "+f);break;
	case 4: System.out.println("Sqaure:" +obj.sqr(num));break;
	case 5: System.out.println("Sqaure:" +obj.cube(num));break;
	case 6: if(obj.isPrime(num)){ System.out.println("Prime"); }
	else{ System.out.println("Not Prime"); } break;
	case 7: System.out.print("Enter Power: ");
			int p=ob.nextInt();
			long c=obj.power(num, p);
			System.out.println("Pow:"+c);break;
			default: System.out.println("**Invalid choice**");
	}
	}}//end of methods class
