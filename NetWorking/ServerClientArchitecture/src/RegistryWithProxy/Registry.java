/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistryWithProxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Registry {
    Registry(){
        ArrayList<Socket> socketsList= new ArrayList();
        try{
            ServerSocket server = new ServerSocket(9000);
            do{
                Socket socket = server.accept();
                socketsList.add(socket);
                System.out.println("**Connected With :"+socket.getInetAddress().getHostAddress());
                
                for(int i=0;i<socketsList.size();i++){
                    try{
                        DataOutputStream out = new DataOutputStream(socketsList.get(i).getOutputStream());
                        out.writeUTF(""+socketsList.size());
                        for(int j=0;j<socketsList.size();j++){
                            out.writeUTF(socketsList.get(j).getInetAddress().getHostAddress());
                        }
                    }catch(Exception exc){
                        exc.printStackTrace();
                    }
                }
                new socketThread(socket , socketsList).start();
            }while(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void main(String arg[])throws Exception{
        new Registry();
    }
}
class socketThread extends Thread{
    Socket socket = null;
    ArrayList<Socket> list;
    socketThread(Socket s , ArrayList l){
        socket = s;
        list = l;
    }
    public void run(){
        try{
            new DataInputStream(socket.getInputStream()).readUTF();
        }catch(Exception ex){ 
            list.remove(socket);
            for(int i=0;i<list.size();i++){
                try{
                    DataOutputStream out = new DataOutputStream(list.get(i).getOutputStream());
                    out.writeUTF(""+list.size());
                    for(int j=0;j<list.size();j++){
                        out.writeUTF(list.get(j).getInetAddress().getHostAddress());
                    }
                }catch(Exception exc){
                    exc.printStackTrace();
                }
            }
        }
    }
}