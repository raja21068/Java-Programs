import javax.swing.*;
import java.awt.*;
class list2{
public static void main(String arg[]){
Frame win=new Frame();
String[] num={"2","3","4","5","6","7","8"};



JList colorlist=new JList(num);
win.setLayout(new FlowLayout());

win.setBounds(0,0,500,500);
win.setBackground(Color.red);
win.add(colorlist);
win.show();
}
}