import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class ExampleGameCanvas extends GameCanvas{

	private boolean isPlay;
	private long delay;
	private int currentX,currentY;
	private int width;
	private int height;
	
	private Sprite sprite;
	
	Graphics g;
	
	int frame=0;
	
	public  ExampleGameCanvas()throws Exception{
		super(true);
		width = getWidth();
		height = getHeight();
		currentX = width/2;
		currentY = height/2;
		delay = 20;
		
		Image image = Image.createImage("/kidicarus.png");
		sprite = new Sprite(image,29,26);
	
		g = getGraphics();
		drawScreen(g);
			
	}
	
	
	protected void keyPressed(int code){
		input(code);
		drawScreen(g);
	}
	protected void keyRepeated(int code){
		input(code);
		drawScreen(g);
	}
	
	private void input(int keyStates){
		
		sprite.setFrame(0);
		
		if(keyStates == KEY_NUM4  || keyStates == LEFT || keyStates == -3){
			currentX = Math.max(0,currentX-5);
			if( frame == 1 ){ sprite.setFrame(++frame); }			
			else{ frame=1; sprite.setFrame(frame); }			
			
		}
		
		if(keyStates == KEY_NUM6){
			currentX = Math.min(width,currentX+5);
			if( frame == 9 ){ sprite.setFrame(++frame); }			
			else{ frame=9; sprite.setFrame(frame); }
		}
		
		if(keyStates == KEY_NUM2) {
			currentY = Math.max(0, currentY - 5);
			sprite.setFrame(2);
		}

		if(keyStates == KEY_NUM8){
			currentY = Math.min(height, currentY + 5);
			sprite.setFrame(4); 
		}
	}
	
	private void drawScreen(Graphics g) {
		
		g.setColor(0);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0x0000ff);   
    
		// display sprites     
		sprite.setPosition(currentX,currentY);
		sprite.paint(g);
		
		flushGraphics();
	}  
}