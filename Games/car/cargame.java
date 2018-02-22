import java.awt.*;

import javax.swing.*;
public class cargame{
public static void main(String arg[])throws Exception{
int y=100,z=350;
Frame win=new Frame("motion pic");
win.setBounds(0, 0, 600, 530);
ImageIcon car=new ImageIcon("e:/image1.png"); 
JLabel c=new JLabel(car);

ImageIcon icon=new ImageIcon("e:/road.jpg"); 
JLabel pic=new JLabel(icon);
ImageIcon icon1=new ImageIcon("e:/bar.jpg"); 
JLabel pic1=new JLabel(icon1);
ImageIcon icon2=new ImageIcon("e:/bar.jpg"); 
JLabel pic2=new JLabel(icon2);
c.setBounds(200, 200, 100, 110);
pic.setBounds(0, 0, 500, 600);
pic1.setBounds(250, y, 20, 72);
win.add(c);
win.add(pic2);
win.add(pic1);
win.add(pic);
win.setVisible(true); 

for (;;y++,z++){
                 
          pic1.setBounds(250, y, 20, 72);
           
           
             pic2.setBounds(250, z, 20, 72);
             if(y==500){y=0;}
           
             if(z==500){z=0;}
             Thread.sleep(5);
}}



}


