import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;


public class Client extends javax.swing.JFrame implements KeyListener {
	
	javax.swing.JLabel ipLbl;
	javax.swing.JTextField ipTxt;
	javax.swing.JTextField browseTxt;
	javax.swing.JLabel BowseLbl;
	javax.swing.JLabel fileNameLbl; 
	javax.swing.JButton browseBtn;
	javax.swing.JLabel fileSizeLbl; 
	javax.swing.JLabel packetSizeLbl;
	javax.swing.JLabel totalPacketLbl;
	javax.swing.JLabel transPackLbl;
	javax.swing.JButton transfer;
	javax.swing.JProgressBar progressBar;
	java.net.Socket socket;
	java.io.PrintStream outPrint;
	java.io.DataInputStream input;
	
	
	Client() throws Exception{
		addKeyListener(this);
		initComponents();
	}
	void initComponents()throws Exception{
		ipLbl = new javax.swing.JLabel();
		ipTxt = new javax.swing.JTextField("127.0.0.1");
		browseTxt = new javax.swing.JTextField();
		BowseLbl = new javax.swing.JLabel();
		fileNameLbl = new javax.swing.JLabel();
		fileSizeLbl = new javax.swing.JLabel();
		packetSizeLbl = new javax.swing.JLabel();
		totalPacketLbl = new javax.swing.JLabel();
		transPackLbl = new javax.swing.JLabel();
		browseBtn = new javax.swing.JButton();
		transfer = new javax.swing.JButton();
		progressBar = new javax.swing.JProgressBar();
	
		setVisible(true);
		setTitle("Client");
		setLayout(null);
		setBounds(100,100,360,600);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(browseTxt);
		browseTxt.setBounds(20,80,300,25);
		
		getContentPane().add(browseBtn);
		browseBtn.setText("Browse");
		browseBtn.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,13));
		browseBtn.setBounds(20,120,120,30);
		browseBtn.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){							
				FileDialog dialog=new FileDialog(new javax.swing.JFrame(),"Save",FileDialog.LOAD);	
				dialog.show();												
				String s=dialog.getDirectory() + dialog.getFile();
				browseTxt.setText(s);
					
	     }
			
		});
		
		getContentPane().add(BowseLbl);
		BowseLbl.setText("Browse Your File:");
		BowseLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		BowseLbl.setBounds(20,55,140,20);
		
		getContentPane().add(fileNameLbl);
		fileNameLbl.setText("File Name : ");
		fileNameLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		fileNameLbl.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		fileNameLbl.setBounds(20,200,300,30);
		
		getContentPane().add(fileSizeLbl);
		fileSizeLbl.setText("File Size : ");
		fileSizeLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		fileSizeLbl.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		fileSizeLbl.setBounds(20,250,300,30);
		
		getContentPane().add(packetSizeLbl);
		packetSizeLbl.setText("Packet Size : ");
		packetSizeLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		packetSizeLbl.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		packetSizeLbl.setBounds(20,300,300,30);
		
		getContentPane().add(totalPacketLbl);
		totalPacketLbl.setText("Total Packet : ");
		totalPacketLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		totalPacketLbl.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		totalPacketLbl.setBounds(20,350,300,30);
		
		getContentPane().add(transPackLbl);
		transPackLbl.setText("Transfer Packet# ");
		transPackLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		transPackLbl.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		transPackLbl.setBounds(20,400,300,30);
		
		getContentPane().add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,15));
		progressBar.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,222,0)));
		progressBar.setBounds(20,450,300,30);
		
		getContentPane().add(transfer);
		transfer.setText("Transfer");
		transfer.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,13));
		transfer.setBounds(170,120,120,30);
		transfer.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				socket = new java.net.Socket(ipTxt.getText(),9090);
				System.out.println("connected...");
				java.io.File f = new java.io.File(browseTxt.getText());
				java.io.DataInputStream inFile = new java.io.DataInputStream(new java.io.FileInputStream(f));
				int fileSize = inFile.available();
				int packetSize = 10000;
				int totalPacket = fileSize / packetSize;
				int lastPacket = fileSize % packetSize;
				String fileName = f.getName();
				fileNameLbl.setText("File Name        "+fileName);
				fileSizeLbl.setText("FileSize        "+fileSize);
				packetSizeLbl.setText("Packet Size        "+packetSize);
				totalPacketLbl.setText("Total Packet        "+(totalPacket+1));
				java.io.File desti = new java.io.File("D:/"+fileName);
				desti.createNewFile();
				new TransferThread(f ,fileSize ,packetSize, totalPacket, socket , inFile,progressBar, transPackLbl).start();
				}catch(Exception e1){ e1.printStackTrace();}
			}
			
		});
		getContentPane().add(ipLbl);
		ipLbl.setText("IP Adress:");
		ipLbl.setBounds(20,10,100,30);
		
		getContentPane().add(ipTxt);
		ipTxt.setBounds(80,15,160,20);
		ipTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			
		
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			new Client();
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println(c);
	}

}
class TransferThread extends Thread{
	String fileName;
	int fileSize;
	int packetSize;
	int totalPacket;
	int lastPacket;
	java.io.File f;
	java.io.DataOutputStream outForSocket;
	java.io.DataInputStream inFile ;
	javax.swing.JProgressBar bar;
	java.net.Socket socket;
	javax.swing.JLabel packLbl;
	TransferThread(java.io.File file,int fileSize , int packSize , int totalPack ,java.net.Socket socket,java.io.DataInputStream inFile , javax.swing.JProgressBar bar,javax.swing.JLabel label){
		f = file;
		this.fileName = file.getName();
		this.fileSize = fileSize;
		packetSize = packSize;
		this.totalPacket = totalPack;
		this.lastPacket = fileSize % packetSize;
		this.socket = socket;
		this.inFile = inFile;
		this.bar = bar;
		packLbl = label;
		bar.setMaximum(totalPack);
		}
	public void run(){
		
		try {
			//outForSocket = new java.io.DataOutputStream(new java.io.FileOutputStream("D:/"+fileName));
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
					bar.setValue(i);
					packLbl.setText("Transfer Packet# "+i);
				}
				inFile.readFully(b,0,lastPacket);
				outForSocket.write(b,0,lastPacket);
				packLbl.setText("Transfer Packet# "+(totalPacket+1));
				javax.swing.JOptionPane.showMessageDialog(null,"Copied succesfuly..");
				
		} 
		catch (FileNotFoundException e) {e.printStackTrace();}
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
