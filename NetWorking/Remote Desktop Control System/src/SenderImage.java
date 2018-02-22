import java.net.Socket;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class SenderImage {
    public static void main(String arg[])throws Exception{
        System.out.println("Waiting for connection....");
        String ip = JOptionPane.showInputDialog(null,"Enter ip address");
        Socket socket = new Socket(ip,9090);
        System.out.println("Connected..");  
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        
        Robot robot = new Robot();
        new MousePointer(socket , robot).start();
        do{            
            BufferedImage image = robot.createScreenCapture(rec);
            ImageIO.write(image, "jpg", byteOut);
            byte[] data = byteOut.toByteArray();
            out.println(data.length);
            out.write(data,0,data.length);
            byteOut.reset();
//            System.out.println("sended...");
        
        }while(true);
//        out.close();
    }
}
class MousePointer extends Thread{
    Socket socket;
    DataInputStream in;
    Robot robot;
    MousePointer(Socket s , Robot r)throws Exception{
        socket = s;
        robot =r;
        in = new DataInputStream(socket.getInputStream());
    }
    public void run(){
        
        do{
            try{
            
                int x = Integer.parseInt(in.readUTF());
                System.out.println(x);
                if(x>1){
                    int y = Integer.parseInt(in.readUTF());
//                  System.out.println("x:"+x+",y:"+y);
                    robot.mouseMove(x, y);
                } 
                else if(x==-1){
                    System.out.println("LEFT_CLICKED");
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    
                }
                else{
                    System.out.println("RIGHT_CLICKED");
                    robot.mousePress(InputEvent.BUTTON3_MASK);
                    robot.mouseRelease(InputEvent.BUTTON3_MASK);
                }
                
             }catch(Exception ex){JOptionPane.showMessageDialog(null, ex);
                    }
         }while(true);
        

    }
}