/**
The VoiceManager is the central repository of voices available to FreeTTS.
You can use this sample code to get available voice list.
*/
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
 
public class VoiceDetector {
    public static void main(String[] args) {
     VoiceManager voiceManager;
     voiceManager = VoiceManager.getInstance();
     // Get all available voices
     Voice[] voices = voiceManager.getVoices();
     for (int i = 0; i < voices.length; i++) {
       System.out.println(voices[i].getName());
     }
   }
}