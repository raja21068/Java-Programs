import java.awt.*;
import javax.media.*;
import javax.media.protocol.*;
import javax.media.protocol.DataSource;
import javax.media.format.*;
import javax.media.control.TrackControl;
import javax.media.control.QualityControl;
import java.io.*;

public class VideoTransmit {

   private static String defaultVideoDeviceName = "Microsoft WDM Image Capture";
   private static String defaultVideoFormatString = "size=176x144, encoding=rgb, maxdatalength=76032";
   private static String defaultAudioDeviceName = "DirectSoundCapture";
   private static String defaultAudioFormatString = "linear, 16000.0 hz, 8-bit, mono, unsigned";

   private static CaptureDeviceInfo captureVideoDevice ;
   private static CaptureDeviceInfo captureAudioDevice ;
   private static VideoFormat	    captureVideoFormat ;
   private static AudioFormat	    captureAudioFormat ;

   private String ipAddress;
   private String port;

   private Processor processor = null;
   private DataSink  rtptransmitter = null;
   private DataSource dataOutput = null;
    
   public VideoTransmit(String ipAddress, String port) {	
	this.ipAddress = ipAddress;
	this.port = port;
    }

    /**
     * Starts the transmission. Returns null if transmission started ok.
     * Otherwise it returns a string with the reason why the setup failed.
     */
    public synchronized String start() {
	String result;

	// Create a processor for the specified media locator
	// and program it to output JPEG/RTP
	result = createProcessor();
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

	// Start the transmission
	processor.start();
	
	return null;
    }

    /**
     * Stops the transmission if already started
     */
    public void stop() {
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
     try{

	System.out.println("get list of all media devices ...");
	java.util.Vector deviceListVector = CaptureDeviceManager.getDeviceList(null);

	if (deviceListVector == null){
	    System.out.println("Error: media device list vector is null, program aborted");
	    System.exit(1);
	}//end if

	if (deviceListVector.size() == 0){
		System.out.println("Error: media device list vector size is 0, program aborted");
		System.exit(1);
	}//end if

	for (int x = 0; x < deviceListVector.size(); x++){

			// display device name
			CaptureDeviceInfo deviceInfo = (CaptureDeviceInfo) deviceListVector.elementAt(x);
			String deviceInfoText = deviceInfo.getName();


			// display device formats
			Format deviceFormat[] = deviceInfo.getFormats();
			for (int y = 0; y < deviceFormat.length; y++)			{
				// serach for default video device
				if (captureVideoDevice == null)
					if (deviceFormat[y] instanceof VideoFormat)
					if (deviceInfo.getName().indexOf(defaultVideoDeviceName) >= 0)
    				        {
					  captureVideoDevice = deviceInfo;
  					  System.out.println(">>> capture video device = " + deviceInfo.getName());
				        }

				// search for default video format
				if (captureVideoDevice == deviceInfo)
					if (captureVideoFormat == null)
					if (DeviceInfo.formatToString(deviceFormat[y]).indexOf(defaultVideoFormatString) >= 0)
				        {
					  captureVideoFormat = (VideoFormat) deviceFormat[y];
					  System.out.println(">>> capture video format = " + DeviceInfo.formatToString(deviceFormat[y]));
				        }

				// serach for default audio device
				if (captureAudioDevice == null)
					if (deviceFormat[y] instanceof AudioFormat)
					if (deviceInfo.getName().indexOf(defaultAudioDeviceName) >= 0)
				         {
 					   captureAudioDevice = deviceInfo;
					   System.out.println(">>> capture audio device = " + deviceInfo.getName());
				         }

				// search for default audio format
				if (captureAudioDevice == deviceInfo)
					if (captureAudioFormat == null)
					if (DeviceInfo.formatToString(deviceFormat[y]).indexOf(defaultAudioFormatString) >= 0)
				         {
					   captureAudioFormat = (AudioFormat) deviceFormat[y];
					   System.out.println(">>> capture audio format = " + DeviceInfo.formatToString(deviceFormat[y]));
				         }

			}//inner for loop printing formats
		}//outer for loop printing devices


        if(captureVideoDevice==null){
           System.out.println("captureVideoDevice=null");
           return "captureVideoDevice=null";
        }//end if


       MediaLocator videoLocator =captureVideoDevice.getLocator();
       MediaLocator audioLocator =captureAudioDevice.getLocator();
	 DataSource videoDataSource= Manager.createDataSource(videoLocator);
	 DataSource audioDataSource= Manager.createDataSource(audioLocator);

       DeviceInfo.setFormat(videoDataSource, captureVideoFormat)
       DeviceInfo.setFormat(audioDataSource, captureAudioFormat)

		
 	 DataSource dArray[] ={videoDataSource,audioDataSource};
	 DataSource mixedDataSource = javax.media.Manager.createMergingDataSource(dArray);


       processor = Manager.createProcessor(mixedDataSource);




	// Wait for it to configure
	boolean result = waitForState(processor, Processor.Configured);
	if (result == false)
	    return "Couldn't configure processor";

	// Get the tracks from the processor
	TrackControl [] tracks = processor.getTrackControls();

	// Do we have atleast one track?
	if (tracks == null || tracks.length < 1)
	    return "Couldn't find tracks in processor";

	boolean programmed = false;

	// Search through the tracks for a video track
	for (int i = 0; i < tracks.length; i++) {
	    Format format = tracks[i].getFormat();
	    if (  tracks[i].isEnabled() &&
		  format instanceof VideoFormat &&
		  !programmed) {
		
		// Found a video track. Try to program it to output JPEG/RTP
		// Make sure the sizes are multiple of 8's.
		Dimension size = ((VideoFormat)format).getSize();
		float frameRate = ((VideoFormat)format).getFrameRate();
		int w = (size.width % 8 == 0 ? size.width :
				(int)(size.width / 8) * 8);
		int h = (size.height % 8 == 0 ? size.height :
				(int)(size.height / 8) * 8);
		VideoFormat jpegFormat = new VideoFormat(VideoFormat.JPEG_RTP,
							 new Dimension(w, h),
							 Format.NOT_SPECIFIED,
							 Format.byteArray,
							 frameRate);
		tracks[i].setFormat(jpegFormat);
		System.err.println("Video transmitted as:");
		System.err.println("  " + jpegFormat);
		// Assume succesful
		programmed = true;
	    } else
		tracks[i].setEnabled(false);
	}

	if (!programmed)
	    return "Couldn't find video track";

	// Set the output content descriptor to RAW_RTP
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

	// Get the output data source of the processor
	dataOutput = processor.getDataOutput();
	return null;
    }

    // Creates an RTP transmit data sink. This is the easiest way to create
    // an RTP transmitter. The other way is to use the RTPSessionManager API.
    // Using an RTP session manager gives you more control if you wish to
    // fine tune your transmission and set other parameters.
    private String createTransmitter() {
	// Create a media locator for the RTP data sink.
	// For example:
	//    rtp://129.130.131.132:42050/video
	String rtpURL = "rtp://" + ipAddress + ":" + port + "/video";
	MediaLocator outputLocator = new MediaLocator(rtpURL);

	// Create a data sink, open it and start transmission. It will wait
	// for the processor to start sending data. So we need to start the
	// output data source of the processor. We also need to start the
	// processor itself, which is done after this method returns.


	    rtptransmitter = Manager.createDataSink(dataOutput, outputLocator);
	    rtptransmitter.open();
	    rtptransmitter.start();
	    dataOutput.start();

	} catch (Exception e) {
	   e.printStackTrace();
         return e.getMessage();
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
    
    Integer getStateLock() {
	return stateLock;
    }

    void setFailed() {
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

    /****************************************************************
     * Inner Classes
     ****************************************************************/

    class StateListener implements ControllerListener {

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


    /****************************************************************
     * Sample Usage for VideoTransmit class
     ****************************************************************/
    
    public static void main(String [] args) {
	//   java VideoTransmit file:/C:/media/test.mov  129.130.131.132 42050
	
	
        VideoTransmit vt = new VideoTransmit(args[1],args[2]);
	// Start the transmission
	String result = vt.start();

	// result will be non-null if there was an error. The return
	// value is a String describing the possible error. Print it.
	if (result != null) {
	    System.err.println("Error : " + result);
	    System.exit(0);
	}

	System.err.println("Start transmission for 60 seconds...");
	
	// Transmit for 60 seconds and then close the processor
	// This is a safeguard when using a capture data source
	// so that the capture device will be properly released
	// before quitting.
	// The right thing to do would be to have a GUI with a
	// "Stop" button that would call stop on VideoTransmit
	try {
	    Thread.currentThread().sleep(60000);
	} catch (InterruptedException ie) {
	}

	// Stop the transmission
	vt.stop();

	System.err.println("...transmission ended.");
	
	System.exit(0);
    }
}

