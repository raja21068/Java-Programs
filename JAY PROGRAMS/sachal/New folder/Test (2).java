import java.awt.*;

public class Test {
public static void main(String args[]){
/*
  Frame win1=new Frame("frame1");
  Frame win2=new Frame("frame2");
  Frame win3=new Frame("frame3");
  Frame win4=new Frame("frame4");
  Frame win5=new Frame("frame5");
  Frame win6=new Frame("frame6");
  Frame win7=new Frame("frame7");
*/

  Frame win1=new Frame("frame 1");
  Frame win2=new Frame("frame 2");

  Button b1=new Button("button 1");
  Button b2=new Button("button 2");
  Button b3=new Button("button 3");
  Button b4=new Button("button 4");
  Button b5=new Button("button 5");
  Button b6=new Button("button 6");

   Font font=new Font("comic ms sans",Font.BOLD,20);

  b1.setFont(font);
  b2.setFont(font);
  b3.setFont(font);


  b1.setBackground(Color.red);
  b2.setBackground(Color.red);
  b3.setBackground(Color.red);
  b4.setBackground(Color.red);
  b5.setBackground(Color.red);
  b6.setBackground(Color.red);


  b1.setBounds(100,100,100,25);
  b2.setBounds(100,130,100,25);
  b3.setBounds(100,160,100,25);
  b4.setBounds(100,190,100,25);
  b5.setBounds(100,220,100,25);
  b6.setBounds(100,250,100,25);

  win1.add(b1);
  win1.add(b2);
  win1.add(b3);

  win2.add(b4);
  win2.add(b5);
  win2.add(b6);

  win1.setLayout(null);
  win2.setLayout(null);

  win1.setBounds(0,0,300,600);
  win2.setBounds(400,0,300,600);

  win1.setVisible(true);
  win2.setVisible(true);


 /*
  for(int a=50; a<=500; a+=50)
  {
     Frame win=new Frame("frame "+a);
     win.setBounds(a,a,300,300);
     win.setVisible(true);
  }
*/



}

}
