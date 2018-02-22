import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.JOptionPane;
public class tictac extends Applet implements ActionListener {

	javax.swing.JButton buttons[]=new javax.swing.JButton[9];
	boolean b;
	Color color=new Color(100,210,20);
	public void init(){
	//GridLayout layout=new GridLayout(3,3);
	setLayout(new GridLayout(3,3));
	Font font=new Font("arial",Font.BOLD,25);
	for(int i=0;i<buttons.length;i++){
		buttons[i]=new javax.swing.JButton();
		add(buttons[i]);
		buttons[i].setFont(font);
		buttons[i].addActionListener(this);
		buttons[i].setBackground(color);
	}
		//buttons[0]=buttons[1];
		//setBounds(0,0,300,300);
		show();
		javax.swing.JOptionPane.showMessageDialog(null,"");
	}
	
//	public static void main(String[] args) {
//		new tictac();
//		
//	}


	public void start(){}
	public void stop(){}
	public void destroy(){}
	@Override
	public void actionPerformed(ActionEvent e) {
		javax.swing.JButton but=(javax.swing.JButton)e.getSource();
		if(b){
			but.setBackground(Color.getHSBColor(HEIGHT, ALLBITS, ALLBITS));
			but.setLabel("X");
		}else {but.setBackground(Color.getHSBColor(45, 120, 50));
			but.setLabel("0");}
		b=!b;
		but.setEnabled(false);
		checking();
	}

	private void checking(){
		if((buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X"))||(buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X"))||(buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) ){
			javax.swing.JOptionPane.showMessageDialog(null, "X won the game");  }
		if((buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X"))||(buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X"))||(buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) ){
			javax.swing.JOptionPane.showMessageDialog(null, "X won the game");  }
		if((buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X"))||(buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))){
			javax.swing.JOptionPane.showMessageDialog(null, "X won the game"); }
		if((buttons[0].getText().equals("0") && buttons[1].getText().equals("0") && buttons[2].getText().equals("0"))||(buttons[3].getText().equals("0") && buttons[4].getText().equals("0") && buttons[5].getText().equals("0"))||(buttons[6].getText().equals("0") && buttons[7].getText().equals("0") && buttons[8].getText().equals("0")) ){
			javax.swing.JOptionPane.showMessageDialog(null, "0 won the game");  }
		if((buttons[0].getText().equals("0") && buttons[3].getText().equals("0") && buttons[6].getText().equals("0"))||(buttons[1].getText().equals("0") && buttons[4].getText().equals("0") && buttons[7].getText().equals("0"))||(buttons[2].getText().equals("0") && buttons[5].getText().equals("0") && buttons[8].getText().equals("0")) ){
			javax.swing.JOptionPane.showMessageDialog(null, "0 won the game");  }
		if((buttons[0].getText().equals("0") && buttons[4].getText().equals("0") && buttons[8].getText().equals("0"))||(buttons[2].getText().equals("0") && buttons[4].getText().equals("0") && buttons[6].getText().equals("0"))){
			javax.swing.JOptionPane.showMessageDialog(null, "0 won the game"); }
		
		
	}
}
