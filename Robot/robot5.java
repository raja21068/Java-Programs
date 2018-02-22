import java.awt.Color;
import java.awt.Robot;

public class Main {
  public static void main(String[] args) throws Exception{
    Robot robot = new Robot();

    Color color = robot.getPixelColor(20, 20);

    System.out.println("Red   = " + color.getRed());
    System.out.println("Green = " + color.getGreen());
    System.out.println("Blue  = " + color.getBlue());
  }
}