import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.*;

public class Display extends Canvas implements Runnable{
	
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	
	private Thread thread;
	private boolean isRunning = false;
	private Screen screen;
	private BufferedImage img;
	private int pixels[];
	
	Display(){
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	
	
	private void start(){
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		System.out.println("started!!");
	}
	
	private void stop(){
		if(!isRunning)
			return;
		isRunning = false;
		try{
			thread.join();
		}catch(Exception ex){ex.printStackTrace();
			System.exit(1);
		}
	}
	
	public void run(){
		long prevTime = System.nanoTime();
		//System.out.println(prevTime);
		int frames=0;
		
		while(isRunning){
			long newTime = System.nanoTime();
			//System.out.println(newTime);
			if(newTime-prevTime >= 1000000000){
				System.out.println("Fps: "+frames);
				prevTime = newTime;
				frames = 0;
			}
			
			render();
			frames++;
		}
	}
	
	private void tick(){
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.render();
		for(int i=0 ; i<WIDTH*HEIGHT ; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String arg[]){
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setTitle("3D Game Programming");
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}

}
