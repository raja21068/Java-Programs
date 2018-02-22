
import java.awt.Cursor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUIReciever extends javax.swing.JFrame {

    Scanner scan = new Scanner(System.in);
    DatagramSocket socket;
    byte data[] = new byte[500];
    String s="";
    DatagramPacket packet;
    DatagramPacket packet2;
    static int packetport;
    static InetAddress address;
    /** Creates new form GUIReciever */
    public GUIReciever() {
        try {
            initComponents();
            setVisible(true);
            socket = new DatagramSocket(9090);
            
            new Thread(){
                public void run(){
                    try{
                        do{
                            recieve();
                        }while(true);
                    }catch(Exception ex){ex.printStackTrace();}
                }
            }.start();    
                
        } catch (Exception ex) {
            Logger.getLogger(GUIReciever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageScrollPane = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        recieveMessageScrollPane = new javax.swing.JScrollPane();
        recieveMessageTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reciever");
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(null);

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
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
        sendButton.setBounds(10, 160, 240, 30);

        recieveMessageScrollPane.setAlignmentY(BOTTOM_ALIGNMENT);

        recieveMessageTextArea.setColumns(20);
        recieveMessageTextArea.setEditable(false);
        recieveMessageTextArea.setRows(5);
        recieveMessageScrollPane.setViewportView(recieveMessageTextArea);

        getContentPane().add(recieveMessageScrollPane);
        recieveMessageScrollPane.setBounds(10, 10, 238, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {  
                String s=messageTextArea.getText();
                data = s.getBytes();
                packet2 = new DatagramPacket(data,0,data.length ,address,packetport);
                socket.send(packet2);
                recieveMessageTextArea.setText(recieveMessageTextArea.getText()+"\nReciever: "+s);
                messageTextArea.setText("");
        } catch (IOException ex) {
            Logger.getLogger(GUIReciever.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_sendButtonActionPerformed
    public void recieve()throws Exception{
        packet = new DatagramPacket(data,0,data.length);
         socket.receive(packet);
         packetport = packet.getPort();
         address = packet.getAddress();
         s = new String(data,0,data.length);
         recieveMessageTextArea.setText(recieveMessageTextArea.getText()+"\nSender: "+s.trim());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
             
                new GUIReciever().setVisible(true);
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane messageScrollPane;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JScrollPane recieveMessageScrollPane;
    private javax.swing.JTextArea recieveMessageTextArea;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
