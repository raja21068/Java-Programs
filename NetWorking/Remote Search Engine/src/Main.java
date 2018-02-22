
import java.awt.TrayIcon.MessageType;
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Main {
    public static void main(String arg[]){
          ClientFrame  cf = new ClientFrame();
//          LogInn login = new LogInn(cf);
//          login.setVisible(true);
          String s = (String)JOptionPane.showInputDialog(cf, "Remote Search Engine", "Enter IP Address", 0, new ImageIcon("login.png"), null, null);
          
          new UpdatingThread(s,cf).start();
          cf.setVisible(true);
          try{
    		ServerSocket server= new ServerSocket(9000); 	
    		do{
				Socket socket = server.accept();
				System.out.println("Connected with : "+socket.getInetAddress());
                                new ServerInputThread(socket).start();
                                
    		}while(true);
    	}catch(Exception e){}
    }
}
class UpdatingThread extends Thread{
   String path=""; 
   JList fileList;
   String ip;
   ClientFrame clientFram;
    UpdatingThread(String ip , ClientFrame cf){
        fileList = cf.filesList;
        this.ip = ip;
        clientFram =cf;
        cf.refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        cf.filesList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt){
                if(evt.getSource()==null)return;
                String ip = (String)(clientFram.onlineUserList.getSelectedValue());
                System.out.println("ipAddress at Main Class and in constructor: "+ip);
                try{
                    Socket sock = new Socket(ip,9000);
                    fileInformation(sock);
                }catch(Exception ex){ex.printStackTrace();}
                
            }
        });
        cf.onlineUserList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent evt){
                if(evt.getSource()==null)return;
                String ip = (String)(clientFram.onlineUserList.getSelectedValue());
                System.out.println("ipAddress at Main Class and in constructor: "+ip);
                try{
                    Socket sock = new Socket(ip,9000);
                    directoryRecieving(sock);
                }catch(Exception ex){ex.printStackTrace();}
                
            }
        });
        cf.searchNameButton.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(evt.getSource()==null)return;
                fileSearching();
            }
        });
        cf.downloadButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((clientFram.fileNameTextField.getText().length())<1){
                    JOptionPane.showMessageDialog(clientFram, "Invalid File Name");
                    return;
                }
                Object ob = clientFram.onlineUserList.getSelectedValue();
                String s = (String)ob;
                System.out.println(s);
                try{
                Socket socket = new Socket(s,9000);
                fileRecieving(socket);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
        });
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
            clientFram.onlineUserList.removeAll();
            clientFram.onlineUserList.setListData(v);
        }while(true);
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Server is Closed....");
        }
        System.exit(0);
    }
   
    void fileRecieving(Socket s)throws Exception{
        JFileChooser choose = new JFileChooser();
        choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        choose.showSaveDialog(new JFrame());
        path = choose.getSelectedFile().getAbsolutePath();
        final Socket sock = s;
        new Thread(){
        public void run(){
            try{
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                out.writeUTF("download");
                System.out.println((String)clientFram.filesList.getSelectedValue());
                out.writeUTF((String)clientFram.filesList.getSelectedValue());
                DataInputStream in = new DataInputStream(sock.getInputStream());
                String filename = in.readUTF();
                clientFram.fileNameLabel.setText("File Name :"+filename);
                int size = Integer.parseInt(in.readUTF());
                System.out.println("received"+size);
                clientFram.fileSizeLabel.setText("File Size : "+size);
                int packetSize = Integer.parseInt(in.readUTF());
                clientFram.packetSizeLabel.setText("Packet Size :"+packetSize );
                System.out.println("received"+packetSize);
                int totalPacket = Integer.parseInt(in.readUTF());
                clientFram.totalPacketLabel.setText("Total Packet:"+totalPacket+1);
                System.out.println("received"+totalPacket);
                int lastPacket = Integer.parseInt(in.readUTF());
                System.out.println("received"+lastPacket);
                clientFram.progressBar.setValue(0);
                clientFram.progressBar.setMaximum(0);
                clientFram.progressBar.setMaximum(totalPacket+1);
                clientFram.progressBar.setStringPainted(true);
                File f  = new File(path+"/"+filename);
                f.createNewFile();
                DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(f));
                byte b[] = new byte[packetSize];
                for(int i=1 ; i<=totalPacket ; i++){
                    in.readFully(b, 0, b.length);
                    fileOut.write(b, 0 ,b.length);
                    clientFram.progressBar.setValue(i);
                    clientFram.packetNoLabel.setText("Packet# "+i);                        
                }
                in.readFully(b, 0, lastPacket);
                fileOut.write(b, 0 ,lastPacket);
                clientFram.progressBar.setValue(totalPacket+1);
                clientFram.packetNoLabel.setText("Packet# "+totalPacket+1);
                fileOut.close();
            }catch(Exception e){e.printStackTrace(); JOptionPane.showMessageDialog(clientFram,"You are restricted....\n"+e);
              }    
            }
        
             }.start();
            }
    
     public void refreshButtonActionPerformed(java.awt.event.ActionEvent e){
         if(clientFram.onlineUserList.isSelectionEmpty()){
             System.out.println((String)clientFram.onlineUserList.getSelectedValue());
            JOptionPane.showMessageDialog(clientFram,"No ip is Selected");
             return;
         }   
         String s = (String)clientFram.onlineUserList.getSelectedValue();
            System.err.println("refresh Action Performed: "+s);
            try{
            Socket sock = new Socket(ip,9000);
            directoryRecieving(sock);
            }catch(Exception ex){ex.printStackTrace();}          
    }
    
    public void directoryRecieving(Socket sock)throws Exception{
        DataOutputStream out = new DataOutputStream(sock.getOutputStream());
        out.writeUTF("directory");
        DataInputStream socketIn = new DataInputStream(sock.getInputStream());
        int size = Integer.parseInt(socketIn.readUTF());
        System.out.println("(Main=>updating Thread=>directory recieving) Size "+size);
         Vector vec = new Vector();
        for(int i=0; i<size ; i++){
            try{
            vec.addElement(socketIn.readUTF());
            System.out.println("(Main=>updating Thread=>directory recieving)vector :"+(String)vec.elementAt(i));
            }catch(Exception e){ e.printStackTrace(); }
        }
        clientFram.driveComboBox.removeAllItems();
        for(int i=0;i<vec.size();i++){
            clientFram.driveComboBox.addItem((String)vec.elementAt(i));
        }
    }
    public void fileSearching(){
        new Thread(){
            public void run(){
                Object ob = clientFram.onlineUserList.getSelectedValue();
                String ip = (String)ob;
                System.out.println(ip);
                try{
                    Socket socket = new Socket(ip,9000);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("search");
                    out.writeUTF((String)clientFram.driveComboBox.getSelectedItem());
                    out.writeUTF(clientFram.fileNameTextField.getText());
                    DataInputStream in= new DataInputStream(socket.getInputStream());
                    Vector vec= new Vector();
                    String s=in.readUTF();
                    while(!(s.contains("exit"))){
                        vec.addElement(s);
                        clientFram.filesList.setListData(vec);
                        s=in.readUTF();
                    }
                }catch(Exception ex){ex.printStackTrace();}
            }
        }.start();
        
    }
    public void fileInformation(Socket s)throws Exception{
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String filePath = (String)clientFram.filesList.getSelectedValue();
        out.writeUTF("information");
        out.writeUTF(filePath);
        String fileName = in.readUTF();
        String fileSize = in.readUTF();
        String packetSize = in.readUTF();
        clientFram.fileNameLabel.setText("File Name: "+fileName);
        clientFram.fileSizeLabel.setText("File Size: "+fileSize);
        clientFram.packetSizeLabel.setText("Packet Size: "+packetSize);
        int size = Integer.parseInt(fileSize);
        int pSize = Integer.parseInt(packetSize);
        clientFram.totalPacketLabel.setText("Total Packet: "+(size/pSize));
        clientFram.lastPacketLabel.setText("Last Packet: "+(size%pSize));
    }
}