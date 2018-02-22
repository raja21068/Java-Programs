import java.net.ServerSocket;
import java.net.ServerSocket;

/**
 *
 * @author Ali Asad
 */
class Server 
{
    public static void main(String arg[])
    {
        try{
        int portNo = 9090;
        ServerSocket server = new ServerSocket(portNo);
        
            do{
                new RecievingThread(server).start();
            }while(true);
        
        }catch(Exception ex){ex.printStackTrace();}
    }
}
