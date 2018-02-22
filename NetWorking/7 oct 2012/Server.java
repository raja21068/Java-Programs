import java.net.*;
import java.util.Vector;
import java.io.*;
class Server {
	
	
	public static void main(String arg[]){
		try{
			ServerSocket server= new ServerSocket(9000); 	
			Vector v = new Vector();
			do{
				try{
					System.out.println("Waiting...");
					Socket socket = server.accept();
					System.out.println("Connected with : "+socket.getInetAddress());
					v.addElement(socket);
					new ClientThread(v , socket).start();
                                        for(int i =0 ;i<v.size(); i++ ){
                                            Socket s = (Socket)v.elementAt(i);
                                            DataOutputStream out = new DataOutputStream(s.getOutputStream());
                                            out.writeUTF(""+v.size());
                                            for(int k=0;k<v.size();k++ ){
                                               Socket s2 = (Socket)v.elementAt(i);
                                                out.writeUTF(s2.getInetAddress().getHostAddress());
                                            }
                                        }
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
				out.writeUTF(s.getInetAddress().getHostAddress());
			}
		}while(true);
		}
		catch(SocketException e){ vec.remove(socket); 
			for(int i =0 ;i<vec.size(); i++ ){
                              try{  
                            Socket s = (Socket)vec.elementAt(i);
                                          DataOutputStream out = new DataOutputStream(s.getOutputStream());
                                            out.writeUTF(""+vec.size());
                                            for(int k=0;k<vec.size();k++ ){
                                               Socket s2 = (Socket)vec.elementAt(i);
                                                out.writeUTF(s2.getInetAddress().getHostAddress());
                                            }
                                        }catch(Exception e1){e1.printStackTrace();}
		}
		
		
	}catch(IOException e){e.printStackTrace();}
    }
}
