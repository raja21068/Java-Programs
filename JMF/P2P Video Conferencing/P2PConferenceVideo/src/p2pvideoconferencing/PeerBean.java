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
 * Title:        PeerBean
 * Description:  Peer Details
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public class PeerBean {
    private int peerId;
    private String hostName;
    private String hostAddress;
    
    public void setPeerId(int peerId){
        this.peerId = peerId;
    }
    public void setHostName(String hostName){
        this.hostName = hostName;
    }
    public void setHostAddress(String hostAddress){
        this.hostAddress = hostAddress;
    }
    
    public int getPeerId(){
        return this.peerId;
    }
    public String getHostName(){
        return hostName;
    }
    public String getHostAddress(){
        return hostAddress;
    }
    
    @Override
    public String toString(){
        return this.getHostName();
    }
}
