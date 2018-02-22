/*this program converts meter into yards..*/

import javax.swing.*;
class mt_into_yd{
public static void main(String arg[]){
String m=JOptionPane.showInputDialog("Enter meter: ");
int metr=Integer.parseInt(m);
JOptionPane.showMessageDialog(null,"Yard will be"+(metr*1.0936));
 }
}
