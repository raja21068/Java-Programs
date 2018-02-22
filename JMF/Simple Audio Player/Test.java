import javax.media.*;
import java.io.*;

public class Test{

	public static void main(String arg[])throws Exception{

		File f = new File("res/song.mp3");
		Player p = Manager.createRealizedPlayer(f.toURL());

		// Configure
		// Realize
		// Start
		//Stop

		p.start();

		System.out.println("Enter to stop");
		System.in.read();

		p.stop();
		p.close();

	}

}