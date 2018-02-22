import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class BatchFrame extends javax.swing.JFrame {

    MainFrame main;
    public BatchFrame(MainFrame main) {
        this.main = main;
        initComponents();

    }
    public void setVisible(boolean b){
        if(b){
            setAllFaculty();        
        }
        super.setVisible(b);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        batchList = new javax.swing.JList();
        depNameLabel = new javax.swing.JLabel();
        batchIdTextField = new javax.swing.JTextField();
        progLabel = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTxt = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        facNameLabel = new javax.swing.JLabel();
        facNameComboBox = new javax.swing.JComboBox();
        depNameComboBox = new javax.swing.JComboBox();
        batchLabel = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        progNameComboBox = new javax.swing.JComboBox();
        batchYearTextField = new javax.swing.JTextField();
        batchYearLabel = new javax.swing.JLabel();
        groupLbl = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();
        sessionLabel = new javax.swing.JLabel();
        sessionComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("B a t c h   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        batchList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                batchListValueChanged(evt);
            }
        });
        listScroll.setViewportView(batchList);

        getContentPane().add(listScroll);
        listScroll.setBounds(320, 70, 150, 290);

        depNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        depNameLabel.setText("Dept Name");
        getContentPane().add(depNameLabel);
        depNameLabel.setBounds(20, 70, 110, 30);

        batchIdTextField.setEditable(false);
        batchIdTextField.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(batchIdTextField);
        batchIdTextField.setBounds(100, 150, 210, 20);

        progLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        progLabel.setText("Program");
        getContentPane().add(progLabel);
        progLabel.setBounds(20, 110, 60, 30);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(20, 270, 50, 20);

        remarkScroll.setViewportView(remarkTxt);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(30, 290, 280, 70);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(10, 370, 90, 30);

        DeleteButton.setText("DEL");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(110, 370, 90, 30);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn);
        updateBtn.setBounds(210, 370, 90, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(310, 370, 90, 30);

        listLbl.setText("Batch List");
        getContentPane().add(listLbl);
        listLbl.setBounds(350, 40, 80, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(410, 370, 70, 30);

        facNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facNameLabel.setText("Fac Name");
        getContentPane().add(facNameLabel);
        facNameLabel.setBounds(20, 40, 70, 30);

        facNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facNameComboBox);
        facNameComboBox.setBounds(100, 50, 210, 20);

        depNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(depNameComboBox);
        depNameComboBox.setBounds(100, 80, 210, 20);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        batchLabel.setText("Batch ID");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(20, 150, 60, 20);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(20, 210, 60, 16);

        progNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                progNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(progNameComboBox);
        progNameComboBox.setBounds(100, 120, 210, 20);

        batchYearTextField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(batchYearTextField);
        batchYearTextField.setBounds(100, 180, 210, 20);

        batchYearLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        batchYearLabel.setText("Batch Year");
        getContentPane().add(batchYearLabel);
        batchYearLabel.setBounds(20, 180, 140, 20);

        groupLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        groupLbl.setText("Group");
        getContentPane().add(groupLbl);
        groupLbl.setBounds(20, 230, 110, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening", "Noon" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(100, 210, 80, 20);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Commerce", "No Group" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(100, 240, 210, 20);

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sessionLabel.setText("Session");
        getContentPane().add(sessionLabel);
        sessionLabel.setBounds(180, 210, 60, 20);

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spring", "Fall" }));
        getContentPane().add(sessionComboBox);
        sessionComboBox.setBounds(230, 210, 80, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        this.batchIdTextField.setText("");
        this.batchYearTextField.setText("");
        this.remarkTxt.setText("");
        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if((this.batchYearTextField.getText().trim().length())!=4){
            JOptionPane.showMessageDialog(this , "Invalid / Empty batch year");
            return;
        } 
        ProgramBean pBean = (ProgramBean)progNameComboBox.getSelectedItem();
        BatchBean batBean = new BatchBean();
       
        batBean.setProgId(pBean.getProgID());
        batBean.setBatchYear(Integer.parseInt(this.batchYearTextField.getText()));
        batBean.setGroup(TypeEncoder.encode(groupComboBox.getSelectedItem().toString()));
        batBean.setShift(TypeEncoder.encode(shiftComboBox.getSelectedItem().toString()));
        batBean.setSession(TypeEncoder.encode(sessionComboBox.getSelectedItem().toString()));
        batBean.setRemarks(this.remarkTxt.getText());
        try{
            DatabaseManager.addBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        
        clearButtonActionPerformed(null);
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_backButtonActionPerformed

    private void facNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facNameComboBoxItemStateChanged
        
        FacultyBean facBean = (FacultyBean)facNameComboBox.getSelectedItem();
        if(facBean==null){ return; }
        depNameComboBox.removeAllItems();
        try{
            Vector vector = DatabaseManager.getAllDepartments(facBean.getFacultyId());
            for(int i =0 ;i<vector.size() ; i++){
                depNameComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
         clearButtonActionPerformed(null);
    }//GEN-LAST:event_facNameComboBoxItemStateChanged

    private void depNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depNameComboBoxItemStateChanged
        
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
        if(dBean==null)return;
        progNameComboBox.removeAllItems();
        try{
            Vector vec = DatabaseManager.getAllProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                progNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_depNameComboBoxItemStateChanged

    private void progNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_progNameComboBoxItemStateChanged

        ProgramBean progBean = (ProgramBean)progNameComboBox.getSelectedItem();
        if(progBean==null)return;
        batchList.removeAll();
        try {
            Vector vec = DatabaseManager.getAllBatches(progBean.getProgID());
            batchList.setListData(vec);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(BatchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_progNameComboBoxItemStateChanged

    private void batchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_batchListValueChanged
        
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        if(batBean==null)return;
        try{
            this.batchIdTextField.setText(""+batBean.getBatchId());
            this.batchYearTextField.setText(""+batBean.getBatchYear());
            this.groupComboBox.setSelectedItem(TypeDecoder.decode(batBean.getGroup()));
            this.shiftComboBox.setSelectedItem(TypeDecoder.decode(batBean.getShift()));
            this.sessionComboBox.setSelectedItem(TypeDecoder.decode(batBean.getSession()));
            this.remarkTxt.setText(batBean.getRemarks());
        }catch(NullPointerException ex){System.err.println("NullPointerException at BatchFrame: 282");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_batchListValueChanged

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        if(batchList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        try{
            DatabaseManager.deleteBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
        if(batchList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        if((this.batchYearTextField.getText().trim().length())!=4){
            JOptionPane.showMessageDialog(this , "Invalid / Empty batch year");
            return;
        } 
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        batBean.setBatchYear(Integer.parseInt(this.batchYearTextField.getText()));
        batBean.setGroup(TypeEncoder.encode(groupComboBox.getSelectedItem().toString()));
        batBean.setShift(TypeEncoder.encode(shiftComboBox.getSelectedItem().toString()));
        batBean.setSession(TypeEncoder.encode(sessionComboBox.getSelectedItem().toString()));
        batBean.setRemarks(this.remarkTxt.getText());
        try{
            DatabaseManager.updateBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void setAllFaculty(){
        facNameComboBox.removeAllItems();
        try{
            Vector vec = DatabaseManager.getAllFaculty();
            for(int i = 0 ; i<vec.size() ;i++){
                facNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField batchIdTextField;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JList batchList;
    private javax.swing.JLabel batchYearLabel;
    private javax.swing.JTextField batchYearTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox depNameComboBox;
    private javax.swing.JLabel depNameLabel;
    private javax.swing.JComboBox facNameComboBox;
    private javax.swing.JLabel facNameLabel;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLbl;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel progLabel;
    private javax.swing.JComboBox progNameComboBox;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
