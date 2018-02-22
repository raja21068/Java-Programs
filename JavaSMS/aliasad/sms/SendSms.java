//package sms;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

/**
 *
 * @author Ali Asad Molwani
 */
public class SendSms implements SerialPortEventListener{
    
    public SendSms(){
        try{
            serialPort.addEventListener(this);
            in = serialPort.getInputStream();
            
            serialPort.notifyOnDataAvailable(true);
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    @Override
    public void serialEvent(SerialPortEvent e){
        if(e.getEventType() == SerialPortEvent.DATA_AVAILABLE){
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            try{
                while((line = reader.readLine()) != null)
                    System.out.println(line);
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
    
    
    public static void main(String arg[]){
        String textMode = "AT+CMGF=1\n";
        String sender = "AT+CMGS=\"" + "+923153028704" + "\"\n";
        String msg = "Hello World";
        
        String comPort = "COM33";
        
        Enumeration<CommPortIdentifier> e = CommPortIdentifier.getPortIdentifiers();
        while(e.hasMoreElements()){
            
            CommPortIdentifier commPort = e.nextElement();
            if(commPort.getName().equals(comPort)){
                
                try{
                    serialPort = (SerialPort)commPort.open("Sms_GSM", 0);
                    SendSms ob = new SendSms();
                    
                    out = serialPort.getOutputStream();
                    serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    
                    out.write(textMode.getBytes());
                    out.write(sender.getBytes());
                    out.write(msg.getBytes());
                    out.write(26);
                    out.flush();
                    
                    in.close();
                    out.close();
                    
//                    serialPort.close();
                }catch(Exception ex){ex.printStackTrace();}
                
            }
            
        }
    }
    
    private static SerialPort serialPort;
    private static OutputStream out;
    private static InputStream in;
}
