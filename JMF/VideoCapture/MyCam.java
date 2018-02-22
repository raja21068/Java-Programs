import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Control;
import javax.media.DataSink;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.FormatControl;
import javax.media.protocol.FileTypeDescriptor; 
import javax.media.protocol.DataSource; 

public class MyCam{

	CaptureDeviceInfo cam;	
	MediaLocator locator;
	Player player;
	FormatControl formatControl;
	
	DataSink sink;
	
	JFrame f;
	JButton buttonSave;
	public MyCam(){
		
		// Creating a Frame to display Video
		f = new JFrame();
		f.setTitle("Test Webcam");
		f.setLayout(new BorderLayout());
		
		buttonSave = new JButton("Start");
		buttonSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev){
				buttonSaveActionPerformed();
			}
		});
		f.add(buttonSave, BorderLayout.NORTH);
		
		try{
			// List out available Devices to Capture Video. 
			/*Vector<CaptureDeviceInfo> list = CaptureDeviceManager.getDeviceList ( null );
			
			// Iterating list 
			for(CaptureDeviceInfo temp : list){
				// Checking whether the current device supports VfW
				// VfW = Video for Windows
				System.out.println(temp);
				if(temp.getName().startsWith("vfw:")){

					System.out.println("Found : "+temp.getName().substring(4));
					// Selecting the very first device that supports VfW
					cam = temp;
					System.out.println("Selected : "+cam.getName().substring(4));
					break;
				}
			}

			System.out.println("Put it on work!..."+cam);
			// Getting the MediaLocator for Selected device.
			// MediaLocator describes the location of media content
			
			locator = cam.getLocator();
			*/
			locator = new MediaLocator("vfw://0");
			setCam();
		}catch(Exception e){
			e.printStackTrace();
		}
		f.setVisible(true);

	}
	
	public void startVideo()throws Exception{
		
		player.start();
				
	}
	
	public void setCam()throws Exception{
		if(locator != null){
			// Create a Player for Media Located by MediaLocator
			player = Manager.createRealizedPlayer(locator);

			if(player != null){
					
				// Starting the player	
					
				// Adding the Visual Component to display Video captured by Player 
				// from URL provided by MediaLocator
				f.add(player.getVisualComponent(), BorderLayout.CENTER);
				f.add(BorderLayout.SOUTH, player.getControlPanelComponent());	
				
				f.pack(); 
					
			}

		}else{
				System.out.println("Locator is Null, cant find device..");
		}
	}
	
	public void stopVideo()throws Exception{
		player.stop();
	}
	
	public void buttonSaveActionPerformed(){
		if(buttonSave.getText().equals("Start") ){
			try{startVideo();}catch(Exception ex){ex.printStackTrace();}
			// try{save();}catch(Exception ex){ex.printStackTrace();}
			buttonSave.setText("Stop");
		}else{
			try{
				buttonSave.setText("Start");
				stopVideo();
				// stopSaving();
			}catch(Exception ex){ex.printStackTrace();}
		}		
	}
	
	
	public void save()throws Exception{
		Processor p = Manager.createProcessor(locator);
		
		while(p.getState()!=Processor.Configured)
			p.configure();
		p.setContentDescriptor(new FileTypeDescriptor(FileTypeDescriptor.MPEG ));
		
		while(p.getState()!=Processor.Realized)
			p.realize();

		DataSource source = p.getDataOutput();
		MediaLocator dest = new MediaLocator("file:demo.mpeg");
		sink = Manager.createDataSink(source, dest);
		sink.open();
		sink.start();

		System.out.println("start");
	
	}
	
	public void stopSaving()throws Exception{
		sink.stop();
		sink.close();
	}

	public static void main(String[] args) {
		new MyCam();
	}
}