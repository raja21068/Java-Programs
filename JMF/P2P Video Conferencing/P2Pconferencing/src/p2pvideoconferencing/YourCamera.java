package p2pvideoconferencing;


import java.awt.*;
import javax.media.*;
import java.io.*;
import javax.media.protocol.*;
import javax.swing.JOptionPane;

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
 * Title:        YourCamera
 * Description:  This class shows the user camera.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public final class YourCamera {
    
    public YourCamera(VideoConferenceRoomDialog videoConferenceRoomDialog) {
        this.videoConferenceRoomDialog = videoConferenceRoomDialog;
        try{
            captureSetting();
        }catch(NoDataSourceException | IOException | IncompatibleSourceException | NoPlayerException | CannotRealizeException e){
            JOptionPane.showMessageDialog(videoConferenceRoomDialog, e);
        }
    }

    public void captureSetting()throws NoDataSourceException, IOException, IncompatibleSourceException, NoPlayerException, CannotRealizeException{
        if(player == null) {
            video = Manager.createDataSource(CaptureDeviceManager.getDevice(ConstantVariable.VIDEO_DEVICE_NAME).getLocator());
            audio = Manager.createDataSource(CaptureDeviceManager.getDevice(ConstantVariable.AUDIO_DEVICE_NAME).getLocator());

            videoLocator = video.getLocator().getProtocol() + video.getLocator().getRemainder();
            audioLocator = audio.getLocator().getProtocol() + audio.getLocator().getRemainder();

            video = Manager.createCloneableDataSource(video);
            audio = Manager.createCloneableDataSource(audio);
            
            DataSource mixedDataSource = Manager.createMergingDataSource(new DataSource[] {video,audio});

            player = Manager.createRealizedPlayer(mixedDataSource);
            player.prefetch();

            Component visualPanel = player.getVisualComponent();
            if(visualPanel != null) {
                videoConferenceRoomDialog.liveCameraPanel.add(visualPanel);
            }
        }
	player.start();
//        this.videoConferenceRoomDialog.busyLabel.setBusy(false);
//        this.videoConferenceRoomDialog.busyLabel.setVisible(false);
    }
    
    public DataSource getVideoCloneableDataSource(){
        return ((SourceCloneable)video).createClone();
    }
    
    public DataSource getAudioCloneableDataSource(){
        return ((SourceCloneable)audio).createClone();
    }
    
    private VideoConferenceRoomDialog videoConferenceRoomDialog;
    private DataSource video = null;
    private DataSource audio = null;
    public Player player = null;
    public String videoLocator;
    public String audioLocator;
}
