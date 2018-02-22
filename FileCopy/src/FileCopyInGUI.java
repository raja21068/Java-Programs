import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class FileCopyInGUI extends JFrame implements ActionListener{
	
	//Buttons initializing
	JButton browse1=new JButton("Browse");
	JButton browse2=new JButton("Browse");
	JButton start=new JButton("Start");
	JButton pause=new JButton("Pause");
	JButton stop=new JButton("Stop");
	JButton about=new JButton("About");
	JButton exit=new JButton("Exit");
	//Text fields initializing
	JTextField s=new JTextField("");
	JTextField d=new JTextField("");
	
	//Labels initializing
	JLabel l1=new JLabel("Source");
	JLabel l2=new JLabel("Destination");
	//Check Box initializing
	JCheckBox check=new JCheckBox("Delete File from source after Copied..");
	
	JProgressBar bar=new JProgressBar();
	String fileName="";
	
	startThread copyThread;
	
	FileCopyInGUI(){
		
		//setting Frame
		setBounds(100,100,500,300);
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e){}
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container con=getContentPane();
		con.setLayout(null);
		
		
		//Setting Bounds Of Components
		browse1.setBounds(380,30,80,30);
		browse2.setBounds(380,80,80,30);
		start.setBounds(30, 200,70,30);
		pause.setBounds(110, 200,70,30);
		stop.setBounds(190, 200,70,30);
		about.setBounds(270, 200,70,30);
		exit.setBounds(350, 200,70,30);
		s.setBounds(85,35,285,30);
		d.setBounds(85,85,285,30);
		l1.setBounds(20,40,50,20);
		l2.setBounds(20,90,70,20);
		check.setBounds(30, 120, 250, 20);
		bar.setBounds(60, 160, 350, 20);
		
		//Adding components in container of Frame
		con.add(check);
		con.add(l2);
		con.add(l1);
		con.add(d);
		con.add(s);
		con.add(exit);
		con.add(about);
		con.add(stop);
		con.add(pause);
		con.add(start);
		con.add(browse2);
		con.add(browse1);
		con.add(bar);
		
		//Registering the components into Action Listener
		browse1.addActionListener(this);
		browse2.addActionListener(this);
		start.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);
		check.addActionListener(this);
		about.addActionListener(this);
		exit.addActionListener(this);
		stop.setEnabled(false);
		pause.setEnabled(false);
		
		
		show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==browse1){ open(); }
		else if(ob==browse2){ save(); }
		else if(ob==start){ try{ copyThread=new startThread();
							copyThread.start();	}catch(Exception e1){} 
							start.setEnabled(false);
							stop.setEnabled(true);
							pause.setEnabled(true);
						  }
		else if(ob==pause){ 
				if(pause.getText().equals("Pause")){
							copyThread.suspend();
							pause.setText("Resume");
						}
				else if(pause.getText().equals("Resume")){
							copyThread.resume();
							pause.setText("Pause");
						}
					}
		else if(ob==stop){
			copyThread.stop();
			copyThread=null;
				s.setText("");
				d.setText("");
				fileName="";
				pause.setEnabled(false);
				stop.setEnabled(false);
				start.setEnabled(true);
		}
		else if(ob==about){ JOptionPane.showMessageDialog(null,
				"This is Program for copying the file\n you have to give destination path with copying file name\nBY:JAY KUMAR 2K11/CSM/25"); }
		else if(ob==exit){ System.exit(0); }
	}
	
	
	void open(){
		fileName="";
		Frame win=new Frame();
		FileDialog dialog=new FileDialog(win,"open....",FileDialog.LOAD);
		dialog.show();
		String str=dialog.getDirectory() + dialog.getFile();
		fileName=dialog.getFile();
		s.setText("");	
		if(!str.equals("nullnull"))s.setText(str);
                JOptionPane.showMessageDialog(null, str);
	}
	void save(){
		Frame win=new Frame();
		FileDialog dialog=new FileDialog(win,"open....",FileDialog.SAVE);
		dialog.show();
		String str=dialog.getDirectory()+ dialog.getFile();
                JOptionPane.showMessageDialog(null, dialog.getDirectory()+"/"+ dialog.getFile());
		d.setText("");	
		if(!str.equals("nullnull"))d.setText(str);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileCopyInGUI();
	}

////////////////////////////////////////////////////////////////////////
	//Inner Class
	class startThread extends Thread{
		public void run(){
			String source=s.getText();
			String desti=d.getText();
			JOptionPane.showMessageDialog(null, "Source:"+source);
			
			if(source.equals("")){JOptionPane.showMessageDialog(null,"sain path ta diyo...!"); return; }
			if(desti.equals("")){JOptionPane.showMessageDialog(null,"sain path ta diyo...!"); return; }
			
//			if(fileName.equals("")){ 
//				int lio=source.lastIndexOf("\\");
//				fileName=source.substring(lio+1, source.length());
//				desti+=fileName;
//				}
//			else { desti+=fileName; }
			
			File so=new File(source);
			File des=new File(d.getText());
                        JOptionPane.showMessageDialog(null, "des- "+des.getAbsolutePath());
			if(!so.exists()){ JOptionPane.showMessageDialog(null,"yar to source path hi galat dino aa...!"); return; }
			
			try{
			
				DataInputStream in = new DataInputStream(new FileInputStream(source));
				
				//Destination   
				File f = new File(desti);
				if(!f.exists()){ f.createNewFile();}
			    
				RandomAccessFile out = new RandomAccessFile(source,"r");
				RandomAccessFile wr=new RandomAccessFile(des,"rw");
				
			    
			    long size =so.getTotalSpace();
			    System.out.println("Source file size: "+size);
                            int packetSize = 100000;
			    long initialsize=des.getTotalSpace();
                            System.out.println("destination file size : "+initialsize);
			    long totalPackets =so.getTotalSpace() / packetSize;
                            System.out.println("total packets : "+totalPackets);
			    long lastPacketSize = so.getTotalSpace() % packetSize;
                            System.out.println("last packert : "+lastPacketSize);
			    
                            byte b[] = new byte[packetSize];
			    long i;
			    
			    bar.setStringPainted(true);
			    bar.setMaximum((int)(totalPackets+1));
			    bar.setMinimum(0);
			    bar.setValue((int)initialsize/packetSize);
			    out.skipBytes(Long.bitCount(initialsize));
			    wr.seek(initialsize);
			    
                            System.out.println("Loop start from packet: "+((initialsize/packetSize)+1));
                            
                            i = ((initialsize/packetSize)+1);
                            System.out.println("i :"+i);
                            System.out.println("total packat: "+totalPackets);
			    while(i<=totalPackets){
                                bar.setValue((int)i);
			         bar.validate();
			        //super.setTitle("Total: "+totalPackets+" value: "+i);
			        //bar.show();
			    	System.out.println("Packet : " + i);
                                 out.readFully(b, 0, b.length);
			        wr.write(b, 0, b.length);
			        System.out.println("Packet : " + i);
                            }
                            
//                            for(i=(int)(initialsize/packetSize)+1; i<=totalPackets; i++){
//			    	bar.setValue(i);
//			         bar.validate();
//			        //super.setTitle("Total: "+totalPackets+" value: "+i);
//			        //bar.show();
//			    	out.readFully(b, 0, b.length);
//			        wr.write(b, 0, b.length);
//			        System.out.println("Packet : " + i);
//			    }

			    System.out.println("Last Packet : " + i);
			    in.readFully(b, 0,(int) lastPacketSize);
			    out.write(b, 0, (int)lastPacketSize);

			    System.out.println("File Size     : " + size);
			    System.out.println("Last Packet   : " + lastPacketSize);
			    in.close();
			    out.close();
			    if(check.isSelected()){ System.out.println("true");  so.delete(); }
			    JOptionPane.showMessageDialog(null,"File Copied Successfully...");
			    start.setEnabled(true);
			    pause.setEnabled(false);
			    stop.setEnabled(false);
			    s.setText("");
			    d.setText("");
			    fileName="";
			}catch(Exception e1){}
			}
	}//End of inner Class
///////////////////////////////////////////////////////////////////////////////////////

}
