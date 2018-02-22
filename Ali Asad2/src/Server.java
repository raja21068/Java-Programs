import java.net.*;

class Server 
{
	public static void main(String arg[])throws Exception
	{
		ServerSocket server = new ServerSocket(9090);
		
		do{
			Socket socket = server.accept();
			RecievingThread r = new RecievingThread(socket);
			//r.setDaemon(true);
			r.start();
		}while(true);
	}
}
