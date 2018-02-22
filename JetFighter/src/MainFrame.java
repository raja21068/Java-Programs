
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
    Image icon;

    MenuPanel menuPanel;
    GamePanel gamePanel;
    SettingPanel settingPanel;

    public MainFrame(){
        setBounds(220,220,500,500);
        try{
        icon = ImageIO.read(new File("pic/menu-icon.png"));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Image not found pic/menu-icon.png");
            ex.printStackTrace();
        }
        setIconImage(icon);
        setResizable(false);

        menuPanel = new MenuPanel(this);
        add(menuPanel);
        menuPanel.setFocusable(true);
        menuPanel.setDoubleBuffered(true);

        settingPanel = new SettingPanel(this);
        
    }
        
    public static void main(String arg[]){
        MainFrame f = new MainFrame();
        f.setVisible(true);    
   }

    public void newGame(){
        gamePanel = new GamePanel(this);
        add(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.setDoubleBuffered(true);
        
        remove(menuPanel);
        
        repaint();
        validate();
        gamePanel.run();
    }
    
    public void setting(){
        add(settingPanel);
        settingPanel.setFocusable(true);
        settingPanel.setDoubleBuffered(true);
        
        remove(menuPanel);
        
        repaint();
        validate();
    }
    
    public void back(JPanel p){
        add(menuPanel);
        remove(p);
        repaint();
        validate();
    }
}
