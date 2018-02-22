import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class ExampleGameCanvas extends GameCanvas implements Runnable{

	private boolean isPlay;
	private long delay;
	private int currentX,currentY;
	private int width;
	private int height;
	
	private Sprite sprite;
	
	public ExampleGameCanvas()throws Exception{
		super(true);
		width = getWidth();
		height = getHeight();
		currentX = width/2;
		currentY = height/2;
		delay = 20;
		
		Image image = Image.createImage("/transparent.png");
		sprite = new Sprite(image,32,32);
		
	}
	
	public void start(){
		isPlay = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stop(){isPlay = false; }
	
	public void run(){
		Graphics g = getGraphics();
		while(isPlay){
			input();
			drawScreen(g);
			try{Thread.sleep(delay);}catch(Exception ex){ex.printStackTrace();}
			
		}
	}
	
	private void input(){
		int keyStates = getKeyStates();
		
		sprite.setFrame(0);
		
		if((keyStates & LEFT_PRESSED)!=0){
			currentX = Math.max(0,currentX-1);
			sprite.setFrame(1);
		}
		
		if((keyStates & RIGHT_PRESSED)!=0){
			if(currentX + 5 <width){
				currentX = Math.min(width,currentX+1);
				sprite.setFrame(3);
			}
		}
		 // Up
		if ((keyStates & UP_PRESSED) != 0) {
			currentY = Math.max(0, currentY - 1);
			sprite.setFrame(2);
		}

		// Down
		if ((keyStates & DOWN_PRESSED) !=0){
			if ( currentY + 10 < height) {
				currentY = Math.min(height, currentY + 1);
				sprite.setFrame(4);
			} 
		}
	}
	// Method to Display Graphics
	private void drawScreen(Graphics g) {
		//g.setColor(0xffffff);
		g.setColor(0xFF0000);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(0x0000ff);   
    
		// display sprites     
		sprite.setPosition(currentX,currentY);
		sprite.paint(g);
    
		flushGraphics();
	}  
}