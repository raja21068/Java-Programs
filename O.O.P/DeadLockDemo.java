class Boo{
	synchronized void first(Foo f)
	{
		System.out.println("First() method of Boo");
		try{ Thread.sleep(1000); }catch(Exception e){}
		f.last();
	}
	synchronized void last()
	{
		System.out.println("Last() method of Boo");
	}
}

class Foo{
synchronized void first(Boo b)
	{
		System.out.println("First() method of Foo");
		try{ Thread.sleep(1000); }catch(Exception e){}
		b.last();
	}
	synchronized void last()
	{
		System.out.println("Last() method of Foo");
	}
}
class A extends Thread{
	Boo b;
	Foo f;
	A(Boo b , Foo f)
	{
		this.b = b;
		this.f = f;
	}
	public void run()
	{
		b.first(f);
	}
}
class B extends Thread{
	Boo b;
	Foo f;
	B(Boo b , Foo f)
	{
		this.b = b;
		this.f = f;
	}
	public void run()
	{
		f.first(b);
	}
}
class DeadLockDemo{
	public static void main(String arg[]){
		Boo b = new Boo();
		Foo f = new Foo();
		A t1 = new A(b,f);
		B t2 = new B(b,f);
		t1.start();
		t2.start();
	}
}