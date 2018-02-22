
import java.io.IOException;
import javax.media.*;
import javax.media.protocol.DataSource;

/**
 *
 * @author Students
 */
public class JReciever extends Thread implements ControllerListener{

    String ipAddress;
    int port;
    
    JReciever(String ip, int p){
        ipAddress = ip;
        port = p;
    }

    @Override
    public void run() {
        try {
            DataSource ds;
                String destinationURL = "rtp://" + ipAddress + ":" + port + "/video";
                System.out.println(destinationURL);
                MediaLocator mediaLocator=new MediaLocator(destinationURL);
                ds = Manager.createDataSource(mediaLocator);
                
                MyMediaPlayer myMediaPlayer = new MyMediaPlayer();
                
                  if (!myMediaPlayer.open(ds))System.out.println("Can not create cloninggggg");
//        } catch (NoPlayerException | IOException | NoDataSourceException ex) {
  //          Logger.getLogger(JReciever.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){ex.printStackTrace();}
    }

    @Override
    public void controllerUpdate(ControllerEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
