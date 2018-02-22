
import javax.swing.JOptionPane;

public class AccountSummaryFrame extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel leftTableModel;
    javax.swing.table.DefaultTableModel rightTableModel;
    int index=1;
    public AccountSummaryFrame() {
        initComponents();
        leftTableModel = (javax.swing.table.DefaultTableModel) this.leftTable.getModel();
        rightTableModel = (javax.swing.table.DefaultTableModel) this.rightTable.getModel();
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
private void getDatewiseAccountDetails(){
    AccountBean accountBean = (AccountBean)accountsComboBox.getSelectedItem();
    if(accountBean==null)return;
    
    if(this.fromDateFormattedTextField.getText().trim().length()==4 || this.toDateFormattedTextField.getText().trim().length()==4){
        return;
    }
    String fromDate = DateFormatter.FlipDateAndMonth(this.fromDateFormattedTextField.getText());
    String toDate = DateFormatter.FlipDateAndMonth(this.toDateFormattedTextField.getText());
    try{
        java.util.ArrayList list = DatabaseManager.getAccountDetailDatewise(accountBean.getAccountId(), fromDate, toDate);
        int credit = 0;
        int debit = 0;
        for(int i=0;i<list.size();i++){
            TransactionBean bean = (TransactionBean)list.get(i);
            if(bean.getType()==Constant.DEBIT){
                debit+=bean.getAmount();
                this.leftTableModel.addRow(new Object[]{DateFormatter.dateToString(bean.getdate()), TypeDecoder.typeDecode(bean.getType()) , bean.getAmount()});
            }
            else if(bean.getType()==Constant.CREDIT){
                credit+=bean.getAmount();
                this.rightTableModel.addRow(new Object[]{DateFormatter.dateToString(bean.getdate()), TypeDecoder.typeDecode(bean.getType()) , bean.getAmount()});
            }
        }
        this.leftTableTotalTextField.setText(""+debit);
        this.rightTableTotalTextField.setText(""+credit);
        this.finalAmountTextField.setText(""+(debit - credit));
    }catch(Exception ex){ex.printStackTrace();}
    
}
private void getYearlyAccountDetails(){
    System.out.println("Entered getYearlyAccountDetails");
    AccountBean accountBean = (AccountBean)accountsComboBox.getSelectedItem();
    YearBean yearBean = (YearBean)yearComboBox.getSelectedItem();
    if(accountBean==null)return;
    this.accountTypeLabel.setText(TypeDecoder.typeDecode(accountBean.getAccountType()));
    int credit = 0;
    int debit = 0;
    
    try{
        java.util.ArrayList salePurchaseList = DatabaseManager.getSalePurchase(accountBean.getAccountId(), yearBean.getYearId());
        for(int i=0;i<salePurchaseList.size();i++){
            SalePurchaseBean b = (SalePurchaseBean)salePurchaseList.get(i);
            credit+=b.getTotalAmount();
            this.rightTableModel.addRow(new Object[]{DateFormatter.dateToString(b.getDay()), TypeDecoder.typeDecode(b.getType()) , b.getTotalAmount()});
        }
        java.util.ArrayList list = DatabaseManager.getAccountYearlyTransactions(accountBean.getAccountId() , yearBean.getYearId());

        for(int i=0;i<list.size();i++){
            TransactionBean bean = (TransactionBean)list.get(i);
            if(bean.getType()==Constant.DEBIT){
                debit+=bean.getAmount();
                this.leftTableModel.addRow(new Object[]{DateFormatter.dateToString(bean.getdate()), TypeDecoder.typeDecode(bean.getType()) , bean.getAmount()});
            }
            else if(bean.getType()==Constant.CREDIT){
                credit+=bean.getAmount();
                this.rightTableModel.addRow(new Object[]{DateFormatter.dateToString(bean.getdate()), TypeDecoder.typeDecode(bean.getType()) , bean.getAmount()});
            }
        }
        debit+=Integer.parseInt(this.debitAmountLabel.getText());
        credit+=Integer.parseInt(this.creditAmountLabel.getText());
        this.leftTableTotalTextField.setText(""+debit);
        this.rightTableTotalTextField.setText(""+credit);
        if(debit>credit){
            this.finalAmountTextField.setText("Debit/"+(debit - credit));
        }
        else{
            this.finalAmountTextField.setText("Credit/"+(credit - debit));
        }
    }catch(Exception ex){ex.printStackTrace();}
        
}
private void clearTables(){
        int count = this.leftTableModel.getRowCount();
        for(int i=count-1;i>=0;i--){
            this.leftTableModel.removeRow(i);
        }
        count = this.rightTableModel.getRowCount();
        for(int i=count-1;i>=0;i--){
            this.rightTableModel.removeRow(i);
        }
}
private void clear(){
    clearTables();
    this.leftTableTotalTextField.setText("0");
    this.rightTableTotalTextField.setText("0");
    this.finalAmountTextField.setText("0");
}
private void getYearSalePurchase(){
    YearBean yearBean = (YearBean)yearComboBox.getSelectedItem();
    if(yearBean==null)return;
    try{
        java.util.ArrayList list = DatabaseManager.getYearlySalePurchase(yearBean.getYearId());
        int sale = 0;
        int purchase = 0;
        for(int i=0;i<list.size();i++){
            SalePurchaseBean salePurchase = (SalePurchaseBean)list.get(i);
            if(salePurchase.getType()==Constant.SALE){
                sale+=salePurchase.getTotalAmount();
                this.leftTableModel.addRow(new Object[]{DateFormatter.dateToString(salePurchase.getDay()), TypeDecoder.typeDecode(salePurchase.getType()) , salePurchase.getTotalAmount()});
            }
            else if(salePurchase.getType()==Constant.PURCHASE){
                purchase+=salePurchase.getTotalAmount();
                this.rightTableModel.addRow(new Object[]{DateFormatter.dateToString(salePurchase.getDay()), TypeDecoder.typeDecode(salePurchase.getType()) , salePurchase.getTotalAmount()});
            }
            
        }
        this.leftTableTotalTextField.setText(""+sale);
        this.rightTableTotalTextField.setText(""+purchase);
        this.finalAmountTextField.setText(""+(sale - purchase));
    }catch(Exception ex){ex.printStackTrace();}
}
private void getDatewiseSalePurchase(){
    if(this.fromDateFormattedTextField.getText().trim().length()==4 || this.toDateFormattedTextField.getText().trim().length()==4){
        return;
    }
    String fromDate = DateFormatter.FlipDateAndMonth(this.fromDateFormattedTextField.getText());
    String toDate = DateFormatter.FlipDateAndMonth(this.toDateFormattedTextField.getText());
    try{
        java.util.ArrayList list = DatabaseManager.getDatewiseSalePurchase(fromDate,toDate);
        int sale = 0;
        int purchase=0;
        for(int i=0;i<list.size();i++){
            SalePurchaseBean salePurchase = (SalePurchaseBean)list.get(i);
            if(salePurchase.getType()==Constant.SALE){
                sale+=salePurchase.getTotalAmount();
                this.leftTableModel.addRow(new Object[]{DateFormatter.dateToString(salePurchase.getDay()), TypeDecoder.typeDecode(salePurchase.getType()) , salePurchase.getTotalAmount()});
            }
            else if(salePurchase.getType()==Constant.PURCHASE){
                purchase+=salePurchase.getTotalAmount();
                this.rightTableModel.addRow(new Object[]{DateFormatter.dateToString(salePurchase.getDay()), TypeDecoder.typeDecode(salePurchase.getType()) , salePurchase.getTotalAmount()});
            }            
        }
        this.leftTableTotalTextField.setText(""+sale);
        this.rightTableTotalTextField.setText(""+purchase);
        this.finalAmountTextField.setText(""+(sale - purchase));
    }catch(Exception ex){ex.printStackTrace();}
}
private void closeAccount(){
    AccountBean accountBean = (AccountBean)accountsComboBox.getSelectedItem();
    YearBean yearBean = (YearBean)yearComboBox.getSelectedItem();
    if(accountBean==null|yearBean==null)return;
    int type = TypeEncoder.typeEncode((this.finalAmountTextField.getText()).split("/")[0]);
    int amount = Integer.parseInt((this.finalAmountTextField.getText()).split("/")[1]);
    
    try{
        AccountSummaryBean b = DatabaseManager.getAccountSummary(accountBean.getAccountId(), yearBean.getYearId());
        if(b.getAmount()==0){
            DatabaseManager.addAccounSummary(yearBean.getYearId(), accountBean.getAccountId(),amount ,type , accountBean.getRemarks()); 
            JOptionPane.showMessageDialog(null,"account succussfully closed..");
        }
        else{
            int i=JOptionPane.showConfirmDialog(null, "this account is already cloased, want to update?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(i==0){
                DatabaseManager.updateAccountSummary(yearBean.getYearId(), accountBean.getAccountId(),amount ,type , accountBean.getRemarks()); 
//                JOptionPane.showMessageDialog(null, "account succesfully updated.."+i);
            }
        }
        
    }catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(null,"some problem occured.." );
    }
    }

private void getPreviousYearAccountDetail(){
    AccountBean accountBean = (AccountBean)accountsComboBox.getSelectedItem();
    int index = yearComboBox.getSelectedIndex();
//    System.out.println("Index:"+index);
    if(index==yearComboBox.getItemCount()-1){
        this.creditAmountLabel.setText("0");
        this.debitAmountLabel.setText("0");
        return;}
    YearBean yearBean = (YearBean)yearComboBox.getItemAt(index+1);
    if(accountBean==null|yearBean==null)return;
    try{
        AccountSummaryBean bean = DatabaseManager.getAccountSummary(accountBean.getAccountId(), yearBean.getYearId());
        if(bean.getType()==Constant.CREDIT){
            this.creditAmountLabel.setText(""+(bean.getAmount()-1));
            this.debitAmountLabel.setText("0");
        }
        if(bean.getType()==Constant.DEBIT){
            this.creditAmountLabel.setText("0");
            this.debitAmountLabel.setText(""+(bean.getAmount()-1));
        }
    }catch(Exception ex){ex.printStackTrace();}
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainLabel = new javax.swing.JLabel();
        accountsLabel = new javax.swing.JLabel();
        accountsComboBox = new javax.swing.JComboBox();
        yearComboBox = new javax.swing.JComboBox();
        yearLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        toDateFormattedTextField = new javax.swing.JFormattedTextField();
        toLabel = new javax.swing.JLabel();
        fromDateFormattedTextField = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rightTable = new javax.swing.JTable();
        salePurchaseCheckBox = new javax.swing.JCheckBox();
        yearlyRadioButton = new javax.swing.JRadioButton();
        datewiseRadioButton = new javax.swing.JRadioButton();
        progressBar = new javax.swing.JProgressBar();
        closeAllAccountsButton = new javax.swing.JButton();
        closeAccountButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalLabel1 = new javax.swing.JLabel();
        leftTableTotalTextField = new javax.swing.JTextField();
        rightTableTotalTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        leftTable = new javax.swing.JTable();
        finalAmountLabel = new javax.swing.JLabel();
        finalAmountTextField = new javax.swing.JTextField();
        rightTableLabel = new javax.swing.JLabel();
        leftTableLabel = new javax.swing.JLabel();
        debitAmountLabel = new javax.swing.JLabel();
        creditAmountLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accountTypeLabel = new javax.swing.JLabel();
        chartButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Summary");
        setMinimumSize(new java.awt.Dimension(750, 552));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("ACCOUNT SUMMARY");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(240, 10, 190, 40);

        accountsLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        accountsLabel.setText("Accounts");
        getContentPane().add(accountsLabel);
        accountsLabel.setBounds(10, 60, 70, 20);

        accountsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                accountsComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(accountsComboBox);
        accountsComboBox.setBounds(80, 60, 200, 30);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(380, 60, 110, 30);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(350, 60, 50, 30);

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        dayLabel.setText("DAY");
        getContentPane().add(dayLabel);
        dayLabel.setBounds(500, 60, 30, 30);

        try {
            toDateFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        toDateFormattedTextField.setEnabled(false);
        toDateFormattedTextField.setOpaque(false);
        toDateFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDateFormattedTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(toDateFormattedTextField);
        toDateFormattedTextField.setBounds(630, 60, 70, 30);

        toLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        toLabel.setText("to");
        getContentPane().add(toLabel);
        toLabel.setBounds(610, 60, 20, 30);

        try {
            fromDateFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fromDateFormattedTextField.setEnabled(false);
        fromDateFormattedTextField.setOpaque(false);
        getContentPane().add(fromDateFormattedTextField);
        fromDateFormattedTextField.setBounds(530, 60, 70, 30);

        rightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rightTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 120, 260, 360);

        salePurchaseCheckBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salePurchaseCheckBox.setText("Sale / Purchase");
        salePurchaseCheckBox.setOpaque(false);
        salePurchaseCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salePurchaseCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(salePurchaseCheckBox);
        salePurchaseCheckBox.setBounds(580, 240, 130, 23);

        buttonGroup1.add(yearlyRadioButton);
        yearlyRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        yearlyRadioButton.setSelected(true);
        yearlyRadioButton.setText("Yearly");
        yearlyRadioButton.setOpaque(false);
        yearlyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(yearlyRadioButton);
        yearlyRadioButton.setBounds(580, 200, 90, 23);

        buttonGroup1.add(datewiseRadioButton);
        datewiseRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        datewiseRadioButton.setText("Datewise");
        datewiseRadioButton.setOpaque(false);
        datewiseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datewiseRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(datewiseRadioButton);
        datewiseRadioButton.setBounds(580, 170, 100, 23);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(570, 274, 130, 20);

        closeAllAccountsButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        closeAllAccountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/closeAll.png"))); // NOI18N
        closeAllAccountsButton.setText("Close All Accounts");
        closeAllAccountsButton.setOpaque(false);
        closeAllAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeAllAccountsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeAllAccountsButton);
        closeAllAccountsButton.setBounds(560, 310, 140, 30);

        closeAccountButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        closeAccountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/lock.png"))); // NOI18N
        closeAccountButton.setText("Close Account");
        closeAccountButton.setOpaque(false);
        closeAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeAccountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeAccountButton);
        closeAccountButton.setBounds(560, 350, 140, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(560, 390, 140, 30);

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        totalLabel.setText("Total");
        getContentPane().add(totalLabel);
        totalLabel.setBounds(310, 490, 40, 20);

        totalLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        totalLabel1.setText("Total");
        getContentPane().add(totalLabel1);
        totalLabel1.setBounds(30, 490, 40, 20);

        leftTableTotalTextField.setEnabled(false);
        getContentPane().add(leftTableTotalTextField);
        leftTableTotalTextField.setBounds(70, 490, 120, 20);

        rightTableTotalTextField.setEnabled(false);
        getContentPane().add(rightTableTotalTextField);
        rightTableTotalTextField.setBounds(350, 490, 120, 20);

        leftTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane2.setBounds(10, 122, 260, 360);

        finalAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        finalAmountLabel.setText("Final Amount");
        getContentPane().add(finalAmountLabel);
        finalAmountLabel.setBounds(600, 460, 90, 20);

        finalAmountTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
        finalAmountTextField.setEnabled(false);
        getContentPane().add(finalAmountTextField);
        finalAmountTextField.setBounds(570, 480, 130, 30);

        rightTableLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        rightTableLabel.setText("Credit");
        getContentPane().add(rightTableLabel);
        rightTableLabel.setBounds(290, 100, 60, 14);

        leftTableLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        leftTableLabel.setText("Debit");
        getContentPane().add(leftTableLabel);
        leftTableLabel.setBounds(10, 100, 60, 14);

        debitAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        debitAmountLabel.setText("0");
        debitAmountLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        debitAmountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(debitAmountLabel);
        debitAmountLabel.setBounds(204, 100, 70, 14);

        creditAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        creditAmountLabel.setText("0");
        creditAmountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(creditAmountLabel);
        creditAmountLabel.setBounds(494, 100, 60, 14);

        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1);
        jLabel1.setBounds(570, 160, 130, 70);

        accountTypeLabel.setFont(new java.awt.Font("Verdana", 3, 11));
        accountTypeLabel.setForeground(new java.awt.Color(102, 0, 102));
        getContentPane().add(accountTypeLabel);
        accountTypeLabel.setBounds(280, 60, 70, 30);

        chartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Line Chart.png"))); // NOI18N
        chartButton.setText("Chart");
        chartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartButtonActionPerformed(evt);
            }
        });
        getContentPane().add(chartButton);
        chartButton.setBounds(560, 427, 140, 30);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(-50, 0, 760, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        clear();
        YearBean bean = (YearBean)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        if(salePurchaseCheckBox.isSelected())
            this.getYearSalePurchase();
        if(!salePurchaseCheckBox.isSelected()){
            getPreviousYearAccountDetail();
            this.getYearlyAccountDetails();
        }
}//GEN-LAST:event_yearComboBoxItemStateChanged

    private void salePurchaseCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salePurchaseCheckBoxActionPerformed
        if(salePurchaseCheckBox.isSelected()){
            clear();
            this.accountsComboBox.setEnabled(false);
            this.leftTableLabel.setText("Sale");
            this.rightTableLabel.setText("Purchase");
            this.closeAccountButton.setEnabled(false);
            this.closeAllAccountsButton.setEnabled(false);
            if(this.yearlyRadioButton.isSelected()){
                this.getYearSalePurchase();}
        }
        else{
            this.accountsComboBox.setEnabled(true);
            this.leftTableLabel.setText("Debit");
            this.rightTableLabel.setText("Credit");
            this.closeAccountButton.setEnabled(true);
            this.closeAllAccountsButton.setEnabled(true);
            if(this.yearlyRadioButton.isSelected()){
                clear();
                this.getPreviousYearAccountDetail();
                this.getYearlyAccountDetails();
            }
        }
    }//GEN-LAST:event_salePurchaseCheckBoxActionPerformed

    private void datewiseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datewiseRadioButtonActionPerformed
        if(this.datewiseRadioButton.isSelected()){
            this.fromDateFormattedTextField.setEnabled(true);
            this.toDateFormattedTextField.setEnabled(true);
            this.yearComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_datewiseRadioButtonActionPerformed

    private void yearlyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyRadioButtonActionPerformed
        if(this.yearlyRadioButton.isSelected()){
            this.fromDateFormattedTextField.setEnabled(false);
            this.toDateFormattedTextField.setEnabled(false);
            this.yearComboBox.setEnabled(true);
            getYearSalePurchase();
        }
    }//GEN-LAST:event_yearlyRadioButtonActionPerformed

    private void toDateFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDateFormattedTextFieldActionPerformed
        if(this.datewiseRadioButton.isSelected() && (!this.salePurchaseCheckBox.isSelected())){
            clear();
            this.getDatewiseAccountDetails();
        }
        if(this.datewiseRadioButton.isSelected() && this.salePurchaseCheckBox.isSelected()){
            clear();
            this.getDatewiseSalePurchase();
        }
    }//GEN-LAST:event_toDateFormattedTextFieldActionPerformed

    private void accountsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_accountsComboBoxItemStateChanged
        clear();
        if(!this.salePurchaseCheckBox.isSelected()){
           getPreviousYearAccountDetail();
            getYearlyAccountDetails();      

        }
    }//GEN-LAST:event_accountsComboBoxItemStateChanged

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void closeAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeAccountButtonActionPerformed
        closeAccount();
    }//GEN-LAST:event_closeAccountButtonActionPerformed

    private void closeAllAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeAllAccountsButtonActionPerformed
            int items = accountsComboBox.getItemCount();
            progressBar.setMinimum(0);
            progressBar.setMaximum(items);
            accountsComboBox.setEnabled(false);
            yearComboBox.setEnabled(false);
            closeAccountButton.setEnabled(false);
            clearButton.setEnabled(false);
            salePurchaseCheckBox.setEnabled(false);
            for(int i=0; i<items;i++){
                accountsComboBox.setSelectedIndex(i); 
                progressBar.setValue(accountsComboBox.getSelectedIndex()+1);
                closeAccount();      
            }
            accountsComboBox.setEnabled(true);
            yearComboBox.setEnabled(true);
            closeAccountButton.setEnabled(true);
            clearButton.setEnabled(true);
            salePurchaseCheckBox.setEnabled(true);
    }//GEN-LAST:event_closeAllAccountsButtonActionPerformed

    private void chartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButtonActionPerformed
        YearBean bean = (YearBean)this.yearComboBox.getSelectedItem();
        if(bean==null)return;
        new MonthlyChart(bean).frame.setVisible(true);
    }//GEN-LAST:event_chartButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JComboBox accountsComboBox;
    private javax.swing.JLabel accountsLabel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton chartButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeAccountButton;
    private javax.swing.JButton closeAllAccountsButton;
    private javax.swing.JLabel creditAmountLabel;
    private javax.swing.JRadioButton datewiseRadioButton;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel debitAmountLabel;
    private javax.swing.JLabel finalAmountLabel;
    private javax.swing.JTextField finalAmountTextField;
    private javax.swing.JFormattedTextField fromDateFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable leftTable;
    private javax.swing.JLabel leftTableLabel;
    private javax.swing.JTextField leftTableTotalTextField;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable rightTable;
    private javax.swing.JLabel rightTableLabel;
    private javax.swing.JTextField rightTableTotalTextField;
    private javax.swing.JCheckBox salePurchaseCheckBox;
    private javax.swing.JFormattedTextField toDateFormattedTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalLabel1;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JRadioButton yearlyRadioButton;
    // End of variables declaration//GEN-END:variables
}
