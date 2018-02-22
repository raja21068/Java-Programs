import java.awt.FileDialog;
import java.net.*;
import java.util.*;
import java.io.*;
/*
 * MainFrame.java
 *
 * Created on Oct 6, 2012, 3:08:00 AM
 *//**
 *
 * @author Jay Kumar
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        ipLabel = new javax.swing.JLabel();
        ipText = new javax.swing.JTextField();
        browseLabel = new javax.swing.JLabel();
        browseText = new javax.swing.JTextField();
        browseBtn = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        packetSizeText = new javax.swing.JTextField();
        totalPacketLabel = new javax.swing.JLabel();
        lastPacketLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        transferBtn = new javax.swing.JButton();
        restrictBtn = new javax.swing.JButton();
        permissionBtn = new javax.swing.JButton();
        permissionDialog = new PermissionDialog(this,true);
        restrictionDialog = new PermissionDialog(this,true);
        restrictionDialog.Label.setText("Grant Restriction");
        restrictionDialog.permissionBtn.setText("Restrict");
        permissionDialog.jTextField1.setEditable(false);
        permissionDialog.permissionBtn.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent e){
        		try {
					DBManager.deleteIp((String)permissionDialog.comboBox.getSelectedItem());
					permissionDialog.updateCombo();
				} catch (Exception e1) {e1.printStackTrace();}
        	}
        });
        restrictionDialog.permissionBtn.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent e){
        		try {
					DBManager.addIP(restrictionDialog.jTextField1.getText());
					restrictionDialog.updateCombo();
				} catch (Exception e1) {e1.printStackTrace();}
        	}
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ipLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        ipLabel.setText("Remote IP");

        browseLabel.setText("File Browse");

        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        fileNameLabel.setText("File Name : ");

        fileSizeLabel.setText("File Size : ");

        packetSizeLabel.setText("Packet Size :");

        totalPacketLabel.setText("Total Packets : ");

        lastPacketLabel.setText("Last Packet Size:");

        transferBtn.setText("Transfer");
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        restrictBtn.setText("Grant Restriction");
        restrictBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restrictBtnActionPerformed(evt);
            }
        });

        permissionBtn.setText("Grant Permission");
        permissionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lastPacketLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalPacketLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fileSizeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fileNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ipText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(ipLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(packetSizeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(packetSizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(browseText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(permissionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(restrictBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ipLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(browseBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packetSizeLabel)
                    .addComponent(packetSizeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalPacketLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastPacketLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transferBtn)
                        .addGap(5, 5, 5)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(permissionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restrictBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	FileDialog dialog=new FileDialog(new javax.swing.JFrame(),"Save",FileDialog.LOAD);	
		dialog.show();												
		String s=dialog.getDirectory() + dialog.getFile();
		browseText.setText(s);
    }                                         

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:

    			try{
    	    		if(ipText.getText().trim().equals("")){
    	    			javax.swing.JOptionPane.showMessageDialog(null,"Empty ip address");
    	    			return;
    	    		}
        			Socket socket = new java.net.Socket(ipText.getText(),9000);
        			System.out.println("connected...");
        			java.io.File f = new java.io.File(browseText.getText());
        			java.io.DataInputStream inFile = new java.io.DataInputStream(new java.io.FileInputStream(f));
        			int fileSize = inFile.available();
        			int packetSize = Integer.parseInt(packetSizeText.getText());
        			int totalPacket = fileSize / packetSize;
        			int lastPacket = fileSize % packetSize;
        			String fileName = f.getName();
        			fileNameLabel.setText("File Name        "+fileName);
    				fileSizeLabel.setText("File Size        "+fileSize);
    				packetSizeLabel.setText("Packet Size        "+packetSize);
    				totalPacketLabel.setText("Total Packets        "+(totalPacket+1));
    				lastPacketLabel.setText("Last Packet Size : "+lastPacket);
    				new TransferThread(f ,fileSize ,packetSize, totalPacket, socket , inFile,progressBar).start();
        		}catch(FileNotFoundException e){
        			javax.swing.JOptionPane.showMessageDialog(null,"File Not Found....");
        			}
        		catch(NumberFormatException e){
        			javax.swing.JOptionPane.showMessageDialog(null,"Empty / Invalid packet Size");
        		}
        		catch(SocketException e){
        			javax.swing.JOptionPane.showMessageDialog(null,"Request Rejected");
        		}
        		catch(Exception e){ e.printStackTrace(); }
    }
    
    private void permissionBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
       permissionDialog.setVisible(true);
    }                                        

    private void restrictBtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	restrictionDialog.setVisible(true);
    }                                           

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify
    private javax.swing.JButton browseBtn;
    private javax.swing.JLabel browseLabel;
    private javax.swing.JTextField browseText;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipText;
    private javax.swing.JLabel lastPacketLabel;
    private javax.swing.JLabel packetSizeLabel;
    private javax.swing.JTextField packetSizeText;
    private javax.swing.JButton permissionBtn;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton restrictBtn;
    private javax.swing.JLabel totalPacketLabel;
    private javax.swing.JButton transferBtn;
    PermissionDialog permissionDialog;
    PermissionDialog restrictionDialog;
    // End of variables declaration
    
   
}

