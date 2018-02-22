
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Main {
    public static void main(String arg[]){
          ClientFrame  cf = new ClientFrame();

          new UpdatingThread(cf.onlineUserList , "127.0.0.1",cf).start();
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
   JList list;
   String ip;
   ClientFrame clientFram;
    UpdatingThread(JList l , String ip , ClientFrame cf){
        list = l;
        this.ip = ip;
        clientFram =cf;
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource()==null){ return; }
                Object ob = list.getSelectedValue();
                String s = (String)ob;
                System.out.println(s);
                try{
                Socket socket = new Socket(s,9000);
                String ipSocket = socket.getInetAddress().getHostAddress();
                if(ipSocket.contains("127.0.0.1")){ clientFram.removeButton.setEnabled(true); }
                else{ clientFram.removeButton.setEnabled(false); }
                
                    listUpdating(socket);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
        });
        cf.downloadButton.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object ob = list.getSelectedValue();
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
            list.removeAll();
            list.setListData(v);
        }while(true);
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Server is Closed....");
        }
        System.exit(0);
    }
    
    void listUpdating(Socket s)throws Exception{
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF("file");
        DataInputStream in = new DataInputStream(s.getInputStream());
        int size = Integer.parseInt(in.readUTF());
        System.out.println("Size "+size);
        Vector vec = new Vector();
        for(int i=0; i<size ; i++){
            try{
            vec.addElement(in.readUTF());
            }catch(Exception e){ e.printStackTrace(); }
        }
        for(int i=0; i<vec.size() ; i++){
            System.out.println("vector :"+(String)vec.elementAt(i));
        }
        clientFram.sharedFileList.removeAll();
        clientFram.sharedFileList.setListData(vec);
    }
    void fileRecieving(Socket s)throws Exception{
        final Socket sock = s;
        new Thread(){
        public void run(){
            try{
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                out.writeUTF("download");
                System.out.println((String)clientFram.sharedFileList.getSelectedValue());
                out.writeUTF((String)clientFram.sharedFileList.getSelectedValue());
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
                File f = new File(filename);
                f.createNewFile();
                System.out.println("file Created.....");
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
            }catch(Exception e){e.printStackTrace(); JOptionPane.showMessageDialog(clientFram,"You are restricted....");
              }    
            }
        
             }.start();
        
    }
}