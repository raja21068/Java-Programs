class TestDemo{
	static int score;
	int feet,inch;
}
class StaticDemo {
public static void main(String arg[]){
	TestDemo ob1=new TestDemo();
	TestDemo ob2=new TestDemo();
	TestDemo.score=500;
	ob1.feet=10;
	ob1.inch=5;
	ob2.feet=100;
	ob2.inch=50;
	System.out.println("ob1.feet"+ob1.feet);
	System.out.println("ob1.inch"+ob1.inch);
	System.out.println("ob2.feet"+ob2.feet);
	System.out.println("ob1.inch"+ob1.inch);
	System.out.println(TestDemo.score);
	System.out.println(ob1.score);
	System.out.println(ob2.score);
	ob1.score+=100;
	System.out.println(ob1.score);
	System.out.println(ob2.score);
	System.out.println(TestDemo.score);
	ob2.score+=100;
	System.out.println(ob1.score);
	System.out.println(ob2.score);
	System.out.println(TestDemo.score);
	TestDemo.score+=100;
	System.out.println(ob1.score);
	System.out.println(ob2.score);
	System.out.println(TestDemo.score);
	
	
}
}
