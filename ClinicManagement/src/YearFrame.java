
import javax.swing.JOptionPane;

public class YearFrame extends javax.swing.JFrame {

    
    public YearFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/calender.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        yearListScrollPane = new javax.swing.JScrollPane();
        yearList = new javax.swing.JList();
        yearIdLabel = new javax.swing.JLabel();
        yearIdTextField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        yearFormattedTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Year");
        setMinimumSize(new java.awt.Dimension(600, 450));
        setResizable(false);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 0));
        mainLabel.setText("YEARLY RECORD");

        yearList.setToolTipText("Year List");
        yearList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                yearListValueChanged(evt);
            }
        });
        yearListScrollPane.setViewportView(yearList);

        yearIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        yearIdLabel.setText("YEAR ID");

        yearIdTextField.setEditable(false);
        yearIdTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        yearLabel.setText("YEAR ");

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setOpaque(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
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

        try {
            yearFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(yearListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addButton)
                .addGap(15, 15, 15)
                .addComponent(updateButton)
                .addGap(15, 15, 15)
                .addComponent(deleteButton)
                .addGap(11, 11, 11)
                .addComponent(clearButton)
                .addGap(15, 15, 15)
                .addComponent(backButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yearIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yearIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(yearFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(yearListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(clearButton)
                    .addComponent(backButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setVisible(boolean b){
        super.setVisible(b);
        if(b){
            refreshYear();
            clear();
        }
    }
    private void refreshYear(){
        try{
            yearList.setListData(DatabaseManager.getYears().toArray());
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void clear(){
        this.yearIdTextField.setText("");
        this.yearFormattedTextField.setText("");
        this.remarksTextArea.setText("");
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String year = yearFormattedTextField.getText();
        String remarks = remarksTextArea.getText();
        if(year.equals("")){
            JOptionPane.showMessageDialog(null, "Year field is empty, please enter a year...");
            return;
        }
        try{
            DatabaseManager.addYear(Integer.parseInt(year), remarks);
            JOptionPane.showMessageDialog(null, "year suucessfully added...");
            refreshYear();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Invalid year");
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);}
        clear();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(yearList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a year from list..");
            return;}
        YearBean bean = (YearBean)yearList.getSelectedValue();
        String year = yearFormattedTextField.getText();
        String remarks = remarksTextArea.getText();
        if(year.equals("")){
            JOptionPane.showMessageDialog(null, "Year field is empty, please enter a year...");
            return;
        }
        try{
            DatabaseManager.updateYear(bean.getYearId(), Integer.parseInt(year), remarks);
            clear();
            refreshYear();
            JOptionPane.showMessageDialog(null, "year suucessfully Updated...");
        }
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(yearList.isSelectionEmpty())
        {JOptionPane.showMessageDialog(null, "Select a year from list..");
            return;}
        int id = Integer.parseInt(yearIdTextField.getText());
        try{
            DatabaseManager.deleteYear(id);
            clear();
            refreshYear();
            JOptionPane.showMessageDialog(null, "year suucessfully Deleted...");
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "year can't be deleted... you have to delete first data linked with this year");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);        
    }//GEN-LAST:event_backButtonActionPerformed

    private void yearListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_yearListValueChanged
        YearBean bean =(YearBean) yearList.getSelectedValue();
        if(bean==null)return;
        yearIdTextField.setText(""+bean.getYearId());
        yearFormattedTextField.setText(""+bean.getYear());
        remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_yearListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JFormattedTextField yearFormattedTextField;
    private javax.swing.JLabel yearIdLabel;
    private javax.swing.JTextField yearIdTextField;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JList yearList;
    private javax.swing.JScrollPane yearListScrollPane;
    // End of variables declaration//GEN-END:variables
}
