import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PicDemo implements KeyListener {
	Frame win=new Frame();	
	static int i=20,j=12;
	ImageIcon icon2=new ImageIcon("gamebackground.jpg");
	static ImageIcon icon=new ImageIcon("LilongaElvie1.jpg"); 
	JLabel pic2=new JLabel(icon2);
    static JLabel pic=new JLabel(icon);
    ImageIcon icon3=new ImageIcon("run.jpg"); 
	JLabel pic3=new JLabel(icon3);
	 static ImageIcon icon4=new ImageIcon("front.jpg"); 
		static JLabel pic4=new JLabel(icon4);
	PicDemo(){
		pic2.setBounds(0, 0, 300, 300);
	
		win.add(pic4);
		win.add(pic);
		win.add(pic3);
		win.add(pic2);
		
		pic.addKeyListener(this);
		win.addKeyListener(this);
		pic3.addKeyListener(this);
		win.setBounds(0, 0, 500, 500);
		win.show();
		
	}
	
	
	public static void main(String arg[])throws Exception{
		new PicDemo();
		for(int i=0;i<=300;i++){
			pic4.setBounds(270,i,40,40);
			if(i==290){i=0;}
			Thread.sleep(100);
		}
		
}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int ob=e.getKeyCode();	
	    if(ob==e.VK_RIGHT){	
	    	pic3.setBounds(i,j,15,120);
	    	i+=2;
	    	pic.setBounds(0,0,0,0);
	    	
	    	if(i==270)
	    	{ 
	    		for( ;j<=120;j++)
	    	{ 
				try {
					pic3.setBounds(270,j,15,110);
					Thread.sleep(20);
				} catch (Exception e1) {
					
				}
	    			
	    			
	    	}
	    			    	}
	    	}
		
	if(ob==e.VK_DOWN){
		j+=2;
		pic.setBounds(i,j , 15,120);
		if(j>=240){ j=7; }
		}
		if(ob==e.VK_LEFT){
			i-=2;
			pic.setBounds(i,j , 15,120);
			pic3.setBounds(0,0,0,0);
			if(i<7){i=240;}
		}
		if(ob==e.VK_UP){}
			//j-=2;
			//pic.setBounds(i,j , 15,120);
			
		//if(j<10){j=240;}
		//}
		}
		
public void keyReleased(KeyEvent e) {
	pic.setBounds(i,j , 15,120);
		
	}
}