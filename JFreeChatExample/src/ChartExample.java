import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;


public class ChartExample {
    public ChartExample(){
     DefaultCategoryDataset set = new DefaultCategoryDataset();
     set.addValue(new Double(68), "one", "A1");
     set.addValue(new Double(44), "Two", "B");
     set.addValue(new Double(54), "Three", "C");
     set.addValue(new Double(82), "Four", "D");
     set.addValue(new Double(68), "Five", "E");
     set.addValue(new Double(44), "Six", "F");
     set.addValue(new Double(54), "Seven", "I");
     set.addValue(new Double(82), "Eight", "J");
     JFreeChart chart = ChartFactory.createBarChart("Bar Chart", null, null, set, PlotOrientation.VERTICAL, true, true, true);
     CategoryPlot p = (CategoryPlot)chart.getPlot();
     ChartFrame frame = new ChartFrame("Bar Chart" , chart);
     frame.setVisible(true);
     frame.setSize(450,550);

    }
    public static void main(String arg[])throws Exception{
     new ChartExample();
//     DefaultPieDataset pieSet = new DefaultPieDataset();   
//     java.util.Vector  v = DatabaseManager.getAllCustomer();
//     CustomerBean bean = (CustomerBean)v.elementAt(0);
//     
//     pieSet.setValue("January", (int)Double.parseDouble(bean.getJan()));
//     pieSet.setValue("Fabruary", (int)Double.parseDouble(bean.getFeb()));
//     pieSet.setValue("March", (int)Double.parseDouble(bean.getMarch()));
//     pieSet.setValue("April", (int)Double.parseDouble(bean.getApril()));
//     pieSet.setValue("May", (int)Double.parseDouble(bean.getMay()));
//     pieSet.setValue("June", (int)Double.parseDouble(bean.getJune()));
//     pieSet.setValue("July", (int)Double.parseDouble(bean.getJuly()));
//     pieSet.setValue("August", (int)Double.parseDouble(bean.getAugust()));
//     pieSet.setValue("September", (int)Double.parseDouble(bean.getSeptember()));
//     pieSet.setValue("October", (int)Double.parseDouble(bean.getOctober()));
//     pieSet.setValue("November", (int)Double.parseDouble(bean.getNovember()));
//     pieSet.setValue("December", (int)Double.parseDouble(bean.getDecember()));
    /*
     pieSet.setValue("Sindh", new Integer(993));
     pieSet.setValue("Punjab", new Integer(365));
     pieSet.setValue("NWFP", new Integer(100));
     pieSet.setValue("Balochistan", new Integer(36));
     pieSet.setValue("Branch 5", new Integer(40));
*/

 //    pieSet.setValue("Feederal", new Integer(767));
   //  pieSet.setValue("four province ", new Integer(139));

     
//     pieSet.setValue("Sindh", new Integer(139));
//     pieSet.setValue("Punjab", new Integer(1122));
//     pieSet.setValue("NWFP", new Integer(101));
//     pieSet.setValue("Balochistan", new Integer(55));
     
     
//     JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieSet, true, true, true);
//     PiePlot p = (PiePlot)chart.getPlot();
//     ChartFrame frame = new ChartFrame("Pie Chart" , chart);
//     frame.setVisible(true);
//     frame.setSize(450,550);
     
//     JFreeChart chart = ChartFactory.createPieChart3D("Pie3D Chart", pieSet, true, true, true);
//     PiePlot3D p = (PiePlot3D)chart.getPlot();
//     ChartFrame frame = new ChartFrame("Pie3D Chart" , chart);
//     frame.setVisible(true);
//     frame.setSize(450,550);
     
//     JFreeChart chart = ChartFactory.createRingChart("Ring Chart", pieSet, true, true, true);
//     PiePlot p = (PiePlot)chart.getPlot();
//     ChartFrame frame = new ChartFrame("Ring Chart" , chart);
//     frame.setVisible(true);
//     frame.setSize(450,550);
     
//     DefaultCategoryDataset set = new DefaultCategoryDataset();
//       set.addValue(new Double(68), "one", "A1");
//     set.addValue(new Double(44), "Two", "B");
//     set.addValue(new Double(54), "Three", "C");
//     set.addValue(new Double(82), "Four", "D");
//     set.addValue(new Double(68), "Five", "E");
//     set.addValue(new Double(44), "Six", "F");
//     set.addValue(new Double(54), "Seven", "I");
//     set.addValue(new Double(82), "Eight", "J");
//
//     JFreeChart chart = ChartFactory.createBarChart("Bar Chart", null, null, set, PlotOrientation.HORIZONTAL, true, true, true);
//     CategoryPlot p = (CategoryPlot)chart.getPlot();
//     ChartFrame frame = new ChartFrame("Bar Chart" , chart);
//     frame.setVisible(true);
//     frame.setSize(450,550);

        
//     DefaultCategoryDataset set = new DefaultCategoryDataset();
//     set.addValue(new Double(68), "one", "A1");
//     set.addValue(new Double(44), "Two", "B");
//     set.addValue(new Double(54), "Three", "C");
//     set.addValue(new Double(82), "Four", "D");
//     set.addValue(new Double(68), "Five", "E");
//     set.addValue(new Double(44), "Six", "F");
//     set.addValue(new Double(54), "Seven", "I");
//     set.addValue(new Double(82), "Eight", "J");
//     JFreeChart chart = ChartFactory.createBarChart("Bar Chart", null, null, set, PlotOrientation.VERTICAL, true, true, true);
//     CategoryPlot p = (CategoryPlot)chart.getPlot();
//     ChartFrame frame = new ChartFrame("Bar Chart" , chart);
//     frame.setVisible(true);
//     frame.setSize(450,550);

//        JFreeChart chart = ChartFactory.createAreaChart("Area Chart", "Discrption", "Discription2", set, PlotOrientation.VERTICAL, true, true, true);
//        CategoryPlot p = (CategoryPlot)chart.getPlot();
//        ChartFrame frame = new ChartFrame("Ring Chart" , chart);
//        frame.setVisible(true);
//        frame.setSize(450,550);
        
       

     ///////////////////////////////////**********************?////////////////////
     DefaultXYDataset dataset = new DefaultXYDataset();
//
     double[][] data = new double[2][2];
     data[0][0]=(1120000);
     data[0][1]=(1200000);
     data[1][0]=1300000;
     data[1][1]=1030232;
             
     dataset.addSeries("key", data);
         
        JFreeChart chart = ChartFactory.createXYLineChart("Char", "X-axis Label", "Y axis Label",dataset , PlotOrientation.HORIZONTAL, true, true, true);
        XYPlot p = (XYPlot)chart.getPlot();
        ChartFrame frame = new ChartFrame("Ring Chart" , chart);
        frame.setVisible(true);
        frame.setSize(450,550);
    
    }
}
