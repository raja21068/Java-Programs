import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChickenSlip implements MouseListener{
	
	JFrame frame=new JFrame();
	JLabel Background=new JLabel(new ImageIcon("grass.jpg"));
	JButton b1[];
	ChickenSlip(){
		try{
		String number=JOptionPane.showInputDialog("Enter Numbers of chicken:", "");
		b1=new JButton[Integer.parseInt(number)];
		}
		catch(Exception e){
		b1=new JButton[5];	
		}
		
		//declaration buttons
		for(int i=0;i<b1.length;i++)b1[i]=new JButton();
		
		//setting Frame
		frame.setBounds(200,200,500,500);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(3);
		
		for(int i=0;i<b1.length;i++)b1[i].setBounds((int)(Math.random()*436),(int)(Math.random()*440),20,20);
		Background.setBounds(1, 1, 500, 500);
		
		//adding component
		for(int i=0;i<b1.length;i++)frame.getContentPane().add(b1[i]);
		frame.getContentPane().add(Background);
		
		//register with mouse listener
		for(int i=0;i<b1.length;i++)b1[i].addMouseListener(this);
		
		frame.show();
		}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
		new chickenRun((JButton)e.getSource()).start();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String arg[]){
		new ChickenSlip();
	}
	

	class chickenRun extends Thread{
		int x,y;
		JButton b;
		public void run(){
			int j=(int)(Math.random()*(frame.getWidth()-60));
			int k=(int)(Math.random()*(frame.getWidth()-60));
			synchronized(this){
			if(x<j){
				for( ;x<=j ;x++){
					b.setBounds(x,y,20,20);
					
					try{
						Thread.sleep(10);
					}catch(Exception e){}}
				
			}//end of if
			else if(x>j){
				for( ;x>=j ;x--){
					b.setBounds(x,y,20,20);
					
					try{
						Thread.sleep(10);
					}catch(Exception e){}}
			}
			
			if(y<k){ 
				for( ;y<=k ;y++){
				b.setBounds(x,y,20,20);
				
				try{
					Thread.sleep(10);
				}catch(Exception e){}} }
			if(y>k){
				for( ;y>=k ;y--){
					b.setBounds(x,y,20,20);
					
					try{
						Thread.sleep(10);
					}catch(Exception e){}}
			}}
		}//end of run method
		chickenRun(JButton btn){
			b=btn;
			x=b.getX();
			y=b.getY();
		}//end of constructor
	
	}//end of chickenRun class
}//end of class`
