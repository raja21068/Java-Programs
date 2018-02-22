
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
/**
 *
 * @author Jay Kumar
 */
public class MainMidlet extends MIDlet implements CommandListener{

    Command exitCommand , addCommand;
	StringItem longitude , latitude , altitude;
    Display display;
    Form form;
    
    public MainMidlet(){
        display = Display.getDisplay(this);
        form = new Form("GPS System");
        exitCommand = new Command("Exit",Command.EXIT,0);
        addCommand = new Command("Add Location",Command.ITEM,1);
        longitude = new StringItem("Longitude:","");
        latitude = new StringItem("Latitude:","");
        altitude = new StringItem("Altitude:","");
		
        form.append(longitude);
        form.append(latitude);
        form.append(altitude);
		form.addCommand(exitCommand);
        form.addCommand(addCommand);
		form.setCommandListener(this);
		
    }
    
    public void startApp(){
        display.setCurrent(form);
    }

    public void pauseApp() {
    
    }

    public void destroyApp(boolean unconditional){
        notifyDestroyed();
    }
    
    public void commandAction(Command c, Displayable d){
        
        if(c == exitCommand){
            destroyApp(true);
        }
        else if(c == addCommand){
        
        }
    }
    
}
