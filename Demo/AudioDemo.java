import java.applet.*;
import java.awt.*;
import java.io.*;

class AudioDemo extends Frame {

	AudioDemo(){
		setBounds(0,0,500,500);
		
		setVisible(true);
		
		AudioClip clip;
		try {
			clip = Applet.newAudioClip(new File("A.wav").toURL());
			clip.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	public static void main(String[] args)throws Exception {
		
		new AudioDemo();
		
		
	}

}
