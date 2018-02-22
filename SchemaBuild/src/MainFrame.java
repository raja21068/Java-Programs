/**
 * @author Jay Kumar
 */

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.healthmarketscience.jackcess.Database;

public class MainFrame extends javax.swing.JFrame {

    JFileChooser choose;

    public MainFrame()  {
        initComponents();
        choose = new JFileChooser("/");
        choose.removeChoosableFileFilter(choose.getAcceptAllFileFilter());
        choose.addChoosableFileFilter(new FileNameExtensionFilter("(*.mdb)", "mdb"));
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }catch(Exception ex){ex.printStackTrace();}
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        browseTextField.setEditable(false);

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter .mdb File");

        createButton.setText("Create Scheme");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Build Scheme");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(browseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseButton)))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addGap(32, 32, 32)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        choose.showOpenDialog(this);
        browseTextField.setText( choose.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_browseButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if(browseTextField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Please slelect a database");
            return;
        }
        String dbPath = browseTextField.getText().trim();
        
        choose.setApproveButtonText("Save Database Name");
        choose.showSaveDialog(this);
        File f = choose.getSelectedFile();
        String filePath = f.getAbsolutePath();
        if(!f.getName().contains(".mdb")){
            filePath += ".mdb";
        }
        if(filePath.equals(dbPath)){
            JOptionPane.showMessageDialog(this, "The source and destination file is same, please select a different path");
            return;
        }
        try{
            createScheme(dbPath , filePath);
            JOptionPane.showMessageDialog(this, "Schema is created");
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_createButtonActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

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
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private void createScheme(String dbPath, String filePath)throws Exception {
        Connection connection= java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
        
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
        File f = new File(filePath);
        f.createNewFile();
        Database db = Database.create(f);
        db.close();
        Connection destinationConn = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+filePath,"" ,"");       
        while(rs.next()){
            String tableName = rs.getString(3);
            Statement st = connection.createStatement();
            ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
            ResultSetMetaData rsMetaData = tableRS.getMetaData();
            String query="CREATE TABLE "+tableName+"(";
            for(int i=1;i<=rsMetaData.getColumnCount();i++){
                query+= rsMetaData.getColumnName(i)+" "+rsMetaData.getColumnTypeName(i);
                if(i != rsMetaData.getColumnCount()){
                    query += ", ";
                }
            }
            query += " )";
            System.out.println(query);
            try{
                destinationConn.createStatement().executeUpdate(query);
            }catch(Exception ex){System.err.println(ex);}
            st.close();
        }
    }
}
