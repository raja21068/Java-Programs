import java.applet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class BatchFrame extends Applet {

    MainFrame main;
    public BatchFrame(MainFrame main) {
        this.main = main;
        initComponents();
        setAllFaculty();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        batchList = new javax.swing.JList();
        depNameLabel = new javax.swing.JLabel();
        batchIdTxt = new javax.swing.JTextField();
        progLabel = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        facNameLabel = new javax.swing.JLabel();
        facNameComboBox = new javax.swing.JComboBox();
        depNameComboBox = new javax.swing.JComboBox();
        batchLabel = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        progNameComboBox = new javax.swing.JComboBox();
        batchYearTxt = new javax.swing.JTextField();
        batchYearLabel = new javax.swing.JLabel();
        groupLbl = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();

        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 450));
        setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("B a t c h   I n f o r m a t i o n");
        add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        batchList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                batchListValueChanged(evt);
            }
        });
        listScroll.setViewportView(batchList);

        add(listScroll);
        listScroll.setBounds(320, 70, 150, 290);

        depNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        depNameLabel.setText("Dept Name");
        add(depNameLabel);
        depNameLabel.setBounds(20, 70, 110, 30);

        batchIdTxt.setEditable(false);
        batchIdTxt.setForeground(new java.awt.Color(255, 0, 0));
        add(batchIdTxt);
        batchIdTxt.setBounds(100, 150, 210, 20);

        progLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        progLabel.setText("Program");
        add(progLabel);
        progLabel.setBounds(20, 110, 60, 30);

        remarkLbl.setText("Remarks");
        add(remarkLbl);
        remarkLbl.setBounds(20, 270, 50, 20);

        remarkScroll.setViewportView(remarkTxt);

        add(remarkScroll);
        remarkScroll.setBounds(30, 290, 280, 70);

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn);
        addBtn.setBounds(10, 370, 90, 30);

        DelBtn.setText("DEL");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });
        add(DelBtn);
        DelBtn.setBounds(110, 370, 90, 30);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn);
        updateBtn.setBounds(210, 370, 90, 30);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        add(clearBtn);
        clearBtn.setBounds(310, 370, 90, 30);

        listLbl.setText("Batch List");
        add(listLbl);
        listLbl.setBounds(350, 40, 80, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(410, 370, 70, 30);

        facNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facNameLabel.setText("Fac Name");
        add(facNameLabel);
        facNameLabel.setBounds(20, 40, 70, 30);

        facNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facNameComboBoxItemStateChanged(evt);
            }
        });
        add(facNameComboBox);
        facNameComboBox.setBounds(100, 50, 210, 20);

        depNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depNameComboBoxItemStateChanged(evt);
            }
        });
        add(depNameComboBox);
        depNameComboBox.setBounds(100, 80, 210, 22);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        batchLabel.setText("Batch ID");
        add(batchLabel);
        batchLabel.setBounds(20, 150, 60, 20);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        shiftLabel.setText("Shift");
        add(shiftLabel);
        shiftLabel.setBounds(20, 210, 60, 16);

        progNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                progNameComboBoxItemStateChanged(evt);
            }
        });
        add(progNameComboBox);
        progNameComboBox.setBounds(100, 120, 210, 22);

        batchYearTxt.setFont(new java.awt.Font("Tahoma", 1, 13));
        add(batchYearTxt);
        batchYearTxt.setBounds(100, 180, 210, 20);

        batchYearLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        batchYearLabel.setText("Batch Year");
        add(batchYearLabel);
        batchYearLabel.setBounds(20, 180, 140, 20);

        groupLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        groupLbl.setText("Group");
        add(groupLbl);
        groupLbl.setBounds(20, 230, 110, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening", "Noon" }));
        add(shiftComboBox);
        shiftComboBox.setBounds(100, 210, 210, 20);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Commerce", "No Group" }));
        add(groupComboBox);
        groupComboBox.setBounds(100, 240, 210, 22);

    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        this.batchIdTxt.setText("");
        this.batchYearTxt.setText("");
        this.remarkTxt.setText("");
        
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if((this.batchYearTxt.getText().trim().length())!=4){
            JOptionPane.showMessageDialog(this , "Invalid / Empty batch year");
            return;
        } 
        ProgramBean pBean = (ProgramBean)progNameComboBox.getSelectedItem();
        BatchBean batBean = new BatchBean();
       
        batBean.setProgId(pBean.getProgID());
        batBean.setBatYear(Integer.parseInt(this.batchYearTxt.getText()));
        batBean.setGroup((String)groupComboBox.getSelectedItem());
        batBean.setShift((String)shiftComboBox.getSelectedItem());
        batBean.setRemarks(this.remarkTxt.getText());
        try{
            DatabaseManager.addBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        
        clearBtnActionPerformed(null);
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_addBtnActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        clearBtnActionPerformed(null);
    }//GEN-LAST:event_backButtonActionPerformed

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
         clearBtnActionPerformed(null);
    }//GEN-LAST:event_facNameComboBoxItemStateChanged

    private void depNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depNameComboBoxItemStateChanged
        // TODO add your handling code here:
        progNameComboBox.removeAllItems();
        DepartmentBean dBean = (DepartmentBean)depNameComboBox.getSelectedItem();
        try{
            Vector vec = DatabaseManager.getAllProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                progNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
        clearBtnActionPerformed(null);
    }//GEN-LAST:event_depNameComboBoxItemStateChanged

    private void progNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_progNameComboBoxItemStateChanged
        // TODO add your handling code here:
        batchList.removeAll();
        ProgramBean progBean = (ProgramBean)progNameComboBox.getSelectedItem();
        try {
            Vector vec = DatabaseManager.getAllBatches(progBean.getProgID());
            batchList.setListData(vec);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(BatchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearBtnActionPerformed(null);
    }//GEN-LAST:event_progNameComboBoxItemStateChanged

    private void batchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_batchListValueChanged
        // TODO add your handling code here:
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        try{
        this.batchIdTxt.setText(""+batBean.getBatID());
        this.batchYearTxt.setText(""+batBean.getBatYear());
        this.groupComboBox.setSelectedItem(batBean.getGroup());
        this.shiftComboBox.setSelectedItem(batBean.getShift());
        this.remarkTxt.setText(batBean.getRemarks());
        }catch(NullPointerException ex){System.err.println("NullPointerException at BatchFrame: 282");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_batchListValueChanged

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
        if(batchList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        try{
            DatabaseManager.deleteBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_DelBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(batchList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No batch is Selected from list...");
            return;
        }
        if((this.batchYearTxt.getText().trim().length())!=4){
            JOptionPane.showMessageDialog(this , "Invalid / Empty batch year");
            return;
        } 
        BatchBean batBean = (BatchBean)batchList.getSelectedValue();
        batBean.setBatYear(Integer.parseInt(this.batchYearTxt.getText()));
        batBean.setGroup((String)groupComboBox.getSelectedItem());
        batBean.setShift((String)shiftComboBox.getSelectedItem());
        batBean.setRemarks(this.remarkTxt.getText());
        try{
            DatabaseManager.updateBatch(batBean);
        }catch(Exception ex){ex.printStackTrace();}
        progNameComboBoxItemStateChanged(null);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void setAllFaculty(){
        try{
            Vector vec = DatabaseManager.getAllFaculty();
            for(int i = 0 ; i<vec.size() ;i++){
                facNameComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
    }
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField batchIdTxt;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JList batchList;
    private javax.swing.JLabel batchYearLabel;
    private javax.swing.JTextField batchYearTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox depNameComboBox;
    private javax.swing.JLabel depNameLabel;
    private javax.swing.JComboBox facNameComboBox;
    private javax.swing.JLabel facNameLabel;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLbl;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel progLabel;
    private javax.swing.JComboBox progNameComboBox;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
