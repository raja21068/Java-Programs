import java.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.io.*;

public class ConnectorMIDlet extends MIDlet implements CommandListener{
	
	Display display;
	TextBox form;
	StreamConnection sc;
	Command send;
	Command exit;
	
	DataOutputStream out;
	DataInputStream in;
	
	public ConnectorMIDlet(){
		display = Display.getDisplay(this);
		form = new TextBox("Connector","",120,TextField.ANY);
		send = new Command("Send",Command.OK,1);
		exit = new Command("Exit",Command.EXIT,0);
		
		form.addCommand(send);
		form.addCommand(exit);
		
		form.setCommandListener(this);
		
		try{
			sc = (StreamConnection)Connector.open("socket://localhost:9999");
			in = sc.openDataInputStream();
			out = sc.openDataOutputStream();
			
			new Thread(){
				public void run(){
				try{
					do{
					String s = in.readUTF();
					System.out.println(s);
					while(true);
					}catch(Exception ex){ex.printStackTrace();}
				}
			}.start();
		}catch(Exception ex){ ex.printStackTrace();}
		
	}
	
	public void startApp(){
		display.setCurrent(form);
		
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	
	public void commandAction(Command c,Displayable d){
		if(c == exit){
			notifyDestroyed();
		}
		if(c == send ){
			try{
				String s = form.getString();
				out.writeUTF(s);
				out.flush();
				System.out.println("Message sent..");
				form.setString("");
			}catch(Exception ex){System.out.println("Sending failed");}
		}
	}
}