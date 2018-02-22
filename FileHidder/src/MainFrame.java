
import java.util.List;
import java.util.Vector;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay K
 */
public class MainFrame extends javax.swing.JFrame {

    public Vector filesVector;
    JFileChooser choose;
    LoginDialog login;
    
    public MainFrame() {
        initComponents();
        filesVector = new Vector();
        login = new LoginDialog(this, rootPaneCheckingEnabled);
        choose = new JFileChooser("/");
        choose.setMultiSelectionEnabled(true);
        jPanel1.setDropTarget(new DropTarget() {
        public synchronized void drop(DropTargetDropEvent evt) {
            try {
                evt.acceptDrop(DnDConstants.ACTION_COPY);
                List<File> droppedFiles = (List<File>) evt
                        .getTransferable().getTransferData(
                                DataFlavor.javaFileListFlavor);
                addInList(droppedFiles.toArray());
                hide(droppedFiles.toArray());
                addInDatabase(droppedFiles.toArray());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFiles = new javax.swing.JList();
        jToolBar1 = new javax.swing.JToolBar();
        buttonAdd = new javax.swing.JButton();
        buttonShow = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Hidder");
        setMinimumSize(new java.awt.Dimension(621, 490));
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(listFiles);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(38, 81, 558, 360);

        jToolBar1.setRollover(true);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Add-icon.png"))); // NOI18N
        buttonAdd.setText("Add");
        buttonAdd.setFocusable(false);
        buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonAdd);

        buttonShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Security-Key-icon.png"))); // NOI18N
        buttonShow.setText("show");
        buttonShow.setFocusable(false);
        buttonShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonShow);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(-3, 21, 620, 50);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowActionPerformed
        List l = listFiles.getSelectedValuesList();
        try {
            visible(l);
            deleteFromDatabase(l);
            deleteFromList(l.toArray());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonShowActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            choose.showOpenDialog(this);
            File[] files = choose.getSelectedFiles();
            addInList(files);
            hide(files);
            addInDatabase(files);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"failed.."+ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    public void hide(Object[] files){
    
        for(Object f : files){
            try{
                System.out.println(">> "+f);
                Runtime.getRuntime().exec("attrib +s +h \""+f+"\"");
            }catch(Exception ex){ System.out.println("file "+f+" cant hide due to "+ex); }
        }
    }

    public void visible(List<String> files){
    
        for(String f : files){
            try{
                Runtime.getRuntime().exec("attrib -s -h \""+f+"\"");
            }catch(Exception ex){ System.out.println("file "+f+" cant hide due to "+ex); }
        }
    }
    
    public void addInList(Object[] files){
        try{
            for(Object f : files){
                File file = (File)f;
                filesVector.addElement(file.getAbsolutePath());
            }
        }catch(Exception ex){
            for(Object f : files){
                filesVector.addElement(f);
            }
        }
        listFiles.setListData(filesVector);
    }
    
    public void deleteFromList(Object[] files){
        
        for(Object f : files){
            filesVector.remove(f);
        }
        listFiles.setListData(filesVector);
    }
    
    public void addInDatabase(Object[] files)throws Exception{
        for(Object f : files){
            DatabaseManager.add(""+f);
        }
    }
    public void deleteFromDatabase(List<String> files)throws Exception{
        for(String f : files){
            DatabaseManager.deletePath(f);
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        try{
            Vector v = DatabaseManager.getFiles();
            addInList(v.toArray());
        }catch(Exception ex){ 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,ex);
        }
    }
    
    
    
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
                MainFrame  main = new MainFrame();
                main.login.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonShow;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList listFiles;
    // End of variables declaration//GEN-END:variables
}
