import javax.media.*;

import java.io.File;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class SimpleAudioPlayer{

	private Player audioPlayer;

	public SimpleAudioPlayer(URL url)throws IOException, NoPlayerException, CannotRealizeException{
		audioPlayer = Manager.createRealizedPlayer(url);
	}

	public SimpleAudioPlayer(File file)throws IOException, NoPlayerException, CannotRealizeException{
		this(file.toURL());
	}

	public void play(){
		audioPlayer.start();
	}

	public void stop(){
		audioPlayer.stop();
		audioPlayer.close();
	}

	public double getTotalTime(){
		Time t = audioPlayer.getDuration();
		return t.getSeconds()/60;
	}

	public static void main(String arg[])throws Exception{

		File file = new File("res/song.mp3");
		SimpleAudioPlayer audio = new SimpleAudioPlayer(file);

		System.out.println("Total Time: " + audio.getTotalTime());

		audio.play();

		System.out.print("Enter to stop audio");
		System.in.read();

		audio.stop();

	}

}