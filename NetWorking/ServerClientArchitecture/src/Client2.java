
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

/*
 * Client2.java
 *
 * Created on Nov 16, 2012, 12:03:38 PM
 */
/**
 *
 * @author Jay Kumar
 */
public class Client2 extends javax.swing.JFrame {

    JFileChooser fileDialog;
    Socket socket;
    public Client2() {
        initComponents();
        fileDialog = new JFileChooser();
        try{
            String ip=null;
            do{
                ip= (String)JOptionPane.showInputDialog(this, "Enter Server IP Address", "Entry", 0, new ImageIcon("login.png"), null,null);                
            }while(ip==null||ip.length()<3);
            System.out.println(ip.toCharArray());
            socket = new Socket(ip,9090);
            new Input(socket,this.clientList).start();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
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
        listScrollPane = new javax.swing.JScrollPane();
        clientList = new javax.swing.JList();
        clientLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(450, 400));
        getContentPane().setLayout(null);

        mainLabel.setBackground(new java.awt.Color(255, 255, 102));
        mainLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 0));
        mainLabel.setText("FILE TRANSFER");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(150, 10, 120, 30);

        ipLabel.setText("ENTER DESTINAION IP");
        getContentPane().add(ipLabel);
        ipLabel.setBounds(20, 60, 140, 16);
        getContentPane().add(ipTextField);
        ipTextField.setBounds(20, 82, 200, 30);

        fileLabel.setText("ENTER FILE");
        getContentPane().add(fileLabel);
        fileLabel.setBounds(20, 160, 90, 20);
        getContentPane().add(fileTextField);
        fileTextField.setBounds(20, 180, 200, 30);

        browseButton.setBackground(new java.awt.Color(255, 153, 153));
        browseButton.setText("BROWSE ");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(100, 220, 120, 30);

        transferButton.setBackground(new java.awt.Color(204, 255, 204));
        transferButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        transferButton.setForeground(new java.awt.Color(255, 102, 51));
        transferButton.setText("TRANSFER");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transferButton);
        transferButton.setBounds(20, 260, 200, 70);

        listScrollPane.setViewportView(clientList);

        getContentPane().add(listScrollPane);
        listScrollPane.setBounds(240, 80, 160, 240);

        clientLabel.setText("CLIENTS");
        getContentPane().add(clientLabel);
        clientLabel.setBounds(290, 60, 60, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        int i=fileDialog.showOpenDialog(this);
        if(i<1){
            fileTextField.setText(fileDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        // TODO add your handling code here:
        try{
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            outToServer.writeUTF("file");
            FileInputStream fileIn = new FileInputStream(fileTextField.getText());
            outToServer.writeUTF(ipTextField.getText());
            outToServer.writeUTF(new File(fileTextField.getText()).getName());
            int size = fileIn.available();
            outToServer.writeUTF(""+size);
            int packet = 10000;
            outToServer.writeUTF(""+packet);
            byte[] data = new byte[packet];
            for(int i=1;i<=(size/packet);i++){
                fileIn.read(data, 0, data.length);
                outToServer.write(data, 0, data.length);
            }
            fileIn.read(data, 0, (size%packet));
            outToServer.write(data, 0, (size%packet));
            fileIn.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
        
    }//GEN-LAST:event_transferButtonActionPerformed


    public static void main(String args[]) {

        new Client2().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JList clientList;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables
}
class Input extends Thread{
    DataInputStream in;
    Socket socket;
    JList list;
    Input(Socket s,JList list){
        socket = s;
        this.list = list;
    }
    public void run(){
        try{
            in = new DataInputStream(socket.getInputStream());
            do{
                String check = in.readUTF();
                if(check.contains("list")){
                    int size = Integer.parseInt(in.readUTF());
                    ArrayList<String> ips = new ArrayList();
                    for(int i=0;i<size;i++){
                        ips.add(in.readUTF());
                    }
                    list.setListData(ips.toArray());
                }
                if(check.contains("download")){
                    String fileName = in.readUTF();
                    int size = Integer.parseInt(in.readUTF());
                    int packet = Integer.parseInt(in.readUTF());
                    String drive = JOptionPane.showInputDialog(null,""+fileName+"\n"+size+"\nin which drive you want to save:");
                    byte[] data = new byte[packet];
                    FileOutputStream fileOut = new FileOutputStream(drive+":/"+fileName);
                    for(int i=1;i<=(size/packet);i++){
                        in.readFully(data, 0, data.length);
                        fileOut.write(data, 0, data.length);
                    }
                    in.readFully(data, 0, (size%packet));
                    fileOut.write(data, 0, (size%packet));
                    fileOut.close();    
                }
            }while(true);
            }catch(Exception ex){ex.printStackTrace();}
        
    }
}