/*this program convert kilo into grams..*/

import javax.swing.*;

 class k_into_gm{
 public static void main(String arg[]){
 String k=JOptionPane.showInputDialog("enter kilo");
 int kilo=Integer.parseInt(k);
 int grams=kilo*1000;
 JOptionPane.showMessageDialog(null,"grams will be:"+grams);

  }

 }
