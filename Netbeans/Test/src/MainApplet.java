import java.applet.*;
import java.awt.event.*;

public class MainApplet extends Applet implements ActionListener{
    public void init(){
        javax.swing.JButton b = new javax.swing.JButton("Open tic tac toe game..");
        b.addActionListener(this);
    }
    public void destroy(){}
    public void start(){}
    public void stop(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        new tictac().init();
    }
}
