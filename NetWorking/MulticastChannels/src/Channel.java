/**
 *
 * @author Jay Kumar
 */
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Channel extends javax.swing.JFrame {
    
    Vector<String> vector = new Vector();
    JFileChooser choose;
    /** Creates new form Channel */
    public Channel() {
        initComponents();
        choose = new JFileChooser();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        groupAddressLabel = new javax.swing.JLabel();
        groupAddressTextField = new javax.swing.JTextField();
        registryIpLabel = new javax.swing.JLabel();
        registryIpTextField = new javax.swing.JTextField();
        channelNameLabel = new javax.swing.JLabel();
        channelNameTextField = new javax.swing.JTextField();
        topicLabel = new javax.swing.JLabel();
        topicTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        connectButton = new javax.swing.JButton();
        programScrollPane = new javax.swing.JScrollPane();
        programList = new javax.swing.JList();
        browseButton = new javax.swing.JButton();
        audioFileTextField = new javax.swing.JTextField();
        multicastButton = new javax.swing.JButton();
        programsLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 430));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setText("C H A N N E L");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(198, 13, 90, 16);

        groupAddressLabel.setText("Group Address");
        getContentPane().add(groupAddressLabel);
        groupAddressLabel.setBounds(20, 50, 90, 16);
        getContentPane().add(groupAddressTextField);
        groupAddressTextField.setBounds(20, 70, 140, 22);

        registryIpLabel.setText("Registry IP");
        getContentPane().add(registryIpLabel);
        registryIpLabel.setBounds(20, 100, 70, 16);
        getContentPane().add(registryIpTextField);
        registryIpTextField.setBounds(20, 120, 140, 22);

        channelNameLabel.setText("Channel Name");
        getContentPane().add(channelNameLabel);
        channelNameLabel.setBounds(20, 150, 90, 20);
        getContentPane().add(channelNameTextField);
        channelNameTextField.setBounds(20, 170, 140, 22);

        topicLabel.setText("Topic");
        getContentPane().add(topicLabel);
        topicLabel.setBounds(20, 200, 31, 16);
        getContentPane().add(topicTextField);
        topicTextField.setBounds(20, 220, 140, 22);

        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(20, 260, 26, 16);
        getContentPane().add(dateTextField);
        dateTextField.setBounds(20, 280, 140, 22);

        timeLabel.setText("Time");
        getContentPane().add(timeLabel);
        timeLabel.setBounds(20, 320, 29, 16);
        getContentPane().add(timeTextField);
        timeTextField.setBounds(20, 340, 140, 22);

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeButton);
        removeButton.setBounds(170, 340, 180, 25);

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        getContentPane().add(insertButton);
        insertButton.setBounds(170, 310, 180, 25);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(connectButton);
        connectButton.setBounds(360, 310, 150, 60);

        programList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programListValueChanged(evt);
            }
        });
        programScrollPane.setViewportView(programList);

        getContentPane().add(programScrollPane);
        programScrollPane.setBounds(170, 80, 180, 220);

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(360, 160, 90, 25);

        audioFileTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("AudioFile"));
        getContentPane().add(audioFileTextField);
        audioFileTextField.setBounds(360, 190, 150, 40);

        multicastButton.setText("Multicast");
        multicastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multicastButtonActionPerformed(evt);
            }
        });
        getContentPane().add(multicastButton);
        multicastButton.setBounds(360, 240, 150, 60);

        programsLabel.setText("Programs");
        getContentPane().add(programsLabel);
        programsLabel.setBounds(180, 60, 60, 16);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antenna.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 30, 140, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        vector.add(topicTextField.getText()+" _ "+dateTextField.getText()+" _ "+timeTextField.getText());
        programList.setListData(vector);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        String s = (String) programList.getSelectedValue();
        if(s==null){JOptionPane.showMessageDialog(this,"No value is selected..");return;}
        vector.remove(s);
        programList.setListData(vector);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        if(channelNameTextField.getText().isEmpty()||groupAddressTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Some fields are missing");
            return;
        }
        if(vector.size()<1){
            JOptionPane.showMessageDialog(null, "No any programs list..");
            return;
        }
        new Thread(){
            public void run(){
                try{
                    Socket socket = new Socket(registryIpTextField.getText(),9000);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("channel");
                    String value =groupAddressTextField.getText()+"'"+channelNameTextField.getText()+"'";
                    value+= vector.elementAt(0);
                    for(int i=1;i<vector.size();i++){
                        value+= (","+vector.elementAt(i));
                    }
                    out.writeUTF(value);
                }catch(Exception ex){JOptionPane.showMessageDialog(null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_connectButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        choose.showOpenDialog(this);
        audioFileTextField.setText(choose.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_browseButtonActionPerformed

    private void multicastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multicastButtonActionPerformed
        // TODO add your handling code here:
        new Thread(){
            public void run(){
                try{
                    FileInputStream in = new FileInputStream(new File(audioFileTextField.getText()));
                    DatagramSocket socket = new DatagramSocket();
                    byte[] data = new byte[1000];
                    int total = in.available()/data.length;
                    int last = in.available()%data.length;
                    InetAddress address = InetAddress.getByName(groupAddressTextField.getText());
                    for(int i=1;i<=total;i++){
                        in.read(data, 0, data.length);
                        DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9090);
                        socket.send(packet);
                        System.out.println("packet sended...");
                        Thread.sleep(5,500);
                    }
                    in.read(data, 0, last);
                    DatagramPacket packet = new DatagramPacket(data,0,last,address,9090);
                    socket.send(packet);
                    
                    
                }catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
            }
        }.start();
    }//GEN-LAST:event_multicastButtonActionPerformed

    private void programListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programListValueChanged
        // TODO add your handling code here:
        String s = (String)programList.getSelectedValue();
        if(s==null)return;
        System.out.print("channel list: "+s);
        String[] spilt = s.split("_");
        this.topicTextField.setText(spilt[0]);
        this.timeTextField.setText(spilt[2]);
        this.dateTextField.setText(spilt[1]);
    }//GEN-LAST:event_programListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

                new Channel().setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField audioFileTextField;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel channelNameLabel;
    private javax.swing.JTextField channelNameTextField;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel groupAddressLabel;
    private javax.swing.JTextField groupAddressTextField;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton multicastButton;
    private javax.swing.JList programList;
    private javax.swing.JScrollPane programScrollPane;
    private javax.swing.JLabel programsLabel;
    private javax.swing.JLabel registryIpLabel;
    private javax.swing.JTextField registryIpTextField;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JLabel topicLabel;
    private javax.swing.JTextField topicTextField;
    // End of variables declaration//GEN-END:variables
}