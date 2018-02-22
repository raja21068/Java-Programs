
public class PurchaseBookFrame extends javax.swing.JFrame {

    /** Creates new form SaleBookFrame */
    javax.swing.table.DefaultTableModel tableModel;
    public PurchaseBookFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/Book-icon.png")));
        }catch(Exception ex){ex.printStackTrace();}
        tableModel = (javax.swing.table.DefaultTableModel) this.billTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        dateLabel = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox();
        billNoIdLabel = new javax.swing.JLabel();
        billNoIdTextField = new javax.swing.JTextField();
        accountsLabel = new javax.swing.JLabel();
        accountsComboBox = new javax.swing.JComboBox();
        billNoLabel = new javax.swing.JLabel();
        productsLabel = new javax.swing.JLabel();
        productsComboBox = new javax.swing.JComboBox();
        stockLabel = new javax.swing.JLabel();
        stockTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        quantityTextField = new javax.swing.JTextField();
        billNoTextField = new javax.swing.JTextField();
        billDateLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase Book");
        setMinimumSize(new java.awt.Dimension(593, 624));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("PURCHASE BOOK");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(200, 10, 200, 40);

        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(20, 54, 40, 20);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(60, 50, 100, 30);

        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(170, 54, 40, 20);

        getContentPane().add(dateComboBox);
        dateComboBox.setBounds(210, 50, 110, 30);

        billNoIdLabel.setText("Bill No ID");
        getContentPane().add(billNoIdLabel);
        billNoIdLabel.setBounds(340, 60, 60, 14);
        getContentPane().add(billNoIdTextField);
        billNoIdTextField.setBounds(400, 50, 80, 30);

        accountsLabel.setText("Accounts");
        getContentPane().add(accountsLabel);
        accountsLabel.setBounds(20, 130, 60, 14);

        getContentPane().add(accountsComboBox);
        accountsComboBox.setBounds(80, 120, 240, 30);

        billNoLabel.setText("Bill No");
        getContentPane().add(billNoLabel);
        billNoLabel.setBounds(340, 130, 50, 14);

        productsLabel.setText("Products");
        getContentPane().add(productsLabel);
        productsLabel.setBounds(20, 190, 60, 14);

        productsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productsComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(productsComboBox);
        productsComboBox.setBounds(80, 180, 240, 30);

        stockLabel.setText("Stock");
        getContentPane().add(stockLabel);
        stockLabel.setBounds(340, 184, 60, 20);
        getContentPane().add(stockTextField);
        stockTextField.setBounds(400, 180, 80, 30);

        quantityLabel.setText("Enter Quantity");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(20, 234, 90, 20);

        jLabel10.setText("press enter");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(240, 240, 90, 14);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(210, 470, 160, 23);

        generateBillButton.setText("Generate Bill");
        generateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillButtonActionPerformed(evt);
            }
        });
        getContentPane().add(generateBillButton);
        generateBillButton.setBounds(30, 470, 160, 23);

        totalLabel.setText("Total");
        getContentPane().add(totalLabel);
        totalLabel.setBounds(390, 470, 50, 20);

        totalAmountTextField.setText("0");
        getContentPane().add(totalAmountTextField);
        totalAmountTextField.setBounds(440, 470, 110, 20);

        paidAmountLabel.setText("Paid Amount");
        getContentPane().add(paidAmountLabel);
        paidAmountLabel.setBounds(370, 500, 80, 20);

        paidAmountTextField.setText("0");
        paidAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountTextFieldActionPerformed(evt);
            }
        });
        paidAmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paidAmountTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountTextFieldKeyReleased(evt);
            }
        });
        getContentPane().add(paidAmountTextField);
        paidAmountTextField.setBounds(440, 500, 110, 20);

        remainingLabel.setText("Remaining");
        getContentPane().add(remainingLabel);
        remainingLabel.setBounds(370, 530, 70, 20);

        remainingTextField.setText("0");
        getContentPane().add(remainingTextField);
        remainingTextField.setBounds(440, 530, 110, 20);

        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 510, 50, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(70, 510, 290, 60);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 270, 540, 190);

        quantityTextField.setText("0");
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(100, 230, 120, 30);

        billNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(billNoTextField);
        billNoTextField.setBounds(400, 120, 80, 30);

        billDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        billDateLabel.setForeground(new java.awt.Color(255, 0, 51));
        billDateLabel.setText("Date");
        getContentPane().add(billDateLabel);
        billDateLabel.setBounds(380, 230, 110, 30);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(4, 4, 570, 580);

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

    private void productsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productsComboBoxItemStateChanged
        ProductBean bean = (ProductBean)this.productsComboBox.getSelectedItem();
        if(bean==null)return;
        this.stockTextField.setText(""+bean.getQuantity());
    }//GEN-LAST:event_productsComboBoxItemStateChanged

    private void generateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillButtonActionPerformed
        new Thread(){
            public void run(){
                generateBill();
            }
        }.start();
       
    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
        updateTable();
}//GEN-LAST:event_billTableMouseClicked

    private void billTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTableKeyPressed
        
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DELETE){
            int[] rows = this.billTable.getSelectedRows();
            for(int i=0;i<rows.length;i++){
                this.tableModel.removeRow(this.billTable.getSelectedRow());
            }
        }
        updateTable();
}//GEN-LAST:event_billTableKeyPressed

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        if(this.quantityTextField.getText().isEmpty()||quantityTextField.getText().equals("0"))return;
        try{
            Integer.parseInt(this.quantityTextField.getText());
        }catch(NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "invalid quantity");
            this.quantityTextField.setText("0");
            return;
        }
        ProductBean bean = (ProductBean)this.productsComboBox.getSelectedItem();
        
        addRowInTable(bean,Integer.parseInt(this.quantityTextField.getText()) , bean.getRate());
        this.quantityTextField.setText("0");
        tableTotalCalculation();
}//GEN-LAST:event_quantityTextFieldActionPerformed

    private void billNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billNoTextFieldActionPerformed
        if(this.billNoTextField.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Bill no is empty, enter bill no..");
            return;
        }
        String billNo = billNoTextField.getText();
        try{
            SalePurchaseBean salePurchase = DatabaseManager.getSalePurchase(billNoTextField.getText());
            if(salePurchase.getSalePuchaseId()==0){
                message(null, "the bill number you entered in not in record..");
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
            message(null, ex);
            ex.printStackTrace();
        }
}//GEN-LAST:event_billNoTextFieldActionPerformed

    private void paidAmountTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextFieldKeyPressed
       
    }//GEN-LAST:event_paidAmountTextFieldKeyPressed

    private void paidAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountTextFieldActionPerformed
         try{
            int paidamount = Integer.parseInt(paidAmountTextField.getText());
            int total = Integer.parseInt(totalAmountTextField.getText());
            remainingTextField.setText(""+(total-paidamount));
        }catch(Exception ex){
            remainingTextField.setText(totalAmountTextField.getText());
            ex.printStackTrace();}
    }//GEN-LAST:event_paidAmountTextFieldActionPerformed

    private void paidAmountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextFieldKeyReleased
        paidAmountTextFieldActionPerformed(null);
    }//GEN-LAST:event_paidAmountTextFieldKeyReleased
private void addRowInTable(ProductBean bean , int quantity , int rate){
    int row=tableModel.getRowCount();
        tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
        tableModel.setValueAt(row+1, row, 0);
        tableModel.setValueAt(quantity, row, 1);
        tableModel.setValueAt(bean, row, 2);
        tableModel.setValueAt(rate, row, 3);
        tableModel.setValueAt((rate*quantity), row, 4);      
}
public void setVisible(boolean b){
    if( b==true)
    refreshYear();
    refreshAccountsComboBox();
    refreshProductsComboBox();
    clear();
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
        java.util.ArrayList list = DatabaseManager.getAccounts(Constant.PURCHASE);
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
    private void clearTable(){
        int count = this.tableModel.getRowCount();
        System.out.println(count);
        for(int i=count-1;i>=0;i--){
            this.tableModel.removeRow(i);
            System.out.println(i);
        }
        
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
 private void generateBill(){
         YearBean yearbean = (YearBean)this.yearComboBox.getSelectedItem();
         DayBean daybean = (DayBean)this.dateComboBox.getSelectedItem();
         AccountBean accountbean = (AccountBean)this.accountsComboBox.getSelectedItem();
         ProductBean poductbean = (ProductBean)this.productsComboBox.getSelectedItem();
         if(yearbean==null||daybean==null||accountbean==null||poductbean==null){return;}
         if(daybean.isClosed()){
             message(null, "This date is closed, please enter a new date..");
             return;
         }
         if(this.billNoTextField.getText().isEmpty()||this.billNoTextField.getText().equals("")){
             message(null, "Enter Bill number");
             return;
         }
        try {
            if(DatabaseManager.isBillNumberExist(this.billNoTextField.getText().trim())){
                message(null, "This bill Number is already exist..");
                return;
            }
            int totalAmount = Integer.parseInt(this.totalAmountTextField.getText());
            int debitAmount = Integer.parseInt(this.paidAmountTextField.getText());
            int creditAmount = Integer.parseInt(this.remainingTextField.getText());
            int count=0;
            
            int salePurchaseId = DatabaseManager.addSalePurchase(daybean.getdayId(), accountbean.getAccountId(),
                this.billNoTextField.getText(),totalAmount , Constant.PURCHASE, remarksTextArea.getText());
            count++;
            System.out.println("Maximum Bill Id: "+salePurchaseId);
            if(salePurchaseId==0){
                message(null, "Some problem occured...");
                return;
            }
            for(int i=0 ; i<tableModel.getRowCount();i++){
                int quantity =(Integer) tableModel.getValueAt(i, 1);
                ProductBean pBean = (ProductBean)tableModel.getValueAt(i, 2);
                int rate = (Integer)tableModel.getValueAt(i, 3);
                count++;
                int r = DatabaseManager.addTranction(salePurchaseId, pBean.getProductId(), quantity, rate, Constant.PRODUCT);
                if(r>0){
                    
                    count +=DatabaseManager.updateProductQuantity(pBean.getProductId(), pBean.getQuantity()+quantity);
                }
            }
            System.out.println("debit: "+debitAmount);
            if(debitAmount>0){
               System.out.println("Entered debit amount");
               count+= DatabaseManager.addCashTransaction(daybean.getdayId(), accountbean.getAccountId(), salePurchaseId, debitAmount, Constant.DEBIT);
               count+= DatabaseManager.updateCurrentAmount(yearbean.getYearId(), yearbean.getCurrentAmount()-debitAmount);
            }
//            if(creditAmount>0){
//               System.out.println("Entered credit amount");
//               count+= DatabaseManager.addCashTransaction(daybean.getdayId(), accountbean.getAccountId(), salePurchaseId, creditAmount, Constant.CREDIT);
//            }
            message(this, count + " Transaction added successfully...");
            refreshProductsComboBox();
            clear();
        } catch (Exception ex) {
            message(null, ""+ex);
            ex.printStackTrace();
        } 
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
    public void message(java.awt.Component parent,Object message){
        javax.swing.JOptionPane.showMessageDialog(parent, message);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountsComboBox;
    private javax.swing.JLabel accountsLabel;
    private javax.swing.JLabel backgroundLabel;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainLabel;
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
