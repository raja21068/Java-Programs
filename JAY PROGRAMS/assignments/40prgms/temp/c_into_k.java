/*this program will convert centigrade into kelvin.. */

import javax.swing.*;

class c_into_k{
public static void main(String arg[]){
String c=JOptionPane.showInputDialog("Enter centigrade:");
int cen=Integer.parseInt(c);
JOptionPane.showMessageDialog(null,"kelvin will be:"+(cen+274.15));
 }
}
