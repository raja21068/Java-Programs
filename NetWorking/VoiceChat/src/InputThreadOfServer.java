
/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import java.io.*;
import javax.swing.JFrame;

public class InputThreadOfServer extends Thread{
    Socket socket;
    InputThreadOfServer(Socket socket){
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
                        new PlayVoice( new File(f.getAbsolutePath()+"\\"+fileName));
                        
        }catch(Exception e){e.printStackTrace();}
    
    }
}
