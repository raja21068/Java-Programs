import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;


public class MainMIDlet extends MIDlet implements CommandListener{
	
	Vector bricks;
	Displayable can;
	Command exit;
	
	public MainMIDlet(){
		exit = new Command("Exit",Command.EXIT,0);
		bricks = new Vector();
		can = new BrickCanvas(bricks);
		
		can.addCommand(exit);
		can.setCommandListener(this);
	}

	public void startApp(){
		Display.getDisplay(this).setCurrent(can);
	}
	public void pauseApp(){
	}
	public void destroyApp(boolean b){
		notifyDestroyed();
	}
	
	public void commandAction(Command c , Displayable d){
		if(c == exit){
			destroyApp(false);
		}
	}

}