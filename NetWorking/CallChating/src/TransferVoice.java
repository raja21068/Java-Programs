/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */
import java.io.*;
import javax.sound.sampled.*;
import java.net.*;

class TransferVoice extends Thread{
	
	Socket socket;
	
	AudioFormat format;
	DataLine.Info info;
	TargetDataLine line;
	DataOutputStream out;
        
        ClientFrame frame;
	
	TransferVoice(Socket sock , ClientFrame cf){
		socket = sock;
		format = getAudioFormat();
		info = new DataLine.Info(TargetDataLine.class, format);
                frame = cf;
	}
	
	public void run(){
		try{
			int bufferSize = 50;
                        byte b[] = new byte[bufferSize];
                        int voice; 
			out = new DataOutputStream(socket.getOutputStream());
			
			line = (TargetDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();
			
			while(true){
				voice = line.read(b, 0, b.length);
                                       
                                            out.write(b, 0, voice);
                                            out.flush();
			}
			
		}catch(Exception ex){
                    javax.swing.JOptionPane.showMessageDialog(null,"Client is Busy....");
                    frame.stopButtonActionPerformed(null);
                }
		finally{
			try{
			out.close();
			line.drain();
			line.stop();
			line.close();
			}catch(Exception ex){}
                       
		}
		
	}
        AudioFormat getAudioFormat(){
         float sampleRate = 44100.0f;
	 int sampleSize = 16;
	 int channel = 1;
	 boolean signed = true;
	 boolean bigEndian = true;
            AudioFormat format = new AudioFormat(sampleRate , sampleSize, channel , signed , bigEndian);
            return format;
        }
}
