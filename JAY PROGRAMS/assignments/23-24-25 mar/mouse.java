import java.awt.*;
import java.awt.event.*;

/*
   MouseMotionListener
   mouseDragged();
   mouseMoved();

*/
class MotionDemo2 extends Frame implements MouseMotionListener, MouseListener {
      Button b = new Button("Dragged");
       
       MotionDemo2(){
	setBounds(0,0,300,300);
        b.setBounds(100,100,100,25);  
                setLayout(null);
                add(b);
                addMouseListener(this);  
                addMouseMotionListener(this);
                show(); 
       }
public void mouseEntered(MouseEvent e){
setBackground(Color.green);}
public void mouseExited(MouseEvent e){
setBackground(Color.'2');}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){}

   public void mouseDragged(MouseEvent e){ 
   int x=e.getX();
   int y=e.getY(); 
   b.setLocation(x+20,y);                                      }
   public void mouseMoved(MouseEvent e){
   
   int c=e.getX();
   int d=e.getY();   
   setTitle(c + ":" + d);
   
       
   }

   public static void main(String arg[]){
        MotionDemo2 m = new MotionDemo2 ();
    }
}