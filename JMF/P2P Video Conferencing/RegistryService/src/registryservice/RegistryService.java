package registryservice;

/**
 * Title:        RegistryServer
 * Description:  This server use to manage clients.
 * Copyright:    Copyright (c) 2011
 * Company:      IMCS, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         07 January, 2012
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class RegistryService extends Thread{
    private int port;
    private Hashtable<String, Socket> hashtable;
    
    public RegistryService(int port){
        this.port = port;
        hashtable = new Hashtable<String, Socket>();
    }
    
    @Override
    public void run(){
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server started on ["+port+"] port successfully...");
            do{
                try{
                    Socket socket = server.accept();
                    new ClientHandler(socket).start();
                }catch(Exception ee){ee.printStackTrace();}
            }while(true);
        }catch(Exception e){e.printStackTrace();}
    }
    
    private class ClientHandler extends Thread{
        private Socket socket;
        private InetAddress inetAddress;

        private ClientHandler(Socket socket){
            this.socket = socket;
            this.inetAddress = socket.getInetAddress();
        }
        @Override
        public void run(){
            try{
                System.out.println("["+inetAddress.getHostAddress() + "] Client is Connected...");
                hashtable.put(inetAddress.getHostName(), socket);
                sendListToAllClient();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                
                do{
                    String headers = (String) in.readLine();
                }while(true);
            }catch(IOException e){
                System.out.println("Client is Disconnected...");
                removeClient(inetAddress.getHostName());
                sendListToAllClient();
            }
        }
        
        private void removeClient(String hostName){
            hashtable.remove(hostName);
        }
        
        private void sendListToAllClient(){            
            try{
                Enumeration<Socket> e = hashtable.elements();
                String list = "";
                while(e.hasMoreElements()){
                    Socket s = e.nextElement();
                    list = list + s.getInetAddress().getHostName() + "[]" + s.getInetAddress().getHostAddress() + "+";
                }
                e = hashtable.elements();
                while(e.hasMoreElements()){
                    Socket s = e.nextElement();
                    PrintStream out=new PrintStream(s.getOutputStream());
                    out.println(list);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new RegistryService(7777).start();
    }
}
