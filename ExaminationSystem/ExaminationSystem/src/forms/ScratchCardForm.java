/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import bean.ScratchCardBean;
import database.DatabaseManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import utility.DateFormatter;

/**
 *
 * @author Raja Kumar
 */
public class ScratchCardForm extends javax.swing.JFrame {

    ArrayList listBeans;
    public static int CARD_DIGITS = 14;
    
    public ScratchCardForm() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        scratchCardIdLabel = new javax.swing.JLabel();
        textFieldScratchCardId = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        comboBoxAmount = new javax.swing.JComboBox();
        scratchCardNoLabel = new javax.swing.JLabel();
        textFieldsScratchCardNo = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        textFieldQuantity = new javax.swing.JTextField();
        amountLabel = new javax.swing.JLabel();
        textFieldamount = new javax.swing.JTextField();
        labelValidUpto = new javax.swing.JLabel();
        textFieldvalidUpto = new javax.swing.JFormattedTextField();
        buttonRandomlyGenerate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListUsedCard = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListUnusedCard = new javax.swing.JList();
        buttonUpdate = new javax.swing.JButton();
        expandButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListExpiredCard = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        labelExpiredCardNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonDelete = new javax.swing.JButton();
        labelUnusedCardNo = new javax.swing.JLabel();
        labelUsedCardNo = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        labelProgressStatus = new javax.swing.JLabel();
        gDateLabel = new javax.swing.JLabel();
        textFieldGenerateDate = new javax.swing.JTextField();
        gDateLabel1 = new javax.swing.JLabel();
        textFieldUsedDate = new javax.swing.JTextField();

        setTitle("Scratch Card");

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 153));
        titleLabel.setText("Scratch Card Display");

        scratchCardIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scratchCardIdLabel.setText("Scratch Card ID");

        textFieldScratchCardId.setEditable(false);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusLabel.setText("Filter");

        comboBoxAmount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxAmountItemStateChanged(evt);
            }
        });

        scratchCardNoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        scratchCardNoLabel.setText("Card No");

        textFieldsScratchCardNo.setEditable(false);

        quantityLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quantityLabel.setText("Quantity");

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel.setText("Amount");

        labelValidUpto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelValidUpto.setText("Valid upto");

        try {
            textFieldvalidUpto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonRandomlyGenerate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonRandomlyGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Credit-Card-icon -small.png"))); // NOI18N
        buttonRandomlyGenerate.setText("<html>Randomly<br>Generate");
        buttonRandomlyGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRandomlyGenerateActionPerformed(evt);
            }
        });

        ListUsedCard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ListUsedCard.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListUsedCardValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListUsedCard);

        ListUnusedCard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ListUnusedCard.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListUnusedCardValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListUnusedCard);

        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Arrow-Up-icon.png"))); // NOI18N
        buttonUpdate.setText("Update");
        buttonUpdate.setEnabled(false);
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        expandButton.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        expandButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expend.png"))); // NOI18N
        expandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expandButtonActionPerformed(evt);
            }
        });

        ListExpiredCard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ListExpiredCard.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListExpiredCardValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(ListExpiredCard);

        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Used", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N

        labelExpiredCardNo.setText("Total Cards:");

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unused", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expired", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 153))); // NOI18N

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close-2-icon.png"))); // NOI18N
        buttonDelete.setText("Delete");
        buttonDelete.setEnabled(false);
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        labelUnusedCardNo.setText("Total Cards:");

        labelUsedCardNo.setText("Total Cards:");

        progressBar.setStringPainted(true);

        gDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gDateLabel.setText("Generate Date");

        textFieldGenerateDate.setEditable(false);

        gDateLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        gDateLabel1.setText("Used Date");

        textFieldUsedDate.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelProgressStatus)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonRandomlyGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quantityLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(amountLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldamount, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelValidUpto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textFieldvalidUpto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(scratchCardNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gDateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(textFieldUsedDate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(gDateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textFieldGenerateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(textFieldsScratchCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(scratchCardIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textFieldScratchCardId, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(comboBoxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelExpiredCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(expandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelUnusedCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsedCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(250, 250, 250)
                                        .addComponent(labelExpiredCardNo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textFieldScratchCardId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scratchCardIdLabel)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(scratchCardNoLabel))
                                    .addComponent(textFieldsScratchCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldGenerateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gDateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldUsedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelValidUpto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldamount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldvalidUpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(buttonRandomlyGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelProgressStatus))))
                    .addComponent(expandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(labelUnusedCardNo))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(labelUsedCardNo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRandomlyGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRandomlyGenerateActionPerformed
        new Thread(){
            public void run(){
                buttonRandomlyGenerate.setEnabled(false);
                if(textFieldvalidUpto.getText().length()<10){
                    JOptionPane.showMessageDialog(null, "Date Format is not correct DD-MM-YYYY (i.e   02-05-2013)");
                    return;
                }
                labelProgressStatus.setText("Generating...");
                String currentDate = DateFormatter.dateToStringYMD(new Date());
                String expiryDate = DateFormatter.DMYToYMD(textFieldvalidUpto.getText());
                char[] elements = {'1','2','3','4','5','6','7','8','9','0'};
                try{
                    int amount = Integer.parseInt(textFieldamount.getText());
                    int totalCards = Integer.parseInt(textFieldQuantity.getText());
                    java.util.ArrayList<String> scratchCardNos = new java.util.ArrayList<String>();

                    progressBar.setMinimum(0);
                    progressBar.setMaximum(totalCards);
                
                    
                    // First add previous generated nos in arrayList
                    // which will help us to generate UNIQUE nos.            
                    for(int i=0;i<listBeans.size();i++){
                        ScratchCardBean b = (ScratchCardBean)listBeans.get(i);
                        scratchCardNos.add(b.getScratchCardNo());
                    }

                    String no ="";

                    for(int i=1;i<=totalCards; ){
                        for(int j=1;j<=CARD_DIGITS;j++){
                            int index = (int)(Math.random()*(elements.length));
                            no+=elements[index];
                        }
                        if(!scratchCardNos.contains(no)){
                            scratchCardNos.add(no);
                            System.out.println(i+". "+no);
                            i++;
                            DatabaseManager.addScratchCard(no,amount,currentDate,expiryDate, "");
                            progressBar.setValue(progressBar.getValue()+1);
                        }
                        no="";
                    }
                    labelProgressStatus.setText("Generating Complete...");
                    setDistinctAmount();
                }
                catch(NumberFormatException ex){
                    labelProgressStatus.setText("Generating Error...");
                    JOptionPane.showMessageDialog(null, "Invalid Quantity / Amount..");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Transaction not Performed:\n"+ex);
                    labelProgressStatus.setText("Generating Error...");    
                }
                buttonRandomlyGenerate.setEnabled(true);
                    
            }
        }.start();
    }//GEN-LAST:event_buttonRandomlyGenerateActionPerformed

    private void ListUsedCardValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListUsedCardValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.ListUsedCard.getSelectedValue();
        if(bean==null)return;
        
        textFieldUsedDate.setText(""+DateFormatter.dateToStringDMY(bean.getDateOfUsed()));
        textFieldGenerateDate.setText( DateFormatter.dateToStringDMY(bean.getDateOfCreate()) );
        textFieldvalidUpto.setText(DateFormatter.dateToStringDMY(bean.getDateOfExpire()));
        textFieldsScratchCardNo.setText(bean.getScratchCardNo());
        textFieldScratchCardId.setText(""+bean.getScratchCardId());
        
    }//GEN-LAST:event_ListUsedCardValueChanged

    private void ListUnusedCardValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListUnusedCardValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.ListUnusedCard.getSelectedValue();
        if(bean==null)return;
        textFieldGenerateDate.setText( DateFormatter.dateToStringDMY(bean.getDateOfCreate()) );
        textFieldvalidUpto.setText(DateFormatter.dateToStringDMY(bean.getDateOfExpire()));
        textFieldsScratchCardNo.setText(bean.getScratchCardNo());
        textFieldScratchCardId.setText(""+bean.getScratchCardId());
        
    }//GEN-LAST:event_ListUnusedCardValueChanged

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        ScratchCardBean bean = (ScratchCardBean)this.ListExpiredCard.getSelectedValue();
        if(bean==null)return;
        try{
            
        }catch(NumberFormatException ex){JOptionPane.showMessageDialog(this,"Invalid amount");}
        catch(Exception ex){ex.printStackTrace();JOptionPane.showMessageDialog(this,ex);}
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void expandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expandButtonActionPerformed
        int width = this.getWidth();
        if(width==585){
            this.setSize(970, getHeight());
        }
        else{
            this.setSize(585, getHeight());
        }
    }//GEN-LAST:event_expandButtonActionPerformed

    private void ListExpiredCardValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListExpiredCardValueChanged
        ScratchCardBean bean = (ScratchCardBean)this.ListExpiredCard.getSelectedValue();
        if(bean==null)return;
        textFieldGenerateDate.setText( DateFormatter.dateToStringDMY(bean.getDateOfCreate()) );
        textFieldvalidUpto.setText(DateFormatter.dateToStringDMY(bean.getDateOfExpire()));
        textFieldsScratchCardNo.setText(bean.getScratchCardNo());
        textFieldScratchCardId.setText(""+bean.getScratchCardId());
    }//GEN-LAST:event_ListExpiredCardValueChanged

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        for(int i=0;i<ListExpiredCard.getSelectedIndices().length;i++){
            ScratchCardBean bean = (ScratchCardBean)this.ListExpiredCard.getSelectedValue();
            if(bean==null)return;
            try{
                DatabaseManager.deleteScratchCard(bean.getScratchCardId());
                JOptionPane.showMessageDialog(this, "succesfully deleted...");
            }catch(Exception ex){ex.printStackTrace();}

        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void comboBoxAmountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxAmountItemStateChanged
        showScratchCard();
    }//GEN-LAST:event_comboBoxAmountItemStateChanged

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if(b){
             new Thread(){
                 public void run(){
                     setDistinctAmount();
                 }
             }.start();
        }
    }
    
    public void setDistinctAmount(){
        try{
            ArrayList list = DatabaseManager.getDistinctScratchCardAmount();
            comboBoxAmount.removeAllItems();
            for(int i=0; i<list.size(); i++ ){
                comboBoxAmount.addItem(list.get(i));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }
    
    public void showScratchCard(){
        new Thread(){
            public void run(){
                try{
                    int amount = (int)comboBoxAmount.getSelectedItem();
                    labelProgressStatus.setText("getting scrtch card");
                    listBeans = DatabaseManager.getAllScratchCard(amount);
                    progressBar.setMinimum(0);
                    progressBar.setMaximum(listBeans.size()-1);
                    ArrayList used = new ArrayList();
                    ArrayList unUsed = new ArrayList();
                    ArrayList expired = new ArrayList();
                    Date d = new Date();
                    Date cal = new Date(d.getYear(), d.getMonth(), d.getDate());
                    for(int i=0;i<listBeans.size();i++){
                        ScratchCardBean bean = (ScratchCardBean) listBeans.get(i);
//                        System.out.println(cal + " : " +bean.getDateOfExpire() + " : "+ cal.equals(bean.getDateOfExpire()));
                        //UNUSED
                        if( (bean.getDateOfUsed() == null) && ( (cal.before(bean.getDateOfExpire())) || (cal.equals(bean.getDateOfExpire())) )  ){
                            unUsed.add(bean);
                        }
                        // EXPIRED
                        else if( (bean.getDateOfUsed() == null) && new Date().after(bean.getDateOfExpire()) ){
                            expired.add(bean);
                        }
                        //USED
                        else{
                            used.add(bean);
                        }
                    }
                    ListExpiredCard.setListData(expired.toArray());
                    labelExpiredCardNo.setText("Total Cards: "+expired.size());
                    ListUnusedCard.setListData(unUsed.toArray());
                    labelUnusedCardNo.setText("Total Cards: "+unUsed.size());
                    ListUsedCard.setListData(used.toArray());
                    labelUsedCardNo.setText("Total Cards: "+used.size());
                    labelProgressStatus.setText("Done...");
                }catch(Exception ex){
                    ex.printStackTrace();
                    //JOptionPane.showMessageDialog(null, "Something went wrong.. \n"+ex);
                }
            }
        }.start();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListExpiredCard;
    private javax.swing.JList ListUnusedCard;
    private javax.swing.JList ListUsedCard;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonRandomlyGenerate;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox comboBoxAmount;
    private javax.swing.JButton expandButton;
    private javax.swing.JLabel gDateLabel;
    private javax.swing.JLabel gDateLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelExpiredCardNo;
    private javax.swing.JLabel labelProgressStatus;
    private javax.swing.JLabel labelUnusedCardNo;
    private javax.swing.JLabel labelUsedCardNo;
    private javax.swing.JLabel labelValidUpto;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel scratchCardIdLabel;
    private javax.swing.JLabel scratchCardNoLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField textFieldGenerateDate;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JTextField textFieldScratchCardId;
    private javax.swing.JTextField textFieldUsedDate;
    private javax.swing.JTextField textFieldamount;
    private javax.swing.JTextField textFieldsScratchCardNo;
    private javax.swing.JFormattedTextField textFieldvalidUpto;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
