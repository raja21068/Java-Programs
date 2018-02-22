/*This program gives area, perimeter and cicumference of circle..*/

import javax.swing.*;
class circle{
public static void main(String arg[]){
String l=JOptionPane.showInputDialog("Enter length of the circle:");
String b=JOptionPane.showInputDialog("Enter breadth of the circle:");
String r=JOptionPane.showInputDialog("Enter radius of the circle");
float len=Integer.parseInt(l);
float bre=Integer.parseInt(b);
float rad=Integer.parseInt(r);
float area=len*bre;
float peri=len*4;
JOptionPane.showMessageDialog(null,"area of circle is:"+area+"\nperimeter of circle is:"+peri+"\ncircumference of circle is:"+(rad*3.14*2));

 }
}
