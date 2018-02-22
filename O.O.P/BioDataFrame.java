import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class BioData{
	String name,fname,surname,dateofbirth,rollno,remarks,gender;
	public String toString(){
		return rollno;}
	
}


public class BioDataFrame extends JFrame implements ListSelectionListener {

	JTextField t1,t2,t3,t4,t5,t6;
	JTextArea area;
	JComboBox combo=new JComboBox();
	JList list=new JList();
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	BioDataFrame(){
		
		Container c=getContentPane();
		c.setLayout(null);
		setBounds(0,0,500,500);
		combo.addItem("Male");
		combo.addItem("Female");
		combo.addItem("Unique");
		combo.setBounds(110, 140, 100, 25);
		l1=new JLabel("Name");
		l1.setBounds(10,20,50,25);
		l2=new JLabel("F/name");
		l2.setBounds(10,50,50,25);
		l3=new JLabel("Surname");
		l3.setBounds(10,80,100,25);
		l4=new JLabel("Date of Birth");
		l4.setBounds(10,110,100,25);
		l5=new JLabel("Gender");
		l5.setBounds(10,140,50,25);
		l6=new JLabel("Rollno");
		l6.setBounds(10,170,50,25);
		l7=new JLabel("Remarks");
		l7.setBounds(10,200,60,25);
		l8=new JLabel("Students List");
		l8.setBounds(250,15,100,25);
		
		c.setBackground(Color.pink);
		
		t1=new JTextField();
		t1.setBounds(110,20,80,25);
		t2=new JTextField();
		t2.setBounds(110,50,80,25);
		t3=new JTextField();
		t3.setBounds(110,80,80,25);
		t4=new JTextField();
		t4.setBounds(110,110,80,25);
		t5=new JTextField();
		t5.setBounds(110,170,80,25);
		area=new JTextArea();
		area.setBounds(110,200,80,50);
		list.setBounds(240, 45, 140, 180);
		list.addListSelectionListener(this);
		add(list);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(area);
		add(combo);
		setStudents();
		show();
		
	}

	private void setStudents() {
		Vector v=new Vector();
		BioData b1=new BioData();
		b1.name="Ali";
		b1.fname="Kamran";
		b1.surname="Sheikh";
		b1.dateofbirth="2-3-1991";
		b1.rollno="2k10/CSE/01";
		b1.remarks="Good";
		b1.gender="Male";
		BioData b2=new BioData();
		b2.name="Ayesha";
		b2.fname="abdul Kamal";
		b2.surname="Soomro";
		b2.dateofbirth="7-4-1991";
		b2.rollno="2k10/CSE/02";
		b2.remarks="Good";
		b2.gender="Unique";
		BioData b3=new BioData();
		b3.name="Akram";
		b3.fname="Waseem";
		b3.surname="Lagari";
		b3.dateofbirth="21-8-1990";
		b3.rollno="2k10/CSE/03";
		b3.remarks="Good";
		b3.gender="Male";
		BioData b4=new BioData();
		b4.name="Azhar";
		b4.fname="Ayaz";
		b4.surname="Unar";
		b4.dateofbirth="12-1-1992";
		b4.rollno="2k10/CSE/04";
		b4.remarks="Good";
		b4.gender="Male";
		BioData b5=new BioData();
		b5.name="Alishan";
		b5.fname="Qaoom";
		b5.surname="Khwaja";
		b5.dateofbirth="3-9-1989";
		b5.rollno="2k10/CSE/05";
		b5.remarks="Good";
		b5.gender="Male";
		BioData b6=new BioData();
		b6.name="Arooba";
		b6.fname="Safeer";
		b6.surname="Sheikh";
		b6.dateofbirth="17-6-1991";
		b6.rollno="2k10/CSE/06";
		b6.remarks="Good";
		b6.gender="Female";
		BioData b7=new BioData();
		b7.name="Anwar";
		b7.fname="Junaid";
		b7.surname="channa";
		b7.dateofbirth="25-5-1992";
		b7.rollno="2k10/CSE/07";
		b7.remarks="Good";
		b7.gender="Male";
		BioData b8=new BioData();
		b8.name="Bilal";
		b8.fname="Tariq";
		b8.surname="chandio";
		b8.dateofbirth="29-10-1988";
		b8.rollno="2k10/CSE/08";
		b8.remarks="Good";
		b8.gender="Male";
				
		v.addElement(b1);
		v.addElement(b2);
		v.addElement(b3);
		v.addElement(b4);
		v.addElement(b5);
		v.addElement(b6);
		v.addElement(b7);
		v.addElement(b8);
		
		list.setListData(v);
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		BioData b=(BioData)list.getSelectedValue();
		if(b==null)return;
		t1.setText(b.name);
		t2.setText(b.fname);
		t3.setText(b.surname);
		t4.setText(b.dateofbirth);
		t5.setText(b.rollno);
		area.setText(b.remarks);
		combo.setSelectedItem(b.gender);
	}

	public static void main(String[] args) {
		new BioDataFrame();

	}
}
