import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.media.*;

public class MainMIDlet extends MIDlet{


	Display display;
	Form form;
	HttpConnection conn;
	InputStream in;
	Player player;
	
	public MainMIDlet(){
		display = Display.getDisplay(this);
		form = new Form("MP3 Player");
	}
	
	public void startApp(){
		display.setCurrent(form);
		new Thread(){
			public void run(){
				try{
					conn = (HttpConnection)Connector.open("http://localhost:9090/sound.wav");
					in = conn.openInputStream();
					player = Manager.createPlayer(in,"audio/x-wav"); 
		
					player.start();
	
				}catch(Exception ex){ ex.printStackTrace();}
			}
		}.start();
		
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}

}