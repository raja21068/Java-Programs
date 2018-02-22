import java.util.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;


class app{

	String cname;
	public String toString(){
		return cname;}
}

class Utility extends Frame implements ListSelectionListener, ActionListener{
JList list=new JList();
String str;
JButton ex=new JButton("Execute");
Runtime run=Runtime.getRuntime();
Utility(){
	setLayout(null);
	setBounds(0, 0, 500, 500);
	ex.addActionListener(this);
	ex.setBounds(200, 400, 100, 50);
	list.setBounds(50,50,100,200);
	list.addListSelectionListener(this);
	add(ex);
	add(list);
	
	SetColor();
	
	show();
	
}

private void SetColor(){
	Vector v=new Vector();
	app c1=new app();
	c1.cname="Calc";
	app c2=new app();
	c2.cname="notepad";
	app c3=new app();
	c3.cname="BLACK";

	v.addElement(c1);
	v.addElement(c2);
	v.addElement(c3);

	
	list.setListData(v);
	
}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		app b=(app)list.getSelectedValue();
		if(b==null)return;
		str=b.cname;
		
	}
	
	public static void main(String[] args){
		Utility ob=new Utility();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==ex){  
		try {
			run.exec(str);
		} catch (Exception e1) {}
		
	}

	
	}}
/*public class Utility extends Frame implements ActionListener, ListSelectionListener {
	Button ex=new Button("Execute");
	List l=new List();
	String str=new String();
	Runtime run=Runtime.getRuntime();

	Utility(){
		setBounds(0,0,500,500);
		l.setBounds(50,50,200,350);
		setLayout(null);
		ex.setBounds(200, 400, 100, 50);
		setTitle("Utility Manager");
		ex.addActionListener(this);
		l.add("Calc");
		l.add("notepad");
		
		add(l);
		add(ex);
		show();	
	}
	
	
	
	public static void main(String[] args) {
		Utility ob=new Utility();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==ex){  
		try {
			run.exec(str);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		}
	}



	@Override
	public void valueChanged(ListSelectionEvent e) {
		String s=l.getSelectedItem();
		str=s;
	}

}*/
