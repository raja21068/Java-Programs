class Render {

	public final int width;
	public final int height;
	public final int pixels[];

	Render(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}
	
	public void draw(Render colouredPixels, int xOffset, int yOffset){
		
		/*int k=0;
		for(int y=0 ; y<colouredPixels.height ; y++){
			//int yPixel = y + yOffset;
			
			for(int x=0 ; x<colouredPixels.width ; x++){
				//int xPixel = x + xOffset;
				
				//pixels[xPixel + yPixel * width] = colouredPixels.pixels[k++];
				pixels[xOffset + yOffset] = colouredPixels.pixels[k++];
			}
			
		}
		*/
		
		int k=0;
		for(int x=0 ; x<colouredPixels.width ; x++){
			for(int y=0 ; y<colouredPixels.height ; y++){
				if(x+xOffset>0 && x+xOffset<width && y+yOffset>0 && y+yOffset<height){
					int colour = colouredPixels.pixels[k++];
					if(colour > 0)
						pixels[ x+xOffset + (y+yOffset)*width] = colour;
					//pixels[ x+xOffset + (y+yOffset)*width] = colouredPixels.pixels[k++];
				}
			}
		}
		
		
	}
}
