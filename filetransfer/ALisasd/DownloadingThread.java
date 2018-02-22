import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

import javax.swing.JProgressBar;

class DownloadingThread implements Runnable
{
	Thread t;
	String source="", destination="";
	JProgressBar bar;
	NewDownload newDownloadDialog;
	
	DownloadingThread(NewDownload nd)
	{
		this.bar = nd.bar;
		this.source = nd.source;
		this.destination = nd.destination;
		this.newDownloadDialog = nd;
		t = new Thread(this,"My Thread");
	}
	
	public void run()
	{
		try{		
			
		DataInputStream in = new DataInputStream(new FileInputStream(source));
		File file = new File(destination);
		
		if(file.exists())
		{	
			RandomAccessFile r = new RandomAccessFile(source,"r");
			RandomAccessFile w = new RandomAccessFile(destination,"rw");
			
			int bytesToSkip = (int)file.length();
			int totalBytes = in.available();
			int initialPacket = bytesToSkip/10000;
			int packetSize = 10000;
			int totalPackets = totalBytes/10000;
			int remainingPacket = (totalBytes-bytesToSkip)%10000;
				
			byte b[] = new byte[packetSize];
			bar.setMinimum(0);
			bar.setMaximum(totalPackets);
			bar.setValue(initialPacket);
			
			r.skipBytes(bytesToSkip);
			w.seek(bytesToSkip);
			
			int i;
			for(i=initialPacket+1 ; i<=totalPackets ; i++)
			{
				r.readFully(b,0,b.length);
				w.write(b, 0, b.length);
				bar.setValue(i);
				DynamicFileDownloadProtocol.tableModel.setValueAt(bar.getString(),DynamicFileDownloadProtocol.tableModel.getRowCount()-1, 1);
			}
			
			r.readFully(b,0,remainingPacket);
			w.write(b,0,remainingPacket);
			bar.setValue(i);
			
			r.close();
			w.close();
			bar.setValue(0);
		
		}
		
		
		else if(!file.exists())
		{
			
			file.createNewFile();
			PrintStream out = new PrintStream(new FileOutputStream(file));
			
			
			int size = in.available();
			int packetSize = 10000;
			int totalPackets = size / packetSize;
			int remainingPacket = size % packetSize;
					
			byte data[] = new byte[packetSize];
			bar.setMaximum(0);
			bar.setMaximum(totalPackets);
			
			int k;
			for(k=1 ; k<=totalPackets ; k++)
			{
				
				in.readFully(data,0,data.length);
				out.write(data,0,data.length);
				bar.setValue(k);
				DynamicFileDownloadProtocol.tableModel.setValueAt(bar.getString(),DynamicFileDownloadProtocol.tableModel.getRowCount()-1, 1);

			}
			in.readFully(data,0,remainingPacket);
			out.write(data,0,remainingPacket);
			bar.setValue(k);
			
			in.close();
			out.close();
			bar.setValue(0);
		}
		
		if(NewDownload.deletionCheck.isSelected())
		{
			File f = new File(source);
		}
		
		if(NewDownload.closingCheck.isSelected())
		{
			this.newDownloadDialog.dispose();
		}
		
		}catch(Exception e){System.out.println(e);}
	}
}