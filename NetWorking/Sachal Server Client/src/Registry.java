import java.util.*;
import java.net.*;
import java.io.*;
public class Registry {
    
    Hashtable hashtable = new Hashtable();
    
    public static void main(String arg[])throws Exception{
        ServerSocket server = new ServerSocket(9000);
        do{
            Socket socket = server.accept();
            Registry r = new Registry();
            r.new HandleClient(socket).start();
        }while(true);
    }
    
    class HandleClient extends Thread{
        Socket socket;    
        HandleClient(Socket socket){
            this.socket = socket;
        }
        public void run(){
            try{
                hashtable.put(socket.getInetAddress().getHostName(), socket);
                sendConnectedClientListToAll();
                socket.getInputStream().read();
            }catch(Exception e){
                remove();
                sendConnectedClientListToAll();
                e.printStackTrace();}
        }
        void remove(){
            hashtable.remove(socket.getInetAddress().getHostName());
        }
        void sendConnectedClientListToAll(){
            String clientList = getClientList();
            Enumeration e =hashtable.keys();
            while(e.hasMoreElements()){
                String hostName = (String) e.nextElement();
                Socket tempSocket = (Socket) hashtable.get(hostName);
                try{
                    PrintStream out = new PrintStream(tempSocket.getOutputStream());
                    out.println(clientList);
                }catch(Exception e1){e1.printStackTrace();}
            } 
        }
        public String getClientList(){
            Enumeration e = hashtable.keys();
            String s = "";
            while(e.hasMoreElements()){
                String name = (String) e.nextElement();
                s+=name+",";
            }
            return s;
        }
    }
}
