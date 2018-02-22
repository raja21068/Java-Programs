/**
 *
 * @author Jay Kumar
 */
import java.awt.Dimension;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class ClientFrame extends javax.swing.JFrame {

    /** Creates new form ClientFrame */
    public ClientFrame() {
        initComponents();
        try{
            new C(clientList ,ipTextField.getText()).start();
        
        }catch(Exception e){e.printStackTrace();}
    }
    private void initComponents() {

        listScrollPane = new javax.swing.JScrollPane();
        clientList = new javax.swing.JList();
        mainLabel = new javax.swing.JLabel();
        recordButton = new javax.swing.JButton();
        transmitButton = new javax.swing.JButton();
        ipLabel = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();
        recieverIpLabel = new javax.swing.JLabel();
        recieverTextField = new javax.swing.JTextField();
        listLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setMinimumSize(new Dimension(360,300));

        listScrollPane.setViewportView(clientList);

        getContentPane().add(listScrollPane);
        listScrollPane.setBounds(210, 60, 170, 150);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("C L I E N T");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(120, 10, 100, 30);

        recordButton.setText("Record");
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recordButton);
        recordButton.setBounds(10, 90, 180, 25);

        transmitButton.setText("Transmit");
        transmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transmitButton);
        transmitButton.setBounds(10, 140, 180, 25);

        ipLabel.setText("IP Address");
        getContentPane().add(ipLabel);
        ipLabel.setBounds(10, 60, 70, 16);

        ipTextField.setEditable(false);
        ipTextField.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        ipTextField.setForeground(new java.awt.Color(0, 255, 204));
        ipTextField.setText("127.0.0.1");
        getContentPane().add(ipTextField);
        ipTextField.setBounds(80, 60, 110, 22);

        recieverIpLabel.setText("Reciever IP:");
        getContentPane().add(recieverIpLabel);
        recieverIpLabel.setBounds(10, 190, 70, 16);
        recieverTextField.setText("127");
        getContentPane().add(recieverTextField);
        recieverTextField.setBounds(10, 210, 180, 22);

        listLabel.setText("Client List");
        getContentPane().add(listLabel);
        listLabel.setBounds(250, 40, 60, 16);

        clientList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource()==null)return;
                String s = (String)clientList.getSelectedValue();
                recieverTextField.setText(s);
            }
        });
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        capture = new VoiceCapture();
        capture.start();
    }

    private void transmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmitButtonActionPerformed
        capture.stopCapture();
        try{
        Socket socket = new Socket(recieverTextField.getText(),9000);
        System.out.println("Connected... with "+recieverTextField.getText());
        File f = new File("Jay.au");
        DataInputStream input = new DataInputStream(new FileInputStream(f));
        new TransferThread(f,input.available(),10000,input.available()/10000 , socket, input).start();
        }catch(Exception e){e.printStackTrace(); }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList clientList;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JLabel listLabel;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel recieverIpLabel;
    private javax.swing.JTextField recieverTextField;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton transmitButton;
    VoiceCapture capture;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String args[]) {
                new ClientFrame().setVisible(true);
                try{
    		ServerSocket server= new ServerSocket(9000); 	
    		do{
				Socket socket = server.accept();
				System.out.println("Connected with : "+socket.getInetAddress());
                                new InputThreadOfServer(socket).start();
    		}while(true);
    	}catch(Exception e){}
         
    }
}

////****List updating Client Thread******\\\\\
class C extends Thread{
   JList list;
   String ip;
    C(JList list , String ip){
        this.list = list;
        this.ip = ip;
    }
    public void run(){
        try{
        Socket socket = new Socket(ip,8000);
        System.out.println("connected....");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        int size;
        do{
            Vector v = new Vector();
            Thread.sleep(1000);
            String s = in.readUTF();
            size = Integer.parseInt(s);
            for(int i =0 ;i<size;i++){
                v.addElement(in.readUTF());
            }
            list.removeAll();
            list.setListData(v);
        }while(true);
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Server is Closed....");
        }
        System.exit(0);
    }
}