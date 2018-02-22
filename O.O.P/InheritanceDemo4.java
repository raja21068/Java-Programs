class a{
	int feet,inch;
	a(){ 
		feet=inch=0;
		System.out.println("I am no argument constructor of a.."); }
	a(int len){ 
		feet=inch=len;
		System.out.println("I am one argument constructor of a.."); }
	a(int a,int b){ 
		feet=a;
		inch=b;
		System.out.println("I am two argument constructor of a.."); }
	void show(){
		System.out.println("feet: "+feet);
		System.out.println("inch: "+inch);
	}
	a(a ob){
		feet=ob.feet;
		inch=ob.inch;
	}
}
class b extends a{
	int width;
	b(){ 
		feet=inch=width=0;
		System.out.println("I am no argument constructor of b.."); }
	b(int len){ 
		feet=inch=len;
		System.out.println("I am one argument constructor of b.."); }
	b(int a,int b,int c){ 
		feet=a;
		inch=b;
		width=c;
		System.out.println("I am three argument constructor of b.."); }
	void show(){
		System.out.println("feet: "+feet);
		System.out.println("inch: "+inch);
		System.out.println("width: "+width);
	}
	b(b ob){
		feet=ob.feet;
		inch=ob.inch;
		width=ob.width;
	}
}

 class c extends b{
	int height;
	c(){ 
		feet=inch=width=height=0;
		System.out.println("I am no argument constructor of c.."); }
	c(int len){ 
		feet=inch=width=height=len;
		System.out.println("I am one argument constructor of c.."); }
	c(int a,int b,int c, int d){ 
		feet=a;
		inch=b;
		width=c;
		height=d;
		System.out.println("I am three argument constructor of c.."); }
	void show(){
		System.out.println("feet: "+feet);
		System.out.println("inch: "+inch);
		System.out.println("width: "+width);
		System.out.println("height: "+height);
	}
	c(c ob){
		feet=ob.feet;
		inch=ob.inch;
		width=ob.width;
		height=ob.height;
	}
}
 
public class InheritanceDemo4 {
	public static void main(String arg[]){
		c ob1=new c();
		c ob2=new c(10);
		c ob3=new c(100,200,300,400);
		c ob4=new c(ob3);
		ob1.show();
		ob2.show();
		ob3.show();
		ob4.show();
	}

}
