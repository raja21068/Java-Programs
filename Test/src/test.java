import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class ServerFrame extends javax.swing.JFrame{
	
	ServerFrame()throws Exception{
		
		
	}
	void initComponents()throws Exception{
		chatTxt = new javax.swing.JTextField();
		msgTxt = new javax.swing.JTextField();
		chatScroll = new javax.swing.JScrollPane(chatTxt);
		msgScroll = new javax.swing.JScrollPane(msgTxt);
		nameLbl = new javax.swing.JLabel();
		msgLbl = new javax.swing.JLabel();
		nameTxt = new javax.swing.JTextArea();
		saveBtn = new javax.swing.JButton();
		enter = new javax.swing.JButton();
		server = new java.net.ServerSocket(9090);
		socket = server.accept();
		outPrint = new java.io.PrintStream(socket.getOutputStream());
		input = new java.io.DataInputStream(socket.getInputStream());
		
		setTitle("Server");
		setLayout(null);
		setBounds(100,100,360,600);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(saveBtn);
		saveBtn.setText("Save");
		saveBtn.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
		saveBtn.setBounds(20,10,100,30);
		saveBtn.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Hello");
			}
			
		});
		
		getContentPane().add(chatScroll);
		chatTxt.setEditable(false);
		chatScroll.setBounds(20,50,300,300);
		
		getContentPane().add(nameLbl);
		nameLbl.setText("Nick Name:");
		nameLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
		nameLbl.setBounds(20,365,120,20);
		
		getContentPane().add(nameTxt);
		nameTxt.setBounds(145,360,160,30);
		nameTxt.setEditable(false);
		nameTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		getContentPane().add(msgLbl);
		msgLbl.setText("Message:");
		msgLbl.setBounds(20,395,160,30);
		
		getContentPane().add(msgScroll);
		msgScroll.setBounds(20,420,300,140);
		msgTxt.setEditable(false);
		
		getContentPane().add(enter);
		msgScroll.setBounds(20,550,60,30);
		
		
	}
	
	
	private javax.swing.JScrollPane chatScroll;
	private javax.swing.JScrollPane msgScroll;
	javax.swing.JTextField chatTxt; 
	javax.swing.JTextField msgTxt;
	javax.swing.JLabel nameLbl;
	javax.swing.JLabel msgLbl;
	javax.swing.JTextArea nameTxt; 
	javax.swing.JButton saveBtn;
	java.net.ServerSocket server;
	java.net.Socket socket;
	java.io.PrintStream outPrint;
	java.io.DataInputStream input;
	javax.swing.JButton enter;
	
	
}

public class test{
	public static void main(String arg[]){
		try{
		ServerFrame s = new ServerFrame();
		s.setVisible(true);
		}catch(Exception e){}
	}
}