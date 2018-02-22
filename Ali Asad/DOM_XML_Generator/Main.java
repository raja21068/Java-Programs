
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main extends javax.swing.JFrame {


    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pathText = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        generateXmlButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        destinationPathText = new javax.swing.JTextField();
        browseButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOM XML Generator - By Ali Asad Khowaja");
        jLabel1.setOpaque(true);

        jLabel2.setText("Enter .mdb file:");

        browseButton.setText("Browse..");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        generateXmlButton.setText("Generate XML");
        generateXmlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateXmlButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Select destination path:");

        browseButton2.setText("Browse..");
        browseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(generateXmlButton)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(destinationPathText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pathText))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseButton)
                            .addComponent(browseButton2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationPathText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(generateXmlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".mdb file", "mdb");
        chooser.setFileFilter(filter);
        int k = chooser.showOpenDialog(this);
        if(k==JFileChooser.APPROVE_OPTION){
            pathText.setText(chooser.getSelectedFile().getAbsolutePath());
        }
        
    }//GEN-LAST:event_browseButtonActionPerformed

    private void generateXmlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateXmlButtonActionPerformed
        String path = pathText.getText();
        if(path.isEmpty())
            return;
        
        String destination = destinationPathText.getText();
        if(destination.isEmpty())
            return;
        
        try{
            DatabaseManager db = new DatabaseManager(path);
            System.out.println(path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf(".")));
            String dbName = path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf("."));
            
            Vector<String> tables = db.getTables();
            for(int i=0 ; i<tables.size() ; i++){
                String tableName = tables.elementAt(i);
                Vector<String> columns = db.getColumns(tableName);
                Vector<String> data = db.getData(tableName, columns.size());
                
                WriteXML xml = new WriteXML(destination, dbName, tableName, columns, data);
                xml.start();
            }
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_generateXmlButtonActionPerformed

    private void browseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButton2ActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int k = chooser.showSaveDialog(this);
        if(k==JFileChooser.APPROVE_OPTION){
            destinationPathText.setText(chooser.getSelectedFile().getAbsolutePath());
        }
        
    }//GEN-LAST:event_browseButton2ActionPerformed

    public static void main(String args[]) {
        new Main().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browseButton2;
    private javax.swing.JTextField destinationPathText;
    private javax.swing.JButton generateXmlButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField pathText;
    // End of variables declaration//GEN-END:variables
}
