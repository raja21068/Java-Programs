import gps.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;


/**
 * <p>Connect a mobile phone to a Bluetooth GPS device.
 * When the connection is done, the latitude and the longitude are showing.</p>
 *
 * <p>This is a small example to know how the connection can be done with the GPS library.
 * There is only a connection with a new device research.</p>
 *
 * <p>License: This library is under the GNU Lesser General Public License.</p>
 *
 * @author Praplan Christophe
 * @author Velen Stephane
 * @version 1.0  <p>Geneva, the 23.03.2006
 */

public class Connection extends MIDlet implements CommandListener, Runnable {

    private BluetoothConnection bt = new BluetoothConnection();
    private GPS gps = new GPS(bt);
    private List listServers;
    private Command deviceSelection = new Command("Select", Command.SCREEN, 3);
    Screen screen;
    Thread thread = new Thread(this);

    public Connection() {

        //search for Bluetooth devices
        bt.searchDevices();
        //get the list of devices found
        listServers = bt.getDevicesList();
        listServers.addCommand(deviceSelection);
        listServers.setCommandListener(this);
        Display.getDisplay(this).setCurrent(listServers);
    }

    public void run() {
        Coordinates coord;
        while (true) {
            //get the coordinates
            coord = gps.getCoordinates();
            //show the latitude and longitude on the screen
            screen.show(coord.getLatitude(), coord.getLongitude());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == deviceSelection) {
            //connect the selected device
            bt.connectDevice(listServers.getSelectedIndex());
            screen = new Screen();
            thread.start();
            Display.getDisplay(this).setCurrent(screen);
        }
    }

    protected void startApp() throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean b) throws MIDletStateChangeException {
    }
}


//Class use to show the longitude and the latitude with a canvas
//License: This library is under the GNU Lesser General Public License
//author Praplan Christophe
//author Velen Stephane
//version 1.0  <p>Geneva, the 23.03.2006
class Screen extends Canvas {
    double latitude;
    double longitude;

    public Screen() {
    }

    protected void paint(Graphics graphics) {
        graphics.setGrayScale(255);
        graphics.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        graphics.setGrayScale(0);
        graphics.drawString("latitude : " + latitude, 10, 50, Graphics.TOP | Graphics.LEFT);
        graphics.drawString("longitude : " + longitude, 10, 90, Graphics.TOP | Graphics.LEFT);
    }

    public void show(double lat, double lon) {
        latitude = lat;
        longitude = lon;
        repaint();
    }
}