import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;

public class FileZipper extends javax.swing.JFrame {

    JFileChooser fileChooser;
    
    public FileZipper() {
        initComponents();
        fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setAcceptAllFileFilterUsed(false);
        zipProgressBar.setStringPainted(true);
        unzipProgressBar.setStringPainted(true);
        zipFileProgressBar.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    //<editor-fold defaultstate="collapsed" desc="JAY KUMAR">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zipPanel = new javax.swing.JPanel();
        zipSourceButton = new javax.swing.JButton();
        zipDestinationButton = new javax.swing.JButton();
        zipSourceTextField = new javax.swing.JTextField();
        zipDestinationTextField = new javax.swing.JTextField();
        zipCreateButton = new javax.swing.JButton();
        zipFileNameTextField = new javax.swing.JTextField();
        zipFileNameLabel = new javax.swing.JLabel();
        zipProgressBar = new javax.swing.JProgressBar();
        zipFileProgressBar = new javax.swing.JProgressBar();
        unzipPanel = new javax.swing.JPanel();
        unzipSourceButton = new javax.swing.JButton();
        unzipSourceTextField = new javax.swing.JTextField();
        unzipDestinationButton = new javax.swing.JButton();
        unzipDestinationTextField = new javax.swing.JTextField();
        unzipCreateButton = new javax.swing.JButton();
        unzipProgressBar = new javax.swing.JProgressBar();
        unzipFileNameTextField = new javax.swing.JTextField();
        unzipFileNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zip / Unzip Folder");
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        zipPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Zip File"));

        zipSourceButton.setText("Source");
        zipSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipSourceButtonActionPerformed(evt);
            }
        });

        zipDestinationButton.setText("Distination");
        zipDestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipDestinationButtonActionPerformed(evt);
            }
        });

        zipCreateButton.setText("Create");
        zipCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipCreateButtonActionPerformed(evt);
            }
        });

        zipFileNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        zipFileNameLabel.setText("File Name: ");

        javax.swing.GroupLayout zipPanelLayout = new javax.swing.GroupLayout(zipPanel);
        zipPanel.setLayout(zipPanelLayout);
        zipPanelLayout.setHorizontalGroup(
            zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zipPanelLayout.createSequentialGroup()
                .addGroup(zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(zipSourceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zipDestinationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zipSourceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(zipDestinationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
            .addGroup(zipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zipFileNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(zipFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zipCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zipProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(zipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zipFileProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        zipPanelLayout.setVerticalGroup(
            zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zipPanelLayout.createSequentialGroup()
                .addGroup(zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipSourceButton)
                    .addComponent(zipSourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipDestinationButton)
                    .addComponent(zipDestinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCreateButton)
                    .addComponent(zipFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipFileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zipProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(zipFileProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(zipPanel);
        zipPanel.setBounds(10, 10, 370, 170);

        unzipPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Unzip File"));

        unzipSourceButton.setText("Source");
        unzipSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzipSourceButtonActionPerformed(evt);
            }
        });

        unzipDestinationButton.setText("Distination");
        unzipDestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzipDestinationButtonActionPerformed(evt);
            }
        });

        unzipCreateButton.setText("Create");
        unzipCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unzipCreateButtonActionPerformed(evt);
            }
        });

        unzipFileNameLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        unzipFileNameLabel.setText("File Name: ");

        javax.swing.GroupLayout unzipPanelLayout = new javax.swing.GroupLayout(unzipPanel);
        unzipPanel.setLayout(unzipPanelLayout);
        unzipPanelLayout.setHorizontalGroup(
            unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unzipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unzipProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(unzipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unzipFileNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(unzipFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(unzipCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(unzipPanelLayout.createSequentialGroup()
                .addGroup(unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(unzipSourceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unzipDestinationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unzipDestinationTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(unzipSourceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
        );
        unzipPanelLayout.setVerticalGroup(
            unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unzipPanelLayout.createSequentialGroup()
                .addGroup(unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unzipSourceButton)
                    .addComponent(unzipSourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unzipDestinationButton)
                    .addComponent(unzipDestinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(unzipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unzipCreateButton)
                    .addComponent(unzipFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unzipFileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(unzipProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(unzipPanel);
        unzipPanel.setBounds(10, 180, 370, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//</editor-fold>
    private void zipSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipSourceButtonActionPerformed
        fileChooser.setDialogTitle("Select Folder to zip");
        if(fileChooser.showDialog(this,"Select")==JFileChooser.APPROVE_OPTION){
            zipSourceTextField.setText(fileChooser.getSelectedFile().getPath());
            zipFileNameTextField.setText(fileChooser.getSelectedFile().getName());
        }
       
    }//GEN-LAST:event_zipSourceButtonActionPerformed

    private void zipDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipDestinationButtonActionPerformed
        fileChooser.setDialogTitle("Select Destination Path");
        if(fileChooser.showDialog(this,"Select")==JFileChooser.APPROVE_OPTION){
            zipDestinationTextField.setText(fileChooser.getCurrentDirectory().getPath());
        }
    }//GEN-LAST:event_zipDestinationButtonActionPerformed

    private void zipCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipCreateButtonActionPerformed
        if(zipSourceTextField.getText().length() < 3){
            JOptionPane.showMessageDialog(this, "source is invalid...");
            return;
        }
        if(zipDestinationTextField.getText().length() < 3){
            JOptionPane.showMessageDialog(this, "Destination is invalid...");
            return;
        }
        if(zipFileNameTextField.getText().length() < 1){
            JOptionPane.showMessageDialog(this, "File Name is empty...");
            return;
        }
        new Thread(){
            public void run(){
                if(new File(zipSourceTextField.getText()).isFile()){
                    try{
                        new ZipClass(zipProgressBar , zipFileProgressBar).zipFile(zipSourceTextField.getText() ,
                        zipDestinationTextField.getText()+"/"+ zipFileNameTextField.getText());
                    }catch(Exception e1){e1.printStackTrace();}
                }
                else{
                    try{
                        new ZipClass(zipProgressBar,zipFileProgressBar).zipFolder(zipSourceTextField.getText() ,
                        zipDestinationTextField.getText()+"/"+ zipFileNameTextField.getText());
                    }catch(Exception e){e.printStackTrace(); }
                }
            }
        }.start();
        
        
    }//GEN-LAST:event_zipCreateButtonActionPerformed

    private void unzipSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unzipSourceButtonActionPerformed
          fileChooser.setDialogTitle("Select Folder to Unzip");
          fileChooser.showSaveDialog(this);
          unzipSourceTextField.setText(fileChooser.getSelectedFile().getPath());
          String name = fileChooser.getSelectedFile().getName().replace(".zip","");
          unzipFileNameTextField.setText(name);
          
    }//GEN-LAST:event_unzipSourceButtonActionPerformed

    private void unzipDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unzipDestinationButtonActionPerformed
        fileChooser.setDialogTitle("Select Destination Path");
        if(fileChooser.showDialog(this,"Select")==JFileChooser.APPROVE_OPTION){
            unzipDestinationTextField.setText(fileChooser.getCurrentDirectory().getPath());
        }
    }//GEN-LAST:event_unzipDestinationButtonActionPerformed

    private void unzipCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unzipCreateButtonActionPerformed
        if(unzipSourceTextField.getText().length() < 3){
            JOptionPane.showMessageDialog(this, "source is invalid...");
            return;
        }
        if(unzipDestinationTextField.getText().length() < 3){
            JOptionPane.showMessageDialog(this, "Destination is invalid...");
            return;
        }
        
        
        new Thread(){
            public void run(){
                try{  
//                  System.out.println(unzipDestinationTextField.getText()+"/"+unzipFileNameTextField.getText());
                    new ZipClass(unzipProgressBar).unzipFolder(unzipSourceTextField.getText(),unzipDestinationTextField.getText()+"/"+unzipFileNameTextField.getText());   
        }catch(Exception e){e.printStackTrace();}
            }
        }.start();
    }//GEN-LAST:event_unzipCreateButtonActionPerformed
    
    
    public static void main(String args[]) {
        
                new FileZipper().setVisible(true);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton unzipCreateButton;
    private javax.swing.JButton unzipDestinationButton;
    private javax.swing.JTextField unzipDestinationTextField;
    private javax.swing.JLabel unzipFileNameLabel;
    private javax.swing.JTextField unzipFileNameTextField;
    private javax.swing.JPanel unzipPanel;
    private javax.swing.JProgressBar unzipProgressBar;
    private javax.swing.JButton unzipSourceButton;
    private javax.swing.JTextField unzipSourceTextField;
    private javax.swing.JButton zipCreateButton;
    private javax.swing.JButton zipDestinationButton;
    private javax.swing.JTextField zipDestinationTextField;
    private javax.swing.JLabel zipFileNameLabel;
    private javax.swing.JTextField zipFileNameTextField;
    private javax.swing.JProgressBar zipFileProgressBar;
    private javax.swing.JPanel zipPanel;
    private javax.swing.JProgressBar zipProgressBar;
    private javax.swing.JButton zipSourceButton;
    private javax.swing.JTextField zipSourceTextField;
    // End of variables declaration//GEN-END:variables
}
