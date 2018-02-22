
class Box4{
	int feet,inch;
	Rectangle2 r1=new Rectangle2(50,60);
	Rectangle2 r2=new Rectangle2(70,90);
	Box4(int a,int b){
		feet=a;
		inch=b;
	}
	class Rectangle2{
		int width,height;
		Rectangle2(int a,int b){
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

class classNestedDemo {
	public static void main(String[] args) {

		Box4 ob1=new Box4(10,5);
		Box4 ob2=new Box4(100,500);
		ob1.r1.show();
		ob1.r2.show();
		ob2.r1.show();
		ob1.r2.show();
		
	}

}
