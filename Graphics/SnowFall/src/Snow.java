import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Snow extends javax.swing.JFrame{
    int x[]=new int[300];
    int y[]=new int[300];
    int size[]=new int[300];
    int width = Toolkit.getDefaultToolkit().getScreenSize().width-10;
    int height= Toolkit.getDefaultToolkit().getScreenSize().height-10;   
    public void init(){
        for(int i=0;i<x.length;i++){
            x[i]=(int)(Math.random()*Toolkit.getDefaultToolkit().getScreenSize().width)+5;
            y[i]=0-((int)(Math.random()*height));
            size[i] = (int)(Math.random()*8)+4;
        }
    }
    
    @Override
    public void paint(java.awt.Graphics g){
        super.paint(g);
		g.setColor(Color.WHITE);
        for(int i=0;i<x.length;i++){
            g.fillOval(x[i], y[i], size[i], size[i]);
        }
    }
    
    public static void main(String arg[]){
        System.out.println("Hello");
        Snow s = new Snow();
        s.init();
        s.setUndecorated(true);
        s.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
//        s.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        s.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        s.getContentPane().setLayout(null);
        s.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        s.setVisible(true);
        for(;;){
        
            for(int i=0;i<s.x.length;i++){
                s.y[i]+=3;
                if(i%3==0){s.x[i]-=(int)(Math.random()*3);}
                else if(i%3==1){s.x[i]+=(int)(Math.random()*3);}
                if(s.y[i]>=s.height || s.x[i]>=s.width || s.x[i]<=0){
                    s.y[i]=0-((int)(Math.random()*300));
                    s.x[i]=(int)(Math.random()*Toolkit.getDefaultToolkit().getScreenSize().width);
                    s.size[i] = (int)(Math.random()*8)+4;
                }
            }
            s.repaint();
            try{
                Thread.sleep(20);
           }catch(Exception ex){ex.printStackTrace();}
        }
    }
    
}