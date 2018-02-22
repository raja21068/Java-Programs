import java.awt.*;
import java.awt.event.*;

/*
   MouseMotionListener
   mouseDragged();
   mouseMoved();

*/
class MotionDemo extends Frame implements MouseMotionListener{
      Button b = new Button("Dragged");
       b.setBounds(100,100,100,25);
       MotionDemo(){
	setBounds(0,0,300,300);
                setLayout(null);
                add(b);
                addMouseMotionListener(this);
                show(); 
       }
   public void mouseDragged(MouseEvent e){}
   public void mouseMoved(MouseEvent e){
       setTitle(e.getX() + ":" + e.getY());
   }

   public static void main(String arg[]){
        MotionDemo m = new MotionDemo ();
    }
}