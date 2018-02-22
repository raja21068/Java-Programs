import java.io.DataInputStream;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.*;

class InputThread extends Thread{
	private Socket socket;
	FileTransferDialog dialog;
	InputThread(final Socket socket){
		this.socket = socket;
		dialog = new FileTransferDialog(new JFrame(), false);
		dialog.cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dialog.dispose();
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		dialog.hideBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dialog.dispose();
			} 
		});
		dialog.setVisible(true);
		dialog.progressBar.setMinimum(0);
		dialog.progressBar.setValue(0);
		dialog.progressBar.setStringPainted(true);
	}
	
	public void run(){
		try{
			
			DataInputStream in=new DataInputStream(socket.getInputStream());
			
			String fileName = in.readLine();
			dialog.fileNameLabel.setText("File Name : "+fileName);
			int packetSize = Integer.parseInt(in.readLine());
			dialog.packetSizeLabel.setText("Packet Size : "+packetSize);
			int totalPacket =Integer.parseInt(in.readLine());
			dialog.totalPacketLabel.setText("Total Packet : "+totalPacket);
			int lastPacket =Integer.parseInt(in.readLine());
			dialog.lastPacketLabel.setText("Last Packet Size : "+lastPacket);
			dialog.pcNameLabel.setText("PC Name : "+socket.getInetAddress().getHostAddress());
			dialog.ipLabel.setText("IP Address : "+socket.getInetAddress().getHostAddress());
			dialog.progressBar.setMaximum(totalPacket);
			
			byte[] b = new byte[packetSize];
			File f=new File("d:/download-files");
			f.mkdirs();
			
			FileOutputStream file=new FileOutputStream(f.getAbsolutePath()+"\\"+fileName);
			for(int i=1;i<=totalPacket;i++){
				in.readFully(b, 0, b.length);
				file.write(b, 0, b.length);
				dialog.progressBar.setValue(i);
			}
			
			in.readFully(b, 0, lastPacket);
			file.write(b, 0, lastPacket);
			
			System.out.println("FileRecieved..");

			in.close();
			file.close();
			socket.close();
			dialog.dispose();
		}catch(Exception e){ 
			dialog.dispose();
			e.printStackTrace();
	    }
	}
}