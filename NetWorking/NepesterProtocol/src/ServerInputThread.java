
/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
        
public class ServerInputThread extends Thread{
    Socket socket;
    ServerInputThread(Socket s){
        socket = s;
    }
    public void run(){
        try{
        DataInputStream in = new DataInputStream(socket.getInputStream());
        String s = in.readUTF();
        System.out.println("recieved : "+s);
        if(s.contains("file")){
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Vector v = new Vector();
            v = DBManager.getAllFiles();
            out.writeUTF(""+v.size());
            for(int i =0 ; i<v.size(); i++){
                try{
                out.writeUTF((String)v.elementAt(i));
                }catch(Exception e){ e.printStackTrace();}
            }
        }
        else if(s.contains("download")){
            Vector v = DBManager.getAllIps();
            for(int i=0;i<v.size();i++){
                String temp = (String)v.elementAt(i);
                if(temp.contains(socket.getInetAddress().getHostAddress())){
                    int check=JOptionPane.showConfirmDialog(null, "you want to allow this"+socket.getInetAddress().getHostName()+" person to dpwnload file?");
                    if(check>0)socket.close(); }
            } 
            String filePath = in.readUTF();
            System.out.println(filePath);
            File f = new File(filePath);
            DataInputStream fileIn = new DataInputStream(new FileInputStream(f));
            int size = fileIn.available();
            System.out.println(size);
            int packetSize = 10000;
            int totalPacket = size/packetSize;
            int lastPacket = size%packetSize;
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(f.getName());
            out.writeUTF(""+size);
            out.writeUTF(""+packetSize);
            out.writeUTF(""+totalPacket);
            out.writeUTF(""+lastPacket);
            byte[] b = new byte[packetSize];
            for(int i=1;i<=totalPacket;i++){
                fileIn.readFully(b, 0, b.length);
                out.write(b, 0, b.length);
            }
                fileIn.readFully(b, 0, lastPacket);
                out.write(b, 0, lastPacket);
                
                fileIn.close();
                out.close();
        }
        
        socket.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
    
}
