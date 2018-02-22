import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class StudentFrame extends javax.swing.JFrame {

    MainFrame main;
    public StudentFrame(MainFrame main) {
        this.main = main;
        initComponents();
        
    }
    public void setVisible(boolean b){
        if(b){
            setAllFaculty();
        }
        super.setVisible(b);
    }
    private void clear(){
//        this.list.setListData(new Object[]{});
        this.stdIdTxt.setText("");
        this.stdNameTxt.setText("");
        this.fNameTxt .setText("");
        this.surnameTxt.setText("");
        this.rollNoTxt.setText("");
        this.cellNoTextField.setText("");
        this.cnicText.setText("");
        this.addressText.setText("");
        this.remarksTextArea.setText("");
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
        shiftLabel = new javax.swing.JLabel();
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
        addBtn = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        rollNoLabel = new javax.swing.JLabel();
        rollNoTxt = new javax.swing.JTextField();
        cnicText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        shiftComboBox = new javax.swing.JComboBox();
        cellNoLabel = new javax.swing.JLabel();
        cellNoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        sessionLabel = new javax.swing.JLabel();
        sessionComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 600));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("S T U D E N T   I N F O R M A T I O N");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(160, 10, 260, 30);

        facLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        facLabel.setText("Faculty Name");
        getContentPane().add(facLabel);
        facLabel.setBounds(20, 50, 90, 20);

        facNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facNameComboBox);
        facNameComboBox.setBounds(150, 50, 260, 20);

        depIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        depIdLabel.setText("Department name");
        getContentPane().add(depIdLabel);
        depIdLabel.setBounds(20, 70, 120, 30);

        depNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(depNameComboBox);
        depNameComboBox.setBounds(150, 80, 260, 20);

        progLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        progLabel.setText("Program Name");
        getContentPane().add(progLabel);
        progLabel.setBounds(20, 110, 100, 20);

        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox);
        batchComboBox.setBounds(110, 150, 110, 20);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchLabel.setText("Batch Year");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(20, 150, 90, 20);

        progNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                progNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(progNameComboBox);
        progNameComboBox.setBounds(150, 110, 260, 20);

        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        listScroll.setViewportView(list);

        getContentPane().add(listScroll);
        listScroll.setBounds(420, 60, 190, 450);

        listLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        listLabel.setText("Student List");
        getContentPane().add(listLabel);
        listLabel.setBounds(460, 30, 90, 30);

        stdIdTxt.setEditable(false);
        getContentPane().add(stdIdTxt);
        stdIdTxt.setBounds(120, 210, 290, 20);

        stdIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        stdIdLabel.setText("Student ID");
        getContentPane().add(stdIdLabel);
        stdIdLabel.setBounds(20, 210, 70, 20);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(230, 180, 50, 20);

        groupLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        groupLabel.setText("Group");
        getContentPane().add(groupLabel);
        groupLabel.setBounds(20, 180, 50, 20);

        stdNameTxt.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(stdNameTxt);
        stdNameTxt.setBounds(120, 240, 290, 20);

        stdNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        stdNameLabel.setText("Student Name");
        getContentPane().add(stdNameLabel);
        stdNameLabel.setBounds(20, 240, 100, 20);
        getContentPane().add(fNameTxt);
        fNameTxt.setBounds(120, 270, 290, 20);

        fNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fNameLabel.setText("Father Name");
        getContentPane().add(fNameLabel);
        fNameLabel.setBounds(20, 270, 90, 20);
        getContentPane().add(surnameTxt);
        surnameTxt.setBounds(120, 300, 290, 20);

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        surnameLabel.setText("Surname");
        getContentPane().add(surnameLabel);
        surnameLabel.setBounds(20, 300, 80, 20);
        getContentPane().add(addressText);
        addressText.setBounds(120, 390, 290, 40);

        CNICLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CNICLabel.setText("NIC No");
        getContentPane().add(CNICLabel);
        CNICLabel.setBounds(20, 330, 90, 16);

        remarkLbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(20, 440, 70, 20);

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(50, 520, 100, 30);

        deleteButton.setText("DEL");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(160, 520, 100, 30);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(270, 520, 100, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(380, 520, 100, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(490, 520, 100, 30);

        rollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rollNoLabel.setText("Roll No");
        getContentPane().add(rollNoLabel);
        rollNoLabel.setBounds(20, 360, 90, 20);
        getContentPane().add(rollNoTxt);
        rollNoTxt.setBounds(120, 360, 90, 20);
        getContentPane().add(cnicText);
        cnicText.setBounds(120, 330, 290, 20);

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addressLabel.setText("Address");
        getContentPane().add(addressLabel);
        addressLabel.setBounds(20, 390, 90, 20);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Commerce", "No Group" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(110, 180, 110, 20);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening", "Noon" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(280, 180, 130, 20);

        cellNoLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cellNoLabel.setText("Cell No");
        getContentPane().add(cellNoLabel);
        cellNoLabel.setBounds(220, 360, 60, 20);
        getContentPane().add(cellNoTextField);
        cellNoTextField.setBounds(280, 360, 130, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 440, 290, 70);

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        sessionLabel.setText("Session");
        getContentPane().add(sessionLabel);
        sessionLabel.setBounds(230, 150, 60, 20);

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spring", "Fall" }));
        getContentPane().add(sessionComboBox);
        sessionComboBox.setBounds(280, 150, 130, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-643)/2, (screenSize.height-593)/2, 643, 593);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
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
        Batch bat = (Batch)batchComboBox.getSelectedItem();
        
        int batchId = bat.getBatchID();
        String studentName = this.stdNameTxt.getText();
        String fatherName = (this.fNameTxt.getText());
        String surname = (this.surnameTxt.getText());
        String rollNo = (this.rollNoTxt.getText());
        String cnic = (this.cnicText.getText());
        String cellNo = (this.cellNoTextField.getText());
        int group = TypeEncoder.encode(groupComboBox.getSelectedItem().toString());
         
        int shift = (TypeEncoder.encode(shiftComboBox.getSelectedItem().toString()));
        String address = (this.addressText.getText());
        String remarks = (this.remarksTextArea.getText());
       try{
           DatabaseManager.addStudent(batchId, studentName, fatherName, surname, cnic, rollNo, cellNo, group, shift, address, remarks);
       }catch(Exception ex){ex.printStackTrace();}
        clear();
        batchComboBoxItemStateChanged(null);
}//GEN-LAST:event_addBtnActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void facNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facNameComboBoxItemStateChanged
        // TODO add your handling code here:
        clear();
        Faculty facBean = (Faculty)facNameComboBox.getSelectedItem();
        if(facBean==null)return;
        this.list.setListData(new java.util.Vector());
        depNameComboBox.removeAllItems();
        try{
            ArrayList vector = DatabaseManager.getDepartment(facBean.getFactId());
            for(int i =0 ;i<vector.size() ; i++){
                depNameComboBox.addItem(vector.get(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_facNameComboBoxItemStateChanged

    private void depNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depNameComboBoxItemStateChanged
        
        Department dBean = (Department)depNameComboBox.getSelectedItem();
        if(dBean==null)return;
        progNameComboBox.removeAllItems();
        try{
            ArrayList vec = DatabaseManager.getProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                progNameComboBox.addItem(vec.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_depNameComboBoxItemStateChanged

    private void progNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_progNameComboBoxItemStateChanged
        
        Program progBean = (Program)progNameComboBox.getSelectedItem();
        if(progBean==null)return;
        batchComboBox.removeAllItems();
        try {
            ArrayList vec = DatabaseManager.getBatch(progBean.getProgID());
            for(int i=0; i<vec.size() ; i++){
                batchComboBox.addItem(vec.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(BatchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_progNameComboBoxItemStateChanged

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        
        Batch batBean = (Batch) batchComboBox.getSelectedItem();
        if(batBean==null)return;
        //        list.removeAll();
        try{
            this.sessionComboBox.setSelectedItem(TypeDecoder.decode(batBean.getSession()));
            ArrayList v = DatabaseManager.getStudent(batBean.getBatchID());
            if(v==null)list.setListData(v.toArray());               
            else list.setListData(v.toArray());
        }catch(Exception ex){ex.printStackTrace();}
//        clear();
    }//GEN-LAST:event_batchComboBoxItemStateChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()== null)return;
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No name is selected from list...");
            return;}
        Student stBean = (Student)list.getSelectedValue();
        try{
            DatabaseManager.deleteStudent(stBean.getStudentId());
        }catch(Exception ex){ex.printStackTrace();}
        batchComboBoxItemStateChanged(null);
        clear();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

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
        Batch bat = (Batch) batchComboBox.getSelectedItem();
        Student stBean = (Student)list.getSelectedValue();
        
        String student = (this.stdNameTxt.getText());
        String fatherName = (this.fNameTxt .getText());
        String surname = (this.surnameTxt.getText());
        String rollNo = (this.rollNoTxt.getText());
        String CNIC = (this.cnicText.getText());
        String cellNo = (this.cellNoTextField.getText());
        int group = (TypeEncoder.encode(groupComboBox.getSelectedItem().toString()));
        int  shift = (TypeEncoder.encode(this.shiftComboBox.getSelectedItem().toString()));
        String address = (this.addressText.getText());
        String remarks = (this.remarksTextArea.getText());
        try{
            DatabaseManager.updateStudent(bat.getBatchID(), stBean.getBatchID(), student,fatherName, surname, CNIC, rollNo, cellNo, group, shift, address, remarks);
        }catch(Exception ex){ex.printStackTrace();}
        clear();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        
        Student stBean = (Student)list.getSelectedValue();
        if(stBean==null)return;
       
        this.stdIdTxt.setText(""+stBean.getStudentId());
        this.stdNameTxt.setText(stBean.getStudentName());
        this.fNameTxt .setText(stBean.getFName());
        this.surnameTxt.setText(stBean.getSurname());
        this.rollNoTxt.setText(stBean.getRollNo());
        this.cellNoTextField.setText(stBean.getCellNo());
        this.cnicText.setText(stBean.getCNIC());
        this.groupComboBox.setSelectedItem(TypeDecoder.decode(stBean.getGroup()));
        this.shiftComboBox.setSelectedItem(TypeDecoder.decode(stBean.getShift()));
        this.addressText.setText(stBean.getAddress());
        this.remarksTextArea.setText(stBean.getRemarks());
    }//GEN-LAST:event_listValueChanged
    private void setAllFaculty(){
        try{
            ArrayList vec = DatabaseManager.getFaculty();
            for(int i = 0 ; i<vec.size() ;i++){
                facNameComboBox.addItem(vec.get(i));
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
    private javax.swing.JLabel cellNoLabel;
    private javax.swing.JTextField cellNoTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField cnicText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel depIdLabel;
    private javax.swing.JComboBox depNameComboBox;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JLabel facLabel;
    private javax.swing.JComboBox facNameComboBox;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list;
    private javax.swing.JLabel listLabel;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel progLabel;
    private javax.swing.JComboBox progNameComboBox;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNoTxt;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JLabel stdIdLabel;
    private javax.swing.JTextField stdIdTxt;
    private javax.swing.JLabel stdNameLabel;
    private javax.swing.JTextField stdNameTxt;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTxt;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
