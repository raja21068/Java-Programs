package p2pvideoconferencing;

import java.awt.Color;

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
 * Title:        MainFrame
 * Description:  Main Interface
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        userConstructor();
    }

    private void userConstructor(){
        videoConferenceRoomDialog = new VideoConferenceRoomDialog(this);
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("P2P Video Conferencing");

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("P2P");

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Video Conferencing");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p2pvideoconferencing/images/international-networking-thumb16919374.jpg"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
        jButton1.setText("Start Video Conferencing...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.videoConferenceRoomDialog.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    public VideoConferenceRoomDialog videoConferenceRoomDialog;
}
