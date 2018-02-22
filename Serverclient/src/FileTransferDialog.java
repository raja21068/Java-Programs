

/**
 *
 * @author Jay Kumar
 */
public class FileTransferDialog extends javax.swing.JDialog {

    /** Creates new form FileTransferDialog */
    public FileTransferDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
 
    private void initComponents() {

        fileNameLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        totalPacketLabel = new javax.swing.JLabel();
        lastPacketLabel = new javax.swing.JLabel();
        pcNameLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        hideBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fileNameLabel.setText("File Name :");

        fileSizeLabel.setText("File Size :");

        packetSizeLabel.setText("Packet Size : ");

        totalPacketLabel.setText("Total Packets :");

        lastPacketLabel.setText("Last Packet Size :");

        pcNameLabel.setText("PC Name :");

        ipLabel.setText("IP Address :");

        hideBtn.setText("Hide");

        cancelBtn.setText("Cancel Downloading");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .addComponent(lastPacketLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fileNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(fileSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(packetSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPacketLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pcNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(hideBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(packetSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPacketLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastPacketLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pcNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hideBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FileTransferDialog dialog = new FileTransferDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
     javax.swing.JButton cancelBtn;
    javax.swing.JLabel fileNameLabel;
    javax.swing.JLabel fileSizeLabel;
    javax.swing.JButton hideBtn;
    javax.swing.JLabel ipLabel;
    javax.swing.JLabel lastPacketLabel;
    javax.swing.JLabel packetSizeLabel;
    javax.swing.JLabel pcNameLabel;
    javax.swing.JProgressBar progressBar;
    javax.swing.JLabel totalPacketLabel;
    // End of variables declaration
}
