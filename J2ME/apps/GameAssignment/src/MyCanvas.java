import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class MyCanvas extends Canvas{
	int x=65;
	int y;
	int w=30;
	int h=30;
	
	int redJetY = 50;
	
	public int screenWidth;
	public int screenHeight;
	
	public Graphics gr;
	
	Image jet;
	Image redJet;
	
	int starY[]=new int[50];
	int starX[] = new int[50];
	
	boolean isFiringThreadRunning;
	Vector firesY;
	Vector firesX;
	
	Random ran;
	
	Fire fireThread;
	
	boolean colide = false;
	
	public MyCanvas(){
		y = getHeight() - 50;
		screenWidth = getWidth()-20;
		screenHeight = getHeight()-20;
		
		firesX = new Vector();
		firesY = new Vector();
		isFiringThreadRunning = false;
		
		fireThread = new Fire(firesY,firesX,isFiringThreadRunning);
		
		try{
			jet = Image.createImage("/Jet-icon.png");
			redJet = Image.createImage("/red-jet.png");
		}catch(Exception ex){ex.printStackTrace();}
		
		//System.out.println("Keys:");
		//System.out.println(" KEY_NUM0"+KEY_NUM0+" , KEY_NUM1"+KEY_NUM1+", KEY_NUM2+"+KEY_NUM2+", KEY_NUM3"+KEY_NUM3+", KEY_NUM4 "+KEY_NUM4+", KEY_NUM5 "+ KEY_NUM5+", KEY_NUM6 "+KEY_NUM6+", KEY_NUM7 "+KEY_NUM7+", KEY_NUM8 "+KEY_NUM8+", KEY_NUM9 "+KEY_NUM9+", KEY_STAR "+KEY_STAR+" KEY_POUND: "+KEY_POUND+" UP "+UP+", DOWN "+DOWN+", LEFT "+LEFT+", RIGHT "+RIGHT+", FIRE "+FIRE+", GAME_A "+GAME_A+", GAME_B "+GAME_B+", GAME_C, and GAME_D.");
		
		ran = new Random();
		
		for(int i=0;i<starX.length;i++){
			float f1 = ran.nextFloat()*screenWidth;
			float f2 = ran.nextFloat()*screenHeight;
			starX[i] = (int) (f1);
			starY[i] = (int) (f2);
			//System.out.println(f1+" : "+f2);
		}
	
	}
	
	protected void paint(Graphics g){
		gr = g;
		g.setColor(0);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(255,255,255);
		g.drawImage(jet,x,y,0);
		
		for(int i=0;i<starY.length;i++){
			g.fillArc(starX[i],starY[i],2,2,360,360);
		}
		
		g.setColor(255,25,2);
		for(int i=0;i<firesY.size();i++){
			g.fillArc(Integer.parseInt((String)firesX.elementAt(i)),Integer.parseInt((String)firesY.elementAt(i)),5,5,360,360);
			g.fillArc(Integer.parseInt((String)firesX.elementAt(i))+30,Integer.parseInt((String)firesY.elementAt(i)),5,5,360,360);
			
			if(redJet !=null){
				checkDestroy( new Rectangle(Integer.parseInt((String)firesX.elementAt(i)),Integer.parseInt((String)firesY.elementAt(i)),5,5) , new Rectangle(50,redJetY,30,32) );
				checkDestroy( new Rectangle(Integer.parseInt((String)firesX.elementAt(i))+30,Integer.parseInt((String)firesY.elementAt(i)),5,5) , new Rectangle(50,redJetY,30,32) );
				g.drawImage(redJet,50,redJetY,0);
			}
		}
		if(redJet != null){
			g.drawImage(redJet,50,redJetY,0);
		}
		
		if(colide){
			new Thread(){
				public void run(){
					try{ sleep(500); }catch(Exception ex){ ex.printStackTrace(); }
					redJet = null;
				}
			}.start();
		}
		//g.drawRect(x+6,y,34,38);
		//g.drawRect(30,30,30,32);
		
		
		//System.out.println("Paint mothod called...starY :"+starY);
	}
	
	
	protected void keyPressed(int code){
		strokes(code);
	}
	protected void keyRepeated(int code){
		strokes(code);
	}
	
	public void strokes(int code){
		//System.out.println(code);
		if(code == KEY_NUM8  || code == DOWN || code == -2){
			if((y+4)<=(screenHeight-20)){
				y+=4;
			}
		}
		if(code == KEY_NUM2  || code == UP || code == -1){
			if((y-4)>=40){
				y-=4;
			}
		}
		if(code == KEY_NUM4  || code == LEFT || code == -3){
			if( (x-4)>=0 ){
				x-=4;
			}
		}
		if(code == KEY_NUM6  || code == RIGHT  || code == -4){
			if( (x+4)<=screenWidth ){
				x+=4;
			}
		}
		if(code == -5){
			firesY.addElement(""+y);
			firesX.addElement(""+(x+5));
			if(!isFiringThreadRunning){
				fireThread = new Fire(firesY,firesX,isFiringThreadRunning);
				fireThread.start();
			}
		}
		gr.setColor(0);
		repaint();
	}
	
	
	public void checkDestroy( Rectangle r1 , Rectangle r2 ){
		
		if( Rectangle.intersact(r1, r2) ){
			System.out.println("Blast....");
			try{
				redJet = Image.createImage("/fire-ring-icon.png");
				colide = true;
			}catch(Exception ex){
				System.out.println("Exception at 'MyCanvas > checkDestroy()'");
				ex.printStackTrace();
			}
		}
	}
	
}

