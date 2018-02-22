/*This program convert kilo into pounds..*/

import javax.swing.*;
class k_into_p{
public static void main(String arg[]){
String k=JOptionPane.showInputDialog("Enter kilo:");
int kilo=Integer.parseInt(k);
JOptionPane.showMessageDialog(null,"pounds will be:"+(kilo*2.2045));
 }
}
