import java.io.*;
import java.net.*;


class Server {
	public static void main(String arg[]) throws Exception{
			ServerSocket server= new ServerSocket(9090); 	
			do{
					Socket socket = server.accept();
					System.out.println("Connected with : "+socket.getLocalPort());
		
					new InputThread(socket).start();
			}while(true);
	}
}

class InputThread extends Thread{
	private Socket socket;
	InputThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try{
			DataInputStream in=new DataInputStream(socket.getInputStream());
					
			String fileName = in.readLine();
			int packetSize = Integer.parseInt(in.readLine());
			int totalPacket =Integer.parseInt(in.readLine());
			int lastPacket =Integer.parseInt(in.readLine());
					
			byte[] b = new byte[packetSize];

			File f=new File("d:/download-files");
			f.mkdirs();
			
			
			FileOutputStream file=new FileOutputStream(f.getAbsolutePath()+"\\"+fileName);
			
			for(int i=1;i<=totalPacket;i++){
				in.readFully(b, 0, b.length);
				file.write(b, 0, b.length);
			}
			
			in.readFully(b, 0, lastPacket);
			file.write(b, 0, lastPacket);
			
			System.out.println("FileRecieved..");

			in.close();
			file.close();
			socket.close();
			
		}catch(Exception e){ 
			e.printStackTrace();
	    }
	}
}