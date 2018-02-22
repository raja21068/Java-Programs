import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.PrintStream;
import java.io.DataInputStream;
/**
 *
 * @author Ali Asad
 */

class SendingThread extends Thread
{
    private Client c;
    SendingThread(Client c)
    {
        setDaemon(true);
        this.c = c;
    }
    
    public void run()
    {
        String file = c.browseText.getText();
        File f = new File(file);
        if(f.exists())
        {
            String fileName = f.getName();
            long fileSize = f.length();
            int packetSize = 10000;
            int totalPackets = (int)f.length()/10000;
            int lastPacket = (int)f.length()%10000;
            
            try{
                Socket socket = new Socket(c.ipText.getText(),9090);
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println(fileName);
                out.println(fileSize);
                out.println(packetSize);
                out.println(totalPackets);
                out.println(lastPacket);
                
                System.out.println(fileName);
                System.out.println(fileSize);
                System.out.println(packetSize);
                System.out.println(totalPackets);
                System.out.println(lastPacket);
                
                DataInputStream in = new DataInputStream(new FileInputStream(f));
                
                byte data[] = new byte[packetSize];
                c.bar.setMinimum(0);
                c.bar.setMaximum(totalPackets);
                c.bar.setValue(0);
                int k;
                for(k=1 ; k<=totalPackets ; k++)
                {
                    in.readFully(data,0,data.length);
                    out.write(data,0,data.length);
                    c.bar.setValue(k);
                }
                in.readFully(data,0,lastPacket);
                out.write(data,0,lastPacket);
                c.bar.setValue(k);
                in.close();
                out.close();
                socket.close();
                
                int opt = JOptionPane.showConfirmDialog(c, "File id compeletely Tranfered, Do you want to close Transfer dialog ??", "Transfer Compelete",JOptionPane.YES_NO_OPTION);
                if(opt == JOptionPane.YES_OPTION)
                    c.dispose();
                else
                    c.bar.setValue(0);
                
            }catch(Exception ex){ex.printStackTrace();}
        }
        
        else
            JOptionPane.showMessageDialog(null,"No such file exists!!");
    }
}

