
import java.util.Enumeration;
import java.util.Hashtable;
import javax.comm.CommPortIdentifier;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SmsSender extends javax.swing.JFrame {

    public static Hashtable<String,BiodataBean> infoTable = new Hashtable<String,BiodataBean>();
    public static Connect connection;
    public SmsSender() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        portsComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        detectButton = new javax.swing.JButton();
        phoneNoComboBox = new javax.swing.JComboBox();
        phoneNumberTextField = new javax.swing.JFormattedTextField();
        connectButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        contactButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SMS SENDER");
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        getContentPane().add(portsComboBox);
        portsComboBox.setBounds(50, 70, 130, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ports");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 70, 40, 14);

        detectButton.setText("Detect Ports");
        detectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(detectButton);
        detectButton.setBounds(190, 70, 120, 35);

        phoneNoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+923332836704" }));
        phoneNoComboBox.setEnabled(false);
        getContentPane().add(phoneNoComboBox);
        phoneNoComboBox.setBounds(10, 170, 170, 30);

        try {
            phoneNumberTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+9###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phoneNumberTextField.setEnabled(false);
        phoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNumberTextField);
        phoneNumberTextField.setBounds(10, 120, 170, 30);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(connectButton);
        connectButton.setBounds(190, 120, 120, 35);

        removeAllButton.setText("<html>Remove All<br>From list");
        removeAllButton.setEnabled(false);
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeAllButton);
        removeAllButton.setBounds(190, 170, 120, 35);

        jScrollPane1.setEnabled(false);

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 280, 110);

        jLabel2.setText("Message:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 220, 60, 14);

        sendButton.setText("SEND");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(300, 290, 80, 60);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(10, 360, 370, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("MESSAGE SENDING");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 10, 120, 40);

        contactButton.setText("<html>Contact<br>List");
        contactButton.setEnabled(false);
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });
        getContentPane().add(contactButton);
        contactButton.setBounds(300, 230, 80, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectButtonActionPerformed
        Enumeration e = CommPortIdentifier.getPortIdentifiers();
        this.portsComboBox.removeAllItems();
        while (e.hasMoreElements()) {
            CommPortIdentifier portId = (CommPortIdentifier) e.nextElement();
            String name = portId.getName();
//            String owner = portId.toString();
//            System.out.println(owner);
//            System.out.println(((CommPortIdentifier) e.nextElement()).getName());
            this.portsComboBox.addItem(name);
        }
    }//GEN-LAST:event_detectButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        String portNo = this.portsComboBox.getSelectedItem().toString();
        if(portNo==null)return;
        try{
            connection = new Connect(portNo);
            JOptionPane.showMessageDialog(null, "connection estblisted");
            
            this.phoneNumberTextField.setEnabled(true);
            this.phoneNoComboBox.setEnabled(true);
            this.removeAllButton.setEnabled(true);
            this.messageTextArea.setEnabled(true);
            this.sendButton.setEnabled(true);
            this.connectButton.setEnabled(true);
        }catch (javax.comm.PortInUseException e){
           System.out.println("Port In Use " + e);
        }catch (java.io.IOException e){
           System.out.println("Error writing to output stream " + e);
        }catch (javax.comm.UnsupportedCommOperationException e){
           e.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_connectButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        this.phoneNoComboBox.removeAllItems();
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        for(int i=0;i<phoneNoComboBox.getItemCount();i++){
            String mobileNo = this.phoneNoComboBox.getItemAt(i).toString();
            String msg = this.messageTextArea.getText();
            connection.send(mobileNo, msg);
        }
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void phoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextFieldActionPerformed
        this.phoneNoComboBox.addItem(this.phoneNumberTextField.getText().trim());
    }//GEN-LAST:event_phoneNumberTextFieldActionPerformed

    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed
        new Thread(){
            public void run(){
                for(int i=1;i<=1000;i++){
                    System.out.println(i);
                    connection.contactEntries(i);
                }
            }
        }.start();
        
    }//GEN-LAST:event_contactButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JButton contactButton;
    private javax.swing.JButton detectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JComboBox phoneNoComboBox;
    private javax.swing.JFormattedTextField phoneNumberTextField;
    private javax.swing.JComboBox portsComboBox;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
