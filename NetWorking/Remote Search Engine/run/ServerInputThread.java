
/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
        
public class ServerInputThread extends Thread{
    Socket socket;
    ServerInputThread(Socket s){
        socket = s;
    }
    public void run(){
        try{
        DataInputStream in = new DataInputStream(socket.getInputStream());
        String s = in.readUTF();
        System.out.println("recieved : "+s);
        if(s.contains("directory")){
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Vector v = new Vector();
            File[] file = new File("C:/").listRoots();
            for(int i=0;i<file.length;i++){
                v.add(file[i].getAbsolutePath());
                System.out.println("serverInputThread=> "+file[i].getAbsolutePath());
            }
            out.writeUTF(""+v.size());
            for(int i =0 ; i<v.size(); i++){
                try{
                    out.writeUTF((String)v.elementAt(i));
                }catch(Exception e){ e.printStackTrace();}
            }
        }
        else if(s.contains("search")){
            String drive = in.readUTF();
            System.out.println(drive);
            String fileName = in.readUTF();
            System.out.println(fileName);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            File[] files = new File(drive).listFiles();
            for(int i=0;i<files.length;i++){
                System.out.println(files[i].getAbsolutePath());
                if(files[i].isHidden()){
                    continue;
                }
                else{
                    if(files[i].isDirectory()){
                        searchFolder(files[i],fileName,out);
                    }
                    else{
                        searchFile(files[i],fileName,out);
                }
                }
                
            }
            out.writeUTF("exit");
        }
        else if(s.contains("information")){
            String filePath = in.readUTF();
            System.out.println(filePath);
            FileInputStream fileIn = new FileInputStream(filePath);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF((new File(filePath).getName()));
            out.writeUTF(""+fileIn.available());
            out.writeUTF(""+10000);
        }        
        else if(s.contains("download")){
            Vector v = DBManager.getAllIps();
            for(int i=0;i<v.size();i++){
                String temp = (String)v.elementAt(i);
                if(temp.contains(socket.getInetAddress().getHostAddress())){
                    int check=JOptionPane.showConfirmDialog(null, "you want to allow this"+socket.getInetAddress().getHostName()+" person to dpwnload file?");
                    if(check>0)socket.close(); }
            } 
            String filePath = in.readUTF();
            System.out.println(filePath);
            File f = new File(filePath);
            DataInputStream fileIn = new DataInputStream(new FileInputStream(f));
            int size = fileIn.available();
            System.out.println(size);
            int packetSize = 10000;
            int totalPacket = size/packetSize;
            int lastPacket = size%packetSize;
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(f.getName());
            out.writeUTF(""+size);
            out.writeUTF(""+packetSize);
            out.writeUTF(""+totalPacket);
            out.writeUTF(""+lastPacket);
            byte[] b = new byte[packetSize];
            for(int i=1;i<=totalPacket;i++){
                fileIn.readFully(b, 0, b.length);
                out.write(b, 0, b.length);
            }
                fileIn.readFully(b, 0, lastPacket);
                out.write(b, 0, lastPacket);
                
                fileIn.close();
                out.close();
        }
        
        socket.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
    public void searchFolder(File f ,String fileName,DataOutputStream out)throws Exception{
        String file = f.getName();
            if(file.contains(fileName)){
                out.writeUTF(f.getAbsolutePath());
             }
            if(f.isHidden()){return;}
            else{        
                File[] files = f.listFiles();
                try{
                    System.out.println(files.length);
                    if(files.length==0)return;
                    for(int i=0;i<files.length;i++){
                        if(files[i].isDirectory()){
                            System.err.println(files[i].getAbsolutePath());
                            searchFolder(files[i],fileName,out);
                        }
                        else{
                            searchFile(files[i],fileName,out);
                        }
                    }
                }catch(Exception ex){ex.printStackTrace();return;}
            }
            
    }
    public void searchFile(File f ,String fileName,DataOutputStream out)throws Exception{
            System.out.println(f.getName());
        if(f.getName().contains(fileName)){
                out.writeUTF(f.getAbsolutePath());
             }
    }
}
