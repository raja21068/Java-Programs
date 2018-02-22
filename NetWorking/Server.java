import java.io.*;
import java.net.*;

class Server{
	public static void main(String arg[]) throws Exception{
		ServerSocket server = new ServerSocket(9090);
		System.out.println("waiting for connection...");
		Socket socket = server.accept();
		System.out.println("connected with client...");
		DataInputStream in = new DataInputStream(socket.getInputStream());
		final DataInputStream inKey = new DataInputStream(System.in);
		final PrintStream out = new PrintStream(socket.getOutputStream());
		String msg="";
		new Thread(){
			public void run(){
				String m = ""; 
				try{
					do{
					m = inKey.readLine();
					out.println(m);
					}while(!(m.contains("exit")));
				}catch(IOException e){ e.printStackTrace(); }
			}
		}.start();
		do{
			msg = in.readLine();
			System.out.println("client says: "+msg);
		}
		while(!(msg.contains("exit")));
        }
}