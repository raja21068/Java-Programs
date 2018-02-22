/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmfapplication;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Controller;
import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.DataSink;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Processor;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;

class TransmitVideo extends Thread{
    public String ipAddress;
    public int port;
    public boolean isClone;

    private Processor processor;
    private DataSink  rtptransmitter;
    private DataSource dataOutput;
    private DataSource ds;
  
   String defaultVideoDeviceName = "vfw:Microsoft WDM Image Capture (Win32):0";
//        String defaultVideoFormatString = "size=176x144, encoding=rgb, maxdatalength=76032";
   String defaultVideoFormatString = "YUV Video Format: Size = java.awt.Dimension[width=176,height=144] MaxDataLength = 50688 DataType = class [B yuvType = 32 StrideY = 352 StrideUV = 352 OffsetY = 0 OffsetU = 1 OffsetV = 3";
   String defaultAudioDeviceName = "DirectSoundCapture";
   String defaultAudioFormatString = "linear, 16000.0 hz, 8-bit, mono, unsigned";

  
  public TransmitVideo(String ipAddress,int port,boolean isClone){
      this.ipAddress=ipAddress;
      this.port=port;
      this.isClone=isClone;
  }//end of cons.

  public void run(){
     String result=startTransmission();
     if(result!=null) System.out.println(result);
  }//end of run()

  private String startTransmission(){
  	String result = createProcessor();
	if (result != null) return result;

	result = createTransmitter();
	if (result != null) {
	    processor.close();
	    processor = null;
	    return result;
	 }
	processor.start();
	return null;
  }//end startTrasmission()
  
  private String createProcessor() {
   try {
     
        CaptureDeviceInfo captureVideoDevice =null;
        CaptureDeviceInfo captureAudioDevice =null;
        VideoFormat	    captureVideoFormat =null;
        AudioFormat	    captureAudioFormat =null;
        
        CaptureDeviceInfo deviceInfo = CaptureDeviceManager.getDevice(defaultVideoDeviceName);
        captureVideoDevice = deviceInfo;
	
       
        Format deviceFormat[] = captureVideoDevice.getFormats();
	
        for (int y = 0; y < deviceFormat.length; y++){
            System.out.println(deviceFormat[y].toString());

            if(deviceFormat[y].toString().equals(defaultVideoFormatString)){
                captureVideoFormat = (VideoFormat)deviceFormat[y];
                break;
            }
            

            }//inner for loop printing formats



             MediaLocator locator=new MediaLocator("vfw://0");
             

   	      ds = Manager.createDataSource(locator);
              ds=Manager.createCloneableDataSource(ds);
              processor = Manager.createProcessor(ds);
              
              System.out.println("DS , ClonableDS and Processor is created..");
          
         
        boolean result = waitForState(processor, Processor.Configured);
	
	ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
	processor.setContentDescriptor(cd);

	result = waitForState(processor, Controller.Realized);
	if (result == false)  return "Couldn't realize processor";

//	setJPEGQuality(processor, 0.5f);


	dataOutput = processor.getDataOutput();


    }catch(Exception e){
    e.printStackTrace();
      return e.toString();
    }
	return null;
 }//end createProcessor()

    private String createTransmitter() {
    try {
  	  String rtpURL = "rtp://" + ipAddress + ":" + port + "/video";
	  System.out.println(rtpURL);

          MediaLocator outputLocator = new MediaLocator(rtpURL);

	  rtptransmitter = Manager.createDataSink(dataOutput, outputLocator);
	  rtptransmitter.open();
	  rtptransmitter.start();
	  dataOutput.start();
     } catch (Exception me) {
     return "Couldn't create RTP data sink";
     }
  return null;
}//end inner class

    private Integer stateLock = new Integer(0);
    private boolean failed = false;

    Integer getStateLock() {
	return stateLock;
    }

    void setFailed() {
	failed = true;
    }

    private synchronized boolean waitForState(Processor p, int state) {
	p.addControllerListener(new ControllerListener() {
            @Override
            public void controllerUpdate(ControllerEvent ce) {
                controlUpdateEvent(ce);
            }
        });
	failed = false;

	// Call the required method on the processor
	if (state == Processor.Configured) {
	    p.configure();
	} else if (state == Processor.Realized) {
	    p.realize();
	}

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

    public void controlUpdateEvent(Object ce){
        if (ce instanceof ControllerClosedEvent)
            {
                setFailed();
                System.out.println("----> Listener ClosedEvent");
            }

	    if (ce instanceof ControllerEvent) {
		synchronized (getStateLock()) {
                    System.out.println("-----> Listener ControllEvent");
		    getStateLock().notifyAll();
		}
            }
     }
  
   }//end most inner class