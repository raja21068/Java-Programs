
import javax.swing.JOptionPane;

public class YearFrame extends javax.swing.JFrame {

    
    public YearFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/calender.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        yearListScrollPane = new javax.swing.JScrollPane();
        yearList = new javax.swing.JList();
        yearIdLabel = new javax.swing.JLabel();
        yearIdTextField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        currentAmountLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        yearChooser = new com.toedter.calendar.JYearChooser();
        currentAmountTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Year");
        setMinimumSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(153, 0, 0));
        mainLabel.setText("YEARLY RECORD");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(200, 10, 180, 50);

        yearList.setToolTipText("Year List");
        yearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                yearListValueChanged(evt);
            }
        });
        yearListScrollPane.setViewportView(yearList);

        getContentPane().add(yearListScrollPane);
        yearListScrollPane.setBounds(370, 80, 190, 120);

        yearIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        yearIdLabel.setText("YEAR ID");
        getContentPane().add(yearIdLabel);
        yearIdLabel.setBounds(20, 100, 70, 30);

        yearIdTextField.setEditable(false);
        yearIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(yearIdTextField);
        yearIdTextField.setBounds(130, 100, 180, 30);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        yearLabel.setText("YEAR ");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(20, 160, 70, 30);

        currentAmountLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        currentAmountLabel.setText("CURRENT AMOUNT");
        getContentPane().add(currentAmountLabel);
        currentAmountLabel.setBounds(20, 220, 110, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 284, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(76, 280, 260, 70);
        getContentPane().add(yearChooser);
        yearChooser.setBounds(130, 160, 180, 30);

        currentAmountTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        getContentPane().add(currentAmountTextField);
        currentAmountTextField.setBounds(130, 220, 180, 30);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setOpaque(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(460, 370, 87, 33);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(240, 370, 99, 33);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(350, 370, 95, 33);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(120, 370, 105, 33);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 370, 85, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(4, -26, 590, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        refreshData();
        clear();
        super.setVisible(b);
    }
    private void refreshData(){
        try{
            yearList.setListData(DatabaseManager.getYears().toArray());
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void clear(){
        this.yearIdTextField.setText("");
        this.currentAmountTextField.setText("");
        this.yearChooser.setYear(new java.util.Date().getYear()+1900);
        this.remarksTextArea.setText("");
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
//        if(currentAmountTextField.getText().isEmpty())
//        {JOptionPane.showMessageDialog(null, "Empty amount field..");
//            return;}
        int year = yearChooser.getYear();
        try{
            int amount = Integer.parseInt(currentAmountTextField.getText().trim());
            String remarks = remarksTextArea.getText();
            DatabaseManager.addYear(year, amount, remarks);
            clear();
            refreshData();
            JOptionPane.showMessageDialog(null, "year suucessfully added...");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Your amount format is invalid, please re-enter in correct form");
            currentAmountTextField.setText("");
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);}
        clear();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(yearList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a year from list..");
            return;}
        if(currentAmountTextField.getText().isEmpty())
        {JOptionPane.showMessageDialog(null, "Empty amount field..");
            return;}
        int id = Integer.parseInt(yearIdTextField.getText());
        int year = yearChooser.getYear();
        int amount = Integer.parseInt(currentAmountTextField.getText().trim());
        String remarks = remarksTextArea.getText();
        try{
            DatabaseManager.updateYear(id, year, amount, remarks);
            clear();
            refreshData();
            JOptionPane.showMessageDialog(null, "year suucessfully Updated...");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Your amount format is invalid, please re-enter in correct form");
            currentAmountTextField.setText("");
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(yearList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a year from list..");
            return;}
        int id = Integer.parseInt(yearIdTextField.getText());
        try{
            DatabaseManager.deleteYear(id);
            clear();
            refreshData();
            JOptionPane.showMessageDialog(null, "year suucessfully Deleted...");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "year can't be deleted... you have to delete first data linked with this year");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);        
    }//GEN-LAST:event_backButtonActionPerformed

    private void yearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_yearListValueChanged
        YearBean bean =(YearBean) yearList.getSelectedValue();
        if(bean==null)return;
        yearIdTextField.setText(""+bean.getYearId());
        yearChooser.setYear(bean.getYear());
        currentAmountTextField.setText(""+bean.getCurrentAmount());
        remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_yearListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel currentAmountLabel;
    private javax.swing.JTextField currentAmountTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private com.toedter.calendar.JYearChooser yearChooser;
    private javax.swing.JLabel yearIdLabel;
    private javax.swing.JTextField yearIdTextField;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JList yearList;
    private javax.swing.JScrollPane yearListScrollPane;
    // End of variables declaration//GEN-END:variables
}
