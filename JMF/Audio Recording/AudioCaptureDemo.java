import javax.media.*;
import javax.media.format.*;
import javax.media.protocol.*;
import java.util.*;
import java.io.*;

public class AudioCaptureDemo{

	public static void main(String arg[])throws Exception{

		Vector v = CaptureDeviceManager.getDeviceList(null);
		for(int k=0 ; k<v.size() ; k++)
			System.out.println(v.elementAt(k));

		Vector deviceList = CaptureDeviceManager.getDeviceList(new AudioFormat("linear", 44100, 16, 2));
		if(deviceList.size() > 0){

			CaptureDeviceInfo di = (CaptureDeviceInfo)deviceList.firstElement();
			Processor p = Manager.createProcessor(di.getLocator());

			while(p.getState()!=Processor.Configured)
				p.configure();

			p.setContentDescriptor(new FileTypeDescriptor(FileTypeDescriptor.WAVE));

			while(p.getState()!=Processor.Realized)
				p.realize();

			
			DataSource source = p.getDataOutput();
			MediaLocator dest = new MediaLocator("file:demo.wav");

			try{

				DataSink sink = Manager.createDataSink(source, dest);
				p.start();
				sink.open();
				sink.start();

				System.out.println("start");
				System.in.read();

				p.stop();
				p.close();

				sink.stop();
				sink.close();

			}catch(Exception ex){ex.printStackTrace();}

		}
		else{
			System.out.println("No Devices Found!");
		}
		

	}

}