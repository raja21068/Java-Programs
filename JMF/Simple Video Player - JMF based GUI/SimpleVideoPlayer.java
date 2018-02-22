import javax.media.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class SimpleVideoPlayer{

	public static void main(String arg[])throws Exception{

		JFrame frame = new JFrame("Simple Video Player - ALi Asad Khowaja");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("res/demo.mp4");
		MediaLocator ml = new MediaLocator(file.toURL());
		Player player = Manager.createRealizedPlayer(ml);

		if(player.getVisualComponent() != null)
			frame.add(BorderLayout.CENTER, player.getVisualComponent());
		if(player.getControlPanelComponent() != null)
			frame.add(BorderLayout.SOUTH, player.getControlPanelComponent());

		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.show();

		player.start();


	}

}