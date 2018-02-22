import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class MainMIDlet extends MIDlet{
	
	MyCanvas myCanvas;
	Menu menu;
	Thread starsMoving;
	
	public MainMIDlet(){
		myCanvas = new MyCanvas();
		menu = new Menu(this);
	}
	
	public void startApp(){
		Display.getDisplay(this).setCurrent(menu);
		
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){
		notifyDestroyed();
	}

	
	public void newGame(){
		Display.getDisplay(this).setCurrent(myCanvas);
			
		starsMoving = new Thread(){
			public void run(){
				System.out.println("myCanvas.screenHeight: "+myCanvas.screenHeight);
				try{
					while(true){
						if( myCanvas.redJetY >= myCanvas.screenHeight  ){ myCanvas.redJetY = 0;  }
						else { myCanvas.redJetY+=3; } 
						for(int i=0;i<myCanvas.starY.length;i++){
						
							if(myCanvas.starY[i] >= myCanvas.screenHeight){
								myCanvas.starY[i]=0;
							}
							myCanvas.starY[i]+=2;
						}
						myCanvas.repaint();
						sleep(50);
					}
				}catch(Exception ex){ex.printStackTrace();}
			}
		};
		starsMoving.start();
	}
}

