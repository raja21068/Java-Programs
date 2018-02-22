
import javax.swing.JOptionPane;

public class ProductFrame extends javax.swing.JFrame {


    public ProductFrame() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Products");
        setMinimumSize(new java.awt.Dimension(600, 470));
        setResizable(false);
        getContentPane().setLayout(null);
	try{
                setIconImage(javax.imageio.ImageIO.read(new java.io.File("src/pictures/product.png")));
               }catch(Exception e){e.printStackTrace();}
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

        productIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        productIdLabel.setText("PRODUCT ID");
        getContentPane().add(productIdLabel);
        productIdLabel.setBounds(20, 100, 80, 30);

        productIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(productIdTextField);
        productIdTextField.setBounds(130, 100, 200, 30);

        productNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        productNameLabel.setText("PRODUCT NAME");
        getContentPane().add(productNameLabel);
        productNameLabel.setBounds(20, 160, 100, 30);

        productNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(productNameTextField);
        productNameTextField.setBounds(130, 160, 200, 30);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        quantityLabel.setText("QUANTITY");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(20, 210, 80, 30);

        quantityTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(130, 210, 200, 30);

        rateLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        rateLabel.setText("RATE");
        getContentPane().add(rateLabel);
        rateLabel.setBounds(20, 270, 100, 30);

        rateTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(rateTextField);
        rateTextField.setBounds(130, 270, 200, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 310, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(80, 310, 250, 70);

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
        jLabel1.setBounds(0, 0, 610, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        refreshData();
        clear();
        super.setVisible(b);
    }
    private void refreshData(){
        try{
            productList.setListData(DatabaseManager.getProducts().toArray());
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
    }
    private void productListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productListValueChanged
        ProductBean bean = (ProductBean)productList.getSelectedValue();
        if(bean==null)return;
        this.productIdTextField.setText(""+bean.getProductId());
        this.productNameTextField.setText(bean.getProductName());
        this.quantityTextField.setText(""+bean.getQuantity());
        this.rateTextField.setText(""+bean.getRate());
        this.remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_productListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(productNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Product name is invalid..");
            return;
        }
        String productName = this.productNameTextField.getText();
        if(productName.contains("'")){
            productName = productName.replaceAll("'", "\"");
            System.out.println("entered in replace");
        }
        try{
            int quantity = Integer.parseInt(this.quantityTextField.getText());
            int rate = Integer.parseInt(this.rateTextField.getText());
            String remarks = remarksTextArea.getText();
            DatabaseManager.addProduct(productName, quantity, rate, remarks);
            JOptionPane.showMessageDialog(null, "\""+productName+"\" Product is added successfully..");
            refreshData();
            clear();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Quantity / Rate format is not correct..");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
          if(productList.isSelectionEmpty()){
              JOptionPane.showMessageDialog(null, "Select a product from list..");
              return;}
          int id = Integer.parseInt(this.productIdTextField.getText());
          String productName = this.productNameTextField.getText();
        try{
            int quantity = Integer.parseInt(this.quantityTextField.getText());
            int rate = Integer.parseInt(this.rateTextField.getText());
            String remarks = remarksTextArea.getText();
            DatabaseManager.updateProduct(id ,productName, quantity, rate, remarks);
            JOptionPane.showMessageDialog(null, "\""+productName+"\" Product is updated successfully..");
            refreshData();
            clear();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Quantity / Rate format is not correct..");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        } 
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         if(productList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select a product from list..");
            return;}
         int id = Integer.parseInt(this.productIdTextField.getText());
         try{
             DatabaseManager.deleteProduct(id);
             JOptionPane.showMessageDialog(null, "\""+productNameTextField.getText()+"\" Product is deleted successfully..");
             refreshData();
             clear();
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex);
         }
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JTextField productIdTextField;
    private javax.swing.JList productList;
    private javax.swing.JScrollPane productListScrollPane;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JTextField rateTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
