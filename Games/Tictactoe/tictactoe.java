import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class tictactoe extends JFrame implements ActionListener {
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	int c=0;
	tictactoe(){
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		b6=new JButton();
		b7=new JButton();
		b8=new JButton();
		b9=new JButton();
		
		setBounds(0,0,400,400);
		setLayout(null);
		b1.setBounds(20, 20, 100, 100);
		b2.setBounds(130, 20, 100, 100);
		b3.setBounds(240, 20, 100, 100);
		b4.setBounds(20, 130, 100, 100);
		b5.setBounds(130, 130, 100, 100);
		b6.setBounds(240, 130, 100, 100);
		b7.setBounds(20, 240, 100, 100);
		b8.setBounds(130, 240, 100, 100);
		b9.setBounds(240, 240, 100, 100);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		show();
	}
	public static void main(String[] args) {
	new tictactoe();

	}

	
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==b1){
			c++;
			if(c%2==1){ b1.setBackground(Color.RED); 
			b1.setText("X");}
			else{b1.setBackground(Color.BLUE); 
			b1.setText("0");}
			b1.setEnabled(false);
		}
			if(ob==b2){
				c++;
				if(c%2==1){ b2.setBackground(Color.RED); b2.setText("X");}
				else{b2.setBackground(Color.BLUE); b2.setText("0");}
				b2.setEnabled(false);
			}
				if(ob==b3){
					c++;
					if(c%2==1){ b3.setBackground(Color.RED); b3.setText("X");}
					else{b3.setBackground(Color.BLUE); b3.setText("0");}
					b3.setEnabled(false);
				}
					if(ob==b4){
						c++;
						if(c%2==1){ b4.setBackground(Color.RED); b4.setText("X");}
						else{b4.setBackground(Color.BLUE); b4.setText("0");}
						b4.setEnabled(false);
					}
						if(ob==b5){
							c++;
							if(c%2==1){ b5.setBackground(Color.RED); b5.setText("X");}
							else{b5.setBackground(Color.BLUE); b5.setText("0");}
							b5.setEnabled(false);
						}
							if(ob==b6){
								c++;
								if(c%2==1){ b6.setBackground(Color.RED); b6.setText("X");}
								else{b6.setBackground(Color.BLUE); b6.setText("0");}
								b6.setEnabled(false);
							}
								if(ob==b7){
									c++;
									if(c%2==1){ b7.setBackground(Color.RED); b7.setText("X");}
									else{b7.setBackground(Color.BLUE); b7.setText("0");}

									b7.setEnabled(false);}
									if(ob==b8){
										c++;
										if(c%2==1){ b8.setBackground(Color.RED); b8.setText("X");}
										else{b8.setBackground(Color.BLUE); b8.setText("0");}
										b8.setEnabled(false);
									}
										if(ob==b9){
											c++;
											if(c%2==1){ b9.setBackground(Color.RED); b9.setText("X");}
											else{b9.setBackground(Color.BLUE); b9.setText("0");}
											b9.setEnabled(false);
										} checking();
		
	}

	private void checking(){
		if((b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X"))||(b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X"))||(b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X")) ){
			JOptionPane.showMessageDialog(null, "X won the game"); reset(); }
		if((b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X"))||(b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X"))||(b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")) ){
			JOptionPane.showMessageDialog(null, "X won the game"); reset(); }
		if((b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X"))||(b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X"))){
			JOptionPane.showMessageDialog(null, "X won the game"); reset();}
		if((b1.getText().equals("0") && b2.getText().equals("0") && b3.getText().equals("0"))||(b4.getText().equals("0") && b5.getText().equals("0") && b6.getText().equals("0"))||(b7.getText().equals("0") && b8.getText().equals("0") && b9.getText().equals("0")) ){
			JOptionPane.showMessageDialog(null, "0 won the game"); reset(); }
		if((b1.getText().equals("0") && b4.getText().equals("0") && b7.getText().equals("0"))||(b2.getText().equals("0") && b5.getText().equals("0") && b8.getText().equals("0"))||(b3.getText().equals("0") && b6.getText().equals("0") && b9.getText().equals("0")) ){
			JOptionPane.showMessageDialog(null, "0 won the game"); reset(); }
		if((b1.getText().equals("0") && b5.getText().equals("0") && b9.getText().equals("0"))||(b3.getText().equals("0") && b5.getText().equals("0") && b7.getText().equals("0"))){
			JOptionPane.showMessageDialog(null, "0 won the game"); reset();}
		
		
	}
 private void reset(){
	 b1.setText(null);
	 b1.setBackground(null);
	 b1.setEnabled(true);
	 b2.setText(null);
	 b2.setBackground(null);
	 b2.setEnabled(true);
	 b3.setText(null);
	 b3.setBackground(null);
	 b3.setEnabled(true);
	 b4.setText(null);
	 b4.setBackground(null);
	 b4.setEnabled(true);
	 b5.setText(null);
	 b5.setBackground(null);
	 b5.setEnabled(true);
	 b6.setText(null);
	 b6.setBackground(null);
	 b6.setEnabled(true);
	 b7.setText(null);
	 b7.setBackground(null);
	 b7.setEnabled(true);
	 b8.setText(null);
	 b8.setBackground(null);
	 b8.setEnabled(true);
	 b9.setText(null);
	 b9.setBackground(null);
	 b9.setEnabled(true);
 }
}
