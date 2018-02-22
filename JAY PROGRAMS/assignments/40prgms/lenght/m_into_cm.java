/*This program convert meter into centimeter..*/

import javax.swing.*;

class m_into_cm{
public static void main(String arg[]){
String m=JOptionPane.showInputDialog("Enter meter:");
int mtr=Integer.parseInt(m);
int cm=mtr*100;
JOptionPane.showMessageDialog(null,"Centimeter will be:"+cm);
 }
}
