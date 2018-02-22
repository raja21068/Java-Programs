import java.applet.*;

import java.awt.*;
import java.awt.event.*;

public class TestApplet2 extends Applet implements ActionListener{

   Button redButton=new Button("RED");
   Button blueButton=new Button("BLUE");
   Button greenButton=new Button("GREEN");
   Button yellowButton=new Button("YELLOW");
   Button orangeButton=new Button("ORANGE");

   public void init(){
       BorderLayout layout=new BorderLayout(10,10);
       setLayout(layout);
/*
       add(redButton);
       add(blueButton);
       add(greenButton);
*/
       add(redButton,BorderLayout.NORTH);
       add(blueButton,BorderLayout.SOUTH);
       add(greenButton,BorderLayout.CENTER);
       add(yellowButton,BorderLayout.EAST);
       add(orangeButton,BorderLayout.WEST);

      System.out.println("I am init");
   }
   public void start(){

     redButton.addActionListener(this);
     blueButton.addActionListener(this);
     greenButton.addActionListener(this);

     System.out.println("I am start");
   }
   public void stop(){
      System.out.println("I am stop");
   }
   public void destroy(){
      System.out.println("I am destroy");
   }


   public void actionPerformed(ActionEvent e){

     if(redButton==e.getSource())setBackground(Color.red);
     if(blueButton==e.getSource())setBackground(Color.blue);
     if(greenButton==e.getSource())setBackground(Color.green);
    
   }
}
