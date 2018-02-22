import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
public class tictac extends Frame implements ActionListener {

	Button buttons[]=new Button[9];
	boolean b;
	Color color=new Color(100,210,20);
	tictac(){
	//GridLayout layout=new GridLayout(3,3);
	setLayout(new GridLayout(3,3));
	Font font=new Font("arial",Font.BOLD,25);
	for(int i=0;i<buttons.length;i++){
		buttons[i]=new Button();
		add(buttons[i]);
		buttons[i].setFont(font);
		buttons[i].addActionListener(this);
		buttons[i].setBackground(color);
	}
		//buttons[0]=buttons[1];
		setBounds(0,0,300,300);
		show();
	}
	
	public static void main(String[] args) {
		new tictac();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button but=(Button)e.getSource();
		if(b){
			but.setBackground(Color.getHSBColor(HEIGHT, ALLBITS, ALLBITS));
			but.setLabel("X");
		}else {but.setBackground(Color.getHSBColor(45, 120, 50));
			but.setLabel("0");}
		b=!b;
		but.setEnabled(false);
	}
}
