
class Demo extends Thread{
	String name;
	int loop;
	int time;
	Demo(String name , int loop, int time ){
		this.name=name;
		this.loop=loop;
		this.time=time;
		}
	public void run(){
		for(int i=1;i<=loop;i++){
			System.out.println(name+" Thread: "+i);
			try{Thread.sleep(time);}catch(Exception e){}
		}
		System.out.println(name+" Thread finished...");
	}//end of run
}

class MultithreadingExample2{
	public static void main(String arg[]){

		Demo t1=new Demo("A",5,500);
		Demo t2=new Demo("B" , 10 , 1000);
		Demo t3=new Demo("C" , 15 ,  1500);
		t1.start();
		t2.start();
		t3.start();
		Thread t=Thread.currentThread();
		String name=t.getName();
		for(int i=1;i<=20;i++){
			System.out.println(name+" Thread: "+i);
			try{Thread.sleep(2000);}catch(Exception e){}
		}
		System.out.println(name+" Thread finished....");
	}
} 