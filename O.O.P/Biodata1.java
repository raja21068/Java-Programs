import java.awt.event.*;

import javax.swing.*;
public class Biodata1 extends JFrame implements KeyListener, ActionListener{
	JLabel name,live,uni,roll,bycot;
	JTextField namet;
	JTextField livet, unit, rollt, bycott;
	JButton clear,about;
	String str="";
	int t=1,mistake=0;
	int count=0;
	Biodata1(){
		
		setLayout(null);
		setResizable(false);
		setBounds(0,0,300,400);
		name=new JLabel("hello my name is ali");
		name.setBounds(25, 25, 200, 25);
		live=new JLabel("i live in hyderabad");
		live.setBounds(25, 75, 200, 25);
		uni=new JLabel("i am student of university of sindh");
		uni.setBounds(25, 125, 200, 25);
		roll=new JLabel("my roll no is 2k11/cse/99");
		roll.setBounds(25, 175, 200, 25);
		bycot=new JLabel("today is bycot");
		bycot.setBounds(25, 225, 200, 25);
		
		namet=new JTextField();
		namet.setBounds(25, 50, 200, 25);
		livet=new JTextField();
		livet.setBounds(25, 100, 200, 25);
		unit=new JTextField();
		unit.setBounds(25, 150, 200, 25);
		rollt=new JTextField();
		rollt.setBounds(25, 200, 200, 25);
		bycott=new JTextField();
		bycott.setBounds(25, 250, 200, 25);
		
		namet.setEditable(false);
		livet.setEditable(false);
		unit.setEditable(false);
		rollt.setEditable(false);
		bycott.setEditable(false);
		clear=new JButton("Clear");
		clear.setBounds(35, 280, 80, 25);
		about=new JButton("About");
		about.setBounds(130, 280, 80, 25);
		clear.addActionListener(this);
		about.addActionListener(this);
		add(name);
		add(live);
		add(uni);
		add(roll);
		add(bycot);
		add(namet);
		add(livet);
		add(unit);
		add(rollt);
		add(bycott);
		add(clear);
		add(about);
		addKeyListener(this);
		namet.addKeyListener(this);
		livet.addKeyListener(this); 
		unit.addKeyListener(this);
		rollt.addKeyListener(this);
		bycott.addKeyListener(this);
		clear.addKeyListener(this);
		about.addKeyListener(this);
		show();
	}


	public static void main(String[] args) {
		new Biodata1();
		
	}


	
	public void keyTyped(KeyEvent e) {
		char ob=e.getKeyChar();
		if(t==5){
			count++;
			str+=ob;
			bycott.setText(str);
			if(count==15){
				mistake++;
				str=""; JOptionPane.showMessageDialog(null, "Invalid spell\nRetype again");
				count=0;
				bycott.setText(null);
			}
			if(str.equals("today is bycot")){
				t++;
				str="";
				count=0;
				JOptionPane.showMessageDialog(null, "You Done well...!\nYou typed "+mistake+"times wrong sentence");
			}
		}//end of t==5	
		if(t==4){
			count++;
			str+=ob;
			rollt.setText(str);
			if(count==26){
				mistake++;
				str=""; JOptionPane.showMessageDialog(null, "Invalid spell\nRetype again");
				count=0;
				rollt.setText(null);
			}
			if(str.equals("my roll no is 2k11/cse/99")){
				t++;
				str="";
				count=0;
			}
		}//end of t==4
		
		if(t==3){
			count++;
			str+=ob;
			unit.setText(str);
			if(count==36){
				mistake++;
				str=""; JOptionPane.showMessageDialog(null, "Invalid spell\nRetype again");
				count=0;
				unit.setText(null);
			}
			if(str.equals("i am student of university of sindh")){
				t++;
				str="";
				count=0;
			}
		}//end of t==3
		
		if(t==2){
			count++;
			str+=ob;
			livet.setText(str);
			if(count==20){
				mistake++;
				str=""; JOptionPane.showMessageDialog(null, "Invalid spell\nRetype again");
				count=0;
				livet.setText(null);}
			if(str.equals("i live in hyderabad")){
				t++;
				str="";
				count=0;
			}
		}//end of t==2
				
		if(t==1){
			str+=ob;
			count++;
		namet.setText(str);
		if(count==21){
			mistake++;
			str=""; JOptionPane.showMessageDialog(null, "invalid sentence\nretype again");
			count=0;
			namet.setText(null);}
		if(str.equals("hello my name is ali")){
			t++;
			str="";
			count=0;
		}
		}//end of t==1
		
	}		


	
	public void keyPressed(KeyEvent e) {
	
		
	}


	
	public void keyReleased(KeyEvent e) {
	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==about){
			JOptionPane.showMessageDialog(null, "This is a 1st typing tutor program\nBy:Jay Kumar");
		}//end of if
	if(ob==clear){
		t=1;
		count=0;
		namet.setText(null);
		livet.setText(null);
		unit.setText(null);
		rollt.setText(null);
		bycott.setText(null);
		str = "";}//end of if	
	}//end of action performed

	
	
}//end of class
