import java.awt.print.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PrintDemo{

    public void print(){
        try{

            Vector v=DatabaseManager.getStudent(batchBean.getBatchId());
		Vector v2 = new Vector();
		for(int i = 0; i < v.size(); i++){
		    v2.addElement(v.elementAt(i));
		    if(v2.size() == 20){
		         book.append(new Report(v2), pageFormat);
	         	 v2 = new Vector();
		    }    
		}

            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setPageable(book);

            if(printJob.printDialog())
                printJob.print();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
        }
    }

    private static PageFormat getPageFormat() {

        PageFormat pageFormat = new PageFormat();

        Paper paper=new Paper();

        double pageHeight = 842.4;
        double pageWidth = 597.6;

        double PIXEL_PER_INCH = 72;

        paper.setSize(pageWidth, pageHeight);

        double LEFT = 1 * PIXEL_PER_INCH;

        double RIGHT = 1 * PIXEL_PER_INCH;
        RIGHT = 8.3 - (LEFT + RIGHT);

        double BOTTOM = 1 * PIXEL_PER_INCH;

        paper.setImageableArea(LEFT-15, 1, paper.getWidth()-RIGHT, paper.getHeight()+BOTTOM+20);

        pageFormat.setPaper(paper);

        pageFormat.setOrientation(PageFormat.PORTRAIT);

        return pageFormat;

    } //end getPageFormate()

class Report implements Printable{

    Report(){
    }

    private boolean access;
    public int print(Graphics g, PageFormat pageFormat, int page) {

        if(!access){
            access=true;
            return this.PAGE_EXISTS;
        }

            Graphics2D g2d = (Graphics2D)g;

            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.setPaint(Color.black);
            
            Font font;
            
            String str = "Baba Foundation Public High School Hyderabad";
            font = new Font("Arial", Font.BOLD, 20);

            g2d.drawString(str, 100,  100);

        return this.PAGE_EXISTS;
    }//end method
}
}