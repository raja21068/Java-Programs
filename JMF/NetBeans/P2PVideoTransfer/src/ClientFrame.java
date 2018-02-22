
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Jay Kumar
 */
public class ClientFrame extends javax.swing.JFrame {

    ArrayList arrayListCapture;
    
    public ClientFrame() {
        initComponents();
        arrayListCapture = new ArrayList();
        listCapture .setListData(arrayListCapture.toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOnlineClients = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCapture = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        buttonCapture = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Video Conference");

        jScrollPane1.setViewportView(listOnlineClients);

        jLabel2.setText("Online User");

        jScrollPane2.setViewportView(listCapture);

        jLabel3.setText("Capturing");

        buttonCapture.setText("Capture");
        buttonCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCaptureActionPerformed(evt);
            }
        });

        jButton2.setText("Stop Capture");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonCapture, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCapture)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCaptureActionPerformed
       Object ob = listOnlineClients.getSelectedValue();
       if(ob == null){
           JOptionPane.showMessageDialog(this,"Please select any client");
           return;
       }
       
       String ip = (String)ob;
       startRecieving(ip);
       arrayListCapture.add(ob);
       listCapture.setListData(arrayListCapture.toArray());
    }//GEN-LAST:event_buttonCaptureActionPerformed

    public void startRecieving(String ip){
        try{
            Socket s = new Socket(ip, PortConfig.REQUEST_LISTENER_PORT);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(""+PortConfig.MEDIA_PORT);
            new JReciever(ip,PortConfig.MEDIA_PORT).start();
            System.out.println("*//....Recieving Strated...*");
        }catch(Exception ex){
          ex.printStackTrace();
        }
    }
    
    public javax.swing.JList getListOnlineClients(){
        return listOnlineClients;
    }

    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        if(b){
            // start service for listen request an dsend video
            new RequestListener().start();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCapture;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listCapture;
    private javax.swing.JList listOnlineClients;
    // End of variables declaration//GEN-END:variables
}
