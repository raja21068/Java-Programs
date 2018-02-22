import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Shermie implements KeyListener {
	JFrame win=new JFrame();	
	static int i=20,j=5;
	static JLabel stand=new JLabel(new ImageIcon("shermie-stance-full.gif"));
	JLabel pic2=new JLabel(new ImageIcon("levelnew.jpg"));
	JLabel run2=new JLabel(new ImageIcon("sher-walk.gif"));
	JLabel standback=new JLabel(new ImageIcon("shermie-backstance-full.gif"));
	JLabel back=new JLabel(new ImageIcon("sher-walkback.gif"));
	JLabel arr2=new JLabel(new ImageIcon("arrow1.png"));
	JLabel arr3=new JLabel(new ImageIcon("arrow2.png"));
	JLabel queen=new JLabel(new ImageIcon("anigif.gif"));
	JLabel fire=new JLabel(new ImageIcon("shermie-doinit.gif"));
	JLabel backfire=new JLabel(new ImageIcon("shermie-doinit.gif"));
	JLabel kick=new JLabel(new ImageIcon("sher-kick.gif"));
	JLabel kickback=new JLabel(new ImageIcon("sher-kickback.gif"));
	
	int face=1;
	Shermie(){
		Container c=win.getContentPane();
		pic2.setBounds(0, 1, 920, 600);
		queen.setBounds(20, 500, 40,40);
		win.add(queen);
		win.add(standback);
		win.add(arr3);
		win.add(backfire);
		win.add(arr2);
		win.add(fire);
		win.add(kickback);
		win.add(kick);
		win.add(back);
		win.add(stand);
		win.add(run2);
		win.add(pic2);
		
		
		//r1.addKeyListener(this);
		//pic.addKeyListener(this);
		win.addKeyListener(this);
		//run2.addKeyListener(this);
		
		win.setBounds(0, 0, 1050, 745);
		//win.setDefaultCloseOperation(EXIT_ON_CLOSE);
		win.setVisible(true);
		
	}
	
		
	public void keyTyped(KeyEvent e) {
		char ch=e.getKeyChar();
		if(ch=='k'){
			stand.setBounds(0,0,0,0);
			standback.setBounds(0,0 ,0,0);
			back.setBounds(0, 0, 0, 110);
			fire.setBounds(0,0 , 0,0);
			backfire.setBounds(0,0 , 0,0);
			if(face==1)kick.setBounds(i, j, 200, 120);
			else {kickback.setBounds(i, j, 200, 120);}
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int ob=e.getKeyCode();	
	    char ch=e.getKeyChar();
	    
	    if(ch=='f'){
	    	if(face==1)fire.setBounds(i,j , 80,120);
	    	else {backfire.setBounds(i,j , 80,120);}
	    	kick.setBounds(0, 0, 0, 0);
	    	back.setBounds(0, 0, 0, 0);
	    	kickback.setBounds(0,0,0,0);
	    	standback.setBounds(0,0 , 0,0);
	    	stand.setBounds(0,0,0,0);
	    	run2.setBounds(0,0,0,0);
	    }
		if(ob==e.VK_RIGHT){	
	    	face=1;
			stand.setBounds(0,0,0,0);
			kick.setBounds(0, 0, 0, 0);
			kickback.setBounds(0,0,0,0);
			standback.setBounds(0,0 , 0,0);
			fire.setBounds(0,0 , 0,0);
			backfire.setBounds(0,0 , 0,0);
			i+=6;
	    	run2.setBounds(i,j+2,70,110);
	    	if(j==5){
	    	if(i>=520 && i<=530){
	    		
	    		for(;j<170;j+=2){
	    			
	    			stand.setBounds(i, j, 40, 120);						
							//Thread.sleep(20);
						} 
	    	}}
						if(j>160 && j<180){
							if(i>=875){
								j=340;
							}
						}
						if(j==340 && i<600 ){
							if(i>560){j=540; }
						}
						
	    	 }//end of right key
	    
	    	if(ob==e.VK_LEFT){
			i-=4;
			face=0;
			stand.setBounds(0,0,0,0);
			kickback.setBounds(0,0,0,0);
			standback.setBounds(0,0 ,0,0);
			kick.setBounds(0, 0, 0, 0);
			back.setBounds(i, j, 60, 110);
			fire.setBounds(0,0 , 0,0);
			backfire.setBounds(0,0 , 0,0);
			i-=2;
	    	if(j>=170 && j<=180 && i<=90){
	    		j=340;
	    	}
	    	if(j==340 && i<700 && i>500){ j=540; }
	    	}//end of left
		
		if(ob==e.VK_UP){ }
		if(ob==e.VK_DOWN){}
		
	}//end of key pressed
		
public void keyReleased(KeyEvent e) {
	if(face==1){stand.setBounds(i,j , 70,120);}		
	else{standback.setBounds(i,j , 70,120);}
	run2.setBounds(0,0,0,0);
	kick.setBounds(0, 0, 0, 0);
	backfire.setBounds(0,0 , 0,0);
	back.setBounds(0,0,0,0);
	kickback.setBounds(0,0,0,0);
	fire.setBounds(0,0,0,0);
}
public static void main(String arg[])throws Exception{
	Shermie ob=new Shermie();
	int y,b;
	for(int z=0,a=900;;z+=4,a-=4){
		ob.arr2.setBounds(a,200,100,40);
		ob.arr3.setBounds(0, 0, 0, 0);
		if(z==900){
			for(b=0,y=900;y>0;y-=4,b+=4){
				Thread.sleep(10);
				ob.arr2.setBounds(0,0,0,0);
				
				ob.arr3.setBounds(b, 200, 100, 40);
			}
			z=0; a=900;}
		Thread.sleep(10);
	}
	
	
}

}