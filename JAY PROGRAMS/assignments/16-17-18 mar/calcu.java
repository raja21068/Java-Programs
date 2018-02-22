import java.awt.*;
import java.awt.event.*;
class Caltest implements ActionListener{

Frame f1=new Frame("calculator");
Button b1=new Button("Result");
Button b2=new Button("+");
Button b3=new Button("-");
Button b4=new Button("x");
Button b5=new Button("/");
Button b6=new Button("%");
TextField text1=new TextField();
TextField text2=new TextField();
TextField text3=new TextField();
Label l1=new Label("Enter 1st Value:");
Label l2=new Label("Enter 2nd value:");

Caltest(){
f1.setLayout(null);
f1.setBackground(Color.red);
b1.setBackground(Color.yellow);
b2.setBackground(Color.pink);
b3.setBackground(Color.pink);
b4.setBackground(Color.pink);
b5.setBackground(Color.pink);
b6.setBackground(Color.pink);
Font font=new Font("arial",Font.BOLD,30);
l1.setFont(font);
l2.setFont(font);
b1.setFont(font);
b2.setFont(font);
b3.setFont(font);
b4.setFont(font);
b5.setFont(font);
b6.setFont(font);

f1.setBounds(0,0,500,500);
l1.setBounds(100,70,225,30);
text1.setBounds(100,100,225,30);
l2.setBounds(100,140,225,30);
text2.setBounds(100,170,225,30);
b2.setBounds(100,210,50,25);
b3.setBounds(155,210,50,25);
b4.setBounds(210,210,50,25);
b5.setBounds(265,210,50,25);
b6.setBounds(320,210,50,25);
b1.setBounds(100,250,100,25);
text3.setBounds(100,300,225,30);


f1.add(b1);
f1.add(text1);
f1.add(text2);
f1.add(text3);
f1.add(l1);
f1.add(l2);
f1.add(b2);
f1.add(b3);
f1.add(b4);
f1.add(b5);
f1.add(b6);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
f1.show();
f1.setVisible(true);
}
public void actionPerformed(ActionEvent e){

Object ob=e.getSource();
int a=Integer.parseInt(text1.getText());
int b=Integer.parseInt(text2.getText());

if(ob==b2) text3.setText(""+(a+b));
if(ob==b3) text3.setText(""+(a-b));
if(ob==b4) text3.setText(""+(a*b));
if(ob==b5) text3.setText(""+a/b);
if(ob==b6) text3.setText(""+a%b);
}
public static void main(String arg[]){
Caltest obj=new Caltest();
}
}