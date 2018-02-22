import java.awt.event.*;
import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
class colour{
	Color color;
	String cname;
	public String toString(){
		return cname;}
}

class ColorList extends Frame implements ListSelectionListener, MouseListener{
JList list=new JList();

ColorList(){
	setLayout(null);
	setBounds(0, 0, 500, 500);
	addMouseListener(this);
	list.setBounds(50,50,100,200);
	list.addListSelectionListener(this);
	add(list);
	
	SetColor();
	
	show();
	
}

private void SetColor(){
	Vector v=new Vector();
	colour c1=new colour();
	c1.cname="RED";
	c1.color=(Color.red);
	colour c2=new colour();
	c2.cname="BLUE";
	c2.color=(Color.BLUE);
	colour c3=new colour();
	c3.cname="BLACK";
	c3.color=(Color.BLACK);
	colour c4=new colour();
	c4.cname="PINK";
	c4.color=(Color.PINK);
	colour c5=new colour();
	c5.cname="GREEN";
	c5.color=(Color.GREEN);
	colour c6=new colour();
	c6.cname="CYAN";
	c6.color=(Color.cyan);
	colour c7=new colour();
	c7.cname="DARK GRAY";
	c7.color=(Color.DARK_GRAY);
	colour c8=new colour();
	c8.cname="MEGENTA";
	c8.color=(Color.magenta);
	colour c9=new colour();
	c9.cname="ORANGE";
	c9.color=(Color.orange);
	colour c10=new colour();
	c10.cname="YELLOW";
	c10.color=(Color.YELLOW);
	colour c11=new colour();
	c11.cname="LIGHTGRAY";
	c11.color=(Color.lightGray);
	
	v.addElement(c1);
	v.addElement(c2);
	v.addElement(c3);
	v.addElement(c4);
	v.addElement(c5);
	v.addElement(c6);
	v.addElement(c7);
	v.addElement(c8);
	v.addElement(c9);
	v.addElement(c10);
	v.addElement(c11);
	
	list.setListData(v);
	
}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		colour b=(colour)list.getSelectedValue();
		if(b==null)return;
		setBackground(b.color);
		
	}
	
	public static void main(String[] args){
		ColorList ob=new ColorList();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(Color.WHITE);
		
	}
}