import java.awt.*;

class testimage7{
public static void main(String[] args){
Frame win=new Frame("Calculator");
Button b1=new Button("ok");
TextField text1=new TextField();
Label l1=new Label("My Project");
b1.setBounds(100,100,100,25);
text1.setBounds(100,130,100,25);
l1.setBounds(100,160,100,25);
win.setBounds(0,0,500,500);
win.setLayout(null);
win.add(b1);
win.add(l1);
win.add(text1);
win.setVisible(true); 
}
}