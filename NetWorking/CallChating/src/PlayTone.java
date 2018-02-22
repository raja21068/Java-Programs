/**
 *
 * @author Jay Kumar
 */
public class PlayTone{
    java.io.File file;
    java.applet.AudioClip clip;
    PlayTone(java.io.File f){
       file = f;
       play();
    }
    
    public void play(){
        try{
            System.out.println("Tone start");
             clip = java.applet.Applet.newAudioClip(file.toURL());
            clip.play();
        }catch(Exception e){e.printStackTrace();}
    }
    public void stop(){
        clip.stop();
    }
    
}
