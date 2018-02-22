import javax.swing.*;

class testimage2{

public static void main(String arg[]){
ImageIcon icon=new ImageIcon("abc.jpg");
JLabel label=new JLabel(icon);
JScrollPane scroll=new JScrollPane(label);
JOptionPane.showMessageDialog(null,scroll);
}
}
