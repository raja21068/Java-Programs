import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class notepaddReplace extends JDialog implements ActionListener {

	JLabel l=new JLabel("Find what:");
	JLabel l2=new JLabel("Replace with:");
	JButton bfn=new JButton("Find Next");
	JButton brep=new JButton("Replace");
	JButton brepall=new JButton("ReplaceAll");
	JButton bcan=new JButton("Cancel");
	JTextField tf=new JTextField();
	JTextField tf2=new JTextField();
	JCheckBox cb =new JCheckBox("Match Case");
	notepadd note;
	notepaddReplace(notepadd n){
		note=n;
		setTitle("Replace");
		setBounds(200,200,355,180);
		Font f=new Font("arial",Font.PLAIN,11);
		Container con=getContentPane();
		con.setLayout(null);
		
		l.setBounds(7, 15, 60, 10);
		l.setFont(f);
		con.add(l);
		l2.setBounds(7, 40, 80, 10);
		l2.setFont(f);
		con.add(l2);
		
		tf.setBounds(70,10,190,22);
		con.add(tf);
		tf2.setBounds(70,35,190,22);
		con.add(tf2);
		bfn.setBounds(265,10,80,20);
		bfn.setFont(f);
		con.add(bfn);
		brep.setBounds(265,35,80,20);
		brep.setFont(f);
		con.add(brep);
		brepall.setBounds(265,60,80,20);
		brepall.setFont(f);
		con.add(brepall);
		bcan.setBounds(265,85,80,20);
		bcan.setFont(f);
		con.add(bcan);
		cb.setBounds(10,120,90,25);
		cb.setFont(f);
		con.add(cb);
		
		bfn.addActionListener(this);
		brep.addActionListener(this);
		brepall.addActionListener(this);
		bcan.addActionListener(this);

		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//show();
	}
	/*public static void main(String[] args) {
		new notepaddReplace();

	}*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object ob=arg0.getSource();
		if(ob==brep){
		String s1=tf.getText();
		System.out.println("Text input: "+s1);
		String s2=tf2.getText();
		System.out.println("Replace with: "+s2);
		String s3=note.txt.getText();
		s3=s3.replace(s1, s2);
		note.txt.setText(s3);
		System.out.println(s3);
		}
		if(ob==brepall){
			String s1=tf.getText();
			System.out.println("Text input: "+s1);
			String s2=tf2.getText();
			System.out.println("Replace with: "+s2);
			String s3=note.txt.getText();
			String s4=s3.replaceAll(s1,s2);
			note.txt.setText(s4);
			System.out.println(s4);
			}
		if(ob==bcan){ dispose(); }
		
	}

}
