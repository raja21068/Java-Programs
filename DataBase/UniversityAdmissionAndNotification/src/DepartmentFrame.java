
import javax.swing.JOptionPane;

/**
 *
 * @author Jay Kumar
 */
public class DepartmentFrame extends javax.swing.JFrame {

    MainFrame main;
    
    public DepartmentFrame( MainFrame main ) {
        this.main = main;
        initComponents();
        
    }
    public void setVisible(boolean b){
        if(b){
            setAllFacultyInComboBox();
        }
        super.setVisible(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        departmentList = new javax.swing.JList();
        depNameLbl = new javax.swing.JLabel();
        departmentTextField = new javax.swing.JTextField();
        departmentIdTextField = new javax.swing.JTextField();
        departmentIdLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarksTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        listLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        facultyLabel = new javax.swing.JLabel();
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
        getContentPane().add(departmentTextField);
        departmentTextField.setBounds(30, 140, 230, 20);
        getContentPane().add(departmentIdTextField);
        departmentIdTextField.setEnabled(false);
        departmentIdTextField.setBounds(140, 60, 120, 20);

        departmentIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        departmentIdLabel.setText("Department ID :");
        getContentPane().add(departmentIdLabel);
        departmentIdLabel.setBounds(30, 50, 110, 30);

        remarksLabel.setText("Remarks");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(30, 160, 50, 20);

        remarkScroll.setViewportView(remarksTextField);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(30, 180, 230, 70);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    addBtnActionPerformed(evt);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 260, 70, 30);

        DeleteButton.setText("DEL");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{ DelBtnActionPerformed(evt); }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(DeleteButton);
        DeleteButton.setBounds(100, 260, 70, 30);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                updateBtnActionPerformed(evt);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(180, 260, 73, 30);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear();
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(260, 260, 70, 30);

        listLabel.setText("Dept List");
        getContentPane().add(listLabel);
        listLabel.setBounds(310, 50, 70, 30);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(340, 260, 70, 30);

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facultyLabel.setText("Faculty");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(30, 80, 50, 30);

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
        if(departmentTextField.getText().trim().length()<4){
            JOptionPane.showMessageDialog(rootPane, "Invalid department name...");
            return;
        }
        FacultyBean faculty = (FacultyBean)facultyComboBox.getSelectedItem();
        boolean check = false;
        int facID = faculty.getFacultyId();
        String depName = departmentTextField.getText();
        DepartmentBean depBean = new DepartmentBean();
        depBean.setfacultyID(facID);
        depBean.setDeptName(depName);
        depBean.setRemarks(remarksTextField.getText());
        
        java.util.Vector v = DatabaseManager.getAllDepartments(facID);
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
        if(departmentTextField.getText().trim().length()<4){
            JOptionPane.showMessageDialog(rootPane, "Invalid department name...");
            return;
        }
        FacultyBean faculty = (FacultyBean)facultyComboBox.getSelectedItem();
        int facID = faculty.getFacultyId();
        System.out.println(facID);
        DepartmentBean depBean = new DepartmentBean();
        depBean.setfacultyID(facID);
        depBean.setDeptID(Integer.parseInt(departmentIdTextField.getText()));
        depBean.setDeptName(departmentTextField.getText());
        depBean.setRemarks(remarksTextField.getText());
        DatabaseManager.updateDepartment(depBean);
        javax.swing.JOptionPane.showMessageDialog(this, depBean.getDeptName()+" is updated...");
        refreshDepartmentList();
    }

    public void clear(){
        departmentIdTextField.setText("");
        departmentTextField.setText("");
        remarksTextField.setText("");
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
     
            setVisible(false);
    }
    
    
    private void departmentListValueChanged(javax.swing.event.ListSelectionEvent e)throws Exception{
        if(e.getSource()==null)return;
        DepartmentBean dBean =(DepartmentBean) departmentList.getSelectedValue();
        departmentIdTextField.setText(""+dBean.getDeptID());
        departmentTextField.setText(dBean.getDeptName());
        remarksTextField.setText(dBean.getRemarks());
    }
    
    private void facultyComboBoxItemStateChanged(java.awt.event.ItemEvent e)throws Exception{
        refreshDepartmentList();
    }
    
    private void setAllFacultyInComboBox() {
        try {
            facultyComboBox.removeAllItems();
            java.util.Vector v = DatabaseManager.getAllFaculty();
            for(int i=0 ; i<v.size() ; i++){
                FacultyBean fBean = (FacultyBean)v.elementAt(i);
                facultyComboBox.addItem(fBean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void refreshDepartmentList()throws Exception{
        FacultyBean facBean = (FacultyBean) facultyComboBox.getSelectedItem();
        if(facBean==null)return;
        java.util.Vector vector = DatabaseManager.getAllDepartments(facBean.getFacultyId());
        departmentList.removeAll();
        departmentList.setListData(vector);
        clear();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JTextField departmentIdTextField;
    private javax.swing.JLabel departmentIdLabel;
    private javax.swing.JLabel depNameLbl;
    private javax.swing.JTextField departmentTextField;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JList departmentList;
    private javax.swing.JLabel listLabel;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarksTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    
}
