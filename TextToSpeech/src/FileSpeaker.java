import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
 
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
 
public class FileSpeaker {
  public static void main(String[] args) throws Exception {
     // Voice Name
     String voiceName = "kevin";
     VoiceManager voiceManager = null;
     Voice voice = null;
 
     voiceManager = VoiceManager.getInstance();
     voice = voiceManager.getVoice(voiceName);
     voice.setPitch((float) 5.00);
     voice.setPitchShift((float) 40.005);
     voice.setPitchRange((float) 0.01);
     // "business", "casual", "robotic", "breathy"
     //voice.setStyle("business");
     voice.setStyle("casual");
     //voice.setStyle("robotic");
     //voice.setStyle("breathy");
            
     //allocate the resources for the voice
     voice.allocate();
 
     // Create input stream from file
     InputStream in = new FileInputStream(new File("D:/test.txt"));
     voice.speak(in);
 
     voice.deallocate();
   }
} 