
/**
 * @author Jay Kumar Tharwani
 */
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    DayFrame dayFrame = new DayFrame();
    DayCloseFrame dayClose;
    DoctorFrame doctor;
    PatientFrame patient;
    YearFrame year;
    PatientSummary summary;
    
    public MainFrame() {
        initComponents();
        dayFrame = new DayFrame();
        dayClose =  new DayCloseFrame();
        doctor = new DoctorFrame();
        patient = new PatientFrame();
        year = new YearFrame();
        summary = new PatientSummary();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        headingLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionMenu = new javax.swing.JMenu();
        MenuItemAddDay = new javax.swing.JMenuItem();
        MenuItemAddDoctor = new javax.swing.JMenuItem();
        MenuItemAddPatient = new javax.swing.JMenuItem();
        yearMenuItem = new javax.swing.JMenuItem();
        MenuItemCloseDay = new javax.swing.JMenuItem();
        summaryMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinic Management");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("<html>Developer: JAY KUMAR THARWANI<br>Team incharge: PREM SOMJI</html>");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 0, 240, 40);

        headingLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        headingLabel.setText("<html>WELCOME TO MENHAR CLINIC<BR \\>PANJIANI CHOK SANGHAR</html>");
        getContentPane().add(headingLabel);
        headingLabel.setBounds(210, 250, 780, 240);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel);
        logoLabel.setBounds(100, 0, 210, 220);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1003, 749);

        optionMenu.setMnemonic('O');
        optionMenu.setText("Options");

        MenuItemAddDay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemAddDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/date2.png"))); // NOI18N
        MenuItemAddDay.setText("Add Day");
        MenuItemAddDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAddDayActionPerformed(evt);
            }
        });
        optionMenu.add(MenuItemAddDay);

        MenuItemAddDoctor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemAddDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/doctor-icon.png"))); // NOI18N
        MenuItemAddDoctor.setText("Add Doctor");
        MenuItemAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAddDoctorActionPerformed(evt);
            }
        });
        optionMenu.add(MenuItemAddDoctor);

        MenuItemAddPatient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemAddPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Patients-icon.png"))); // NOI18N
        MenuItemAddPatient.setText("Add Patient");
        MenuItemAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAddPatientActionPerformed(evt);
            }
        });
        optionMenu.add(MenuItemAddPatient);

        yearMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        yearMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Apps-Calendar-Metro-icon.png"))); // NOI18N
        yearMenuItem.setText("Add Year");
        yearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(yearMenuItem);

        MenuItemCloseDay.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemCloseDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/run-icon.png"))); // NOI18N
        MenuItemCloseDay.setText("Close Day");
        MenuItemCloseDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCloseDayActionPerformed(evt);
            }
        });
        optionMenu.add(MenuItemCloseDay);

        summaryMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        summaryMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Zoom-icon.png"))); // NOI18N
        summaryMenuItem.setText("Patient Summary");
        summaryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(summaryMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/glossy-3d-blue-delete-icon.png"))); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        optionMenu.add(jMenuItem1);

        jMenuBar1.add(optionMenu);

        jMenu2.setMnemonic('H');
        jMenu2.setText("Help");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Help-icon.png"))); // NOI18N
        aboutMenuItem.setText("about");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(aboutMenuItem);

        helpMenuItem.setText("help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(helpMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAddPatientActionPerformed
        patient.setVisible(true);
    }//GEN-LAST:event_MenuItemAddPatientActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Do you ant to exit?","Exit", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuItemAddDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAddDayActionPerformed
        dayFrame.setVisible(true);
    }//GEN-LAST:event_MenuItemAddDayActionPerformed

    private void MenuItemAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAddDoctorActionPerformed
        doctor.setVisible(true);
    }//GEN-LAST:event_MenuItemAddDoctorActionPerformed

    private void MenuItemCloseDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCloseDayActionPerformed
        dayClose.setVisible(true);
    }//GEN-LAST:event_MenuItemCloseDayActionPerformed

    private void yearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearMenuItemActionPerformed
        year.setVisible(true);
    }//GEN-LAST:event_yearMenuItemActionPerformed

    private void summaryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryMenuItemActionPerformed
        summary.setVisible(true);
    }//GEN-LAST:event_summaryMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This software is developed by : JAY KUMAR\njay_tharwani1992@yahoo.com (+92-315-3028704)");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
       try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"readme.txt");
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_helpMenuItemActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                int width = Toolkit.getDefaultToolkit().getScreenSize().width;
                int height = Toolkit.getDefaultToolkit().getScreenSize().height;
                frame.setSize(width-20, height-50);
                frame.backgroundLabel.setSize(frame.getSize());
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemAddDay;
    private javax.swing.JMenuItem MenuItemAddDoctor;
    private javax.swing.JMenuItem MenuItemAddPatient;
    private javax.swing.JMenuItem MenuItemCloseDay;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JMenuItem summaryMenuItem;
    private javax.swing.JMenuItem yearMenuItem;
    // End of variables declaration//GEN-END:variables
}
