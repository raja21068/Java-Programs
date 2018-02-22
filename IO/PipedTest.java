import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.Random;

class NumGen extends Thread{
	DataOutputStream dos;
	NumGen(PipedOutputStream pos){
		try{
		dos = new DataOutputStream(pos);
		}catch(Exception e){}
	}
	public void run(){
		Random ran =new Random();
		double d;
		for(int i=0;i<10;i++){
			try{
			d= ran.nextDouble()*1000;
			dos.writeDouble(d);
			dos.flush();
			}catch(Exception e){}
			
		}
	}
}

class RunAver extends Thread{
	DataInputStream dis;
	RunAver(PipedInputStream pis){
		dis = new DataInputStream(pis);
	}
	public void run(){
		for(int i=0;i<10;i++){
			try{
				double d=dis.readDouble();
				System.out.println(d);
			}catch(Exception e){}
		}
	}
}
public class PipedTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		PipedOutputStream pos=new PipedOutputStream();;
		PipedInputStream pis = new PipedInputStream(pos);
		
		NumGen no= new NumGen(pos);
		RunAver run = new RunAver(pis);
		
		no.start();
		run.start();
		}catch(Exception e){}
		}

}
