import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * 21-Feb-2013
 * @author DELL
 */
public class serverTest {
    public static void main(String srg[])throws Exception{
        ServerSocket server = new ServerSocket(9090);
        do{
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream  out= new DataOutputStream(socket.getOutputStream());
           
            String statusLine = in.readLine();
            System.out.println(statusLine);
            
            String line = "";
            int len=0;
            do{
                line = in.readLine();
                System.out.println(line);
                if(line.startsWith("Content-Length")){
                    len = Integer.parseInt(line.split(" ")[1]);
                }
            }while(!line.trim().equals(""));
            
            if(statusLine.startsWith("POST")){
                byte data[] = new byte[len];
                in.readFully(data, 0, len);
                String str = new String(data,0,data.length);
                str = java.net.URLDecoder.decode(str);
                System.out.println(str);
                
            }
            in.close();
            socket.close();
            System.out.println("!...The connection is closed...!");
        }while(true);
    }
}
