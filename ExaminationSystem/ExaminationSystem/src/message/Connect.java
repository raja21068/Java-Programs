package message;


import java.io.*;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

/**
 *
 * @author DELL
 */
public class Connect implements  SerialPortEventListener
{
    
    String line1 ;
    String line2 ;
    int index=0;
    
    CommPortIdentifier portId;
    String messageString = "Dont consider this sms, just for testing....:-D";
    char ch = '"';
    String dest ="";
    String s = "";
    InputStream inputStream;

    SerialPort serialPort;
    OutputStream outputStream;

    public Connect(String port)throws Exception
    {
            portId = CommPortIdentifier.getPortIdentifier(port);

            serialPort = (SerialPort) portId.open("Sms_GSM", 0);
            System.out.println("SMS Sending....Port Found");
            
            inputStream = serialPort.getInputStream();                    
            outputStream = serialPort.getOutputStream();
            
            serialPort.notifyOnDataAvailable(true);
            
            serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("setted serial port parameters");
            recieve();
    }
    
    
    public void addEventListener(SerialPort serial){
        
        try{
            serialPort.addEventListener(this);
        }
        catch (TooManyListenersException e){
            System.out.println("Exception in Adding Listener" + e);
        }
    }
    
    @Override
    public void serialEvent(SerialPortEvent event)
    {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
        index = 0;
        if(event.getEventType()==SerialPortEvent.DATA_AVAILABLE){
            try {
                while((s=input.readLine())!=null){
                    System.out.println("line : "+s);
                    if(s.contains("CMTI")){
                        new Thread(){
                            public void run(){
                                if((index=s.indexOf(','))!=-1){
                                    s=s.substring(index+1);
                                    index = Integer.parseInt(s.trim());
                                    System.out.println("Index:"+index);
                                    try {
                                        outputStream.write("AT+CMGF=1\r\n".getBytes());
                                        outputStream.write(("AT+CMGR="+index+"\r\n").getBytes());
                                        outputStream.flush();
                                    
                                        Thread.sleep(200);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                    
                                }
                            }
                        }.start();
                    }
                    if(s.contains("+CMGR:")){
                            String msg = (s+"\n"+input.readLine());
                            System.out.println("Message: "+msg);
                            String from = msg.split(",")[1];
                            String message = msg.substring(msg.lastIndexOf("\"")+1);

                            new MessageHandler(from.replaceAll("\"", ""),message ).start();
                            deleteMessage(index);
                    }
                    
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();}        
        }
      
    }
    
    synchronized public void send(String phoneNo,String message){
        dest = ch + phoneNo + ch;
        messageString = message;
        System.out.println("To: "+dest);
        System.out.println("Message: "+message);
        
        line1 = "AT+CMGF=1\n";
        line2 = "AT+CMGS=" + dest + "\n";
         
        //String line1 = "AT+CREG=2";
        //String line2 = "AT+CGREG?";
        try
        {
            Thread.sleep(400);
            System.out.println("now sending...");
            
            outputStream.write(line1.getBytes());
            outputStream.write(line2.getBytes());
            outputStream.write(messageString.getBytes());
            outputStream.write(26);
            outputStream.flush();
            Thread.sleep(400);
        }
        catch (Exception e)
        {
            System.out.println("Error writing message " + e);
        }
        
    }
    public void contactEntries(int index){
        String command = "AT+CPBR="+index+"\r\n";
        try{
            outputStream.write(command.getBytes());
            outputStream.flush();
            byte[] b = new byte[20];
            inputStream.read(b , 0,20);
            String s = new String(b,0,b.length);
            System.out.println("read : "+s+": length"+s.trim().length() );
        }catch (Exception e){
            System.out.println("Error writing message " + e);
        }
       
    }
    
    public void recieve(){
        try{
            String s = "AT+CNMI=1,1,0,0,0\r";
            String source = "AT+CPMS=\"SM\"\r\n";
            outputStream.write(s.getBytes());
            outputStream.write(source.getBytes());
            outputStream.flush();
            addEventListener(serialPort);
        }catch(Exception ex){ex.printStackTrace();}
   }
    synchronized public void deleteMessage(int index){
        String source = "AT+CMGD="+index+"\r\n";
        try {
            outputStream.write(source.getBytes());
            outputStream.flush();
        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
