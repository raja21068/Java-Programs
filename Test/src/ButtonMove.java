import javax.swing.*;
import java.awt.event.*;

class ButtonMove extends Thread implements ActionListener{
	JButton demo;
	JButton start;
	JFrame frame;
	static int move=1;
	
	ButtonMove(){
		frame = new JFrame("");
		frame.setBounds(40,40,600,700);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(3);
		frame.show();
		
		demo = new JButton("Demo");
		start = new JButton("Start");
		frame.getContentPane().add(demo);
		frame.getContentPane().add(start);
		demo.setBounds(0, 0, 100, 100);
		start.setBounds(frame.getWidth()/2,150, 100,100);
		start.addActionListener(this);
	}
	
	public void run(){
		while(true){
			if(move==1)
			{for(int i=demo.getX();i<(frame.getWidth()-demo.getWidth()-20);i++ ){
			demo.setBounds(i,demo.getY(),100,100);
			frame.show();
			try{ sleep(10); }catch(Exception e){}	
			}move=2;
			}//end of if 
			if( move==2){
				for(int i=demo.getY();i<(frame.getHeight()-demo.getHeight()-20);i++ ){
					demo.setBounds(demo.getX(),i,100,100);
					frame.show();
					try{ sleep(10); }catch(Exception e){}
					
					}move=3;
			}
			if( move==3){
				for(int i=demo.getX();i>0;i-- ){
					demo.setBounds(i,demo.getY(),100,100);
					frame.show();
					try{ sleep(10); }catch(Exception e){}
					
					}move=4;
			}
			if( move==4){
				for(int i=demo.getY();i>0;i-- ){
					demo.setBounds(demo.getX(),i,100,100);
					frame.show();
					try{ sleep(10); }catch(Exception e){}
					
					}move=1;
			}
		}//end of while
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==start){ this.start(); }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonMove();
	}

}
