import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class ConnectionMIDlet extends MIDlet implements CommandListener{

	Form form;
	Display display;
	HttpConnection conn;
	Command exit;
	Command send;
	TextField user,pass;
	StringItem response;
	public ConnectionMIDlet(){
	
		display = Display.getDisplay(this);
		form = new Form("Tomcat Connection");
		exit = new Command("Exit",Command.EXIT,0);
		send = new Command("Send",Command.OK,1);
		user = new TextField("Username","",30,TextField.ANY);
		pass = new TextField("Pass","",30,TextField.ANY);
		response = new StringItem("Response","");
		
		form.append(user);
		form.append(pass);
		form.append(response);
		form.addCommand(send);
		form.addCommand(exit);
		form.setCommandListener(this);
		
		send();
	}
	
	public void startApp(){
		display.setCurrent(form);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){
		notifyDestroyed();
	}
	
	public void commandAction(Command c , Displayable d){
		if(c == exit){
			notifyDestroyed();
		}
		if(c == send){
			send();
		
		}
		
	}
	
	public void send(){
		String userName = user.getString();
			String password = pass.getString();
			try{
				conn = (HttpConnection)Connector.open("http://localhost:9090/GeneralServlet/EchoServlet?user="+userName+"&pass="+password);
				System.out.println("Connection established..");
				int rc = conn.getResponseCode();
				if (rc != HttpConnection.HTTP_OK) {
					System.out.println("Error in reponse Code");
				}else{
					DataInputStream dis = new DataInputStream(conn.openInputStream());
					StringBuffer b = new StringBuffer();
					int ch;
					while( (ch=dis.read())!='\n' ){
						b.append((char)ch);
					}
					System.out.println(b.toString());
					response.setText(""+b.toString());
				}
			}catch(Exception ex){ ex.printStackTrace(); }
	
	}
}