package forms;

import bean.TransactionDetailBean;
import database.DatabaseManager;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class TransactionForm extends javax.swing.JFrame {

    public TransactionForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDates = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTransaction = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldStudent = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRANSACTION FORM");

        listDates.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listDates.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDatesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDates);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Dates");

        listTransaction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listTransaction.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listTransactionValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listTransaction);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Transactions");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Student Name");

        textFieldStudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel3)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textFieldStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listDatesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDatesValueChanged
        Date item = (Date) listDates.getSelectedValue();
        if(item == null) return;
        try{
           ArrayList list = DatabaseManager.getAllTransation(item.toString());
           listTransaction.setListData(list.toArray());
       }catch(Exception ex){
           ex.printStackTrace();
           //JOptionPane.showMessageDialog(this, ex);
       }
    }//GEN-LAST:event_listDatesValueChanged

    private void listTransactionValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listTransactionValueChanged
        TransactionDetailBean b = (TransactionDetailBean)listTransaction.getSelectedValue();
        if(b!=null)textFieldStudent.setText(b.getStudentName());
    }//GEN-LAST:event_listTransactionValueChanged

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if(b){
           listTransaction.setListData(new Object[]{});
           setDistinctDates();
           textFieldStudent.setText("");
        }
    }

    public void setDistinctDates(){
       try{
           ArrayList list = DatabaseManager.getDistinctDatesFromTransaction();
           listDates.setListData(list.toArray());
       } catch(Exception ex){
           ex.printStackTrace();
       }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listDates;
    private javax.swing.JList listTransaction;
    private javax.swing.JTextField textFieldStudent;
    // End of variables declaration//GEN-END:variables
}
