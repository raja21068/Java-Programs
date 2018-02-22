import java.awt.*;
import java.awt.event.*;

/*
   MouseMotionListener
   mouseDragged();
   mouseMoved();

*/
class MotionDemo extends Frame implements MouseMotionListener{
      Button b = new Button("Dragged");
       
       MotionDemo(){
	setBounds(0,0,300,300);
        b.setBounds(100,100,100,25);  
                setLayout(null);
                add(b);
                addMouseMotionListener(this);
                show(); 
       }
   public void mouseDragged(MouseEvent e){  }
   public void mouseMoved(MouseEvent e){
   int x=e.getX();
   int y=e.getY();
   setTitle(x + ":" + y);
   b.setLocation(x+20,y);
       
   }

   public static void main(String arg[]){
        MotionDemo m = new MotionDemo ();
    }
}