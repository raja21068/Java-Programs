import java.awt.*;
import java.awt.event.*;
class hms{
public static void main(String arg[])throws Exception{
Frame win=new Frame("h/m/s");
Label label=new Label("H . M . S");
Label hour=new Label();
Label min=new Label();   
Label sec=new Label();
win.setLayout(null);
win.setBounds(0,0,300,300);
label.setBounds(100,80,50,25);
hour.setBounds(100,110,20,20);
min.setBounds(120,110,20,20);
sec.setBounds(140,110,20,20);
win.add(label);
win.add(min);
win.add(hour);
win.add(sec);
win.show();
for (int i=0;i<24;i++ ){
    hour.setText(""+i);
   
   
   
      for (int j=0;j<60;j++){
         
         min.setText(""+j);
         
         
         
              for (int k=1;k<60;k++){
                   
                  sec.setText(""+k);
                  
                   
                 Thread.sleep(1000);
                  }}}




}

}