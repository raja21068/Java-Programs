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
 * Title:        RegistryServiceHandler
 * Description:  This class handles the central server.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

import java.io.DataInputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

public class RegistryServiceHandler extends Thread{
    private MainFrame mainFrame;
    private String hostName;
    private int port;
    
    public RegistryServiceHandler(MainFrame mainFrame, String hostName, int port){
        this.mainFrame = mainFrame;
        this.hostName = hostName;
        this.port = port;
    }
    
    @Override
    public void run(){
        try{
            Socket socket = new Socket(hostName, port);
            DataInputStream input=new DataInputStream(socket.getInputStream());
            do{
                String list=input.readLine();
                
                if(list != null || !list.equals("")){
                    setPeersList(new StringTokenizer(list,"+"));
                }
            }while(true);
        }catch(Exception e){
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(mainFrame, "RegistryService is not running...");
            System.exit(0);
        }
    }
    
    private void setPeersList(StringTokenizer token){
        mainFrame.videoConferenceRoomDialog.onlinePeersVector.removeAllElements();
        while(token.hasMoreTokens()){
            StringTokenizer token2 = new StringTokenizer(token.nextToken(),"[]");
            
            PeerBean bean = new PeerBean();
            bean.setHostName(token2.nextToken());
            bean.setHostAddress(token2.nextToken());
            
            mainFrame.videoConferenceRoomDialog.onlinePeersVector.addElement(bean);
        }
            mainFrame.videoConferenceRoomDialog.onlinePeersList.setListData(mainFrame.videoConferenceRoomDialog.onlinePeersVector);
    }
}
