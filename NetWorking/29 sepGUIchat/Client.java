import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;


public class Client extends JFrame{
	private javax.swing.JScrollPane chatScroll;
	private javax.swing.JScrollPane msgScroll;
	javax.swing.JTextArea chatTxt; 
	javax.swing.JTextArea msgTxt;
	javax.swing.JLabel nameLbl;
	javax.swing.JLabel msgLbl;
	javax.swing.JTextField nameTxt; 
	javax.swing.JButton saveBtn;
	java.net.Socket socket;
	java.io.PrintStream outPrint;
	java.io.DataInputStream input;
	javax.swing.JButton enter;
	javax.swing.JButton connect;
	javax.swing.JLabel ipLbl;
	javax.swing.JTextField ipTxt;
	Thread t;
	
	Client() throws Exception{
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
		connect = new javax.swing.JButton();
		ipLbl = new javax.swing.JLabel();
		ipTxt = new javax.swing.JTextField("127.0.0.1");
		t=new Thread(){
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
		};
		setVisible(true);
		setTitle("Client");
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
		chatScroll.setBounds(20,50,300,240);
		
		getContentPane().add(nameLbl);
		nameLbl.setText("Nick Name:");
		nameLbl.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
		nameLbl.setBounds(20,305,120,20);
		
		getContentPane().add(nameTxt);
		nameTxt.setBounds(145,300,160,30);
		nameTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		getContentPane().add(msgLbl);
		msgLbl.setText("Message:");
		msgLbl.setBounds(20,385,160,30);
		
		getContentPane().add(msgScroll);
		msgScroll.setBounds(20,410,300,140);
		msgTxt.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if(((int)ch)==10){
					enterActionPerformed();
				}
			}
			
		});
		
		getContentPane().add(enter);
		enter.setText("Enter");
		enter.setEnabled(false);
		enter.setBounds(20,550,60,30);
		enter.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				enterActionPerformed();
			}
			
		});
		getContentPane().add(connect);
		connect.setText("Connect");
		connect.setBounds(240,340,90,20);
		connect.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
				socket = new java.net.Socket(ipTxt.getText(),9090);
				System.out.println("connected.....");
				enter.setEnabled(true);
				outPrint = new java.io.PrintStream(socket.getOutputStream());
				input = new java.io.DataInputStream(socket.getInputStream());
				t.start();
				}catch(Exception e1){ e1.printStackTrace();}
			}
			
		});
		getContentPane().add(ipLbl);
		ipLbl.setText("IP Adress:");
		ipLbl.setBounds(20,335,100,30);
		
		getContentPane().add(ipTxt);
		ipTxt.setBounds(80,340,160,20);
		ipTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
			
		
	}

	public void input()throws Exception{
		String msg =input.readLine();
		chatTxt.setText(chatTxt.getText()+"\n"+msg);
	}
	public void enterActionPerformed(){
		String s = msgTxt.getText();
		msgTxt.setText("");
		if(nameTxt.getText().trim().equals("")){chatTxt.setText(chatTxt.getText()+"\nClient : "+s);outPrint.println("Client : "+s); }
		else{chatTxt.setText(chatTxt.getText()+"\n"+nameTxt.getText()+" : "+s); outPrint.println(nameTxt.getText()+" : "+s); } 
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

}
