import javax.swing.*;
import java.awt.*;
class list{
public static void main(String arg[]){
Frame win=new Frame();
String[] colornames={"RED","GREEN","BLUE","ORANGE"};



JList colorlist=new JList(colornames);
win.setLayout(new FlowLayout());

win.setBounds(0,0,500,500);
win.setBackground(Color.red);
win.add(colorlist);
win.show();
}
}