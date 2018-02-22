package utility;


import bean.Year;
import database.DatabaseManager;
import java.awt.event.ItemEvent;
import javax.swing.*;
import org.jfree.chart.ChartFrame;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.experimental.chart.plot.CombinedCategoryPlot;

public class MonthlyChart {
    ChartFrame frame ;
    DefaultCategoryDataset set;
    JComboBox yearComboBox;
    JFreeChart chart ;
    public MonthlyChart(){
        set = new DefaultCategoryDataset();
        yearComboBox = new JComboBox();
        setChart();
        setCombo();
    }
    private void setCombo(){
        yearComboBox.setSize(100, 30);
        yearComboBox.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                yearComboBoxItemStateChanged(e);
            }
        } );
        frame.add(yearComboBox);
    }
    public void setVisible(boolean b){
        getYears();
        frame.setVisible(true);
    }
    private void getYears(){
        yearComboBox.removeAllItems();
        try{
            java.util.List list = DatabaseManager.getData(Year.class.getName()," YEAR DESC" );
            for(int i=0; i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
    private void setChart(){
//        JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Years", "Value", set, PlotOrientation.VERTICAL, true, true, true);
//      CategoryPlot p = (CategoryPlot)chart.getPlot();

        BarRenderer renderer2 = new BarRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        NumberAxis rangeAxis2 = new NumberAxis("Value");
        rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        CategoryPlot subplot1 = new CategoryPlot(set, null, rangeAxis2,renderer2);
        subplot1.setDomainGridlinesVisible(true);
        CategoryAxis domainAxis = new CategoryAxis("Category");
        CombinedCategoryPlot plot = new CombinedCategoryPlot(domainAxis, new NumberAxis("Range"));
        plot.add(subplot1, 2);
        JFreeChart chart = new JFreeChart(plot);
        
        frame = new ChartFrame("Monthwise chart of years " , chart);
        frame.setSize(500,550);
    }
    private void setDataset(DefaultCategoryDataset dataset){
        
        try{/*
            YearBean bean = (YearBean)yearComboBox.getSelectedItem();
            ArrayList sales = DatabaseManager.getYearlySalePurchase(bean.getYearId());
            int jan=0;
            int janP=0;
            int feb = 0 ;
            int febP = 0 ;
            int march=0 ;
            int marchP=0 ;
            int april=0;
            int aprilP=0;
            int may =0;
            int mayP =0;
            int june=0;
            int juneP=0;
            int july=0;
            int julyP=0;
            int aug=0;
            int augP=0;
            int sept =0 ;
            int septP =0 ;
            int oct=0;
            int octP=0;
            int nov= 0;
            int novP= 0;
            int dec=0;
            int decP=0;
            for(int i=0;i<sales.size();i++){
                SalePurchaseBean salePurchase = (SalePurchaseBean)sales.get(i);
                if(salePurchase.getType()==Constant.SALE){
                    String month = (DateFormatter.dateToStringMDY(salePurchase.getDay()).split("-"))[0];
                    int m=Integer.parseInt(month);
                    if(m==1){jan+=salePurchase.getTotalAmount();}
                    else if(m==2){feb+=salePurchase.getTotalAmount();}
                    else if(m==3){march+=salePurchase.getTotalAmount();}
                    else if(m==4){april+=salePurchase.getTotalAmount();}
                    else if(m==5){may+=salePurchase.getTotalAmount();}
                    else if(m==6){june+=salePurchase.getTotalAmount();}
                    else if(m==7){july+=salePurchase.getTotalAmount();}
                    else if(m==8){aug+=salePurchase.getTotalAmount();}
                    else if(m==9){sept+=salePurchase.getTotalAmount();}
                    else if(m==10){oct+=salePurchase.getTotalAmount();}
                    else if(m==11){nov+=salePurchase.getTotalAmount();}
                    else if(m==12){dec+=salePurchase.getTotalAmount();}
                }
                if(salePurchase.getType()==Constant.PURCHASE){
                    String month = (DateFormatter.dateToStringMDY(salePurchase.getDay()).split("-"))[0];
                    int m=Integer.parseInt(month);
                    if(m==1){janP+=salePurchase.getTotalAmount();}
                    else if(m==2){febP+=salePurchase.getTotalAmount();}
                    else if(m==3){marchP+=salePurchase.getTotalAmount();}
                    else if(m==4){aprilP+=salePurchase.getTotalAmount();}
                    else if(m==5){mayP+=salePurchase.getTotalAmount();}
                    else if(m==6){juneP+=salePurchase.getTotalAmount();}
                    else if(m==7){julyP+=salePurchase.getTotalAmount();}
                    else if(m==8){augP+=salePurchase.getTotalAmount();}
                    else if(m==9){septP+=salePurchase.getTotalAmount();}
                    else if(m==10){octP+=salePurchase.getTotalAmount();}
                    else if(m==11){novP+=salePurchase.getTotalAmount();}
                    else if(m==12){decP+=salePurchase.getTotalAmount();}
                }
            dataset.addValue(new Double(jan), "Sale", "Jan");    
            dataset.addValue(new Double(feb), "Sale", "Feb");    
            dataset.addValue(new Double(march), "Sale","Mar");    
            dataset.addValue(new Double(april), "Sale", "Apr");    
            dataset.addValue(new Double(may), "Sale", "May");    
            dataset.addValue(new Double(june), "Sale", "June");    
            dataset.addValue(new Double(july), "Sale", "July");    
            dataset.addValue(new Double(aug), "Sale", "Aug");    
            dataset.addValue(new Double(sept), "Sale", "Sep");    
            dataset.addValue(new Double(oct), "Sale", "Oct");    
            dataset.addValue(new Double(nov), "Sale", "Nov");    
            dataset.addValue(new Double(dec), "Sale", "Dec");    
          
            dataset.addValue(new Double(janP), "Purchase", "Jan");    
            dataset.addValue(new Double(febP), "Purchase", "Feb");    
            dataset.addValue(new Double(marchP), "Purchase","Mar");    
            dataset.addValue(new Double(aprilP), "Purchase", "Apr");    
            dataset.addValue(new Double(mayP), "Purchase", "May");    
            dataset.addValue(new Double(juneP), "Purchase", "June");    
            dataset.addValue(new Double(julyP), "Purchase", "July");    
            dataset.addValue(new Double(augP), "Purchase", "Aug");    
            dataset.addValue(new Double(septP), "Purchase", "Sep");    
            dataset.addValue(new Double(octP), "Purchase", "Oct");    
            dataset.addValue(new Double(novP), "Purchase", "Nov");    
            dataset.addValue(new Double(decP), "Purchase", "Dec");
            
            frame.repaint();
            
            }*/
        }catch(Exception ex){ex.printStackTrace();}
    }
private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent e){
            setDataset(set);
}
    
}
