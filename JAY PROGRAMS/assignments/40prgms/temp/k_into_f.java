/*this program will convert kelvin into farenheit.. */

import javax.swing.*;

class k_into_f{
public static void main(String arg[]){
String k=JOptionPane.showInputDialog("Enter kelvin:");
int kel=Integer.parseInt(k);
int cen=kel-275;
int fer=((cen+32)*180)/100;

JOptionPane.showMessageDialog(null,"farenheit will be:"+fer);
 }
}

