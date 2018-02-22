/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

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
public class DailCall implements SerialPortEventListener{


    public DailCall(){
        try{
            serialPort.addEventListener(this);
            in = serialPort.getInputStream();
            serialPort.notifyOnDataAvailable(true);
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    @Override
    public void serialEvent(SerialPortEvent e){
        if(e.getEventType() == SerialPortEvent.DATA_AVAILABLE){
            System.out.println("Event occured!!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            try{
                while((line = reader.readLine()) != null)
                    System.out.println(line);
            }catch(Exception ex){ex.printStackTrace();}
        }
    }
    
    
    public static void main(String arg[]){
        String call = "ATD03342632765;\n";  // Dail number
        //String call = "ATDL\n";      // Redial last called number
        //String call = "ATDS<location>\n"  // Dail stored number at location
        String comPort = "COM8";    
        
        Enumeration<CommPortIdentifier> e = CommPortIdentifier.getPortIdentifiers();
        while(e.hasMoreElements()){
            
            CommPortIdentifier commPort = e.nextElement();
            if(commPort.getName().equals(comPort)){
                
                try{
                    System.out.println("Port is found!!");
                    serialPort = (SerialPort)commPort.open("Sms_GSM", 0);
                    DailCall ob = new DailCall();
                    
                    out = serialPort.getOutputStream();
                    serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    
                    out.write(call.getBytes());
                    out.flush();
                    
                    while(true){
                        
                    }
                    
                }catch(Exception ex){ex.printStackTrace();}
                
            }
            
        }
    }
    
    private static SerialPort serialPort;
    private static OutputStream out;
    private static InputStream in;
}


