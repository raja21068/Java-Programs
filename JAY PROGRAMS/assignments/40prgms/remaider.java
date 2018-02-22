import javax.swing.*;

class remaider{
public static void main(String arg[]){

String v1=JOptionPane.showInputDialog("Enter 1st value:");
String v2=JOptionPane.showInputDialog("Enter 2nd value:");
int val1=Integer.parseInt(v1);
int val2=Integer.parseInt(v2);
int rem=val1%val2;
JOptionPane.showMessageDialog(null,"remaider of these values is:"+rem);

 }
}
