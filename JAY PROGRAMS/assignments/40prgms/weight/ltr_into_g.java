/*this program concert convert litre into gallon..*/

import javax.swing.*;
class ltr_into_g{
public static void main(String arg[]){
String l=JOptionPane.showInputDialog("Enter Litre:");
int ltr=Integer.parseInt(l);
JOptionPane.showMessageDialog(null,"Gallon will be "+(ltr*0.264));                                              
 }
}
