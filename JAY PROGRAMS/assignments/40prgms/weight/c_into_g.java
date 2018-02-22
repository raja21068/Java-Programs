/*this program convert carat into grams..*/

import javax.swing.*;

 class c_into_g{
 public static void main(String arg[]){
 String c=JOptionPane.showInputDialog("enter carat:");
 int carat=Integer.parseInt(c);
 JOptionPane.showMessageDialog(null,"grams will be:"+(carat*0.2));

  }

 }
