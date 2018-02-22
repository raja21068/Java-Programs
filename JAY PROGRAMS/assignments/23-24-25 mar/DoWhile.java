import javax.swing.*;

class DoWhile{

public static void main(String arg[]){

int code;
do{
    int a=Integer.parseInt(JOptionPane.showInputDialog("Enter 1st Value:"));
    int b=Integer.parseInt(JOptionPane.showInputDialog("Enter 2nd value:"));
code=JOptionPane.showConfirmDialog(null,"Adiition is:"+(a+b)+"\nDo you want to calculate more..?","Confermation....",JOptionPane.YES_NO_OPTION);
}
  while(code==JOptionPane.YES_OPTION);
 }
  }