/*This program will convert stone into kilogram..*/

import javax.swing.*;

class s_into_kg{
public static void main(String arg[]){
String s=JOptionPane.showInputDialog("Enter stone:");
int st=Integer.parseInt(s);
JOptionPane.showMessageDialog(null,"Kilograms will be: "+(st/0.1574));
 }
}
