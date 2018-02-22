
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

public class bouncingBalls extends MIDlet
{
	
	private Display display;
	static MyCanvas canvas;
	
	public void startApp()
	{
	
		
    
		display=Display.getDisplay(this);
		canvas=new MyCanvas(this);
		display.setCurrent(canvas);
		
		
	}
	public void pauseApp()
	{
		
	}
	public void destroyApp(boolean unconditional)
	{
		
	}
	public void exitMidlet()
	{
		destroyApp(true);
		notifyDestroyed();
	}
	
	      
    }
	
	


class MyCanvas extends Canvas
{
	
	bouncingBalls bballs;
//	int ballX = 20;
//	int ballY = 20;
	int WIDTH = 240;
	int HEIGHT = 320;
	
//	boolean xon;//true will be for +ve 
//	boolean yon;
	int numBalls = 1;
	
	Timer time;
	TestTimerTask task;
	
	int screen = 0;
	private int INPUT = 0,
		 		BOUNCING = 1;
	
	private String str = "1";
	ball bb[] = new ball[1000];
	
	Random rand;
	
	MyCanvas(bouncingBalls bballs)
	{
		setFullScreenMode(true);
		this.bballs=bballs;
		task = new TestTimerTask();
		time = new Timer();
		time.schedule(task,50,50);
		screen = INPUT;
		rand = new Random();
		
	}
	
	
	public void paint(Graphics g)
	{
		if(screen == INPUT)
		{			
				g.setColor(0,0,0);
				g.fillRect(0,0,WIDTH,HEIGHT);
				
				g.setColor(255,255,255);
				g.setFont(Font.getFont(Font.FACE_PROPORTIONAL,Font.STYLE_BOLD, Font.SIZE_SMALL));
				g.drawString("Please input the",WIDTH/2,HEIGHT/3,g.TOP|g.HCENTER);
				g.drawString("number of balls",WIDTH/2,HEIGHT/3 + 15,g.TOP|g.HCENTER);
				
				g.drawRect(WIDTH/2 - 100,HEIGHT/2 - 10,200,20);
				
				g.drawString(""+str,WIDTH/2,HEIGHT/2 - 5,g.TOP|g.HCENTER);
				
				g.drawString("Max. 20",WIDTH/2,HEIGHT/2 + 20,g.TOP|g.HCENTER);
				
				g.drawString("OK",WIDTH/2,HEIGHT,g.BOTTOM|g.HCENTER);
				g.drawString("CLEAR",0,HEIGHT,g.LEFT|g.BOTTOM);
				//g.drawString("EXIT",WIDTH,HEIGHT,g.RIGHT|g.BOTTOM);
				
				
		}	
		else if(screen == BOUNCING)
		{
				g.setColor(0,0,0);
				g.fillRect(0,0,WIDTH,HEIGHT);
			
//				g.setColor(255,255,255);
//				g.drawArc(ballX,ballY,10,10,0,360);
				
				for(int i = 0;i < numBalls;i++)
				{
					if(bb[i].ballX <= 5)
					{
						bb[i].xon = true;
					}
					
					if(bb[i].ballX > WIDTH - 5)
					{
						bb[i].xon = false;
					}
					if(bb[i].ballY <= 5)
					{
						bb[i].yon = true;
					}
					if(bb[i].ballY >= HEIGHT - 5)
					{
						bb[i].yon = false;
					}
					if(bb[i].xon)
					{
						bb[i].ballX += 1;
					}
					else if(!bb[i].xon)
					{
						bb[i].ballX -= 1;
					}
					if(bb[i].yon)
					{
						bb[i].ballY += 1;
					}
					else if(!bb[i].yon)
					{
						bb[i].ballY -= 1;
					}
					bb[i].paintScreen(g);
				}
				g.setColor(255,255,255);
				//g.drawString("Exit",WIDTH,HEIGHT,g.BOTTOM|g.RIGHT);
				/*
					if(ballX <= 5)
					{
						xon = true;
					}
					
					if(ballX > WIDTH - 5)
					{
						xon = false;
					}
					if(ballY <= 5)
					{
						yon = true;
					}
					if(ballY >= HEIGHT - 5)
					{
						yon = false;
					}
					if(xon)
					{
						ballX += 1;
					}
					else if(!xon)
					{
						ballX -= 1;
					}
					if(yon)
					{
						ballY += 1;
					}
					else if(!yon)
					{
						ballY -= 1;
					}
					*/
				
		}	
		
	}
		
	protected void keyPressed(int key)
	{
		int k = getGameAction(key);
		System.out.println("Key Value"+k);
		switch(getGameAction(key))
		{
			
			case Canvas.FIRE:
			
				System.out.println("Pressed OK on Input");
				if(screen == INPUT)
				{
					screen = BOUNCING;
					
					numBalls = numBalls + (Integer.parseInt(str) - 1);
					System.out.println("Creating bb object");
					
					for(int i = 0;i < numBalls;i++)
					{
						bb[i] = new ball(this);
						bb[i].ballX = Math.abs((rand.nextInt())%200);
						bb[i].ballY = Math.abs((rand.nextInt())%200);
						int x = rand.nextInt();
						if(x%2 == 0)
							bb[i].xon = false;
						else if(x%2 == 1)
							bb[i].xon = true;
							
						x = rand.nextInt();
						if(x%2 == 0)
							bb[i].yon = false;
						else if(x%2 == 1)
							bb[i].yon = true;
							
						bb[i].speed = Math.abs(rand.nextInt()%10);		
					}
				System.out.println("End of for after creating objects");
				}
			
			break;
			
			case 53:
				if(screen == INPUT)
				{
					System.out.println("Entered 5");
				//	str.append("5");
					
				}
				break;
				
			case 49:
				if(screen == INPUT)
				{
				//	str.append("4");
					
				}
				break;
			case -6:
					

				if(screen == INPUT)
				{
					str = "";
				}
			break;			
			case -7:
				System.out.println("Pressed CLEAR");
				if(screen == INPUT)
				{
					bballs.exitMidlet();
				}
				else if(screen == BOUNCING)
				{
					bballs.exitMidlet();
				}
			break;
			
			 
		}
	}
	
	
	private class TestTimerTask extends TimerTask 
	{
		public void run()
		{
			repaint();
		}
	}
	
}


 class ball
{
	
	MyCanvas can;
	int ballX;
	int ballY;
	
	boolean xon;//true will be for +ve 
	boolean yon;
	
	int speed;
	
	ball(MyCanvas can)
	{
		this.can = can;	
	}
	
	
	public void paintScreen(Graphics g)
	{
		g.setColor(255,255,255);
		g.drawArc(ballX,ballY,10,10,0,360);
					
		
	}
}

