import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;

class PicSplitDemo {

	public static void main(String[] args)throws IOException {

		
		File f=new File("index.jpeg");
		FileInputStream fs=new FileInputStream(f);
		BufferedImage bi=ImageIO.read(f);
		int col=4,rows=4;
		int chunks=col*rows;
		int chunkwidth=bi.getWidth()/col;
		int chunkheight=bi.getWidth()/rows;
		int count =0;
		BufferedImage barray[]=new BufferedImage[chunks];
		   for(int x=0;x<rows;x++){
			   for(int y=0;y<col;y++){
				   barray[count]=new BufferedImage(chunkwidth,chunkheight,bi.getType());
				   Graphics2D gr=barray[count++].createGraphics();
				   gr.drawImage(bi,0, 0,chunkwidth,chunkheight,chunkwidth*y, chunkheight*x, chunkwidth*y+chunkwidth, chunkheight*x+chunkheight, null);
				   gr.dispose();
			   }
		   }
	System.out.println("Spliting Done....!");	
	for(int i=0;i<barray.length;i++){
		ImageIO.write(barray[i], "jpg", new File("image"+i+".jpg"));
	}
	System.out.println("Mini images Created");
	}
	
	}