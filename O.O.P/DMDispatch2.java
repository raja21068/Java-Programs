import java.awt.event.*;
import java.awt.*;

class ab implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){ System.out.println("i am Ab"); }
}

class bc implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("i am bc");
	}
	
}

class test extends Frame{
	Button b1=new Button("Ab");
	Button b2=new Button("Bc");
	test(){
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		ab ob1=new ab();
		bc ob2=new bc();
		b1.addActionListener(ob1);
		b2.addActionListener(ob2);
		setBounds(0,0,400,400);
		show();
	}
}
class DMDispatch2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new test();
		// TODO Auto-generated method stub

	}

}
