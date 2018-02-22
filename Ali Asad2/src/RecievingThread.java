import java.io.*;
import java.net.*;

class RecievingThread extends Thread
{
	private Socket socket;
	RecievingThread(Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		try{
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String fileName = in.readLine();
			long fileSize = Long.parseLong(in.readLine());
			int packetSize = Integer.parseInt(in.readLine());
			int totalPackets = Integer.parseInt(in.readLine());
			int lastPacket = Integer.parseInt(in.readLine());
			
			File dir = new File("d:\\downloads");
			if(!dir.exists())
				dir.mkdir();
			
			PrintStream out = new PrintStream(new FileOutputStream(dir + "\\" + fileName));
			byte data[] = new byte[packetSize];
			
			for(int k=1 ; k<=totalPackets ; k++)
			{
				in.readFully(data, 0, packetSize);
				out.write(data, 0 , packetSize);
			}
			in.readFully(data, 0, lastPacket);
			out.write(data, 0 , lastPacket);
			
			socket.close();
			in.close();
			out.close();
		}catch(Exception ex){}
	}
}
