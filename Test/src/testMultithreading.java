
public class testMultithreading {

	public static void main(String arg[]){
		
		DispThread dt1=new DispThread("hello");
		DispThread dt2=new DispThread("world");
		dt1.start();
		dt2.start();
	}
}

class DispThread extends Thread{
	String msg;
	public void run(){
		
		for(int i=0;i<100;i++){
			try{Thread.sleep(100);
			System.out.println(msg);
			}catch(Exception e){}
			}
	}//end of run
	DispThread(String m){
		msg=m;
	}
}