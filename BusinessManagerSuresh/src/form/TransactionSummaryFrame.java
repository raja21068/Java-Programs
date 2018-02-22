package form;


import database.DataManager;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import report.PrintJtable;
import utility.DateFormatter;

public class TransactionSummaryFrame extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel leftTableModel;
    
    int ACCOUNT_COLUMN=0;
    int DATE_COLUMN=1;
    int TYPE_COLUMN=2;
    int PAID_AMOUNT_COLUMN=3;
    int TOTAL_AMOUNT_COLUMN=4;
    int CHEQUE_COLUMN=5;
    int BILL_COLUMN=6;
    
    public TransactionSummaryFrame() {
        initComponents();
        leftTableModel = (javax.swing.table.DefaultTableModel) this.leftTable.getModel();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/account summary 2.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }
public void setVisible(boolean b){
    if(b){
        getYears();
        getAccounts();
    }
    super.setVisible(b);
}

private void getYears(){
        try{
//            java.util.ArrayList list = DatabaseManager.getAllYear();
//            for(int i=0; i<list.size();i++){
//                yearComboBox.addItem(list.get(i));
//            }
        }catch(Exception ex){ex.printStackTrace();}
}
private void getAccounts(){
    try{
//        java.util.ArrayList list = DatabaseManager.getAllAccount();
//        for(int i=0; i<list.size();i++){
//            this.accountsComboBox.addItem(list.get(i));
//        }
    }catch(Exception ex){ex.printStackTrace();}
}

private void clearTables(){
        int count = this.leftTableModel.getRowCount();
        System.out.println(count);
        for(int i=count-1;i>=0;i--){
            this.leftTableModel.removeRow(i);
        }
}
private void clear(){
    clearTables();
    this.totalSaleTextField.setText("0");
    this.totalPurchaseTextField.setText("0");
    this.profitTextField.setText("0");
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        leftTable = new javax.swing.JTable();
        leftTableLabel = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        totalSaleTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalPurchaseTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        profitTextField = new javax.swing.JTextField();
        transactionsButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Summary");
        setMinimumSize(new java.awt.Dimension(750, 580));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText(" TRANSACTION SUMMARY");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(210, 10, 290, 40);

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dayLabel.setText("DAY");
        getContentPane().add(dayLabel);
        dayLabel.setBounds(30, 50, 30, 30);

        toLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        toLabel.setText("TO");
        getContentPane().add(toLabel);
        toLabel.setBounds(260, 50, 40, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(550, 500, 130, 30);

        leftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account", "Date", "Type", "Paid Amount", "Total Amount", "Cheque", "Bill"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(leftTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 112, 680, 350);

        leftTableLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        leftTableLabel.setText("TRANSACTION");
        getContentPane().add(leftTableLabel);
        leftTableLabel.setBounds(20, 90, 140, 14);
        getContentPane().add(fromDateChooser);
        fromDateChooser.setBounds(80, 55, 130, 30);
        getContentPane().add(toDateChooser);
        toDateChooser.setBounds(310, 55, 150, 30);

        jLabel1.setText("TOTAL SALE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 480, 80, 14);
        getContentPane().add(totalSaleTextField);
        totalSaleTextField.setBounds(20, 500, 120, 30);

        jLabel2.setText("TOTAL PURCHASE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 480, 120, 14);
        getContentPane().add(totalPurchaseTextField);
        totalPurchaseTextField.setBounds(190, 500, 120, 30);

        jLabel3.setText("PROFIT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 480, 60, 14);
        getContentPane().add(profitTextField);
        profitTextField.setBounds(380, 500, 120, 30);

        transactionsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transactionsButton.setText("Transactions");
        transactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transactionsButton);
        transactionsButton.setBounds(470, 55, 130, 30);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/print-icon.png"))); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton);
        printButton.setBounds(610, 50, 80, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void transactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsButtonActionPerformed
        Date from = fromDateChooser.getDate();
        if(from == null){
            JOptionPane.showMessageDialog(this , "Please Select the Day DATE");
            return; 
        }
        Date to  = toDateChooser.getDate();
        if(to == null){
            JOptionPane.showMessageDialog(this , "Please Select the TO DATE");
            return; 
        }
        String fromDate = DateFormatter.dateToStringYMD(from);
        String toDate = DateFormatter.dateToStringYMD(to);
        try{
            clear();
            DataManager.setDaySummary(fromDate, toDate, leftTableModel, ACCOUNT_COLUMN, DATE_COLUMN, TYPE_COLUMN, PAID_AMOUNT_COLUMN, TOTAL_AMOUNT_COLUMN, CHEQUE_COLUMN, BILL_COLUMN, totalSaleTextField, totalPurchaseTextField, profitTextField);
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_transactionsButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        new PrintJtable(leftTable).doPrint();
        try {
            leftTable.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Transaction Report"),new MessageFormat(""));
        } catch (PrinterException ex) {
            Logger.getLogger(TransactionSummaryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dayLabel;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable leftTable;
    private javax.swing.JLabel leftTableLabel;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField profitTextField;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField totalPurchaseTextField;
    private javax.swing.JTextField totalSaleTextField;
    private javax.swing.JButton transactionsButton;
    // End of variables declaration//GEN-END:variables
}
