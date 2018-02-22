/*this program convert grams into kilo..*/

import javax.swing.*;

 class gm_into_k{
 public static void main(String arg[]){
 String grm=JOptionPane.showInputDialog("enter grams:");
 int grams=Integer.parseInt(grm);
 int kilo=grams/1000;
 JOptionPane.showMessageDialog(null,"kilo will be:"+kilo);
  }

 }
