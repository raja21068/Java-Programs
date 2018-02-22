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
	
	public  ExampleGameCanvas()throws Exception{
		super(true);
		width = getWidth();
		height = getHeight();
		currentX = width/2;
		currentY = height/2;
		delay = 20;
		
		Image image = Image.createImage("/transparent.png");
		Image image2 = Image.createImage("/kidicarus.png");
		sprite = new Sprite(image,32,32);
	
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
	protected void keyReleased(int code){
		front();
	}
	
	
	private void front(){
		
		try{
			Thread.sleep(50);
			sprite.setFrame(0);
			drawScreen(g);
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	private void input(int keyStates){
		
		sprite.setFrame(0);
		
		if(keyStates == KEY_NUM4  || keyStates == LEFT || keyStates == -3){
			currentX = Math.max(0,currentX-5);
			sprite.setFrame(1);
		}
		
		if(keyStates == KEY_NUM6  || keyStates == RIGHT  || keyStates == -4){
			if(currentX + 5 <width){
				currentX = Math.min(width,currentX+5);
				sprite.setFrame(3);
			}
		}
		 // Up
		if(keyStates == KEY_NUM2  || keyStates == UP || keyStates == -1) {
			currentY = Math.max(0, currentY - 5);
			sprite.setFrame(2);
		}

		// Down
		if(keyStates == KEY_NUM8  || keyStates == DOWN || keyStates == -2){
			if ( currentY + 10 < height) {
				currentY = Math.min(height, currentY + 5);
				sprite.setFrame(4);
			} 
		}
	}
	// Method to Display Graphics
	private void drawScreen(Graphics g) {
		
		//g.setColor(0xffffff);
		//g.setColor(0xFF0000);
		g.setColor(0);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0x0000ff);   
    
		// display sprites     
		sprite.setPosition(currentX,currentY);
		sprite.paint(g);
		
		flushGraphics();
	}  
}