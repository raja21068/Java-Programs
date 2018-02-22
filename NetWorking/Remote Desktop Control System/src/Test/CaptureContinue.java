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

public class CaptureContinue {
    public static void main(String arg[])throws Exception{
        Robot robot = new Robot();
        
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
 
        BufferedImage image = robot.createScreenCapture(rec);
        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
          

          frame.setSize(800, 800);
          frame.getContentPane().setLayout(null);
          java.awt.ScrollPane scroll = new java.awt.ScrollPane();
          scroll.setBounds(frame.getBounds());
          JLabel label  = new JLabel(icon);
          scroll.add(label);
          frame.getContentPane().add(scroll);
          frame.setVisible(true);
          BufferedOutputStream buffer = new BufferedOutputStream(new java.io.FileOutputStream("D:/screen.jpg"));
        do{

           image = robot.createScreenCapture(rec);
           icon.setImage(image);
           label.setIcon(icon);
           label.repaint();
           
           Thread.sleep(10);
          }while(true);
    }
}
