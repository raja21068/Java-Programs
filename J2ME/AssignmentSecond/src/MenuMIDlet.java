import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MenuMIDlet extends MIDlet implements CommandListener{

	Display display;
	List menuList;
	Command exit;
	Calculator calcu;
	TextEditor txt;
	Colors color;
	
	public MenuMIDlet(){
		display = Display.getDisplay(this);
		menuList = new List("Menu",Choice.IMPLICIT);
		exit = new Command("Exit",Command.EXIT,0);
		Image colorImage = null;
		calcu = new Calculator(display , menuList);
		txt = new TextEditor(display , menuList);
		color = new Colors(display , menuList);
		
		menuList.append("Color",colorImage);
		menuList.append("Font",colorImage);
		menuList.append("Calcultor",colorImage);
		menuList.append("Text Editor",colorImage);
		menuList.addCommand(exit);
		
		menuList.setCommandListener(this);
		
		
	}
	
	public void startApp(){
		display.setCurrent(menuList);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	
	public void commandAction(Command c , Displayable d){
		if(c == exit){
			notifyDestroyed();
		}
		else if(d == menuList){
			List list = (List) display.getCurrent();
			int select = list.getSelectedIndex();
			if(select == 0){ display.setCurrent(color.form); }
			else if(select == 1){}
			else if(select == 2){ display.setCurrent(calcu.mainForm); }
			else if(select == 3){ display.setCurrent(txt.tx); }
		}
	}
	
}