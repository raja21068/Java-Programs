
import java.awt.Rectangle;

/**
 *
 * @author Jay Kumar
 */
public class Enemy extends Rectangle{
    int initialPosition;

    public Enemy(int x, int y, int width, int height , int init) {
        super(x, y, width, height);
        initialPosition = init;
    }
    
}
