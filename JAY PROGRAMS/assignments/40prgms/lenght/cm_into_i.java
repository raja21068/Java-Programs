/*This program convert centimeter into inches..*/

import javax.swing.*;
class cm_into_i{
public static void main(String arg[]){
String c=JOptionPane.showInputDialog("Enter centimeter:");
int cm=Integer.parseInt(c);
JOptionPane.showMessageDialog(null,"Inches will be:"+(cm/2.54));
 }
}
