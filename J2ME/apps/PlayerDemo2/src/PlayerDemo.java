import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.io.*;
import java.io.*;
import javax.microedition.media.*;


public class PlayerDemo extends MIDlet implements CommandListener{

	Form mainForm = new Form("Player");
	Command connectCmd = new Command("Connect", Command.SCREEN, 0);
	Display dis;
	
	public PlayerDemo(){
		mainForm.addCommand(connectCmd);
		mainForm.setCommandListener(this);
	}
	
	public void startApp()
    {
		dis = Display.getDisplay(this);
        dis.setCurrent(mainForm);
    }
	
	public void pauseApp()
    {
    }

    public void destroyApp(boolean unconditional)
    {
		notifyDestroyed();
    }
	
	private void connectAndPlay(){
	
		new Thread(){
			public void run(){
			  try{
					String url = "http://localhost:9090/sound.wav";
					HttpConnection  hc =  (HttpConnection)Connector.open(url);
					
					// reading response of a servlet
				
				    InputStream is = hc.openInputStream();
					
					//playing wav music
					Player p = Manager.createPlayer(is, "audio/x-wav");
					p.start();
	
	
			  }catch(Exception e){ e.printStackTrace();}
			}
		}.start();
	}
	
	public void commandAction(Command c, Displayable d){
      String label = c.getLabel();
	  
	  if(label.equals("Connect")){
		connectAndPlay();
	  }

	}
	
	




}