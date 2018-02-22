package form;


import bean.Categeory;
import bean.MeasurementUnit;
import bean.Product;
import database.DatabaseManager;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductFrame extends javax.swing.JFrame {


    DefaultTableModel tableModel;
    
    static int QUANTITY_COLUMN = 0;
    static int AMOUNT_COLUMN = 1;
    static int DATE_COLUMN = 2;
    static int BILL_COLUMN = 3;
    static int ACCOUNT_COLUMN = 4;
    
    public ProductFrame() {
        initComponents();
        productTable.setVisible(false);
//        categoryComboBox.setVisible(false);
//        categoryLabel.setVisible(false);
        tableModel = (DefaultTableModel)tableHistory.getModel();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/product_icon_large.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        productListScrollPane = new javax.swing.JScrollPane();
        productList = new javax.swing.JList();
        productIdLabel = new javax.swing.JLabel();
        productIdTextField = new javax.swing.JTextField();
        productNameLabel = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        rateLabel = new javax.swing.JLabel();
        rateTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        rateLabel1 = new javax.swing.JLabel();
        currentRateTextField = new javax.swing.JTextField();
        categoryComboBox = new javax.swing.JComboBox();
        productNameLabel1 = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        unitComboBox = new javax.swing.JComboBox();
        productNameLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        printButton = new javax.swing.JButton();
        printAllProductButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Products");
        setMinimumSize(new java.awt.Dimension(1000, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 51));
        mainLabel.setText("Product Details");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(210, 0, 170, 50);

        productList.setToolTipText("Product List");
        productList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productListValueChanged(evt);
            }
        });
        productListScrollPane.setViewportView(productList);

        getContentPane().add(productListScrollPane);
        productListScrollPane.setBounds(380, 60, 190, 330);

        productIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        productIdLabel.setText("PRODUCT ID");
        getContentPane().add(productIdLabel);
        productIdLabel.setBounds(20, 20, 80, 30);

        productIdTextField.setEditable(false);
        productIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(productIdTextField);
        productIdTextField.setBounds(120, 20, 60, 30);

        productNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        productNameLabel.setText("PRODUCT NAME");
        getContentPane().add(productNameLabel);
        productNameLabel.setBounds(20, 100, 100, 30);

        productNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(productNameTextField);
        productNameTextField.setBounds(130, 100, 200, 30);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        quantityLabel.setText("QUANTITY");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(20, 150, 80, 30);

        quantityTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(130, 150, 200, 30);

        rateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rateLabel.setText("CURRENT RATE");
        getContentPane().add(rateLabel);
        rateLabel.setBounds(20, 260, 100, 30);

        rateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(rateTextField);
        rateTextField.setBounds(130, 210, 200, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 310, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(80, 310, 250, 70);

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

        rateLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rateLabel1.setText("<html>RATE<br>Customer</html>");
        getContentPane().add(rateLabel1);
        rateLabel1.setBounds(20, 210, 100, 30);
        getContentPane().add(currentRateTextField);
        currentRateTextField.setBounds(130, 260, 200, 30);

        categoryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(categoryComboBox);
        categoryComboBox.setBounds(130, 60, 200, 30);

        productNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        productNameLabel1.setText("History");
        getContentPane().add(productNameLabel1);
        productNameLabel1.setBounds(590, 30, 60, 30);

        categoryLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        categoryLabel.setText("CATEGORY");
        getContentPane().add(categoryLabel);
        categoryLabel.setBounds(20, 60, 100, 30);

        getContentPane().add(unitComboBox);
        unitComboBox.setBounds(440, 35, 120, 20);

        productNameLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        productNameLabel3.setText("Unit");
        getContentPane().add(productNameLabel3);
        productNameLabel3.setBounds(380, 30, 60, 30);

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Amount", "Date", "Bill #", "Account"
            }
        ));
        jScrollPane1.setViewportView(tableHistory);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 60, 400, 320);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/print-icon.png"))); // NOI18N
        printButton.setText("History");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton);
        printButton.setBounds(730, 390, 160, 40);

        printAllProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/print-icon.png"))); // NOI18N
        printAllProductButton.setText("<html>Print All<center>Products</center></html>");
        printAllProductButton.setToolTipText("Prints Rate, and product name of All Products");
        printAllProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printAllProductButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printAllProductButton);
        printAllProductButton.setBounds(590, 390, 130, 40);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Stock", "Rate", "Total"
            }
        ));
        jScrollPane2.setViewportView(productTable);
        productTable.getColumnModel().getColumn(0).setMinWidth(200);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(200);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 450, 660, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        refreshCategory();
        refreshUnit();
        clear();
        super.setVisible(b);
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
    private void clear(){
        this.productIdTextField.setText("");
        this.productNameTextField.setText("");
        this.quantityTextField.setText("0");
        this.rateTextField.setText("0");
        this.remarksTextArea.setText("");
        this.currentRateTextField.setText("0");
    }
    
    private void productListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productListValueChanged
        Product bean = (Product)productList.getSelectedValue();
        if(bean==null)return;
        this.productIdTextField.setText(""+bean.getProductId());
        this.productNameTextField.setText(bean.getProductName());
        this.quantityTextField.setText(""+bean.getQuantity());
        this.rateTextField.setText(""+bean.getRate());
        this.currentRateTextField.setText(""+bean.getCurrentRate());
        this.remarksTextArea.setText(bean.getRemarks());
        
        int total = unitComboBox.getItemCount();
        for(int i=0; i<total; i++){
            MeasurementUnit mu = (MeasurementUnit)unitComboBox.getItemAt(i);
            if(mu == bean.getMeasurementUnit()){
                unitComboBox.setSelectedItem(mu);
                break;
            }
        }
        
        refreshProductHistory(bean.getProductId());
    }//GEN-LAST:event_productListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(productNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Product name is invalid..");
            return;
        }
        String productName = this.productNameTextField.getText().trim().toUpperCase();
        if(productName.contains("'")){
            productName = productName.replaceAll("'", "\"");
            System.out.println("entered in replace");
        }
        MeasurementUnit unit = ((MeasurementUnit) unitComboBox.getSelectedItem());
        double quantity = Double.parseDouble(quantityTextField.getText());
        double rate = Double.parseDouble(rateTextField.getText());
        double currentRate = Double.parseDouble(currentRateTextField.getText());
        String remarks = remarksTextArea.getText().trim().toUpperCase();
        Categeory cat = (Categeory)categoryComboBox.getSelectedItem();
        
        try{
            DatabaseManager.addData(new Product(unit, cat, productName, rate, currentRate, currentRate, quantity, remarks));
            refreshProducts();
            clear();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Quantity / Rate format is not correct..");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
          if(productList.isSelectionEmpty()){
              JOptionPane.showMessageDialog(null, "Select a product from list..");
              return;}
          Product bean = (Product)productList.getSelectedValue();
          Categeory cat = (Categeory)categoryComboBox.getSelectedItem();
          try{
              
              bean.setCategeory(cat);
              bean.setProductName(this.productNameTextField.getText().trim().toUpperCase());
              bean.setQuantity(Double.parseDouble(this.quantityTextField.getText()));
              bean.setRate(Double.parseDouble(this.rateTextField.getText()));
              bean.setCurrentRate(Double.parseDouble(this.currentRateTextField.getText()));
              bean.setRemarks(remarksTextArea.getText().trim().toUpperCase());
              bean.setMeasurementUnit(((MeasurementUnit) unitComboBox.getSelectedItem()) );
              
              refreshCategory();
              clear();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Quantity / Rate / Current Rate format is not correct..");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        } 
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         if(productList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select a product from list..");
            return;}
        
         try{
             Product bean = (Product)productList.getSelectedValue();
             DatabaseManager.deleteData(Product.class, bean.getProductId());
             JOptionPane.showMessageDialog(null, "\""+productNameTextField.getText()+"\" Product is deleted successfully..");
             refreshCategory();
             clear();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

    private void categoryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboBoxItemStateChanged
        if(categoryComboBox.getSelectedItem() == null) return;
        refreshProducts();
        clear();
    }//GEN-LAST:event_categoryComboBoxItemStateChanged

    private void printAllProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printAllProductButtonActionPerformed
        clearInvisibleTable();
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
//        List<Product> pList = DatabaseManager.getData(Product.class.getName(), "PRODUCT_NAME ASC");
        List<Product> pList = DatabaseManager.getData("SELECT p FROM "+Product.class.getName()+" as p JOIN p.measurementUnit ORDER BY p.productName ASC");
        for(int i=0;i<pList.size();i++){
            Product prod = (Product)pList.get(i);
            String name = prod.getProductName();
            double stock = prod.getQuantity();
            double current = prod.getRate();
            int row = model.getRowCount();
            model.insertRow(row, new Object[]{name,stock +"    "+prod.getMeasurementUnit().getUnitName(),current,(stock*current)});
        }
        MessageFormat header = new MessageFormat("Product List");
        MessageFormat footer = new MessageFormat("");
        try{
            productTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Printing Error.."+ex);
         }
        clearInvisibleTable();
    }//GEN-LAST:event_printAllProductButtonActionPerformed

    public void clearInvisibleTable(){
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        int row = model.getRowCount();
        for(int i=0;i<row;i++){
            model.removeRow(0);
        }
    }
    
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        if(tableModel.getRowCount()<1){
            JOptionPane.showMessageDialog(this, "There is no row in table");
            return;
        }
        Product p = (Product)productList.getSelectedValue();
        if(p ==null){
            JOptionPane.showMessageDialog(this, "Please select any product..");
            return;
        }
        
        MessageFormat header = new MessageFormat(p.getProductName());
        MessageFormat footer = new MessageFormat("");
        try {
            tableHistory.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField currentRateTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton printAllProductButton;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JTextField productIdTextField;
    private javax.swing.JList productList;
    private javax.swing.JScrollPane productListScrollPane;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JLabel productNameLabel1;
    private javax.swing.JLabel productNameLabel3;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JLabel rateLabel1;
    private javax.swing.JTextField rateTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JTable tableHistory;
    private javax.swing.JComboBox unitComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void refreshProducts() {
        Categeory cat = (Categeory)categoryComboBox.getSelectedItem();
        if(cat == null){
            System.out.println("null at refresh products");
            return;
        }
        List list = DatabaseManager.getData(Product.class.getName(), " CATEGORY_ID = "+cat.getCategoryId(), " PRODUCT_NAME ASC ");
        productList.setListData(list.toArray());
        
    }

    private void refreshUnit() {
        unitComboBox.removeAllItems();
        List list = DatabaseManager.getData(MeasurementUnit.class.getName(), "UNIT_NAME ASC");
        for(int i=0; i<list.size();i++){
            unitComboBox.addItem(list.get(i));
        }
    }

    private void refreshProductHistory(Integer productId) {
        try{
            database.DataManager.setProductHistory(productId, tableModel, QUANTITY_COLUMN, AMOUNT_COLUMN, DATE_COLUMN, BILL_COLUMN, ACCOUNT_COLUMN);
            
        }catch(Exception ex){ex.printStackTrace();}
    }

}
