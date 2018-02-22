 /*this program convert weaks into years..*/
 import javax.swing.*;
 class weakintoyear{
 public static void main(String arg[]){
  String w=JOptionPane.showInputDialog("enter weak:");
  int weak=Integer.parseInt(w);
  int year=weak/52;
  JOptionPane.showMessageDialog(null,"years will be:"+year);
  }
 }
