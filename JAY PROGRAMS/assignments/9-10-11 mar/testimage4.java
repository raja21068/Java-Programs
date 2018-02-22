import java.awt.*;

class testimage4{
public static void main(String[] args){
Frame win=new Frame();
Toolkit kit= win.getToolkit();
Dimension d= kit.getScreenSize();
win.setSize(d.width,d.height/2);
win.show();
}
}