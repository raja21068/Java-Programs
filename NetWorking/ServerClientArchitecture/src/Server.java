
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Server{

    public static void main(String arg[]){
        try{
            ServerSocket server = new ServerSocket(9090);
            do{
                Socket socket = server.accept();
                new ServerThread(socket).start();
            }
            while(true); 
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
class ServerThread extends Thread{
    Socket socket;
    ServerThread(Socket s){
        socket = s;
    }
    public void run(){
        try{
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String destination = in.readUTF();
            Socket sendSocket = new Socket(destination,9000);
            DataOutputStream outToClient = new DataOutputStream(sendSocket.getOutputStream());
            String fileName = in.readUTF();
            outToClient.writeUTF(fileName);
            int fileSize = Integer.parseInt(in.readUTF());
            outToClient.writeUTF(""+fileSize);
            int packet = Integer.parseInt(in.readUTF());
            outToClient.writeUTF(""+packet);
            outToClient.writeUTF(in.readUTF());
            byte[] data= new byte[packet];
            for(int i=1;i<=(fileSize/packet);i++){
                in.readFully(data, 0, data.length);
                outToClient.write(data,0,data.length);
            }
                in.readFully(data, 0, (fileSize%packet));
                outToClient.write(data, 0, (fileSize%packet));
            
//                outToClient.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        finally{
            try{
//            socket.close();
            }catch(Exception exc){exc.printStackTrace();}
        }
    }
}