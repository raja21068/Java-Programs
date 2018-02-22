import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.awt.FileDialog;
import javax.swing.JFrame;


public class Server extends JFrame implements KeyListener {
	private javax.swing.JScrollPane chatScroll;
	private javax.swing.JScrollPane msgScroll;
	javax.swing.JTextArea chatTxt; 
	javax.swing.JTextArea msgTxt;
	javax.swing.JLabel nameLbl;
	javax.swing.JLabel msgLbl;
	javax.swing.JTextField nameTxt; 
	javax.swing.JButton saveBtn;
	java.net.ServerSocket server;
	java.net.Socket socket;
	java.io.PrintStream outPrint;
	java.io.DataInputStream input;
	javax.swing.JButton enter;
	
	Server() throws Exception{
		addKeyListener(this);
		initComponents();
	}
	void initComponents()throws Exception{
		chatTxt = new javax.swing.JTextArea();
		msgTxt = new javax.swing.JTextArea();
		chatScroll = new javax.swing.JScrollPane(chatTxt);
		msgScroll = new javax.swing.JScrollPane(msgTxt);
		nameLbl = new javax.swing.JLabel();
		msgLbl = new javax.swing.JLabel();
		nameTxt = new javax.swing.JTextField();
		saveBtn = new javax.swing.JButton();
		enter = new javax.swing.JButton();
		server = new java.net.ServerSocket(9090);
		socket = server.accept();
		System.out.println("Connected...");
		setVisible(true);
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
											
				FileDialog dialog=new FileDialog(new JFrame(),"Save",FileDialog.SAVE);	
				dialog.show();												
				String s=dialog.getDirectory() + dialog.getFile();		
				try{
				File f=new File(s);										
				if(!f.exists()){ f.createNewFile(); }					
				String str=chatTxt.getText();								
				OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(f));
				out.write(str);										
				out.close();												
				}catch(Exception e1){}	
	     
			}
			
		});
		
		getContentPane().add(chatScroll);
		chatTxt.setEditable(false);
		chatTxt.setEnabled(false);
		chatScroll.setBounds(20,50,300,300);
		
		getContentPane().add(nameLbl);
		nameLbl.setText("Nick Name:");
		nameLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
		nameLbl.setBounds(20,365,120,20);
		
		getContentPane().add(nameTxt);
		nameTxt.setBounds(145,360,160,30);
		
		nameTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		getContentPane().add(msgLbl);
		msgLbl.setText("Message:");
		msgLbl.setBounds(20,385,160,30);
		
		getContentPane().add(msgScroll);
		msgScroll.setBounds(20,410,300,140);
		
		getContentPane().add(enter);
		enter.setText("Enter");
		enter.setBounds(20,550,60,30);
		enter.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = msgTxt.getText();
				msgTxt.setText("");
				if(nameTxt.getText().trim().equals("")){chatTxt.setText(chatTxt.getText()+"\nServer : "+s);outPrint.println("server : "+s); }
				else{chatTxt.setText(chatTxt.getText()+"\n"+nameTxt.getText()+" : "+s); outPrint.println(nameTxt.getText()+" : "+s); 				} 
				}
			
		});
			new Thread(){
				public void run(){
					do{
						try {
							input();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}while(true);
				}
			}.start();
		
	}

	public void input()throws Exception{
		String msg =input.readLine();
		chatTxt.setText(chatTxt.getText()+"\n: "+msg);
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			new Server();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println(c);
	}

}
