/**
 * @author Jay
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PatientFrame extends javax.swing.JFrame {

    ArrayList days=null;
    javax.swing.table.DefaultTableModel tableModel;
    
    public PatientFrame() {
        initComponents();
        tableModel = (javax.swing.table.DefaultTableModel) this.patientTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        doctorsComboBox = new javax.swing.JComboBox();
        patientNameTf = new javax.swing.JTextField();
        diseaseTf = new javax.swing.JTextField();
        dispancyNameTf = new javax.swing.JTextField();
        diagnosicTf = new javax.swing.JTextField();
        labTestTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        dayComboBox = new javax.swing.JComboBox();
        payementFormattedTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1053, 506));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DR. Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Patient Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Dispancy Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Disease");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Diagnosic");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("LAB Testing");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Payment");

        doctorsComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        doctorsComboBox.setToolTipText("");

        patientNameTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        diseaseTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        dispancyNameTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        diagnosicTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        labTestTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Today's Patients");

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(102, 0, 0));
        mainLabel.setText("PATIENT SHEET");

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P.No", "Dr. Name", "Patient Name", "Dispancy Name", "Disease", "Diagnosic", "Lab", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        patientTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(patientTable);
        patientTable.getColumnModel().getColumn(0).setMinWidth(25);
        patientTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        patientTable.getColumnModel().getColumn(0).setMaxWidth(25);

        dayComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayComboBoxItemStateChanged(evt);
            }
        });

        payementFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        payementFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payementFormattedTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel8)
                        .addGap(455, 455, 455))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diagnosicTf))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(doctorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diseaseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dispancyNameTf)
                                    .addComponent(patientNameTf)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addComponent(labTestTf)))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(5, 5, 5)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(payementFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientNameTf, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dispancyNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(diseaseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(diagnosicTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labTestTf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(payementFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {doctorsComboBox, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, patientNameTf});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DayBean day = (DayBean)dayComboBox.getSelectedItem();
        DoctorsBean doctor = (DoctorsBean)doctorsComboBox.getSelectedItem();
        if(day==null){
            JOptionPane.showMessageDialog(this, "All dates in database are closed, please add a new day/ date");
            return;    
        }
        if(doctor==null){
            JOptionPane.showMessageDialog(this, "There is no any doctor in database, please enter a doctor name in 'Add Doctor'");
            return;
        }
        String patientName = patientNameTf.getText();
        String dispancy = dispancyNameTf.getText();
        String disease = diseaseTf.getText();
        String diagnosic = diagnosicTf.getText();
        String lab = labTestTf.getText();
        String pay = payementFormattedTextField.getText().trim();
        
        if(patientName.equals("")){
            JOptionPane.showMessageDialog(this,"Enter atleast patient name");
            return;
        }
        try{
            int transactionID = DatabaseManager.addTransaction(day.getDayId(),doctor.getDoctorId(), patientName, dispancy, disease, diagnosic, lab, Integer.parseInt(pay));
            int row=tableModel.getRowCount();
            PatientBean newbean = new PatientBean();
            newbean.setDayId(day.getDayId());
            newbean.setDignosic(diagnosic);
            newbean.setDisease(disease);
            newbean.setDispancy(dispancy);
            newbean.setDoctorName(doctor.getDoctorName());
            newbean.setLab(lab);
            newbean.setPatientName(patientName);
            newbean.setPayment(Integer.parseInt(pay));
            newbean.setTransactionId(transactionID);
            addRowInTable(row+1,doctor.getDoctorName(), newbean, dispancy, disease, diagnosic, lab, Integer.parseInt(pay));
            clear();
        }catch(NumberFormatException ex){
          JOptionPane.showMessageDialog(this,"Invalid amount");
          payementFormattedTextField.setText("0");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] rows =  patientTable.getSelectedRows();
        if(rows.length <=0){
            JOptionPane.showMessageDialog(this, "Please select atleast one row from table");
        }
        for(int i=0;i<rows.length;i++){
            PatientBean bean=(PatientBean)this.tableModel.getValueAt(this.patientTable.getSelectedRow(), 2);
            System.out.println(bean.getTransactionId());
            try {
                DatabaseManager.deleteTransaction(bean.getTransactionId());
                this.tableModel.removeRow(this.patientTable.getSelectedRow());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog( null, ex);
                ex.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void dayComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayComboBoxItemStateChanged
        try {
            clearTable();
            refreshPatientTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_dayComboBoxItemStateChanged

    private void payementFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payementFormattedTextFieldActionPerformed
        addButtonActionPerformed(evt);
    }//GEN-LAST:event_payementFormattedTextFieldActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        try {
        if(b){
            refreshDoctor();
            days = DatabaseManager.getAllUnclosedDay();
            dayComboBox.removeAllItems();
            for(int i=0;i<days.size();i++){
                dayComboBox.addItem(days.get(i));
            }
            clearTable();
            refreshPatientTable();
            
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }
    private void refreshDoctor()throws Exception{
        doctorsComboBox.removeAllItems();
        ArrayList list = DatabaseManager.getAllDoctors();
        for(int i=0;i<list.size();i++){
            doctorsComboBox.addItem(list.get(i));
        }
    }
    private void refreshPatientTable()throws Exception{
        DayBean bean = (DayBean)dayComboBox.getSelectedItem();
        if(bean==null){
            return;
        }
        ArrayList list = DatabaseManager.getAllTransaction(bean.getDayId());
        for(int i=0;i<list.size();i++){
            PatientBean pBean = (PatientBean)list.get(i);
            addRowInTable(i+1, pBean.getDoctorName(), pBean, pBean.getDispancy(), pBean.getDisease(), pBean.getDignosic(), pBean.getLab(), pBean.getPayment());
        }
    }
    private void clearTable(){
        int rows=tableModel.getRowCount();
        for(int i=0;i<rows;i++){
            tableModel.removeRow(0);
        }
    }
    private void clear(){
        patientNameTf.setText("");
        dispancyNameTf.setText("");
        diseaseTf.setText("");
        diagnosicTf.setText("");
        labTestTf.setText("");
        payementFormattedTextField.setText("");
    }
    
    private void addRowInTable(int serialNo ,String doctor,PatientBean patient, String dispancy,String disease,String diag,String lab,int pay){
        int row=tableModel.getRowCount();
        tableModel.insertRow(tableModel.getRowCount(),new Object[]{});
        tableModel.setValueAt(serialNo,row,0);
        tableModel.setValueAt(doctor,row,1);
        tableModel.setValueAt(patient,row,2);
        tableModel.setValueAt(dispancy,row,3);
        tableModel.setValueAt(disease,row,4);
        tableModel.setValueAt(diag,row,5);
        tableModel.setValueAt(lab,row,6);
        tableModel.setValueAt(pay,row,7);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField diagnosicTf;
    private javax.swing.JTextField diseaseTf;
    private javax.swing.JTextField dispancyNameTf;
    private javax.swing.JComboBox doctorsComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField labTestTf;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField patientNameTf;
    private javax.swing.JTable patientTable;
    private javax.swing.JFormattedTextField payementFormattedTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
