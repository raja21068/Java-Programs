
class Box{
	int feet;
	int inch;
	Box(int feet, int inch){
		this.feet=feet;
		this.inch=inch;
	}
	void show(){
		System.out.println("Feet: "+feet);
		System.out.println("inch: "+inch);
			}//end of show
}//end of class
class DemoThis {
	public static void main(String arg[]){
		Box ob1=new Box(10,5);
		Box ob2=new Box(7,3);
		ob1.show();
		ob2.show();
	}

}
