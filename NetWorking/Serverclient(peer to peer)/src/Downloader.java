/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAJA
 */

    
import java.net.Socket;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class Downloader extends Thread {
    Downloader(Socket socket)
    {
        this.socket = socket;
    }
    
    public void run()
    {
        DataInputStream in = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            PrintStream out=new PrintStream(socket.getOutputStream());
            String filename=in.readLine();
            int filesize =Integer.parseInt(in.readLine());
            int packagesize= Integer.parseInt(in.readLine());
            int totalpackage=Integer.parseInt(in.readLine());
            int lastPackage=Integer.parseInt(in.readLine());
            System.out.println("file name:"+filename);
            System.out.println("file size:"+filesize);
            System.out.println("package size:"+packagesize);
            System.out.println("total package:"+totalpackage);
            System.out.println("last package:"+lastPackage);
           
            
            FileOutputStream file=new FileOutputStream("E:\\getfiles\\"+filename);
            byte[] data=new byte[packagesize];
            for(int i=0;i<=totalpackage;i++){

                    in.read(data, 0, packagesize);
                    file.write(data, 0, packagesize);
            }
            in.read(data, 0, lastPackage);
            file.write(data, 0, lastPackage);
            //System.out.println(""+filename+"\n"+filesize+"\n"+packagesize+"\n"+totalpackage+"\n"+lastPackage);
            file.close();
            in.close();
            out.close();
        } catch (Exception ex) {
            //Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (Exception ex) {
               // Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    Socket socket;
}

    
