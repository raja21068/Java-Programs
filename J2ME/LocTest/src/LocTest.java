import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.location.*;
 
public class LocTest extends MIDlet implements CommandListener
{
    private Display display;
    private Form form;
    private Command cmdExit,cmdOK;
    private StringItem si;
 
    public LocTest()
    {
 
        display =Display.getDisplay(this);
        form = new Form("Location Api test");
        cmdExit = new Command("Exit",Command.EXIT,5);
        cmdOK = new Command("OK",Command.OK,1);
        si = new StringItem("Geo Location", "Click OK");
        form.append(si);
        form.addCommand(cmdOK);
        form.addCommand(cmdExit);
        form.setCommandListener(this);
 
    }
 
    public void startApp()
    {
        display.setCurrent(form);
    }
 
 
    public void pauseApp()
    {
 
    }
 
    public void destroyApp(boolean flag) {
        notifyDestroyed();
    }
 
    public void commandAction(Command c, Displayable d)
    {
        if (c == cmdOK){
            Retriever ret = new Retriever(this);
            ret.start();
 
        } else if (c == cmdExit) {
            destroyApp(false);
        }
    }
 
    public void displayString(String string)
    {
        si.setText(string);
    }
}
 
class Retriever extends Thread {
 
    private LocTest midlet;
 
        public Retriever(LocTest midlet)
        {
            /**
              * Constructor
              *
              * EFFECTS: Initialise the server and store midlet information
              *
              * @param midlet The main application midlet
              * @param server Forecast Server URL
              *
              */
            this.midlet = midlet;
 
    }
 
    public void run()
        {
            /**
            * Entry point of the thread
            *
            * EFFECTS: call to connect() method
            */
			int counter=0;
do{

            try {
			counter++;
                            checkLocation(counter);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                            midlet.displayString(ex.toString());
                         }
}while(true);						 
        }
 
    public void checkLocation(int counter) throws Exception
    {
        String string;
        Location l;
        LocationProvider lp;
        Coordinates c;
        // Set criteria for selecting a location provider:
        // accurate to 500 meters horizontally
        Criteria cr= new Criteria();
        //cr.setHorizontalAccuracy(1);
 
        // Get an instance of the provider
        lp= LocationProvider.getInstance(cr);
 
        // Request the location, setting a one-minute timeout
        l = lp.getLocation(-1);
        c = l.getQualifiedCoordinates();
 
        if(c != null ) {
          // Use coordinate information
          double lat = c.getLatitude();
          double lon = c.getLongitude();
          double alt = c.getAltitude();
          string = "\nLatitude : " + lat + "\nLongitude : " + lon + "\nAltitude : " +alt+"\nCounter: "+counter;
 
        } else {
            string ="Location API failed";
        }
        midlet.displayString(string);
    }
}
//- See more at: http://mobilepit.com/05/javame-location-api-example-application-with-source-code.html#sthash.GcuHITAM.dpuf
