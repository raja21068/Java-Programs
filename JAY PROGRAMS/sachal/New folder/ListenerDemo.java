/*MouseListener

mouseClicked()
mouseEntered()
mouseExited()
mousePressed()
mouseReleased()
*/
import java.awt.*;
import java.awt.event.*;

class ListenerDemo extends Frame implements MouseListener{

    ListenerDemo (){
         setBounds(0,0,300,300);
         addMouseListener(this);
         show();
    }

public void mouseClicked(MouseEvent e){
      setBackground(Color.yellow);
}
public void mouseEntered(MouseEvent e){
      setBackground(Color.green);
}
public void mouseExited(MouseEvent e){
      setBackground(Color.red);
}
public void mousePressed(MouseEvent e){
      System.out.println("Pressed");
      setBackground(Color.blue);
}
public void mouseReleased(MouseEvent e){
//      setBackground(Color.black);
}

public static void main(String arg[]){
     ListenerDemo l = new ListenerDemo();
}

}