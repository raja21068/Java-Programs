package p2pvideoconferencing;

/**
 * Title:        Live Media Transmision System based on RTP & RTCP protocols
 * Description:  This project will transfer video and audio contents on the network,
 * transmiter will take data from web-cam direct and transmit it to network and receiver will play that contents on the player on realtime mode. this implementation based on UDP protocol at transport level, at
 * application level we are developing our own protocols call RTP,RTCP
 * protocols at application level. as we know streams are only possible in TCP protocol, but RTP working on the top of UDP, RTP and RTCP provides here streams technique to be take data at realtime mode and relable this example aslo can be run on the Internet there will be no chance of losing packes RTCP protocol controlling this.
 * if this program not working please contact me thanks....
 * --------------------------------------------------------
 * Yougeshwar Khatri
 * BS-CS 3rd Year Student
 * IMCS, University of Sindh, Jamshoro.
 * Contact: yogeshwar_90@hotmail.com
 * Mobile: 03342811035
 * ---------------------------------------------------------------------
 * Mentor: Sachal Joyo (Network and Protocol designing)
 *                     (Java Technologies)
 * Title:        VideoConferenceRoomDialog
 * Description:  This is the main interface of video conferencing.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

import java.awt.Color;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Vector;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Format;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

public class VideoConferenceRoomDialog extends javax.swing.JDialog {

    public VideoConferenceRoomDialog(MainFrame parent) {
        super(parent);
        initComponents();
        userConstructor();
    }

    private void userConstructor(){
        this.getContentPane().setBackground(Color.white);
        this.setSize(820, 578);
        this.setLocationRelativeTo(null);
        
        onlinePeersVector = new java.util.Vector<PeerBean>();
        watchingPeersTable = new Hashtable<String, LiveCameraTransmitter>();
        livePeersTable = new Hashtable<String, LivePeerDialog>();
        permissionDialog = new PermissionDialog(this);
        restrictionDialog = new RestrictionDialog(this);

        textMessageListModel = new DefaultListModel<String>();
        textMessageList.setModel(textMessageListModel);
        
        intializeCamera();
    }

    @Override
    public void show(){
        getDevices();
        super.show();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlinePeersList = new javax.swing.JList();
        viewButton = new javax.swing.JButton();
        permissionButton = new javax.swing.JButton();
        restrictionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        videoDeviceNameLabel = new javax.swing.JLabel();
        videoDeviceLocationLabel = new javax.swing.JLabel();
        frameRateLabel = new javax.swing.JLabel();
        dataLengthLabel = new javax.swing.JLabel();
        resulationLabel = new javax.swing.JLabel();
        audioDeviceNameLabel = new javax.swing.JLabel();
        audioDeviceLocationLabel = new javax.swing.JLabel();
        timeLabel1 = new javax.swing.JLabel();
        transmittedPacketLabel1 = new javax.swing.JLabel();
        lastPacketSizeLabel1 = new javax.swing.JLabel();
        totalPacketLabel1 = new javax.swing.JLabel();
        packetSizeLabel1 = new javax.swing.JLabel();
        fileSizeLabel1 = new javax.swing.JLabel();
        fileNameLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        devicesComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        formatsList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        watcherPeerList = new javax.swing.JList();
        stopWatchingButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textMessageList = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        enterMessageTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        liveCameraPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Video Conference Room");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Video Conference Room");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 682, 41);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Online Peer");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(545, 70, 70, 15);

        onlinePeersList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(onlinePeersList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(542, 91, 123, 242);

        viewButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewButton);
        viewButton.setBounds(702, 351, 104, 58);

        permissionButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        permissionButton.setText("Permission");
        permissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(permissionButton);
        permissionButton.setBounds(702, 415, 104, 33);

        restrictionButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        restrictionButton.setText("Restriction");
        restrictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restrictionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restrictionButton);
        restrictionButton.setBounds(702, 454, 104, 33);

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelButton.setText("Back");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(702, 493, 104, 46);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(null);

        videoDeviceNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(videoDeviceNameLabel);
        videoDeviceNameLabel.setBounds(154, 21, 180, 15);

        videoDeviceLocationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(videoDeviceLocationLabel);
        videoDeviceLocationLabel.setBounds(154, 41, 180, 15);

        frameRateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(frameRateLabel);
        frameRateLabel.setBounds(154, 61, 180, 15);

        dataLengthLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataLengthLabel.setText("50688");
        jPanel6.add(dataLengthLabel);
        dataLengthLabel.setBounds(154, 81, 180, 15);

        resulationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resulationLabel.setText("176 X 144");
        jPanel6.add(resulationLabel);
        resulationLabel.setBounds(154, 101, 180, 15);

        audioDeviceNameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(audioDeviceNameLabel);
        audioDeviceNameLabel.setBounds(154, 121, 180, 15);

        audioDeviceLocationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel6.add(audioDeviceLocationLabel);
        audioDeviceLocationLabel.setBounds(154, 141, 180, 15);

        timeLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        timeLabel1.setText("Audio:");
        jPanel6.add(timeLabel1);
        timeLabel1.setBounds(10, 121, 40, 15);

        transmittedPacketLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transmittedPacketLabel1.setText("Audio Device Locator:");
        jPanel6.add(transmittedPacketLabel1);
        transmittedPacketLabel1.setBounds(10, 141, 140, 15);

        lastPacketSizeLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lastPacketSizeLabel1.setText("Resolution: ");
        jPanel6.add(lastPacketSizeLabel1);
        lastPacketSizeLabel1.setBounds(10, 101, 130, 15);

        totalPacketLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalPacketLabel1.setText("Max data length: ");
        jPanel6.add(totalPacketLabel1);
        totalPacketLabel1.setBounds(10, 81, 109, 15);

        packetSizeLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        packetSizeLabel1.setText("Frame Rate:");
        jPanel6.add(packetSizeLabel1);
        packetSizeLabel1.setBounds(10, 61, 80, 15);

        fileSizeLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fileSizeLabel1.setText("Video Device Locator: ");
        jPanel6.add(fileSizeLabel1);
        fileSizeLabel1.setBounds(10, 41, 136, 15);

        fileNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fileNameLabel1.setText("Video Capture Device: ");
        jPanel6.add(fileNameLabel1);
        fileNameLabel1.setBounds(10, 21, 138, 15);

        getContentPane().add(jPanel6);
        jPanel6.setBounds(10, 355, 350, 184);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Statical Report");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(13, 336, 93, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Watcher Peers");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(671, 70, 110, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Live");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(265, 70, 24, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Capture Devices");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(15, 70, 110, 15);

        devicesComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        devicesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devicesComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(devicesComboBox);
        devicesComboBox.setBounds(10, 91, 244, 31);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Formats Support");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(15, 128, 104, 15);

        formatsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane2.setViewportView(formatsList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 149, 244, 184);

        jScrollPane3.setViewportView(watcherPeerList);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(671, 89, 135, 203);

        stopWatchingButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopWatchingButton.setText("Stop Watching");
        stopWatchingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopWatchingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopWatchingButton);
        stopWatchingButton.setBounds(671, 298, 135, 35);

        jScrollPane4.setViewportView(textMessageList);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(369, 355, 327, 130);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Text Messaging");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(369, 336, 95, 15);

        enterMessageTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        enterMessageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterMessageTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(enterMessageTextField);
        enterMessageTextField.setBounds(369, 512, 327, 27);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Enter Message");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(369, 491, 89, 15);

        liveCameraPanel.setBackground(new java.awt.Color(0, 0, 0));
        liveCameraPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(liveCameraPanel);
        liveCameraPanel.setBounds(262, 91, 273, 242);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        PeerBean bean = (PeerBean) onlinePeersList.getSelectedValue();
        if (bean == null) {
            JOptionPane.showMessageDialog(this, "Select peer...");
            return;
        }
        new VideoConferenceThread(bean).start();
    }//GEN-LAST:event_viewButtonActionPerformed

    private void permissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionButtonActionPerformed
        permissionDialog.show();
    }//GEN-LAST:event_permissionButtonActionPerformed

    private void restrictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restrictionButtonActionPerformed
        restrictionDialog.show();
    }//GEN-LAST:event_restrictionButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void devicesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devicesComboBoxActionPerformed
        String deviceName = (String) devicesComboBox.getSelectedItem();
        if(deviceName == null) return;
        
        CaptureDeviceInfo captureDeviceInfo = CaptureDeviceManager.getDevice(deviceName);
        
        Vector<String> v = new Vector<String>();
        for(Format f : captureDeviceInfo.getFormats()){
            v.addElement(f.toString());
        }
        formatsList.setListData(v);
    }//GEN-LAST:event_devicesComboBoxActionPerformed

    private void stopWatchingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopWatchingButtonActionPerformed
        String name = (String) watcherPeerList.getSelectedValue();
        if (name == null) {
            JOptionPane.showMessageDialog(this, "Select peer...");
            return;
        }
        new StopWatchingMeThread(name).start();
    }//GEN-LAST:event_stopWatchingButtonActionPerformed

    private void enterMessageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterMessageTextFieldActionPerformed
        String msg = enterMessageTextField.getText();
        if(!msg.isEmpty())
            new TextMessageThread(msg).start();
    }//GEN-LAST:event_enterMessageTextFieldActionPerformed

    private void intializeCamera(){
        yourCamera = new YourCamera(this);
        setCameraInfo();
    }
    
    private void setCameraInfo(){
        this.videoDeviceNameLabel.setText(ConstantVariable.VIDEO_DEVICE_NAME);
        this.videoDeviceLocationLabel.setText(yourCamera.videoLocator);
        this.frameRateLabel.setText(String.valueOf(yourCamera.player.getRate()));
        this.audioDeviceNameLabel.setText(ConstantVariable.AUDIO_DEVICE_NAME);
        this.audioDeviceLocationLabel.setText(yourCamera.audioLocator);
    }
    
    private void resetWatcherList(String name){
        watchingPeersTable.remove(name);
        java.util.Enumeration e = watchingPeersTable.keys();
        Vector<String> v = new Vector<String>();
        while(e.hasMoreElements()){
            v.addElement((String)e.nextElement());
        }
        watcherPeerList.setListData(v);
    }
    
    private void getDevices(){
        devicesComboBox.removeAllItems();
        Vector<CaptureDeviceInfo> v = CaptureDeviceManager.getDeviceList(null);
        for (int i = 0; i < v.size(); i++)
            devicesComboBox.addItem(v.elementAt(i).getName());
    }
    
    private class VideoConferenceThread extends Thread{
        private PeerBean bean;
        
        private VideoConferenceThread(PeerBean bean){
            this.bean = bean;
        }
        
        @Override
        public void run(){
            try{
                Socket socket = new Socket(bean.getHostAddress(), 3333);
                PrintStream out = new PrintStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                
                out.println("Start-Conference");
                String answer = in.readLine();

                if(answer.equals("NO")){
                    JOptionPane.showMessageDialog(null, "Peer don't want to see me...");
                    return;
                }
                Thread.sleep(2000);
                LivePeerDialog livePeerDialog = new LivePeerDialog(bean);
                livePeerDialog.setVisible(true);
                livePeersTable.put(bean.getHostName(), livePeerDialog);
            }catch(IOException | HeadlessException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    private class StopWatchingMeThread extends Thread{
        private String name;
        
        private StopWatchingMeThread(String name){
            this.name = name;
        }
        
        @Override
        public void run(){
            try{
                Socket socket = new Socket(name, 3333);
                PrintStream out = new PrintStream(socket.getOutputStream());
                
                out.println("Stop-Watching-Me");
                Thread.sleep(2000);
                
                LiveCameraTransmitter liveCameraTransmitter = watchingPeersTable.get(name);
                if(liveCameraTransmitter != null){
                    liveCameraTransmitter.stopTransmitter();
                    resetWatcherList(name);
                }
                dispose();

                out.close();
                socket.close();
            }catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private class TextMessageThread extends Thread{
        private String msg;
        
        private TextMessageThread(String msg){
            this.msg = msg;
        }
        
        @Override
        public void run(){
            try{
                java.net.InetAddress address = java.net.InetAddress.getLocalHost();
                String localHost = address.getHostName();

                for(int i = 0; i < onlinePeersVector.size(); i++){
                    PeerBean bean = onlinePeersVector.get(i);
                    
                    if(bean.getHostName().equals(localHost)) continue;
                    
                    try (Socket socket = new Socket(bean.getHostName(), 3333)) {
                        PrintStream out = new PrintStream(socket.getOutputStream());
                        out.println("Text-Message");
                        
                        out.println(localHost + "[]" + msg);
                        
                        Thread.sleep(2000);
                        out.close();
                    }
                }
                textMessageListModel.addElement("Me: " + msg);
            }catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel audioDeviceLocationLabel;
    public javax.swing.JLabel audioDeviceNameLabel;
    private javax.swing.JButton cancelButton;
    public javax.swing.JLabel dataLengthLabel;
    private javax.swing.JComboBox devicesComboBox;
    private javax.swing.JTextField enterMessageTextField;
    public javax.swing.JLabel fileNameLabel1;
    public javax.swing.JLabel fileSizeLabel1;
    private javax.swing.JList formatsList;
    public javax.swing.JLabel frameRateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lastPacketSizeLabel1;
    public javax.swing.JPanel liveCameraPanel;
    public javax.swing.JList onlinePeersList;
    public javax.swing.JLabel packetSizeLabel1;
    private javax.swing.JButton permissionButton;
    private javax.swing.JButton restrictionButton;
    public javax.swing.JLabel resulationLabel;
    private javax.swing.JButton stopWatchingButton;
    private javax.swing.JList textMessageList;
    private javax.swing.JLabel timeLabel1;
    public javax.swing.JLabel totalPacketLabel1;
    public javax.swing.JLabel transmittedPacketLabel1;
    public javax.swing.JLabel videoDeviceLocationLabel;
    public javax.swing.JLabel videoDeviceNameLabel;
    private javax.swing.JButton viewButton;
    public javax.swing.JList watcherPeerList;
    // End of variables declaration//GEN-END:variables
    public java.util.Vector<PeerBean> onlinePeersVector;
    public YourCamera yourCamera;
    public java.util.Hashtable<String, LiveCameraTransmitter> watchingPeersTable;
    public java.util.Hashtable<String, LivePeerDialog> livePeersTable;
    private PermissionDialog permissionDialog;
    public RestrictionDialog restrictionDialog;
    public DefaultListModel<String> textMessageListModel;
}
