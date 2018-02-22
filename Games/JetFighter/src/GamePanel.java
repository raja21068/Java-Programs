
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements KeyListener{
    
    //Initialization Of Variables
    ArrayList<Rectangle> starsCoordinatesList;
    ArrayList<Rectangle> fireCoordinatesList;
    ArrayList<Enemy> enemyCoordinatesList;
    boolean isFiring = false;
    boolean threadControl = true;
    BufferedImage heroImage;
    BufferedImage enemyImage;
    int enemyCount;
    long timeInterval;
    int stars = 100;
    int starIncreament = 1;
    int enemyIncreament = 2;
    int heroX;
    int heroY;
    int heroYLimit;
    int fireWidth = 4;
    int fireHeight = 7;
    int score = 0;
    MainFrame frame;
    Thread starsMovingThread;
    
    public GamePanel(MainFrame f){
        frame = f;
        starsCoordinatesList = new ArrayList();
        fireCoordinatesList = new ArrayList();
        enemyCoordinatesList = new ArrayList();
        try{
            heroImage = ImageIO.read(new File("pic/Jet-icon.png"));
            enemyImage = ImageIO.read(new File("pic/red-jet.png"));
        }catch(Exception ex){ex.printStackTrace();}
        
        heroX = frame.getWidth()/2;
        heroY = frame.getHeight() - (heroImage.getHeight()/2)-heroImage.getHeight();
        heroYLimit = heroY;
        
        levelOne();
        
        for(int i=1; i<=stars; i++){
            int x = (int)(Math.random()*frame.getWidth());
            int y = (int)(Math.random()*frame.getHeight());
            Rectangle r = new Rectangle(x, y, 2, 2);
            starsCoordinatesList.add(r);
        }
        
        initEnemy();
        addKeyListener(this);
        
    }

    public void initEnemy(){
        for(int i=0;i<enemyCount;i++){
            int y = (int)(Math.random()* -2000);
            int x = (int)(Math.random()*(frame.getWidth()-40));
            System.out.print(x+" , ");
            Enemy en = new Enemy(x, y, enemyImage.getWidth(), enemyImage.getHeight(), y);
            enemyCoordinatesList.add(en);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        
        
        g.setColor(Color.white);
        for(Rectangle r: starsCoordinatesList){
            if(r.y >= frame.getHeight())r.y = 0; 
            g.fillArc(r.x, r.y+=starIncreament, r.width,r.height, 0, 360);
        }
        starIncreament = 0; //because of HeroMoving
        g.drawImage(heroImage, heroX,heroY, frame);
        
        handleFire(g);
        checkCollision(g);
        
        enemyIncreament = 0;
        g.setColor(Color.white);
        g.drawString("Score: "+score, 10, 10);
        g.drawString("Aliens: "+enemyCoordinatesList.size(), 10, 20);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(threadControl){
            if((int)e.getKeyChar() == KeyEvent.VK_SPACE)addFire(heroX, heroY);
            else if((int)e.getKeyChar() == KeyEvent.VK_ESCAPE){  threadControl = false; frame.back(this); }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(threadControl)heroMove(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(threadControl)heroMove(e);
    }
    
    public void heroMove(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){ if(heroY-4 > 10)heroY-= 4; }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){ if(heroY+4 < heroYLimit)heroY+= 4; }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){ if(heroX-2 > 1)heroX-= 4; }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){ if(heroX+heroImage.getWidth()+4 < frame.getWidth()-2)heroX+= 4; }
        repaint();
    }
    
    public void addFire(int x , int y){
        fireCoordinatesList.add(new Rectangle((x+(int)(heroImage.getWidth()/2.2)), y-10, fireWidth, fireHeight));
        if(!isFiring){
            isFiring = true;
        }
    }
        
    public void run(){
        starsMovingThread = new Thread(){
            public void run(){
                while(threadControl){
                    starIncreament = 1;
                    enemyIncreament = 2;
                    repaint();
                    try{
                        Thread.sleep(timeInterval);
                    }catch(Exception ex){ex.printStackTrace();}
                }
                try{
                    Thread.sleep(2000);
                    back();
                }catch(Exception ex){ex.printStackTrace();}
            }
        };
        starsMovingThread.start();
    }
        
    public void back(){
        frame.back(this);
    }
    
    public void handleFire(Graphics g){
        g.setColor(Color.ORANGE);
        if(isFiring){
            for(int i=0;i<fireCoordinatesList.size();i++){
                Rectangle r = fireCoordinatesList.get(i);
                if((r.y-=2) <= 0){ fireCoordinatesList.remove(i); i--; continue; }
                g.fillRect(r.x, r.y, r.width, r.height);
                for(int j=0;j<enemyCoordinatesList.size();j++){
                    Rectangle rect = (Rectangle)enemyCoordinatesList.get(j);
                    if(rect.intersects(r)){
                        enemyCoordinatesList.remove(j);
                        fireCoordinatesList.remove(i);
                        i--;
                        j--;
                        score+=10;
                    }
                }
            }
            if(fireCoordinatesList.isEmpty()){ System.out.println("Firing Stooped..");  isFiring = false; }
        }
    }
    
    public void checkCollision(Graphics g){
        if(! enemyCoordinatesList.isEmpty()){
            for(int i=0; i<enemyCoordinatesList.size();i++ ){
                Enemy enemy = enemyCoordinatesList.get(i);
                if(enemy.y >= frame.getHeight()){ enemy.y = enemy.initialPosition;  }
                g.drawImage(enemyImage, enemy.x, enemy.y+=enemyIncreament, frame);
                if(enemy.intersects(new Rectangle(heroX,heroY,heroImage.getWidth()-5, heroImage.getHeight()-5))){
                    try{
                        gameOver(g);
                    }catch(Exception ex){ ex.printStackTrace(); }
                    
                }
            }
        }else{
            levelTwo();
        }
    }
    
    public void gameOver(Graphics g)throws Exception{
        threadControl = false;
        heroImage = ImageIO.read(new File("pic/fire-ring-icon.png"));
        g.drawImage(heroImage, heroX+5,heroY+2, frame);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Game Over", (frame.getWidth()/3), (frame.getHeight()/2));
        g.dispose();
    }
    
    public void levelOne(){
        enemyCount = 10;
        timeInterval = 20;
    }
    
    public void levelTwo(){
        enemyCount = 20;
        timeInterval = 10;
        initEnemy();
    }
}