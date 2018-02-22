import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class TextEditor implements CommandListener{

	public TextBox tx;
	Command gotoParentCommand;
	Screen parent;
	Display display;
	
	public TextEditor(Display d , Screen sc){
		display = d;
		parent = sc;
		
		tx = new TextBox("Text Editor",null,500,TextField.ANY);
		gotoParentCommand = new Command("Main Menu",Command.BACK,0);
		
		tx.addCommand(gotoParentCommand);
		tx.setCommandListener(this);	
			
	}
	
	public void commandAction(Command c , Displayable d){
		if(c == gotoParentCommand){
			display.setCurrent(parent);
		}
	}
}