/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import setting.MenuSetting;

/**
 *
 * @author Jay Kumar
 */
public class SettingFrame extends javax.swing.JFrame {

    
    MainFrame mainFrame;
    public SettingFrame(MainFrame main) {
        mainFrame = main;
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

        jLabel1 = new javax.swing.JLabel();
        accountCheckBox = new javax.swing.JCheckBox();
        yearCheckBox = new javax.swing.JCheckBox();
        dayCheckBox = new javax.swing.JCheckBox();
        productCheckBox = new javax.swing.JCheckBox();
        salebookCheckBox = new javax.swing.JCheckBox();
        purchaseCheckBox = new javax.swing.JCheckBox();
        categoryCheckBox = new javax.swing.JCheckBox();
        unitCheckBox = new javax.swing.JCheckBox();
        cashbookCheckBox = new javax.swing.JCheckBox();
        chequeCheckBox = new javax.swing.JCheckBox();
        transactionCheckBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SETTING");

        accountCheckBox.setText("ACCOUNT");

        yearCheckBox.setText("YEAR");

        dayCheckBox.setText("DAY");

        productCheckBox.setText("PRODUCT");

        salebookCheckBox.setText("SALE BOOK");

        purchaseCheckBox.setText("PURCHASE BOOK");

        categoryCheckBox.setText("CATEGORY");

        unitCheckBox.setText("MEASUREMENT UNIT");

        cashbookCheckBox.setText("CASH BOOK");

        chequeCheckBox.setText("CHEQUE BOOK");

        transactionCheckBox.setText("TRANSACTION SUMMARY");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountCheckBox)
                            .addComponent(productCheckBox)
                            .addComponent(categoryCheckBox)
                            .addComponent(chequeCheckBox))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transactionCheckBox)
                            .addComponent(unitCheckBox)
                            .addComponent(salebookCheckBox)
                            .addComponent(yearCheckBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseCheckBox)
                    .addComponent(dayCheckBox)
                    .addComponent(cashbookCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountCheckBox)
                    .addComponent(yearCheckBox)
                    .addComponent(dayCheckBox))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCheckBox)
                    .addComponent(salebookCheckBox)
                    .addComponent(purchaseCheckBox))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryCheckBox)
                    .addComponent(unitCheckBox)
                    .addComponent(cashbookCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chequeCheckBox)
                    .addComponent(transactionCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            saveCheckBoxs();
            setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(SettingFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
   
        if(b){
           try{ 
               setCheckBoxs();
           }catch(FileNotFoundException ex){
               try{
                MenuSetting.createSettingFile();
                setCheckBoxs();
            }catch(Exception ex1){
                JOptionPane.showMessageDialog(this, "Cannot Create File, Please Change the drive of Project..\n"+ex1);
            }
           }catch(Exception ex){
               JOptionPane.showMessageDialog(this, ex);
           }
        }
    }

    public void saveCheckBoxs()throws Exception{
       MenuSetting.setFrameVisiblity(MenuSetting.ACCOUNT, accountCheckBox.isSelected());
       mainFrame.setAccountVisible(accountCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.YEAR,yearCheckBox.isSelected());
       mainFrame.setYearVisible(yearCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.DAY , dayCheckBox.isSelected());
       mainFrame.setDayVisible(dayCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.PRODUCTS,productCheckBox.isSelected());
       mainFrame.setProductVisible(productCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.SALESBOOK , salebookCheckBox.isSelected());
       mainFrame.setSalesBookUnitVisible(salebookCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.PURCHASEBOOK ,purchaseCheckBox.isSelected());
       mainFrame.setPurchaseBookUnitVisible(purchaseCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.CATEGORY, categoryCheckBox.isSelected());
       mainFrame.setCategoryVisible(categoryCheckBox.isSelected());
        
       MenuSetting.setFrameVisiblity(MenuSetting.MEASUREMENTUNIT,unitCheckBox.isSelected());
        mainFrame.setMeasurementUnitVisible(unitCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.CASHBOOK,cashbookCheckBox.isSelected());
       mainFrame.setCashBookUnitVisible(cashbookCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.CHEQUEBOOK, chequeCheckBox.isSelected());
       mainFrame.setChequeBookUnitVisible(chequeCheckBox.isSelected());
       
       MenuSetting.setFrameVisiblity(MenuSetting.TRANSACTIONSUMMARY, transactionCheckBox.isSelected());
       mainFrame.setTransactionUnitVisible(transactionCheckBox.isSelected());
    }
    
    public void setCheckBoxs()throws Exception{
       accountCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.ACCOUNT));
       yearCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.YEAR));
       dayCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.DAY));
       productCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.PRODUCTS));
       salebookCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.SALESBOOK));
       purchaseCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.PURCHASEBOOK));
       categoryCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.CATEGORY));
       unitCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.MEASUREMENTUNIT));
       cashbookCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.CASHBOOK));
       chequeCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.CHEQUEBOOK));
       transactionCheckBox.setSelected(MenuSetting.getFrameVisiblity(MenuSetting.TRANSACTIONSUMMARY));
    }
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox accountCheckBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox cashbookCheckBox;
    private javax.swing.JCheckBox categoryCheckBox;
    private javax.swing.JCheckBox chequeCheckBox;
    private javax.swing.JCheckBox dayCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox productCheckBox;
    private javax.swing.JCheckBox purchaseCheckBox;
    private javax.swing.JCheckBox salebookCheckBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox transactionCheckBox;
    private javax.swing.JCheckBox unitCheckBox;
    private javax.swing.JCheckBox yearCheckBox;
    // End of variables declaration//GEN-END:variables
}
