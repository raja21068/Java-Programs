import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MainMIDlet extends MIDlet implements CommandListener{
	
	Displayable can;
	Command exit;
	
	public MainMIDlet(){
		can = new DisplayCanvas();
		exit = new Command("Exit",Command.EXIT,0);
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