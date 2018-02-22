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

class SendVoice extends Thread{
	
	private Socket socket;
	
	private final float sampleRate = 44100.0f;
	private final  int sampleSize = 16;
	private final int channel = 1;
	private final boolean signed = true;
	private final boolean bigEndian = true;
	
	
	private AudioFormat format;
	private DataLine.Info info;
	private TargetDataLine line;
	private PrintStream pOut;
	//private ObjectOutputStream pOut;
	
	SendVoice(Socket socket){
		this.socket = socket;
		format = new AudioFormat(sampleRate,sampleSize,channel,signed,bigEndian);
		info = new DataLine.Info(TargetDataLine.class, format);
		start();
	}
	
	public void run(){
		try{
			
			int bufferSize = (int)format.getSampleRate() * format.getFrameSize();
			byte buffer[] = new byte[bufferSize];
			//ByteArrayOutputStream out = new ByteArrayOutputStream();
			pOut = new PrintStream(socket.getOutputStream());
			//pOut = new ObjectOutputStream(socket.getOutputStream());
			
			line = (TargetDataLine)AudioSystem.getLine(info);
			line.open(format);
			line.start();
			
			while(true){
				int voice = line.read(buffer, 0, buffer.length);
				
				if(voice > 0){
					pOut.write(buffer, 0, voice);
					pOut.flush();
				}
			
			}
			
		}catch(Exception ex){ex.printStackTrace();}
		finally{
			try{
			pOut.close();
			line.drain();
			line.close();
			}catch(Exception ex){}
		}
		
	}
}
