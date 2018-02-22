

import java.net.*;
import java.util.Vector;
import java.io.*;
import javax.swing.*;
public class RegistrySystem {
	
	public static void main(String arg[]){
		JFrame frame = new JFrame();
                JList list = new JList();
                frame.setTitle("Server");
                frame.setBounds(200, 200, 200, 200);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.getContentPane().add(list);
                frame.setVisible(true);
            try{
			ServerSocket server= new ServerSocket(8000); 	
			Vector v = new Vector();
			do{
				try{
                                        Vector listVector = new Vector();
					System.out.println("Waiting...");
					Socket socket = server.accept();
					System.out.println("Connected with : "+socket.getInetAddress());
					v.addElement(socket);
					new ClientThread(v , socket , list).start();
                                        System.out.println("*********");
                                        list.removeAll();
                                        for(int i =0 ;i<v.size(); i++ ){
                                            Socket s = (Socket)v.elementAt(i);
                                           listVector.addElement(s.getInetAddress().getHostAddress());
                                            System.out.println(s.getInetAddress().getHostAddress());
                                            DataOutputStream out = new DataOutputStream(s.getOutputStream());
                                            out.writeUTF(""+v.size());
                                            for(int k=0;k<v.size();k++ ){
                                               Socket s2 = (Socket)v.elementAt(k);
                                                out.writeUTF(s2.getInetAddress().getHostAddress());
                                            }
                                        }
                                        list.setListData(listVector);
				}catch(Exception e){e.printStackTrace(); }
                                
			}while(true);
		}catch(Exception e){e.printStackTrace();}			
	}
}

class ClientThread extends Thread{
	Vector vec;
	Socket socket;
        JList list;
	ClientThread(Vector v, Socket socket, JList list){
		vec = v;
		this.socket = socket;
                this.list = list;
	}
	public void run(){
		try{ 
                             DataInputStream in = new DataInputStream(socket.getInputStream());
                             in.readUTF();
                             System.out.println("done");
		}
		catch(SocketException e){ 
                    vec.remove((Object)socket);
                    Vector listVector = new Vector();
                    System.out.println("*****disconnect*****");
                    for(int i =0 ;i<vec.size(); i++ ){
                              try{  
                                Socket s = (Socket)vec.elementAt(i);
                                listVector.addElement(s.getInetAddress().getHostAddress());
                                System.out.println(s.getInetAddress().getHostAddress());
                                          DataOutputStream out = new DataOutputStream(s.getOutputStream());
                                            out.writeUTF(""+vec.size());
                                            for(int k=0;k<vec.size();k++ ){
                                               Socket s2 = (Socket)vec.elementAt(k);
                                                out.writeUTF(s2.getInetAddress().getHostAddress());
                                            }
                                            
                                        }catch(Exception e1){e1.printStackTrace();}
                              //list.setListData(vec);
		}
		
		list.setListData(listVector);
	}catch(IOException e){e.printStackTrace();}
         catch(Exception e){}
    }
}