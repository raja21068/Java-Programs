/*this program will convert farenheit into kelvin.. */

import javax.swing.*;

class f_into_k{
public static void main(String arg[]){
String c=JOptionPane.showInputDialog("Enter ferenheit:");
int fer=Integer.parseInt(c);
int cen=((fer-32)*100)/180;
JOptionPane.showMessageDialog(null,"kelvin will be:"+(cen+274.15));
 }
}

