/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BatchFrame.java
 *
 * Created on Oct 12, 2012, 11:52:13 AM
 */
/**
 *
 * @author Jay Kumar
 */
public class BatchFrame extends javax.swing.JFrame {

    /** Creates new form BatchFrame */
    public BatchFrame() {
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
        listScroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        depIdLbl = new javax.swing.JLabel();
        batchIdTxt = new javax.swing.JTextField();
        progLbl = new javax.swing.JLabel();
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
        facComboBox = new javax.swing.JComboBox();
        depComboBox = new javax.swing.JComboBox();
        batchLabel = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        progComboBox = new javax.swing.JComboBox();
        batchYearTxt = new javax.swing.JTextField();
        batchYearLabel = new javax.swing.JLabel();
        groupLbl = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 450));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("B a t c h   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 260, 30);

        listScroll.setViewportView(list);

        getContentPane().add(listScroll);
        listScroll.setBounds(320, 70, 150, 290);

        depIdLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        depIdLbl.setText("Department");
        getContentPane().add(depIdLbl);
        depIdLbl.setBounds(20, 70, 110, 30);
        getContentPane().add(batchIdTxt);
        batchIdTxt.setBounds(100, 150, 210, 20);

        progLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        progLbl.setText("Program");
        getContentPane().add(progLbl);
        progLbl.setBounds(20, 110, 60, 30);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(20, 270, 50, 20);

        remarkScroll.setViewportView(remarkTxt);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(30, 290, 280, 70);

        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(10, 370, 90, 30);

        DelBtn.setText("DEL");
        getContentPane().add(DelBtn);
        DelBtn.setBounds(110, 370, 90, 30);

        updateBtn.setText("Update");
        getContentPane().add(updateBtn);
        updateBtn.setBounds(210, 370, 90, 30);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn);
        clearBtn.setBounds(310, 370, 90, 30);

        listLbl.setText("Batch List");
        getContentPane().add(listLbl);
        listLbl.setBounds(350, 40, 80, 30);

        backBtn.setText("Back");
        getContentPane().add(backBtn);
        backBtn.setBounds(410, 370, 70, 30);

        facLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        facLbl.setText("Faculty ID");
        getContentPane().add(facLbl);
        facLbl.setBounds(20, 40, 70, 30);

        getContentPane().add(facComboBox);
        facComboBox.setBounds(100, 50, 210, 20);

        getContentPane().add(depComboBox);
        depComboBox.setBounds(100, 80, 210, 22);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchLabel.setText("Batch ID");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(20, 150, 60, 20);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(20, 210, 60, 16);

        getContentPane().add(progComboBox);
        progComboBox.setBounds(100, 120, 210, 22);
        getContentPane().add(batchYearTxt);
        batchYearTxt.setBounds(100, 180, 210, 20);

        batchYearLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        batchYearLabel.setText("Batch Year");
        getContentPane().add(batchYearLabel);
        batchYearLabel.setBounds(20, 180, 140, 20);

        groupLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        groupLbl.setText("Group");
        getContentPane().add(groupLbl);
        groupLbl.setBounds(20, 230, 110, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Evening", "Noon" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(100, 210, 210, 20);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Commerce" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(100, 240, 210, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BatchFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField batchIdTxt;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JLabel batchYearLabel;
    private javax.swing.JTextField batchYearTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox depComboBox;
    private javax.swing.JLabel depIdLbl;
    private javax.swing.JComboBox facComboBox;
    private javax.swing.JLabel facLbl;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLbl;
    private javax.swing.JList list;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JComboBox progComboBox;
    private javax.swing.JLabel progLbl;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}