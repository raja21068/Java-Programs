import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.*;

class BackgroundMove extends Thread implements KeyListener{
	JFrame frame;
	static JLabel Image1Label;
	static JLabel Image2Label;
	JLabel helicopterLabel;
	JLabel Enemy;
	JLabel fireLabel;
	JLabel fireLabel2;
	JLabel fireLabel3;
	JLabel fireLabel4;
	static int fires=1;
	
	int XOfHeli=0,YOfHeli=50;
	BackgroundMove(){
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(200,200,700,500);
		frame.setDefaultCloseOperation(3);
		
		Image1Label = new JLabel(new ImageIcon("A1.jpg"));
		Image2Label = new JLabel(new ImageIcon("A2.jpg"));
		helicopterLabel = new JLabel(new ImageIcon("helicopter.png"));
		fireLabel = new JLabel(new ImageIcon("hunter_bullet.png"));
		fireLabel2 = new JLabel(new ImageIcon("hunter_bullet2.png"));
		fireLabel3 = new JLabel(new ImageIcon("hunter_bullet3.png"));
		fireLabel4 = new JLabel(new ImageIcon("hunter_bullet4.png"));
		Enemy = new JLabel(new ImageIcon("Enemy.png"));
		
		Image1Label.setBounds(0,0,frame.getWidth(),frame.getHeight());
		Image1Label.setBounds(500,0,frame.getWidth(),frame.getHeight());
		helicopterLabel.setBounds(0,50,100,60);
		
		frame.getContentPane().add(helicopterLabel);
		frame.getContentPane().add(Enemy);
		frame.getContentPane().add(fireLabel);
		frame.getContentPane().add(fireLabel2);
		frame.getContentPane().add(fireLabel3);
		frame.getContentPane().add(fireLabel4);
		frame.getContentPane().add(Image1Label);
		frame.getContentPane().add(Image2Label);
		
			start();
			new Enemy().start();
		frame.addKeyListener(this);
		helicopterLabel.addKeyListener(this);
		frame.show();
	}

	
	public void run(){
		for(int i=0,j=690;i>-700;i--,j--){
			Image1Label.setBounds(i,0,frame.getWidth(),frame.getHeight());
			Image2Label.setBounds(j,0,frame.getWidth(),frame.getHeight());
			try{Thread.sleep(20);}catch(Exception e){}
			//show();
			if(i==-699){  i=690; }
			if(j==-699){ j=690; }
	}//end of run
}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int arrow=e.getKeyCode();
		
		if(arrow==e.VK_LEFT){
			if(XOfHeli<=0)return;
			XOfHeli-=4;
			helicopterLabel.setBounds(XOfHeli,YOfHeli,130,60);
			frame.show();
		}
		else if(arrow==e.VK_RIGHT){
				if(XOfHeli>=frame.getWidth()-130)return;
					XOfHeli+=4;
					helicopterLabel.setBounds(XOfHeli,YOfHeli,130,60);
					frame.show();
		}
		else if(arrow==e.VK_UP){
			if(YOfHeli<=10)return;
			YOfHeli-=4;
			helicopterLabel.setBounds(XOfHeli,YOfHeli,130,60);
			frame.show();
		}
		else if(arrow==e.VK_DOWN){
			if(YOfHeli>=frame.getHeight()-80)return;
			YOfHeli+=4;
			helicopterLabel.setBounds(XOfHeli,YOfHeli,130,60);
			frame.show();
		}
				
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		if(c=='f'){
			
			new fire().start();
			
		}
	}
	
//****************************************************	
class fire extends Thread{
	
	public void run(){
		
		int y=helicopterLabel.getY()+20;
		
		for(int x = helicopterLabel.getX() + helicopterLabel.getWidth() - 10; x <= 700; x++){
			try{ 
				Thread.sleep(1); 
			}catch(Exception e){}
			
			if(fires==1){fireLabel.setBounds(x,y,25, 25);
							frame.show();
						fires=2;	
					}
			else if(fires==2){fireLabel2.setBounds(x,y,25, 25);
						frame.show();
						fires=3;  }
			else if(fires==3){fireLabel3.setBounds(x,y,25, 25);
			frame.show();
			fires=4;  }
			
			else if(fires==4){fireLabel4.setBounds(x,y,25, 25);
			frame.show();
			fires=1;  }
		
		}
	}//end of run
}//end of fire class
//****************************************************

//***********************Enemy Class*************************//
class Enemy extends Thread{
	JLabel enemyLbl;
	public void run(){
		int randomY;
		while(true){
			randomY=(int)(Math.random()*400);
			for(int i=700;i>0;i--){
				Enemy.setBounds(i,randomY+30,50,20);
				if((fireLabel.getX()+15>= Enemy.getX() && fireLabel.getX()<= Enemy.getX()-15 ) && ( fireLabel.getY()>=(Enemy.getY()-10) && fireLabel.getY()>=(Enemy.getY()+10) ) )
				{
					System.out.println("true1");
					break;
				}
				if((fireLabel2.getX()+15>= Enemy.getX() && fireLabel2.getX()<= Enemy.getX()-15 ) && ((fireLabel2.getY()-10)>=Enemy.getY() && fireLabel2.getY()+10<=Enemy.getY()))
				{
					System.out.println("true");
					break;
				}
				if((fireLabel3.getX()+15>= Enemy.getX() && fireLabel3.getX()<= Enemy.getX()-15 ) && ((fireLabel3.getY()-10)>=Enemy.getY() && fireLabel3.getY()+10<=Enemy.getY()))
				{
					System.out.println("true");
					break;
				}
				if((fireLabel4.getX()+15>= Enemy.getX() && fireLabel4.getX()<= Enemy.getX()-15 ) && ((fireLabel4.getY()-10)>=Enemy.getY() && fireLabel4.getY()+10<=Enemy.getY()))
				{
					System.out.println("true");
					break;
				}
				
			try{Thread.sleep(2);}catch(InterruptedException e){}
			frame.show();
			}
		}
	}
	
}
//************************************************************//

public static void main(String arg[]){
		new BackgroundMove();
		System.out.println("hello");
	}
	
}//end of main class