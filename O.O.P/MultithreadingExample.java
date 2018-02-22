
class A implements Runnable{
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("A Thread: "+i);
			try{Thread.sleep(500);}catch(Exception e){}
		}
		System.out.println("A Thread finished...");
	}//end of run
}
class B implements Runnable{
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println("B Thread: "+i);
			try{Thread.sleep(1000);}catch(Exception e){}
		}
		System.out.println("B Thread finished....");
	} 
}
class MultithreadingExample{
	public static void main(String arg[]){
		A a=new A();
		B b=new B();
		Thread t1=new Thread(a);
		Thread t2=new Thread(b);
		t1.start();
		t2.start();
		for(int i=1;i<=15;i++){
			System.out.println("Main Thread: "+i);
			try{Thread.sleep(1500);}catch(Exception e){}
		}
		System.out.println("Main Thread finished....");
	}
} 