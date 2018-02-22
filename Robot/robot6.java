//Create mouse event using Robot class
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {
  public static void main(String[] args) throws Exception {
    Robot robot = new Robot();

    robot.mouseMove(200, 200);

    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.mouseWheel(-100);
  }
}