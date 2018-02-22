class Box2{
	int feet;
	int inch;
	Box2(int a,int b){
		feet=a;
		inch=b;
	}
	void add(Box2 ob){
		System.out.println(feet+ob.feet);
		System.out.println(inch+ob.inch);
	}
	void add(Box2 ob1,Box2 ob2){
		System.out.println(feet+ob1.feet+ob2.feet);
		System.out.println(inch+ob1.inch+ob2.inch);
	}
	void sub(Box2 ob){
		System.out.println(feet-ob.feet);
		System.out.println(inch-ob.inch);
	}
	void sub(Box2 ob1,Box2 ob2){
		System.out.println(feet-ob1.feet-ob2.feet);
		System.out.println(inch-ob1.inch-ob2.inch);
	}
	void mul(Box2 ob){
		System.out.println(feet*ob.feet);
		System.out.println(inch*ob.inch);
	}
	void mul(Box2 ob1,Box2 ob2){
		System.out.println(feet*ob1.feet*ob2.feet);
		System.out.println(inch*ob1.inch*ob2.inch);
	}
	void div(Box2 ob){
		System.out.println(feet/ob.feet);
		System.out.println(inch/ob.inch);
	}
	void div(Box2 ob1,Box2 ob2){
		System.out.println(feet/ob1.feet/ob2.feet);
		System.out.println(inch/ob1.inch/ob2.inch);
	}
	
}//end of class box2
public class ObjPassAsArg2 {
	public static void main(String arg[]) {
		Box2 ob1=new Box2(10,5);
		Box2 ob2=new Box2(100,50);
		Box2 ob3=new Box2(1000,500);
		ob1.add(ob2);
		ob1.add(ob2, ob3);
		ob3.add(ob1, ob1);
		ob3.add(ob3, ob3);
		ob3.add(ob3);
	}

}
