/*
 * AboutBox.java
 *
 * Created on 27-Jul-2011, 00:37:27
 */

/**
 *
 * @author Kasak
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setResizable(false);

        appEmailLabel.setText("justbeller@hotmail.com");

        appVendorLabel.setText("Yougeshwar Khatri");

        appVersionLabel.setText("2.0");

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText("Product Version:");

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText("Vendor:");

        emailLabel.setFont(emailLabel.getFont().deriveFont(emailLabel.getFont().getStyle() | java.awt.Font.BOLD));
        emailLabel.setText("Email:");

        appDescLabel.setText("<html>Database Bean Generator based on Swing Application Framework Using Java Technology");

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appTitleLabel.setText("Database Bean Generator");

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about_1.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(imageLabel)
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(appTitleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 213, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(appDescLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 213, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(versionLabel)
                        .add(10, 10, 10)
                        .add(appVersionLabel))
                    .add(layout.createSequentialGroup()
                        .add(vendorLabel)
                        .add(59, 59, 59)
                        .add(appVendorLabel))
                    .add(layout.createSequentialGroup()
                        .add(emailLabel)
                        .add(69, 69, 69)
                        .add(appEmailLabel)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(imageLabel)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(appTitleLabel)
                .add(11, 11, 11)
                .add(appDescLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(8, 8, 8)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(versionLabel)
                    .add(appVersionLabel))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(vendorLabel)
                    .add(appVendorLabel))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(emailLabel)
                    .add(appEmailLabel)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
