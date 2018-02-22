
import javax.swing.JOptionPane;

public class DayFrame extends javax.swing.JFrame {

    /** Creates new form DayFrame */
    public DayFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/date.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        dayListScrollPane = new javax.swing.JScrollPane();
        dayList = new javax.swing.JList();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        dayLabel = new javax.swing.JLabel();
        closingBalanceLabel = new javax.swing.JLabel();
        closingBalanceTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        dayFormattedTextField = new javax.swing.JFormattedTextField();
        DayIdLabel = new javax.swing.JLabel();
        dayIdTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Days");
        setMinimumSize(new java.awt.Dimension(600, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(102, 0, 0));
        mainLabel.setText("Day Sheet");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(240, 10, 110, 50);

        dayList.setToolTipText("Days List");
        dayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dayListValueChanged(evt);
            }
        });
        dayListScrollPane.setViewportView(dayList);

        getContentPane().add(dayListScrollPane);
        dayListScrollPane.setBounds(380, 60, 190, 320);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        yearLabel.setText("YEAR ");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(20, 110, 70, 30);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(120, 110, 220, 30);

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        dayLabel.setText("DAY");
        getContentPane().add(dayLabel);
        dayLabel.setBounds(20, 160, 60, 30);

        closingBalanceLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        closingBalanceLabel.setText("CLOSING BALANCE");
        getContentPane().add(closingBalanceLabel);
        closingBalanceLabel.setBounds(10, 230, 110, 30);

        closingBalanceTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        closingBalanceTextField.setText("00");
        getContentPane().add(closingBalanceTextField);
        closingBalanceTextField.setBounds(120, 230, 220, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 290, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(90, 290, 250, 70);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(460, 390, 90, 30);

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 390, 90, 30);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(120, 390, 105, 30);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(230, 390, 100, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(340, 390, 110, 30);

        try {
            dayFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(dayFormattedTextField);
        dayFormattedTextField.setBounds(120, 160, 220, 40);

        DayIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        DayIdLabel.setText("DAY ID");
        getContentPane().add(DayIdLabel);
        DayIdLabel.setBounds(20, 70, 60, 30);

        dayIdTextField.setEditable(false);
        getContentPane().add(dayIdTextField);
        dayIdTextField.setBounds(120, 70, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        super.setVisible(b);
        refreshYear();
        clear();
    }
    private void refreshYear(){
        yearComboBox.removeAllItems();
        try{
            java.util.ArrayList list = DatabaseManager.getYears();
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace();}
    }
    private void refreshDays(){
        try{
            YearBean bean = (YearBean)yearComboBox.getSelectedItem();
            if(bean==null)return;
            java.util.ArrayList list = DatabaseManager.getDays(bean.getYearId());
            dayList.setListData(list.toArray());
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void clear(){
        this.closingBalanceTextField.setText("0");
        this.remarksTextArea.setText("");
    }
    private void dayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dayListValueChanged
        DayBean bean =(DayBean) dayList.getSelectedValue();
        if(bean==null)return;
        this.dayIdTextField.setText(""+bean.getdayId());
        this.dayFormattedTextField.setText(DateFormatter.dateToString(bean.getday()));
        closingBalanceTextField.setText(""+bean.getClosingBalance());
        remarksTextArea.setText(bean.getRemarks());
}//GEN-LAST:event_dayListValueChanged

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        refreshDays();
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       YearBean bean = (YearBean)yearComboBox.getSelectedItem();
       int yearId = bean.getYearId();
       String[] dates = dayFormattedTextField.getText().split("-");
       String date = dates[1]+"-"+dates[0]+"-"+dates[2];
       try{
           int closingBalanace = Integer.parseInt(this.closingBalanceTextField.getText());
           String remarks = this.remarksTextArea.getText();
           DatabaseManager.addDay(yearId, date, closingBalanace, remarks);
           refreshDays();
           clear();
           JOptionPane.showMessageDialog(null,"day addedd succesfully..");
       }catch(NumberFormatException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null,"Balnace format is not correct / invalid");
           this.closingBalanceTextField.setText("");
       }
       catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
       DayBean dayBean = (DayBean)dayList.getSelectedValue();
       YearBean bean = (YearBean)yearComboBox.getSelectedItem();
       int yearId = bean.getYearId();
       try{
           int closingBalanace = Integer.parseInt(this.closingBalanceTextField.getText());
           String remarks = this.remarksTextArea.getText();
           String dates[] = dayFormattedTextField.getText().split("-");
           String date = dates[1]+"-"+dates[0]+"-"+dates[2];
           DatabaseManager.updateDay(yearId,dayBean.getdayId(), date, closingBalanace,false ,remarks);
           refreshDays();
           clear();
           JOptionPane.showMessageDialog(null,"day updatedd succesfully..");
       }catch(NumberFormatException ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(null,"Blanace format is not correct / invalid");
           this.closingBalanceTextField.setText("");
       }
       catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
        DayBean dayBean = (DayBean)dayList.getSelectedValue();
        try{
            DatabaseManager.deleteDay(dayBean.getdayId());
            JOptionPane.showMessageDialog(null,"day deleted succesfully..");
            refreshDays();
        }catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayIdLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel closingBalanceLabel;
    private javax.swing.JTextField closingBalanceTextField;
    private javax.swing.JFormattedTextField dayFormattedTextField;
    private javax.swing.JTextField dayIdTextField;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JList dayList;
    private javax.swing.JScrollPane dayListScrollPane;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
