import java.awt.event.*;
import java.awt.*;

import javax.swing.JButton;

class buttonclone extends Frame implements ActionListener {
	//Button[] b;
	JButton b1=new JButton("add new");
	
	buttonclone(){
		FlowLayout flow=new FlowLayout();
		setLayout(flow);
		setBounds(0,0,400,400);
		b1.addActionListener(this);
		add(b1);
		show();
	}


	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==b1){ 
		Button b=new Button("add new");
		b.addActionListener(this);
		add(b);
		show();
		}
		
	}
	public static void main(String[] args) {
		new buttonclone();
	}
}
