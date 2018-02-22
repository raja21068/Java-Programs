/*This program will tell you the percentage of HSC..*/

import javax.swing.*;
class marks{
public static void main(String arg[]){
String m=JOptionPane.showInputDialog("Please enter your marks");
String t=JOptionPane.showInputDialog("Enter total marks");
float marks=Integer.parseInt(m);
float tmarks=Integer.parseInt(t);
float per=marks/tmarks*100;
JOptionPane.showMessageDialog(null,"your percentage is:"+per);
 }
}
