
/**
 *
 * @author Jay Kumar
 */
import java.awt.event.*;
import java.io.*;
import java.applet.*;

class PlayVoice{

    File file =null;
    
    public PlayVoice( java.io.File f) {
        
        file = f;
        try{
        play();
        }catch(Exception e){e.printStackTrace();}
    }
    public void play()throws Exception{
        AudioClip clip= Applet.newAudioClip(file.toURL());
				System.out.println("played");
				clip.play();               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
