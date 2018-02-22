import java.net.*;
import java.util.Vector;
import java.io.*;
public class ServerWithList {
	
	
	public static void main(String arg[]){
		try{
			ServerSocket server= new ServerSocket(9090); 	
			Vector v = new Vector();
			do{
				try{
					System.out.println("Waiting...");
					Socket socket = server.accept();
					System.out.println("Connected with : "+socket.getInetAddress());
					v.addElement(socket);
					new ClientThread(v , socket).start();
					}catch(Exception e){e.printStackTrace(); }
			}while(true);
		}catch(Exception e){e.printStackTrace();}			
	}
}

class ClientThread extends Thread{
	Vector vec;
	Socket socket;
	ClientThread(Vector v, Socket socket){
		vec = v;
		this.socket = socket;
	}
	public void run(){
		try{
		do{
			DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
			for(int i=0 ; i<vec.size() ; i++){
				Socket s = (Socket)vec.elementAt(i);
				out.writeChars(s.getInetAddress().getHostAddress());
			}
		}while(true);
		}
		catch(SocketException e){ vec.remove(socket); 
			for(int i=0 ; i<vec.size() ; i++){
				try{
					Socket s = (Socket)vec.elementAt(i);
					DataOutputStream out = new DataOutputStream(s.getOutputStream());
					out.writeChars(s.getInetAddress().getHostAddress());
				}catch(Exception ex){ ex.printStackTrace();}
			}
		}
		catch(IOException e){ e.printStackTrace(); }
		
		
	}
}
