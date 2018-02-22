
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class SaleBookFrame extends javax.swing.JFrame {

    /** Creates new form SaleBookFrame */
    javax.swing.table.DefaultTableModel tableModel;
    public SaleBookFrame() {
        super();
        initComponents();
	try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/transaction2.png")));
        }catch(Exception ex){ex.printStackTrace();}
	tableModel = (javax.swing.table.DefaultTableModel) this.billTable.getModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        dateLabel = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox();
        billNoIdLabel = new javax.swing.JLabel();
        billNoIdTextField = new javax.swing.JTextField();
        accountsLabel = new javax.swing.JLabel();
        accountsComboBox = new javax.swing.JComboBox();
        billNoLabel = new javax.swing.JLabel();
        billNoTextField = new javax.swing.JTextField();
        productsLabel = new javax.swing.JLabel();
        productsComboBox = new javax.swing.JComboBox();
        stockLabel = new javax.swing.JLabel();
        stockTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        clearButton = new javax.swing.JButton();
        generateBillButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        paidAmountLabel = new javax.swing.JLabel();
        paidAmountTextField = new javax.swing.JTextField();
        remainingLabel = new javax.swing.JLabel();
        remainingTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        billDateLabel = new javax.swing.JLabel();
        backgroundPicLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales Book");
        setMinimumSize(new java.awt.Dimension(600, 680));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("SALES BOOK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 10, 160, 40);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(10, 70, 50, 30);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(60, 70, 100, 30);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(170, 70, 40, 30);

        getContentPane().add(dateComboBox);
        dateComboBox.setBounds(210, 70, 110, 30);

        billNoIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        billNoIdLabel.setText("Bill No ID");
        getContentPane().add(billNoIdLabel);
        billNoIdLabel.setBounds(330, 74, 70, 20);

        billNoIdTextField.setEditable(false);
        getContentPane().add(billNoIdTextField);
        billNoIdTextField.setBounds(400, 70, 80, 30);

        accountsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accountsLabel.setText("Accounts");
        getContentPane().add(accountsLabel);
        accountsLabel.setBounds(10, 144, 70, 20);

        getContentPane().add(accountsComboBox);
        accountsComboBox.setBounds(80, 140, 240, 30);

        billNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        billNoLabel.setText("Bill No");
        getContentPane().add(billNoLabel);
        billNoLabel.setBounds(330, 144, 60, 20);

        billNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(billNoTextField);
        billNoTextField.setBounds(400, 140, 80, 30);

        productsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productsLabel.setText("Products");
        getContentPane().add(productsLabel);
        productsLabel.setBounds(10, 204, 70, 20);

        productsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productsComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(productsComboBox);
        productsComboBox.setBounds(80, 200, 240, 30);

        stockLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stockLabel.setText("Stock");
        getContentPane().add(stockLabel);
        stockLabel.setBounds(330, 210, 70, 20);
        getContentPane().add(stockTextField);
        stockTextField.setBounds(400, 200, 80, 30);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quantityLabel.setText("Enter Quantity");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(10, 250, 100, 30);

        quantityTextField.setText("0");
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(110, 250, 120, 30);

        jLabel10.setText("press enter");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(240, 260, 90, 14);

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Quantity", "Product", "Per Rate", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billTable.getTableHeader().setReorderingAllowed(false);
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        billTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(billTable);
        billTable.getColumnModel().getColumn(0).setResizable(false);
        billTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        billTable.getColumnModel().getColumn(1).setResizable(false);
        billTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        billTable.getColumnModel().getColumn(2).setResizable(false);
        billTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        billTable.getColumnModel().getColumn(3).setResizable(false);
        billTable.getColumnModel().getColumn(4).setResizable(false);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 290, 540, 190);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(210, 490, 140, 23);

        generateBillButton.setText("Generate Bill");
        generateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillButtonActionPerformed(evt);
            }
        });
        getContentPane().add(generateBillButton);
        generateBillButton.setBounds(30, 490, 140, 23);

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setText("Total");
        getContentPane().add(totalLabel);
        totalLabel.setBounds(360, 490, 80, 20);

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setText("0");
        getContentPane().add(totalAmountTextField);
        totalAmountTextField.setBounds(440, 490, 110, 20);

        paidAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        paidAmountLabel.setText("Paid Amount");
        getContentPane().add(paidAmountLabel);
        paidAmountLabel.setBounds(360, 520, 90, 20);

        paidAmountTextField.setText("0");
        paidAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountTextFieldActionPerformed(evt);
            }
        });
        paidAmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountTextFieldKeyReleased(evt);
            }
        });
        getContentPane().add(paidAmountTextField);
        paidAmountTextField.setBounds(440, 520, 110, 20);

        remainingLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        remainingLabel.setText("Remaining");
        getContentPane().add(remainingLabel);
        remainingLabel.setBounds(360, 550, 80, 20);

        remainingTextField.setEditable(false);
        remainingTextField.setText("0");
        getContentPane().add(remainingTextField);
        remainingTextField.setBounds(440, 550, 110, 20);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 530, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(70, 530, 280, 60);

        billDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billDateLabel.setForeground(new java.awt.Color(255, 0, 51));
        billDateLabel.setText("Date");
        getContentPane().add(billDateLabel);
        billDateLabel.setBounds(384, 244, 110, 30);

        backgroundPicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(backgroundPicLabel);
        backgroundPicLabel.setBounds(0, 0, 630, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        YearBean bean = (YearBean)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        try{
            this.dateComboBox.removeAllItems();
            this.dateComboBox.addItem(DatabaseManager.getLastDay(bean.getYearId()));
            }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        if(this.quantityTextField.getText().isEmpty()||quantityTextField.getText().equals("0"))return;
        try{
            Integer.parseInt(this.quantityTextField.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "invalid quantity");
            this.quantityTextField.setText("0");
            return;
        }
        ProductBean bean = (ProductBean)this.productsComboBox.getSelectedItem(); 
        
        this.addRowInTable(bean,Integer.parseInt(this.quantityTextField.getText()) , bean.getRate());
        
        this.quantityTextField.setText("0");
        tableTotalCalculation();
    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void productsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productsComboBoxItemStateChanged
        ProductBean bean = (ProductBean)this.productsComboBox.getSelectedItem();
        if(bean==null)return;
        this.stockTextField.setText(""+bean.getQuantity());
    }//GEN-LAST:event_productsComboBoxItemStateChanged

    private void billTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTableKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            int[] rows = this.billTable.getSelectedRows();
            for(int i=0;i<rows.length;i++){
                this.tableModel.removeRow(this.billTable.getSelectedRow());
            }
        }
        updateTable();
    }//GEN-LAST:event_billTableKeyPressed

    private void paidAmountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextFieldKeyReleased
        String pay = this.paidAmountTextField.getText();
        if(pay==null||pay.equals(""))return;
        int paid = (Integer.parseInt(pay));
        int total =(Integer.parseInt(this.totalAmountTextField.getText()));
        this.remainingTextField.setText(""+(total-paid));
    }//GEN-LAST:event_paidAmountTextFieldKeyReleased

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
        updateTable();
    }//GEN-LAST:event_billTableMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void generateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillButtonActionPerformed
        new Thread(){
            public void run(){
                generateBill();
            }
        }.start();
    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void billNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billNoTextFieldActionPerformed
        
        if(this.billNoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Bill no is empty, enter bill no..");
            return;
        }
        String billNo = billNoTextField.getText();
        try{
            SalePurchaseBean salePurchase = DatabaseManager.getSalePurchase(billNoTextField.getText());
            if(salePurchase.getSalePuchaseId()==0){
                JOptionPane.showMessageDialog(null, "the bill number you entered in not in record..");
                return;
            }
            
            clear();
            billNoTextField.setText(billNo);
            billNoIdTextField.setText(""+salePurchase.getSalePuchaseId());
            this.totalAmountTextField.setText(""+salePurchase.getTotalAmount());
            this.billDateLabel.setVisible(true);
            this.billDateLabel.setText(DateFormatter.dateToString(salePurchase.getDay()));
            int accountId = salePurchase.getAccountId();
            for(int i=0 ; i<this.accountsComboBox.getItemCount();i++){
                AccountBean aBean = (AccountBean) this.accountsComboBox.getItemAt(i);
                if(accountId==aBean.getAccountId()){
                    accountsComboBox.setSelectedItem(aBean);
                    break;
                }
            }
            java.util.ArrayList<TransactionBean> transactions = DatabaseManager.getTransactions(salePurchase.getSalePuchaseId());
            clearTable();
            for(int i=0 ; i<transactions.size();i++ ){
                TransactionBean bean = transactions.get(i);
                int amount = bean.getAmount();
                int productId = bean.getProductId();
                int quantity = bean.getQuantity();
                int type = bean.getType();
                if(type==Constant.PRODUCT){
                    ProductBean productBean = getProductBean(productId);
                    addRowInTable(productBean , quantity, amount);
                }else if(type==Constant.DEBIT){
                    paidAmountTextField.setText(""+amount);
                    remainingTextField.setText(""+(salePurchase.getTotalAmount() - amount));
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_billNoTextFieldActionPerformed

    private void paidAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountTextFieldActionPerformed
        try{
            int paidamount = Integer.parseInt(paidAmountTextField.getText());
            int total = Integer.parseInt(totalAmountTextField.getText());
            remainingTextField.setText(""+(total-paidamount));
        }catch(Exception ex){
            remainingTextField.setText(totalAmountTextField.getText());
            ex.printStackTrace();}
    }//GEN-LAST:event_paidAmountTextFieldActionPerformed

public void setVisible(boolean b){
    if(b)
    {
        refreshYear();
        refreshAccountsComboBox();
        refreshProductsComboBox();
        clear();
    }
    super.setVisible(b);
}
private void refreshYear(){
        yearComboBox.removeAllItems();
        try{
            java.util.ArrayList list = DatabaseManager.getYears();
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    } 
private void refreshAccountsComboBox(){
    this.accountsComboBox.removeAllItems();
    try{
        java.util.ArrayList list = DatabaseManager.getAccounts(Constant.SALE);
        System.out.println(list.size());
        for(int i=0; i<list.size();i++){
            this.accountsComboBox.addItem(list.get(i));
        }
    }catch(Exception ex){ex.printStackTrace();}
}
private void refreshProductsComboBox(){
    this.productsComboBox.removeAllItems();
    try{
        java.util.ArrayList list = DatabaseManager.getProducts();
        for(int i=0; i<list.size();i++){
            this.productsComboBox.addItem(list.get(i));
        }
    }catch(Exception ex){ex.printStackTrace();}
}
private ProductBean getProductBean(int id){
    
    for(int i=0;i<this.productsComboBox.getItemCount();i++){
        ProductBean proBean = (ProductBean)this.productsComboBox.getItemAt(i);
        if(proBean.getProductId()==id){
            return proBean;
        }
    }
    return null;
}
private void addRowInTable(ProductBean bean , int quantity , int rate){
        int row=tableModel.getRowCount();
        tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
        tableModel.setValueAt(row+1, row, 0);
        tableModel.setValueAt(quantity, row, 1);
        tableModel.setValueAt(bean, row, 2);
        tableModel.setValueAt(rate, row, 3);
        tableModel.setValueAt((rate*quantity), row, 4);      
}
private void tableTotalCalculation(){
   int total=0;
   for(int i=0;i<tableModel.getRowCount();i++){
          if(tableModel.getValueAt(i, 4)!=null){
              String s = tableModel.getValueAt(i, 4).toString();
              total += Integer.parseInt(s);
          }       
    }
    this.totalAmountTextField.setText(""+total);
    this.remainingTextField.setText(""+(total-(Integer.parseInt(this.paidAmountTextField.getText()))));
}
private void updateTable(){
    for(int rowNo=0 ; rowNo<tableModel.getRowCount();rowNo++){
            Object obj = tableModel.getValueAt(rowNo, 0);
            if(obj==null){break;}
                int quantity = Integer.parseInt( this.billTable.getValueAt(rowNo, 1).toString());
                int rate = Integer.parseInt(this.billTable.getValueAt(rowNo, 3).toString());
                tableModel.setValueAt((quantity*rate) ,rowNo , 4);
        }
    for(int i=0;i<tableModel.getRowCount();i++){
        tableModel.setValueAt(i+1, i, 0);
    }
        this.tableTotalCalculation();
}
public void clear(){
    this.billNoTextField.setText("");
    this.quantityTextField.setText("0");
    clearTable();
    this.totalAmountTextField.setText("0");
    this.paidAmountTextField.setText("0");
    this.remainingTextField.setText("0");
    this.remarksTextArea.setText("");
    this.billDateLabel.setVisible(false);
}
    private void clearTable(){
        int count = this.tableModel.getRowCount();
        System.out.println(count);
        for(int i=count-1;i>=0;i--){
            this.tableModel.removeRow(i);
            System.out.println(i);
        }
}
    private void generateBill(){
         YearBean yearbean = (YearBean)this.yearComboBox.getSelectedItem();
         DayBean daybean = (DayBean)this.dateComboBox.getSelectedItem();
         AccountBean accountbean = (AccountBean)this.accountsComboBox.getSelectedItem();
         ProductBean poductbean = (ProductBean)this.productsComboBox.getSelectedItem();
         if(yearbean==null||daybean==null||accountbean==null||poductbean==null){return;}
         if(daybean.isClosed()){
             JOptionPane.showMessageDialog(null, "This date is closed, please enter a new date..");
             return;
         }
         if(this.billNoTextField.getText().isEmpty()||this.billNoTextField.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Enter Bill number");
             return;
         }
        try {
            if(DatabaseManager.isBillNumberExist(this.billNoTextField.getText().trim())){
                JOptionPane.showMessageDialog(null, "This bill Number is already exist..");
                return;
            }
            int totalAmount = Integer.parseInt(this.totalAmountTextField.getText());
            int debitAmount = Integer.parseInt(this.paidAmountTextField.getText());
            int creditAmount = Integer.parseInt(this.remainingTextField.getText());
            int count=0;
            
            int salePurchaseId = DatabaseManager.addSalePurchase(daybean.getdayId(), accountbean.getAccountId(),
                this.billNoTextField.getText(),totalAmount , Constant.SALE, remarksTextArea.getText());
            count++;
            if(salePurchaseId==0){
                JOptionPane.showMessageDialog(null, "Problem...");
                return;
            }
            System.out.println("Maximum Bill Id: "+salePurchaseId);
            if(salePurchaseId==0){
                JOptionPane.showMessageDialog(null, "Some problem occured...");
                return;
            }
            for(int i=0 ; i<tableModel.getRowCount();i++){
                int quantity =(Integer) tableModel.getValueAt(i, 1);
                ProductBean pBean = (ProductBean)tableModel.getValueAt(i, 2);
                int rate = (Integer)tableModel.getValueAt(i, 3);
                count++;
                int r = DatabaseManager.addTranction(salePurchaseId, pBean.getProductId(), quantity, rate, Constant.PRODUCT);
                if(r>0){
                    
                    count +=DatabaseManager.updateProductQuantity(pBean.getProductId(), pBean.getQuantity()-quantity);
                }
            }
            System.out.println("debit: "+debitAmount);
            if(debitAmount>0){
               System.out.println("Entered debit amount");
               count+= DatabaseManager.addCashTransaction(daybean.getdayId(), accountbean.getAccountId(), salePurchaseId, debitAmount, Constant.DEBIT);
               count+= DatabaseManager.updateCurrentAmount(yearbean.getYearId(), yearbean.getCurrentAmount()+debitAmount);
            }
//            if(creditAmount>0){
//               System.out.println("Entered credit amount");
//               count+= DatabaseManager.addCashTransaction(daybean.getdayId(), accountbean.getAccountId(), salePurchaseId, creditAmount, Constant.CREDIT);
//            }
            JOptionPane.showMessageDialog(this, count + " Transaction added successfully...");
            refreshProductsComboBox();
            clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ""+ex);
            ex.printStackTrace();
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountsComboBox;
    private javax.swing.JLabel accountsLabel;
    private javax.swing.JLabel backgroundPicLabel;
    private javax.swing.JLabel billDateLabel;
    private javax.swing.JLabel billNoIdLabel;
    private javax.swing.JTextField billNoIdTextField;
    private javax.swing.JLabel billNoLabel;
    private javax.swing.JTextField billNoTextField;
    private javax.swing.JTable billTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton generateBillButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel paidAmountLabel;
    private javax.swing.JTextField paidAmountTextField;
    private javax.swing.JComboBox productsComboBox;
    private javax.swing.JLabel productsLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JTextField remainingTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JTextField stockTextField;
    private javax.swing.JTextField totalAmountTextField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
