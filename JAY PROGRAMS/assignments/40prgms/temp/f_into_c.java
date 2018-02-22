/*This program convert ferenheit into centigrade..*/

import javax.swing.*;
 class f_into_c{
 public static void main(String arg[]){
 String f=JOptionPane.showInputDialog("enter  temperature in ferenheit:");
 float fer=Integer.parseInt(f);
 float cen=((fer-32)*100)/180;
 JOptionPane.showMessageDialog(null,"centigrade will be:"+cen);

  }
 }
