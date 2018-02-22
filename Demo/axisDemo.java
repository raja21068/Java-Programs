import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class axisDemo extends JFrame implements KeyListener,MouseListener{
	JTextArea txt=new JTextArea();
	JPanel panel=new JPanel();
	int x1,y1,x2,y2;
	JLabel x=new JLabel("x:"+x1+",Ln:"+y1);
	axisDemo(){
		setBounds(0,0,500,500);
		Container con=getContentPane();
		panel.add(x);
		con.setLayout(null);
		txt.setBounds(2,2,450,450);
		con.add(txt);
		panel.setBounds(2,450,400,50);
		con.add(panel);
		
		txt.addMouseListener(this);
		txt.addKeyListener(this);
		show();
		
	}
	public static void main(String arg[]){
		new axisDemo();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int ob=e.getKeyCode();
		if(ob==e.VK_LEFT ||ob==e.VK_RIGHT||ob==e.VK_UP||ob==e.VK_DOWN){
			x2=txt.getLineCount();
	    	y2=txt.getRows();
	    	x.setText("Ln:"+x2+",Col:"+y2);
	    	System.out.println("Ln:"+x2+",Col:"+y2);
	    	show();
	    }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int ob=e.getKeyCode();
	    if(ob==e.VK_LEFT ||ob==e.VK_RIGHT||ob==e.VK_UP||ob==e.VK_DOWN){
	    	x2=txt.getLineCount();
	    	y2=txt.getRows();
	    	x.setText("Ln:"+x2+",Col:"+y2);
	    	System.out.println("Ln:"+x2+",Col:"+y2);
	    	show();
	    }
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x2=txt.getLineCount();
		//y2=txt.;
		try{
		y2=txt.getLineOfOffset(0);}catch(Exception e){}
    	x.setText("Ln:"+x2+",Col:"+y2);
    	System.out.println("Ln:"+x2+",Col:"+y2);
    	show();
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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

}
