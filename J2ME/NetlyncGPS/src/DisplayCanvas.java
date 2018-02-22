import javax.microedition.lcdui.*;

public class DisplayCanvas extends Canvas{

	protected void paint(Graphics g){
		g.setColor(255,255,255);
		g.fillRect(0,0,getWidth(),getHeight()-10);
		
		g.setColor(255,0,0);
		g.fillRect(2,2,5,getHeight());//leftBorder
		g.fillRect(2,2,getWidth()-5,5);//up border
		g.fillRect(getWidth()-12,2,5,getHeight());//right border
		g.fillRect(2,getHeight()/3,getWidth()-80,5);
		g.fillRect(2,getHeight()/2,getWidth()-80,5);
		g.fillRect(2,(getHeight()/4)+getHeight()/2,getWidth()/3,5);
		g.fillRect(getWidth()/3,(getHeight()/4)+getHeight()/2,5,(getHeight()/5));
		g.fillRect(2,(int)(getHeight()/4)+(int)(getHeight()/1.7),getWidth()/3,5);
		g.fillRect(2,getHeight()-10,getWidth()-80,5);//bottom border
		
		g.setColor(0);
		g.drawString("classroom",-20+getWidth()/2,getHeight()/5,Graphics.TOP|Graphics.LEFT);
		g.drawString("lab",-20+getWidth()/2,(int)(getHeight()/2.5),Graphics.TOP|Graphics.LEFT);
		g.drawString("reception",30,(int)(getHeight()/1.8),Graphics.TOP|Graphics.LEFT);
		g.drawString("store\nroom",30,(int)(getHeight()/1.3),Graphics.TOP|Graphics.LEFT);
		g.drawString("bathrrom",30,(int)(getHeight()/1.1),Graphics.TOP|Graphics.LEFT);
		try{
			g.drawImage(Image.createImage("/Map-Marker-Marker-Inside-Chartreuse-icon.png"),30,40,Graphics.TOP|Graphics.LEFT);
		}catch(Exception ex){ex.printStackTrace();}
	}

}