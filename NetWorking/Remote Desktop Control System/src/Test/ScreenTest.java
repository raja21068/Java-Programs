package Test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.io.BufferedOutputStream;
import javax.imageio.ImageIO;

public class ScreenTest {
    public static void main(String arg[])throws Exception{
        Robot robot = new Robot();
        
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
 
        BufferedImage image = robot.createScreenCapture(rec);
        ImageIcon icon = new ImageIcon(image);
//        JOptionPane.showMessageDialog(null, icon);
//          JFrame frame = new JFrame();
          
//          frame.getContentPane().add(new JLabel(icon));
//          frame.getContentPane().add(new JScrollPane().add(new JLabel(icon)));
            
//          frame.setSize(800, 800);
//          frame.getContentPane().setLayout(null);
//          java.awt.ScrollPane scroll = new java.awt.ScrollPane();
//          scroll.setBounds(frame.getBounds());
//          JLabel label  = new JLabel(icon);
//          scroll.add(label);
//          frame.getContentPane().add(scroll);
//          frame.setVisible(true);
//          BufferedOutputStream buffer = new BufferedOutputStream(new java.io.FileOutputStream("D:/screen.jpg"));
          java.io.FileOutputStream buffer = new java.io.FileOutputStream("D:/screen.jpg");
          ImageIO.write(image,"jpg",buffer);
          buffer.close();
//              image = robot.createScreenCapture(rec);
//              icon.setImage(image);
//              label.setIcon(icon);
//          }while(true);
    }
}
