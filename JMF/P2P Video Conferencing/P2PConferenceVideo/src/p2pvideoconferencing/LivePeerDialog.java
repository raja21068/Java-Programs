package p2pvideoconferencing;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

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
 * Title:        LivePeerDialog
 * Description:  This class use the LiveCameraReciever class to show video with GUI view.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public class LivePeerDialog extends javax.swing.JFrame {

    public LivePeerDialog(PeerBean peerBean){
        this.peerBean = peerBean;
        
        initComponents();
        setSize(410, 396);
        setLocationRelativeTo(null);
        intializeCamera();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        liveCameraPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Live Peer");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(410, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Stop & Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        liveCameraPanel.setBackground(new java.awt.Color(0, 0, 0));
        liveCameraPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(liveCameraPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new StopConferenceThread(peerBean).start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void intializeCamera(){
        liveCameraReciever = new LiveCameraReciever(this, peerBean);
    }

    private class StopConferenceThread extends Thread{
        private PeerBean bean;
        
        private StopConferenceThread(PeerBean bean){
            this.bean = bean;
        }
        
        @Override
        public void run(){
            try{
                Socket socket = new Socket(bean.getHostAddress(), 3333);
                PrintStream out = new PrintStream(socket.getOutputStream());
                
                out.println("Stop-Conference");
                Thread.sleep(2000);
                liveCameraReciever.stop();
                dispose();
            }catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel liveCameraPanel;
    // End of variables declaration//GEN-END:variables
    private PeerBean peerBean;
    public LiveCameraReciever liveCameraReciever;
}
