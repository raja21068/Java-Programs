/*this program convert year into days..*/
import javax.swing.*;

 class age_into_d{
 public static void main(String arg[]){
 String y=JOptionPane.showInputDialog("what is your age?enter year:");
 int year=Integer.parseInt(y);
 int days=year*356;
 JOptionPane.showMessageDialog(null,"days will be:"+days);
  }
 }
