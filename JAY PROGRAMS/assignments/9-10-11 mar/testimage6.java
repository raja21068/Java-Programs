import java.awt.*;

class testimage6{
public static void main(String[] args){
for(int i=0;i<3;i++){
Frame win1=new Frame("RED");
Frame win2=new Frame("Yellow");
Frame win3=new Frame("Blue");
win1.setBackground(Color.red);
win2.setBackground(Color.yellow);
win3.setBackground(Color.blue);
win1.setBounds(50,50,1400,1200);
win2.setBounds(150,150,300,300);
win3.setBounds(200,200,200,200);
win1.show();
win2.show();
win3.show();
}
}
}