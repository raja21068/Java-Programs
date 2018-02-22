
  class apple{
	private int feet,inch;
	apple(){ 
		feet=inch=0;
		System.out.println("I am no argument constructor of a.."); }
	apple(int len){ 
		feet=inch=len;
		System.out.println("I am one argument constructor of a.."); }
	apple(int a,int b){ 
		feet=a;
		inch=b;
		System.out.println("I am two argument constructor of a.."); }
	void show(){
		System.out.println("feet: "+feet);
		System.out.println("inch: "+inch);
	}
	apple(apple ob){
		feet=ob.feet;
		inch=ob.inch;
	}
}
class banana extends apple{
	private int width;
	banana(){ 
		width=0;
		System.out.println("I am no argument constructor of b.."); }
	banana(int len){ 
		super(len);
		width=len;
		System.out.println("I am one argument constructor of b.."); }
	banana(int a,int b,int c){ 
		super(a,b);
		width=c;
		System.out.println("I am three argument constructor of b.."); }
	void show(){
		super.show();
		System.out.println("width: "+width);
	}
	banana(banana ob){
		super(ob);
		width=ob.width;
	}
}

 class cat extends banana{
	private int height;
	cat(){ 
		height=0;
		System.out.println("I am no argument constructor of c.."); }
	cat(int len){ 
		super(len);
		height=len;
		System.out.println("I am one argument constructor of c.."); }
	cat(int a,int b,int c, int d){ 
		super(a,b,c);
		height=d;
		System.out.println("I am Four argument constructor of c.."); }
	void show(){
		super.show();
		System.out.println("height: "+height);
	}
	cat(cat ob){
		super(ob);
		height=ob.height;
	}
}
class InheritanceDemo5 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat ob1=new cat();
		cat ob2=new cat(10);
		cat ob3=new cat(100,200,300,400);
		cat ob4=new cat(ob3);
		
		ob1.show();
		ob2.show();
		ob3.show();
		ob4.show();

	}

}
