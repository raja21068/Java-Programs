import java.util.Random;

class Screen extends Render {

	private Render colouredPixels;
	private int num=0;
	
	Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		colouredPixels = new Render(100, 100);
		for (int i = 0; i < 100*100; i++) {
			colouredPixels.pixels[i] = random.nextInt()*(random.nextInt(9)/6);
		}
	}

	public void render() {
		
		for(int k=0 ; k<height*width ; k++){
			pixels[k] = 0;
		}
		
		for(int k=0 ; k<80 ; k++){
			int animate = (int)(Math.sin(((num++) + k*30) % 3000.0 / 3000 * Math.PI * 2) * 150);
			int animate2 = (int)(Math.cos(((num++) + k*30) % 30000.0 / 3000 * Math.PI  * 2) * 150);
			
			draw(colouredPixels, (width - 50) / 2 - animate, (height - 50) / 2 + animate2);
		}
	}
}
