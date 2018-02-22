
import javax.swing.JOptionPane;

/*
 * PartFrame.java
 *
 * Created on Jan 14, 2013, 6:20:20 PM
 */
public class PartFrame extends javax.swing.JFrame {

    
    public PartFrame() {
        initComponents();
    }
    public void setVisible(boolean b){
        if(b){
            getDepartments();
        }
        super.setVisible(b);
    }
    
    private void getDepartments(){
        
            this.departmentComboBox.removeAllItems();
        try{
            java.util.Vector vector = DatabaseManager.getAllDepartments();
            for(int i =0 ;i<vector.size() ; i++){
                departmentComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
   }
    
   private void getPrograms(){
        DepartmentBean dBean = (DepartmentBean)departmentComboBox.getSelectedItem();
        if(dBean==null)return;
        this.programComboBox.removeAllItems();
        try{
            java.util.Vector vec = DatabaseManager.getAllProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                programComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
   }
   private void getBatches(){
        ProgramBean progBean = (ProgramBean)programComboBox.getSelectedItem();
        if(progBean==null)return;
        batchComboBox.removeAllItems();
        try {
            java.util.Vector vec = DatabaseManager.getAllBatches(progBean.getProgID());
            for(int i=0; i<vec.size() ; i++){
                batchComboBox.addItem(vec.elementAt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
          }
   }
   private void getAllPartsAndDetail(){
       BatchBean bean = (BatchBean)batchComboBox.getSelectedItem();
       if(bean==null)return;
       groupComboBox.setSelectedItem(TypeDecoder.decode(bean.getGroup()));
       sessionComboBox.setSelectedItem(TypeDecoder.decode(bean.getSession()));
       shiftComboBox.setSelectedItem(TypeDecoder.decode(bean.getShift()));
       bean.getRemarks();
       try{
           this.partsList.setListData((DatabaseManager.getAllParts(bean.getBatchId())).toArray());
       }catch(Exception ex){ex.printStackTrace();}
   }
   private void clear(){
       this.partIdTextField.setText("");
       this.partYearTextField.setText("");
       this.remarksTextArea.setText("");
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        batchLabel = new javax.swing.JLabel();
        batchComboBox = new javax.swing.JComboBox();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        programLabel = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        shiftLabel = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        partIdLabel = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        sessionLabel = new javax.swing.JLabel();
        sessionComboBox = new javax.swing.JComboBox();
        groupLabel = new javax.swing.JLabel();
        partIdTextField = new javax.swing.JTextField();
        partYearLabel = new javax.swing.JLabel();
        partYearTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        partLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        partsList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parts");
        setMinimumSize(new java.awt.Dimension(700, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        titleLabel.setForeground(new java.awt.Color(0, 0, 153));
        titleLabel.setText("PART");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(300, 20, 60, 20);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        batchLabel.setText("Batch");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(10, 220, 70, 20);

        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox);
        batchComboBox.setBounds(100, 210, 120, 30);

        departmentLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        departmentLabel.setText("Department");
        getContentPane().add(departmentLabel);
        departmentLabel.setBounds(10, 90, 80, 20);

        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(100, 80, 290, 30);

        programLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        programLabel.setText("Program");
        getContentPane().add(programLabel);
        programLabel.setBounds(10, 150, 70, 20);

        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(programComboBox);
        programComboBox.setBounds(100, 150, 290, 30);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(220, 210, 50, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Noon", "Evening" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(270, 210, 120, 30);

        partIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        partIdLabel.setText("Part ID");
        getContentPane().add(partIdLabel);
        partIdLabel.setBounds(10, 326, 70, 14);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Pre-Commerce", "No Group" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(100, 270, 120, 30);

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        sessionLabel.setText("Session");
        getContentPane().add(sessionLabel);
        sessionLabel.setBounds(220, 270, 50, 30);

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spring", "Fall" }));
        getContentPane().add(sessionComboBox);
        sessionComboBox.setBounds(270, 270, 120, 30);

        groupLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        groupLabel.setText("Group");
        getContentPane().add(groupLabel);
        groupLabel.setBounds(10, 280, 70, 20);

        partIdTextField.setEditable(false);
        getContentPane().add(partIdTextField);
        partIdTextField.setBounds(100, 320, 120, 20);

        partYearLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        partYearLabel.setText("Part Year");
        getContentPane().add(partYearLabel);
        partYearLabel.setBounds(220, 320, 60, 20);
        getContentPane().add(partYearTextField);
        partYearTextField.setBounds(280, 320, 110, 20);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 400, 70, 20);

        partComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
        getContentPane().add(partComboBox);
        partComboBox.setBounds(100, 360, 120, 30);

        partLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        partLabel.setText("Part");
        getContentPane().add(partLabel);
        partLabel.setBounds(10, 360, 70, 30);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 400, 310, 70);

        partsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                partsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(partsList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 70, 230, 320);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(420, 400, 110, 30);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(540, 400, 110, 30);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(420, 440, 110, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(540, 440, 110, 30);

        backButton.setFont(new java.awt.Font("Tahoma", 0, 6));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setToolTipText("Back");
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(650, 400, 30, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        clear();
        getPrograms();
    }//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        getBatches();
    }//GEN-LAST:event_programComboBoxItemStateChanged

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        
        getAllPartsAndDetail();
    }//GEN-LAST:event_batchComboBoxItemStateChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        BatchBean batch = (BatchBean)this.batchComboBox.getSelectedItem();
        if(batch==null)return;
        int batchId = batch.getBatchId();
        int partYear = batch.getBatchYear();
        String remarks = batch.getRemarks();
        try{
            DatabaseManager.addAllParts(batchId, partYear, Integer.parseInt(this.partComboBox.getSelectedItem().toString()), remarks);
            JOptionPane.showMessageDialog(null, "All parts are added in database..");
            getAllPartsAndDetail();
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        PartBean bean = (PartBean)this.partsList.getSelectedValue();
        if(bean==null)return;
        try{
            DatabaseManager.deletePart(bean.getPartId());
            JOptionPane.showMessageDialog(null, "part is deleted succesfully..");
            getAllPartsAndDetail();
        }catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        PartBean bean = (PartBean)this.partsList.getSelectedValue();
        if(bean==null)return;
        int part = Integer.parseInt(this.partComboBox.getSelectedItem().toString());
        try{
            DatabaseManager.updatePart(bean.getPartId(),part , Integer.parseInt(partYearTextField.getText()), remarksTextArea.getText());
            JOptionPane.showMessageDialog(this, "updates succesfully");
            clear();
        }catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void partsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_partsListValueChanged
        PartBean bean = (PartBean)this.partsList.getSelectedValue();
        if(bean==null)return;
        this.partComboBox.setSelectedItem(bean.getPart());
        this.partIdTextField.setText(""+bean.getPartId());
        this.partYearTextField.setText(""+bean.getPartYear());
        this.remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_partsListValueChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JLabel partIdLabel;
    private javax.swing.JTextField partIdTextField;
    private javax.swing.JLabel partLabel;
    private javax.swing.JLabel partYearLabel;
    private javax.swing.JTextField partYearTextField;
    private javax.swing.JList partsList;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JLabel programLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
