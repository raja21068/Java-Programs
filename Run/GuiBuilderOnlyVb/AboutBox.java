/*
 * AboutBox.java
 *
 * Created on 27-Jul-2011, 00:37:27
 */

/**
 *
 * @author Raja
 */
public class AboutBox extends javax.swing.JDialog {

    /** Creates new form AboutBox */
    public AboutBox(MainFrame parent) {
        super(parent, true);
        initComponents();
        this.setSize(400, 210);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel appEmailLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel emailLabel = new javax.swing.JLabel();
        javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
        javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setMinimumSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        appEmailLabel.setText("raja21068@facebook.com");
        getContentPane().add(appEmailLabel);
        appEmailLabel.setBounds(216, 143, 149, 16);

        appVendorLabel.setText("RAJA");
        getContentPane().add(appVendorLabel);
        appVendorLabel.setBounds(248, 121, 29, 16);

        appVersionLabel.setText("2.0");
        getContentPane().add(appVersionLabel);
        appVersionLabel.setBounds(256, 99, 18, 16);

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText("Product Version:");
        getContentPane().add(versionLabel);
        versionLabel.setBounds(137, 99, 109, 16);

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText("Vendor:");
        getContentPane().add(vendorLabel);
        vendorLabel.setBounds(137, 121, 52, 16);

        emailLabel.setFont(emailLabel.getFont().deriveFont(emailLabel.getFont().getStyle() | java.awt.Font.BOLD));
        emailLabel.setText("Email:");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(137, 143, 37, 16);

        appDescLabel.setText("<html>Database Gui Generator based on Swing Application Framework Using Java Technology");
        getContentPane().add(appDescLabel);
        appDescLabel.setBounds(137, 43, 213, 16);

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appTitleLabel.setText("Database Gui Generator");
        getContentPane().add(appTitleLabel);
        appTitleLabel.setBounds(137, 11, 213, 21);

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about_1.png"))); // NOI18N
        getContentPane().add(imageLabel);
        imageLabel.setBounds(0, 0, 130, 177);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("Note:\n1: ListBox name must be same TABLE NAME \n   eg: employeesListBox, FaculityListBox\n2: TextBox names same as column name \n   eg: employeeIDTextBox, EmployeeNameTextBox\n\tFacIdTextBox, FacNameTextBox, \n\tRemartksTextBox\n3: Button Name Must Be AddButton, DeleteButton\n\t UpdateButton, ClearButton");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 380, 190);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
