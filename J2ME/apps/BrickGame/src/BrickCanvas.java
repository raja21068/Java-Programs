import javax.microedition.lcdui.*;
import java.util.*;

public class BrickCanvas extends Canvas{
	int brickSize;
	int y = 10;
	int init = 2;
	Vector bricks;
	
	int barX;
	int barWidth = 50;
	int barHeight = 5;
	
	public BrickCanvas(Vector v){
		int endLimit = getWidth()-2;
		brickSize = endLimit/8;
		bricks = v;
		while(y <= (getHeight()/2)){
			init = 2;
			while(init+brickSize<= getWidth()){
				bricks.addElement(new Rectangle(init,y,brickSize-2,getHeight()/15));
				init += brickSize;
			}
			y+= (getHeight()/15)+2;
		}
		barX = (getWidth()/2) - (barWidth/2);
	}

	protected void paint(Graphics g){
		g.setColor(2,200,5);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(255,255,2);
		for(int i=0;i<bricks.size();i++){
			Rectangle r = (Rectangle)bricks.elementAt(i);
			g.fillRect(r.x,r.y,r.width,r.height);
		}
		
		g.fillRect(barX , getHeight()-(barHeight*2),barWidth,barHeight);
		
		g.setColor(255,255,255);
		g.fillArc(100,100,10,10,0,360);
	}
	
	protected void keyPressed(int code){
		barMove(code);
	}
	protected void keyRepeated(int code){
		barMove(code);
	}

	public void barMove(int code){
		//LEFT
		if(code == -3){ 
			if( (barX-5) > 2){
				barX-=5;
			}
			else if( (barX-4) > 2){
				barX-=4;
			}else if((barX-3) > 2){
				barX-=3;
			}else if((barX-2) > 2){
				barX-=2;
			}
			
		}
		//RIGHT
		if(code == -4){
			if((barX+5) < (getWidth()-2)){
				barX+=5;
			}
			else if((barX+4) < (getWidth()-2)){
				barX+=4;
			}else if((barX+3) < (getWidth()-2)){
				barX+=3;
			}else if((barX+2) < (getWidth()-2)){
				barX+=2;
			}
		}
		repaint();
	}
	
}