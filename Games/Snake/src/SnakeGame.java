import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SnakeGame extends JFrame implements KeyListener{
	JLabel s[]=new JLabel[10];
	JLabel coin=new JLabel("c");
	int x=100;
	int y=100;
	int height=10;
	int width=10;
	int move;
	int cx,cy,ch,cw;
	int prex,prey,preh,prew;
	SnakeGame(){
		Container con=getContentPane();
		con.setLayout(null);
		setBounds(200,200,400,400);
		con.setBackground(Color.cyan);
		
		for(int i=0;i<s.length;i++){
			s[i]=new JLabel();
			con.add(s[i]);
			s[i].setText("0");
		}
		s[0].setBounds(x, y, width, height);
		coinRandom();
		coin.setBounds(cx, cy, cw, ch);
		con.add(coin);
		s[1].setBounds(prex,prey,prew,preh);
		addKeyListener(this);
		s[0].addKeyListener(this);
		show();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SnakeGame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int ob=e.getKeyCode();
		if(ob==e.VK_RIGHT){
			prex=x;
			prey=y;
			prew=width;
			preh=height;
			s[1].setBounds(prex, prey, prew, preh);
			x+=1;
			s[0].setBounds(x, y, width, height);
			show();
		}
		if(ob==e.VK_LEFT){
			prex=x;
			prey=y;
			prew=width;
			preh=height;
			s[1].setBounds(prex, prey, prew, preh);
			
			x-=1;
			s[0].setBounds(x, y, width, height);
			show();
		}
		if(ob==e.VK_UP){
			prex=x;
			prey=y;
			prew=width;
			preh=height;
			s[1].setBounds(prex, prey, prew, preh);
			
			y-=1;
			s[0].setBounds(x, y, width, height);
			show();
		}
		if(ob==e.VK_DOWN){
			prex=x;
			prey=y;
			prew=width;
			preh=height;
			s[1].setBounds(prex, prey, prew, preh);
			
			y+=1;
			s[0].setBounds(x, y, width, height);
			show();
		}
		cheking();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//for(; ; move++){
			
	//	}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	void cheking(){
		if(x==cx && y==cy && height==ch && width==cw){ coinRandom(); }
	
	}
	void coinRandom(){
		double d=Math.random()*300;
		cx=(int)d;
		double d2=Math.random()*300;
		cy=(int)d2;
		double d3=Math.random()*400;
		cw=(int)d3;
		double d4=Math.random()*400;
		ch=(int)d4;
		coin.setBounds(cx, cy, cw, ch);
		show();
	}
}
