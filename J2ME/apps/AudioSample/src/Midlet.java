
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Midlet extends MIDlet {
      private Display display;
      AudioPlayer ap;

      public void startApp() {
            display = Display.getDisplay(this);
            ap = new AudioPlayer(this, display);
            display.setCurrent(ap);
      }

      public void pauseApp() {
      }

      public void destroyApp(boolean unconditional) {
            notifyDestroyed();
      }
}
