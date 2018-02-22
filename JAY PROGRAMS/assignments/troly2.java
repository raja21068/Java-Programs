import javax.swing.*;

class troly2{
public static void main(String arg[]){

String t=JOptionPane.showInputDialog("Enter Troly load: ");
String d=JOptionPane.showInputDialog("Enter recent cost of Deisel per litre:");

Double troly=Double.parseDouble(t);
Double deisel=Double.parseDouble(d);

Double income=800*troly;
Double driver=150*troly;
Double tax=income/10;
Double dis=(deisel*2)*troly;
Double profit=income-driver-tax-dis;

JOptionPane.showMessageDialog(null,"Troly turns:"+troly+" \nTotal Income:"+income+ "\nDriver: "+driver+ "\ntax 10%:" +tax+"\nDeisel:"+dis+ "\nProfit: "+profit); 
}
}