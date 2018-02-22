import javax.swing.*;

import java.awt.Font;
import java.io.*;
import java.net.*;

class SendingThread extends JDialog implements Runnable
{
	private Thread t;
	private JLabel fileNameLabel = new JLabel("File Name : ");
	private JLabel fileSizeLabel = new JLabel("File Size : ");
	private JLabel packetSizeLabel = new JLabel("Packet Size : 10000");
	private JLabel totalPacketsLabel = new JLabel("Total Packets : ");
	private JLabel lastPacketLabel = new JLabel("Last Packet : ");
	private JProgressBar bar = new JProgressBar();
	private String filePath;
	private String ip;
	SendingThread(Client c)
	{
		super(c,false);
		filePath = c.browseText.getText();
		ip = c.ipText.getText();
		setBounds(c.getX(),c.getY()+c.getHeight(),400,240);
		setTitle("0% - "+filePath);
		setResizable(false);
		setLayout(null);
		
		java.awt.Font font = new Font("Arail",Font.BOLD,20);
		
		fileNameLabel.setBounds(30,10,340,30);	
		fileSizeLabel.setBounds(30,40,340,30);	
		packetSizeLabel.setBounds(30,70,340,30);	
		totalPacketsLabel.setBounds(30,100,340,30);	
		lastPacketLabel.setBounds(30,130,340,30);	
		add(fileNameLabel);
		add(fileSizeLabel);
		add(packetSizeLabel);
		add(totalPacketsLabel);
		add(lastPacketLabel);
		
		bar.setBounds(20,170,360,30);
		bar.setStringPainted(true);
		add(bar);
		
		setVisible(true);
		t = new Thread(this,"Sending Thread");
		t.setDaemon(true);
		t.start();
	}
	
	public void run()
	{
		File f = new File(filePath);
		String fileName = f.getName();
		long fileSize = f.length();
		int packetSize = 10000;
		int totalPackets = (int)fileSize/packetSize;
		int lastPacket = (int)fileSize%packetSize;
		
		fileNameLabel.setText("File Name : "+fileName);
		fileSizeLabel.setText("File Size : "+fileSize);
		totalPacketsLabel.setText("Total Packets : "+totalPackets);
		lastPacketLabel.setText("Last Packet : "+lastPacket);
		
		try{
			Socket socket = new Socket(ip,9090);
			DataInputStream in = new DataInputStream(new FileInputStream(f));
			PrintStream out = new PrintStream(socket.getOutputStream());
			
			out.println(fileName);
			out.println(fileSize);
			out.println(packetSize);
			out.println(totalPackets);
			out.println(lastPacket);
			
			bar.setMinimum(0);
			bar.setMaximum(totalPackets);
			bar.setValue(0);
			byte data[] = new byte[packetSize];
			
			int k;
			for(k=1 ; k<=totalPackets ; k++)
			{
				in.readFully(data, 0, packetSize);
				out.write(data, 0, packetSize);
				bar.setValue(k);
				setTitle(bar.getString() + " - " + filePath);
			}
			in.readFully(data, 0, lastPacket);
			out.write(data, 0, lastPacket);
			bar.setValue(k);
			
			socket.close();
			in.close();
			out.close();
			
			JOptionPane.showMessageDialog(null, "Transfer compeleted");
			this.dispose();
			
		}catch(Exception ex){}
	}
}
