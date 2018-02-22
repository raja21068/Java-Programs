import java.io.*;

class ContinueRowProgress implements Runnable
{
	Thread rowThread;
	private String source, destination;
	private int rowNumber;
	
	ContinueRowProgress(String source, String destination, int rowNumber)
	{
		this.source = source;
		this.destination = destination;
		this.rowNumber = rowNumber;
		rowThread = new Thread(this,"Row Thread");
	}
	
	public void run()
	{
		try{
			
			File sourceFile = new File(source);
			if(!sourceFile.exists())
				return;
			
			
			File destinationFile = new File(destination);
			
			if(destinationFile.exists())
			{
				RandomAccessFile r = new RandomAccessFile(source,"r");
				RandomAccessFile w = new RandomAccessFile(destination,"rw");
				
				int totalSize = (int)r.length();
				int bytesToSkip = (int)w.length();
				int packetSize = 10000;
				int totalPackets = totalSize/packetSize;
				int remainingPackets = totalSize%packetSize;
				int initialPacket = bytesToSkip/packetSize;
				
				byte b[] = new byte[packetSize]; 
				r.skipBytes(bytesToSkip);
				w.seek(bytesToSkip);
				
				
				for(int k=initialPacket+1 ; k<=totalPackets ; k++)
				{
					r.readFully(b,0,b.length);
					w.write(b,0,b.length);
					double per = (double)w.length() * 100 / totalSize;
					DynamicFileDownloadProtocol.tableModel.setValueAt((int)per+"%", rowNumber, 1);
				}
				
				r.readFully(b,0,remainingPackets);
				w.write(b,0,remainingPackets);
				double per = (double)w.length() * 100 / totalSize;
				DynamicFileDownloadProtocol.tableModel.setValueAt((int)per+"%", rowNumber, 1);
			}
			
			
			if(!destinationFile.exists())
			{
				
				destinationFile.createNewFile();
				PrintStream out = new PrintStream(new FileOutputStream(destinationFile));
				
				DataInputStream in = new DataInputStream(new FileInputStream(sourceFile));
				
				
				int totalSize = in.available();
				int packetSize = 10000;
				int totalPackets = totalSize/packetSize;
				int remainingPackets = totalSize%packetSize;
				
				byte b[] = new byte[packetSize]; 
				
				for(int k=1 ; k<=totalPackets ; k++)
				{
					in.readFully(b,0,b.length);
					out.write(b,0,b.length);
					double per = (double)destinationFile.length() * 100 / totalSize;
					DynamicFileDownloadProtocol.tableModel.setValueAt((int)per+"%", rowNumber, 1);
				}
				
				in.readFully(b,0,remainingPackets);
				out.write(b,0,remainingPackets);
				double per = (double)destinationFile.length() * 100 / totalSize;
				DynamicFileDownloadProtocol.tableModel.setValueAt((int)per+"%", rowNumber, 1);
			}
			
		}catch(Exception e){}
	}
}
