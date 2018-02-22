package report;

import com.lowagie.text.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jay Kumar
 */
public class PrintBill implements Printable{

    double paidAmount;
    double totalAmount;
    String billNo;
    String date;
    String accountName;
    DefaultTableModel tableModel;
    
    public PrintBill(String account, String bill,String date, double paid, double total, DefaultTableModel model){
        accountName = account;
        billNo = bill;
        paidAmount = paid;
        totalAmount = total;
        tableModel = model;
        this.date =date;
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex>0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g = (Graphics2D)graphics;
        g.setFont( new java.awt.Font("Arial", Font.BOLD, 20) );
        float w = (float)pageFormat.getImageableWidth()/2f - 50;
        g.drawString("Kartar Kiryana Store Kandyari",w , 100.0f);
        
        g.setFont( new java.awt.Font("Arial", Font.NORMAL, 12) );
        g.drawString("Customer Name: "+accountName,100 , 140);
        g.drawString("Bill # "+billNo,450 , 140);
        g.drawString("Date : "+date,100 , 170);
        
        g.drawLine(45, 190,600, 190);
        g.setFont( new java.awt.Font("Arial", Font.BOLD, 12) );
        g.drawString("Product  ",90 , 205);
        g.drawString("Quantity  ",300 , 205);
        g.drawString("Rate  ",400 , 205);
        g.drawString("Total  ",500 , 205);
        g.drawLine(45, 210,600, 210);
        
        int y = 250;
        g.setFont( new java.awt.Font("Arial", Font.NORMAL, 12) );
        int rows = tableModel.getRowCount();
        for(int i=0;i<rows;i++){
            g.drawString(""+tableModel.getValueAt(i, 2),100 , y);
            g.drawString(""+tableModel.getValueAt(i, 1),300 , y);
            g.drawString(""+tableModel.getValueAt(i, 3),400 , y);
            g.drawString(""+tableModel.getValueAt(i, 4),500 , y);
            y+=5;
            g.drawLine(45, y,600, y);
            y+=20;
        }
        y+=20;
        g.drawString("Paid Amount: "+paidAmount, 90, y);
        y+=30;
        g.drawString("Total Amount: "+totalAmount, 90, y);
        y+=30;
        g.drawLine(45, y, 600, y);
        
        return PAGE_EXISTS;
    }
    
    public void doPrint()throws Exception{
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if(job.printDialog()){
            job.print();
        }
    }
}
