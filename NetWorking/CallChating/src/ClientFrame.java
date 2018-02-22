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


////****List updating Client Thread******\\\\\
public class ClientFrame extends javax.swing.JFrame {

    Socket socket;
    TransferVoice transferVoice;
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
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
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
        mainLabel.setText("C a l l i n g  S o f t w a r e");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(60, 10, 240, 30);

        startButton.setText("Start / Connect");
        startButton.setEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(10, 90, 180, 25);

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(10, 140, 180, 25);       

        ipLabel.setText("IP Address");
        getContentPane().add(ipLabel);
        ipLabel.setBounds(10, 60, 70, 16);

        ipTextField.setEditable(false);
        ipTextField.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        ipTextField.setForeground(new java.awt.Color(0, 255, 204));
        ipTextField.setText("127.0.0.1");
        getContentPane().add(ipTextField);
        ipTextField.setBounds(80, 60, 110, 22);

        recieverIpLabel.setText("Enter Reciever IP:");
        getContentPane().add(recieverIpLabel);
        recieverIpLabel.setBounds(10, 190, 140, 16);
        recieverTextField.setText("127");
        getContentPane().add(recieverTextField);
        recieverTextField.setBounds(10, 210, 180, 22);

        listLabel.setText("Client List");
        getContentPane().add(listLabel);
        listLabel.setBounds(250, 40, 60, 16);

        clientList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource()==null)return;
                startButton.setEnabled(true);
                String s = (String)clientList.getSelectedValue();
                recieverTextField.setText(s);
            }
        });
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
        stopButton.setEnabled(true);
        if(startButton.getText().contains("Start / Connect")){
            startButton.setText("pause");
            try{
                System.out.println("start button entered");
                socket = new Socket(recieverTextField.getText(),9000);
                transferVoice=new TransferVoice(socket , this);
                transferVoice.start();
            }catch(Exception e){e.printStackTrace();}
        }
        else if(startButton.getText().contains("pause")){
            startButton.setText("start");
            transferVoice.suspend();
        }
        else if(startButton.getText().contains("start")){
            startButton.setText("pause");
                transferVoice.resume();
        }
        
    }

    public void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {
        startButton.setText("Start / Connect");
        System.out.println("Entered stop button");
        transferVoice.stop();
        try{
            socket.close();
        }catch(Exception e){e.printStackTrace(); }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JList clientList;
    javax.swing.JLabel ipLabel;
    javax.swing.JTextField ipTextField;
    javax.swing.JLabel listLabel;
    javax.swing.JScrollPane listScrollPane;
    javax.swing.JLabel mainLabel;
    javax.swing.JLabel recieverIpLabel;
    javax.swing.JTextField recieverTextField;
    javax.swing.JButton startButton;
    javax.swing.JButton stopButton;
    VoiceCapture capture;
    // End of variables declaration//GEN-END:variables
    
}





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