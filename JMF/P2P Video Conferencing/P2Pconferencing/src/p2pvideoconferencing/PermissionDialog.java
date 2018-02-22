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
 * Title:        PermissionDialog
 * Description:  Peers Permission
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */
import java.awt.Color;

public class PermissionDialog extends javax.swing.JDialog {

    public PermissionDialog(VideoConferenceRoomDialog parent) {
        super(parent, true);
        initComponents();
        
        this.getContentPane().setBackground(Color.white);
        setSize(238, 168);
        setLocationRelativeTo(null);
    }

    @Override
    public void show(){
        getRestrictedPeers();
        super.show();
    }
    
    private void getRestrictedPeers(){
        try{
            peerComboBox.removeAllItems();
            java.util.Vector<PeerBean> v = DatabaseManager.getRestrictedPeers();
            
            for(int i = 0; i < v.size(); i++){
                peerComboBox.addItem(v.elementAt(i));
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "getRestrictedPeers() : " + e);
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        permissionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        peerComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grant Permission");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Grant Permission");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 218, 25);

        permissionButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        permissionButton.setText("Grant Permisssion");
        permissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(permissionButton);
        permissionButton.setBounds(10, 100, 141, 32);

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelButton.setText("Back");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(157, 100, 71, 32);
        getContentPane().add(peerComboBox);
        peerComboBox.setBounds(10, 70, 217, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Rrestricted Peers");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(15, 50, 110, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void permissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionButtonActionPerformed
        PeerBean bean = (PeerBean) this.peerComboBox.getSelectedItem();
        if(bean == null) return;
        
        try{
            int row = DatabaseManager.deleteRestrictionPeer(bean.getPeerId());
            if(row > 0){
                javax.swing.JOptionPane.showMessageDialog(null, bean.getHostName() + " Grant Permintted...");
                getRestrictedPeers();
            }
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_permissionButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox peerComboBox;
    private javax.swing.JButton permissionButton;
    // End of variables declaration//GEN-END:variables
}
