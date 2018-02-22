package p2pvideoconferencing;


import java.awt.Component;
import javax.media.*;
import javax.media.bean.playerbean.MediaPlayer;

/**
 * Title:        Live Media Transmision System based on RTP & RTCP protocols
 * Description:  This project will transfer video and audio contents on the network,
 * transmiter will take data from web-cam direct and transmit it to network and receiver will play that contents on the player on realtime mode. this implementation based on UDP protocol at transport level, at
 * application level we are developing our own protocols call RTP,RTCP
 * protocols at application level. as we know streams are only possible in TCP protocol, but RTP working on the top of UDP, RTP and RTCP provides here streams technique to be take data at realtime mode and relable this example aslo can be run on the Internet there will be no chance of losing packes RTCP protocol controlling this.
 * if this program not working please contact me thanks....
 * --------------------------------------------------------
 * Yougeshwar Khatri
 * BS-CS 3rd Year Student
 * IMCS, University of Sindh, Jamshoro.
 * Contact: yogeshwar_90@hotmail.com
 * Mobile: 03342811035
 * ---------------------------------------------------------------------
 * Mentor: Sachal Joyo (Network and Protocol designing)
 *                     (Java Technologies)
 * Title:        LiveCameraReciever
 * Description:  This class shows the camera of selected peer.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public class LiveCameraReciever implements ControllerListener{
    
    public LiveCameraReciever(LivePeerDialog livePeerDialog, PeerBean peerBean){
        this.livePeerDialog = livePeerDialog;
        this.peerBean = peerBean;
        
        try{
            captureSetting();
        }catch(Exception e){e.printStackTrace();}
    }

    public void captureSetting()throws Exception{
        String mediaLocation = "rtp://"+peerBean.getHostAddress()+":"+ConstantVariable.VIDEO_PORT+"/video";//"rtp://127.0.0.1:9000/video";
        mediaPlayer =new MediaPlayer();
        
        mediaLocator = new MediaLocator(mediaLocation);
        
        mediaPlayer.setMediaLocator(mediaLocator);

        player = mediaPlayer.getPlayer();
        player.addControllerListener(this);
        player.realize();
    }
    
    @Override
    public synchronized void controllerUpdate(ControllerEvent event){
        if (event instanceof RealizeCompleteEvent){
            Component visualComponent = player.getVisualComponent();

            livePeerDialog.liveCameraPanel.add(visualComponent);

            player.prefetch();
  	}
       else
         if (event instanceof PrefetchCompleteEvent) {
             player.start();
             this.livePeerDialog.busyLabel.setBusy(false);
             this.livePeerDialog.busyLabel.setVisible(false);
         }
    }

    public void stop(){
        player.close();
        mediaPlayer.close();
    }
    
    public MediaLocator getMediaLocator(){
        return mediaLocator;
    }

    private LivePeerDialog livePeerDialog;
    private PeerBean peerBean;
    private MediaLocator mediaLocator;
    private MediaPlayer mediaPlayer;
    private Player player = null;
    public int width;
    public int height;
}
