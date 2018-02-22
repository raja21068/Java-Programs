/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CashBookFrame.java
 *
 * Created on Jan 5, 2013, 3:21:03 PM
 */
/**
 *
 * @author DELL
 */
public class CashBookFrame extends javax.swing.JFrame {

    public CashBookFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/dollar-icon (1).png")));
        }catch(Exception ex){ex.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        yearLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox();
        accountsLabel = new javax.swing.JLabel();
        accountsComboBox = new javax.swing.JComboBox();
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionsList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        amountLabel1 = new javax.swing.JLabel();
        accountTypeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cash Book");
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("CASH BOOK");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(240, 10, 140, 40);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(60, 70, 110, 30);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(10, 70, 50, 30);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(190, 70, 40, 30);

        dateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dateComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(dateComboBox);
        dateComboBox.setBounds(230, 70, 120, 30);

        accountsLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        accountsLabel.setText("Accounts");
        getContentPane().add(accountsLabel);
        accountsLabel.setBounds(10, 144, 70, 20);

        accountsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(accountsComboBox);
        accountsComboBox.setBounds(80, 140, 270, 30);

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel.setText("Enter Amount");
        getContentPane().add(amountLabel);
        amountLabel.setBounds(10, 210, 100, 30);

        amountTextField.setText("0");
        getContentPane().add(amountTextField);
        amountTextField.setBounds(110, 210, 110, 30);

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        typeLabel.setText("TYPE");
        getContentPane().add(typeLabel);
        typeLabel.setBounds(230, 210, 50, 30);

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Debit", "Credit" }));
        getContentPane().add(typeComboBox);
        typeComboBox.setBounds(270, 210, 80, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 290, 70, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(70, 290, 280, 90);

        transactionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                transactionsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(transactionsList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 70, 180, 320);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(40, 430, 110, 33);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(160, 430, 110, 33);

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(280, 430, 110, 33);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(400, 430, 110, 33);

        amountLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel1.setText("Account Type");
        getContentPane().add(amountLabel1);
        amountLabel1.setBounds(10, 175, 100, 30);

        accountTypeTextField.setEditable(false);
        getContentPane().add(accountTypeTextField);
        accountTypeTextField.setBounds(110, 175, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        YearBean bean = (YearBean)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        try{
            this.dateComboBox.removeAllItems();
            java.util.ArrayList years = DatabaseManager.getDays(bean.getYearId());
            for(int i=0;i<years.size();i++){
                this.dateComboBox.addItem(years.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_yearComboBoxItemStateChanged

    private void transactionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_transactionsListValueChanged
        SalePurchaseBean sBean = (SalePurchaseBean)this.transactionsList.getSelectedValue();
        if(sBean == null) return;
        
        this.amountTextField.setText(""+sBean.getTotalAmount());
        this.typeComboBox.setSelectedItem(TypeDecoder.typeDecode(sBean.getType()));
        this.remarksTextArea.setText(sBean.getRemarks());
        
        for(int i=0;i<this.accountsComboBox.getItemCount();i++){
            AccountBean ac =(AccountBean) this.accountsComboBox.getItemAt(i);
            if(sBean.getAccountId() == ac.getAccountId()){
                this.accountsComboBox.setSelectedItem(ac);
                break;
            }
        }
}//GEN-LAST:event_transactionsListValueChanged

    private void dateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateComboBoxItemStateChanged
        DayBean day = (DayBean)this.dateComboBox.getSelectedItem();
        if(day==null)return;
        try{
            java.util.ArrayList list = DatabaseManager.getSalePurchases(day.getdayId());
            if(list!=null)this.transactionsList.setListData(list.toArray());
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_dateComboBoxItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        YearBean yearbean = (YearBean)this.yearComboBox.getSelectedItem();
        DayBean daybean = (DayBean)this.dateComboBox.getSelectedItem();
        AccountBean accountbean = (AccountBean)this.accountsComboBox.getSelectedItem();
        if(yearbean==null||daybean==null||accountbean==null){return;}
        if(this.amountTextField.getText().isEmpty()||this.amountTextField.getText().equals("0")){
            javax.swing.JOptionPane.showMessageDialog(null,"Amount is empty, enter amount");
            return;
        }
        try{
            int amount = Integer.parseInt(amountTextField.getText());
        
            if(daybean.isClosed()){
                javax.swing.JOptionPane.showMessageDialog(null,"this date is closed, add new other date..");
                return;
            }
            if(this.accountTypeTextField.getText().equals("Expanse") &&((String)this.typeComboBox.getSelectedItem())!= "Credit"){
                javax.swing.JOptionPane.showMessageDialog(null,"Invalid Type..");
                return;
            }
            String type= typeComboBox.getSelectedItem().toString();
            DatabaseManager.addCashTransaction(daybean.getdayId(), accountbean.getAccountId(), 0, amount, TypeEncoder.typeEncode(typeComboBox.getSelectedItem().toString()));
            if(accountTypeTextField.getText().equals("Sale")&&type.equals("Debit")||accountTypeTextField.getText().equals("Purchase")&&type.equals("Credit")){
                DatabaseManager.updateCurrentAmount(yearbean.getYearId(), yearbean.getCurrentAmount()+amount);
            }
            else 
                {
                DatabaseManager.updateCurrentAmount(yearbean.getYearId(), yearbean.getCurrentAmount()-amount);
            }

            setVisible(true);
        }catch(NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(null,"Invalid amount..");    
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

private void accountsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsComboBoxActionPerformed
    AccountBean bean = (AccountBean) this.accountsComboBox.getSelectedItem();
    if(bean == null) return;
    
    this.accountTypeTextField.setText(TypeDecoder.typeDecode(bean.getAccountType()));
}//GEN-LAST:event_accountsComboBoxActionPerformed

    private void clear(){
        this.amountTextField.setText("0");
        this.remarksTextArea.setText("");
        this.transactionsList.setListData(new java.util.Vector());
    }
    public void setVisible(boolean b){
        refreshYearComboBox();
        getAccounts();
        
        super.setVisible(b);
    }
    public void refreshYearComboBox(){
        yearComboBox.removeAllItems();
        try{
            java.util.ArrayList list = DatabaseManager.getYears();
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    } 
    
    private void getAccounts(){
        this.accountsComboBox.removeAllItems();
        try{
            java.util.ArrayList list = DatabaseManager.getAccounts();
            for(int i=0; i<list.size();i++){
                this.accountsComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountTypeTextField;
    private javax.swing.JComboBox accountsComboBox;
    private javax.swing.JLabel accountsLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel amountLabel1;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList transactionsList;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
