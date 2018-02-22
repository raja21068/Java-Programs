import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Demokey implements KeyListener {
int i=7,j=40;
Frame win=new Frame();
Button b=new Button("Buuton");	
ImageIcon icon=new ImageIcon("LilongaElvie1.jpg"); 
JLabel pic=new JLabel(icon);
Demokey(){
	win.setBounds(0,0,300,300);
	b.addKeyListener(this);
	pic.addKeyListener(this);
	
	win.add(b);
	win.add(pic);
	win.show();
}

	public void keyTyped(KeyEvent e) {
	
			}


	public void keyPressed(KeyEvent e) {
	int ob=e.getKeyCode();	
    if(ob==e.VK_RIGHT){	
    	i+=2;
    	pic.setBounds(i,j , 30,20);
	if(i>=240){ i=7; }
	}
if(ob==e.VK_DOWN){
	j+=2;
	pic.setBounds(i,j , 30,20);
	if(j>=240){ j=7; }
	}
	if(ob==e.VK_LEFT){
		i-=2;
		pic.setBounds(i,j , 30,20);
		
		if(i<7){i=240;}
	}
	if(ob==e.VK_UP){
		j-=2;
		pic.setBounds(i,j , 30,20);
		
	if(j<10){j=240;}
	}
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		pic.setBounds(i,j , 30,20);
		
	}
	public static void main(String[] args) {
		new Demokey();

	}

}
