
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookIssueFrame.java
 *
 * Created on Dec 2, 2012, 10:31:06 AM
 */
/**
 *
 * @author DELL
 */
public class BookIssueFrame extends javax.swing.JFrame {

    /** Creates new form BookIssueFrame */
    public BookIssueFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        bookIssueListScrollPane = new javax.swing.JScrollPane();
        bookIssueList = new javax.swing.JList();
        listLabel = new javax.swing.JLabel();
        bookNameComboBox = new javax.swing.JComboBox();
        bookNameLabel = new javax.swing.JLabel();
        dateIssueLabel = new javax.swing.JLabel();
        issueDateChooser = new com.toedter.calendar.JDateChooser();
        dateReturnLabel = new javax.swing.JLabel();
        returnDateChooser = new com.toedter.calendar.JDateChooser();
        fineAmountFormattedTextField = new javax.swing.JFormattedTextField();
        fineAmountLabel = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        departmentLabel = new javax.swing.JLabel();
        batchYearLabel = new javax.swing.JLabel();
        rollNoLabel = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        remarksAreaScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        issueIdLabel = new javax.swing.JLabel();
        issueIdTextField = new javax.swing.JTextField();
        batchYearChooser = new com.toedter.calendar.JYearChooser();
        departmentTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(770, 570));
        setName("Book Issue"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(204, 0, 102));
        mainLabel.setText("B O O K  I S S U E");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(270, 10, 160, 30);

        bookIssueList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                bookIssueListValueChanged(evt);
            }
        });
        bookIssueListScrollPane.setViewportView(bookIssueList);

        getContentPane().add(bookIssueListScrollPane);
        bookIssueListScrollPane.setBounds(540, 80, 200, 430);

        listLabel.setText("Book Issued");
        getContentPane().add(listLabel);
        listLabel.setBounds(600, 54, 70, 20);

        getContentPane().add(bookNameComboBox);
        bookNameComboBox.setBounds(150, 80, 290, 20);

        bookNameLabel.setText("Books Name");
        getContentPane().add(bookNameLabel);
        bookNameLabel.setBounds(70, 80, 70, 20);

        dateIssueLabel.setText("Date Of Issue");
        getContentPane().add(dateIssueLabel);
        dateIssueLabel.setBounds(70, 150, 70, 14);
        getContentPane().add(issueDateChooser);
        issueDateChooser.setBounds(150, 150, 290, 20);

        dateReturnLabel.setText("Date Of Return");
        getContentPane().add(dateReturnLabel);
        dateReturnLabel.setBounds(70, 190, 80, 14);
        getContentPane().add(returnDateChooser);
        returnDateChooser.setBounds(150, 190, 290, 20);

        try {
            fineAmountFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(fineAmountFormattedTextField);
        fineAmountFormattedTextField.setBounds(150, 240, 280, 20);

        fineAmountLabel.setText("Fine Amount");
        getContentPane().add(fineAmountLabel);
        fineAmountLabel.setBounds(70, 240, 70, 20);

        studentNameLabel.setText("Student Name");
        getContentPane().add(studentNameLabel);
        studentNameLabel.setBounds(70, 290, 80, 20);
        getContentPane().add(studentNameTextField);
        studentNameTextField.setBounds(150, 290, 280, 20);

        departmentLabel.setText("Department");
        getContentPane().add(departmentLabel);
        departmentLabel.setBounds(70, 330, 70, 20);

        batchYearLabel.setText("Batch Year");
        getContentPane().add(batchYearLabel);
        batchYearLabel.setBounds(70, 370, 70, 20);

        rollNoLabel.setText("Roll No.");
        getContentPane().add(rollNoLabel);
        rollNoLabel.setBounds(270, 370, 70, 20);
        getContentPane().add(rollNoTextField);
        rollNoTextField.setBounds(320, 370, 110, 20);

        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(70, 410, 60, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksAreaScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksAreaScrollPane);
        remarksAreaScrollPane.setBounds(120, 410, 350, 70);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(110, 490, 90, 23);

        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeButton);
        removeButton.setBounds(200, 490, 90, 23);

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(290, 490, 90, 23);

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(380, 490, 90, 23);

        issueIdLabel.setText("Issue Id");
        getContentPane().add(issueIdLabel);
        issueIdLabel.setBounds(70, 120, 70, 20);

        issueIdTextField.setEditable(false);
        getContentPane().add(issueIdTextField);
        issueIdTextField.setBounds(150, 120, 70, 20);
        getContentPane().add(batchYearChooser);
        batchYearChooser.setBounds(150, 370, 110, 20);
        getContentPane().add(departmentTextField);
        departmentTextField.setBounds(150, 330, 280, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        CategoryDetialBean catBean =(CategoryDetialBean )this.bookNameComboBox.getSelectedItem();
        int catId = catBean.getCatDetailId();
        String dep = this.departmentTextField.getText();
        Date issue = this.issueDateChooser.getDate();
        Date ret = this.returnDateChooser.getDate();
        int fine= Integer.parseInt(this.fineAmountFormattedTextField.getText().trim());
        String std= this.studentNameTextField.getText();
        String roll= this.rollNoTextField.getText();
        String remark= this.remarksTextArea.getText();
        int year = this.batchYearChooser.getYear();
        try{
            DatabaseManager.addbook_issue(catId, issue, ret, fine, remark, dep,year , std, roll);
            updateList();
            updateCombo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        try{
            DatabaseManager.deletebook_issue(Integer.parseInt(this.issueIdTextField.getText()));
            updateList();
            updateCombo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        BookIssueBean bean = (BookIssueBean)bookIssueList.getSelectedValue();
        if(bean==null){
            JOptionPane.showMessageDialog(null,"invalid list selection");
            return;
        }
        CategoryDetialBean catBean =(CategoryDetialBean )this.bookNameComboBox.getSelectedItem();
        int id = Integer.parseInt(issueIdTextField.getText());
        int catId = catBean.getCatDetailId();
        String dep = this.departmentTextField.getText();
        Date issue = this.issueDateChooser.getDate();
        Date ret = this.returnDateChooser.getDate();
        int fine= Integer.parseInt(this.fineAmountFormattedTextField.getText());
        String std= this.studentNameTextField.getText();
        String roll= this.rollNoTextField.getText();
        String remark= this.remarksTextArea.getText();
        int year = this.batchYearChooser.getYear();
        try{
            DatabaseManager.updatebook_issue(id, catId, issue, ret, fine, remark, dep,year , std, roll);
            updateList();
            updateCombo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        this.issueIdTextField.setText("");
        this.fineAmountFormattedTextField.setText("");
        this.studentNameTextField.setText("");
        this.departmentTextField.setText("");
        this.rollNoTextField.setText("");
        this.remarksTextArea.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void bookIssueListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_bookIssueListValueChanged
        BookIssueBean bean = (BookIssueBean)bookIssueList.getSelectedValue();
        for(int i=0;i<this.bookNameComboBox.getItemCount();i++){
            CategoryDetialBean catBean =(CategoryDetialBean) bookNameComboBox.getItemAt(i);
            if(bean.getCatDetailId()==catBean.getCatDetailId()){
                bookNameComboBox.setSelectedIndex(i);
                break;
            }
        }
        this.issueIdTextField.setText(""+bean.getIssueId());
        this.departmentTextField.setText(bean.getDepartmentName());
        this.issueDateChooser.setDate(bean.getDateOfIssue());
        this.returnDateChooser.setDate(bean.getDateOfReturn());
        this.fineAmountFormattedTextField.setText(""+bean.getFineAmount());
        this.studentNameTextField.setText(bean.getStudentName());
        this.departmentTextField.setText(bean.getDepartmentName());
        this.rollNoTextField.setText(bean.getRollNo());
        this.remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_bookIssueListValueChanged
    public void setVisible(){
        try{
            updateList();
            updateCombo();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
        setVisible(true);
    }
    public void updateList()throws Exception{
        Vector v = DatabaseManager.getAllbook_issue();
        bookIssueList.setListData(v);
    }
    public void updateCombo()throws Exception{
        bookNameComboBox.removeAllItems();
        Vector v = DatabaseManager.getAllcategory_detial();
        for (int i=0;i<v.size();i++){
            bookNameComboBox.addItem((CategoryDetialBean)v.elementAt(i));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private com.toedter.calendar.JYearChooser batchYearChooser;
    private javax.swing.JLabel batchYearLabel;
    private javax.swing.JList bookIssueList;
    private javax.swing.JScrollPane bookIssueListScrollPane;
    private javax.swing.JComboBox bookNameComboBox;
    private javax.swing.JLabel bookNameLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dateIssueLabel;
    private javax.swing.JLabel dateReturnLabel;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextField departmentTextField;
    private javax.swing.JFormattedTextField fineAmountFormattedTextField;
    private javax.swing.JLabel fineAmountLabel;
    private com.toedter.calendar.JDateChooser issueDateChooser;
    private javax.swing.JLabel issueIdLabel;
    private javax.swing.JTextField issueIdTextField;
    private javax.swing.JLabel listLabel;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JScrollPane remarksAreaScrollPane;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton removeButton;
    private com.toedter.calendar.JDateChooser returnDateChooser;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}