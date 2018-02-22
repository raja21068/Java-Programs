

class OuterClass {

	int a,b;
	OuterClass(int a,int b){
		this.a=a;
		this.b=b;
	}
	void show(){
		System.out.println(a);
		System.out.println(b);
	}
	class InnerClass{
		int x,y;
		InnerClass(int a, int b){
			x=a;
			y=b;
		}
		void show(){
			System.out.println(x);
			System.out.println(y);
			System.out.println(a);
			System.out.println(b);
		}
	}
}
class InnerClassDemo{
	public static void main(String arg[]){
	OuterClass ob=new OuterClass(22,33);
	OuterClass.InnerClass hello=ob.new InnerClass(98,76);
	}
}