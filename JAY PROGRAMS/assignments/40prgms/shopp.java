/*This program tells the profit..*/
import javax.swing.*;
class shopp{
public static void main(String arg[]){

JOptionPane.showMessageDialog(null,"Welcome to a shop software\nThis will tell you what you earn profit");
String c=JOptionPane.showInputDialog("Enter cost:");
String s=JOptionPane.showInputDialog("Enter sold price:");
float cost=Integer.parseInt(c);
float sold=Integer.parseInt(s);
float profit=sold-cost;
float per=profit/cost*100;
if (sold>cost)
{ JOptionPane.showMessageDialog(null,"the profit is:"+profit+" Rupees\npercentage of profit is:"+per+" Rupees");
       }else{ JOptionPane.showMessageDialog(null,"You are in lost of "+(cost-sold)" Rupees"); } 
 }
}
