
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Jay Kumar
 */
public class SettingPanel extends JPanel implements KeyListener{
    
    
    MainFrame frame;

    public SettingPanel(MainFrame f){
     frame = f;
     addKeyListener(this);
    }   

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    
        g.setColor(Color.white);
        g.drawString("MOVE UP: ",100 , 100);
        g.drawString("MOVE DOWN: ",100 , 150);
        g.drawString("MOVE LEFT: ",100 , 200);
        g.drawString("MOVE RIGHT: ",100 ,250);
        g.drawString("FIRE: ",100 , 300);
        g.drawString("BACK: ",100 , 350);
    
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("\u2191",200 , 100);
        g.drawString("\u2193",200 , 150);
        g.drawString("\u2190",200 , 200);
        g.drawString("\u2192",200 , 250);
        g.drawString("SPACE",200 , 300);
        g.drawString("ESC",200 , 350);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if((int)e.getKeyChar() == KeyEvent.VK_ESCAPE){
            frame.back(this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
