/*this program converts yards into meter..*/

import javax.swing.*;
class yd_into_mt{
public static void main(String arg[]){
String y=JOptionPane.showInputDialog("Enter Yard: ");
int yd=Integer.parseInt(y);
JOptionPane.showMessageDialog(null,"Yard will be"+(yd/1.0936));
 }
}
