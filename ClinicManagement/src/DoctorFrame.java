
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay
 */
public class DoctorFrame extends javax.swing.JFrame {

    public DoctorFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        doctorNameTf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctorList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTa = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Doctor Frame");
        setMinimumSize(new java.awt.Dimension(607, 300));
        setResizable(false);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(102, 0, 0));
        mainLabel.setText("Doctor");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DR. Name");

        doctorNameTf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        doctorList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                doctorListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(doctorList);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Remarks");

        remarksTa.setColumns(20);
        remarksTa.setRows(5);
        jScrollPane2.setViewportView(remarksTa);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(doctorNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = doctorNameTf.getText();
        String remarks = remarksTa.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Type Doctor's Name..");
            return;
        }
        try{
            DatabaseManager.addDoctors(name, remarks);
            refreshDoctorList();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex); 
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void doctorListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_doctorListValueChanged
        try{
            DoctorsBean bean = (DoctorsBean)doctorList.getSelectedValue();
            if(bean==null)return;
            doctorNameTf.setText(bean.getDoctorName());
            remarksTa.setText(bean.getRemarks());
        }catch(NullPointerException ex){ex.printStackTrace();}
    }//GEN-LAST:event_doctorListValueChanged

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DoctorsBean bean = (DoctorsBean)doctorList.getSelectedValue();
        if(bean==null){
            JOptionPane.showMessageDialog(this, "Please select a doctors name for delete..");
            return;
        }
        try{
            DatabaseManager.deleteDoctors(bean.getDoctorId());
            refreshDoctorList();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        DoctorsBean bean = (DoctorsBean)doctorList.getSelectedValue();
        if(bean==null){
            JOptionPane.showMessageDialog(this, "Please select a doctors name for update..");
            return;
        }
        String name = doctorNameTf.getText();
        String remarks = remarksTa.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Type Doctor's Name..");
            return;
        }
        try{
            DatabaseManager.updateDoctors(bean.getDoctorId(),name,remarks);
            refreshDoctorList();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        this.doctorNameTf.setText("");
        this.remarksTa.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        try{
            refreshDoctorList();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }
    public void refreshDoctorList()throws Exception{
        ArrayList list = DatabaseManager.getAllDoctors();
        doctorList.setListData(list.toArray());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JList doctorList;
    private javax.swing.JTextField doctorNameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextArea remarksTa;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
