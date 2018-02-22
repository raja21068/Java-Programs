/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplevideotransfer;

import java.awt.Dimension;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Controller;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Processor;
import javax.media.control.TrackControl;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import javax.media.protocol.SourceCloneable;

/**
 *
 * @author Raja Kumar
 */
public class SimpleVideoTransfer {

    Processor processor;
    DataSource ds;
    
    public SimpleVideoTransfer(){
        
    }
     private String createProcessor() {
   try {
     
        String defaultVideoDeviceName = "Microsoft WDM Image Capture";
        String defaultVideoFormatString = "size=176x144, encoding=rgb, maxdatalength=76032";
        String defaultAudioDeviceName = "DirectSoundCapture";
        String defaultAudioFormatString = "linear, 16000.0 hz, 8-bit, mono, unsigned";

        CaptureDeviceInfo captureVideoDevice =null;
        CaptureDeviceInfo captureAudioDevice =null;
        VideoFormat	    captureVideoFormat =null;
        AudioFormat	    captureAudioFormat =null;

	java.util.Vector deviceListVector = CaptureDeviceManager.getDeviceList(null);

	if (deviceListVector == null){
	    System.out.println("Error: media device list vector is null, program aborted");
	    System.exit(1);
	}//end if

	if (deviceListVector.size() == 0){
		System.out.println("Error: media device list vector size is 0, program aborted");
		//System.exit(1);
	}//end if

    
                        
	CaptureDeviceInfo deviceInfo = CaptureDeviceManager.getDevice("vfw://0");
			
	Format deviceFormat[] = deviceInfo.getFormats();
	for (int y = 0; y < deviceFormat.length; y++){
            if (captureVideoDevice == null)
		if (deviceFormat[y] instanceof VideoFormat)
                    if (deviceInfo.getName().indexOf(defaultVideoDeviceName) >= 0){
                        captureVideoDevice = deviceInfo;
                        System.out.println(">>> capture video device = " + deviceInfo.getName());
                    }

				if (captureVideoDevice == deviceInfo)
					if (captureVideoFormat == null)
					if (DeviceInfo.formatToString(deviceFormat[y]).indexOf(defaultVideoFormatString) >= 0)
				        {
					  captureVideoFormat = (VideoFormat) deviceFormat[y];
					  System.out.println(">>> capture video format = " + DeviceInfo.formatToString(deviceFormat[y]));
				        }
			}//inner for loop printing formats


        MediaLocator locator=new MediaLocator("vfw://0");  

   	      ds = Manager.createDataSource(locator);
              System.out.println("DS is created..");
              ds=Manager.createCloneableDataSource(ds);
              System.out.println("DS , ClonableDS is created..");
              processor = Manager.createProcessor(ds);
              
              System.out.println("DS , ClonableDS and Processor is created..");
          
        

	boolean result = waitForState(processor, Processor.Configured);
	if (result == false)
	    return "Couldn't configure processor";

	TrackControl [] tracks = processor.getTrackControls();
	if (tracks == null || tracks.length < 1)
	    return "Couldn't find tracks in processor";

	boolean programmed = false;
	for (int i = 0; i < tracks.length; i++) {
	    Format format = tracks[i].getFormat();
	    if (  tracks[i].isEnabled() &&
		  format instanceof VideoFormat &&
		  !programmed) {

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

	if (!programmed)  return "Couldn't find video track";

	ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
	processor.setContentDescriptor(cd);

	result = waitForState(processor, Controller.Realized);
	if (result == false)  return "Couldn't realize processor";

	setJPEGQuality(processor, 0.5f);


	dataOutput = processor.getDataOutput();


    }catch(Exception e){
    e.printStackTrace();
      return e.toString();
    }
	return null;
 }//end createProcessor()
    
    public static void main(String[] args) throws Exception{
        MediaLocator locator = new MediaLocator("rtp://10.0.0.2:10000/video");
        
    }
}
