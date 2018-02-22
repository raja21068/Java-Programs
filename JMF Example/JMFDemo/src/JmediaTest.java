import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFrame;


class JmediaTest extends JFrame{
      private final static long serialVersionUID = 15L;
      private Player player;      

      public JmediaTest(String title, URL url){
	 super(title);
         Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);         

        try{
              createPlayerAndShowComponents(url);
        }catch(Exception ex){ex.printStackTrace();}

         
      }
      
      public void createPlayerAndShowComponents(URL url)throws IOException,NoPlayerException,CannotRealizeException{
          player = Manager.createRealizedPlayer(url);
          Component comp;
          if((comp = player.getVisualComponent()) != null ){
                add(comp , BorderLayout.CENTER);
          }
          if((comp = player.getControlPanelComponent()) != null ){
                add(comp , BorderLayout.SOUTH);
          } 
     }
		
}