import java.awt.*;
import java.awt.event.*;



class  TestAction implements ActionListener{
   Frame win=new Frame();

   Button redButton=new Button("RED");
   Button greenButton=new Button("GREEN");
   Button yellowButton=new Button("YELLOW");

   TestAction(){
     win.setLayout(null);

     redButton.setBounds(100,100,100,25);
     greenButton.setBounds(100,130,100,25);
     yellowButton.setBounds(100,160,100,25);

     win.add(redButton);
     win.add(greenButton);
     win.add(yellowButton);

     redButton.addActionListener(this);
     greenButton.addActionListener(this);
     yellowButton.addActionListener(this);


     win.setBounds(0,0,500,500);
     win.show();
   }


   public void actionPerformed(ActionEvent e){

    Object ob=e.getSource();

    if(ob==redButton)win.setBackground(Color.red);
    if(ob==greenButton)win.setBackground(Color.green);
    if(ob==yellowButton)win.setBackground(Color.yellow);

   }

   public static void main(String arg[]){
       TestAction obj=new TestAction();
   }
}
