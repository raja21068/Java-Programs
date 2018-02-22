import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import javax.swing.JOptionPane;

class TransferThread extends Thread{
	String fileName;
	int fileSize;
	int packetSize;
	int totalPacket;
	int lastPacket;
	java.io.File f;
	java.io.DataOutputStream outForSocket;
	java.io.DataInputStream inFile ;
	java.net.Socket socket;
	TransferThread(java.io.File file,int fileSize , int packSize , int totalPack ,java.net.Socket socket,java.io.DataInputStream inFile){
		f = file;
		this.fileName = file.getName();
		this.fileSize = fileSize;
		packetSize = packSize;
		this.totalPacket = totalPack;
		this.lastPacket = fileSize % packetSize;
		this.socket = socket;
		this.inFile = inFile;
				}
	public void run(){
		
		try {
			outForSocket = new java.io.DataOutputStream(socket.getOutputStream());	
			java.io.PrintStream print = new java.io.PrintStream(socket.getOutputStream());
			System.out.println(fileName);
			print.println(fileName);
			System.out.println(""+packetSize);
			print.println(""+packetSize);
			System.out.println(""+totalPacket);
			print.println(""+totalPacket);
			System.out.println(""+lastPacket);
			print.println(""+lastPacket);
				byte[] b = new byte[packetSize];
				for(int i =1; i<=totalPacket;i++){
					inFile.readFully(b, 0, b.length);
					outForSocket.write(b, 0, b.length);
				}
				inFile.readFully(b,0,lastPacket);
				outForSocket.write(b,0,lastPacket);
				
				
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch(SocketException e){ JOptionPane.showMessageDialog(null, "Request Rejected.."); }
		catch (IOException e){ e.printStackTrace(); }
		finally{
			try {
				inFile.close();
				outForSocket.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
