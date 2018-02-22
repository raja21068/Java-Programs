/*
 * Java Media Framework
 * 
 * Copyright (c) 1999-2001 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

import java.awt.*;
import java.util.*;
import javax.media.*;
import javax.media.protocol.*;
import javax.media.control.*;
import javax.media.format.*;

/**
* This is the primary class to run. It gathers an image stream and drives the processing.
* 
*/
public class jmfcam05v
{
     DataSource dataSource;
     PushBufferStream pbs;
     
     Vector camImgSize = new Vector();
     Vector camCapDevice = new Vector();
     Vector camCapFormat = new Vector();
     
     int camFPS;
     int camImgSel;
     
     Processor processor = null;
     DataSink datasink = null;
     
     /**
     * Main method to instance and run class
     * 
     */
     public static void main(String[] args)
     {
          jmfcam05v jmfcam = new jmfcam05v();          
     }
     
     /**
     * Constructor and processing method for image stream from a cam
     * 
     */
     public jmfcam05v()
     {
          // Select webcam format
          fetchDeviceFormats();
          camImgSel=0;     // first format, or otherwise as desired
          camFPS = 30;     // framerate
          
          // Setup data source
          fetchDeviceDataSource();
          createPBDSource();
          createProcessor(dataSource);
          startCapture();
          try{Thread.sleep(20000);}catch(Exception e){}     // 20 seconds
          stopCapture();
     }
     
     /**
     * Gathers info on a camera
     * 
     */
     boolean fetchDeviceFormats()
     {
          Vector deviceList = CaptureDeviceManager.getDeviceList(new VideoFormat(null));
          CaptureDeviceInfo CapDevice = null;
          Format CapFormat = null;
          String type = "N/A";
          
          CaptureDeviceInfo deviceInfo=null;boolean VideoFormatMatch=false;
          for(int i=0;i<deviceList.size();i++)
          {
               // search for video device
               deviceInfo = (CaptureDeviceInfo)deviceList.elementAt(i);
               if(deviceInfo.getName().indexOf("vfw:")<0)continue;
               
               Format deviceFormat[] = deviceInfo.getFormats();
			   System.out.println(">>Length  : "+deviceFormat.length);
			   for (int f=0;f<deviceFormat.length;f++)
               {                    
                    if(deviceFormat[f] instanceof RGBFormat)type="RGB";
                    if(deviceFormat[f] instanceof YUVFormat)type="YUV";
                    if(deviceFormat[f] instanceof JPEGFormat)type="JPG";
                    
                    Dimension size = ((VideoFormat)deviceFormat[f]).getSize();
                    camImgSize.addElement(type+" "+size.width+"x"+size.height);
                    
                    CapDevice = deviceInfo;
                    camCapDevice.addElement(CapDevice);
                    //System.out.println("Video device = " + deviceInfo.getName());
                    
                    CapFormat = (VideoFormat)deviceFormat[f];
                    camCapFormat.addElement(CapFormat);
                    //System.out.println("Video format = " + deviceFormat[f].toString());
                    
                    VideoFormatMatch=true;     // at least one               
               }
          }
          if(VideoFormatMatch==false)
          {
               if(deviceInfo!=null)System.out.println(deviceInfo);
               System.out.println("Video Format not found");
               return false;
          }
          
          return true;
     }
     
     /**
     * Finds a camera and sets it up 
     * 
     */
     void fetchDeviceDataSource()
     {
          CaptureDeviceInfo CapDevice = (CaptureDeviceInfo)camCapDevice.elementAt(camImgSel);
          System.out.println("Video device = " + CapDevice.getName());
          Format CapFormat = (Format)camCapFormat.elementAt(camImgSel);
          System.out.println("Video format = " + CapFormat.toString());
          
          MediaLocator loc = CapDevice.getLocator();
          try
          {
               dataSource = Manager.createDataSource(loc);
          }
          catch(Exception e){}
          
          try
          {
               // ensures 30 fps or as otherwise preferred, subject to available cam rates but this is frequency of windows request to stream
               FormatControl formCont=((CaptureDevice)dataSource).getFormatControls()[0];
               VideoFormat formatVideoNew = new VideoFormat(null,null,-1,null,(float)camFPS);
               formCont.setFormat(CapFormat.intersects(formatVideoNew));
          }
          catch(Exception e){}
     }
     
     /**
     * Gets a stream from the camera (and sets debug)
     * 
     */
     void createPBDSource()
     {
          try
          {
               pbs=((PushBufferDataSource)dataSource).getStreams()[0];
          }
          catch(Exception e){}
     }
     
     public void createProcessor(DataSource datasource)
     {
          FileTypeDescriptor ftd = new FileTypeDescriptor(FileTypeDescriptor.MSVIDEO);
          Format[] formats = new Format[] {new VideoFormat(VideoFormat.INDEO50)};
          ProcessorModel pm = new ProcessorModel(datasource, formats, ftd);
          try
          {
               processor = Manager.createRealizedProcessor(pm);
          }
          catch(Exception me)
          {
               System.out.println(me);
               // Make sure the capture devices are released
               datasource.disconnect();
               return;
          }
     }
     
     private void startCapture()
     {
          // Get the processor's output, create a DataSink and connect the two.
          DataSource outputDS = processor.getDataOutput();
          try
          {
               MediaLocator ml = new MediaLocator("file:capture.avi");
               datasink = Manager.createDataSink(outputDS, ml);
               datasink.open();
               datasink.start();
          }catch (Exception e)
          {
               System.out.println(e);
          }
          processor.start();
          System.out.println("Started saving...");
     }
     
     private void pauseCapture()
     {
          processor.stop();
     }
     
     private void resumeCapture()
     {
          processor.start();
     }
     
     private void stopCapture()
     {
          // Stop the capture and the file writer (DataSink)
          processor.stop();
          processor.close();
          datasink.close();
          processor = null;
          System.out.println("Done saving.");
     }
}