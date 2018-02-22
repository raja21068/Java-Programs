import java.io.*;
import java.net.*;
import java.util.*;

public class Server{

	ServerSocket server;
	DataInputStream in;
	DataOutputStream out ;
	public Server()throws Exception{
			server = new ServerSocket(9999);
			System.out.println("Server Started...");
			
				Socket client = server.accept();
				System.out.println("Client Connected..");
				in = new DataInputStream(client.getInputStream());
				out = new DataOutputStream(client.getOutputStream());
				
				new Thread(){
					public void run(){
						try{
						do{
							String s = in.readUTF();
							System.out.println("client:"+s);
						}while(true);
					}catch(Exception ex){ex.printStackTrace();}
					}
				}.start();
				
				new Thread(){
					public void run(){
						Scanner scan = new Scanner(System.in);
						try{
						do{
							System.out.print("Me:");
							String s = scan.nextLine();
							out.writeUTF(s);
						}while(true);
					}catch(Exception ex){ex.printStackTrace();}
					}
				}.start();
				
				
				
	}
	
	public static void main(String arg[]){
		try{
			Server s = new Server();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
} 