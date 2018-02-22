package report;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JTable;


/**
 *
 * @author Jay Kumar
 */
public class PrintJtable  implements Printable{
    JTable tableView;
    
    public PrintJtable(JTable jtable){
        tableView = jtable;
    }
    
    public int print(Graphics g, PageFormat pageFormat,int pageIndex) throws PrinterException {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        int fontHeight=g2.getFontMetrics().getHeight();
        int fontDesent=g2.getFontMetrics().getDescent();

        //leave room for page number
        double pageHeight = pageFormat.getImageableHeight()-fontHeight;
        double pageWidth = pageFormat.getImageableWidth();
        double tableWidth = (double)
        tableView.getColumnModel().getTotalColumnWidth();

        // height of TEXT BEFORE JTable
        double textHeight = 10f;

        double scale = 1;
        if (tableWidth >= pageWidth) {
            scale = pageWidth / tableWidth;
        }

        double headerHeightOnPage = tableView.getTableHeader().getHeight()*scale;
        double tableWidthOnPage = tableWidth*scale;

        double oneRowHeight = (tableView.getRowHeight()+ tableView.getRowMargin())*scale;
        int numRowsOnAPage  = (int)((pageHeight-headerHeightOnPage)/oneRowHeight);
        double pageHeightForTable = oneRowHeight*numRowsOnAPage;
        int totalNumPages= (int)Math.ceil(((double)tableView.getRowCount())/numRowsOnAPage);
        if(pageIndex>=totalNumPages) {
            return NO_SUCH_PAGE;
        }

        g2.translate(pageFormat.getImageableX() , pageFormat.getImageableY());
        g2.drawString("Page: "+(pageIndex+1),(int)pageWidth/2-35,
        (int)(pageHeight+fontHeight-fontDesent));//bottom center

        //PUT TEXT ON TOP OF THE PAGE BEFORE JTABLE
        g2.drawString("TEXT before JTable", (int)0 , (int)textHeight);

        // MOVE TABLE USING TRANSLATE with added textHeight
        g2.translate(0f, headerHeightOnPage+textHeight);
        g2.translate(0f,-pageIndex*pageHeightForTable);

        //If this piece of the table is smaller than the size available,
        //clip to the appropriate bounds.
        if (pageIndex + 1 == totalNumPages) {
            int lastRowPrinted = numRowsOnAPage * pageIndex;
            int numRowsLeft = tableView.getRowCount() -
            lastRowPrinted;
            g2.setClip(0, (int)(pageHeightForTable * pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(oneRowHeight * numRowsLeft));
        }
        //else clip to the entire area available.
        else{
            g2.setClip(0, (int)(pageHeightForTable*pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(pageHeightForTable));
        }

        g2.scale(scale,scale);
        tableView.paint(g2);
        g2.scale(1/scale,1/scale);
        g2.translate(0f,pageIndex*pageHeightForTable);
        g2.translate(0f, -headerHeightOnPage);
        g2.setClip(0, 0,(int) Math.ceil(tableWidthOnPage), (int)Math.ceil(headerHeightOnPage));
        g2.scale(scale,scale);
        tableView.getTableHeader().paint(g2);//paint header at top

        return Printable.PAGE_EXISTS;
    }
    
    public void doPrint(){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if(job.printDialog()){
            try{
                job.print();
            }catch(Exception ex){
                ex.printStackTrace(System.err);
            }
        }
    }
    
}
