/*this program convert days into years...*/

import javax.swing.*;
 class d_into_y{
 public static void main(String arg[]){
 String d=JOptionPane.showInputDialog("Enter days:");
 int days=Integer.parseInt(d);
 int year=days/256;
 JOptionPane.showMessageDialog(null,"years will be:"+year);
  }
 }
