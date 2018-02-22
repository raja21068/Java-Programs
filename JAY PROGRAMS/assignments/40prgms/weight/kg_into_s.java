/*This program will convert kilogram into stone..*/

import javax.swing.*;

class kg_into_s{
public static void main(String arg[]){
String k=JOptionPane.showInputDialog("Enter Kilograms:");
int kg=Integer.parseInt(k);
JOptionPane.showMessageDialog(null,"Stone will be: "+(kg*0.1574));
 }
}
