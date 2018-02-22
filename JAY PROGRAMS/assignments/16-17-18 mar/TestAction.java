import java.awt.*;
import java.awt.event.*;
class TestAction implements ActionListener{

Frame win= new Frame();
Button red=new Button("RED");
Button green= new Button("GREEN");
Button yellow=new Button("YELLOW");

TestAction(){
win.setLayout(null);
red.setBounds(100,100,100,25);
green.setBounds(100,130,100,25);
yellow.setBounds(100,160,100,25);
win.add(red);
win.add(green);
win.add(yellow);
red.addActionListener(this);
green.addActionListener(this);
yellow.addActionListener(this);
win.setBounds(0,0,500,500);
win.show();
}
public void actionPerformed(ActionEvent e){
Object ob=e.getSource();
if(ob==red) win.setBackground(Color.red);
if(ob==green) win.setBackground(Color.green);
if(ob==yellow) win.setBackground(Color.yellow);
}
public static void main(String args[]){
TestAction obj=new TestAction();
}
}
