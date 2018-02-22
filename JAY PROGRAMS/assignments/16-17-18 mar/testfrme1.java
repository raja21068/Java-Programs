import java.awt.*;
class testfrme1{
public static void main(String [] args){

Frame f1=new Frame("this is frame");

Button b1=new Button("button");
TextField t1=new TextField();
Label l1=new Label("LABEL");
b1.setBounds(100,100,100,25);
t1.setBounds(100,130,120,25);
l1.setBounds(100,160,100,25);
f1.setBounds(0,0,500,500);
f1.setLayout(null);
f1.add(b1);
f1.add(l1);
f1.add(t1);
f1.setVisible(true);
}
}