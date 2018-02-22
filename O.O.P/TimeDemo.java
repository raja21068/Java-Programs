import java.util.*;
import java.awt.*;
class TimeDemo extends Frame{
	
	Label a,b,c,d;
	TimeDemo(){
		setLayout(null);
		setBounds(0,0,500,500);
		a=new Label();
		b=new Label();
		c=new Label();
		d=new Label();
		a.setBounds(40,40,40,40);
		b.setBounds(80,40,40,40);
		c.setBounds(120,40,40,40);
		d.setBounds(60,180,180,40);
		add(a);
		add(b);
		add(c);
		add(d);
		while(3<4){
			try{ Thread.sleep(1000); }catch(Exception e){}
			Date ob1=new Date();
			a.setText(""+ob1.getHours());
			b.setText(""+ob1.getMinutes()+".");
			c.setText(""+ob1.getSeconds()+".");
			System.out.println(ob1.toLocaleString());
			d.setText(ob1.toLocaleString());
			show();
		}
		//try {time();}catch(Exception e){}
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	void time()throws Exception{
		while(3<4){
			Thread.sleep(1000);
			//a.setText(""+ob1.SECOND);
			//b.setText(""+ob1.MINUTE);
			//c.setText(""+ob1.HOUR);
			show();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TimeDemo();
		

	}

}
