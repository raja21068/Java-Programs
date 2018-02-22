package p2pvideoconferencing;

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
 * Title:        PeersCommandHandlerServer
 * Description:  This class use handle commands of peers
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.media.IncompatibleSourceException;
import javax.media.Manager;
import javax.media.protocol.DataSource;

public class PeersCommandHandlerServer extends Thread {
    private int port;
    private MainFrame parent;
    public PeersCommandHandlerServer(MainFrame parent, int port) {
        this.parent = parent;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Video Server is started on " + port + " port...");

            do {
                Socket peer = server.accept();

                System.out.println(peer.getInetAddress().getHostName() + " peer is connected...");
                new PeerHandler(peer).start();
            } while (true);
        } catch (BindException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "This Application already running please close it first...");
            System.exit(0);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Network Error: " + e);
        }
    }

    public class PeerHandler extends Thread {
        private Socket socket;
        
        public PeerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                PrintStream out = new PrintStream(socket.getOutputStream());
                String command = in.readLine();

                switch (command) {
                    case "Start-Conference":
                        playVideoConference(out);
                        break;
                    case "Stop-Conference":
                        stopVideoConference();
                        break;
                    case "Stop-Watching-Me":
                        stopWatchingMe();
                        break;
                    case "Text-Message":
                        setTextMessage(in);
                        break;
                }
                
                in.close();
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(null, "Network Error: " + e);
            }
        }

        private void playVideoConference(PrintStream out){
            try {
                out.println("YES");
                DataSource mixedDataSource = getMergingDataSource(parent.videoConferenceRoomDialog.yourCamera.getVideoCloneableDataSource(), parent.videoConferenceRoomDialog.yourCamera.getAudioCloneableDataSource());

                LiveCameraTransmitter liveCameraTransmitter = new LiveCameraTransmitter(mixedDataSource, socket.getInetAddress().getHostAddress(), ConstantVariable.VIDEO_PORT);
                parent.videoConferenceRoomDialog.watchingPeersTable.put(socket.getInetAddress().getHostName(), liveCameraTransmitter);
                liveCameraTransmitter.start();
                resetWatcherList();
            } catch (IncompatibleSourceException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(null, "videoConference(): " + ex);
            }
        }

        private void stopVideoConference(){
            System.out.println(1);
            LiveCameraTransmitter liveCameraTransmitter = parent.videoConferenceRoomDialog.watchingPeersTable.get(socket.getInetAddress().getHostName());
            liveCameraTransmitter.stopTransmitter();
            liveCameraTransmitter.stop();
            
            System.out.println(2);
            parent.videoConferenceRoomDialog.watchingPeersTable.remove(socket.getInetAddress().getHostName());
            javax.swing.JOptionPane.showMessageDialog(null, socket.getInetAddress().getHostName() + " is disconnected...");
            resetWatcherList();
        }

        private void stopWatchingMe(){
            LivePeerDialog livePeerDialog = parent.videoConferenceRoomDialog.livePeersTable.get(socket.getInetAddress().getHostName());
            livePeerDialog.liveCameraReciever.stop();
            javax.swing.JOptionPane.showMessageDialog(livePeerDialog, socket.getInetAddress().getHostName() + " is disconnected...");
            livePeerDialog.dispose();
            
            parent.videoConferenceRoomDialog.livePeersTable.remove(socket.getInetAddress().getHostName());
        }
        
        private DataSource getMergingDataSource(DataSource video, DataSource audio) throws IncompatibleSourceException{
            DataSource mixedDataSource = Manager.createMergingDataSource(new DataSource[] {video,audio});
            return mixedDataSource;
        }
        
        private void resetWatcherList(){
            java.util.Enumeration e = parent.videoConferenceRoomDialog.watchingPeersTable.keys();
            Vector<String> v = new Vector<String>();
            while(e.hasMoreElements()){
                v.addElement((String)e.nextElement());
            }
            parent.videoConferenceRoomDialog.watcherPeerList.setListData(v);
        }
        
        private void setTextMessage(DataInputStream in)throws Exception{
            String msg = in.readLine();
            StringTokenizer token = new StringTokenizer(msg,"[]");
            String senderName = token.nextToken();
            msg = token.nextToken();
            parent.videoConferenceRoomDialog.textMessageListModel.addElement(senderName + ": " + msg);
        }
        
        public void closeConnection(){
            try{
                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    // PeerHandler
}