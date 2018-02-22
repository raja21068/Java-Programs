package forms;

/**
 *
 * @author Raja Kumar
 */
public class MainFrame extends javax.swing.JFrame {

    ScratchCardForm scratchCardForm;
    CertificateForm certificateForm;
    SmsSender smsSender ;
    TransactionForm transactionForm;
    public MainFrame() {
        initComponents();
        init();
       
    }
    
    public void init(){
        scratchCardForm = new ScratchCardForm();
        certificateForm = new CertificateForm();
        smsSender = new SmsSender();
        transactionForm = new TransactionForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        scratchCardButton = new javax.swing.JButton();
        certificateButton = new javax.swing.JButton();
        buttonConnect = new javax.swing.JButton();
        buttonTransaction = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        scratchCardMenuItem = new javax.swing.JMenuItem();
        certificateMenuItem = new javax.swing.JMenuItem();
        menuItemPortConnector = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Examination System");

        jToolBar1.setRollover(true);

        scratchCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Credit-Card-icon.png"))); // NOI18N
        scratchCardButton.setToolTipText("Credit Card");
        scratchCardButton.setFocusable(false);
        scratchCardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scratchCardButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        scratchCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scratchCardButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(scratchCardButton);

        certificateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pages-icon.png"))); // NOI18N
        certificateButton.setToolTipText("Certificates");
        certificateButton.setFocusable(false);
        certificateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        certificateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        certificateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificateButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(certificateButton);

        buttonConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sim-icon.png"))); // NOI18N
        buttonConnect.setToolTipText("GSM Connector");
        buttonConnect.setFocusable(false);
        buttonConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonConnect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonConnect);

        buttonTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Data-Ticket-icon.png"))); // NOI18N
        buttonTransaction.setToolTipText("Transaction");
        buttonTransaction.setFocusable(false);
        buttonTransaction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTransaction.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransactionActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonTransaction);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images.jpg"))); // NOI18N

        jMenu1.setText("File");

        scratchCardMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        scratchCardMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        scratchCardMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Credit-Card-icon -small.png"))); // NOI18N
        scratchCardMenuItem.setText("Scratch Card");
        scratchCardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scratchCardMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(scratchCardMenuItem);

        certificateMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        certificateMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        certificateMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pages-icon-small.png"))); // NOI18N
        certificateMenuItem.setText("Certificate");
        certificateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificateMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(certificateMenuItem);

        menuItemPortConnector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuItemPortConnector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sim-icon-small.png"))); // NOI18N
        menuItemPortConnector.setText("Port Connector");
        menuItemPortConnector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPortConnectorActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPortConnector);

        menuItemExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 211, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scratchCardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scratchCardMenuItemActionPerformed
        scratchCardForm.setVisible(true);
    }//GEN-LAST:event_scratchCardMenuItemActionPerformed

    private void certificateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificateMenuItemActionPerformed
        certificateForm.setVisible(true);
    }//GEN-LAST:event_certificateMenuItemActionPerformed

    private void scratchCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scratchCardButtonActionPerformed
        scratchCardForm.setVisible(true); 
    }//GEN-LAST:event_scratchCardButtonActionPerformed

    private void certificateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificateButtonActionPerformed
        certificateForm.setVisible(true);
    }//GEN-LAST:event_certificateButtonActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectActionPerformed
        smsSender.setVisible(true);
    }//GEN-LAST:event_buttonConnectActionPerformed

    private void buttonTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransactionActionPerformed
        transactionForm.setVisible(true);
    }//GEN-LAST:event_buttonTransactionActionPerformed

    private void menuItemPortConnectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPortConnectorActionPerformed
        smsSender.setVisible(true);
    }//GEN-LAST:event_menuItemPortConnectorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonTransaction;
    private javax.swing.JButton certificateButton;
    private javax.swing.JMenuItem certificateMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemPortConnector;
    private javax.swing.JButton scratchCardButton;
    private javax.swing.JMenuItem scratchCardMenuItem;
    // End of variables declaration//GEN-END:variables
}
