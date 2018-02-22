import java.awt.*;
import java.awt.event.*;

class Click extends Frame implements MouseListener{

Click(){
setBounds(0,0,300,300);
addMouseListener(this);
show();

}
public void mouseEntered(MouseEvent e){
setBounds(0,0,600,300);
setBackground(Color.green);

}
public void mouseExited(MouseEvent e){
setBackground(Color.red);
setBounds(0,0,300,300);
}
public void mouseClicked(MouseEvent e){
//setBackground(Color.yellow);
}
public void mousePressed(MouseEvent e){
setBackground(Color.pink);
setBounds(0,0,300,600);
}
public void mouseReleased(MouseEvent e){
setBackground(Color.black);
setBounds(0,0,300,300);
}
public static void main(String arg[]){
Click i=new Click();
}

}