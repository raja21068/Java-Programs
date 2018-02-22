import java.awt.*;
import javax.swing.*;

public class clock {
	
	public static void main(String[] args)throws Exception {
		JFrame win=new JFrame();
		int s=0;
		int m=0;
		int h=0;
		JLabel sec=new JLabel();
		JLabel min=new JLabel();
		JLabel hour=new JLabel();
		Container con=win.getContentPane();
		con.setLayout(null);
		win.setBounds(0,0,300,300);
		sec.setBounds(90,40,20,20);
		min.setBounds(60,40,20,20);
		hour.setBounds(30,40,20,20);
		sec.setText(""+s);
		min.setText(""+m);
		hour.setText(""+h);
		
		con.add(sec);
		con.add(min);
		con.add(hour);
		win.show();
	for(s=0;s<61;s++){
		sec.setText(""+s);
		min.setText(""+m);
		hour.setText(""+h);
		Thread.sleep(1000);
		if(s==59){ s=-1; m++; }
		if(m==60){ m=0; h++; }
	}
	
	}

}
