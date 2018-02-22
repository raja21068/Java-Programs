import java.io.IOException;


class Server extends Thread {
	java.net.ServerSocket server; 
	Server(int serverIP)throws Exception{
		server = new java.net.ServerSocket(serverIP); 	
	}
	
	public void run(){
			try {
				do{
				java.net.Socket socket = server.accept();
				System.out.println("Connected with : "+socket.getPort());
				java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream());
				//java.io.PrintStream out = new java.io.PrintStream(socket.getOutputStream());
				new InputThread(socket.getPort(),in).start();
				}while(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static void main(String arg[]) throws Exception{
		Server server = new Server(9090);
			server.start();	
	}
	
}
class InputThread extends Thread{
	java.io.DataInputStream in;
	int portNo;
	InputThread(int socketPort,java.io.DataInputStream in){
		this.in = in;
		portNo = socketPort;
	}
	public void run(){
		try{
			do{
		String msg = in.readLine();
		System.out.println(portNo+" : "+msg);
			}
			while(true);
		}catch(Exception e){}
	}
}