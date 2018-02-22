import javax.swing.*;
import java.awt.*;
import javax.swing.tree.*;
import java.util.*;

class testTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame win=new JFrame();
		
		Vector vec1=new Vector();
		vec1.addElement("A");
		vec1.addElement("B");
		vec1.addElement("C");
		Vector vec2=new Vector();
		vec2.addElement("D");
		vec2.addElement("E");
		vec2.addElement("F");
		Vector vec3=new Vector();
		vec3.addElement("G");
		vec3.addElement("H");
		vec3.addElement("I");
		Vector mainv=new Vector();
		mainv.add(vec1);
		mainv.add(vec2);
		mainv.add(vec3);		
		JTree maint=new JTree(mainv);
		//win.getContentPane().setLayout(null);
		maint.setBounds(30, 40, 200, 200);
		win.getContentPane().add(maint);
		win.setSize(300,500);
		win.show();
		
	}

}
