class Marks
{
	int a,b,c,d,e;
	
	Marks(int a, int b, int c, int d, int e)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}
	
	void claculate()
	{
		Calculate.obtain(this);
	}
}

class Calculate
{
	static void obtain(Marks m)
	{
		per(m.a + m.b + m.c + m.d + m.e);
	}
	
	static void per(int marks)
	{
		//char g = Grade.grade();
	}
}

public class DemoThis1 {

}
