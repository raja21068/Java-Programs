import java.awt.*;

import javax.swing.*;


class notepaddGoto extends JFrame {

	JLabel l=new JLabel("Line Number:");
	JButton b1=new JButton("OK");
	JButton b2=new JButton("Cancel");
	JTextField tf=new JTextField();
	notepadd note;
	notepaddGoto(notepadd n){
		note=n;
		setTitle("Goto");
		setBounds(200,200,270,125);
		Font f=new Font("arial",Font.PLAIN,11);
		Container con=getContentPane();
		con.setLayout(null);
		
		l.setBounds(9, 15, 65, 10);
		l.setFont(f);
		con.add(l);
		tf.setBounds(75,10,80,22);
		con.add(tf);
		b1.setBounds(20,55,70,20);
		b1.setFont(f);
		con.add(b1);
		b2.setBounds(100,55,70,20);
		b2.setFont(f);
		con.add(b2);
		setResizable(false);
		String lineNo = tf.getText();
		try{
		int line = Integer.parseInt(lineNo);
		n.txt.setCaretPosition(line);}
		catch(Exception e){}
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show();
	}
	/*public static void main(String[] args) {
		//new notepaddGoto();

	}*/

}
