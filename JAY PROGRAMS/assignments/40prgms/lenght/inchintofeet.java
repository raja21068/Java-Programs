/*This program is to convert inches into feet*/

import javax.swing.*;
 class inchintofeet{
 public static void main(String arg[]){
 String in=JOptionPane.showInputDialog("Enter inches");
 int inch=Integer.parseInt(in);
 int feet=inch/12;
 JOptionPane.showMessageDialog(null,"feet wiil be:"+feet);
  }

 }

