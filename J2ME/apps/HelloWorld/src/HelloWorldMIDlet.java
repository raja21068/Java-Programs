import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class HelloWorldMIDlet extends MIDlet implements CommandListener{

	private Form mainForm;
	public HelloWorldMIDlet(){
		mainForm = new Form("Hello MIDlet");
		mainForm.append(new StringItem(null,"Hello World of MIDlet!"));
		mainForm.addCommand(new Command("Exit",Command.EXIT,0));
		mainForm.setCommandListener(this);
	}
	
	public void startApp(){
		Display.getDisplay(this).setCurrent(mainForm);
	}
	
	public void pauseApp(){} 
	public void destroyApp(boolean b){}

	public void commandAction(Command c , Displayable s){
		notifyDestroyed();
	} 	
}