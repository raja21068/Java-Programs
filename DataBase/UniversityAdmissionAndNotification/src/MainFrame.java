/*
   @author Jay Kumar
 */
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.pictureLabel.setSize(getSize());
        facultyFrame = new FacultyFrame(this); 
        department = new DepartmentFrame(this);
        programFrame = new ProgramFrame(this);
        batchFrame = new BatchFrame(this);
        studentFrame = new StudentFrame(this);
        part = new PartFrame();
        scratchCard = new ScratchCardFrame();
        smsSending = new SmsSenderFrame();
        studentPartRegistrationFrame = new StudentPartRegistrationFrame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        setupMenu = new javax.swing.JMenu();
        facultyMenuItem = new javax.swing.JMenuItem();
        departmentMenuItem = new javax.swing.JMenuItem();
        programMenuItem = new javax.swing.JMenuItem();
        batchMenuItem = new javax.swing.JMenuItem();
        partEntryMenuItem = new javax.swing.JMenuItem();
        scratchCardMenuItem = new javax.swing.JMenuItem();
        studentMenuItem = new javax.swing.JMenuItem();
        studentPartRegsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        smsSendingMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Of Sindh");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        pictureLabel.setBackground(new java.awt.Color(255, 255, 255));
        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/wall.jpg"))); // NOI18N
        pictureLabel.setOpaque(true);
        getContentPane().add(pictureLabel);
        pictureLabel.setBounds(1, -4, 760, 460);
        pictureLabel.setSize(getSize());

        setupMenu.setText("Setup");

        facultyMenuItem.setText("Faculty");
        facultyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(facultyMenuItem);

        departmentMenuItem.setText("Department");
        departmentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(departmentMenuItem);

        programMenuItem.setText("Program");
        programMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(programMenuItem);

        batchMenuItem.setText("Batch");
        batchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(batchMenuItem);

        partEntryMenuItem.setText("Part Entry");
        partEntryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partEntryMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(partEntryMenuItem);

        scratchCardMenuItem.setText("Scratch Card");
        scratchCardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scratchCardMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(scratchCardMenuItem);

        studentMenuItem.setText("Student");
        studentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(studentMenuItem);

        studentPartRegsMenuItem.setText("Student Part Regs");
        studentPartRegsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentPartRegsMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(studentPartRegsMenuItem);
        setupMenu.add(jSeparator1);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/exit.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(exitMenuItem);

        menuBar.add(setupMenu);

        jMenu1.setText("Notification");

        smsSendingMenuItem.setText("SMS Sending");
        smsSendingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smsSendingMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(smsSendingMenuItem);

        menuBar.add(jMenu1);

        helpMenu.setText("Help");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Help-icon.png"))); // NOI18N
        aboutMenuItem.setText("about");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyMenuItemActionPerformed
        
        facultyFrame.setVisible(true);
    }//GEN-LAST:event_facultyMenuItemActionPerformed

    private void departmentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentMenuItemActionPerformed
        
        department.setVisible(true);
    }//GEN-LAST:event_departmentMenuItemActionPerformed

    private void programMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programMenuItemActionPerformed
        programFrame.setVisible(true);
    }//GEN-LAST:event_programMenuItemActionPerformed

    private void batchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchMenuItemActionPerformed
        batchFrame.setVisible(true);
    }//GEN-LAST:event_batchMenuItemActionPerformed

    private void studentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentMenuItemActionPerformed
        studentFrame.setVisible(true);
    }//GEN-LAST:event_studentMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        
        int exit = JOptionPane.showConfirmDialog(this, "Do you want to exit..?","Exit",JOptionPane.YES_NO_OPTION);
        if(exit == 0){ 
            try{
                DatabaseManager.connectionClose();
            }catch(Exception ex){ex.printStackTrace();}
            System.exit(0);
            }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
         // TODO add your handling code here:
        String message = "This project is \"Addmission System of University Of Sindh \""
                + "\n Where There is Frames of Faculty , Department , Program , batch and "
                + "Student. \nInside the database is working, with records.."
                + "\nDatabase is on \'Microsoft Access\' in which every frame has seperate table"
                + "\nLISTS:\n      Whenever you click on any list, type the first alphabat of name,\n which you want to see.."
                +"\n This Project is developed by : JAY KUMAR 2k11/csm/25 (Computer Science) University Of Sindh";
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void partEntryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partEntryMenuItemActionPerformed
        part.setVisible(true);
    }//GEN-LAST:event_partEntryMenuItemActionPerformed

    private void scratchCardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scratchCardMenuItemActionPerformed
        scratchCard.setVisible(true);
    }//GEN-LAST:event_scratchCardMenuItemActionPerformed

    private void smsSendingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smsSendingMenuItemActionPerformed
        smsSending.setVisible(true);
    }//GEN-LAST:event_smsSendingMenuItemActionPerformed

    private void studentPartRegsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPartRegsMenuItemActionPerformed
        studentPartRegistrationFrame.setVisible(true);
    }//GEN-LAST:event_studentPartRegsMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler README.txt");
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_helpMenuItemActionPerformed

 
    public static void main(String args[]) {
          new MainFrame().setVisible(true);
         
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem batchMenuItem;
    private javax.swing.JMenuItem departmentMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem facultyMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem partEntryMenuItem;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JMenuItem programMenuItem;
    private javax.swing.JMenuItem scratchCardMenuItem;
    private javax.swing.JMenu setupMenu;
    private javax.swing.JMenuItem smsSendingMenuItem;
    private javax.swing.JMenuItem studentMenuItem;
    private javax.swing.JMenuItem studentPartRegsMenuItem;
    // End of variables declaration//GEN-END:variables
    FacultyFrame facultyFrame;
    DepartmentFrame department;
    ProgramFrame programFrame;
    BatchFrame batchFrame;
    StudentFrame studentFrame;
    PartFrame part ;
    ScratchCardFrame scratchCard;
    SmsSenderFrame smsSending;
    StudentPartRegistrationFrame studentPartRegistrationFrame;
}
