import javax.media.Player;
import javax.swing.JFrame;
import java.net.URL;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.CannotRealizeException;
import java.awt.*;
import java.io.*;
import javax.swing.*;


class JmediaTestMain{
      public static void main(String arg[]){
          JFileChooser chooser = new JFileChooser();
          int option = chooser.showOpenDialog(null);
          if(option == JFileChooser.APPROVE_OPTION){
               try{
                    URL url = chooser.getSelectedFile().toURL();
                    createAndShowGUI(url);
               }catch(Exception ex){ex.printStackTrace();}
          } 
     }
      
     public static void createAndShowGUI(URL url){
         JmediaTest playerFrame = new JmediaTest("jmedia player",url);
         playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         playerFrame.setSize(400,400);
         playerFrame.setVisible(true);
    }
		
}//end of class