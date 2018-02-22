class Demo extends Thread{
	int counter;
	public void run(){
		while(true)counter++;
	}
}
class TestThreadPeriority{
	public static void main(String arg[]){
		Demo t1 = new Demo();
		Demo t2 = new Demo();
		Demo t3 = new Demo();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t1.start(); t2.start(); t3.start();
		
		try{Thread.sleep(2000);} catch(InterruptedException e){}
		t1.stop(); t2.stop();  t3.stop();
		System.out.println("first count"+t1.counter);
		System.out.println("second count"+t2.counter);
		System.out.println("third count"+t3.counter);
	}
}