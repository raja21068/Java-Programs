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

class TestThreadJoin{
	public static void main(String arg[]){
		Test t1 = new Test("A" , 5, 500);
		Test t2 = new Test("B" , 10, 1000);
		t1.start();
		t2.start();
		System.out.println(t1.getName()+" : " +t1.isAlive());
		System.out.println(t2.getName()+" : " +t2.isAlive());
		System.out.println("Main Thread waithing...");
		try{ t1.join(); }catch(Exception e){}
		System.out.println(t1.getName()+" : " +t1.isAlive());
		System.out.println(t2.getName()+" : " +t2.isAlive());
		System.out.println("Main Thread waithing...");
		try{ t2.join(); }catch(Exception e){}
		System.out.println(t1.getName()+" : " +t1.isAlive());
		System.out.println(t2.getName()+" : " +t2.isAlive());
	}
}