import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

public class Draft implements CommandListener{
	
	Alert alert;
	
	Command back;
	Command view;
	Command delete;
	
	Display display;
	Displayable parent;
	RecordStore store;

	Form form;
	
	List list;
	
	StringItem str;
	
	Vector messages;
	
	public Draft(Display d, Displayable p , RecordStore s){
	
		display = d;
		parent = p;
		store = s;
		
		alert = new Alert("");
		back = new Command("back",Command.BACK,0);
		delete = new Command("delete",Command.ITEM,0);
		view = new Command("View",Command.OK,0);
		list = new List("Drafts",List.IMPLICIT);
		form = new Form("Saved Message");
		str = new StringItem("","");
		
		
		list.addCommand(back);
		list.addCommand(view);
		list.addCommand(delete);
		list.setCommandListener(this);
		
		form.append(str);
		form.addCommand(back);
		form.setCommandListener(this);
	
	}
	
	public void show(){
		list.deleteAll();
		try{	
			int num = store.getNumRecords();
			if(num <1){
				alert.setTimeout(1000);
				alert.setString("No any message..!");
				display.setCurrent(alert,parent);
			}else{
				messages = new Vector();
				
				enumerateRecord();
				
				display.setCurrent(list);
				return;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		display.setCurrent(parent);
	}
	
	
	public void commandAction(Command c, Displayable d){
		String label = c.getLabel();
		if(d == list){
			if(label.equals("back")){
				display.setCurrent(parent);
			}
			else if(label.equals("View")){
				int index = list.getSelectedIndex();
				str.setText((String)messages.elementAt(index));
				display.setCurrent(form);
			}
			else if(label.equals("delete")){
				try{
				int index = list.getSelectedIndex();
				String del = (String)messages.elementAt(index);
				System.out.println(del); 
				byte[] byteInputData = new byte[1];
				int length =0;
				for (int x = 1; x <= store.getNumRecords(); x++){
					if (store.getRecordSize(x) > byteInputData.length){
						byteInputData = new byte[store.getRecordSize(x)];
					}
					length = store.getRecord(x, byteInputData, 0);
					String mess = new String(byteInputData, 0, length);
					if( mess.equals(del)){
						store.deleteRecord(x);
						System.out.println("Record Deleted..");
						break;
					}
				}
				show();
				}catch(Exception ex){ ex.printStackTrace(); }
			}
		}
		if( d == form){
			if(label.equals("back")){
				display.setCurrent(list);
			}
		}
		
	}
	
	
	public void enumerateRecord()throws Exception{
		
		RecordEnumeration en = store.enumerateRecords(null, null,false);
		while(en.hasNextElement()){
			String mess = new String(en.nextRecord());
			messages.addElement(mess);
			if(mess.length()>10){
				list.append(mess.substring(0,10),null);
			}else{
				list.append(mess,null);
			}
		}
	}
	

	
		/*byte[] byteInputData = new byte[1]; 
			int length = 0;
				
				for (int x = 1; x < store.getNextRecordID(); x++){
					try{
						if (store.getRecordSize(x) > byteInputData.length){
							byteInputData = new byte[store.getRecordSize(x)];
						}
						length = store.getRecord(x, byteInputData, 0);
						String mess = new String(byteInputData, 0, length);
						messages.addElement(mess);
						if(mess.length()>10){
							list.append(mess.substring(0,10),null);
						}else{
							list.append(mess,null);
						}
					}catch(InvalidRecordIDException ex){System.out.println("Invalid ID: "+x);}
					length = 0;
				}
				*/
}