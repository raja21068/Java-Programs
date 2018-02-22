/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;
public class Client extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public Client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ipLabel = new javax.swing.JLabel();
        ipText = new javax.swing.JTextField();
        ConnectBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList();
        connectLabel = new javax.swing.JLabel();
        ClientLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame"); // NOI18N
        getContentPane().setLayout(null);
        this.setBounds(200,200,200,200);

        ipLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ipLabel.setText("Remote IP");
        getContentPane().add(ipLabel);
        ipLabel.setBounds(27, 40, 80, 20);

        ipText.setForeground(new java.awt.Color(204, 0, 51));
        ipText.setText("127.0.0.1");
        getContentPane().add(ipText);
        ipText.setBounds(28, 60, 150, 30);

        ConnectBtn.setText("Connect");
        ConnectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectBtn.setEnabled(false);
                new C(onlineList).start();
            }
        });
        getContentPane().add(ConnectBtn);
        ConnectBtn.setBounds(30, 270, 140, 30);

        jScrollPane1.setViewportView(onlineList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(28, 120, 150, 140);

        connectLabel.setText("Connected :");
        getContentPane().add(connectLabel);
        connectLabel.setBounds(38, 100, 130, 20);

        ClientLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ClientLabel.setForeground(new java.awt.Color(204, 51, 255));
        ClientLabel.setText("C L I E N T");
        getContentPane().add(ClientLabel);
        ClientLabel.setBounds(40, 10, 80, 17);

        pack();
    }// </editor-fold>                        
                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Client().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel ClientLabel;
    private javax.swing.JButton ConnectBtn;
    private javax.swing.JLabel connectLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList onlineList;
    // End of variables declaration                  

}

class C extends Thread{
   JList list;
    C(JList list){
        this.list = list;
    }
    public void run(){
        try{
        Socket socket = new Socket("127.0.0.1",9000);
        System.out.println("connected....");
        do{
            Vector v = new Vector();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String s = in.readUTF();
            System.out.println(s);
            int size = Integer.parseInt(s);
            for(int i =0 ;i<size;i++){
                v.addElement(in.readUTF());
            }
            list.setListData(v);
        }while(true);
        }catch(Exception e){ e.printStackTrace();}
    }
}