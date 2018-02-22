package forms;


import bean.BiodataBean;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.comm.CommPortIdentifier;
import javax.swing.JOptionPane;
import message.Connect;

/**
 *
 * @author DELL
 */
public class SmsSender extends javax.swing.JFrame {

    public static Hashtable<String , BiodataBean> infoTable = new Hashtable();
    public static Connect connection;
    
    public SmsSender() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        portsComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        buttonDetect = new javax.swing.JButton();
        comboBoxPhoneNo = new javax.swing.JComboBox();
        buttonConnect = new javax.swing.JButton();
        buttonRemoveAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        buttonSend = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        textFieldPhoneNumber = new javax.swing.JTextField();
        labelProgress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SMS SENDER");
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        portsComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(portsComboBox);
        portsComboBox.setBounds(50, 70, 170, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ports");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 70, 40, 14);

        buttonDetect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonDetect.setText("Detect Ports");
        buttonDetect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetectActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDetect);
        buttonDetect.setBounds(240, 70, 160, 35);

        comboBoxPhoneNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxPhoneNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "+923332836704" }));
        comboBoxPhoneNo.setEnabled(false);
        getContentPane().add(comboBoxPhoneNo);
        comboBoxPhoneNo.setBounds(10, 170, 210, 30);

        buttonConnect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonConnect.setText("Connect");
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });
        getContentPane().add(buttonConnect);
        buttonConnect.setBounds(240, 120, 160, 35);

        buttonRemoveAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonRemoveAll.setText("<html>Remove All<br>From list");
        buttonRemoveAll.setEnabled(false);
        buttonRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveAllActionPerformed(evt);
            }
        });
        getContentPane().add(buttonRemoveAll);
        buttonRemoveAll.setBounds(240, 170, 160, 35);

        jScrollPane1.setEnabled(false);

        messageTextArea.setColumns(20);
        messageTextArea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 320, 110);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Message:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 220, 100, 17);

        buttonSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSend.setText("SEND");
        buttonSend.setEnabled(false);
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSend);
        buttonSend.setBounds(340, 240, 90, 110);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(10, 360, 370, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("MESSAGE SENDING");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 10, 120, 40);

        textFieldPhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textFieldPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPhoneNumberActionPerformed(evt);
            }
        });
        getContentPane().add(textFieldPhoneNumber);
        textFieldPhoneNumber.setBounds(10, 120, 210, 30);
        getContentPane().add(labelProgress);
        labelProgress.setBounds(20, 394, 200, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetectActionPerformed
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
    }//GEN-LAST:event_buttonDetectActionPerformed

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectActionPerformed
        String portNo = this.portsComboBox.getSelectedItem().toString();
        if(portNo==null)return;
        try{
            connection = new Connect(portNo);
            JOptionPane.showMessageDialog(null, "connection estblisted");
            
            this.textFieldPhoneNumber.setEnabled(true);
            this.comboBoxPhoneNo.setEnabled(true);
            this.buttonRemoveAll.setEnabled(true);
            this.messageTextArea.setEnabled(true);
            this.buttonSend.setEnabled(true);
            this.buttonConnect.setEnabled(true);
    
            labelProgress.setText("Connection Established...");
            
        }catch (javax.comm.PortInUseException e){
           System.out.println("Port In Use " + e);
           labelProgress.setText("Port In Use...");
        }catch (java.io.IOException e){
           System.out.println("Error writing to output stream " + e);
        }catch (javax.comm.UnsupportedCommOperationException e){
           e.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_buttonConnectActionPerformed

    private void buttonRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveAllActionPerformed
        this.comboBoxPhoneNo.removeAllItems();
    }//GEN-LAST:event_buttonRemoveAllActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        for(int i=0;i<comboBoxPhoneNo.getItemCount();i++){
            String mobileNo = this.comboBoxPhoneNo.getItemAt(i).toString();
            String msg = this.messageTextArea.getText();
            connection.send(mobileNo, msg);
        }
        
    }//GEN-LAST:event_buttonSendActionPerformed

    private void textFieldPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPhoneNumberActionPerformed
        comboBoxPhoneNo.addItem(textFieldPhoneNumber.getText());
    }//GEN-LAST:event_textFieldPhoneNumberActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonDetect;
    private javax.swing.JButton buttonRemoveAll;
    private javax.swing.JButton buttonSend;
    private javax.swing.JComboBox comboBoxPhoneNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JComboBox portsComboBox;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField textFieldPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
