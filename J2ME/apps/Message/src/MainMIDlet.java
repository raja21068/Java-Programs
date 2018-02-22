import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

public class MainMIDlet extends MIDlet implements CommandListener{
	
	Display display;
	
	List list;
	
	RecordStore store;
	
	NewMessage newMessage;
	Draft draft;
	
	public MainMIDlet(){
		display = Display.getDisplay(this);
		
		list = new List("Message",List.IMPLICIT);
		
		list.setCommandListener(this);
			
		try{
			list.append("New Message",Image.createImage("/message.png"));
			list.append("Inbox",Image.createImage("/inbox.png"));
			list.append("Draft",Image.createImage("/Draft.png"));
	
			//RecordStore.deleteRecordStore("messages");
			store = RecordStore.openRecordStore("messages",true);
			System.out.println("Number Of Records >> "+store.getNumRecords());
			
			newMessage = new NewMessage(display, list,store);
			draft = new Draft(display, list,store);
		
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(">>( Exception occured during getting RecordStore )");
		}
		
	}
	
	public void startApp(){
		display.setCurrent(list);
	}
	
	public void pauseApp(){}
	
	public void destroyApp(boolean b){
		notifyDestroyed();
	}
	
	public void commandAction(Command c, Displayable d){
		
		int index = list.getSelectedIndex();
		
		if(index == 0){
			newMessage.show();
		}
		else if(index == 1){}
		else if(index == 2){
			draft.show();
		}
		
	}

}