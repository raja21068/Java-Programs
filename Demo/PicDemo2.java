import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PicDemo2 implements KeyListener {
	JFrame win=new JFrame();	
	static int i=20,j=1;
	static ImageIcon icon=new ImageIcon("run0.png"); 
	static JLabel stand=new JLabel(icon);
	ImageIcon r1=new ImageIcon("run3.png"); 
	JLabel run1=new JLabel(r1);
	ImageIcon icon2=new ImageIcon("levelnew.jpg");
	JLabel pic2=new JLabel(icon2);
	ImageIcon r2=new ImageIcon("run2.png");
	JLabel run2=new JLabel(r2);

	JLabel back=new JLabel(new ImageIcon("back2.png"));
	JLabel arr=new JLabel(new ImageIcon("arrow2.png"));
	JLabel arr1=new JLabel(new ImageIcon("arrow1.png"));
	JLabel arr2=new JLabel(new ImageIcon("arrow1.png"));
	JLabel arr3=new JLabel(new ImageIcon("arrow2.png"));
	JLabel queen=new JLabel(new ImageIcon("e:/pictures/anigif.gif"));
	PicDemo2(){
		Container c=win.getContentPane();
		pic2.setBounds(0, 1, 900, 600);
		queen.setBounds(20, 500, 40,40);
		win.add(queen);
		win.add(arr);
		win.add(arr1);
		win.add(arr3);
		win.add(arr2);
		win.add(back);
		win.add(run1);
		win.add(stand);
		win.add(run2);
		win.add(pic2);
		
		
		//r1.addKeyListener(this);
		//pic.addKeyListener(this);
		win.addKeyListener(this);
		//run2.addKeyListener(this);
		
		win.setBounds(0, 0, 1000, 650);
		win.show();
		
	}
	
		
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int ob=e.getKeyCode();	
	    if(ob==e.VK_RIGHT){	
	    	stand.setBounds(0,0,0,0);
	    	i+=2;
	    	run2.hide();
	    	run1.show();
	    	run1.setBounds(i,j,40,120);
	    	i+=2;
	    	run1.hide();
	    	run2.show();
	    	run2.setBounds(i,j,40,120);
	    	if(j==1){
	    	if(i>=520 && i<=530){
	    		
	    		for(;j<150;j+=2){
	    			
	    			stand.setBounds(i, j, 40, 120);						
							//Thread.sleep(20);
						} 
	    	}}
						if(j>=150 && j<=160){
							if(i>=865){
								j=310;
							}
						}
						
	    	 }//end of right key
	    
	    	if(ob==e.VK_LEFT){
			i-=2;
			stand.setBounds(0,0,0,0);
			back.setBounds(i, j, 40, 120);
			i-=2;}
	    	if(j>=140 && j<=160 && i>=160 && i<=170){
	    		j=310;
	    	}
		
		if(ob==e.VK_UP){}
		if(ob==e.VK_DOWN){}
		
	}//end of key pressed
		
public void keyReleased(KeyEvent e) {
	stand.setBounds(i,j , 35,120);	
	run1.setBounds(0,0,0,0);	
	run2.setBounds(0,0,0,0);	
	back.setBounds(0,0,0,0);
}
public static void main(String arg[])throws Exception{
	PicDemo2 ob=new PicDemo2();
	int y,b;
	for(int z=0,a=900;;z+=4,a-=4){
		ob.arr1.setBounds(0, 0, 0, 0);
		ob.arr.setBounds(z,120,100,40);
		ob.arr2.setBounds(a,200,100,40);
		ob.arr3.setBounds(0, 0, 0, 0);
		if(z==900){
			for(b=0,y=900;y>0;y-=4,b+=4){
				Thread.sleep(10);
				ob.arr.setBounds(0,0,0,0);
				ob.arr2.setBounds(0,0,0,0);
				ob.arr1.setBounds(y,120,100,40);
				ob.arr3.setBounds(b, 200, 100, 40);
			}
			z=0; a=900;}
		Thread.sleep(10);
	}
	
	
}

}