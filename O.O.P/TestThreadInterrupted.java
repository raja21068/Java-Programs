class Demo extends Thread{
	static int c=0;
	public void run(){
		try{
			do{
				System.out.println(getName()+ ":"+ c++);
				Thread.sleep(100);
				}while(true);
				}//end of try
		catch(InterruptedException e){}
		System.out.println(getName()+" Thread finishes");	
	}
}
class TestThreadInterrupted{
	public static void main(String arg[]) throws Exception{
		Demo t1 = new Demo();
		Demo t2 = new Demo();
		
		t1.setName("A");
		t2.setName("B");
		t1.start(); t2.start();
		
		try{Thread.sleep(5000);} catch(InterruptedException e){}
		t1.interrupt();
		try{Thread.sleep(2000);} catch(InterruptedException e){}
		t2.interrupt();
		
		System.out.println(Thread.currentThread().getName()+" Thread finishes....");
	}
}