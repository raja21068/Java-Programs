
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileToDbFrame extends javax.swing.JFrame {
    JFileChooser choose;
    JFileChooser saveChooser;
    JFileChooser fileChooser;
    
    public FileToDbFrame() {
        initComponents();
        choose = new JFileChooser("/");
        saveChooser = new JFileChooser("/");
        fileChooser = new JFileChooser("/");
        
        saveChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        choose.removeChoosableFileFilter(choose.getAcceptAllFileFilter());
        choose.addChoosableFileFilter(new FileNameExtensionFilter("(*.mdb)", "mdb"));
        
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("(*.xml,*.csv)", "xml","csv"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openDBButton = new javax.swing.JButton();
        openDBTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        openFileButton = new javax.swing.JButton();
        openFileTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList();
        loadTableButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loadDbButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openDBButton.setText("Open");
        openDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDBButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter Target Database");

        openFileButton.setText("Open");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter Target File / Folder");

        jScrollPane1.setViewportView(tableList);

        loadTableButton.setText("Load Table");
        loadTableButton.setEnabled(false);
        loadTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTableButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Database Loader");

        loadDbButton.setText("Load Database");
        loadDbButton.setEnabled(false);
        loadDbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDbButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(filesList);

        progressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(openDBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openDBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(openFileTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openFileButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loadTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadDbButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openDBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openDBButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openFileButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadDbButton)
                    .addComponent(loadTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDBButtonActionPerformed
        choose.showOpenDialog(this);
        openDBTextField.setText(choose.getSelectedFile().getAbsolutePath());
        try {
            ArrayList list = DatabaseHandler.getTableName(openDBTextField.getText());
            tableList.setListData(list.toArray());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_openDBButtonActionPerformed

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        fileChooser.showOpenDialog(this);
        File f = fileChooser.getSelectedFile();
        openFileTextField.setText(f.getAbsolutePath());
        if(f.isDirectory()){
            loadTableButton.setEnabled(true);
            loadDbButton.setEnabled(true);
            String[] files = f.list();
            filesList.setListData(files);
        }else{
            loadTableButton.setEnabled(true);
            loadDbButton.setEnabled(false);
            filesList.setListData(new Object[]{});
        }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void loadTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTableButtonActionPerformed
        new Thread(){

            @Override
            public void run() {
                
        if(tableList.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a table");
            return;
        }
        if(new File(openFileTextField.getText()).isDirectory()){
            if(filesList.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Please select a file");
                return;
            }
            String fileName = filesList.getSelectedValue().toString();
            String fileParent = openFileTextField.getText();
            load(fileParent+File.separator+fileName);
        }else{
             String filePath = openFileTextField.getText();
             load(filePath);

        }
            }
            
        }.start();
    }//GEN-LAST:event_loadTableButtonActionPerformed

    private void loadDbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDbButtonActionPerformed
        List list = filesList.getSelectedValuesList();
        for(int i=0;i<list.size();i++){
            load(openFileTextField.getText()+File.separator+list.get(i));
        }
    }//GEN-LAST:event_loadDbButtonActionPerformed

    private void load(String filePath){
        XmlHandler xml = new XmlHandler(filePath);
            ArrayList tags = xml.getTags();
            for(int i=0;i<tags.size();i++){
                Hashtable tag =(Hashtable) tags.get(i);
                String query="INSERT into "+xml.getTable()+" (";
                Enumeration en = tag.keys();
                String values="";
                while(en.hasMoreElements()){
                    Object ob = en.nextElement();
                    query += ""+ob;

                    String val =  tag.get(ob).toString(); 
                    if(val.trim().equals("null")){
                        values += "''";
                    }else{
                        values += "'"+val+"'";
                    }
                    
                   if(en.hasMoreElements()){
                        query += ",";
                        values += ",";
                    }
                }
               
                query+=") values ("+values+")";
                try{
                    DatabaseHandler.loadInDatabase(openDBTextField.getText(), query);
                }catch(Exception ex){System.err.println(ex);}
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
            java.util.logging.Logger.getLogger(FileToDbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileToDbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileToDbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileToDbFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileToDbFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList filesList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadDbButton;
    private javax.swing.JButton loadTableButton;
    private javax.swing.JButton openDBButton;
    private javax.swing.JTextField openDBTextField;
    private javax.swing.JButton openFileButton;
    private javax.swing.JTextField openFileTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JList tableList;
    // End of variables declaration//GEN-END:variables
}
