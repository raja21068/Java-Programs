import java.applet.*;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class StudentFrame extends Applet {

    MainFrame main;
    public StudentFrame(MainFrame main) {
        this.main = main;
        initComponents();
        setAllFaculty();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        facLabel = new javax.swing.JLabel();
        facNameComboBox = new javax.swing.JComboBox();
        depIdLabel = new javax.swing.JLabel();
        depNameComboBox = new javax.swing.JComboBox();
        progLabel = new javax.swing.JLabel();
        batchComboBox = new javax.swing.JComboBox();
        batchLabel = new javax.swing.JLabel();
        progNameComboBox = new javax.swing.JComboBox();
        listScroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        listLabel = new javax.swing.JLabel();
        stdIdTxt = new javax.swing.JTextField();
        stdIdLabel = new javax.swing.JLabel();
        shiftTxt = new javax.swing.JTextField();
        shiftLabel = new javax.swing.JLabel();
        groupTxt = new javax.swing.JTextField();
        groupLabel = new javax.swing.JLabel();
        stdNameTxt = new javax.swing.JTextField();
        stdNameLabel = new javax.swing.JLabel();
        fNameTxt = new javax.swing.JTextField();
        fNameLabel = new javax.swing.JLabel();
        surnameTxt = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        CNICLabel = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        rollNoLabel = new javax.swing.JLabel();
        rollNoTxt = new javax.swing.JTextField();
        cnicText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();

        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 600));
        setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("S T U D E N T   I N F O R M A T I O N");
        add(mainLabel);
        mainLabel.setBounds(160, 10, 260, 30);

        facLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facLabel.setText("Faculty Name");
        add(facLabel);
        facLabel.setBounds(20, 50, 90, 20);

        facNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facNameComboBoxItemStateChanged(evt);
            }
        });
        add(facNameComboBox);
        facNameComboBox.setBounds(150, 50, 260, 20);

        depIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        depIdLabel.setText("Department name");
        add(depIdLabel);
        depIdLabel.setBounds(20, 70, 120, 30);

        depNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depNameComboBoxItemStateChanged(evt);
            }
        });
        add(depNameComboBox);
        depNameComboBox.setBounds(150, 80, 260, 22);

        progLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        progLabel.setText("Program Name");
        add(progLabel);
        progLabel.setBounds(20, 110, 100, 20);

        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        add(batchComboBox);
        batchComboBox.setBounds(150, 150, 260, 22);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        batchLabel.setText("Batch Year");
        add(batchLabel);
        batchLabel.setBounds(20, 150, 90, 20);

        progNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                progNameComboBoxItemStateChanged(evt);
            }
        });
        add(progNameComboBox);
        progNameComboBox.setBounds(150, 110, 260, 22);

        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        listScroll.setViewportView(list);

        add(listScroll);
        listScroll.setBounds(420, 60, 190, 450);

        listLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        listLabel.setText("Student List");
        add(listLabel);
        listLabel.setBounds(460, 30, 90, 30);

        stdIdTxt.setEditable(false);
        add(stdIdTxt);
        stdIdTxt.setBounds(120, 210, 290, 20);

        stdIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        stdIdLabel.setText("Student ID");
        add(stdIdLabel);
        stdIdLabel.setBounds(20, 210, 70, 20);

        shiftTxt.setEditable(false);
        add(shiftTxt);
        shiftTxt.setBounds(260, 180, 150, 20);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        shiftLabel.setText("Shift");
        add(shiftLabel);
        shiftLabel.setBounds(220, 180, 40, 20);

        groupTxt.setEditable(false);
        add(groupTxt);
        groupTxt.setBounds(70, 180, 140, 20);

        groupLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        groupLabel.setText("Group");
        add(groupLabel);
        groupLabel.setBounds(20, 180, 50, 20);

        stdNameTxt.setFont(new java.awt.Font("Tahoma", 1, 13));
        add(stdNameTxt);
        stdNameTxt.setBounds(120, 240, 290, 20);

        stdNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        stdNameLabel.setText("Student Name");
        add(stdNameLabel);
        stdNameLabel.setBounds(20, 240, 100, 20);
        add(fNameTxt);
        fNameTxt.setBounds(120, 270, 290, 20);

        fNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        fNameLabel.setText("Father Name");
        add(fNameLabel);
        fNameLabel.setBounds(20, 270, 90, 20);
        add(surnameTxt);
        surnameTxt.setBounds(120, 300, 290, 20);

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        surnameLabel.setText("Surname");
        add(surnameLabel);
        surnameLabel.setBounds(20, 300, 80, 20);
        add(addressText);
        addressText.setBounds(120, 390, 290, 40);

        CNICLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        CNICLabel.setText("NIC No");
        add(CNICLabel);
        CNICLabel.setBounds(20, 330, 90, 16);

        remarkLbl.setText("Remarks");
        add(remarkLbl);
        remarkLbl.setBounds(20, 420, 50, 20);

        remarkScroll.setViewportView(remarkTxt);

        add(remarkScroll);
        remarkScroll.setBounds(30, 440, 380, 70);

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn);
        addBtn.setBounds(50, 520, 100, 30);

        deleteButton.setText("DEL");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        add(deleteButton);
        deleteButton.setBounds(160, 520, 100, 30);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        add(updateButton);
        updateButton.setBounds(270, 520, 100, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        add(clearButton);
        clearButton.setBounds(380, 520, 100, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(490, 520, 100, 30);

        rollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        rollNoLabel.setText("Roll No");
        add(rollNoLabel);
        rollNoLabel.setBounds(20, 360, 90, 20);
        add(rollNoTxt);
        rollNoTxt.setBounds(120, 360, 290, 20);
        add(cnicText);
        cnicText.setBounds(120, 330, 290, 20);

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        addressLabel.setText("Address");
        add(addressLabel);
        addressLabel.setBounds(20, 390, 90, 20);

       // pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if((this.stdNameTxt.getText().trim().length())<3){ 
            JOptionPane.showMessageDialog(this, "Invalid or Empty Student name");
            return;
        }
        if((this.fNameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Father's name");
            return;
        }
        if((this.surnameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Surname");
            return;
        }
        if((this.shiftTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Shift");
            return;
        }
        BatchBean bat = (BatchBean)batchComboBox.getSelectedItem();
        StudentBean stBean = new StudentBean();
        stBean.setBatchId(bat.getBatID());
        stBean.setStudentName(this.stdNameTxt.getText());
        stBean.setFName(this.fNameTxt.getText());
        stBean.setSurname(this.surnameTxt.getText());
        stBean.setRollNo(this.rollNoTxt.getText());
        stBean.setCNIC(this.cnicText.getText());
        if((this.groupTxt.getText().trim().length())<3){
            stBean.setGroup("No Group");
        }
        else {stBean.setGroup(this.groupTxt.getText());} 
        stBean.setShift(this.shiftTxt.getText());
        stBean.setAddress(this.addressText.getText());
        stBean.setRemarks(this.remarkTxt.getText());
       try{
           DatabaseManager.addStudent(stBean);
       }catch(Exception ex){ex.printStackTrace();}
        clearButtonActionPerformed(null);
        batchComboBoxItemStateChanged(null);
}//GEN-LAST:event_addBtnActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        this.stdIdTxt.setText("");
        this.stdNameTxt.setText("");
        this.fNameTxt .setText("");
        this.surnameTxt.setText("");
        this.rollNoTxt.setText("");
        this.cnicText.setText("");
        this.groupTxt.setText("");
        this.shiftTxt.setText("");
        this.addressText.setText("");
        this.remarkTxt.setText("");
}//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void facNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facNameComboBoxItemStateChanged
        // TODO add your handling code here:
        if(evt.getSource()==null){ return; }
        depNameComboBox.removeAllItems();
        FacultyBean facBean = (FacultyBean)facNameComboBox.getSelectedItem();
        try{
            Vector vector = DatabaseManager.getAllDept(facBean.factID);
            for(int i =0 ;i<vector.size() ; i++){
                depNameComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_facNameComboBoxItemStateChanged

    private void depNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depNameComboBoxItemStateChanged
        // TODO add your handling code here:
        progNameComboBox.removeAllItems();
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
        try{
            Vector vec = DatabaseManager.getAllProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                progNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_depNameComboBoxItemStateChanged

    private void progNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_progNameComboBoxItemStateChanged
        // TODO add your handling code here:
        ProgramBean progBean = (ProgramBean)progNameComboBox.getSelectedItem();
        batchComboBox.removeAllItems();
        try {
            Vector vec = DatabaseManager.getAllBatches(progBean.getProgID());
            for(int i=0; i<vec.size() ; i++){
                batchComboBox.addItem(vec.elementAt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(BatchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_progNameComboBoxItemStateChanged

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        // TODO add your handling code here:
        BatchBean batBean = (BatchBean) batchComboBox.getSelectedItem();
        list.removeAll();
        try{
            list.setListData(DatabaseManager.getAllStudents(batBean.getBatID()));
        }catch(Exception ex){ex.printStackTrace();}
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_batchComboBoxItemStateChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()== null)return;
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No name is selected from list...");
            return;}
        StudentBean stBean = (StudentBean)list.getSelectedValue();
        try{
            DatabaseManager.deleteStudent(stBean);
        }catch(Exception ex){ex.printStackTrace();}
        batchComboBoxItemStateChanged(null);
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No name is selected from list...");
            return;}
        if((this.stdNameTxt.getText().trim().length())<3){ 
            JOptionPane.showMessageDialog(this, "Invalid or Empty Student name");
            return;
        }
        if((this.fNameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Father's name");
            return;
        }
        if((this.surnameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Surname");
            return;
        }
        if((this.shiftTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid or Empty Shift");
            return;
        }
        StudentBean stBean = (StudentBean)list.getSelectedValue();
        
        stBean.setStudentName(this.stdNameTxt.getText());
        stBean.setFName(this.fNameTxt .getText());
        stBean.setSurname(this.surnameTxt.getText());
        stBean.setRollNo(this.rollNoTxt.getText());
        stBean.setCNIC(this.cnicText.getText());
        stBean.setGroup(this.groupTxt.getText());
        stBean.setShift(this.shiftTxt.getText());
        stBean.setAddress(this.addressText.getText());
        stBean.setRemarks(this.remarkTxt.getText());
        try{
            DatabaseManager.updateStudent(stBean);
        }catch(Exception ex){ex.printStackTrace();}
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        // TODO add your handling code here:
        StudentBean stBean = (StudentBean)list.getSelectedValue();
        try{
        this.stdIdTxt.setText(""+stBean.getStudentID());
        }catch(Exception ex){ex.printStackTrace();}
        this.stdNameTxt.setText(stBean.getStudentName());
        this.fNameTxt .setText(stBean.getFName());
        this.surnameTxt.setText(stBean.getSurname());
        this.rollNoTxt.setText(stBean.getRollNo());
        this.cnicText.setText(stBean.getCNIC());
        this.groupTxt.setText(stBean.getGroup());
        this.shiftTxt.setText(stBean.getShift());
        this.addressText.setText(stBean.getAddress());
        this.remarkTxt.setText(stBean.getRemarks());
    }//GEN-LAST:event_listValueChanged
    private void setAllFaculty(){
        try{
            Vector vec = DatabaseManager.getAllFaculty();
            for(int i = 0 ; i<vec.size() ;i++){
                facNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNICLabel;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField cnicText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel depIdLabel;
    private javax.swing.JComboBox depNameComboBox;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JLabel facLabel;
    private javax.swing.JComboBox facNameComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JTextField groupTxt;
    private javax.swing.JList list;
    private javax.swing.JLabel listLabel;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel progLabel;
    private javax.swing.JComboBox progNameComboBox;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNoTxt;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JTextField shiftTxt;
    private javax.swing.JLabel stdIdLabel;
    private javax.swing.JTextField stdIdTxt;
    private javax.swing.JLabel stdNameLabel;
    private javax.swing.JTextField stdNameTxt;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTxt;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
