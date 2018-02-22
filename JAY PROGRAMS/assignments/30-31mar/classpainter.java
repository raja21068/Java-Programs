import javax.swing.*;
import java.awt.*;
class classpainter{
public static void main(String arg[]){
JFrame win=new JFrame("A simple Paint program");
PaintPanel paintpanel=new PaintPanel();

win.add(paintpanel, BorderLayout.CENTER);
win.add(new JLabel("Drag to mouse to draw"),BorderLayout.SOUTH);

win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
win.setSize(400,200);
win.setVisible(true);
}
}

           //(page no:605)