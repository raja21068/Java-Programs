import javax.swing.*;

class discount{
public static void main(String arg[]){
String o=JOptionPane.showInputDialog("Enter old price: ");
String n=JOptionPane.showInputDialog("Enter price after discount: ");
float op=Integer.parseInt(o);
float np=Integer.parseInt(n);
float dis=100-((np/op)*100);
JOptionPane.showMessageDialog(null,"your have: "+dis+"% discount");

 }
}
