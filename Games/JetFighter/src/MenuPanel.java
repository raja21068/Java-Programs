
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jay Kumar
 */
public class MenuPanel extends JPanel implements KeyListener{

    static int OPTION_NEW_GAME = 0;
    static int OPTION_SETTING = 1;
    static int OPTION_EXIT = 2;
    
    int option= OPTION_NEW_GAME;  
    private int optionHighLightY;
        
    Image menuImage;
    MainFrame mainFrame;
   
    public MenuPanel(MainFrame f){
        mainFrame = f;
        optionHighLightY = (int)(f.getHeight()/2.4);
        
        try{
            menuImage = ImageIO.read(new File("pic/menu-icon.png"));
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,ex);
        }
        addKeyListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        menuLogoGraphics(g);
        optionsGraphics(g);
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Typed :"+(int)e.getKeyChar()+"  >> ENTER:"+KeyEvent.VK_ENTER);
        
        if((int)e.getKeyChar() == KeyEvent.VK_ENTER){
            optionSelected();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        optionChanged(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    private void optionsGraphics(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(getWidth()/3, getHeight()/3, 200, 200);
        
        g.setColor(new Color(122,0,133));
        g.fillRect((int)(getWidth()/3),optionHighLightY,160,30);
        
        g.setFont(new Font("Lucida Calligraphy" , Font.BOLD, 25));
        g.setColor(new Color(255,255,255));
        g.drawString("New Game" , (getWidth()/2)-70,getHeight()/2);		
        g.drawString("Setting" , (getWidth()/2)-50,getHeight()/2 + 40);
        g.drawString("Quit" , (getWidth()/2)-40,getHeight()/2 + 80);
    }
    
    private void menuLogoGraphics(Graphics g){
        g.setColor(Color.BLACK);
	g.fillRect(0, 0, getWidth(), getHeight());
		
        g.setColor(new Color(0,0,255));
        //g.fillRect(centerX-75,getHeight()/4,150,30);
        g.fillRoundRect(10,50,(getWidth()-20),100,30,20);
        g.setColor(new Color(12,33,90));
        g.fillRect(30,70,(getWidth()-60),60);

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Lucida Handwriting" , Font.BOLD, 30));
        g.drawString("Jet Fight",80,100);
		
        g.drawImage(menuImage,getWidth()-120,40,null);

        g.setFont(new Font("Lucida Calligraphy" , Font.BOLD, 25));
        
    }
    
    public void optionSelected(){
        if(option == OPTION_NEW_GAME){
            System.out.println("New Game Started..");
            mainFrame.newGame();
        }
        else if(option == OPTION_SETTING){ mainFrame.setting(); }
        else if(option == OPTION_EXIT){ System.gc(); System.exit(0); }
    }
    
    public void optionChanged(int code){
        if(code == KeyEvent.VK_UP){
            if(option == OPTION_NEW_GAME){ option = OPTION_EXIT; optionHighLightY+=80; }
            else if(option == OPTION_SETTING){ option = OPTION_NEW_GAME; optionHighLightY-=40; }
            else if(option == OPTION_EXIT){ option = OPTION_SETTING; optionHighLightY-=40;}
        }
        else if(code == KeyEvent.VK_DOWN){
            if(option == OPTION_NEW_GAME){ option = OPTION_SETTING; optionHighLightY+=40; }
            else if(option == OPTION_SETTING){ option = OPTION_EXIT; optionHighLightY+=40;}
            else if(option == OPTION_EXIT){ option = OPTION_NEW_GAME; optionHighLightY-=80; }
        
        }
        optionsGraphics(getGraphics());
    }
}
