
class contructorDemo {





	public static void main(String[] args) {
		Box3 ob1=new Box3();
		Box3 ob2=new Box3(10);
		Box3 ob3=new Box3(100,200);
		ob1.show();
		ob2.show();
		ob3.show();
		ob1.set(100, 50);
		ob2.set(50, 60);
		ob3.set(90, 70);
		ob1.show();
		ob2.show();
		ob3.show();
		ob2.set(10,50);
		ob2.show();
	}

}
class Box3{
	int feet=0;
	int inch=0;
	Box3(){
		System.out.println("i am no argument constructor");
	}
	Box3(int a){
		feet=inch=a;
		System.out.println("i am one argument constructor");
	}
	Box3(int a,int b){
		feet=a;
		inch=b;
		System.out.println("i am two argument Constructor ");
	}
	void set(int a,int b){
		feet=a;
		inch=b;
	}
	void show(){
		System.out.println("Feet: "+feet);
		System.out.println("Inch: "+inch);
		}
}
