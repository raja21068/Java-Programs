package form;


import bean.Day;
import bean.Year;
import database.DatabaseManager;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class DayFrame extends javax.swing.JFrame {

    /** Creates new form DayFrame */
    public DayFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/date.png")));
        }catch(Exception ex){ex.printStackTrace(System.err);}
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
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        DayIdLabel = new javax.swing.JLabel();
        dayIdTextField = new javax.swing.JTextField();
        dayLabel1 = new javax.swing.JLabel();
        cashTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Days");
        setMinimumSize(new java.awt.Dimension(600, 470));
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dayLabel.setText("Cash");
        getContentPane().add(dayLabel);
        dayLabel.setBounds(20, 220, 60, 30);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 290, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(90, 290, 250, 70);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        getContentPane().add(dateChooser);
        dateChooser.setBounds(120, 160, 220, 30);

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(120, 390, 105, 30);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(230, 390, 100, 30);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(340, 390, 110, 30);

        DayIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DayIdLabel.setText("DAY ID");
        getContentPane().add(DayIdLabel);
        DayIdLabel.setBounds(20, 70, 60, 30);

        dayIdTextField.setEditable(false);
        getContentPane().add(dayIdTextField);
        dayIdTextField.setBounds(120, 70, 150, 30);

        dayLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dayLabel1.setText("DAY");
        getContentPane().add(dayLabel1);
        dayLabel1.setBounds(20, 160, 60, 30);

        cashTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashTextFieldKeyReleased(evt);
            }
        });
        getContentPane().add(cashTextField);
        cashTextField.setBounds(120, 220, 220, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        refreshYear();
        refreshLastDayCash();
        clear();
    }
    private void refreshYear(){
        yearComboBox.removeAllItems();
        try{
            List list  = DatabaseManager.getData(Year.class.getName(), " year DESC");
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace(System.err);}
    }
    
    public void refreshLastDayCash(){
        List list = DatabaseManager.getData(Day.class.getName()," DAY DESC");
        if(list.size()>0){
            Day d = (Day)list.get(0);
            cashTextField.setText(""+d.getCash());
        }else{
            cashTextField.setText("0");
        }
    }
    
    private void clear(){
        
        this.remarksTextArea.setText("");
    }
    private void dayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dayListValueChanged
        Day bean =(Day) dayList.getSelectedValue();
        if(bean==null)return;
        
        dayIdTextField.setText(""+bean.getDayId());
        dateChooser.setDate(bean.getDay());
        cashTextField.setText(""+bean.getCash());
        remarksTextArea.setText(bean.getRemarks());
}//GEN-LAST:event_dayListValueChanged

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        if(evt.getItem() == null) return;
        refreshDays();
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       Year bean = (Year)yearComboBox.getSelectedItem();
       if(bean == null){
           JOptionPane.showMessageDialog(this, "Please Add a year..");
           return;
       }
       
       int yearId = bean.getYearId();
       if(dateChooser.getDate().getYear()+1900 != bean.getYear()){
           JOptionPane.showMessageDialog(this, "Date doesnot match with Selected year..");
           return;
       }
       
       ListModel list = dayList.getModel();
       for(int i=0;i<list.getSize();i++){
           Day d = (Day)list.getElementAt(i);
           if(dateChooser.getDate() == d.getDay()){
              JOptionPane.showMessageDialog(this, "Duplicate Date..");
              return;
           }
       }
       double cash = 0;
       if(!cashTextField.getText().trim().equals("")){
           cash = Double.parseDouble(cashTextField.getText());
       }
       
       try{
           String remarks = this.remarksTextArea.getText().trim().toUpperCase();
           DatabaseManager.addData(new Day(bean, dateChooser.getDate(), remarks,cash ));
           JOptionPane.showMessageDialog(null,"day addedd succesfully..");
           setVisible(true);
       }catch(NumberFormatException ex){
           ex.printStackTrace(System.err);
           JOptionPane.showMessageDialog(null,"Balnace format is not correct / invalid");
       }
       catch(Exception ex){ex.printStackTrace(System.err);
        JOptionPane.showMessageDialog(null,"Error in Date / Duplicate Date");
       }
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
       
       double cash = 0;
       if(!cashTextField.getText().trim().equals("")){
           cash = Double.parseDouble(cashTextField.getText());
       }
        
       Day dayBean = (Day)dayList.getSelectedValue();
       Year bean = (Year)yearComboBox.getSelectedItem();
       dayBean.setDay(dateChooser.getDate());
       dayBean.setRemarks(remarksTextArea.getText().trim().toUpperCase());
       dayBean.setYear(bean);
       dayBean.setCash(cash);
       try{
           DatabaseManager.updateData(dayBean);
           JOptionPane.showMessageDialog(this, "Updated Successgully..");
           refreshDays();
           clear();
       }catch(NumberFormatException ex){
           ex.printStackTrace(System.err);
           JOptionPane.showMessageDialog(null,"Blanace format is not correct / invalid");
//           this.closingBalanceTextField.setText("");
       }
       catch(Exception ex){ex.printStackTrace(System.err);}
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete?","", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.NO_OPTION)return;
        
        Day dayBean = (Day)dayList.getSelectedValue();
        try{
           DatabaseManager.deleteData(Day.class, dayBean.getDayId());
           refreshDays();
        }catch(Exception ex){ex.printStackTrace(System.err);}
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        clear();
        refreshLastDayCash();
}//GEN-LAST:event_clearButtonActionPerformed

    private void cashTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTextFieldKeyReleased
        int code = evt.getKeyChar();
        String s = cashTextField.getText();
        if(code == KeyEvent.VK_0 ||code == KeyEvent.VK_1 ||code == KeyEvent.VK_2 ||code == KeyEvent.VK_3 ||code == KeyEvent.VK_4 ||code == KeyEvent.VK_5 ||code == KeyEvent.VK_6 ||code == KeyEvent.VK_7 ||code == KeyEvent.VK_8 ||code == KeyEvent.VK_9 ||code == 46){
            cashTextField.setText(s);
        }else{
            if(s.length()>0)cashTextField.setText(s.substring(0, s.length()-1));
        }
    }//GEN-LAST:event_cashTextFieldKeyReleased

    public void refreshDays(){
        Year bean = (Year) yearComboBox.getSelectedItem();
        if(bean == null) return;
        try{
            List list = DatabaseManager.getData(Day.class.getName(),"YEAR_ID = "+bean.getYearId(), " DAY DESC");
            dayList.setListData(list.toArray());
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayIdLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField cashTextField;
    private javax.swing.JButton clearButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextField dayIdTextField;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel dayLabel1;
    private javax.swing.JList dayList;
    private javax.swing.JScrollPane dayListScrollPane;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
