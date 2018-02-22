package p2pvideoconferencing;

import java.awt.Dimension;
import java.io.IOException;
import javax.media.*;
import javax.media.control.QualityControl;
import javax.media.control.TrackControl;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;

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
 * Title:        LiveCameraTransmitter
 * Description:  This class send the video of camera to selected peer.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public class LiveCameraTransmitter extends Thread{

    //private MediaLocator locator;
    private DataSource mixedDataSource;
    private String ipAddress;
    private String port;

    private Processor processor = null;
    private DataSink  rtptransmitter = null;
    private DataSource dataOutput = null;
    
    public LiveCameraTransmitter(DataSource mixedDataSource, String ipAddress, String port) {
        this.mixedDataSource = mixedDataSource;
	this.ipAddress = ipAddress;
	this.port = port;
    }
    
    @Override
    public void run(){
       	String result =  startTransmitter();

	if (result != null) {
	    javax.swing.JOptionPane.showMessageDialog(null, "Error : " + result);
	}
    }
    
    public synchronized String startTransmitter() {
	// Create a processor for the specified media locator
	// and program it to output JPEG/RTP

	String result = createProcessor();
	if (result != null)
	    return result;
	// Create an RTP session to transmit the output of the
	// processor to the specified IP address and port no.

	result = createTransmitter();
	if (result != null) {
	    processor.close();
	    processor = null;
	    return result;
	}

	processor.start();
	
	return null;
    }

    public void stopTransmitter() {
	synchronized (this) {
	    if (processor != null) {
		processor.stop();
		processor.close();
		processor = null;
		rtptransmitter.close();
		rtptransmitter = null;
	    }
	}
    }

    private String createProcessor() {
	if (mixedDataSource == null)
	    return "DataSource is null";

//	DataSource ds;
//	try {
//	    ds = Manager.createDataSource(locator);
//	} catch (Exception e) {
//	    return "Couldn't create DataSource";
//	}

	try {
	    processor = Manager.createProcessor(mixedDataSource);
	} catch (NoProcessorException npe) {
	    return "Couldn't create processor";
	} catch (IOException ioe) {
	    return "IOException creating processor";
	} 

	boolean result = waitForState(processor, Processor.Configured);
	if (result == false)
	    return "Couldn't configure processor";

	// Get the tracks from the processor
	TrackControl [] tracks = processor.getTrackControls();

	if (tracks == null || tracks.length < 1)
	    return "Couldn't find tracks in processor";

	boolean programmed = false;

	for (int i = 0; i < tracks.length; i++) {
	    Format format = tracks[i].getFormat();
	    if (  tracks[i].isEnabled() && format instanceof VideoFormat && !programmed) {
		
		Dimension size = ((VideoFormat)format).getSize();
		float frameRate = ((VideoFormat)format).getFrameRate();
		int w = (size.width % 8 == 0 ? size.width : (int)(size.width / 8) * 8);
		int h = (size.height % 8 == 0 ? size.height : (int)(size.height / 8) * 8);
		VideoFormat jpegFormat = new VideoFormat(VideoFormat.JPEG_RTP,
							 new Dimension(w, h),
							 Format.NOT_SPECIFIED,
							 Format.byteArray,
							 frameRate);
		tracks[i].setFormat(jpegFormat);
		System.err.println("Video transmitted as:");
		System.err.println("  " + jpegFormat);
		programmed = true;
	    } else
		tracks[i].setEnabled(false);
	}

	if (!programmed)
	    return "Couldn't find video track";

	ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
	processor.setContentDescriptor(cd);

	// Realize the processor. This will internally create a flow
	// graph and attempt to create an output datasource for JPEG/RTP
	// video frames.

	result = waitForState(processor, Controller.Realized);
	if (result == false)
	    return "Couldn't realize processor";

	// Set the JPEG quality to .5.
	setJPEGQuality(processor, 0.5f);

	dataOutput = processor.getDataOutput();
	return null;
    }

    // Creates an RTP transmit data sink. This is the easiest way to create
    // an RTP transmitter. The other way is to use the RTPSessionManager API.
    // Using an RTP session manager gives you more control if you wish to
    // fine tune your transmission and set other parameters.

    private String createTransmitter() {
	// Create a media locator for the RTP data sink.
	// For example: rtp://129.130.131.132:42050/video

	String rtpURL = "rtp://" + ipAddress + ":" + port + "/video";
	MediaLocator outputLocator = new MediaLocator(rtpURL);

	// Create a data sink, open it and start transmission. It will wait
	// for the processor to start sending data. So we need to start the
	// output data source of the processor. We also need to start the
	// processor itself, which is done after this method returns.
	try {
	    rtptransmitter = Manager.createDataSink(dataOutput, outputLocator);
	    rtptransmitter.open();
	    rtptransmitter.start();
	    dataOutput.start();
	} catch (MediaException me) {
	    return "Couldn't create RTP data sink";
	} catch (IOException ioe) {
	    return "Couldn't create RTP data sink";
	}
	
	return null;
    }


    /**
     * Setting the encoding quality to the specified value on the JPEG encoder.
     * 0.5 is a good default.
     */
    void setJPEGQuality(Player p, float val) {

	Control cs[] = p.getControls();
	QualityControl qc = null;
	VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);

	// Loop through the controls to find the Quality control for
 	// the JPEG encoder.
	for (int i = 0; i < cs.length; i++) {

	    if (cs[i] instanceof QualityControl &&
		cs[i] instanceof Owned) {
		Object owner = ((Owned)cs[i]).getOwner();

		// Check to see if the owner is a Codec.
		// Then check for the output format.
		if (owner instanceof Codec) {
		    Format fmts[] = ((Codec)owner).getSupportedOutputFormats(null);
		    for (int j = 0; j < fmts.length; j++) {
			if (fmts[j].matches(jpegFmt)) {
			    qc = (QualityControl)cs[i];
	    		    qc.setQuality(val);
			    System.err.println("- Setting quality to " + 
					val + " on " + qc);
			    break;
			}
		    }
		}
		if (qc != null)
		    break;
	    }
	}
    }

    /****************************************************************
     * Convenience methods to handle processor's state changes.
     ****************************************************************/
    
    private Integer stateLock = new Integer(0);
    private boolean failed = false;
    
    public Integer getStateLock() {
	return stateLock;
    }

    public void setFailed() {
	failed = true;
    }
    
    private synchronized boolean waitForState(Processor p, int state) {
	p.addControllerListener(new StateListener());
	failed = false;

	// Call the required method on the processor
	if (state == Processor.Configured) {
	    p.configure();
	} else if (state == Processor.Realized) {
	    p.realize();
	}
	
	// Wait until we get an event that confirms the
	// success of the method, or a failure event.
	// See StateListener inner class
	while (p.getState() < state && !failed) {
	    synchronized (getStateLock()) {
		try {
		    getStateLock().wait();
		} catch (InterruptedException ie) {
		    return false;
		}
	    }
	}

	if (failed)
	    return false;
	else
	    return true;
    }

    private class StateListener implements ControllerListener {
        @Override
	public void controllerUpdate(ControllerEvent ce) {

	    // If there was an error during configure or
	    // realize, the processor will be closed
	    if (ce instanceof ControllerClosedEvent)
		setFailed();

	    // All controller events, send a notification
	    // to the waiting thread in waitForState method.
	    if (ce instanceof ControllerEvent) {
		synchronized (getStateLock()) {
		    getStateLock().notifyAll();
		}
	    }
	}
    }

//
//    public static void main(String [] args) {
//	// We need three parameters to do the transmission
//	// For example : java VideoTransmit file:/C:/media/test.mov  129.130.131.132 42050
//	
//	if (args.length < 3) {
//	    System.err.println("Usage: VideoTransmit <sourceURL> <destIP> <destPort>");
//	    System.exit(-1);
//	}
//	
////	LiveCameraTransmitter vt = new LiveCameraTransmitter(new MediaLocator(args[0]), args[1], args[2]);
//	String result = vt.start();
//
//	if (result != null) {
//	    System.err.println("Error : " + result);
//	    System.exit(0);
//	}
//
//	System.err.println("Start transmission for 60 seconds...");
//
//	try {
//	    Thread.currentThread().sleep(60000);
//	} catch (InterruptedException ie) {
//	}
//
//	vt.stop();
//
//	System.err.println("...transmission ended.");
//	
//	System.exit(0);
//    }
}

