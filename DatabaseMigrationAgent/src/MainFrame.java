/**
 * @author Jay Kumar
 */

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {

    JFileChooser choose;
    JFileChooser saveChooser;
    JFileChooser fileChooser;
    
    ArrayList errors = new ArrayList();
    public MainFrame() {
        initComponents();
        choose = new JFileChooser("/");
        saveChooser = new JFileChooser("/");
        saveChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        choose.removeChoosableFileFilter(choose.getAcceptAllFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("(*.mdb)", "mdb");
        choose.addChoosableFileFilter(filter);
        
        fileChooser = new JFileChooser("/");
        
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("(*.xml,*.csv)", "xml","csv"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        browseButton = new javax.swing.JButton();
        browseTextField = new javax.swing.JTextField();
        convertButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        openDBTextField = new javax.swing.JTextField();
        loadTableButton = new javax.swing.JButton();
        openDBButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        openFileButton = new javax.swing.JButton();
        openFileTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList();
        loadDbButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Enter .mdb File");

        jLabel3.setText("Migrat File Type");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "xml", "csv" }));

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        browseTextField.setEditable(false);

        convertButton.setText("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(browseTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Database To File", jPanel1);

        loadTableButton.setText("Load Table");
        loadTableButton.setEnabled(false);
        loadTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTableButtonActionPerformed(evt);
            }
        });

        openDBButton.setText("Open");
        openDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDBButtonActionPerformed(evt);
            }
        });

        progressBar.setStringPainted(true);

        jScrollPane2.setViewportView(filesList);

        jLabel6.setText("Enter Target Database");

        openFileButton.setText("Open");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Enter Target File / Folder");

        jScrollPane1.setViewportView(tableList);

        loadDbButton.setText("Load Database");
        loadDbButton.setToolTipText("slect multiple files from list then press it..!");
        loadDbButton.setEnabled(false);
        loadDbButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadDbButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadDbButtonMouseExited(evt);
            }
        });
        loadDbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDbButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(openDBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(openDBButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(openFileTextField)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(openFileButton))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(loadTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                    .addComponent(loadDbButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(openDBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(openDBButton)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(openFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(openFileButton))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loadDbButton)
                        .addComponent(loadTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Load In Database", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Database Migration Agent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        choose.showOpenDialog(this);
        browseTextField.setText( choose.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_browseButtonActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        if(browseTextField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Please select a database");
            return;
        }
        saveChooser.showSaveDialog(this);
        File f = saveChooser.getSelectedFile();
        if(!f.exists()){
            f.mkdir();
        }
        try {
            DatabaseHandler.DBToXml(browseTextField.getText(), f , typeComboBox.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "Files are created");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_convertButtonActionPerformed

    private void loadTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTableButtonActionPerformed
        new Thread(){

            @Override
            public void run() {
                try{
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
                    if(fileName.contains(".xml")){
                        load(fileParent+File.separator+fileName);
                    }else if(fileName.contains(".csv")){
                        loadCsv(fileParent+File.separator+fileName);
                    }
                    JOptionPane.showMessageDialog(null, "Loaded...");
                }else{
                    String filePath = openFileTextField.getText();
                    if(filePath.contains(".xml")){
                        load(filePath);
                    }else{
                        loadCsv(filePath);
                    }
                    JOptionPane.showMessageDialog(null, "Loaded...");
                }
                }catch(Exception ex){ex.printStackTrace();}
            }

        }.start();
    }//GEN-LAST:event_loadTableButtonActionPerformed
    private void load(String filePath){
            infoLabel.setText(filePath);
            XmlHandler xml = new XmlHandler(filePath);
            ArrayList tags = xml.getTags();
            progressBar.setMinimum(0);
            progressBar.setMaximum(tags.size());
            for(int i=0;i<tags.size();i++){
                Hashtable tag =(Hashtable) tags.get(i);
                String query="INSERT into "+xml.getTable()+" (";
                Enumeration en = tag.keys();
                String values="";
                while(en.hasMoreElements()){
                    Object ob = en.nextElement();
                    

                    String val =  tag.get(ob).toString(); 
                    if(!val.trim().equals("null")){
                        values += "'"+val+"'";
                        query += ""+ob;
                        if(en.hasMoreElements()){
                            query += ",";
                            values += ",";
                        }
                    }
                    
                }
               
                query+=") values ("+values+")";
                try{
                    DatabaseHandler.loadInDatabase(openDBTextField.getText(), query);
                }catch(Exception ex){
                    System.err.println(ex);
                    if(!errors.contains(xml.getTable())){
                        errors.add(xml.getTable());
                    }
                }
                progressBar.setValue(i);
            }
            infoLabel.setText("");
    }
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
            String[] files = f.list(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.lastIndexOf('.')>0)
               {
                  // get last index for '.' char
                  int lastIndex = name.lastIndexOf('.');
                  
                  // get extension
                  String str = name.substring(lastIndex);
                  
                  // match path name extension
                  if(str.equals(".csv") || str.equals(".xml"))
                  {
                     return true;
                  }
               }
               return false;
            }        
            });
            filesList.setListData(files);
        }else{
            loadTableButton.setEnabled(true);
            loadDbButton.setEnabled(false);
            filesList.setListData(new Object[]{});
        }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void loadDbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDbButtonActionPerformed
        new Thread(){
            @Override
            public void run() {
                List list = filesList.getSelectedValuesList();
                for(int i=0;i<list.size();i++){
                    if(list.get(i).toString().contains(".xml"))load(openFileTextField.getText()+File.separator+list.get(i));
                    else{
                        try {
                            loadCsv(openFileTextField.getText()+File.separator+list.get(i));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if(list.size()>0){
                    String str="Error Ocuured in these tables";
                    for(int i=0;i<list.size();i++){
                        str+= "\n"+(i+1)+". "+list.get(i);
                    }
                    JOptionPane.showMessageDialog(null, str);
                }
            }
            
        }.start();
        
    }//GEN-LAST:event_loadDbButtonActionPerformed

    private void loadDbButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadDbButtonMouseEntered
        infoLabel.setText("Select multiple files from list then press it..!");
    }//GEN-LAST:event_loadDbButtonMouseEntered

    private void loadDbButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadDbButtonMouseExited
        infoLabel.setText("");
    }//GEN-LAST:event_loadDbButtonMouseExited

    private void loadCsv(String filePath) throws Exception{
       DataInputStream in = new DataInputStream(new FileInputStream(filePath));
       String str =null;
       String cols = in.readLine();
       String columns[] = cols.split(",");
       
       String fileName = new File(filePath).getName();
       String table = fileName.substring(0,fileName.lastIndexOf(".") );
       while((str = in.readLine()) !=null){
           String[] values = str.split(",");

           String originalCols = "";
           String originalValues = "";
           for(int i=0;i<values.length;i++){
               if(values[i]!=null && (!values[i].equals("")) && (!values[i].equals("null"))){
                   originalCols += columns[i];
                   originalValues += "'"+values[i]+"'";
                   if(i != values.length-1){
                       originalCols += " ,";
                       originalValues += " ,";
                   }
               }
           }
           String query = "INSERT into "+table+"("+originalCols+") values ("+originalValues+")";
           try{
               DatabaseHandler.loadInDatabase(openDBTextField.getText(), query);
           }catch(Exception ex){System.err.println(ex);}
           
           System.out.println(query);
       }
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField browseTextField;
    private javax.swing.JButton convertButton;
    private javax.swing.JList filesList;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadDbButton;
    private javax.swing.JButton loadTableButton;
    private javax.swing.JButton openDBButton;
    private javax.swing.JTextField openDBTextField;
    private javax.swing.JButton openFileButton;
    private javax.swing.JTextField openFileTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JList tableList;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
