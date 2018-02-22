
/**
 *
 * @author Jay Kumar
 */
import java.net.*;
import java.io.*;
import javax.swing.JFrame;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class InputThreadOfServer extends Thread{
    Socket socket;
    DataLine.Info info;
    SourceDataLine line;
    AudioFormat audioFormat;
    
    InputThreadOfServer(Socket socket){
        this.socket = socket;
        audioFormat = getAudioFormat();
        info = new DataLine.Info(SourceDataLine.class, audioFormat);
    }
    public void run(){
        try{
            int bufferSize = 50;            
            DataInputStream in=new DataInputStream(socket.getInputStream());
			//String s = in.readUTF();
                        byte b[] =new byte[bufferSize];
                        line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(audioFormat);
                        line.start();
                        int voice = in.read(b, 0, b.length);
                        Thread.sleep(1000);
                        do{ 
			    if(voice > 0)
                            	line.write(b, 0, voice);
                            
                            //line.drain();
                            voice = in.read(b, 0, b.length);
                            if(voice<1) {line.stop();line.close();stop();}
                        }while(true);
                      
        }catch(Exception e){e.printStackTrace(); JOptionPane.showMessageDialog(null,"client is closed...");
        }
    
    }
    AudioFormat getAudioFormat(){
        final float sampleRate = 44100.0f;
	 final  int sampleSize = 16;
	 final int channel = 1;
	 final boolean signed = true;
	 final boolean bigEndian = true;
         
        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSize, channel , signed , bigEndian);
        return audioFormat;
}
}
