import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Main {
  public static void main(String[] argv) throws Exception {

    Robot robot = new Robot();

    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);

  }
}