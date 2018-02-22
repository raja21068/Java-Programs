import java.io.*;
import java.net.*;

class Client{
	public static void main(String arg[])throws Exception{
		System.out.println("waiting for connection...");
		Socket socket = new Socket("127.0.0.1",9090);
		System.out.println("connected with server...");
		final DataInputStream in = new DataInputStream(socket.getInputStream());
		DataInputStream inKey = new DataInputStream(System.in);
		PrintStream out = new PrintStream(socket.getOutputStream());
		String msg="";
		new Thread(){
			public void run(){
				String m = "";
				try{
					do{
					m = in.readLine();
					System.out.println("Server says: "+m);
					}while(!(m.contains("exit")));
				}catch(IOException e){ e.printStackTrace(); }
			}	
		}.start();
		do{
			System.out.println("Enter MSg:");
			msg = inKey.readLine();
			out.println(msg);
		} while(!(msg.contains("exit")));
		
        }
}