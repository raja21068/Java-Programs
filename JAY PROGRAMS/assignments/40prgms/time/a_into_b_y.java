/*This program will convert age into birth year..*/
 import javax.swing.*;
 class a_into_b_y{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("enter your age:");
 int year=Integer.parseInt(y);
 int b_y=2012-year;
 JOptionPane.showMessageDialog(null,"your year of birth is:"+b_y);
  }
 }
