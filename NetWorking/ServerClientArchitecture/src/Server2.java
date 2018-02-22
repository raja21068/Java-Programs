
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Server2 {
    ArrayList<Socket> socketsList = new ArrayList();
    Server2(){
        try{
            ServerSocket server = new ServerSocket(9090);
            do{
                Socket socket  = server.accept();
                System.out.println("connected with "+socket.getInetAddress().getHostAddress());
                socketsList.add(socket);
                new NewSocket(socket, socketsList).start();
            }while(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    public static void main(String arg[]){
        new Server2();
    }
    
}
class NewSocket extends Thread{
    Socket socket;
    ArrayList<Socket> arrayList;
    NewSocket(Socket s , ArrayList list){
        socket = s;
        arrayList = list;
        //** sending all ip address of all sockets to sockets**\\
        try{
            for(int i=0;i<arrayList.size();i++){
                DataOutputStream out = new DataOutputStream(arrayList.get(i).getOutputStream());
                out.writeUTF("list");
                out.writeUTF(""+arrayList.size());
                for(int j=0;j<arrayList.size();j++){
                    out.writeUTF(arrayList.get(i).getInetAddress().getHostAddress());
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void run(){
        try{
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            do{
            String check = inFromClient.readUTF();
            if(check.contains("file")){
                //*geting file from client*\\
                String ip = inFromClient.readUTF();
                Socket sendSocket=null;
                for(int i=0;i<arrayList.size();i++){
                    if(ip.contains(arrayList.get(i).getInetAddress().getHostAddress())){
                        sendSocket = arrayList.get(i);
                        break;
                    }
                }
                DataOutputStream outTohost = new DataOutputStream(sendSocket.getOutputStream());
                outTohost.writeUTF("download");
                String fileName = inFromClient.readUTF();
                outTohost.writeUTF(fileName);
                int size = Integer.parseInt(inFromClient.readUTF());
                outTohost.writeUTF(""+size);
                int packet = Integer.parseInt(inFromClient.readUTF());
                outTohost.writeUTF(""+packet);
                byte[] data = new byte[packet];
                for(int i=0;i<=(size/packet);i++){
                    inFromClient.readFully(data, 0, data.length);
                    outTohost.write(data, 0, data.length);
                }
                inFromClient.readFully(data, 0, (size%packet));
                outTohost.write(data, 0, (size%packet));
                outTohost.close();
            }
            }while(true);
        }catch(Exception ex){
            arrayList.remove(socket);
        }
         for(int i=0;i<arrayList.size();i++){
             try{   
                DataOutputStream out = new DataOutputStream(arrayList.get(i).getOutputStream());
                out.writeUTF("list");
                out.writeUTF(""+arrayList.size());
                for(int j=0;j<arrayList.size();j++){
                    out.writeUTF(arrayList.get(i).getInetAddress().getHostAddress());
                }
            }catch(Exception ex){ex.printStackTrace();}
         }
    }
}