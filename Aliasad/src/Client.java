
import java.awt.FileDialog;


/**
 *
 * @author Ali Asad
 */
    class Client extends javax.swing.JFrame {

    public Client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileNameLabel3 = new javax.swing.JLabel();
        enterIPLabel = new javax.swing.JLabel();
        ipText = new javax.swing.JTextField();
        browsePanel = new javax.swing.JPanel();
        browseText = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        fileSizeLabel = new javax.swing.JLabel();
        transferButton = new javax.swing.JButton();
        packetSizeLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        totalPacketsLabel = new javax.swing.JLabel();
        lastPacketLabel = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();

        fileNameLabel3.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        fileNameLabel3.setForeground(new java.awt.Color(255, 51, 51));
        fileNameLabel3.setText("File Name :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setBounds(new java.awt.Rectangle(300, 100, 0, 0));
        setName("clientFrame"); // NOI18N
        setResizable(false);

        enterIPLabel.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        enterIPLabel.setForeground(new java.awt.Color(255, 51, 51));
        enterIPLabel.setText("ENTER I.P :");

        ipText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTextActionPerformed(evt);
            }
        });

        browsePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Browse", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout browsePanelLayout = new javax.swing.GroupLayout(browsePanel);
        browsePanel.setLayout(browsePanelLayout);
        browsePanelLayout.setHorizontalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browseText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        browsePanelLayout.setVerticalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(browsePanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                    .addComponent(browseText))
                .addContainerGap())
        );

        fileSizeLabel.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        fileSizeLabel.setForeground(new java.awt.Color(255, 51, 51));
        fileSizeLabel.setText("File Size :");

        transferButton.setText("Transfer");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        packetSizeLabel.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        packetSizeLabel.setForeground(new java.awt.Color(255, 51, 51));
        packetSizeLabel.setText("Packet Size :");

        fileNameLabel.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        fileNameLabel.setForeground(new java.awt.Color(255, 51, 51));
        fileNameLabel.setText("File Name :");

        totalPacketsLabel.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        totalPacketsLabel.setForeground(new java.awt.Color(255, 51, 51));
        totalPacketsLabel.setText("Total Packets :");

        lastPacketLabel.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        lastPacketLabel.setForeground(new java.awt.Color(255, 51, 51));
        lastPacketLabel.setText("Last Packet");

        bar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterIPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ipText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(packetSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPacketsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastPacketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ipText)
                        .addGap(1, 1, 1))
                    .addComponent(enterIPLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(fileSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(packetSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPacketsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastPacketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTextActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        new SendingThread(this).start();
    }//GEN-LAST:event_transferButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        java.awt.FileDialog d = new FileDialog(new javax.swing.JDialog(),"Browse..",FileDialog.LOAD);
        d.setVisible(true);
        
        if(d.getDirectory() == null)
            return;
        java.io.File f = new java.io.File(d.getDirectory() + d.getFile());
        if(f.exists())
        {
            String fileName = f.getName();
            String fileSize = f.length() + " Bytes";
            String packetSize = "10000";
            String totalPackets = "" + f.length()/10000;
            String lastPacket = "" + f.length()%10000;
            
            browseText.setText(f.getAbsolutePath());
            fileNameLabel.setText("File Name : "+fileName);
            fileSizeLabel.setText("File Size : "+fileSize);
            packetSizeLabel.setText("Packet Size : "+packetSize);
            totalPacketsLabel.setText("Total Packets : "+totalPackets);
            lastPacketLabel.setText("Last Packet : "+lastPacket);
            
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JProgressBar bar;
    private javax.swing.JButton browseButton;
    private javax.swing.JPanel browsePanel;
    javax.swing.JTextField browseText;
    private javax.swing.JLabel enterIPLabel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel fileNameLabel3;
    private javax.swing.JLabel fileSizeLabel;
    javax.swing.JTextField ipText;
    private javax.swing.JLabel lastPacketLabel;
    private javax.swing.JLabel packetSizeLabel;
    private javax.swing.JLabel totalPacketsLabel;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables
}
