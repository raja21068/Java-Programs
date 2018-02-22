/*
 * MainFrame.java
 *
 * Created on Oct 29, 2012, 3:07:49 AM
 */
import javax.mail.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailAddressTextField = new javax.swing.JTextField();
        sendToLabel = new javax.swing.JLabel();
        sendEmailTextField = new javax.swing.JTextField();
        messageScrollPane = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        subjectLabel = new javax.swing.JLabel();
        subjectTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 420));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Sylfaen", 1, 14));
        mainLabel.setForeground(new java.awt.Color(51, 204, 255));
        mainLabel.setText("SIMPLE  MAIL  TRANSFER  PROTOCOL");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(106, 13, 307, 33);

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        emailLabel.setText("Your e-mail:");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(10, 60, 80, 16);

        emailAddressTextField.setFont(new java.awt.Font("Tahoma", 3, 14));
        getContentPane().add(emailAddressTextField);
        emailAddressTextField.setBounds(90, 50, 220, 30);

        sendToLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        sendToLabel.setText("To:");
        getContentPane().add(sendToLabel);
        sendToLabel.setBounds(10, 90, 30, 30);

        sendEmailTextField.setFont(new java.awt.Font("Tahoma", 3, 14));
        getContentPane().add(sendEmailTextField);
        sendEmailTextField.setBounds(90, 90, 400, 30);

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        messageScrollPane.setViewportView(messageTextArea);

        getContentPane().add(messageScrollPane);
        messageScrollPane.setBounds(20, 180, 460, 140);

        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Message"));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 160, 480, 170);

        sendButton.setText("SEND   MAIL");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(10, 330, 470, 25);

        subjectLabel.setText("Subject:");
        getContentPane().add(subjectLabel);
        subjectLabel.setBounds(10, 130, 50, 16);
        getContentPane().add(subjectTextField);
        subjectTextField.setBounds(90, 130, 400, 22);

        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(320, 50, 60, 20);
        getContentPane().add(passwordField);
        passwordField.setBounds(380, 50, 120, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        
        Properties property = new Properties();
        property.put("mail.smtp.host", "smtp.gmail.com");
        property.put("mail.smtp.socketFactory.port", "465");
        property.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        property.put("mail.smtp.auth", "true");
        property.put("mail.smtp.port", "465");
        System.out.println("Starting session...");
        Session session = Session.getDefaultInstance(property , 
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication( emailAddressTextField.getText() , passwordField.getText());
                    }
                }
                );
        try{
           
            Message msg  = new MimeMessage(session);
            msg.setFrom(new javax.mail.internet.InternetAddress(emailAddressTextField.getText()));
            msg.setRecipients(Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(sendEmailTextField.getText()));
            msg.setSubject(subjectTextField.getText());
            msg.setText(messageTextArea.getText());
            System.out.println("Transport message...");
//            for(int i=1;i<=50;i++){
                Transport.send(msg);
//            }
            JOptionPane.showMessageDialog(null, "Message sent");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailAddressTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JScrollPane messageScrollPane;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField sendEmailTextField;
    private javax.swing.JLabel sendToLabel;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTextField subjectTextField;
    // End of variables declaration//GEN-END:variables
}
