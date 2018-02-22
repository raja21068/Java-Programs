package Test;

import java.net.Socket;
import java.io.DataOutputStream;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.FileInputStream;
public class Sending {
    
    public static void main(String arg[])throws Exception{
        System.out.println("Waiting for connection....");
        
        Socket socket = new Socket("127.0.0.1",9090);
          System.out.println("Connected....");
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//        BufferedOutputStream stream = new BufferedOutputStream(socket.getOutputStream());
        
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        
        Robot robot = new Robot();
//        do{
        BufferedImage image = robot.createScreenCapture(rec);
//        ImageIcon icon = new ImageIcon(image);
        
//        BufferedOutputStream buffer = new BufferedOutputStream(new java.io.FileOutputStream("D:/screen.jpg"));
         java.io.FileOutputStream buffer = new java.io.FileOutputStream("D:/screen.jpg");
         ImageIO.write(image,"jpg",buffer);
         buffer.close();
        FileInputStream file = new FileInputStream("D:/screen.jpg");
        
        int size = file.available();
        int packet = 10000;
        int totalpack = size/10000;
        int lastpack = size%10000;
        byte[] data= new byte[packet];
        out.writeUTF(""+size);
        out.writeUTF(""+packet);
        for(int i=1;i<=totalpack;i++){
            file.read(data, 0, data.length);
            out.write(data, 0, data.length);
        }
        file.read(data, 0, lastpack);
        out.write(data, 0, lastpack);
//    }while(true);
    }
}
