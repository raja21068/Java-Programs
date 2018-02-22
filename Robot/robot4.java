import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Main {
  public static void main(String[] args) throws Exception {
    Robot robot = new Robot();

    robot.delay(3000);

    robot.keyPress(KeyEvent.VK_Q);
    robot.keyPress(KeyEvent.VK_W);
    robot.keyPress(KeyEvent.VK_E);
    robot.keyPress(KeyEvent.VK_R);
    robot.keyPress(KeyEvent.VK_T);
    robot.keyPress(KeyEvent.VK_Y);
  }
}