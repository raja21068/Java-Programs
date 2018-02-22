
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class PrintingPage implements Printable{
    
    int x=0;
    int y=0;
    String str="";
//    int xpoints[] = {25,145,25,145,25}; 
    int xpoints[] = {25,145,25,145,0}; 
    int ypoints[] = {25,25,145,145,0}; 
    
    public PrintingPage(String s , int x ,int y){
   
       str=s;
       this.x=x;
       this.y=y;
    }
    public static PageFormat getPageFormat(double width , double height){
        PageFormat pageFormat = new PageFormat();
        Paper paper = new Paper();
        paper.setSize(width, height);
        paper.setImageableArea(0.0, 0.0, width, height);
        
        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        
        return pageFormat;
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D draw = (Graphics2D)graphics;
        
        
        draw.setFont(new Font("Arial",Font.BOLD,20));
        draw.drawString(str, x , y);
        
        draw.drawPolygon(xpoints, ypoints, 5);
        try {
            java.awt.image.BufferedImage image = ImageIO.read(getClass().getResource("car.png"));
            draw.drawImage(image, null, 20, 50);
            
            draw.setColor(new Color(1.0f, 1.0f, 1.0f, 0.6f));
            draw.fillOval(40, 50, 200, 200);
            
            
//            draw.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.6f));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
//        return Printable.PAGE_EXISTS;
        return PrintingPage.PAGE_EXISTS;
    }
    
    public static void main(String arg[]) throws PrinterException{
        Book book = new Book();
        PageFormat format = getPageFormat(500,500);
        
        String str = "Hello dear how are you?";
        PrintingPage page = new PrintingPage(str , 50,100);
        book.append(page, format);
        
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPageable(book);
        
        if(printJob.printDialog())
        {printJob.print();}
    }
    
}
