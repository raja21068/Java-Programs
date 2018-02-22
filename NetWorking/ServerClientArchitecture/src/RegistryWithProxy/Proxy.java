/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistryWithProxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Proxy {
    Proxy(){
        try{
            ServerSocket server = new ServerSocket(9090);
            do{
                Socket socket = server.accept();
                new SendFileToClient(socket).start();
            }while(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void main(String arg[]){
        new Proxy();
    }
}
class SendFileToClient extends Thread{
    Socket socket=null;
    SendFileToClient(Socket s){
        socket = s;
    }
    public void run(){
        try{
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String ip = in.readUTF();
            String fileName = in.readUTF();
            String size = in.readUTF();
            String packet = in.readUTF();
            
            Socket sendSocket = new Socket(ip,8000);
            DataOutputStream out = new DataOutputStream(sendSocket.getOutputStream());
            
            out.writeUTF(fileName);
            out.writeUTF(size);
            out.writeUTF(packet);
            
            int pack = Integer.parseInt(packet);
            int sizee = Integer.parseInt(size);
            int total = pack/sizee;
            int last = pack%sizee;
            byte data[] = new byte[pack];
            
            for(int i=0;i<sizee;i++){
                in.readFully(data, 0, data.length);
                out.write(data, 0, data.length);
            }
              in.readFully(data, 0, last);
                out.write(data, 0, last);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"send File in Proxy\n"+ ex);
        }
    }
}
