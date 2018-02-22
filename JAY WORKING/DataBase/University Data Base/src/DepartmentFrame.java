/**
 *
 * @author Jay Kumar
 */
public class DepartmentFrame extends javax.swing.JFrame {

    /** Creates new form DepartmentFrame */
    public DepartmentFrame( FacultyFrame faculty ) {
        this.faculty = faculty;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
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
        comboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 360));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("D e p a r t m e n t   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        listScroll.setViewportView(list);

        getContentPane().add(listScroll);
        listScroll.setBounds(270, 80, 160, 150);

        depNameLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        depNameLbl.setText("Department Name:");
        getContentPane().add(depNameLbl);
        depNameLbl.setBounds(30, 110, 130, 30);
        getContentPane().add(depNameTxt);
        depNameTxt.setBounds(30, 140, 230, 20);
        getContentPane().add(depIDTxt);
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
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(20, 260, 70, 30);

        DelBtn.setText("DEL");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DelBtn);
        DelBtn.setBounds(100, 260, 70, 30);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn);
        updateBtn.setBounds(180, 260, 73, 30);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
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

        getContentPane().add(comboBox);
        comboBox.setBounds(90, 90, 175, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DelBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        faculty.setVisible(true);
        faculty.department.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JTextField depIDTxt;
    private javax.swing.JLabel depIdLbl;
    private javax.swing.JLabel depNameLbl;
    private javax.swing.JTextField depNameTxt;
    private javax.swing.JLabel facLbl;
    private javax.swing.JList list;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
    FacultyFrame faculty;
}
