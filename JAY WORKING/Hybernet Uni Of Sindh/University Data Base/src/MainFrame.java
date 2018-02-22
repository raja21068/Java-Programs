
public class MainFrame extends javax.swing.JFrame {

    FacultyFrame faculty;
    DepartmentFrame department;
    ProgramFrame program;
    BatchFrame batch;
    StudentFrame student;
    public MainFrame() {
        initComponents();
        faculty = new FacultyFrame(this);
        department = new DepartmentFrame(this);
        program = new ProgramFrame(this);
        batch = new BatchFrame(this);
        student = new StudentFrame(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        facultyMenuItem = new javax.swing.JMenuItem();
        departmentMenuItem = new javax.swing.JMenuItem();
        programMenuItem = new javax.swing.JMenuItem();
        batchMenuItem = new javax.swing.JMenuItem();
        studentMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Options");

        facultyMenuItem.setText("Faculty");
        facultyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(facultyMenuItem);

        departmentMenuItem.setText("Department");
        departmentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(departmentMenuItem);

        programMenuItem.setText("Program");
        programMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(programMenuItem);

        batchMenuItem.setText("Batch");
        batchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(batchMenuItem);

        studentMenuItem.setText("Student");
        studentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(studentMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facultyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyMenuItemActionPerformed
        faculty.setVisible(true);
    }//GEN-LAST:event_facultyMenuItemActionPerformed

    private void departmentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentMenuItemActionPerformed
        department.setVisible(true);
    }//GEN-LAST:event_departmentMenuItemActionPerformed

    private void programMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programMenuItemActionPerformed
        program.setVisible(true);
    }//GEN-LAST:event_programMenuItemActionPerformed

    private void batchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchMenuItemActionPerformed
        batch.setVisible(true);
    }//GEN-LAST:event_batchMenuItemActionPerformed

    private void studentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentMenuItemActionPerformed
        student.setVisible(true);
    }//GEN-LAST:event_studentMenuItemActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem batchMenuItem;
    private javax.swing.JMenuItem departmentMenuItem;
    private javax.swing.JMenuItem facultyMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem programMenuItem;
    private javax.swing.JMenuItem studentMenuItem;
    // End of variables declaration//GEN-END:variables
}
