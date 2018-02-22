/*This program will convert inch into centimeter..*/

import javax.swing.*;
class i_into_cm{
public static void main(String arg[]){
String i=JOptionPane.showInputDialog("Enter Inches:");
float inch=Integer.parseInt(i);
JOptionPane.showMessageDialog(null,"Centimeter will be:"+(inch*2.54));

 }
}
