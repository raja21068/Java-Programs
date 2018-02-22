import javax.comm.*;
import java.io.*;
import java.util.*;

public class SimpleWrite implements Runnable, SerialPortEventListener
{
    public void run()
    {}

    static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString = "Dont consider this sms, just for testing....:-D";
    static char ch = '"';
    static String dest = ch + "+923342632765" + ch;  // 10 Digit Mobile Number.
    static InputStream inputStream;

    static SerialPort serialPort;
    static OutputStream outputStream;

    public void serialEvent(SerialPortEvent event)
    {
        switch (event.getEventType())
        {
        case SerialPortEvent.BI:
        case SerialPortEvent.OE:
        case SerialPortEvent.FE:
        case SerialPortEvent.PE:
        case SerialPortEvent.CD:
        case SerialPortEvent.CTS:
        case SerialPortEvent.DSR:
        case SerialPortEvent.RI:
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
        case SerialPortEvent.DATA_AVAILABLE:
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            try
            {

                while ( (line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            catch (IOException e)
            {
                System.err.println("Error while reading Port " + e);
            }
            break;

        }
        } //switch
    }

    public SimpleWrite(SerialPort serial)
    {
        try
        {
            inputStream = serial.getInputStream();
            try
            {
                serial.addEventListener(this);
            }
            catch (TooManyListenersException e)
            {
                System.out.println("Exception in Adding Listener" + e);
            }
            serial.notifyOnDataAvailable(true);

        }
        catch (Exception ex)
        {
            System.out.println("Exception in getting InputStream" + ex);
        }

    }

    public static void main(String[] args)
    {
        String line1 = "AT+CMGF=1\r\n";
        String line2 = "AT+CMGS=" + dest + "\r\n";
        String line3 = messageString + "\r\n";
        //String line1 = "AT+CREG=2";
        //String line2 = "AT+CGREG?";

        portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements())
        {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                if ( portId.getName().equals("COM4"))
                {
                    System.out.println("SMS Sending....Port Found");
                    try
                    {
                        serialPort = (SerialPort) portId.open("Sms_GSM", 0);
                        SimpleWrite wr = new SimpleWrite(serialPort);

                    }
                    catch (PortInUseException e)
                    {
                        System.out.println("Port In Use " + e);
                    }
                    try
                    {
                        outputStream = serialPort.getOutputStream();
                    }
                    catch (IOException e)
                    {
                        System.out.println("Error writing to output stream " + e);
                    }
                    try
                    {
                        serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    }
                    catch (UnsupportedCommOperationException e)
                    {
                    }
                    try
                    {
                        outputStream.write(line1.getBytes());
                        outputStream.write(line1.getBytes());
                        outputStream.write(line2.getBytes());
                        outputStream.write(line3.getBytes());
                        outputStream.write(26);
                        outputStream.flush();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error writing message " + e);
                    }
                }
            }
        }
    }

    /** show text in the text window
     * @param Text text string to show on the display
     */
    public static void showText(String Text)
    {
        System.out.println(Text);
    }
}
