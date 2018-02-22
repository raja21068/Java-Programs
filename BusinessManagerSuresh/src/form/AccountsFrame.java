package form;


import bean.Account;
import database.DataManager;
import database.DatabaseManager;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utility.DateFormatter;
import utility.TypeDecoder;
import utility.TypeEncoder;

public class AccountsFrame extends javax.swing.JFrame {

    static int TYPE_COLUMN = 0;
    static int PAID_AMOUNT_COLUMN = 1;
    static int DATE_COLUMN = 2;
    static int BILL_NO_COLUMN = 3;
    static int TOTAL_COLUMN = 4;
    
    DefaultTableModel tableModel;
    
    /** Creates new form AccountsFrame */
    public AccountsFrame() {
        initComponents();
        tableModel = (DefaultTableModel)historyTable.getModel();
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
        accountNameLabel1 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        mobileTextField = new javax.swing.JTextField();
        accountTypeLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        paidHistoryTextField = new javax.swing.JTextField();
        totalHistoryTextField = new javax.swing.JTextField();
        accountSummuryTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        historyToDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        historyFromDateChooser = new com.toedter.calendar.JDateChooser();
        printAllAccountHistoryButton = new javax.swing.JButton();
        printHistoryButton = new javax.swing.JButton();
        showTransactionButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accounts");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(950, 500));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 51));
        mainLabel.setText("Accounts Details");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(180, 10, 170, 50);

        accountIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountIdLabel.setText("ACCOUNT ID");
        getContentPane().add(accountIdLabel);
        accountIdLabel.setBounds(20, 50, 80, 30);

        accountIdTextField.setEditable(false);
        accountIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(accountIdTextField);
        accountIdTextField.setBounds(130, 50, 180, 30);

        accountNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountNameLabel.setText("ACCOUNT NAME");
        getContentPane().add(accountNameLabel);
        accountNameLabel.setBounds(20, 110, 100, 30);

        accountNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(accountNameTextField);
        accountNameTextField.setBounds(130, 110, 180, 30);

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addressLabel.setText("ADDRESS");
        getContentPane().add(addressLabel);
        addressLabel.setBounds(20, 220, 100, 30);

        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        accountTypeLabel.setText("History");
        accountTypeLabel.setPreferredSize(new java.awt.Dimension(14, 14));
        getContentPane().add(accountTypeLabel);
        accountTypeLabel.setBounds(560, 20, 90, 20);

        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Purchase", "Sale", "Expanse" }));
        accountTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                accountTypeComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(accountTypeComboBox);
        accountTypeComboBox.setBounds(430, 40, 110, 30);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(460, 400, 90, 30);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 400, 90, 30);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(120, 400, 105, 30);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(230, 400, 100, 30);

        accountNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountNameLabel1.setText("MOBILE");
        getContentPane().add(accountNameLabel1);
        accountNameLabel1.setBounds(20, 160, 100, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(340, 400, 110, 30);
        getContentPane().add(mobileTextField);
        mobileTextField.setBounds(130, 160, 180, 30);

        accountTypeLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountTypeLabel1.setText("ACCOUNT TYPE");
        getContentPane().add(accountTypeLabel1);
        accountTypeLabel1.setBounds(340, 40, 90, 30);

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Paid Amount", "Date", "Bill No", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(historyTable);
        historyTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        historyTable.getColumnModel().getColumn(1).setMinWidth(40);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(550, 100, 380, 280);
        getContentPane().add(paidHistoryTextField);
        paidHistoryTextField.setBounds(620, 385, 110, 20);
        getContentPane().add(totalHistoryTextField);
        totalHistoryTextField.setBounds(800, 385, 110, 20);

        accountSummuryTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(accountSummuryTextField);
        accountSummuryTextField.setBounds(740, 420, 170, 30);

        jLabel1.setText("Paid");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(570, 390, 40, 14);

        jLabel2.setText("Total");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(760, 390, 50, 14);
        getContentPane().add(historyToDateChooser);
        historyToDateChooser.setBounds(790, 20, 120, 20);

        jLabel3.setText("TO ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(760, 20, 30, 20);
        getContentPane().add(historyFromDateChooser);
        historyFromDateChooser.setBounds(620, 20, 130, 20);

        printAllAccountHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/print-icon.png"))); // NOI18N
        printAllAccountHistoryButton.setText("<html>All Account<center>Sheet</center></html>");
        printAllAccountHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAllAccountHistoryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printAllAccountHistoryButton);
        printAllAccountHistoryButton.setBounds(560, 415, 170, 40);

        printHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/print-icon.png"))); // NOI18N
        printHistoryButton.setText("<html>History<html>");
        printHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printHistoryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printHistoryButton);
        printHistoryButton.setBounds(570, 50, 160, 40);

        showTransactionButton.setText("<html><center>Show</center>Transaction</html>");
        showTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTransactionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(showTransactionButton);
        showTransactionButton.setBounds(740, 50, 180, 40);

        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Account Name", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(accountTable);
        accountTable.getColumnModel().getColumn(0).setMinWidth(300);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 500, 520, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void setVisible(boolean b){
    super.setVisible(b);
    if(b)refreshAccounts();
    clear();
}
private void refreshAccounts(){
    try{
        int type= TypeEncoder.encode((String)accountTypeComboBox.getSelectedItem());
        List list = DatabaseManager.getData(Account.class.getName(),"ACCOUNT_TYPE="+type, "ACCOUNT_NAME ASC");
        accountsList.setListData(list.toArray());
    }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't refresh account.."+ex);
        }
}
private void clear(){
    this.accountIdTextField.setText("");
    this.accountNameTextField.setText("");
    this.addressTextField.setText("");
    this.remarksTextArea.setText("");
    this.mobileTextField.setText("");
}

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String accountName = accountNameTextField.getText().trim().toUpperCase();
        String add = addressTextField.getText().trim().toUpperCase();
        String mobile = mobileTextField.getText().trim();
        String remarks = remarksTextArea.getText().trim().toUpperCase();
        int type= TypeEncoder.encode((String)accountTypeComboBox.getSelectedItem());
        System.out.println(accountName+","+ add+","+ type+","+ mobile+","+ remarks);
        Account ac = new Account(accountName, add, type, mobile, remarks, false);
        DatabaseManager.addData(ac);
        setVisible(true);
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(accountsList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a account from list..");
            return;}
        if(accountNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter atleast Account Name..");
            return;
        }
        String accountName = accountNameTextField.getText().trim().toUpperCase();
        String address = addressTextField.getText().trim().toUpperCase();
        String remarks = remarksTextArea.getText().trim().toUpperCase();
        int type = TypeEncoder.encode((String)this.accountTypeComboBox.getSelectedItem());
        String mobile = mobileTextField.getText().trim();
        
        Account ac = (Account)accountsList.getSelectedValue();
        ac.setAccountName(accountName);
        ac.setAddress(address);
        ac.setAccountType(type);
        ac.setRemarks(remarks);
        ac.setMobileNo(mobile);
        try{   
            DatabaseManager.updateData(ac);
            refreshAccounts();
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
            int i = DatabaseManager.deleteData(Account.class, id);
            clear();
            refreshAccounts();
            JOptionPane.showMessageDialog(null, i+" > Account suucessfully Deleted...");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Could not delete..! "+ex);
        }
        
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

    private void accountsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_accountsListValueChanged
        Account bean  = (Account)accountsList.getSelectedValue();
        if(bean==null)return;
        this.accountIdTextField.setText(""+bean.getAccountId());
        this.accountNameTextField.setText(""+bean.getAccountName());
        this.addressTextField.setText(""+bean.getAddress());
        this.remarksTextArea.setText(""+bean.getRemarks());
        this.mobileTextField.setText(""+bean.getMobileNo());
        this.accountTypeComboBox.setSelectedItem(TypeDecoder.decode(bean.getAccountType()));
        try {
            int rows = tableModel.getRowCount();
            for(int i=0;i<rows;i++){
                tableModel.removeRow(0);
            }
            
            DataManager.setAccountHistory(bean.getAccountId(),tableModel,TYPE_COLUMN,PAID_AMOUNT_COLUMN,DATE_COLUMN, BILL_NO_COLUMN, TOTAL_COLUMN);
            calculateAccount();
        } catch (Exception ex) {
            Logger.getLogger(AccountsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_accountsListValueChanged

    private void accountTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_accountTypeComboBoxItemStateChanged
        refreshAccounts();
    }//GEN-LAST:event_accountTypeComboBoxItemStateChanged

    private void printAllAccountHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAllAccountHistoryButtonActionPerformed
        clearInvisibleTable();
        int type= TypeEncoder.encode((String)accountTypeComboBox.getSelectedItem());
        List list = DatabaseManager.getData(Account.class.getName(),"ACCOUNT_TYPE="+type, "ACCOUNT_NAME ASC");
        for(int i=0;i<list.size();i++){
            Account ac = (Account)list.get(i);
            double paid = 0;
            double totalAmount = 0;
            List lis = DatabaseManager.getData("SELECT SUM(sp.paidAmount) FROM bean.SalePurchase as sp, sp.account ac WHERE ac.accountId="+ac.getAccountId());
            if(lis.get(0) != null) paid = (Double)(lis.get(0));
            
            lis = DatabaseManager.getData("SELECT SUM(sp.totalAmount) FROM bean.SalePurchase as sp, sp.account ac WHERE ac.accountId="+ac.getAccountId());
            if(lis.get(0)!=null)totalAmount = (Double)(lis.get(0));
            DefaultTableModel model = (DefaultTableModel)accountTable.getModel();
            int row = model.getRowCount();
            if(totalAmount > paid){
                model.insertRow(row, new Object[]{ac.getAccountName(), (totalAmount-paid)+" / Credit" });
            }else if(totalAmount < paid){
                model.insertRow(row, new Object[]{ ac.getAccountName(), (paid-totalAmount)+" / Cash" });
            }else{
                model.insertRow(row, new Object[]{ac.getAccountName(), (totalAmount - paid)+""});
            }
        }
        try {
            accountTable.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(accountTypeComboBox.getSelectedItem()+" Account Sheet"), new MessageFormat(""));
        } catch (PrinterException ex) {
            Logger.getLogger(AccountsFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
        clearInvisibleTable();
    }//GEN-LAST:event_printAllAccountHistoryButtonActionPerformed

    public void clearInvisibleTable(){
        DefaultTableModel model = (DefaultTableModel)accountTable.getModel();
        int row = model.getRowCount();
        for(int i=0;i<row;i++){
            model.removeRow(0);
        }
    }
    
    private void showTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTransactionButtonActionPerformed
        Account bean  = (Account)accountsList.getSelectedValue();
        Date from = historyFromDateChooser.getDate();
        Date to = historyToDateChooser.getDate();
        if(bean==null){
            JOptionPane.showMessageDialog(this, "Please Select Account..");
            return;
        }
        if(from == null || to ==null){
            JOptionPane.showMessageDialog(this, "Please Select Day TO Date..");
            return;
        }
        
        int row = tableModel.getRowCount();
        for(int i=0;i<row;i++){
            tableModel.removeRow(0);
        }
        
        String toDate = DateFormatter.dateToStringYMD(to);
        String fromDate=DateFormatter.dateToStringYMD(from);
        try{
            DataManager.setAccountHistory(bean.getAccountId(),fromDate,toDate,tableModel,TYPE_COLUMN,PAID_AMOUNT_COLUMN,DATE_COLUMN, BILL_NO_COLUMN, TOTAL_COLUMN);
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, "Error Loading History.. \n"+ex);
        }
    }//GEN-LAST:event_showTransactionButtonActionPerformed

    private void printHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printHistoryButtonActionPerformed
        Account ac = (Account)accountsList.getSelectedValue();
        if(ac==null){
            JOptionPane.showMessageDialog(this, "Please Select account then press Print again..");
            return;
        }
        try {
            historyTable.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(""+ac.getAccountName()+"            "+accountSummuryTextField.getText()), new MessageFormat(""));
        } catch (PrinterException ex) {
            Logger.getLogger(AccountsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printHistoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountIdLabel;
    private javax.swing.JTextField accountIdTextField;
    private javax.swing.JLabel accountNameLabel;
    private javax.swing.JLabel accountNameLabel1;
    private javax.swing.JTextField accountNameTextField;
    private javax.swing.JTextField accountSummuryTextField;
    private javax.swing.JTable accountTable;
    private javax.swing.JComboBox accountTypeComboBox;
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JLabel accountTypeLabel1;
    private javax.swing.JList accountsList;
    private javax.swing.JScrollPane accountsListScrollPane;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private com.toedter.calendar.JDateChooser historyFromDateChooser;
    private javax.swing.JTable historyTable;
    private com.toedter.calendar.JDateChooser historyToDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JTextField paidHistoryTextField;
    private javax.swing.JButton printAllAccountHistoryButton;
    private javax.swing.JButton printHistoryButton;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton showTransactionButton;
    private javax.swing.JTextField totalHistoryTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void calculateAccount() {
        int row = tableModel.getRowCount();
        double total = 0;
        double paid = 0;
        for(int i=0;i<row;i++){
            paid += (Double)tableModel.getValueAt( i,PAID_AMOUNT_COLUMN);
            total += (Double)tableModel.getValueAt(i, TOTAL_COLUMN);
        }
        totalHistoryTextField.setText(""+total);
        paidHistoryTextField.setText(""+paid);
        
        if(paid > total){
            accountSummuryTextField.setText((paid-total)+"  / CASH");
        }else if(paid < total){
            accountSummuryTextField.setText((total-paid)+" / CREDIT");
        }else{
            accountSummuryTextField.setText("0");
        }
    }
}
