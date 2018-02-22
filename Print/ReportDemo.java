
import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.sql.*;

public class ReportDemo implements Printable{
    
    public static void main(String arg[])throws SQLException, PrinterException{
        PageFormat pageFormat = getPageFormat();
        
        Book book = new Book();

        for(int i=1; i<=5; i++){
              ReportDemo report = new ReportDemo();
              book.append(report, pageFormat);
        }        
        
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPageable(book);

        if (printJob.printDialog()) {
            printJob.print();
        }
    }

    private static PageFormat getPageFormat() {
        PageFormat pageFormat = new PageFormat();
        Paper paper=new Paper();

        double pageHeight = 841.824;
        double pageWidth = 595.224;

        paper.setSize(pageWidth, pageHeight);
        paper.setImageableArea(0.0, 0.0, pageWidth, pageHeight);
        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        return pageFormat;
    } //end getPageFormate()
    
    //private class Report implements Printable{
        private boolean access;

        @Override
        public int print(Graphics g, PageFormat pageFormat, int page) {
            if(!access){
                access = true;
                return ReportDemo.PAGE_EXISTS;
            }

            Graphics2D g2d = (Graphics2D)g;

            g2d.drawOval(30,30,50,50);
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.setPaint(Color.black);
            
            Font font;
            
            String str = "Baba Foundation Public High School Hyderabad";
            font = new Font("Arial", Font.BOLD, 20);

            g2d.drawString(str, 100,  100);

            return ReportDemo.PAGE_EXISTS;
        }//end method
        
    //}//end class
}