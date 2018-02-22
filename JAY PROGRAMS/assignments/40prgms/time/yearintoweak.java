/*This program will convert year into weeks..*/
 import javax.swing.*;
 class yearintoweak{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("enter year");
 int year=Integer.parseInt(y);
 int weeks=year*52;
 JOptionPane.showMessageDialog(null,"weeks will be:"+weeks);
  }
 }
