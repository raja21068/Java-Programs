import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import javax.microedition.midlet.*;

public class PacmanMIdlet extends MIDlet{
	
	Display display;
	
	public PacmanMIdlet(){
		display = Display.getDisplay(this);
	}
	public void startApp(){
		try{
			PacmanGameCanvas can = new PacmanGameCanvas();
			Thread t = new Thread(can);
			display.setCurrent(can);
			t.start();
		}catch(Exception ex){ex.printStackTrace();}
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){
	}
}


