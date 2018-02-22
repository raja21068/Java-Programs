class Test extends Thread{
	int loop;
	int time;
	Test(String name, int loop, int time){
		super(name);
		this.loop=loop;
		this.time=time;
	}

	public void run(){
		for(int i = 1 ; i <= loop; i++){
			System.out.println(getName()+" Thread "+i);
			try{ Thread.sleep(time); }catch(Exception e){}
		}
		System.out.println(getName()+" Thread finishes...");
	}
}

class TestDeamonThread{
	public static void main(String arg[]){
		Test t1 = new Test("A" , 5, 500);
		Test t2 = new Test("B" , 10, 1000);
		Test t3 = new Test("C" , 15, 1500);
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();
		try{ Thread.sleep(2000); }catch(Exception e){}
		Thread t=Thread.currentThread();
		String name = t.getName();
		System.out.println(name+" Thread finishes...");
		
	}
}