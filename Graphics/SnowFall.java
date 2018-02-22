
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
/**
 *
 * @author DELL
 */
public class SnowFall extends Thread{
    public  MyLabel[] l = new MyLabel[13];
    public  MyLabel[] l2 = new MyLabel[13];
    public  MyLabel[] l3 = new MyLabel[13];
    public  MyLabel[] l4 = new MyLabel[13];
    public  MyLabel[] l5 = new MyLabel[13];
    public  MyLabel[] l6 = new MyLabel[13];
    public  MyLabel[] l7 = new MyLabel[13];
    public  MyLabel[] l8 = new MyLabel[13];
    public  MyLabel[] l9 = new MyLabel[13];
    public  MyLabel[] l10 = new MyLabel[13];
    public  MyLabel[] l11 = new MyLabel[13];
    public  MyLabel[] l12 = new MyLabel[13];
    public  MyLabel[] l13 = new MyLabel[13];
    public  MyLabel[] l14 = new MyLabel[13];
    public  MyLabel[] l15 = new MyLabel[13];
    public  MyLabel[] l16 = new MyLabel[13];
    public  MyLabel[] l17 = new MyLabel[13];
    public  MyLabel[] l18 = new MyLabel[13];
    
    int x;
    Window subFrame;
    public SnowFall(int x  ,Window w){
        this.x = x;
        subFrame = w;
    }
    public void run(){
        
        
        for(int i=0;i<l.length;i++){
            l[i] = new MyLabel();
            subFrame.add(l[i]);
            
            l2[i] = new MyLabel();
            subFrame.add(l2[i]);
            
            l3[i] = new MyLabel();
            subFrame.add(l3[i]);
            
            l4[i] = new MyLabel();
            subFrame.add(l4[i]);
            
            l5[i] = new MyLabel();
            subFrame.add(l5[i]);
            
            l6[i] = new MyLabel();
            subFrame.add(l6[i]);
            
            l7[i] = new MyLabel();
            subFrame.add(l7[i]);
            
            l8[i] = new MyLabel();
            subFrame.add(l8[i]);
            
            l9[i] = new MyLabel();
            subFrame.add(l9[i]);
            
            l10[i] = new MyLabel();
            subFrame.add(l10[i]);
            
            l11[i] = new MyLabel();
            subFrame.add(l11[i]);
            
            l12[i] = new MyLabel();
            subFrame.add(l12[i]);
            
            l13[i] = new MyLabel();
            subFrame.add(l13[i]);
            
            l14[i] = new MyLabel();
            subFrame.add(l14[i]);
            
            l15[i] = new MyLabel();
            subFrame.add(l15[i]);
    
            l16[i] = new MyLabel();
            subFrame.add(l16[i]);
            
            l17[i] = new MyLabel();
            subFrame.add(l17[i]);
            
            l18[i] = new MyLabel();
            subFrame.add(l18[i]);
        }
        int width=10;
        int height=10;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
               
        for(int i=0;x<=screenWidth;x+=150,i++){
                l[i].setBounds(x, 200 , width, height);
                l2[i].setBounds(x+50, 150 , width, height);
                l3[i].setBounds(x, 100 , width, height);
                l4[i].setBounds(x+50, 50 , width, height);
                l5[i].setBounds(x, 0 , width, height);
                l6[i].setBounds(x+50, -50 , width, height);
                l7[i].setBounds(x, -100 , width, height);
                l8[i].setBounds(x+50, -150 , width, height);
                l9[i].setBounds(x, -200 , width, height);
                l10[i].setBounds(x+50, -250 , width, height);
                l11[i].setBounds(x, -300 , width, height);
                l12[i].setBounds(x+50, -350 , width, height);
                l13[i].setBounds(x, -400 , width, height);
                l14[i].setBounds(x+50, -450 , width, height);
                l15[i].setBounds(x, -500 , width, height);
                l16[i].setBounds(-(i*20), (i*40)-20 , width, height);
                l17[i].setBounds(-(i*40), i*80 , width, height);
                l17[i].setBounds(screenWidth, i*40 , width, height);
        }
        while(true){   
            
            for(int i=0;i<l.length;i++ ){
                l[i].setBounds(l[i].getX(), l[i].getY()+2, width, height);
                if(l[i].getY()>=screenHeight){l[i].setBounds(l[i].getX(), 0, width, height);}
                
                l2[i].setBounds(l2[i].getX(),l2[i].getY()+2 , width, height);
                if(l2[i].getY()>=screenHeight){l2[i].setBounds(l2[i].getX(), 0, width, height);}
                
                l3[i].setBounds(l3[i].getX(),l3[i].getY()+2 , width, height);
                if(l3[i].getY()>=screenHeight){l3[i].setBounds(l3[i].getX(), 0, width, height);}
                
                l4[i].setBounds(l4[i].getX(),l4[i].getY()+2 , width, height);
                if(l4[i].getY()>=screenHeight){l4[i].setBounds(l4[i].getX(), 0, width, height);}
                
                l5[i].setBounds(l5[i].getX(),l5[i].getY()+2 , width, height);
                if(l5[i].getY()>=screenHeight){l5[i].setBounds(l5[i].getX(), 0, width, height);}
                
                l6[i].setBounds(l6[i].getX(),l6[i].getY()+2 , width, height);
                if(l6[i].getY()>=screenHeight){l6[i].setBounds(l6[i].getX(), 0, width, height);}
                
                l7[i].setBounds(l7[i].getX(),l7[i].getY()+2 , width, height);
                if(l7[i].getY()>=screenHeight){l7[i].setBounds(l7[i].getX(), 0, width, height);}
                
                l8[i].setBounds(l8[i].getX(),l8[i].getY()+2 , width, height);
                if(l8[i].getY()>=screenHeight){l8[i].setBounds(l8[i].getX(), 0, width, height);}
                
                l9[i].setBounds(l9[i].getX(),l9[i].getY()+2 , width, height);
                if(l9[i].getY()>=screenHeight){l9[i].setBounds(l9[i].getX(), 0, width, height);}
                
                l10[i].setBounds(l10[i].getX(),l10[i].getY()+2 , width, height);
                if(l10[i].getY()>=screenHeight){l10[i].setBounds(l10[i].getX(), 0, width, height);}
                
                l11[i].setBounds(l11[i].getX(),l11[i].getY()+2 , width, height);
                if(l11[i].getY()>=screenHeight){l11[i].setBounds(l11[i].getX(), 0, width, height);}
                
                l12[i].setBounds(l12[i].getX(),l12[i].getY()+2 , width, height);
                if(l12[i].getY()>=screenHeight){l12[i].setBounds(l12[i].getX(), 0, width, height);}
                
                l13[i].setBounds(l13[i].getX(),l13[i].getY()+2 , width, height);
                if(l13[i].getY()>=screenHeight){l13[i].setBounds(l13[i].getX(), 0, width, height);}
                
                l14[i].setBounds(l14[i].getX(),l14[i].getY()+2 , width, height);
                if(l14[i].getY()>=screenHeight){l14[i].setBounds(l14[i].getX(), 0, width, height);}
                
                l15[i].setBounds(l15[i].getX(),l15[i].getY()+2 , width, height);
                if(l15[i].getY()>=screenHeight){l15[i].setBounds(l15[i].getX(), 0, width, height);}
                
                l16[i].setBounds(l16[i].getX()+2, l16[i].getY()+2 , width, height);
                if(l16[i].getY()>=screenHeight){l16[i].setBounds(-(i*10), (i*60)-20, width, height);}
                
                l17[i].setBounds(l17[i].getX()+2, l17[i].getY()+2 , width, height);
                if(l17[i].getY()>=screenHeight){l17[i].setBounds(-(i*10), i*60, width, height);}
                
                l18[i].setBounds(l18[i].getX()-2, l18[i].getY()+2 , width, height);
                if(l18[i].getY()>=screenHeight){l18[i].setBounds(screenWidth, (i*40)-30, width, height);}
            }    
            
            try{
                Thread.sleep(0,1);
            }catch(Exception ex){ex.printStackTrace();}
                 
            
        }

    }
   
    
}
