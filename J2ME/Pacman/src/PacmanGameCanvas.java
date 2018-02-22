import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class PacmanGameCanvas extends GameCanvas implements Runnable{
	
	private Sprite pac; 
	private Sprite bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9,bar10,bar11,bar12,bar13,bar14,bar15,bar16,bar17,bar18,bar19; 
	int firstFrame;
	int secondFrame;
	
	int switchFrame;
	
	int pacX;
	int pacY;
	
	Vector bars;
	Vector dots;
	
	int side;
	int LEFT_SIDE = 5;
	int RIGHT_SIDE = 6;
	int UP_SIDE = 7;
	int DOWN_SIDE = 8;
	
	
	public PacmanGameCanvas()throws Exception{
		super(true);
		firstFrame = 1;
		secondFrame = 0;
		switchFrame = 1;
		pacX = 9;
		pacY = 9;
		side = LEFT_SIDE;
		
		bars = new Vector();
		dots = new Vector();
		
		Image img = Image.createImage("/pacman.png");
		pac = new Sprite(img,19,20);
		
		setBars();
		for(int i=1,dotX=15;i<=7;i++,dotX+=10){
			dots.addElement(new Rectangle(dotX,15,5,5));
			dots.addElement(new Rectangle(15,dotX,5,5));
		}
		pac.setFrame(firstFrame);
		
	}

	public void run(){
		Graphics g = getGraphics();
		while(true){
			drawScreen(g);
			try{
				Thread.sleep(40);
			}catch(Exception ex){ex.printStackTrace();}
			
			if(switchFrame == 1){ pac.setFrame(firstFrame); switchFrame = 2;}
			else if(switchFrame == 2){ pac.setFrame(secondFrame); switchFrame = 3; }
			else if(switchFrame == 3){ pac.setFrame(2); switchFrame = 4;}
			else if(switchFrame ==4){ pac.setFrame(secondFrame); switchFrame = 5; }
			else if(switchFrame ==5){ pac.setFrame(firstFrame); switchFrame = 1; }
			
			input();
			if(!borderCollide()){
				if(side == LEFT_SIDE){ pacX-=1; }
				else if(side == RIGHT_SIDE){ pacX+=1;}
				else if(side == UP_SIDE){ pacY-=1; }
				else if(side == DOWN_SIDE){ pacY+=1; }
			}
			
			
		}
	}
	
	public void drawScreen(Graphics g){
		g.setColor(0);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(0,225,255);
	
		pac.setPosition(pacX,pacY);
		pac.paint(g);
		
		for(int i=0;i<bars.size();i++){
			Rectangle r = (Rectangle) bars.elementAt(i);
			g.fillRect(r.x, r.y , r.width , r.height);
		}
		g.setColor(255,255,255);
		for(int i=0;i<dots.size();i++){
			Rectangle r = (Rectangle) dots.elementAt(i);
			g.fillArc(r.x, r.y , r.width , r.height,360,360);
		}
		
		flushGraphics();
	}
	
	private boolean borderCollide(){
		
		if( pacX <= 3){
			pacX = (getWidth()-10);
		}else if( pacX >= getWidth()-5){
			pacX = 5;
		}
		int tempX=0;
		int tempY=0;
		if(side == LEFT_SIDE){ tempX = pacX+4; tempY=pacY;}
		else if(side == RIGHT_SIDE){ tempX = pacX-4; tempY=pacY;}
		else if(side == UP_SIDE){ tempY=pacY+6; tempX = pacX;}
		else if(side == DOWN_SIDE){ tempY=pacY-6; tempX = pacX;}
		
		Rectangle pacRect = new Rectangle(tempX,pacY,19,20);
		for(int i=0;i<dots.size();i++){
			Rectangle s = (Rectangle)dots.elementAt(i);
			
			if(s.intersect(pacRect )){
				dots.removeElementAt(i);
			}
		}
		
		for(int i=0;i<bars.size();i++){
			Rectangle s = (Rectangle)bars.elementAt(i);
			if(s.intersect(new Rectangle(pacX,pacY,19,20) )){
				return true;
			}
		}
		return false;
	}
	
	
	private void input(){
		int keyStates = getKeyStates();
		// LEFT
		if((keyStates & LEFT_PRESSED)!=0){
			if(side == UP_SIDE){ pacY+=1; }
			if(side == DOWN_SIDE){ pacY-=1; }
			firstFrame = 1;
			secondFrame = 0;
			side = LEFT_SIDE;
			pacX-=1;
		}
		// RIGHT
		if((keyStates & RIGHT_PRESSED)!=0){
			if(side == UP_SIDE){ pacY+=1; }
			if(side == DOWN_SIDE){ pacY-=1; }
			
			firstFrame = 4;
			secondFrame = 3;
			side = RIGHT_SIDE;
			pacX+=1;
		}
		 // Up
		if ((keyStates & UP_PRESSED) != 0) {
		
			if(side == LEFT_SIDE){ pacX+=1; }
			if(side == RIGHT_SIDE){ pacX-=1;}
			
			firstFrame = 7;
			secondFrame = 6;
			side = UP_SIDE;
			pacY-=1;
		}

		// Down
		if ((keyStates & DOWN_PRESSED) !=0){
			if(side == LEFT_SIDE){ pacX+=1;}
			if(side == RIGHT_SIDE){ pacX-=1;}
			
			firstFrame = 10;
			secondFrame = 9;
			side = DOWN_SIDE;
			pacY+=1;
		}
	}
	
	
	
	public void setBars(){
		bars.addElement(new Rectangle(2,2,getWidth(),7));                                    //upper top bar
		bars.addElement(new Rectangle(2,2,7,(getWidth()/2)-40));                             //left upper bar
		bars.addElement(new Rectangle(getWidth()-5,2,7,(getWidth()/2)-40));                  //right uppeer bar 
		bars.addElement(new Rectangle(2,getHeight()-7,getWidth(),7));                        //lower bottom bar
		bars.addElement(new Rectangle(2,(getHeight()/2)-20,7,(getHeight()/2)+20));           //lower left bar
		bars.addElement(new Rectangle(getWidth()-5,(getHeight()/2)-20,7,(getHeight()/2)+20));//lower right bar
		bars.addElement(new Rectangle(2,(getWidth()/2)-40,35,10));                           //upper left block bar
		bars.addElement(new Rectangle(getWidth()-30,(getWidth()/2)-40,35,10));               //upper right block bar
		bars.addElement(new Rectangle((getWidth()/2)-30,2,10,36));                           //upper left middle bar
		bars.addElement(new Rectangle((getWidth()/2)+30,2,10,36));							 //upper right middle bar
		
		bars.addElement(new Rectangle(30,30,40,10));                                         // left horizontal bar
		bars.addElement(new Rectangle(getWidth()-60,30,35,10));								 // right horizontal bar
		
		bars.addElement(new Rectangle(30,40,10,15));                                         //left vertical bar
		bars.addElement(new Rectangle(getWidth()-35,40,10,15));	                             //right vertical bar
		
		bars.addElement(new Rectangle(getWidth()/2,35,10,90));                               //upper middle vertical bar
		
		bars.addElement(new Rectangle(40,120,170,10));                                       //upper middle horizontal bar
		
		bars.addElement(new Rectangle(60,60,30,30));                                         // upper left rectangle
		bars.addElement(new Rectangle(155,65,30,30));                                         // upper right rectangle
	
			
		bars.addElement(new Rectangle(35,220,10,30));										 // LOWER left vertical bar	
		bars.addElement(new Rectangle(200,220,10,30));										 // LOWER right vertical bar
		
		bars.addElement(new Rectangle(35,250,50,10));										 //LOWER left horizontal bar	
		bars.addElement(new Rectangle(160,250,50,10));   	 								 //LOWER right horizontal bar
	
	}
	
	
	public void init(){
		// bar1 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,getWidth(),7,Sprite.TRANS_NONE));
		// bar2 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,(getWidth()/2)-40,7,Sprite.TRANS_ROT90));
		// bar3 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,(getWidth()/2)-40,7,Sprite.TRANS_ROT90));
		// bar4 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,getWidth(),7,Sprite.TRANS_NONE));
		// bar5 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,(getHeight()/2)+20,7,Sprite.TRANS_ROT90));
		// bar6 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,(getHeight()/2)+20,7,Sprite.TRANS_ROT90));
		// bar7 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,40,10,Sprite.TRANS_NONE));
		// bar8 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,40,10,Sprite.TRANS_NONE));
		// bar9 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,30,10,Sprite.TRANS_ROT90));
		// bar10 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,30,10,Sprite.TRANS_ROT90));
		// bar11 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,35,10,Sprite.TRANS_NONE));
		// bar12 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,35,10,Sprite.TRANS_NONE));
		// bar13 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,20,10,Sprite.TRANS_ROT90));
		// bar14 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,20,10,Sprite.TRANS_ROT90));
		// bar15 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,40,10,Sprite.TRANS_ROT90));
		// bar16 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,50,10,Sprite.TRANS_NONE));
		// bar17 = new Sprite(Image.createImage(Image.createImage("/h-bar.png"),2,2,30,10,Sprite.TRANS_NONE));
		
	}
	
	
}