import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{
	JLabel main=new JLabel("MAIN MENU");
	JButton cal,marks,troaly,atm,converts,shapes,employee,hesco,exit; 
	Font font=new Font("ARIAL",Font.BOLD,20);
//********************stating constructor*********	
	MainMenu(){
		Container con=getContentPane();
		con.setLayout(null);
		setResizable(false);
		setBounds(0,0,410,400);
		cal=new JButton("CALCULATOR");
		marks=new JButton("MARKSHEET");
		troaly=new JButton("TROALYLOAD");
		atm=new JButton("ATM");
		converts=new JButton("CONVERTERS");
		shapes=new JButton("SHAPES");
		employee=new JButton("EMPLOYEES SALARY");
		hesco=new JButton("HESCO");
		exit=new JButton("EXIT");
		main.setFont(font);
	//*************seting bounds****************	
		main.setBounds(140, 20, 130, 20);
		cal.setBounds(30, 60, 160, 30);
		marks.setBounds(210, 60, 160, 30);
		troaly.setBounds(30, 110, 160, 30);
		atm.setBounds(210, 110, 160, 30);
		converts.setBounds(30, 160, 160, 30);
		shapes.setBounds(210, 160, 160, 30);
		employee.setBounds(30, 210, 160, 30);
		hesco.setBounds(210, 210, 160, 30);
		exit.setBounds(120, 260, 160, 30);
	//*********adding action listener**********	
		cal.addActionListener(this);
		marks.addActionListener(this);
		troaly.addActionListener(this);
		atm.addActionListener(this);
		converts.addActionListener(this);
		shapes.addActionListener(this);
		employee.addActionListener(this);
		hesco.addActionListener(this);
		exit.addActionListener(this);
	//*********adding in container************	
		con.add(main);
		con.add(cal);
		con.add(marks);
		con.add(troaly);
		con.add(atm);
		con.add(converts);
		con.add(shapes);
		con.add(employee);
		con.add(hesco);
		con.add(exit);
	//******************************************	
		show();
	}

	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		if(ob==cal){
	
		}
		if(ob==marks){
			hide();
			Marksheet m=new Marksheet();
		}
		if(ob==troaly){
			hide();
			Trolyload t=new Trolyload();
		}
		if(ob==atm){}
		if(ob==converts){}
		if(ob==shapes){
			hide();
			Starlist s=new Starlist();
		}
		if(ob==employee){}
		if(ob==hesco){
			hide();
			Hesco h=new Hesco();
		}
		if(ob==exit){
			hide();
		}
		
		
		
	}
	public static void main(String arg[]){
	new MainMenu();
}
}
