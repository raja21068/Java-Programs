import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;


public class Menu extends Canvas{
	
	int y;
	int option;
	
	MainMIDlet midlet;
	
	public Menu(MainMIDlet mid){
		y = 150;
		option = 0;
		midlet = mid;
	}
	
	public void paint(Graphics g){
		g.setColor(0);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(0,0,255);
		//g.fillRect(30,30,150,30);
		g.fillRoundRect(10,30,(getWidth()-20),100,30,20);
		g.setColor(12,33,90);
		g.fillRect(30,50,(getWidth()-60),60);
		
		g.setColor(255,255,255);
		g.setFont(Font.getFont(Font.FACE_PROPORTIONAL , Font.STYLE_BOLD, Font.SIZE_LARGE));
		g.drawString("Jet Fight",60,60,Graphics.TOP|Graphics.LEFT);
		try{
			g.drawImage(Image.createImage("/menu-icon.png"),getWidth()-80,40,0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		g.setColor(122,0,133);
		g.fillRect((getWidth()/2)-50,y,100,30);
		
		
		g.setColor(255,255,255);
		g.drawString("New Game" , (getWidth()/2),160,Graphics.TOP|Graphics.HCENTER);
		
		g.drawString("Setting" , (getWidth()/2),190,Graphics.TOP|Graphics.HCENTER);
		
		g.drawString("Exit" , (getWidth()/2),220,Graphics.TOP|Graphics.HCENTER);
	}

	protected void keyPressed(int code){
		optionChanged(code);
	}
	protected void keyRepeated(int code){
		optionChanged(code);
	}
	
	public void optionChanged(int code){
		if(code == DOWN || code == LEFT || code == -2){
			alterOptionDown();
		}
		else if(code == UP || code == RIGHT || code == -1){
			alterOptionUp();
		}
		repaint();
		
		if( code == -5){
			optionSelected();
		}
	}
	
	public void alterOptionDown(){
		if(option == 0){ option = 1; y+=30; }
		else if(option == 1){ option = 2; y+=30;}
		else if(option == 2){ option = 0; y-=60; }
	}
	
	public void alterOptionUp(){
		if(option == 0){ option = 2; y+=60; }
		else if(option == 1){ option = 0; y-=30; }
		else if(option == 2){ option = 1; y-=30;}
	}
	
	public void optionSelected(){
		if(option == 0){ midlet.newGame(); }
		else if(option == 1){}
		else if(option == 2){ midlet.notifyDestroyed(); }
	}
	
}