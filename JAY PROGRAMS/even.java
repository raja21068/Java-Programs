import javax.swing.*;

class even{
public static void main(String arg[]){

int v=Integer.parseInt(JOptionPane.showInputDialog("Enter any no:"));

if(v==0) { JOptionPane.showMessageDialog(null,"This is not Even or Odd.."); }
else if (v%2==0) { JOptionPane.showMessageDialog(null,"This no is Even "); }

else { JOptionPane.showMessageDialog(null,"This no is Odd.."); } 


}
}