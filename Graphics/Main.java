
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Main {
     public static void main(String args[]){
//        JWindow subFrame = new JWindow();           
        JFrame subFrame = new JFrame();
        subFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        subFrame.setUndecorated(true);
        subFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        subFrame.setOpacity(1.0f);
        subFrame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        subFrame.getContentPane().setLayout(null);
        subFrame.setVisible(true);
        new SnowFall(40,subFrame).start();
    }
}
