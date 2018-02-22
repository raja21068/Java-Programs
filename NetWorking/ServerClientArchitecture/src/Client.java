
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Client extends javax.swing.JFrame {

    JFileChooser openDialog;
    public Client() {
        initComponents();
        openDialog = new JFileChooser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();
        fileLabel = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setMinimumSize(new java.awt.Dimension(350, 350));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(0, 255, 204));
        mainLabel.setText("File Transfer");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 110, 22);

        ipLabel.setFont(new java.awt.Font("Stencil", 0, 13)); // NOI18N
        ipLabel.setText("Enter Destination IP");
        getContentPane().add(ipLabel);
        ipLabel.setBounds(11, 60, 150, 14);

        ipTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipTextField.setForeground(new java.awt.Color(255, 153, 153));
        getContentPane().add(ipTextField);
        ipTextField.setBounds(10, 90, 260, 23);

        fileLabel.setFont(new java.awt.Font("Stencil", 0, 13)); // NOI18N
        fileLabel.setText("Enter File");
        getContentPane().add(fileLabel);
        fileLabel.setBounds(10, 140, 90, 20);
        getContentPane().add(fileTextField);
        fileTextField.setBounds(10, 170, 210, 22);

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(220, 170, 90, 25);

        transferButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        transferButton.setText("TRANSFER");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transferButton);
        transferButton.setBounds(40, 210, 220, 40);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(10, 270, 300, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        int i = openDialog.showOpenDialog(this);
        if(i<1){
            fileTextField.setText(openDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        if(ipTextField.getText().isEmpty()||(!(ipTextField.getText().contains(".")))){
            JOptionPane.showMessageDialog(this, "Invalid ip");
            return;
        }
        if(fileTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No file is selected..");
            return;
        }
        
        new Thread(){
            public void run(){
                try{
                    String ip=JOptionPane.showInputDialog(this, "Enter Server IP Address:");
                    Socket socket  = new Socket(ip,9090);            
                    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                    outToServer.writeUTF(ipTextField.getText());
                    FileInputStream fileIn = new FileInputStream(fileTextField.getText());
                    String fileName = new File(fileTextField.getText()).getName();
                    int size= fileIn.available();
                    System.out.println("size: "+size);
                    outToServer.writeUTF(fileName);
                    outToServer.writeUTF(""+size);
                    int packet = 10000;
                    outToServer.writeUTF(""+packet);
                    outToServer.writeUTF(InetAddress.getLocalHost().getHostAddress());
                    byte[] data = new byte[packet];
                    progressBar.setMinimum(0);
                    progressBar.setMaximum( (size/packet)+1);
                     System.out.println("size/packet: "+size/packet);
                    for(int i=1;i<=(size/packet);i++){
                        fileIn.read(data, 0, data.length);
                        outToServer.write(data, 0, data.length);
                        progressBar.setValue(i);
                         System.out.println(i);
//                         Thread.sleep(5);
                    }
                    fileIn.read(data, 0, (size%packet));
                    outToServer.write(data, 0, (size%packet));
                    progressBar.setValue(progressBar.getMaximum());
                    outToServer.close();
                }catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
            }
        }.start();
        
    }//GEN-LAST:event_transferButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         new Client().setVisible(true);
         new InputServerOfClient().start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables
}
class InputServerOfClient extends Thread 
{
    public void run(){
        try{
            ServerSocket server = new ServerSocket(9000);
            do{
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String fileName= in.readUTF();
                int size = Integer.parseInt(in.readUTF());
                System.out.println("size:"+size);
                int packet = Integer.parseInt(in.readUTF());
                System.out.println("packet:"+packet);
                String sourceIp = in.readUTF();
                int i = JOptionPane.showConfirmDialog(null,"Do You Want to accept from ?"+sourceIp+"\nFile Name: "+fileName+"\n FileSize:"+size+"\n packet: "+packet);
                if(i==0){
                    byte[] data = new byte[packet];
                    FileOutputStream fileOut = new FileOutputStream("D:/"+fileName);
                    try{
                        System.out.println("size/packet: "+size/packet);
                        for(int j=1;j<=(size/packet);j++){
                            in.read(data, 0, data.length);
                            fileOut.write(data, 0, data.length);
                            System.out.println(j);
                        }
                        in.read(data, 0, (size%packet));
                        fileOut.write(data, 0, (size%packet));
                    }finally{
                        fileOut.close();
                    }
                    
                }
                in.close();
            }while(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
}
