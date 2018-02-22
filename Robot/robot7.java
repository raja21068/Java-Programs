import java.awt.Rectangle;
import java.awt.Robot;
//capturing screen shot

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Main {
  public static void main(String[] argv) throws Exception {
    Robot robot = new Robot();
    int x = 100;
    int y = 100;
    int width = 200;
    int height = 200;
    Rectangle area = new Rectangle(x, y, width, height);
    BufferedImage bufferedImage = robot.createScreenCapture(area);

    area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    bufferedImage = robot.createScreenCapture(area);
  }
}