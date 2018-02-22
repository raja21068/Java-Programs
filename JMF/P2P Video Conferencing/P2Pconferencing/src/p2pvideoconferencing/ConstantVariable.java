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
 * Title:        ConstantVariable
 * Description:  This is final class.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

import java.net.UnknownHostException;

public final class ConstantVariable {

    static{
        try {
            java.net.InetAddress address = java.net.InetAddress.getLocalHost();
	    LOCAL_HOST = address.getHostName();
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
    }
    public static String VIDEO_DEVICE_NAME = " vfw:Microsoft WDM Image Capture (Win32):0";
    public static String AUDIO_DEVICE_NAME = "DirectSoundCapture";
    public static int PORT = 7777;
    public static int SERVICE_PORT = 3333;
    public static String VIDEO_PORT = "22222";
    public static String LOCAL_HOST;
    public static String SERVER_IP = "127.0.0.1";
}
