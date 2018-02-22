import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class TestAction implements ActionListener{

JFrame win= new JFrame();
JButton red=new JButton("RED");
JButton green= new JButton("GREEN");
JButton yellow=new JButton("YELLOW");

TestAction(){
//win.setLayout();
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
