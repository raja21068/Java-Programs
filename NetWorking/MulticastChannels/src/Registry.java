import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Jay Kumar
 */
public class Registry extends Thread{
    
    public void run(){
        try{
            ArrayList<String> channel = new ArrayList();
            ServerSocket server = new ServerSocket(9000);
            do{
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String identify = in.readUTF();
                if(identify.contains("channel")){
                    String newChannel = in.readUTF();
                    String[] ipcheck = newChannel.split("'"); 
                    for(int i=0;i<channel.size();i++){
                        if(channel.get(i).contains(ipcheck[0].trim())){
                            channel.remove(i);
                        }
                    }
                    System.out.println("Registry: "+newChannel);
                    channel.add(newChannel);
                }
                else if(identify.contains("host")){
                    System.out.println("host entered");
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    for(int i=0;i<channel.size();i++){
                        out.writeUTF((String)channel.get(i));
                    }
                    out.writeUTF("exit");
                }
            }while(true);
        }
        catch(Exception e){e.printStackTrace();}
    }
    public static void main(String arg[]){
        new Registry().start();
    }
}