import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;

public class AcyclicGradient extends Canvas {
    AcyclicGradient() {
        setSize(500,100);
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setRect(0f,0f,500f,100f);
        GradientPaint gp;
        gp = new GradientPaint(200f,0f,Color.red,300f,0f,Color.white);
        g2.setPaint(gp);
        g2.fill(rect);
    }
    
}
