import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Jay Kumar
 */
public class Host extends javax.swing.JFrame {

    /** Creates new form Host */
    Joining join;

    public Host() {
        initComponents();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        channelNameLabel = new javax.swing.JLabel();
        channelComboBox = new javax.swing.JComboBox();
        programScrollPane = new javax.swing.JScrollPane();
        programList = new javax.swing.JList();
        timeLabel = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        topicLabel = new javax.swing.JLabel();
        topicTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        groupAddressLabel = new javax.swing.JLabel();
        groupAddressTextField = new javax.swing.JTextField();
        joinButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Host");
        setMinimumSize(new java.awt.Dimension(450, 430));
        getContentPane().setLayout(null);

        channelNameLabel.setText("Channel Names:");
        getContentPane().add(channelNameLabel);
        channelNameLabel.setBounds(20, 30, 100, 16);

        channelComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                channelComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(channelComboBox);
        channelComboBox.setBounds(20, 60, 180, 22);

        programList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                programListValueChanged(evt);
            }
        });
        programScrollPane.setViewportView(programList);

        getContentPane().add(programScrollPane);
        programScrollPane.setBounds(20, 100, 180, 250);

        timeLabel.setText("Time");
        getContentPane().add(timeLabel);
        timeLabel.setBounds(220, 150, 80, 16);
        getContentPane().add(timeTextField);
        timeTextField.setBounds(220, 170, 180, 22);

        topicLabel.setText("Topic");
        getContentPane().add(topicLabel);
        topicLabel.setBounds(220, 90, 80, 16);
        getContentPane().add(topicTextField);
        topicTextField.setBounds(220, 110, 180, 22);

        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(220, 200, 26, 16);
        getContentPane().add(dateTextField);
        dateTextField.setBounds(220, 220, 180, 22);

        groupAddressLabel.setText("Group Address");
        getContentPane().add(groupAddressLabel);
        groupAddressLabel.setBounds(220, 270, 100, 16);
        getContentPane().add(groupAddressTextField);
        groupAddressTextField.setBounds(220, 290, 180, 22);

        joinButton.setText("Join");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });
        getContentPane().add(joinButton);
        joinButton.setBounds(220, 330, 80, 25);

        disconnectButton.setText("Disconect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(disconnectButton);
        disconnectButton.setBounds(300, 330, 100, 25);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        mainLabel.setForeground(new java.awt.Color(153, 0, 102));
        mainLabel.setText("H O S T");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(180, 10, 70, 16);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        getContentPane().add(refreshButton);
        refreshButton.setBounds(220, 60, 180, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void channelComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_channelComboBoxItemStateChanged
        // TODO add your handling code here:
        ChannelBean bean= (ChannelBean)channelComboBox.getSelectedItem();
        if(bean==null)return;
        Vector v = new Vector();
        String[] programs = bean.getPrograms().split(",");
        for(int i=0;i<programs.length;i++){
            v.add(programs[i]);
        }
        programList.setListData(v);
        this.groupAddressTextField.setText(bean.getChannelIp());
    }//GEN-LAST:event_channelComboBoxItemStateChanged

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        // TODO add your handling code here:
        if(groupAddressTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Group address does not exist..");
            return;
        }
        join = new Joining(groupAddressTextField.getText());
        join.start();
        JOptionPane.showMessageDialog(null, "Group "+groupAddressTextField.getText()+" is joined..");
    }//GEN-LAST:event_joinButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        // TODO add your handling code here:
        join.stop();
        JOptionPane.showMessageDialog(null, groupAddressTextField.getText()+" is disconnected...");
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        if(evt==null)return;
        try{
            channelComboBox.removeAllItems();
            
            String ip = JOptionPane.showInputDialog(null,"Enter registry ip");
            Socket socket = new Socket(ip,9000);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF("host");
            String channel = in.readUTF();
            while(!(channel.contains("exit"))){
                System.out.println("HOST: "+channel);
                String[] info = channel.split("'");
                ChannelBean bean = new ChannelBean();
                bean.setChannelIp(info[0]);
                bean.setChannelName(info[1]);
                bean.setPrograms(info[2]);
                channelComboBox.addItem(bean);
                channel = in.readUTF();
            }
                        
            
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void programListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_programListValueChanged
        // TODO add your handling code here:
        String s = (String)programList.getSelectedValue();
        if(s==null)return;
        System.out.println("programsList: "+s);
        String[] spilt = s.split("_");
        this.topicTextField.setText(spilt[0]);
        this.timeTextField.setText(spilt[2]);
        this.dateTextField.setText(spilt[1]);
    }//GEN-LAST:event_programListValueChanged


    public static void main(String args[]) {
      
        new Host().setVisible(true);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox channelComboBox;
    private javax.swing.JLabel channelNameLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel groupAddressLabel;
    private javax.swing.JTextField groupAddressTextField;
    private javax.swing.JButton joinButton;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JList programList;
    private javax.swing.JScrollPane programScrollPane;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JLabel topicLabel;
    private javax.swing.JTextField topicTextField;
    // End of variables declaration//GEN-END:variables
}
class Joining extends Thread{
    String address;
    Joining(String address){
        this.address = address;
    }
    public void run(){
        try{
            MulticastSocket socket = new MulticastSocket(9090);
            byte[] data = new byte[1000];
            DatagramPacket packet = new DatagramPacket(data,0,data.length);
            socket.joinGroup(InetAddress.getByName(address));
            PacketPlay play = new PacketPlay();
            play.lineOpen();
            do{
                socket.receive(packet);
                play.playPacket(packet.getData());
                System.out.println("packet recieved");
//                Thread.sleep(5000);
            }while(true);
        }catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
    }
}