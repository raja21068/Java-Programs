
class Display{
	static void add(Box1 ob){
		System.out.println(ob.feet+ob.inch);}
	static void sub(Box1 ob){
		System.out.println(ob.feet-ob.inch);}
	static void mul(Box1 ob){
		System.out.println(ob.feet*ob.inch);}
}
class Box1{
	int feet;
	int inch;
	Box1(int feet, int inch){
		this.feet=feet;
		this.inch=inch;
	}
	void show(){
		Display.add(this);
		Display.sub(this);
		Display.mul(this);
	}
}
class DemoThisKeyword {
	public static void main(String arg[]){
	Box1 ob1=new Box1(10,5);
	Box1 ob2=new Box1(7,3);
	ob1.show();
	ob2.show();
	Display.add(ob1);
	Display.sub(ob1);
	Display.mul(ob1);
	Display.add(ob2);
	Display.sub(ob2);
	Display.mul(ob2);
	}
	
}
