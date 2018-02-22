/*This program will convert mile into kilometer..*/

import javax.swing.*;
class m_into_km{
public static void main(String arg[]){
String m=JOptionPane.showInputDialog("Enter Miles:");
float ml=Integer.parseInt(m);
JOptionPane.showMessageDialog(null,"kilometer will be:"+(ml*1.609));

 }
}
