/*this program will convert centigrade into fahrenheit.. */

import javax.swing.*;

class c_into_f{
public static void main(String arg[]){
String c=JOptionPane.showInputDialog("Enter centigrade:");
int cen=Integer.parseInt(c);
int fah=((cen+32)/100)*180;
JOptionPane.showMessageDialog(null,"Fahrenheit will be:"+fah);
 }
}
