import javax.microedition.midlet.*;import javax.microedition.lcdui.*;public class MainMIDlet extends MIDlet{		GridCanvas can;		public void startApp(){		can = new GridCanvas();		Display.getDisplay(this).setCurrent(can);			}	public void pauseApp(){}	public void destroyApp(boolean b){}	}