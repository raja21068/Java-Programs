
import javax.swing.JOptionPane;

public class AccountsFrame extends javax.swing.JFrame {

    /** Creates new form AccountsFrame */
    public AccountsFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/account.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        accountIdLabel = new javax.swing.JLabel();
        accountIdTextField = new javax.swing.JTextField();
        accountNameLabel = new javax.swing.JLabel();
        accountNameTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        accountsListScrollPane = new javax.swing.JScrollPane();
        accountsList = new javax.swing.JList();
        accountTypeLabel = new javax.swing.JLabel();
        accountTypeComboBox = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accounts");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(153, 0, 51));
        mainLabel.setText("Accounts Details");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(180, 10, 170, 50);

        accountIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        accountIdLabel.setText("ACCOUNT ID");
        getContentPane().add(accountIdLabel);
        accountIdLabel.setBounds(20, 100, 80, 30);

        accountIdTextField.setEditable(false);
        accountIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(accountIdTextField);
        accountIdTextField.setBounds(130, 100, 180, 30);

        accountNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        accountNameLabel.setText("ACCOUNT NAME");
        getContentPane().add(accountNameLabel);
        accountNameLabel.setBounds(20, 160, 100, 30);

        accountNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(accountNameTextField);
        accountNameTextField.setBounds(130, 160, 180, 30);

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        addressLabel.setText("ADDRESS");
        getContentPane().add(addressLabel);
        addressLabel.setBounds(20, 220, 100, 30);

        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(addressTextField);
        addressTextField.setBounds(130, 220, 180, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 310, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(80, 310, 250, 70);

        accountsList.setToolTipText("Account List");
        accountsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                accountsListValueChanged(evt);
            }
        });
        accountsListScrollPane.setViewportView(accountsList);

        getContentPane().add(accountsListScrollPane);
        accountsListScrollPane.setBounds(350, 81, 190, 300);

        accountTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountTypeLabel.setText("ACCOUNT TYPE");
        getContentPane().add(accountTypeLabel);
        accountTypeLabel.setBounds(20, 270, 100, 30);

        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Purchase", "Sale", "Expanse" }));
        getContentPane().add(accountTypeComboBox);
        accountTypeComboBox.setBounds(130, 270, 180, 30);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(460, 400, 90, 30);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 400, 90, 30);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(120, 400, 105, 30);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(230, 400, 100, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(340, 400, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(4, 4, 590, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void setVisible(boolean b){
    super.setVisible(b);
    refreshData();
    clear();
}
private void refreshData(){
    try{
         accountsList.setListData(DatabaseManager.getAccounts().toArray());
    }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
}
private void clear(){
    this.accountIdTextField.setText("");
    this.accountNameTextField.setText("");
    this.addressTextField.setText("");
    this.remarksTextArea.setText("");
}

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(accountNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Invalid Name...");
            return;}
        String accountName = accountNameTextField.getText();
        String address = addressTextField.getText();
        String remarks = remarksTextArea.getText();
        int type = TypeEncoder.typeEncode((String)this.accountTypeComboBox.getSelectedItem());
        try{
            DatabaseManager.addAccount(accountName, address, type, remarks);
            refreshData();
            clear();
            JOptionPane.showMessageDialog(null, "\""+accountName+"\" is successfully added..");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(accountsList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a account from list..");
            return;}
        if(accountNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter atleast Account Name..");
            return;
        }
        int id = Integer.parseInt(accountIdTextField.getText());
        String accountName = accountNameTextField.getText();
        String address = addressTextField.getText();
        String remarks = remarksTextArea.getText();
        int type = TypeEncoder.typeEncode((String)this.accountTypeComboBox.getSelectedItem());
        try{
            DatabaseManager.updateAccount(id, accountName, address, type, remarks);
            refreshData();
            clear();
            JOptionPane.showMessageDialog(null, "\""+accountName+"\" is successfully updated..");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(accountsList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a account from list..");
            return;}
        int id = Integer.parseInt(accountIdTextField.getText());
        try{
            DatabaseManager.deleteAccount(id);
            clear();
            refreshData();
            JOptionPane.showMessageDialog(null, "Account suucessfully Deleted...");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

    private void accountsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_accountsListValueChanged
        AccountBean bean  = (AccountBean)accountsList.getSelectedValue();
        if(bean==null)return;
        accountIdTextField.setText(""+bean.getAccountId());
        accountNameTextField.setText(bean.getAccountName());
        addressTextField.setText(bean.getAddress());
        accountTypeComboBox.setSelectedItem(TypeDecoder.typeDecode(bean.getAccountType()));
        remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_accountsListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountIdLabel;
    private javax.swing.JTextField accountIdTextField;
    private javax.swing.JLabel accountNameLabel;
    private javax.swing.JTextField accountNameTextField;
    private javax.swing.JComboBox accountTypeComboBox;
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JList accountsList;
    private javax.swing.JScrollPane accountsListScrollPane;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
