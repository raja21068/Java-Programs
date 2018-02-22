
import javax.swing.JOptionPane;

/*
 * ScratchCardFrame.java
 *
 * Created on Jan 14, 2013, 9:16:29 PM
 */
public class ScratchCardFrame extends javax.swing.JFrame {

    
    public ScratchCardFrame() {
        initComponents();
    }
    
    public void setVisible(boolean b){
        if(b){
            getFaculty();
        }
        super.setVisible(b);
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
    private void setCards(){
        FacultyBean bean = (FacultyBean)this.facultyComboBox.getSelectedItem();
        if(bean==null)return;
        new Thread(){
            public void run(){
                try{
                    FacultyBean bean = (FacultyBean)facultyComboBox.getSelectedItem();
                    java.util.ArrayList expired= DatabaseManager.getExpiredScratchCards(bean.getFacultyId(), Constant.LEGAL , DateFormatter.dateToStringMonthFormat(new java.util.Date()));
                    expiredCardList.setListData(expired.toArray());
                    java.util.ArrayList used= DatabaseManager.getUsedScratchCards(bean.getFacultyId(), Constant.USED);
                    usedCardList.setListData(used.toArray());
                    java.util.ArrayList unUsed= DatabaseManager.getUnusedScratchCards(bean.getFacultyId(),Constant.LEGAL,DateFormatter.dateToStringMonthFormat(new java.util.Date()) );
                    unusedCardList.setListData(unUsed.toArray());
                    
                    expiredCardNoLabel.setText("Total Cards: "+expired.size());
                    unusedCardNoLabel.setText("Total Cards: "+unUsed.size());
                    usedCardNoLabel.setText("Total Cards: "+used.size());
                }catch(Exception ex){ex.printStackTrace();}
            }
        }.start();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();
        scratchCardIdLabel = new javax.swing.JLabel();
        scratchCardIdTextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        scratchCardNoLabel = new javax.swing.JLabel();
        scratchCardNoTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        purposeLabel = new javax.swing.JLabel();
        purposeComboBox = new javax.swing.JComboBox();
        amountLabel = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        validUptoLabel = new javax.swing.JLabel();
        validUptoTextField = new javax.swing.JFormattedTextField();
        randomlyGenerateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usedCardList = new javax.swing.JList();
        deleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        unusedCardList = new javax.swing.JList();
        updateButton = new javax.swing.JButton();
        expandButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        expiredCardList = new javax.swing.JList();
        usedCardNoLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        expiredCardNoLabel = new javax.swing.JLabel();
        unusedCardNoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(585, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 153));
        titleLabel.setText("Scratch Card Display");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(220, 20, 200, 20);

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        facultyLabel.setText("Faculty");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(10, 80, 80, 30);

        facultyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facultyComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(100, 80, 290, 30);

        scratchCardIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        scratchCardIdLabel.setText("Scratch Card ID");
        getContentPane().add(scratchCardIdLabel);
        scratchCardIdLabel.setBounds(10, 150, 90, 14);

        scratchCardIdTextField.setEditable(false);
        getContentPane().add(scratchCardIdTextField);
        scratchCardIdTextField.setBounds(110, 148, 90, 20);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusLabel.setText("Status");
        getContentPane().add(statusLabel);
        statusLabel.setBounds(220, 140, 50, 30);

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Legal", "Used" }));
        getContentPane().add(statusComboBox);
        statusComboBox.setBounds(270, 140, 120, 30);

        scratchCardNoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        scratchCardNoLabel.setText("Card No");
        getContentPane().add(scratchCardNoLabel);
        scratchCardNoLabel.setBounds(10, 210, 90, 14);

        scratchCardNoTextField.setEditable(false);
        getContentPane().add(scratchCardNoTextField);
        scratchCardNoTextField.setBounds(110, 207, 280, 25);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        quantityLabel.setText("Quantity");
        getContentPane().add(quantityLabel);
        quantityLabel.setBounds(10, 260, 90, 30);
        getContentPane().add(quantityTextField);
        quantityTextField.setBounds(110, 260, 100, 25);

        purposeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        purposeLabel.setText("Purpose");
        getContentPane().add(purposeLabel);
        purposeLabel.setBounds(220, 260, 50, 30);

        purposeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Exam", "Self" }));
        getContentPane().add(purposeComboBox);
        purposeComboBox.setBounds(270, 260, 120, 30);

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        amountLabel.setText("Amount");
        getContentPane().add(amountLabel);
        amountLabel.setBounds(10, 320, 90, 30);
        getContentPane().add(amountTextField);
        amountTextField.setBounds(110, 320, 100, 25);

        validUptoLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        validUptoLabel.setText("Valid upto");
        getContentPane().add(validUptoLabel);
        validUptoLabel.setBounds(220, 320, 70, 20);

        try {
            validUptoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(validUptoTextField);
        validUptoTextField.setBounds(290, 320, 110, 20);

        randomlyGenerateButton.setText("<html>Randomly<br>Generate");
        randomlyGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomlyGenerateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(randomlyGenerateButton);
        randomlyGenerateButton.setBounds(10, 360, 380, 60);

        usedCardList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                usedCardListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(usedCardList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(810, 30, 150, 360);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(410, 380, 130, 40);

        unusedCardList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                unusedCardListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(unusedCardList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(610, 30, 170, 360);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(410, 330, 130, 40);

        expandButton.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        expandButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/expend.png"))); // NOI18N
        expandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandButtonActionPerformed(evt);
            }
        });
        getContentPane().add(expandButton);
        expandButton.setBounds(560, 10, 20, 410);

        expiredCardList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                expiredCardListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(expiredCardList);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(410, 80, 140, 220);

        usedCardNoLabel.setText("Total Cards:");
        getContentPane().add(usedCardNoLabel);
        usedCardNoLabel.setBounds(810, 396, 140, 14);

        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Used", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(800, 10, 170, 410);

        expiredCardNoLabel.setText("Total Cards:");
        getContentPane().add(expiredCardNoLabel);
        expiredCardNoLabel.setBounds(420, 306, 120, 14);

        unusedCardNoLabel.setText("Total Cards:");
        getContentPane().add(unusedCardNoLabel);
        unusedCardNoLabel.setBounds(620, 394, 150, 14);

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unused", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 10, 190, 410);

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expired", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(402, 56, 153, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facultyComboBoxItemStateChanged
        setCards();
}//GEN-LAST:event_facultyComboBoxItemStateChanged

    private void expandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandButtonActionPerformed
       int width = this.getWidth();
       if(width==585){
           this.setSize(970, getHeight());
       }
       else{
           this.setSize(585, getHeight());
       }
    }//GEN-LAST:event_expandButtonActionPerformed

    private void randomlyGenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomlyGenerateButtonActionPerformed
        FacultyBean facBean = (FacultyBean)this.facultyComboBox.getSelectedItem();
        if(facBean==null)return;
        if(this.validUptoTextField.getText().length()<6){
            JOptionPane.showMessageDialog(null, "re-enter valid upto date...");
        }
        char[] elements = {'1','2','3','4','5','6','7','8','9','0'};
        try{
            int amount = Integer.parseInt(amountTextField.getText());
            int totalCards = Integer.parseInt(this.quantityTextField.getText());
            java.util.ArrayList<String> scratchCardNos = new java.util.ArrayList<String>();
            String no ="";
        
            for(int i=1;i<=totalCards; ){
                for(int j=1;j<=14;j++){
                    int index = (int)(Math.random()*(elements.length-1));
                    no+=elements[index];
                }
                if(!scratchCardNos.contains(no)){
                    scratchCardNos.add(no);
                    i++;
                }
                no="";
            }
            DatabaseManager.addScratchCard(facBean.getFacultyId(), scratchCardNos,amount ,Constant.LEGAL, TypeEncoder.encode(purposeComboBox.getSelectedItem().toString()),validUptoTextField.getText() , "");
        }
        catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "Invalid Quantity / Amount..");
        }
        catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_randomlyGenerateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        for(int i=0;i<expiredCardList.getSelectedIndices().length;i++){
            ScratchCardBean bean = (ScratchCardBean)this.expiredCardList.getSelectedValue();
            if(bean==null)return;
            try{
                DatabaseManager.deleteScratchCard(bean.getScratchCardId());
                JOptionPane.showMessageDialog(this, "succesfully deleted...");
                setCards();
            }catch(Exception ex){ex.printStackTrace();}
        
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
      ScratchCardBean bean = (ScratchCardBean)this.expiredCardList.getSelectedValue();
        if(bean==null)return;
        try{
            int amount = Integer.parseInt(this.amountTextField.getText());
            int status = TypeEncoder.encode(this.statusComboBox.getSelectedItem().toString());
            String cardNo = this.scratchCardNoTextField.getText();
            int purpose = TypeEncoder.encode(this.purposeComboBox.getSelectedItem().toString());
            String validate = DateFormatter.FlipDateAndMonth(this.validUptoTextField.getText());
            DatabaseManager.UpdateScratchCard(bean.getScratchCardId(),amount, status, cardNo, purpose, validate, "");
            JOptionPane.showMessageDialog(this, "succesfully updated...");
            setCards();
        }catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Invalid amount");}  
        catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(this,ex);}  
    }//GEN-LAST:event_updateButtonActionPerformed

    private void unusedCardListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_unusedCardListValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.unusedCardList.getSelectedValue();
        if(bean==null)return;
        this.amountTextField.setText(""+bean.getAmount());
        this.scratchCardNoTextField.setText(bean.getScratchCardNo());
        this.purposeComboBox.setSelectedItem(TypeDecoder.decode(bean.getPurpose()));
        this.scratchCardIdTextField.setText(""+bean.getScratchCardId());
        this.statusComboBox.setSelectedItem(TypeDecoder.decode(bean.getStatus()));
        this.validUptoTextField.setText(DateFormatter.dateToString(bean.getValidUptoDate()));
    }//GEN-LAST:event_unusedCardListValueChanged

    private void usedCardListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_usedCardListValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.usedCardList.getSelectedValue();
        if(bean==null)return;
        this.amountTextField.setText(""+bean.getAmount());
        this.scratchCardNoTextField.setText(bean.getScratchCardNo());
        this.purposeComboBox.setSelectedItem(TypeDecoder.decode(bean.getPurpose()));
        this.scratchCardIdTextField.setText(""+bean.getScratchCardId());
        this.statusComboBox.setSelectedItem(TypeDecoder.decode(bean.getStatus()));
        this.validUptoTextField.setText(DateFormatter.dateToString(bean.getValidUptoDate()));
    }//GEN-LAST:event_usedCardListValueChanged

    private void expiredCardListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_expiredCardListValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.expiredCardList.getSelectedValue();
        if(bean==null)return;
        this.amountTextField.setText(""+bean.getAmount());
        this.scratchCardNoTextField.setText(bean.getScratchCardNo());
        this.purposeComboBox.setSelectedItem(TypeDecoder.decode(bean.getPurpose()));
        this.scratchCardIdTextField.setText(""+bean.getScratchCardId());
        this.statusComboBox.setSelectedItem(TypeDecoder.decode(bean.getStatus()));
        this.validUptoTextField.setText(DateFormatter.dateToString(bean.getValidUptoDate()));
    }//GEN-LAST:event_expiredCardListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton expandButton;
    private javax.swing.JList expiredCardList;
    private javax.swing.JLabel expiredCardNoLabel;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox purposeComboBox;
    private javax.swing.JLabel purposeLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton randomlyGenerateButton;
    private javax.swing.JLabel scratchCardIdLabel;
    private javax.swing.JTextField scratchCardIdTextField;
    private javax.swing.JLabel scratchCardNoLabel;
    private javax.swing.JTextField scratchCardNoTextField;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JList unusedCardList;
    private javax.swing.JLabel unusedCardNoLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JList usedCardList;
    private javax.swing.JLabel usedCardNoLabel;
    private javax.swing.JLabel validUptoLabel;
    private javax.swing.JFormattedTextField validUptoTextField;
    // End of variables declaration//GEN-END:variables

}
