import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.*;

public class CarGame2 extends JFrame implements KeyListener{
	ImageIcon car=new ImageIcon("e:/pictures/redcar.png"); 
	JLabel c=new JLabel(car);
	static int g=-20;
	ImageIcon icon=new ImageIcon("e:/pictures/road.jpg"); 
	JLabel pic=new JLabel(icon);
	static ImageIcon icon1=new ImageIcon("e:/pictures/bar.jpg"); 
	static JLabel pic1=new JLabel(icon1);
	static ImageIcon icon2=new ImageIcon("e:/pictures/bar2.jpg"); 
	static JLabel pic2=new JLabel(icon2);
	static ImageIcon yellow=new ImageIcon("e:/pictures/yellowcar.png"); 
	static JLabel yc=new JLabel(yellow);
	static JLabel ready=new JLabel("READY");
	static JLabel one=new JLabel("1");
	static JLabel two=new JLabel("2");
	static JLabel go=new JLabel("GO");
	Font font=new Font("italic",Font.BOLD,30);
	static int y=100,z=350,x=200,h=400;
	CarGame2(){
		//setResizable(false);
		setBounds(0, 0, 600, 530);
		c.setBounds(x, h, 100, 110);
		pic.setBounds(0, 0, 500, 600);
		
		addKeyListener(this);
		c.addKeyListener(this);
		ready.setFont(font);
		ready.setBackground(Color.GREEN);
		one.setFont(font);
		one.setBackground(Color.GREEN);
		two.setFont(font);
		two.setBackground(Color.GREEN);
		go.setFont(font);
		go.setBackground(Color.GREEN);
		
		add(ready);
		add(one);
		add(two);
		add(go);
		add(yc);
		add(c);
		add(pic2);
		add(pic1);
		add(pic);
	//	setDefaulat
		show();
	}
	
	public void play(String filename)throws Exception{
		File f= new File(filename);
		System.out.println(f.exists());
		AudioClip clip=Applet.newAudioClip(f.toURL());
		clip.play();
	}
	
public static void main(String arg[])throws Exception{
	CarGame2 ob=new CarGame2();
	 
ready.setBounds(50, 50, 150, 50);
ob.play("tone.wav");
Thread.sleep(1000);

one.setBounds(50, 100, 100, 50);	
ob.play("tone.wav");
Thread.sleep(1000);
two.setBounds(50, 150, 100, 50);
ob.play("tone.wav");
Thread.sleep(1000);
go.setBounds(50, 200, 100, 50);
ob.play("tone.wav");
Thread.sleep(1000);
ready.setBounds(0, 00, 00, 0);
one.setBounds(0, 00, 00, 0);
two.setBounds(0, 00, 00, 0);
ob.play("i can transform.wav");
for (;;y+=2,z+=2,g++){                
	pic1.setBounds(250, y, 20, 72);
	      
           yc.setBounds(50, g, 100, 110);
             pic2.setBounds(250, z, 20, 72);
             if(y==500){y=0;}
             if(g==500){g=-20;}
             if(z==500){z=0;}
            // if(h==y+10 ){ break; }
             
             Thread.sleep(3);
}}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	int ob=e.getKeyCode();

	
	if(ob==e.VK_RIGHT){
		x+=3;
		c.setBounds(x, h, 100, 110);
	}
	if(ob==e.VK_LEFT){
		x-=3;
		c.setBounds(x, h, 100, 110);
	}
	if(ob==e.VK_UP){
		h-=3;
		c.setBounds(x, h, 100, 110);
	}
	if(ob==e.VK_DOWN)
	h+=3;
	c.setBounds(x, h, 100, 110);
}

@Override
public void keyReleased(KeyEvent e) {
	c.setBounds(x, h, 100, 110);
	
}



}


