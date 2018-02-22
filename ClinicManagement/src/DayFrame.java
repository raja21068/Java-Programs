
import java.util.ArrayList;
import java.util.Date;
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
        dayLabel = new javax.swing.JLabel();
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
        dayLabel1 = new javax.swing.JLabel();
        dayIdTextField = new javax.swing.JTextField();
        yearComboBox = new javax.swing.JComboBox();
        closeCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Days");
        setMinimumSize(new java.awt.Dimension(600, 470));
        setResizable(false);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(102, 0, 0));
        mainLabel.setText("Day Sheet");

        dayList.setToolTipText("Days List");
        dayList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dayListValueChanged(evt);
            }
        });
        dayListScrollPane.setViewportView(dayList);

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dayLabel.setText("Year");

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
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

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
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

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/empty-icon.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        try {
            dayFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        DayIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DayIdLabel.setText("DAY ID");

        dayLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dayLabel1.setText("DAY");

        dayIdTextField.setEditable(false);

        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });

        closeCheckBox.setSelected(true);
        closeCheckBox.setText("Close");
        closeCheckBox.setToolTipText("Check means you want to close the Date, works only on update");

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DayIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(dayListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(closeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DayIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(dayLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dayIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(dayFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        super.setVisible(b);
        clear();
        refreshYear();
    }
    private void refreshYear(){
        yearComboBox.removeAllItems();
        try{
            ArrayList list = DatabaseManager.getYears();
            for(int i=0;i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void refreshDays(){
        YearBean bean = (YearBean)yearComboBox.getSelectedItem();
        if(bean==null)return;
        try{
            dayList.setListData(DatabaseManager.getAllDay(bean.getYearId()).toArray());
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void clear(){
        this.dayIdTextField.setText("");
        this.dayFormattedTextField.setText(DateFormatter.dateToString(new Date()));
        this.remarksTextArea.setText("");
        closeCheckBox.setSelected(true);
    }
    private void dayListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dayListValueChanged
        DayBean bean =(DayBean) dayList.getSelectedValue();
        if(bean==null)return;
        this.dayIdTextField.setText(""+bean.getDayId());
        this.dayFormattedTextField.setText(DateFormatter.dateToStringMonthFormat(bean.getDay()));
        this.remarksTextArea.setText(bean.getRemarks());
}//GEN-LAST:event_dayListValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
}//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       YearBean yearBean = (YearBean)yearComboBox.getSelectedItem();
       if(yearBean==null){
           JOptionPane.showMessageDialog(this, "Please add a year from 'Add Year' frame");
           return;
       }
       String day = dayFormattedTextField.getText();
       if(day.trim().length()<8){
           JOptionPane.showMessageDialog(this, "Invalid Date");
           return;
       }
       day=DateFormatter.FlipDateAndMonth(day);
        try{
           DatabaseManager.addDay(yearBean.getYearId(),day, false, remarksTextArea.getText());
           JOptionPane.showMessageDialog(null,"day addedd succesfully..");
           refreshDays();
       }catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       YearBean yearBean = (YearBean)yearComboBox.getSelectedItem();
       if(yearBean==null){
           JOptionPane.showMessageDialog(this, "Please add a year from 'Add Year' frame");
           return;
       }
       if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
       DayBean dayBean = (DayBean)dayList.getSelectedValue();
       String day = dayFormattedTextField.getText();
       String dayId = dayIdTextField.getText();
       if(day.equals("") || day.length()<8){
           JOptionPane.showMessageDialog(this, "Invalid Date");
           return;
       }
       day=DateFormatter.FlipDateAndMonth(day);
        try{
           DatabaseManager.updateDay(yearBean.getYearId(), Integer.parseInt(dayId), day,closeCheckBox.isSelected() , remarksTextArea.getText());
           JOptionPane.showMessageDialog(null,"day updated succesfully..");
           refreshDays();
        }catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(dayList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null,"no any selected day");
            return;
        }
        int id = Integer.parseInt(dayIdTextField.getText());
        try{
            DatabaseManager.deleteDay(id);
            refreshDays();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
}//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
}//GEN-LAST:event_clearButtonActionPerformed

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        
        refreshDays();
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayIdLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JCheckBox closeCheckBox;
    private javax.swing.JFormattedTextField dayFormattedTextField;
    private javax.swing.JTextField dayIdTextField;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JLabel dayLabel1;
    private javax.swing.JList dayList;
    private javax.swing.JScrollPane dayListScrollPane;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
}
