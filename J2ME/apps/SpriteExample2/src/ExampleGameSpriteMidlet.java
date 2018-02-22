import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ExampleGameSpriteMidlet extends MIDlet{

	private Display display;
	
	public void startApp(){
		try{
			display = Display.getDisplay(this);
			ExampleGameCanvas gameCanvas= new ExampleGameCanvas();
			display.setCurrent(gameCanvas);
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	public void pauseApp(){}
	public void destroyApp(boolean b){
		notifyDestroyed();
	}

}