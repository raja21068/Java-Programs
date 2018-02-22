import java.awt.*;
import java.awt.event.*;
class Hesco<ImageIcon> implements ActionListener{
	Frame win=new Frame("HESCO");
	Label pic=new Label();
@SuppressWarnings("unchecked")
ImageIcon icon=(ImageIcon) ("jay.jpg");
	Hesco(){
	win.setBounds(0, 0, 400, 400);
	win.setIconImage((Image) icon);
	win.show();
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
public static void main(String arg[])throws Exception{
	new Hesco();
}
}
