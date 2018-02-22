
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * StudentPartRegistrationFrame.java
 *
 * Created on Jan 15, 2013, 12:46:58 PM
 */
public class StudentPartRegistrationFrame extends javax.swing.JFrame {

    
    public StudentPartRegistrationFrame() {
        initComponents();
    }
    public void setVisible(boolean b){
        if(b){
            getFaculty();
        }
        super.setVisible(true);
    }
 private void getFaculty(){
        this.facultyComboBox.removeAllItems();
        try{
            java.util.Vector v = DatabaseManager.getAllFaculty();
            for(int i=0;i<v.size();i++){
                facultyComboBox.addItem(v.get(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }
   private void getDepartments(){
        FacultyBean facBean = (FacultyBean)facultyComboBox.getSelectedItem();
        if(facBean==null)return;
        departmentComboBox.removeAllItems();
        try{
            java.util.Vector vector = DatabaseManager.getAllDepartments(facBean.getFacultyId());
            for(int i =0 ;i<vector.size() ; i++){
                departmentComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
   }
   private void getPrograms(){
        DepartmentBean dBean = (DepartmentBean)departmentComboBox.getSelectedItem();
        if(dBean==null)return;
        programComboBox.removeAllItems();
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
   private void getParts(){
       BatchBean bean = (BatchBean)batchComboBox.getSelectedItem();
       if(bean==null)return;
       try{
           java.util.ArrayList<PartBean> list = DatabaseManager.getAllParts(bean.getBatchId());
           this.partComboBox.removeAllItems();
           for(int i=0;i<list.size();i++){
               partComboBox.addItem(list.get(i));
           }
       }catch(Exception ex){ex.printStackTrace();}
       
   }
   private void getStudents(){
       BatchBean bean = (BatchBean)batchComboBox.getSelectedItem();
       if(bean==null)return;
       try{
           java.util.Vector v =DatabaseManager.getAllStudents(bean.getBatchId());
           this.rollNoComboBox.removeAllItems();
           this.studentsComboBox.removeAllItems();
           for(int i=0;i<v.size();i++){
               rollNoComboBox.addItem(((StudentBean)(v.get(i))).getRollNo());
               studentsComboBox.addItem(v.get(i));
           }
       }catch(Exception ex){ex.printStackTrace();}
   }
   private void getStudentOfPart(){
       PartBean bean = (PartBean)this.partComboBox.getSelectedItem();
        if(bean==null)return;
        try{
            java.util.ArrayList students = DatabaseManager.getStudentsFromPartRgistration(bean.getPartId());
            System.out.println("Size of students  :"+students.size());
            this.rollNoList.setListData(students.toArray());
        }catch(Exception ex){ex.printStackTrace();}
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        departmentIdLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        programLabel = new javax.swing.JLabel();
        batchComboBox = new javax.swing.JComboBox();
        batchLabel = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        mainLabel = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        groupLabel = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox();
        sessionComboBox = new javax.swing.JComboBox();
        sessionLabel = new javax.swing.JLabel();
        partLabel = new javax.swing.JLabel();
        partComboBox = new javax.swing.JComboBox();
        rollNoLabel = new javax.swing.JLabel();
        rollNoComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        pasteButton = new javax.swing.JButton();
        deleteSelectedButton = new javax.swing.JButton();
        studentNameTextField = new javax.swing.JTextField();
        studentNameLabel = new javax.swing.JLabel();
        fNameTextField = new javax.swing.JTextField();
        fNameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        CNICLabel = new javax.swing.JLabel();
        rollNoTextLabel = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        cnicTextField = new javax.swing.JTextField();
        remarksTextArea = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        partTextLabel = new javax.swing.JLabel();
        partTextField = new javax.swing.JTextField();
        scratchCardLabel = new javax.swing.JLabel();
        scratchCardNoTextField = new javax.swing.JTextField();
        amountTextLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        challanNoTextLabel = new javax.swing.JLabel();
        challanTextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        dateOfPaidTextField = new javax.swing.JFormattedTextField();
        dateOfPaidLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        studentsComboBox = new javax.swing.JComboBox();
        progressBar = new javax.swing.JProgressBar();
        studentRegIdTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 570));
        setResizable(false);
        getContentPane().setLayout(null);

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        facultyLabel.setText("Faculty Name");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(20, 70, 90, 20);

        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(150, 60, 260, 30);

        departmentIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        departmentIdLabel.setText("Department name");
        getContentPane().add(departmentIdLabel);
        departmentIdLabel.setBounds(20, 100, 120, 30);

        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(150, 100, 260, 30);

        programLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        programLabel.setText("Program Name");
        getContentPane().add(programLabel);
        programLabel.setBounds(20, 150, 100, 20);

        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox);
        batchComboBox.setBounds(150, 180, 260, 30);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchLabel.setText("Batch Year");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(20, 190, 90, 20);

        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(programComboBox);
        programComboBox.setBounds(150, 140, 260, 30);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("S T U D E N T   P A R T  R E G I S T R A T I O N");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(160, 10, 330, 30);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(20, 240, 50, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Noon", "Evening" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(90, 250, 120, 20);

        groupLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        groupLabel.setText("Group");
        getContentPane().add(groupLabel);
        groupLabel.setBounds(20, 220, 70, 20);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Pre-Commerce", "No Group" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(90, 220, 120, 20);

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spring", "Fall" }));
        getContentPane().add(sessionComboBox);
        sessionComboBox.setBounds(90, 280, 120, 20);

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sessionLabel.setText("Session");
        getContentPane().add(sessionLabel);
        sessionLabel.setBounds(20, 270, 50, 30);

        partLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        partLabel.setText("Part");
        getContentPane().add(partLabel);
        partLabel.setBounds(220, 220, 70, 20);

        partComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));
        partComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                partComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(partComboBox);
        partComboBox.setBounds(290, 220, 120, 20);

        rollNoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rollNoLabel.setText("Roll No");
        getContentPane().add(rollNoLabel);
        rollNoLabel.setBounds(220, 250, 70, 20);

        getContentPane().add(rollNoComboBox);
        rollNoComboBox.setBounds(290, 250, 120, 20);

        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(rollNoList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 70, 180, 200);

        pasteButton.setText("Paste");
        pasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pasteButton);
        pasteButton.setBounds(430, 273, 180, 30);

        deleteSelectedButton.setText("Delete Selected ");
        deleteSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteSelectedButton);
        deleteSelectedButton.setBounds(220, 280, 190, 23);

        studentNameTextField.setEditable(false);
        studentNameTextField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(studentNameTextField);
        studentNameTextField.setBounds(120, 350, 290, 20);

        studentNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        studentNameLabel.setText("Student Name");
        getContentPane().add(studentNameLabel);
        studentNameLabel.setBounds(20, 350, 100, 20);

        fNameTextField.setEditable(false);
        getContentPane().add(fNameTextField);
        fNameTextField.setBounds(120, 380, 290, 20);

        fNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        fNameLabel.setText("Father Name");
        getContentPane().add(fNameLabel);
        fNameLabel.setBounds(20, 380, 90, 20);

        surnameTextField.setEditable(false);
        getContentPane().add(surnameTextField);
        surnameTextField.setBounds(120, 410, 290, 20);

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        surnameLabel.setText("Surname");
        getContentPane().add(surnameLabel);
        surnameLabel.setBounds(20, 410, 80, 20);

        CNICLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CNICLabel.setText("NIC No");
        getContentPane().add(CNICLabel);
        CNICLabel.setBounds(20, 440, 90, 16);

        rollNoTextLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rollNoTextLabel.setText("Roll No");
        getContentPane().add(rollNoTextLabel);
        rollNoTextLabel.setBounds(270, 440, 60, 20);

        rollNoTextField.setEditable(false);
        getContentPane().add(rollNoTextField);
        rollNoTextField.setBounds(320, 440, 100, 20);

        cnicTextField.setEditable(false);
        getContentPane().add(cnicTextField);
        cnicTextField.setBounds(120, 440, 140, 20);
        getContentPane().add(remarksTextArea);
        remarksTextArea.setBounds(430, 360, 180, 70);

        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(430, 340, 60, 14);

        partTextLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        partTextLabel.setText("Part");
        getContentPane().add(partTextLabel);
        partTextLabel.setBounds(430, 440, 60, 20);

        partTextField.setEditable(false);
        getContentPane().add(partTextField);
        partTextField.setBounds(470, 440, 100, 20);

        scratchCardLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        scratchCardLabel.setText("<html>Scratch<br>Card#");
        getContentPane().add(scratchCardLabel);
        scratchCardLabel.setBounds(20, 470, 60, 30);

        scratchCardNoTextField.setEditable(false);
        getContentPane().add(scratchCardNoTextField);
        scratchCardNoTextField.setBounds(120, 470, 140, 20);

        amountTextLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        amountTextLabel.setText("Amount");
        getContentPane().add(amountTextLabel);
        amountTextLabel.setBounds(270, 470, 60, 20);
        getContentPane().add(amountTextField);
        amountTextField.setBounds(320, 470, 100, 20);

        challanNoTextLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        challanNoTextLabel.setText("Challan No");
        getContentPane().add(challanNoTextLabel);
        challanNoTextLabel.setBounds(430, 470, 80, 20);
        getContentPane().add(challanTextField);
        challanTextField.setBounds(500, 470, 70, 20);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusLabel.setText("Status");
        getContentPane().add(statusLabel);
        statusLabel.setBounds(20, 500, 50, 30);

        statusComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusComboBox.setForeground(new java.awt.Color(255, 0, 102));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperary", "Legal" }));
        getContentPane().add(statusComboBox);
        statusComboBox.setBounds(120, 500, 130, 20);

        try {
            dateOfPaidTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dateOfPaidTextField.setToolTipText("");
        getContentPane().add(dateOfPaidTextField);
        dateOfPaidTextField.setBounds(350, 500, 70, 20);

        dateOfPaidLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dateOfPaidLabel.setText("Date Of Paid");
        getContentPane().add(dateOfPaidLabel);
        dateOfPaidLabel.setBounds(270, 500, 70, 20);

        updateButton.setText("Update");
        updateButton.setToolTipText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(430, 500, 120, 30);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setToolTipText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(550, 500, 57, 30);

        jLabel2.setText("Roll No");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(430, 50, 40, 14);

        studentsComboBox.setEnabled(false);
        getContentPane().add(studentsComboBox);
        studentsComboBox.setBounds(470, 50, 140, 18);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(20, 310, 590, 17);

        studentRegIdTextField.setEditable(false);
        getContentPane().add(studentRegIdTextField);
        studentRegIdTextField.setBounds(580, 440, 30, 20);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 330, 610, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        
        if(evt.getSource()==null){ return; }
        getDepartments();
}//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        getPrograms();
        
}//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        getParts();
        getStudents();
}//GEN-LAST:event_batchComboBoxItemStateChanged

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        
        getBatches();
}//GEN-LAST:event_programComboBoxItemStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String dateOfPaid = DateFormatter.FlipDateAndMonth(this.dateOfPaidTextField.getText());
        if(dateOfPaidTextField.getText().trim().length()<8){
            JOptionPane.showMessageDialog(null,"enter date of paid..");
            return;
        }
        int challanNo=0; 
        try{
            challanNo = Integer.parseInt(this.challanTextField.getText());
        }catch(Exception ex){ex.printStackTrace();}
        try{
            int stdRegId = Integer.parseInt(this.studentRegIdTextField.getText());
            int amount = Integer.parseInt(this.amountTextField.getText());
            int status = TypeEncoder.encode(this.statusComboBox.getSelectedItem().toString());
            String remarks = remarksTextArea.getText();
            DatabaseManager.updateStudentPartRegistration(stdRegId, status,challanNo,amount ,dateOfPaid, remarks);
            JOptionPane.showMessageDialog(null, "updated succesfully");
            this.getStudentOfPart();
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void pasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteButtonActionPerformed
        int totalStudents = studentsComboBox.getItemCount();
        PartBean partBean = (PartBean)this.partComboBox.getSelectedItem();
        if(totalStudents==0||partBean==null)return;
        new Thread(){
            public void run(){
                int totalStudents = studentsComboBox.getItemCount();
                PartBean partBean = (PartBean)partComboBox.getSelectedItem();
                progressBar.setMinimum(0);
                progressBar.setMaximum(totalStudents-1);
                for(int i=0;i<totalStudents;i++){
                    try{
                        StudentBean student =(StudentBean) studentsComboBox.getItemAt(i);
                        DatabaseManager.addStudentPartRegistration(student.getStudentId(), partBean.getPartId(), Constant.TEMPERARY);
                        progressBar.setValue(i);
                    }catch(Exception ex){javax.swing.JOptionPane.showMessageDialog(null,"error to save "+studentsComboBox.getItemAt(i));}
                }
                JOptionPane.showMessageDialog(null, "pasted succesfully");
                getStudentOfPart();
            }
        }.start();
    }//GEN-LAST:event_pasteButtonActionPerformed

    private void partComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_partComboBoxItemStateChanged
        getStudentOfPart();
    }//GEN-LAST:event_partComboBoxItemStateChanged

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
        StudentPartRegistrationBean bean = (StudentPartRegistrationBean)this.rollNoList.getSelectedValue();
        if(bean==null)return;
        this.studentRegIdTextField.setText(""+bean.getStudentPartRegId());
        this.studentNameTextField.setText(bean.getStudentName());
        this.fNameTextField.setText(bean.getFatherName());
        this.surnameTextField.setText(bean.getSurname());
        this.cnicTextField.setText(bean.getCNIC());
        this.rollNoTextField.setText(bean.getRollNo());
        this.partTextField.setText(""+bean.getPart());
        this.statusComboBox.setSelectedItem(TypeDecoder.decode(bean.getStatus()));
        this.challanTextField.setText(""+bean.getChallanNo());
        this.amountTextField.setText(""+bean.getAmount());
        int scratchCardId = bean.getScratchCardId();
        if(bean.getDateOfPaid()!=null){
            this.dateOfPaidTextField.setText(DateFormatter.dateToString(bean.getDateOfPaid()));
        }
        try{
            if(scratchCardId!=0){
                ScratchCardBean b =DatabaseManager.getScratchCard(scratchCardId);
                
                if(b!=null)
                this.scratchCardNoTextField.setText(b.getScratchCardNo());
            }
            
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_rollNoListValueChanged

    private void deleteSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedButtonActionPerformed
        java.util.List list =  rollNoList.getSelectedValuesList();
        for(int i=0;i<list.size();i++){
            StudentPartRegistrationBean bean = (StudentPartRegistrationBean)list.get(i);
            try{
                DatabaseManager.deleteStudentPartRegistration(bean.getStudentPartRegId());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            getStudentOfPart();
        }
    }//GEN-LAST:event_deleteSelectedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNICLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel amountTextLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JLabel challanNoTextLabel;
    private javax.swing.JTextField challanTextField;
    private javax.swing.JTextField cnicTextField;
    private javax.swing.JLabel dateOfPaidLabel;
    private javax.swing.JFormattedTextField dateOfPaidTextField;
    private javax.swing.JButton deleteSelectedButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentIdLabel;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JComboBox partComboBox;
    private javax.swing.JLabel partLabel;
    private javax.swing.JTextField partTextField;
    private javax.swing.JLabel partTextLabel;
    private javax.swing.JButton pasteButton;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JLabel programLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextField remarksTextArea;
    private javax.swing.JComboBox rollNoComboBox;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JLabel rollNoTextLabel;
    private javax.swing.JLabel scratchCardLabel;
    private javax.swing.JTextField scratchCardNoTextField;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JTextField studentRegIdTextField;
    private javax.swing.JComboBox studentsComboBox;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
