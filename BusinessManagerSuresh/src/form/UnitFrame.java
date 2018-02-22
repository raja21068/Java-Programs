package form;

import bean.MeasurementUnit;
import database.DatabaseManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay Kumar
 */
public class UnitFrame extends javax.swing.JFrame {

    /**
     * Creates new form UnitFrame
     */
    public UnitFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        productNameLabel = new javax.swing.JLabel();
        unitNameTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        unitList = new javax.swing.JList();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        remarksLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(560, 350));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(102, 0, 0));
        mainLabel.setText("Measurement Unit");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(200, 10, 200, 50);

        productNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        productNameLabel.setText("UNIT NAME");
        getContentPane().add(productNameLabel);
        productNameLabel.setBounds(20, 100, 100, 30);

        unitNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(unitNameTextField);
        unitNameTextField.setBounds(130, 100, 200, 30);

        unitList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                unitListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(unitList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(360, 80, 140, 180);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(80, 170, 250, 70);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(20, 170, 60, 20);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(10, 270, 90, 30);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(110, 270, 105, 30);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(220, 270, 100, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(330, 270, 110, 30);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(450, 270, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_unitListValueChanged
        MeasurementUnit cat = (MeasurementUnit)unitList.getSelectedValue();
        if(cat==null)return;
        unitNameTextField.setText(cat.getUnitName());
        remarksTextArea.setText(cat.getRemarks());
    }//GEN-LAST:event_unitListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(unitNameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Unit name is invalid..");
            return;
        }
        String catName = this.unitNameTextField.getText().trim().toUpperCase();
        if(catName.contains("'")){
            catName = catName.replaceAll("'", "\"");
            System.out.println("entered in replace");
        }
        String remarks = remarksTextArea.getText().trim().toUpperCase();
        try{
            DatabaseManager.addData(new bean.MeasurementUnit(catName, remarks));
            refreshData();
            clear();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(unitList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select a Unit from list..");
            return;}

        MeasurementUnit cat = (MeasurementUnit)unitList.getSelectedValue();
        String catName = this.unitNameTextField.getText().trim().toUpperCase();
        if(catName.contains("'")){
            catName = catName.replaceAll("'", "\"");
            System.out.println("entered in replace");
        }
        String remarks = remarksTextArea.getText().trim().toUpperCase();
        cat.setUnitName(catName);
        cat.setRemarks(remarks);
        try{
            DatabaseManager.updateData(cat);
            refreshData();
            clear();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(unitList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Select a unit from list..");
            return;}
        MeasurementUnit cat = (MeasurementUnit)unitList.getSelectedValue();

        try{

            DatabaseManager.deleteData(MeasurementUnit.class, cat.getUnitId());
            refreshData();
            clear();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JList unitList;
    private javax.swing.JTextField unitNameTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void refreshData() {
        unitList.setListData(DatabaseManager.getData(MeasurementUnit.class.getName(), "UNIT_NAME ASC").toArray());
    }

    private void clear() {
        this.unitNameTextField.setText("");
        this.remarksTextArea.setText("");
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if(b)refreshData();
        clear();
    }
    
    
}