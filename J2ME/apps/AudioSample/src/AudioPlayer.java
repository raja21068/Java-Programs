/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;

public class AudioPlayer extends Form implements CommandListener, PlayerListener {
      Midlet midlet;
      private Display display;
      private Command play, stop, exit;
      private Player player;

      public AudioPlayer(Midlet midlet, Display display) {
            super("");
            this.midlet = midlet;
            this.display = Display.getDisplay(midlet);
            play = new Command("Play", Command.OK, 0);
            stop = new Command("Stop", Command.STOP, 0);
            exit = new Command("Exit", Command.EXIT, 0);
            addCommand(play);
            addCommand(stop);
            addCommand(exit);
            setCommandListener(this);
      }

      public void commandAction(Command c, Displayable d) {
            if (c == play) {
                  try {
                        playAudio();
                  } catch (Exception e) {
					e.printStackTrace();
                  }
            } else if (c == stop) {
                  player.close();
            } else if (c == exit) {
                  if (player != null) {
                        player.close();
                  }
                  midlet.destroyApp(false);
            }
      }

      public void playerUpdate(Player player, String event, Object eventData) {
      }

      public void playAudio() {
            try {
                  player = Manager.createPlayer(getClass().getResourceAsStream("/res/test.wav"), "audio/x-wav");
                  player.addPlayerListener(this);
                  player.setLoopCount(-1);
                  player.prefetch();
                  player.realize();
                  player.start();
            } catch (MediaException e) {
				System.out.println("No player created");
            } catch (IOException e) {
				System.out.println("IO Exception created..");
            }
      }
}