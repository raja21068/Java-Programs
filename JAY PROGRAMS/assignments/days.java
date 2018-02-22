import javax.swing.*;

class days{
public static void main(String arg[]){

String d=JOptionPane.showInputDialog("Enter Days: ");

int days=Integer.parseInt(d);

int d1=days/365;
int d2=days%365;

int d3=d2/7;
int d4=d2%7;


JOptionPane.showMessageDialog(null,"Years="+d1+"\nWeaks="+d3+"\ndays="+d4); 
 }
}