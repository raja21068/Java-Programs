/*This program will convert year into minutes..*/
 import javax.swing.*;
 class y_into_min{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("enter year");
 int year=Integer.parseInt(y);
 int min=year*256*24*60;
 JOptionPane.showMessageDialog(null,"minutes will be:"+min);
  }
 }
