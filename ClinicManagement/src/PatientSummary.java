
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay
 */
public class PatientSummary extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel tableModel;
    
    public PatientSummary() {
        initComponents();
        tableModel = (javax.swing.table.DefaultTableModel) this.patientTable.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closingBalanceLabel = new javax.swing.JLabel();
        todateFormattedTextField = new javax.swing.JFormattedTextField();
        closingBalanceLabel1 = new javax.swing.JLabel();
        dateFormattedTextField = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchByNameButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        patientNameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Summary");
        setMinimumSize(new java.awt.Dimension(710, 426));

        closingBalanceLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closingBalanceLabel.setText("Date");

        try {
            todateFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        closingBalanceLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        closingBalanceLabel1.setText("To");

        try {
            dateFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P.No", "Dr. Name", "Patient Name", "Dispancy Name", "Disease", "Diagnosic", "Lab", "Payment", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        patientTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(patientTable);
        patientTable.getColumnModel().getColumn(0).setPreferredWidth(30);

        searchButton.setText("search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("PATIENT SIMMARY");

        searchByNameButton.setText("Search");
        searchByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Patient Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchByNameButton)
                .addGap(122, 122, 122)
                .addComponent(closingBalanceLabel)
                .addGap(10, 10, 10)
                .addComponent(dateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(closingBalanceLabel1)
                .addGap(4, 4, 4)
                .addComponent(todateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(searchButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(closingBalanceLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(dateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(closingBalanceLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(todateFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchByNameButton)
                            .addComponent(jLabel2)
                            .addComponent(patientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String date = dateFormattedTextField.getText();
        String todate = todateFormattedTextField.getText();
        if(date.trim().length()<8 || todate.trim().length()<8){
            JOptionPane.showMessageDialog(this,"Invalid date format.. please enter date form like this [ 01-05-2013 ]");
            return;
        }
        try{
            ArrayList list = DatabaseManager.getPatientsSummary(DateFormatter.FlipDateAndMonth(date), DateFormatter.FlipDateAndMonth(todate));
            clearTable();
            for(int i=0;i<list.size();i++){
                PatientBean pBean = (PatientBean)list.get(i);
                addRowInTable(i+1, pBean.getDoctorName(), pBean, pBean.getDispancy(), pBean.getDisease(), pBean.getDignosic(), pBean.getLab(), pBean.getPayment(),DateFormatter.dateToString(pBean.getDate()));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNameButtonActionPerformed
        String name = patientNameTextField.getText();
        if(name.equals("")){
            return;
        }
        try{
            ArrayList list = DatabaseManager.getPatientsSummary(name);
            clearTable();
            for(int i=0;i<list.size();i++){
                PatientBean pBean = (PatientBean)list.get(i);
                addRowInTable(i+1, pBean.getDoctorName(), pBean, pBean.getDispancy(), pBean.getDisease(), pBean.getDignosic(), pBean.getLab(), pBean.getPayment(),DateFormatter.dateToString(pBean.getDate()));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchByNameButtonActionPerformed

    private void addRowInTable(int serialNo ,String doctor,PatientBean patient, String dispancy,String disease,String diag,String lab,int pay,String date){
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
        tableModel.setValueAt(date,row,8);
    }
    private void clearTable(){
        int rows=tableModel.getRowCount();
        for(int i=0;i<rows;i++){
            tableModel.removeRow(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closingBalanceLabel;
    private javax.swing.JLabel closingBalanceLabel1;
    private javax.swing.JFormattedTextField dateFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField patientNameTextField;
    private javax.swing.JTable patientTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchByNameButton;
    private javax.swing.JFormattedTextField todateFormattedTextField;
    // End of variables declaration//GEN-END:variables
}
