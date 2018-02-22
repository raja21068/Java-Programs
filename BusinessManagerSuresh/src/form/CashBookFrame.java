package form;

import bean.Account;
import bean.Cheque;
import bean.Day;
import bean.SalePurchase;
import bean.Transaction;
import bean.Year;
import constant.Constant;
import database.DatabaseManager;
import java.util.List;
import javax.swing.JOptionPane;
import utility.TypeEncoder;

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
        dateComboBox = new javax.swing.JComboBox();
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        accountTypeComboBox = new javax.swing.JComboBox();
        accountTypeLabel1 = new javax.swing.JLabel();
        accountsListScrollPane = new javax.swing.JScrollPane();
        accountsList = new javax.swing.JList();
        dateLabel1 = new javax.swing.JLabel();
        chequeDateChooser = new com.toedter.calendar.JDateChooser();
        chequeNumberTextField = new javax.swing.JTextField();
        CHEQUECheckBox = new javax.swing.JCheckBox();
        billNoTextField = new javax.swing.JTextField();
        billNoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionList = new javax.swing.JList();
        accountTypeLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cash Book");
        setMinimumSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(10, 70, 50, 30);

        dateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dateComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(dateComboBox);
        dateComboBox.setBounds(230, 70, 120, 30);

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel.setText("Enter Amount");
        getContentPane().add(amountLabel);
        amountLabel.setBounds(10, 180, 100, 30);

        amountTextField.setText("0");
        getContentPane().add(amountTextField);
        amountTextField.setBounds(110, 180, 110, 30);

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        typeLabel.setText("TYPE");
        getContentPane().add(typeLabel);
        typeLabel.setBounds(230, 180, 50, 30);

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Credit" }));
        getContentPane().add(typeComboBox);
        typeComboBox.setBounds(270, 180, 80, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 290, 70, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(70, 290, 280, 90);

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

        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Purchase", "Sale", "Expanse" }));
        accountTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                accountTypeComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(accountTypeComboBox);
        accountTypeComboBox.setBounds(480, 50, 100, 30);

        accountTypeLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountTypeLabel1.setText("TRANSACTION");
        getContentPane().add(accountTypeLabel1);
        accountTypeLabel1.setBounds(650, 50, 90, 30);

        accountsList.setToolTipText("Account List");
        accountsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                accountsListValueChanged(evt);
            }
        });
        accountsListScrollPane.setViewportView(accountsList);

        getContentPane().add(accountsListScrollPane);
        accountsListScrollPane.setBounds(390, 90, 190, 320);

        dateLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel1.setText("Date");
        getContentPane().add(dateLabel1);
        dateLabel1.setBounds(190, 70, 40, 30);

        chequeDateChooser.setEnabled(false);
        getContentPane().add(chequeDateChooser);
        chequeDateChooser.setBounds(100, 240, 120, 30);

        chequeNumberTextField.setEditable(false);
        getContentPane().add(chequeNumberTextField);
        chequeNumberTextField.setBounds(230, 240, 130, 30);

        CHEQUECheckBox.setText("Cheque");
        CHEQUECheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEQUECheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(CHEQUECheckBox);
        CHEQUECheckBox.setBounds(10, 240, 80, 23);

        billNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(billNoTextField);
        billNoTextField.setBounds(60, 120, 110, 30);

        billNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        billNoLabel.setText("Bill No");
        getContentPane().add(billNoLabel);
        billNoLabel.setBounds(10, 120, 60, 30);

        jScrollPane1.setViewportView(transactionList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(640, 90, 200, 320);

        accountTypeLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accountTypeLabel2.setText("ACCOUNT TYPE");
        getContentPane().add(accountTypeLabel2);
        accountTypeLabel2.setBounds(390, 50, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        Year bean = (Year)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        dateComboBox.removeAllItems();
        try{
            List list = DatabaseManager.getData(Day.class.getName(),"YEAR_ID="+bean.getYearId(), " ORDER BY DAY DESC");
            for(Object ob: list){
                dateComboBox.addItem(ob);
            }
        }catch(Exception ex){ex.printStackTrace(System.err);}
}//GEN-LAST:event_yearComboBoxItemStateChanged

    private void dateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateComboBoxItemStateChanged
        Day day = (Day)this.dateComboBox.getSelectedItem();
        if(day==null)return;
        try{
            List list = DatabaseManager.getData(SalePurchase.class.getName()," (TYPE="+Constant.DEBIT+" OR TYPE="+Constant.CREDIT+") AND DAY_ID="+day.getDayId(),"SALE_PURCHASE_ID ASC");
            System.out.println(">> SIZE: "+list.size());
            transactionList.setListData(list.toArray());
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_dateComboBoxItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Year yearbean = (Year)this.yearComboBox.getSelectedItem();
        Day daybean = (Day)this.dateComboBox.getSelectedItem();
        Account account = (Account)accountsList.getSelectedValue();
        int type = TypeEncoder.encode((String)typeComboBox.getSelectedItem());
        
        if(this.amountTextField.getText().isEmpty()||this.amountTextField.getText().equals("0")){
            javax.swing.JOptionPane.showMessageDialog(null,"Amount is empty, enter amount");
            return;
        }
        if(yearbean == null || daybean == null){
            JOptionPane.showMessageDialog(this, "Please add a date / year.");
            return;
        }
        
        if(account == null){
            JOptionPane.showMessageDialog(this, "Please Select a account..");
            return;
        }
        if(CHEQUECheckBox.isSelected() && chequeDateChooser.getDate() == null){
            JOptionPane.showMessageDialog(this, "Please select a date of Cheque OR uncheck the Cheque option..");
            return;
        }
        
        double totalAmount = 0;
        double paidAmount = 0;
        
        if(type == Constant.DEBIT){
            paidAmount = Double.parseDouble(amountTextField.getText());
        }
        else if(type== Constant.CREDIT){
            totalAmount = Double.parseDouble(amountTextField.getText());
        }
        
        try{
            //Adding SalePurchase Because i am adding transaction of cash book in SalePurchase Table
            // upper if condition is helpful to calculate total summary of account
            SalePurchase sale = new SalePurchase(daybean, account, totalAmount, type, remarksTextArea.getText().trim().toUpperCase(), paidAmount);
            int salePurchaseId = DatabaseManager.addData(sale);
            sale.setSalePurchaseId(salePurchaseId);
            
            // Adding Cheque
            if(CHEQUECheckBox.isSelected()){
                Cheque ch = new Cheque(account, sale, chequeNumberTextField.getText(), chequeDateChooser.getDate(),daybean.getDay() );
                DatabaseManager.addData(ch);
            }
            
            //Updating Daily Cash
            int accountType = TypeEncoder.encode((String)accountTypeComboBox.getSelectedItem());
            double amount = Double.parseDouble(amountTextField.getText());
            double currentCash = daybean.getCash();
            if(type == Constant.DEBIT){
                if(accountType == Constant.PURCHASE)daybean.setCash(currentCash-amount);
                else if(accountType == Constant.SALE)daybean.setCash(currentCash+amount);
                else if(accountType == Constant.EXPANSE)daybean.setCash(currentCash-amount);
                
            }else if(type== Constant.CREDIT){
                if(accountType == Constant.PURCHASE)daybean.setCash(currentCash+amount);
                else if(accountType == Constant.SALE)daybean.setCash(currentCash-amount);
                else if(accountType == Constant.EXPANSE)daybean.setCash(currentCash+amount);
            }
            DatabaseManager.updateData(daybean);
            
            dateComboBoxItemStateChanged(null);
        }catch(NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(null,"Invalid amount..");
            ex.printStackTrace();
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Transaction tr = (Transaction)transactionList.getSelectedValue();
        if(tr == null){
            JOptionPane.showMessageDialog(this, "Please Select A Transaction..");
            return;
        }
        
        try{
            DatabaseManager.deleteData(Transaction.class, tr.getTransactionId());
            JOptionPane.showMessageDialog(this, "Deleted Successfully..");
            dateComboBoxItemStateChanged(null);
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void accountTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_accountTypeComboBoxItemStateChanged
        refreshAccounts();
    }//GEN-LAST:event_accountTypeComboBoxItemStateChanged

    private void accountsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_accountsListValueChanged
        Account bean  = (Account)accountsList.getSelectedValue();
        if(bean==null)return;
        
    }//GEN-LAST:event_accountsListValueChanged

    private void CHEQUECheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEQUECheckBoxActionPerformed
        if(CHEQUECheckBox.isSelected()){
            chequeDateChooser.setEnabled(true);
            chequeNumberTextField.setEditable(true);
        }else{
            chequeDateChooser.setEnabled(false);
            chequeNumberTextField.setEditable(false);
        }
    }//GEN-LAST:event_CHEQUECheckBoxActionPerformed

    private void billNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billNoTextFieldActionPerformed
        if(this.billNoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Bill no is empty, enter bill no..");
            return;
        }
        int billNo = Integer.parseInt(billNoTextField.getText());
       
    }//GEN-LAST:event_billNoTextFieldActionPerformed

    private void clear(){
        this.amountTextField.setText("0");
        this.remarksTextArea.setText("");
    }
    public void setVisible(boolean b){
        if(b){
            refreshYear();
            refreshAccounts();
            setMaxBillId();
        }
        super.setVisible(b);
    }
    private void refreshYear(){
        yearComboBox.removeAllItems();
        try{
            java.util.List list = DatabaseManager.getData(Year.class.getName(), "YEAR DESC");
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace(System.err);}
    } 
    
    private void refreshAccounts(){
    try{
        int type= TypeEncoder.encode((String)accountTypeComboBox.getSelectedItem());
        List list = DatabaseManager.getData(Account.class.getName(),"ACCOUNT_TYPE="+type, "ACCOUNT_NAME ASC");
        accountsList.setListData(list.toArray());
    }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
}
    
    private void setMaxBillId(){
       List list = DatabaseManager.getData(bean.SalePurchase.class.getName() , " SALE_PURCHASE_ID  DESC");
       if(list.size() == 0){
           billNoTextField.setText("1");
       }else{ 
           billNoTextField.setText(""+((((SalePurchase)list.get(0)).getSalePurchaseId())+1) );
       }
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CHEQUECheckBox;
    private javax.swing.JComboBox accountTypeComboBox;
    private javax.swing.JLabel accountTypeLabel1;
    private javax.swing.JLabel accountTypeLabel2;
    private javax.swing.JList accountsList;
    private javax.swing.JScrollPane accountsListScrollPane;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel billNoLabel;
    private javax.swing.JTextField billNoTextField;
    private com.toedter.calendar.JDateChooser chequeDateChooser;
    private javax.swing.JTextField chequeNumberTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList transactionList;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
