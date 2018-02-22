import java.awt.*;
class calculatr{
public static void main(String [] args){

Frame f1=new Frame("CALCULATOR");

Button b1=new Button("MC");
Button b2=new Button("<--");
Button b3=new Button("7");
Button b4=new Button("4");
Button b5=new Button("1");
Button b6=new Button("0");
Button b7=new Button("MR");
Button b8=new Button("CE");
Button b9=new Button("8");
Button b10=new Button("5");
Button b11=new Button("2");
Button b12=new Button("MS");
Button b13=new Button("C");
Button b14=new Button("9");
Button b15=new Button("6");
Button b16=new Button("3");
Button b17=new Button(".");
Button b18=new Button("M+");
Button b19=new Button("+/-");
Button b20=new Button("/");
Button b21=new Button("*");
Button b22=new Button("-");
Button b23=new Button("+");
Button b24=new Button("M-");
Button b25=new Button("sq");
Button b26=new Button("%");
Button b27=new Button("1/x");
Button b28=new Button("=");

f1.setLayout(null);
TextField text=new TextField();
Button lab=new Button("view     edit     help                             ");

Font font=new Font("arial",Font.BOLD,20);
b2.setFont(font);
b17.setFont(font);
text.setFont(font);

f1.setBounds(0,0,250,350);
lab.setBounds(0,30,242,15);
text.setBounds(20,55,210,55);
b1.setBounds(20,113,40,32);
b2.setBounds(20,147,40,32);
b3.setBounds(20,181,40,32);
b4.setBounds(20,215,40,32);
b5.setBounds(20,249,40,32);
b6.setBounds(20,283,82,32);
b7.setBounds(62,113,40,32);
b8.setBounds(62,147,40,32);
b9.setBounds(62,181,40,32);
b10.setBounds(62,215,40,32);
b11.setBounds(62,249,40,32);
b12.setBounds(104,113,40,32);
b13.setBounds(104,147,40,32);
b14.setBounds(104,181,40,32);
b15.setBounds(104,215,40,32);
b16.setBounds(104,249,40,32);
b17.setBounds(104,283,40,32);
b18.setBounds(146,113,40,32);
b19.setBounds(146,147,40,32);
b20.setBounds(146,181,40,32);
b21.setBounds(146,215,40,32);
b22.setBounds(146,249,40,32);
b23.setBounds(146,283,40,32);
b24.setBounds(188,113,40,32);
b25.setBounds(188,147,40,32);
b26.setBounds(188,181,40,32);
b27.setBounds(188,215,40,32);
b28.setBounds(188,249,40,66);

f1.add(text);
f1.add(lab);
f1.add(b1);
f1.add(b2);
f1.add(b3);
f1.add(b4);
f1.add(b5);
f1.add(b6);
f1.add(b7);
f1.add(b8);
f1.add(b9);
f1.add(b10);
f1.add(b11);
f1.add(b12);
f1.add(b13);
f1.add(b14);
f1.add(b15);
f1.add(b16);
f1.add(b17);
f1.add(b18);
f1.add(b19);
f1.add(b20);
f1.add(b21);
f1.add(b22);
f1.add(b23);
f1.add(b24);
f1.add(b25);
f1.add(b26);
f1.add(b27);
f1.add(b28);
f1.setVisible(true);

}
}