import java.awt.*;

class testimage5{
public static void main(String[] args)throws Exception{

for (int i=50,j=0,k=1500,l=1300;i<=500;i+=70,j+=90,k-=140,l-=170){
Frame win=new Frame();
win.setTitle("Test");
win.setLocation(i,j);
win.setBackground(Color.green);
win.setSize(k,l);
win.show();
Thread.sleep(1000); }
}
}