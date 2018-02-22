/*this program concert convert gallon into litre..*/

import javax.swing.*;
class g_into_ltr{
public static void main(String arg[]){
String g=JOptionPane.showInputDialog("Enter Gallon:");
int gal=Integer.parseInt(g);
JOptionPane.showMessageDialog(null,"Litre will be "+(gal/0.264));                                              
 }
}
