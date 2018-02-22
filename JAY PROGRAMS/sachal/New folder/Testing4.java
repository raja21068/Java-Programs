 import javax.swing.*;


class Sachal{

   public static void main(String arg[]){


      String s=JOptionPane.showInputDialog("Enter Feet? ");

      int feet=Integer.parseInt(s);
      int inch=feet*12;

      JOptionPane.showMessageDialog(null,"Inches will be: "+inch);

   }
}

