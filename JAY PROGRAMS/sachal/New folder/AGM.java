import java.util.Scanner;

class Math{

int a,b;
	void add(){
		Scanner call = new Scanner(System.in);
		
		System.out.print("Enter the 1st value:");
		a = call.nextInt();
		
		System.out.print("Enter the 1st value:");
		b = call.nextInt();

		System.out.println("Additoin of " +a +" and "+ +b +" is "+ +(a+b));
		System.out.println();

	}

	void sub(){
		Scanner call = new Scanner(System.in);
			
		System.out.print("Enter the 1st value:");
		a = call.nextInt();
		
		System.out.print("Enter the 1st value:");
		b = call.nextInt();

		System.out.println("Subtraction of " +a +" and "+ +b +" is "+ +(a-b));
		System.out.println();
	}

	void div(){
		Scanner call = new Scanner(System.in);
		
		System.out.print("Enter the 1st value:");
		a = call.nextInt();
		
		System.out.print("Enter the 1st value:");
		b = call.nextInt();

		System.out.println("Division of " +a +" and "+ +b +" is "+ +(a/b));
		System.out.println();
	}

	void mul(){
		Scanner call = new Scanner(System.in);
		
		System.out.print("Enter the 1st value:");
		a = call.nextInt();
		
		System.out.print("Enter the 1st value:");
		b = call.nextInt();

		System.out.println("Multiplication of " +a +" and "+ +b +" is "+ +(a*b));
		System.out.println();
	}

	void rem(){
		Scanner call = new Scanner(System.in);
		
		System.out.print("Enter the 1st value:");
		a = call.nextInt();
		
		System.out.print("Enter the 1st value:");
		b = call.nextInt();

		System.out.println("Remainder of " +a +" and "+ +b +" is "+ +(a%b));
		System.out.println();
	}


}



class caller extends Math{

	void call(){
		Scanner input = new Scanner(System.in);
		
		
		for(;;) {	
			System.out.println();
			System.out.println("Hit 0 for Quit");
			System.out.println("Hit 1 for Addition");
			System.out.println("Hit 2 for Subtraction");
			System.out.println("Hit 3 for Division");
			System.out.println("Hit 4 for Multiplication");
			System.out.println("Hit 5 for Remainder");
			System.out.print("Enter your Choice:");
			int in = input.nextInt();
		
	
			if(in == 0){
				break;
	
			}
			
		
		switch (in){
			case 1:
				add();
				break;
			case 2:
				sub();
				break;
			case 3:
				div();
				break;
			case 4:
				mul();
				break;
			case 5:
				rem();
				break;
			default:
				System.out.println("Wrong Choise");
				System.out.prinln();
				

			}
		}	

	}
}


class AGM{

	public static void main(String[] args){
	caller ob = new caller();
	ob.call();

}	

}