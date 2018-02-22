/*This program will convert kilometer into miles..*/

import javax.swing.*;
class km_into_m{
public static void main(String arg[]){
String k=JOptionPane.showInputDialog("Enter kilometer:");
float km=Integer.parseInt(k);
JOptionPane.showMessageDialog(null,"kilometer will be:"+(km/1.609));

 }
}
