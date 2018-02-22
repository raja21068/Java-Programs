import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class change extends Frame implements ActionListener {
JButton b=new JButton("CHANGE");
int c=0;
change(){
	setLayout(null);
	setBounds(0,0,500,500);
	b.setBounds(200, 200, 100, 100);
	add(b);
	b.addActionListener(this);
	show();
}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==b){
			c++;
			if(c%2==1){ setBackground(Color.RED); }
			else{ setBackground(Color.BLUE); }
		}
		
	}

	public static void main(String[] args) {
		new change();
	}

}
