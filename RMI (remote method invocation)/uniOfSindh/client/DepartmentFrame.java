import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay Kumar
 */
public class DepartmentFrame extends javax.swing.JFrame{
    DatabaseManagerInterface DatabaseManager=  null;
    MainFrame main;
    
    public DepartmentFrame( MainFrame main , DatabaseManagerInterface ob) {
        this.main = main;
	DatabaseManager = ob;
        initComponents();
        try{
            setAllFacultyInComboBox();
        }catch(Exception e){e.printStackTrace();}
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Init Component">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        departmentList = new javax.swing.JList();
        depNameLbl = new javax.swing.JLabel();
        depNameTxt = new javax.swing.JTextField();
        depIDTxt = new javax.swing.JTextField();
        depIdLbl = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        facLbl = new javax.swing.JLabel();
        facultyComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 360));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("D e p a r t m e n t   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        listScroll.setViewportView(departmentList);
        departmentList.addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                try{
                departmentListValueChanged(e);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(listScroll);
        listScroll.setBounds(270, 80, 160, 150);

        depNameLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        depNameLbl.setText("Department Name:");
        getContentPane().add(depNameLbl);
        depNameLbl.setBounds(30, 110, 130, 30);
        getContentPane().add(depNameTxt);
        depNameTxt.setBounds(30, 140, 230, 20);
        getContentPane().add(depIDTxt);
        depIDTxt.setEnabled(false);
        depIDTxt.setBounds(140, 60, 120, 20);

        depIdLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        depIdLbl.setText("Department ID :");
        getContentPane().add(depIdLbl);
        depIdLbl.setBounds(30, 50, 110, 30);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(30, 160, 50, 20);

        remarkScroll.setViewportView(remarkTxt);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(30, 180, 230, 70);

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    addBtnActionPerformed(evt);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(20, 260, 70, 30);

        DelBtn.setText("DEL");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{ DelBtnActionPerformed(evt); }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(DelBtn);
        DelBtn.setBounds(100, 260, 70, 30);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                updateBtnActionPerformed(evt);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(updateBtn);
        updateBtn.setBounds(180, 260, 73, 30);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear();
            }
        });
        getContentPane().add(clearBtn);
        clearBtn.setBounds(260, 260, 70, 30);

        listLbl.setText("Dept List");
        getContentPane().add(listLbl);
        listLbl.setBounds(310, 50, 70, 30);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn);
        backBtn.setBounds(340, 260, 70, 30);

        facLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        facLbl.setText("Faculty");
        getContentPane().add(facLbl);
        facLbl.setBounds(30, 80, 50, 30);

        getContentPane().add(facultyComboBox);
        facultyComboBox.addItemListener(new java.awt.event.ItemListener(){
           public void itemStateChanged(java.awt.event.ItemEvent e){
               try{
               facultyComboBoxItemStateChanged(e);
               }catch(Exception e1){e1.printStackTrace();}
           } 
        });
        facultyComboBox.setBounds(90, 90, 175, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt)throws Exception {//GEN-FIRST:event_addBtnActionPerformed
        if(depNameTxt.getText().trim().length()<4){
            JOptionPane.showMessageDialog(rootPane, "Invalid department name...");
            return;
        }
        FacultyBean faculty = (FacultyBean)facultyComboBox.getSelectedItem();
        boolean check = false;
        int facID = faculty.factID;
        String depName = depNameTxt.getText();
        DepartmentBean depBean = new DepartmentBean();
        depBean.setfacultyID(facID);
        depBean.setDeptName(depName);
        depBean.setRemarks(remarkTxt.getText());
        
        java.util.Vector v = DatabaseManager.getAllDept(facID);
        for(int i =0 ; i<v.size(); i++){
            DepartmentBean dBean = (DepartmentBean) v.elementAt(i);
            if(dBean.getDeptName().contains(depName)){
                check = true;
                break; }
        }
        if(check){
            javax.swing.JOptionPane.showMessageDialog(rootPane,"This department is already in record....");
        }
        else{
            DatabaseManager.addDepartment(depBean);
            javax.swing.JOptionPane.showMessageDialog(rootPane,"The department "+depBean+" has added to record....");
            
        }
        refreshDepartmentList();
    }

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt)throws Exception {
         if(this.departmentList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No department is selected from list...");
            return;
        }
        DepartmentBean dBean = (DepartmentBean)departmentList.getSelectedValue();
        DatabaseManager.deleteDepartment(dBean.getDeptName());
        javax.swing.JOptionPane.showMessageDialog(this, dBean.getDeptName()+" is deleted...");
        refreshDepartmentList();
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt)throws Exception {
        if(this.departmentList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No department is selected from list...");
            return;
        }
        if(depNameTxt.getText().trim().length()<4){
            JOptionPane.showMessageDialog(rootPane, "Invalid department name...");
            return;
        }
        FacultyBean faculty = (FacultyBean)facultyComboBox.getSelectedItem();
        int facID = faculty.factID;
        System.out.println(facID);
        DepartmentBean depBean = new DepartmentBean();
        depBean.setfacultyID(facID);
        depBean.setDeptID(Integer.parseInt(depIDTxt.getText()));
        depBean.setDeptName(depNameTxt.getText());
        depBean.setRemarks(remarkTxt.getText());
        DatabaseManager.updateDepartment(depBean);
        javax.swing.JOptionPane.showMessageDialog(this, depBean.getDeptName()+" is updated...");
        refreshDepartmentList();
    }

    public void clear(){
        depIDTxt.setText("");
        depNameTxt.setText("");
        remarkTxt.setText("");
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
     
            setVisible(false);
    }
    
    
    private void departmentListValueChanged(javax.swing.event.ListSelectionEvent e)throws Exception{
        
        if(e.getSource()==null)return;
        DepartmentBean dBean =(DepartmentBean) departmentList.getSelectedValue();
        depIDTxt.setText(""+dBean.getDeptID());
        depNameTxt.setText(dBean.getDeptName());
        remarkTxt.setText(dBean.getRemarks());
    }
    
    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent e)throws Exception{
        refreshDepartmentList();
    }
    
    private void setAllFacultyInComboBox()throws Exception{
        facultyComboBox.removeAll();
        java.util.Vector v = DatabaseManager.getAllFaculty();
        for(int i=0 ; i<v.size() ; i++){
            FacultyBean fBean = (FacultyBean)v.elementAt(i);
            facultyComboBox.addItem(fBean);
        }
    }
    
    private void refreshDepartmentList()throws Exception{
        FacultyBean facBean = (FacultyBean) facultyComboBox.getSelectedItem();
        java.util.Vector vector = DatabaseManager.getAllDept(facBean.factID);
        departmentList.removeAll();
        departmentList.setListData(vector);
        clear();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField depIDTxt;
    private javax.swing.JLabel depIdLbl;
    private javax.swing.JLabel depNameLbl;
    private javax.swing.JTextField depNameTxt;
    private javax.swing.JLabel facLbl;
    private javax.swing.JList departmentList;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
    
}
