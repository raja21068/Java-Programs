import java.net.ServerSocket;
import java.io.FileOutputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.File;
import java.io.PrintStream;
/**
 *
 * @author Ali Asad
 */
public class RecievingThread extends Thread
{

    private Socket socket;
    RecievingThread(ServerSocket server)
    {
        try{
        socket = server.accept();
        }catch(Exception ex){}
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
            
            System.out.println(fileName);
            System.out.println(fileSize);
            System.out.println(packetSize);
            System.out.println(totalPackets);
            System.out.println(lastPacket);
            
            
                File dir = new File("d:\\download");
                if(!dir.exists())
                    dir.mkdir();   
            PrintStream out = new PrintStream(new FileOutputStream(dir + "\\" + fileName));
            byte data[] = new byte[packetSize];
            
            for(int k=1 ; k<=totalPackets ; k++)
            {
                in.readFully(data, 0, packetSize);
                out.write(data,0,packetSize);
            }
            in.readFully(data,0,lastPacket);
            out.write(data,0,lastPacket);
            out.close();
            in.close();
            socket.close();
        }catch(Exception ex){ex.printStackTrace();}
    }
   
}
