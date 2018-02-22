/*this program takes 2 value and show their addition,substraction,*/
/*multiplicationa nd division*/

import javax.swing.*;

 class testing5{
 public static void main(String arg[]){
 String v1=JOptionPane.showInputDialog("enter 1st value");
 String v2=JOptionPane.showInputDialog("enter 2nd value");
 int a=Integer.parseInt(v1);
 int b=Integer.parseInt(v2);
 JOptionPane.showMessageDialog(null,"addition is:"+(a+b)+"\nsubstraction is:"+(a-b)+"\nmultiplication is:"+(a*b)+"\ndivision is:"+(a/b));
  }

 }
