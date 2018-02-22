import java.io.*;
import java.net.*;


class Server {
	public static void main(String arg[]) throws Exception{
			ServerSocket server= new ServerSocket(9000); 	
			do{
					Socket socket = server.accept();
					System.out.println("Connected with : "+socket.getLocalPort());
		
					new InputThread(socket).start();
			}while(true);
	}
}

class InputThread extends Thread{
	private Socket socket;
	javax.swing.JFileChooser choose;
	InputThread(Socket socket){
		this.socket = socket;
		choose = new javax.swing.JFileChooser();
		choose.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
	}
	
	public void run(){
		try{
			DataInputStream in=new DataInputStream(socket.getInputStream());
			choose.showDialog(null,"Ok");
			File f=new File(choose.getSelectedFile().getAbsolutePath());
			//File f=new File("D:/download-files");
			f.mkdirs();
                        do{		
			String fileName = in.readLine();
			int packetSize = Integer.parseInt(in.readLine());
			int totalPacket =Integer.parseInt(in.readLine());
			int lastPacket =Integer.parseInt(in.readLine());
                        
                        String temp = fileName.substring(3, fileName.lastIndexOf("\\"));
                        
			byte[] b = new byte[packetSize];
                        System.out.println("directories :"+temp+"\nfilesize"+packetSize+"packets:"+totalPacket);
			new File(f.getAbsolutePath()+"\\"+temp).mkdirs();
                        temp+= "\\"+fileName.substring(fileName.lastIndexOf("\\"));
			System.out.println("temp:"+temp);
			FileOutputStream file=new FileOutputStream(f.getAbsolutePath()+"\\"+temp);
			
			for(int i=1;i<=totalPacket;i++){
				in.readFully(b, 0, b.length);
				file.write(b, 0, b.length);
				System.out.println(i);
			}
			
			in.readFully(b, 0, lastPacket);
			file.write(b, 0, lastPacket);
			
			System.out.println("FileRecieved..");

//			in.close();
			file.close();
                        }while(true);
//			socket.close();
			
		}catch(Exception e){ 
			e.printStackTrace();
	    }
	}
}