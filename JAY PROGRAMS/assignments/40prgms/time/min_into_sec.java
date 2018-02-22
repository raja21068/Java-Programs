import javax.swing.*;

class min_into_sec{
public static void main(String arg[]){
String m=JOptionPane.showInputDialog("Enter minutes:");
int min=Integer.parseInt(m);
int sec=min*60;
JOptionPane.showMessageDialog(null,"seconds will be: "+sec);
 }
}
