import javax.swing.*;

class testimage{

public static void main(String arg[]){
ImageIcon icon=new ImageIcon("abcd.jpg");
JLabel label=new JLabel(icon);
JOptionPane.showMessageDialog(null,label);
}
}
