class Box2{
	int feet;
	int inch;
	void add(Rectangle r){
	r.add(this);	
	}
	void mul(Rectangle r){
		System.out.println(r.width+r.height);
	}
}//end of class

class Rectangle{
	int width,height;
	void add(Box2 ob){
		ob.mul(this);
	}
}

class ThisTest {

	public static void main(String[] args) {
		Box2 ob1=new Box2();
		Box2 ob2=new Box2();
		Rectangle r1=new Rectangle();
		Rectangle r2=new Rectangle();
		ob1.feet=10;
		ob1.inch=5;
		ob2.feet=7;
		ob2.inch=3;
		r1.height=20;
		r1.width=10;
		r2.height=5;
		r2.width=3;
		ob1.add(r1);
		ob1.add(r2);
		ob2.add(r1);
		ob2.add(r2);
	}

}
