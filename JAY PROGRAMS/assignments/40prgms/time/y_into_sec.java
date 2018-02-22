/*This program will convert year into seconds..*/
 import javax.swing.*;
 class y_into_sec{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("enter year");
 int year=Integer.parseInt(y);
 int sec=year*256*24*60*60;
 JOptionPane.showMessageDialog(null,"seconds will be:"+sec);
  }
 }
