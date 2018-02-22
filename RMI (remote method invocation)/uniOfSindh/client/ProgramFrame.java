import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class ProgramFrame extends javax.swing.JFrame {
    DatabaseManagerInterface DatabaseManager=  null;
    MainFrame main;
    /** Creates new form ProgramFrame */
    public ProgramFrame(MainFrame main , DatabaseManagerInterface ob) {
        this.main = main;
	DatabaseManager = ob;
        initComponents();
        setAllFaculty();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        programList = new javax.swing.JList();
        depNameLabel = new javax.swing.JLabel();
        progNameTxt = new javax.swing.JTextField();
        progIDText = new javax.swing.JTextField();
        progIdLabel = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTextArea = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        DelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        facNameLabel = new javax.swing.JLabel();
        facNameComboBox = new javax.swing.JComboBox();
        depNameComboBox = new javax.swing.JComboBox();
        progLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        durationText = new javax.swing.JTextField();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 500));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("P r o g r a m   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        programList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programListValueChanged(evt);
            }
        });
        listScroll.setViewportView(programList);

        getContentPane().add(listScroll);
        listScroll.setBounds(350, 80, 180, 270);

        depNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        depNameLabel.setText("Dept Name:");
        getContentPane().add(depNameLabel);
        depNameLabel.setBounds(30, 100, 100, 30);

        progNameTxt.setFont(new java.awt.Font("Tahoma", 1, 13));
        getContentPane().add(progNameTxt);
        progNameTxt.setBounds(130, 180, 200, 30);

        progIDText.setEditable(false);
        progIDText.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(progIDText);
        progIDText.setBounds(140, 150, 160, 20);

        progIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        progIdLabel.setText("Program ID :");
        getContentPane().add(progIdLabel);
        progIdLabel.setBounds(30, 150, 110, 20);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(30, 240, 50, 20);

        remarkScroll.setViewportView(remarkTextArea);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(30, 260, 300, 90);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(10, 360, 90, 30);

        DelButton.setText("DEL");
        DelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DelButton);
        DelButton.setBounds(110, 360, 90, 30);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(213, 360, 90, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(310, 360, 100, 30);

        listLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        listLbl.setText("Program List");
        getContentPane().add(listLbl);
        listLbl.setBounds(390, 50, 90, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(420, 360, 100, 30);

        facNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facNameLabel.setText("Faculty Name:");
        getContentPane().add(facNameLabel);
        facNameLabel.setBounds(30, 60, 90, 30);

        facNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(facNameComboBox);
        facNameComboBox.setBounds(140, 70, 190, 20);

        depNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depNameComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(depNameComboBox);
        depNameComboBox.setBounds(140, 110, 190, 20);

        progLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        progLabel.setText("Program Name");
        getContentPane().add(progLabel);
        progLabel.setBounds(30, 180, 100, 30);

        durationLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        durationLabel.setText("Duration");
        getContentPane().add(durationLabel);
        durationLabel.setBounds(30, 220, 60, 16);
        getContentPane().add(durationText);
        durationText.setBounds(130, 220, 200, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        clearButtonActionPerformed(evt);
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if(programList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        if((progNameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid / Empty program Name");
            return;
        }
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
  
        ProgramBean progBean = new ProgramBean();
        progBean.setDeptID(dBean.getDeptID());
        progBean.setProgID(Integer.parseInt(progIDText.getText()));
        progBean.setProgName(progNameTxt.getText());
        progBean.setDuration(Integer.parseInt(durationText.getText()));
        progBean.setRemarks(remarkTextArea.getText().replace('\'', '-'));
        
        try{
            DatabaseManager.updateProgram(progBean);
        }catch(Exception e){e.printStackTrace();}
        depNameComboBoxItemStateChanged(null);
        clearButtonActionPerformed(evt);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        this.progIDText.setText("");
        this.progNameTxt.setText("");        
        this.durationText.setText("");
        this.remarkTextArea.setText("");        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void facNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facNameComboBoxItemStateChanged
        // TODO add your handling code here:
        if(evt.getSource()==null){ return; }
        depNameComboBox.removeAllItems();
        FacultyBean facBean = (FacultyBean)facNameComboBox.getSelectedItem();
        try{
            Vector vector = DatabaseManager.getAllDept(facBean.factID);
            for(int i =0 ;i<vector.size() ; i++){
                depNameComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_facNameComboBoxItemStateChanged

    private void depNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depNameComboBoxItemStateChanged
        // TODO add your handling code here:
//        if(evt.getSource()==null){ return; }
        programList.removeAll();
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
        try{
        programList.setListData(DatabaseManager.getAllProgram(dBean.getDeptID()));
        }catch(Exception e){e.printStackTrace();}
        clearButtonActionPerformed(null);
    }//GEN-LAST:event_depNameComboBoxItemStateChanged

    private void programListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programListValueChanged
        // TODO add your handling code here:
        if(evt.getSource()==null){ return; }
        ProgramBean progBean = (ProgramBean)programList.getSelectedValue();
        this.progIDText.setText(""+progBean.getProgID());
        this.progNameTxt.setText(progBean.getProgName());
        this.durationText.setText(""+progBean.getDuration());
        this.remarkTextArea.setText(progBean.getRemarks());
    }//GEN-LAST:event_programListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if((progNameTxt.getText().trim().length())<3){
            JOptionPane.showMessageDialog(this, "Invalid / Empty program Name");
            return;
        }
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
  
        ProgramBean progBean = new ProgramBean();
        progBean.setDeptID(dBean.getDeptID());
        progBean.setProgName(progNameTxt.getText());
        progBean.setDuration(Integer.parseInt(durationText.getText()));
        progBean.setRemarks(remarkTextArea.getText().replace('\'', '-'));

        try{
            DatabaseManager.addProgram(progBean);
        }catch(Exception e){e.printStackTrace();}
        this.depNameComboBoxItemStateChanged(null);
        clearButtonActionPerformed(evt);
    }//GEN-LAST:event_addButtonActionPerformed

    private void DelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelButtonActionPerformed
        // TODO add your handling code here:
        if(programList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        ProgramBean pBean = (ProgramBean)this.programList.getSelectedValue();
        
        try {
            DatabaseManager.deleteProgram(pBean);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ProgramFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.depNameComboBoxItemStateChanged(null);
        clearButtonActionPerformed(evt);
    }//GEN-LAST:event_DelButtonActionPerformed
    private void setAllFaculty(){
        try{
            Vector vec = DatabaseManager.getAllFaculty();
            for(int i = 0 ; i<vec.size() ;i++){
                facNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox depNameComboBox;
    private javax.swing.JLabel depNameLabel;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationText;
    private javax.swing.JComboBox facNameComboBox;
    private javax.swing.JLabel facNameLabel;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField progIDText;
    private javax.swing.JLabel progIdLabel;
    private javax.swing.JLabel progLabel;
    private javax.swing.JTextField progNameTxt;
    private javax.swing.JList programList;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTextArea;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    
}
