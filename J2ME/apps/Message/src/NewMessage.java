import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

public class NewMessage implements CommandListener{
	
	Alert alert;
	
	Command back;
	Command save;
	
	TextBox textBox;
	
	Display display;
	Displayable parent;
	
	RecordStore store;
	
	public NewMessage(Display d , Displayable p, RecordStore s){
		display = d;
		parent = p;
		store = s;
		
		textBox = new TextBox("New Message","",500,TextField.ANY);
		back = new Command("back",Command.BACK,0);
		save = new Command("save",Command.OK,0);
		alert = new Alert("");
		alert.setTimeout(Alert.FOREVER);
		
		textBox.addCommand(back);
		textBox.addCommand(save);
		textBox.setCommandListener(this);
	}
	
	public void show(){
		display.setCurrent(textBox);
	}
	
	public void commandAction(Command c , Displayable d){
		String label = c.getLabel();
		
		if(label.equals("back")){
			display.setCurrent(parent);
		}
		else if(label.equals("save")){
			String s = textBox.getString();
			if(s.trim().equals("")){
				alert.setTimeout(1000);
				alert.setString("Empty Field..!");
				display.setCurrent(alert,textBox);
				return;
			}
			
			byte[] b = s.getBytes();
			try{
				int available = store.getSizeAvailable();
				if(b.length > available){
					alert.setString("Not Enough Memory To store..!");
				}else{
					store.addRecord(b,0,b.length);
					System.out.println("Record is saved..!");
					textBox.setString("");
					display.setCurrent(parent);
				}		
			}catch(Exception ex){ex.printStackTrace();}
		}
	}

}