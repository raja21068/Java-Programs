
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jay Kumar
 */
public class RequestListener extends Thread{
    
    @Override
    public void run(){
        try{
            ServerSocket server = new ServerSocket(PortConfig.REQUEST_LISTENER_PORT);
            TransmitVideo transmit = new TransmitVideo();
            do{
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                int port = Integer.parseInt(in.readUTF().trim());
                System.out.println(port);
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println(ip);
                transmit.startTransmission(transmit.getProcessAcknowledge(), ip, port);
                System.out.println("Transmitting..");
            }while(true);
        }catch(Exception ex){
            ex.printStackTrace();
        }
 
    }
    
}
