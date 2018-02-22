import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Abc extends Applet implements ActionListener{

Button redButton=new Button("RED");
Button blueButton=new Button("BLUE");
Button greenButton=new Button("GREEN");


public void init(){}
public void stop(){}
public void destroy(){}

public void start(){

add(redButton);
add(blueButton);
add(greenButton);

redButton.addActionListener(this);
greenButton.addActionListener(this);
blueButton.addActionListener(this);
}

public void actionPerformed(ActionEvent e){

if(redButton==e.getSource())setBackground(Color.red);
if(greenButton==e.getSource())setBackground(Color.green);
if(blueButton==e.getSource())setBackground(Color.blue);

}
}