package form;


import bean.Account;
import bean.Categeory;
import bean.Cheque;
import bean.Day;
import bean.MeasurementUnit;
import bean.Product;
import bean.SalePurchase;
import bean.Transaction;
import bean.Year;
import constant.Constant;
import database.DataManager;
import database.DatabaseManager;
import static form.SaleBookFrame.QUANTITY_COLUMN;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import utility.BillInfo;


public class PurchaseBookFrame extends javax.swing.JFrame {

    /** Creates new form SaleBookFrame */
    javax.swing.table.DefaultTableModel tableModel;
    
    static int QUANTITY_COLUMN = 1;
    static int PRODUCT_COLUMN = 2;
    static int PERRATE_COLUMN = 3;
    
    SalePurchase salePurchase;
    ArrayList<BillInfo> billInfoList; 
    
    public PurchaseBookFrame() {
        super();
        initComponents();
	try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/transaction2.png")));
        }catch(Exception ex){ex.printStackTrace(System.err);}
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
        accountsLabel = new javax.swing.JLabel();
        billNoLabel = new javax.swing.JLabel();
        billNoTextField = new javax.swing.JTextField();
        productsLabel = new javax.swing.JLabel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList();
        billDateLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        accountsList = new javax.swing.JList();
        stockLabel1 = new javax.swing.JLabel();
        customerRateTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        currentRateTextField = new javax.swing.JTextField();
        unitComboBox = new javax.swing.JComboBox();
        setCustomerButton = new javax.swing.JButton();
        CHEQUECheckBox = new javax.swing.JCheckBox();
        chequeDateChooser = new com.toedter.calendar.JDateChooser();
        chequeNumberTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        updateBillButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales Book");
        setMinimumSize(new java.awt.Dimension(670, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PURCHASE BOOK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 0, 190, 30);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(10, 40, 50, 30);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(60, 40, 110, 30);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(10, 80, 40, 30);

        getContentPane().add(dateComboBox);
        dateComboBox.setBounds(60, 80, 110, 30);

        accountsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accountsLabel.setText("Purchase Accounts");
        getContentPane().add(accountsLabel);
        accountsLabel.setBounds(470, 30, 130, 20);

        billNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        billNoLabel.setText("Bill No");
        getContentPane().add(billNoLabel);
        billNoLabel.setBounds(10, 120, 60, 20);

        billNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billNoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(billNoTextField);
        billNoTextField.setBounds(60, 120, 110, 30);

        productsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productsLabel.setText("Products");
        getContentPane().add(productsLabel);
        productsLabel.setBounds(240, 30, 70, 20);

        stockLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stockLabel.setText("<html>Customer<br>Rate</html>");
        getContentPane().add(stockLabel);
        stockLabel.setBounds(10, 200, 70, 30);

        stockTextField.setEditable(false);
        getContentPane().add(stockTextField);
        stockTextField.setBounds(60, 160, 110, 30);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quantityLabel.setText("Enter Quantity");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(20, 280, 100, 30);

        quantityTextField.setText("0");
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(120, 280, 120, 30);

        jLabel10.setText("press enter");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(250, 290, 90, 14);

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Quantity", "Product", "Per Rate", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
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
        jScrollPane1.setBounds(20, 320, 610, 190);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(320, 520, 110, 30);

        generateBillButton.setText("Generate Bill");
        generateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillButtonActionPerformed(evt);
            }
        });
        getContentPane().add(generateBillButton);
        generateBillButton.setBounds(20, 520, 140, 30);

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalLabel.setText("Total");
        getContentPane().add(totalLabel);
        totalLabel.setBounds(470, 520, 70, 20);

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setText("0");
        getContentPane().add(totalAmountTextField);
        totalAmountTextField.setBounds(520, 520, 110, 20);

        paidAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        paidAmountLabel.setText("Paid Amount");
        getContentPane().add(paidAmountLabel);
        paidAmountLabel.setBounds(430, 550, 90, 20);

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
        paidAmountTextField.setBounds(520, 550, 110, 20);

        remainingLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        remainingLabel.setText("Remaining");
        getContentPane().add(remainingLabel);
        remainingLabel.setBounds(420, 640, 80, 20);

        remainingTextField.setEditable(false);
        remainingTextField.setText("0");
        getContentPane().add(remainingTextField);
        remainingTextField.setBounds(500, 640, 130, 20);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 560, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(70, 560, 160, 60);

        productList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(productList);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(240, 60, 190, 190);

        billDateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billDateLabel.setForeground(new java.awt.Color(255, 0, 51));
        billDateLabel.setText("Date");
        getContentPane().add(billDateLabel);
        billDateLabel.setBounds(470, 280, 150, 30);

        jScrollPane4.setViewportView(accountsList);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(470, 50, 150, 190);

        stockLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stockLabel1.setText("Stock");
        getContentPane().add(stockLabel1);
        stockLabel1.setBounds(10, 160, 70, 30);
        getContentPane().add(customerRateTextField);
        customerRateTextField.setBounds(80, 200, 90, 30);

        jLabel2.setText("Current Rate");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 250, 90, 20);

        currentRateTextField.setEditable(false);
        getContentPane().add(currentRateTextField);
        currentRateTextField.setBounds(90, 250, 110, 20);

        getContentPane().add(unitComboBox);
        unitComboBox.setBounds(330, 260, 100, 20);

        setCustomerButton.setText("Set");
        setCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setCustomerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(setCustomerButton);
        setCustomerButton.setBounds(175, 200, 60, 30);

        CHEQUECheckBox.setText("Cheque");
        CHEQUECheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEQUECheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(CHEQUECheckBox);
        CHEQUECheckBox.setBounds(420, 580, 80, 23);

        chequeDateChooser.setEnabled(false);
        getContentPane().add(chequeDateChooser);
        chequeDateChooser.setBounds(500, 580, 130, 20);

        chequeNumberTextField.setEditable(false);
        getContentPane().add(chequeNumberTextField);
        chequeNumberTextField.setBounds(500, 610, 130, 20);

        jLabel3.setText("Check No");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 610, 60, 14);

        updateBillButton.setText("Update Bill");
        updateBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBillButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateBillButton);
        updateBillButton.setBounds(180, 520, 130, 30);

        categoryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(categoryComboBox);
        categoryComboBox.setBounds(300, 30, 130, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        Year bean = (Year)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        dateComboBox.removeAllItems();
        try{
            List list = DatabaseManager.getData(Day.class.getName(),"YEAR_ID="+bean.getYearId(), " DAY DESC");
            for(Object ob: list){
                dateComboBox.addItem(ob);
            }
        }catch(Exception ex){ex.printStackTrace(System.err);}
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed
        if(productList.isSelectionEmpty() || this.quantityTextField.getText().isEmpty()||quantityTextField.getText().equals("0"))return;
        try{
            Product bean = (Product)this.productList.getSelectedValue(); 
            double quantity= Double.parseDouble(this.quantityTextField.getText()) ;
            this.addRowInTable(bean,quantity, bean.getCurrentRate());
        
            this.quantityTextField.setText("0");
            tableTotalCalculation();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, ""+ex);
            this.quantityTextField.setText("0");
            ex.printStackTrace(System.err);
        }
        
    }//GEN-LAST:event_quantityTextFieldActionPerformed

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
        double paid = (Double.parseDouble(pay));
        double total =(Double.parseDouble(this.totalAmountTextField.getText()));
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
            @Override
            public void run(){
                tableTotalCalculation();
                generateBill();
            }
        }.start();
    }//GEN-LAST:event_generateBillButtonActionPerformed

    private void billNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billNoTextFieldActionPerformed
        clearTable();
        generateBillButton.setEnabled(false);
        updateBillButton.setEnabled(true);
        billNoTextField.setEnabled(false);
        quantityTextField.setEnabled(false);
        if(this.billNoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Bill no is empty, enter bill no..");
            return;
        }
        int billNo = Integer.parseInt(billNoTextField.getText().trim());
        try{
            List list = DatabaseManager.getData(SalePurchase.class.getName(), "SALE_PURCHASE_ID="+billNo+" AND TYPE="+Constant.PURCHASE, " DAY_ID DESC");
            if(list.isEmpty())return;
            
            salePurchase = (SalePurchase)list.get(0);
            
            paidAmountTextField.setText(""+salePurchase.getPaidAmount());
            totalAmountTextField.setText(""+salePurchase.getTotalAmount());
            remainingTextField.setText(""+ (salePurchase.getTotalAmount() - salePurchase.getPaidAmount()));
        
            billInfoList = DataManager.setBillHistory(billNo,tableModel,QUANTITY_COLUMN ,PRODUCT_COLUMN , PERRATE_COLUMN,billDateLabel,accountsList);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_billNoTextFieldActionPerformed

    private void paidAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountTextFieldActionPerformed
        try{
            double paidamount = Double.parseDouble(paidAmountTextField.getText());
            double total = Double.parseDouble(totalAmountTextField.getText());
            remainingTextField.setText(""+(total-paidamount));
        }catch(Exception ex){
            remainingTextField.setText(totalAmountTextField.getText());
            ex.printStackTrace(System.err);}
    }//GEN-LAST:event_paidAmountTextFieldActionPerformed

    private void productListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productListValueChanged
        Product bean = (Product)productList.getSelectedValue();
        if(bean==null)return;
        stockTextField.setText(""+bean.getQuantity());
        currentRateTextField.setText(""+bean.getCurrentRate());
        customerRateTextField.setText(""+bean.getRate());
        
        int total = unitComboBox.getItemCount();
        for(int i=0; i<total; i++){
            MeasurementUnit mu = (MeasurementUnit)unitComboBox.getItemAt(i);
            if(mu == bean.getMeasurementUnit()){
                unitComboBox.setSelectedItem(mu);
                break;
            }
        }
    }//GEN-LAST:event_productListValueChanged

    private void setCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setCustomerButtonActionPerformed
        if(productList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select Any Product..");
            return;
        }
        Product bean = (Product)productList.getSelectedValue();
        double cutomerRate = Double.parseDouble(customerRateTextField.getText());
        bean.setRate(cutomerRate);
        DatabaseManager.updateData(bean);
        clear();
    }//GEN-LAST:event_setCustomerButtonActionPerformed

    private void CHEQUECheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEQUECheckBoxActionPerformed
        if(CHEQUECheckBox.isSelected()){
            chequeDateChooser.setEnabled(true);
            chequeNumberTextField.setEditable(true);
        }else{
            chequeDateChooser.setEnabled(false);
            chequeNumberTextField.setEditable(false);
        }
    }//GEN-LAST:event_CHEQUECheckBoxActionPerformed

    private void updateBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBillButtonActionPerformed
        double totalAmount = Double.parseDouble(this.totalAmountTextField.getText());
        double paidAmount = Double.parseDouble(this.paidAmountTextField.getText());
        
        if(paidAmount > totalAmount){
            JOptionPane.showMessageDialog(this, "Cannot Update Bill.. \n Paid amount should not greater than total..");
            generateBillButton.setEnabled(true);
            return;
        } 
        System.out.println("-> "+salePurchase);
        System.out.println("--> "+billInfoList.size());
        salePurchase.setTotalAmount(totalAmount);
        salePurchase.setPaidAmount(paidAmount);
        
        DatabaseManager.updateData(salePurchase);
        
        for(int i=0;i<billInfoList.size();i++){
            BillInfo oldInfo = billInfoList.get(i);
            int row = containsTransactionId(oldInfo);
            try{
                if(row<0){
                    System.out.println("REMOVED");
                    DataManager.deleteTransaction(oldInfo.transactionId);
                    Product p = getProductFromList(oldInfo.productId);
                    double oldQ = p.getQuantity();
                    p.setQuantity(oldQ+oldInfo.quantity);
                    DatabaseManager.updateData(p);
                    //DataManager.updateSaleProduct(oldInfo.productId, oldInfo.quantity);
                }else{
                    System.out.println("UPDATED");
                    double quantity = (Double)tableModel.getValueAt(row, QUANTITY_COLUMN);
                    double price = (Double)tableModel.getValueAt(row,PERRATE_COLUMN );
                    DataManager.updateTransaction( oldInfo.transactionId,quantity ,price );
                    Product p = getProductFromList(oldInfo.productId);
                    double oldQ = p.getQuantity();
                    p.setQuantity(oldQ+(oldInfo.quantity-quantity));
                    DatabaseManager.updateData(p);
                    
                }
                
            }catch(Exception ex){
                ex.printStackTrace(System.err);
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        setVisible(true);
    }//GEN-LAST:event_updateBillButtonActionPerformed

    private void categoryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboBoxItemStateChanged
        if(categoryComboBox.getSelectedItem() == null) return;
        refreshProducts();
    }//GEN-LAST:event_categoryComboBoxItemStateChanged

    private int containsTransactionId(BillInfo info){
        int row = tableModel.getRowCount();
        System.out.println("-------------------\nROW: "+row);
        for(int i=0;i<row;i++){
            BillInfo in = (BillInfo)tableModel.getValueAt(i, PRODUCT_COLUMN);
            System.out.println(in.transactionId+" == "+info.transactionId);
            if(in.transactionId == info.transactionId){
                return i;
            }
        }
        return -1;
    }
    
    private Product getProductFromList(int productId){
        ListModel model = productList.getModel();
        int items = model.getSize();
        for(int i=0;i<items;i++){
            Product p = (Product)model.getElementAt(i);
            if(productId == p.getProductId()){
                return p;
            }
        }
        return null;
    }
   
    private void refreshProducts() {
        Categeory cat = (Categeory)categoryComboBox.getSelectedItem();
        if(cat == null){
            System.out.println("null at refresh products");
            return;
        }
        List list = DatabaseManager.getData(Product.class.getName(), " CATEGORY_ID = "+cat.getCategoryId(), " PRODUCT_NAME ASC ");
        productList.setListData(list.toArray());
        
    }
    
    @Override
    public void setVisible(boolean b){
    if(b)
    {
        refreshYear();
        refreshAccountsList();
        refreshCategory();
        refreshMeasurementUnit();
        clear();
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

    private void refreshAccountsList(){
        List list = DatabaseManager.getData(Account.class.getName(), "ACCOUNT_TYPE="+constant.Constant.PURCHASE, "ACCOUNT_NAME ASC");
        accountsList.setListData(list.toArray());
    }

    private void refreshCategory(){
        try{
            List list = DatabaseManager.getData(Categeory.class.getName(), " CATEGORY_NAME ASC");
            categoryComboBox.removeAllItems();
            for(int i=0;i<list.size();i++){
                categoryComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void addRowInTable(Product bean , double quantity , double rate){
        int row=tableModel.getRowCount();
        tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
        tableModel.setValueAt(row+1, row, 0);
        tableModel.setValueAt(quantity, row, 1);
        tableModel.setValueAt(bean, row, 2);
        tableModel.setValueAt(rate, row, 3);
        tableModel.setValueAt((rate*quantity), row, 4);      
    }
private void tableTotalCalculation(){
   double total=0;
   for(int i=0;i<tableModel.getRowCount();i++){
          if(tableModel.getValueAt(i, 4)!=null){
              String s = tableModel.getValueAt(i, 4).toString();
              total += Double.parseDouble(s);
          }       
    }
    this.totalAmountTextField.setText(""+total);
    this.remainingTextField.setText(""+(total-(Double.parseDouble(this.paidAmountTextField.getText()))));
}
private void updateTable(){
    for(int rowNo=0 ; rowNo<tableModel.getRowCount();rowNo++){
            Object obj = tableModel.getValueAt(rowNo, 0);
            if(obj==null){break;}
                double quantity = Double.parseDouble( this.billTable.getValueAt(rowNo, 1).toString());
                double rate = Double.parseDouble(this.billTable.getValueAt(rowNo, 3).toString());
                tableModel.setValueAt((quantity*rate) ,rowNo , 4);
        }
    for(int i=0;i<tableModel.getRowCount();i++){
        tableModel.setValueAt(i+1, i, 0);
    }
        this.tableTotalCalculation();
}
public void clear(){
    this.quantityTextField.setText("0");
    clearTable();
    generateBillButton.setEnabled(true);
    updateBillButton.setEnabled(false);
    billNoTextField.setEnabled(true);
    quantityTextField.setEnabled(true);
    this.totalAmountTextField.setText("0");
    this.paidAmountTextField.setText("0");
    this.remainingTextField.setText("0");
    this.remarksTextArea.setText("");
    this.billDateLabel.setText("");
    CHEQUECheckBox.setSelected(false);
    chequeDateChooser.setEnabled(false);
//    chequeNumberTextField.setEnabled(false);
    setMaxBillId();
}
    private void clearTable(){
        int count = this.tableModel.getRowCount();
        System.out.println(count);
        for(int i=count-1;i>=0;i--){
            this.tableModel.removeRow(i);
            System.out.println(i);
        }
    }
   private void setMaxBillId(){
       List list = DatabaseManager.getData(bean.SalePurchase.class.getName() , " SALE_PURCHASE_ID  DESC");
       if(list.isEmpty()){
           billNoTextField.setText("1");
       }else{ 
           System.out.println(((SalePurchase)list.get(0)).getSalePurchaseId() +" : "+list.size());
           billNoTextField.setText(""+((((SalePurchase)list.get(0)).getSalePurchaseId())+1) );
       }
   }
           
    private void generateBill(){
         Year yearbean = (Year)this.yearComboBox.getSelectedItem();
         Day daybean = (Day)this.dateComboBox.getSelectedItem();
         Account accountbean = (Account)this.accountsList.getSelectedValue();
         
         if(yearbean==null){
             JOptionPane.showMessageDialog(this, "There is no Year");
             return;
         }
         if(daybean==null){
             JOptionPane.showMessageDialog(this, "There is no Day");
             return;
         }
         if(accountbean==null){
             JOptionPane.showMessageDialog(this, "Please select Account");
             return;
         }
         if(CHEQUECheckBox.isSelected() && chequeDateChooser.getDate() == null){
                JOptionPane.showMessageDialog(this, "Please Select Date For cheque..");
                return;
         }
        try {
            generateBillButton.setEnabled(false);
            double totalAmount = Double.parseDouble(this.totalAmountTextField.getText());
            double paidAmount = Double.parseDouble(this.paidAmountTextField.getText());
            int count=0;
            
            if(paidAmount > totalAmount){
                JOptionPane.showMessageDialog(this, "Cannot Generate Bill.. \n Paid amount should not greater than total..");
                generateBillButton.setEnabled(true);
                return;
            }
            
            // Adding in Sale_Purchase
            bean.SalePurchase sale = new bean.SalePurchase(daybean, accountbean,totalAmount, Constant.PURCHASE, remarksTextArea.getText().trim().toUpperCase(), paidAmount );
            int salePurchaseId = DatabaseManager.addData(sale);
            System.out.println("Added in Sale Purchase");
            sale.setSalePurchaseId(salePurchaseId);
             // Adding Cheque in Database
            if(CHEQUECheckBox.isSelected()){
                Cheque cheq = new Cheque(accountbean, sale, chequeNumberTextField.getText(), chequeDateChooser.getDate(), daybean.getDay());
                DatabaseManager.addData(cheq);
                System.out.println("Checque is added...");
            }
            
            // Adding in Transaction
            int tableRow = tableModel.getRowCount();
            
            for(int i=0; i<tableRow;i++){
                
                double quantity = (Double)billTable.getValueAt(i,QUANTITY_COLUMN);
                 
                Product productBean = (Product)billTable.getValueAt( i , PRODUCT_COLUMN);
                double rate = (Double)billTable.getValueAt( i,PERRATE_COLUMN);
                Transaction tr = new Transaction(daybean, accountbean, productBean, sale, quantity, rate, Constant.PURCHASE);
                
                double oldProductQuantity = productBean.getQuantity();
                double oldOriginalRate = productBean.getOriginalRate();
                
                double totalQuantity = productBean.getQuantity() + quantity;
                double oldInvest = oldProductQuantity * oldOriginalRate;
                double newInvest = quantity*rate;
                double total = oldInvest+newInvest;
                double newOriginalRate = total / totalQuantity;
                
                productBean.setQuantity(totalQuantity);
                productBean.setCurrentRate(rate);
                productBean.setOriginalRate(newOriginalRate);
                
                DatabaseManager.addData(tr);
                DatabaseManager.updateData(productBean);
            }
            
            //Updating Daily Cash
            double c = daybean.getCash();
            daybean.setCash(c-paidAmount);
            DatabaseManager.updateData(daybean);
            
            JOptionPane.showMessageDialog(this, count + ":  Transaction added successfully...");
            clear();          
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ""+ex);
            ex.printStackTrace(System.err);
        }
        refreshProducts();
        setMaxBillId();
        generateBillButton.setEnabled(true);    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CHEQUECheckBox;
    private javax.swing.JLabel accountsLabel;
    private javax.swing.JList accountsList;
    private javax.swing.JLabel billDateLabel;
    private javax.swing.JLabel billNoLabel;
    private javax.swing.JTextField billNoTextField;
    private javax.swing.JTable billTable;
    private javax.swing.JComboBox categoryComboBox;
    private com.toedter.calendar.JDateChooser chequeDateChooser;
    private javax.swing.JTextField chequeNumberTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField currentRateTextField;
    private javax.swing.JTextField customerRateTextField;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton generateBillButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel paidAmountLabel;
    private javax.swing.JTextField paidAmountTextField;
    private javax.swing.JList productList;
    private javax.swing.JLabel productsLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JTextField remainingTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton setCustomerButton;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JLabel stockLabel1;
    private javax.swing.JTextField stockTextField;
    private javax.swing.JTextField totalAmountTextField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JComboBox unitComboBox;
    private javax.swing.JButton updateBillButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables

    private void refreshMeasurementUnit() {
        List list = DatabaseManager.getData(MeasurementUnit.class.getName(), "UNIT_NAME ASC");
        unitComboBox.removeAll();
        for(Object ob : list){
            unitComboBox.addItem(ob);
        }
    }
}
