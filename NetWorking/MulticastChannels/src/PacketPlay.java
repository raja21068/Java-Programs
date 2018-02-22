
/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import java.io.*;
import javax.swing.JFrame;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class PacketPlay{
    DataLine.Info info;
    SourceDataLine line;
    AudioFormat audioFormat;   
    
    public void lineOpen()throws Exception{
        audioFormat = getAudioFormat();
        info = new DataLine.Info(SourceDataLine.class, audioFormat);
        line = (SourceDataLine)AudioSystem.getLine(info);		
        line.open(audioFormat);
        line.start();
        System.err.println("Line started");
    }
    public void playPacket(byte[] b){
        line.write(b, 0, b.length);
    }
    AudioFormat getAudioFormat(){
        final float sampleRate = 44100.0f;
	 final  int sampleSize = 16;
	 final int channel = 1;
	 final boolean signed = true;
	 final boolean bigEndian = false;
         
        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSize, channel , signed , bigEndian);
        return audioFormat;
}
}
