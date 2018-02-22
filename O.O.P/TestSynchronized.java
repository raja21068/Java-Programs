class Bank{
	int amount = 5000;
	synchronized void increament(){
		amount += 1000;
		try{
		Thread.sleep(1000);
		}catch(Exception e){}
		System.out.println("Amount :"+amount);
		amount += 6000;
		try{Thread.sleep(2000);}catch(Exception e){}
		System.out.println("Amount :"+amount);
	}
	synchronized void decreament(){
		amount -= 1000;
		try{
		Thread.sleep(1000);
		}catch(Exception e){}
		System.out.println("Amount :"+amount);
		amount -= 6000;
		try{
		Thread.sleep(2000);
		}catch(Exception e){}
		System.out.println("Amount :"+amount);
	}
}//end of bank

class A extends Thread{
	Bank b;
	A(Bank b){
		this.b = b;
	}
	public void run(){
		b.increament();
	}
}//end of class A

class B extends Thread{
	Bank b;
	B(Bank b){
	this.b= b;
	}
	public void run(){
		b.increament();
	}
}//end of class B

class TestSynchronized{
	public static void main(String arg[]){
		Bank b = new Bank();
		A t1 = new A(b);
		B t2 =new B(b);
		t1.start();
		t2.start();
	}
}