package Test;


import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;


public class Recieving extends javax.swing.JFrame {

    public Recieving() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picScrollPane = new javax.swing.JScrollPane();
        pictureLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 430));
        getContentPane().setLayout(null);

        picScrollPane.setViewportView(pictureLabel);

        getContentPane().add(picScrollPane);
        picScrollPane.setBounds(10, 17, 470, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws Exception {
         Recieving frame = new Recieving();
         frame.setVisible(true);
         
        ServerSocket server =new ServerSocket(9090);
        Socket socket = server.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());

        int size = Integer.parseInt(in.readUTF());
        int packetSize = Integer.parseInt(in.readUTF());
        byte[] data = new byte[packetSize];
        
        FileOutputStream out = new FileOutputStream("E:/screen.jpg");
        for(int i=1;i<=size/packetSize; i++){
            in.read(data, 0, data.length);
            out.write(data, 0, data.length);
        }
         in.read(data, 0, size%packetSize);
         out.write(data, 0, size%packetSize);
         out.close();
         frame.pictureLabel.removeAll();
         frame.pictureLabel.setIcon(new ImageIcon("E:/screen.jpg"));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane picScrollPane;
    private javax.swing.JLabel pictureLabel;
    // End of variables declaration//GEN-END:variables
}
