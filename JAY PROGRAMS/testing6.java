/* this program takes input in feet and gives in inches*/

 import javax.swing.*;
 class testing6{
 public static void main(String arg[]){
 String ft=JOptionPane.showInputDialog("Enter feets:");
 int feet=Integer.parseInt(ft);
 int inch=feet*12; /*this is main formula*/
 JOptionPane.showMessageDialog(null,"Inches will:"+inch);


  }
 }
