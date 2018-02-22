
class Box5{
	int feet,inch;
	Box5(int a,int b){
		feet=a;
		inch=b;
	}
	class Rectangle3{
		int width,height;
		Rectangle3(int a,int b){
			width=a;
			height=b;
		}
		void show(){
			System.out.println(feet);
			System.out.println(inch);
			System.out.println(width);
			System.out.println(height);
		}
	}//end of rectangle class
}//end of box class
class classNestedDemo2 {
	public static void main(String[] args) {
		Box5 ob1=new Box5(100,50);
		Box5 ob2=new Box5(200,400);
		Box5.Rectangle3 r1=ob1.new Rectangle3(20,30);
		Box5.Rectangle3 r2=ob2.new Rectangle3(50,60);
		Box5.Rectangle3 r3=ob1.new Rectangle3(10,15);
		Box5.Rectangle3 r4=ob2.new Rectangle3(90,80);
		r1.show();
		r2.show();
		r3.show();
		r4.show();
	}

}
