
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUISender extends javax.swing.JFrame {

    DatagramSocket socket;
    Scanner scan = new Scanner(System.in);
    InetAddress address;
    String s ="";
    byte[] data;
    /** Creates new form GUISender */
    public GUISender() {
        initComponents();
        setVisible(true);
        try{
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        
        ///*********************Recieving Thread*************
        new Thread(){
            public void run(){
                do{
                    recieve();
                }while(true);
            }
        }.start();
        
        }catch(Exception ex){ex.printStackTrace();}
///***********************************************************
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        messageScrollPane = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        recieveMessageScrollPane = new javax.swing.JScrollPane();
        recieveMessageTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sender");
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        messageScrollPane.setViewportView(messageTextArea);

        getContentPane().add(messageScrollPane);
        messageScrollPane.setBounds(10, 100, 238, 50);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(12, 154, 238, 30);

        recieveMessageTextArea.setEditable(false);
        recieveMessageScrollPane.setAlignmentY(BOTTOM_ALIGNMENT);
        recieveMessageScrollPane.setViewportView(recieveMessageTextArea);
        
        getContentPane().add(recieveMessageScrollPane);
        recieveMessageScrollPane.setBounds(10, 10, 238, 80);

        pack();
    }// </editor-fold>

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
            String s = messageTextArea.getText();
            data = s.getBytes();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9090);
            try {
                socket.send(packet);
                recieveMessageTextArea.setText(recieveMessageTextArea.getText()+"\nSender: "+s.trim());
                messageTextArea.setText("");
            } catch (IOException ex) {
                Logger.getLogger(GUISender.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }                                          
     public void recieve(){
         byte[] dataR = new byte[100];
         DatagramPacket packet2 = new DatagramPacket(dataR,0,dataR.length,address,9090);
         try {
               socket.receive(packet2);
          } catch (IOException ex) {
                    Logger.getLogger(GUISender.class.getName()).log(Level.SEVERE, null, ex);
            }
          s = new String(dataR , 0,dataR.length);
          recieveMessageTextArea.setText(recieveMessageTextArea.getText()+"\nReciever: "+s.trim());
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
                new GUISender().setVisible(true);
    }
    // Variables declaration - do not modify
    private javax.swing.JScrollPane messageScrollPane;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JScrollPane recieveMessageScrollPane;
    private javax.swing.JTextArea recieveMessageTextArea;
    private javax.swing.JButton sendButton;
    // End of variables declaration
}
