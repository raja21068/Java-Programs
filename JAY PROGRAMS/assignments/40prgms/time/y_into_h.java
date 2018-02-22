/*This program will convert year into hours..*/
 import javax.swing.*;
 class y_into_h{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("enter year");
 int year=Integer.parseInt(y);
 int hours=year*256*24;
 JOptionPane.showMessageDialog(null,"hours will be:"+hours);
  }
 }
