import java.awt.*;
import java.awt.event.*;
class StarGui implements ActionListener{

Frame frame=new Frame("Star");
Label row=new Label("Enter No of rows");
TextField text1=new TextField();
Label patern=new Label("Enter Pattern");
TextField text2=new TextField();
Button clear=new Button("Clear");
Button about=new Button("About");
TextArea area=new TextArea();

StarGui(){
frame.setBackground(Color.pink);
frame.setLayout(null);
frame.setBounds(0,0,500,400);
row.setBounds(320,50,100,50);
text1.setBounds(320,100,100,25);
patern.setBounds(320,150,100,50);
text2.setBounds(320,200,100,25);
clear.setBounds(300,250,70,25);
about.setBounds(375,250,70,25);
area.setBounds(30,50,200,300);
about.addActionListener(this);
frame.add(area);
frame.add(clear);
frame.add(about);
frame.add(row);
frame.add(text1);
frame.add(patern);
frame.add(text2);
frame.show();


}
public void actionPerformed(ActionEvent e){
Object ob=e.getSource();
if (ob==clear){ area.setText("This program is of\nprinting stars with differnt style");  }
 
if(ob==about){
frame.setBackground(Color.red);
area.setText("aaa");
}

}
public static void main(String arg[]){
StarGui obj=new StarGui();

}
}