 import javax.swing.*;


class Sachal{

   public static void main(String arg[]){


      String s1=JOptionPane.showInputDialog("month");
      String s2=JOptionPane.showInputDialog("year");

      int a=Integer.parseInt(s1);
      int b=Integer.parseInt(s2);
      int myage=


      JOptionPane.showMessageDialog(null,"Addition is: "+(a+b));
      JOptionPane.showMessageDialog(null,"substraction is: "+(a-b));
      JOptionPane.showMessageDialog(null,"multiplaction is: "+(a*b));
      JOptionPane.showMessageDialog(null,"division is: "+(a/b));

   }
}

