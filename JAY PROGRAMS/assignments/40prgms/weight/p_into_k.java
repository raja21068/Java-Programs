/*This program convert pounds into kilo..*/

import javax.swing.*;
class p_into_k{
public static void main(String arg[]){
String p=JOptionPane.showInputDialog("Enter pound:");
int pound=Integer.parseInt(p);
JOptionPane.showMessageDialog(null,"kilo will be:"+(pound/2.2045));
 }
}
