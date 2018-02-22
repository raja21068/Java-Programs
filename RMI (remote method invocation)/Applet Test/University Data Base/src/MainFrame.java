import java.applet.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Oct 23, 2012, 1:38:45 PM
 */
/**
 *
 * @author jay
 */
public class MainFrame extends Applet {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        facultyFrame = new FacultyFrame(this); 
        department = new DepartmentFrame(this);
        programFrame = new ProgramFrame(this);
        batchFrame = new BatchFrame(this);
        studentFrame = new StudentFrame(this);
         
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
        studentMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setTitle("University Of Sindh");
        setMinimumSize(new java.awt.Dimension(700, 600));
        //setResizable(false);
       // getContentPane().setLayout(null);

        pictureLabel.setIcon(new ImageIcon("wall.jpg"));
        add(pictureLabel);
        pictureLabel.setBounds(1, -4, 400, 280);
        pictureLabel.setBounds(getBounds());

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

        studentMenuItem.setText("Student");
        studentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(studentMenuItem);

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(helpMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        setupMenu.add(exitMenuItem);

        menuBar.add(setupMenu);

        //setJMenuBar(menuBar);

        //pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyMenuItemActionPerformed
        // TODO add your handling code here:
        facultyFrame.setVisible(true);
    }//GEN-LAST:event_facultyMenuItemActionPerformed

    private void departmentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentMenuItemActionPerformed
        // TODO add your handling code here:
        department.setVisible(true);
    }//GEN-LAST:event_departmentMenuItemActionPerformed

    private void programMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programMenuItemActionPerformed
        // TODO add your handling code here:
        programFrame.setVisible(true);
    }//GEN-LAST:event_programMenuItemActionPerformed

    private void batchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchMenuItemActionPerformed
        // TODO add your handling code here:
        batchFrame.setVisible(true);
    }//GEN-LAST:event_batchMenuItemActionPerformed

    private void studentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentMenuItemActionPerformed
        // TODO add your handling code here:
        studentFrame.setVisible(true);
    }//GEN-LAST:event_studentMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(this, "Do you want to exit..?");
        if(exit == 0){ 
            try{
            DatabaseManager.connectionClose();
            }catch(Exception ex){ex.printStackTrace();}
            System.exit(0);
            }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
         // TODO add your handling code here:
        String message = "This project is \"Addmission System of University Of Sindh \""
                + "\n Where There is Frames of Faculty , Department , Program , batch and "
                + "Student. \nInside the database is working, with records.."
                + "\nDatabase is on \'Microsoft Access\' in which every frame has seperate table"
                + "\nLISTS:\n      Whenever you click on any list, type the first alphabat of name,\n which you want to see.."
                +"\n This Project is developed by : JAY KUMAR 2k11/csm/25 (Computer Science) University Of Sindh";
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                new MainFrame().setVisible(true);
         
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem batchMenuItem;
    private javax.swing.JMenuItem departmentMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem facultyMenuItem;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JMenuItem programMenuItem;
    private javax.swing.JMenu setupMenu;
    private javax.swing.JMenuItem studentMenuItem;
    // End of variables declaration//GEN-END:variables
    FacultyFrame facultyFrame;
    DepartmentFrame department;
    ProgramFrame programFrame;
    BatchFrame batchFrame;
    StudentFrame studentFrame;
}
