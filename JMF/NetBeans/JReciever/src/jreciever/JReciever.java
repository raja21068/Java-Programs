/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jreciever;

import java.io.IOException;
import javax.media.*;
import javax.media.protocol.DataSource;

/**
 *
 * @author Students
 */
public class JReciever implements ControllerListener{

    JReciever(){
        try {
            DataSource ds;
            String ipAddress = "localhost";
            String mediaPort = "10000";
                String destinationURL = "rtp://" + ipAddress + ":" + mediaPort + "/video";
                System.out.println(destinationURL);
                MediaLocator mediaLocator=new MediaLocator(destinationURL);
                ds = Manager.createDataSource(mediaLocator);
                //Player p = Manager.createPlayer(ds);
                //p.addControllerListener(this);
                //p.prefetch();
                
                MyMediaPlayer myMediaPlayer = new MyMediaPlayer();
                
                  if (!myMediaPlayer.open(ds))System.out.println("Can not create cloninggggg");
//        } catch (NoPlayerException | IOException | NoDataSourceException ex) {
  //          Logger.getLogger(JReciever.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, NoDataSourceException, NoPlayerException {
        new JReciever();
    }

    @Override
    public void controllerUpdate(ControllerEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
