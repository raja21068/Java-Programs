import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Colors implements CommandListener{
	
	Form form;
	Display display; 
	Screen parent;
	Command gotoParentCommand;
	
	public Colors(Display d , Screen sc){
		display = d ;
		parent = sc;
		
		form = new Form("colors");
		ChoiceGroup grp = new ChoiceGroup("Colors",Choice.MULTIPLE);
		gotoParentCommand = new Command("Main Menu",Command.BACK,0);
		grp.append("Blue",null);
		grp.append("Green",null);
		grp.append("Red",null);
		
		ChoiceGroup grp2 = new ChoiceGroup("Other",Choice.POPUP);
		grp2.append("Orange",null);
		grp2.append("Yellow",null);
		grp2.append("Black",null);
		
		ChoiceGroup grp3 = new ChoiceGroup("Font",Choice.EXCLUSIVE);
		grp3.append("Orange",null);
		grp3.append("Yellow",null);
		grp3.append("Black",null);
		
		form.append(grp);
		form.append(grp2);
		form.append(grp3);
		form.addCommand(gotoParentCommand);
		form.setCommandListener(this);
	}
	
	public void commandAction(Command c , Displayable d){
		if(c == gotoParentCommand){
			display.setCurrent(parent);
		}
	}
}