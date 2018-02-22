import java.awt.*;

class testimage3{
public static void main(String[] args){

for (int i=0,j=0;i<=1000;i+=100,j+=145){
Frame win=new Frame();
win.setTitle("Test");
win.setLocation(j,i);
win.setBackground(Color.green);
win.setSize(75,100);
win.show(); }
}
}