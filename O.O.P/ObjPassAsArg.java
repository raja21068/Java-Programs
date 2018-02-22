
class Box1{
	int feet;
	int inch;
	
	Box1(int a,int b){
		feet=a;
		inch=b;
	}
	void show(){
		System.out.println("Feet:"+feet);
		System.out.println("inch:"+inch);
	}//end of method show
}//end of class Box

class Display{
	static void add(Box1 ob1,Box1 ob2){
		System.out.println("Addition of feets: "+(ob1.feet+ob2.feet));
		System.out.println("Addition of inches: "+(ob1.inch+ob2.inch));
	}//addition
	static void sub(Box1 ob1,Box1 ob2){
		System.out.println("Subtraction of feets: "+(ob1.feet-ob2.feet));
		System.out.println("Subtraction of inches: "+(ob1.inch-ob2.inch));
	}//Subtraction
	static void mul(Box1 ob1,Box1 ob2){
		System.out.println("multiplication of feets: "+(ob1.feet*ob2.feet));
		System.out.println("multiplication of inches: "+(ob1.inch*ob2.inch));
	}//multiplication
	static void div(Box1 ob1,Box1 ob2){
		System.out.println("division of feets: "+(ob1.feet/ob2.feet));
		System.out.println("division of inches: "+(ob1.inch/ob2.inch));
	}//division
	static void rem(Box1 ob1,Box1 ob2){
		System.out.println("Remainder of feets: "+(ob1.feet%ob2.feet));
		System.out.println("Remainder of inches: "+(ob1.inch%ob2.inch));
	}//Remainder
	static void sqr(Box1 ob1){
		System.out.println("Square of feets: "+(ob1.feet*ob1.feet));
		System.out.println("Square of inches: "+(ob1.inch*ob1.inch));
	}//Subtraction
}//end of class display

class ObjPassAsArg {

	public static void main(String arg[]){
		Box1 ob1=new Box1(10,5);
		Box1 ob2=new Box1(100,50);
		Box1 ob3=new Box1(1000,500);
		Display.add(ob1, ob2);
		Display.sub(ob2, ob3);
		Display.mul(ob1, ob3);
		Display.div(ob3, ob2);
		Display.rem(ob2, ob1);
		Display.sqr(ob1);
	}//end of main method
}//end of class objpassAsArg
