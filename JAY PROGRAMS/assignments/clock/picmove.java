import java.awt.*;

import javax.swing.*;
class picmove{
public static void main(String arg[])throws Exception{
Frame win=new Frame("h/m/s");
win.setBounds(0, 0, 300, 300);
ImageIcon icon=new ImageIcon("d://abc.jpg"); 
JLabel pic=new JLabel(icon);
win.add(pic);
win.show(); 
for (int i=7;i<200;i++ ){
             pic.setBounds(i, 40, 40, 30);     
              if(i>195){i=7;}     
                 Thread.sleep(1000);
                 
}}




}

