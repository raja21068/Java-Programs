/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */

import com.sun.media.BasicPlayer;
import javax.media.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


class mp3 extends Thread{
    
    private URL url;
    private MediaLocator mediaLocator;
    private Player playMP3;
    
    public mp3(String mp3){
        try{
            this.url = new URL(mp3);
        }catch(java.net.MalformedURLException ex){ex.printStackTrace();}
    }
    
    public void run()
{

try{
   mediaLocator = new MediaLocator(url);     
   playMP3 = Manager.createPlayer(mediaLocator);
    }catch(java.io.IOException e)
      {System.out.println(e.getMessage());
    }catch(javax.media.NoPlayerException e)
      {System.out.println(e.getMessage());}

playMP3.addControllerListener(new ControllerListener()
  {
  public void controllerUpdate(ControllerEvent e)
     {
     if (e instanceof EndOfMediaEvent)
         {
         playMP3.stop();
         playMP3.close();
         }
     }
  }
 );
 playMP3.realize();
 playMP3.start();
 } 
}

public class playmp3{
  public static void main(String[] args)
  {
      
  javax.swing.JFileChooser choose = new javax.swing.JFileChooser();
  choose.showOpenDialog(null);
  System.out.println(""+choose.getSelectedFile().getAbsolutePath());
//  mp3 t = new mp3("file:///C://JavaApplications//cd.mp3");
//  mp3 t = new mp3("file:///"+choose.getSelectedFile().getAbsolutePath());
//  t.start();
      BasicPlayer b = new BasicPlayer() {

          @Override
          protected boolean audioEnabled() {
              return true;
          }

          @Override
          protected boolean videoEnabled() {
              return true;
          }

          @Override
          protected TimeBase getMasterTimeBase() {
              throw new UnsupportedOperationException("Not supported yet.");
          }

          @Override
          public void updateStats() {
              throw new UnsupportedOperationException("Not supported yet.");
          }
      };
  }
 
}