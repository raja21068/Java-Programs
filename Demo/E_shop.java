
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Item{
	String ID;
	String name;
	String Description;
	String price;
	String quality;
    String picloc;
	public  String toString(){
		return name;
	}
}
public class E_shop extends JFrame implements ListSelectionListener,ActionListener{ 

	JButton basket1=new JButton("Add Basket");
	JButton basket2=new JButton("View Basket");
    JList list=new JList();
    JList list2=new JList();
    
    JLabel item=new JLabel("Item ID");
    JLabel description=new JLabel("Description");
    JLabel price=new JLabel("Price Rs");
    JLabel quantity=new JLabel("Quantity");
    JLabel picture=new JLabel("Picture");
    JLabel view=new JLabel("View Basket Item");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    
    
	E_shop(){
Container c=getContentPane();
c.setLayout(null);
c.add(picture);
c.add(basket1);
c.add(basket2);

c.add(list);
c.add(view);
c.add(list2);
c.add(item);
c.add(t1);
c.add(description);
c.add(t2);
c.add(price);
c.add(t3);
c.add(quantity);
c.add(t4);


basket1.setBounds(100, 280, 120, 30);
basket2.setBounds(100, 320, 120, 30);
list.setBounds(10, 20, 100, 200);
	list2.setBounds(300,100,100,150);
	item.setBounds(140, 70, 70, 30);
	t1.setBounds(220, 70, 50, 30);
	description.setBounds(140, 90, 70, 60);
	t2.setBounds(140, 130, 140, 70);
	price.setBounds(140, 200, 70, 30);
	t3.setBounds(200, 205,70, 30);
   quantity.setBounds(140, 240, 70, 30);
   t4.setBounds(200, 240, 40, 30);
   view.setBounds(300, 80, 100, 20);
   picture.setBounds(200, 10, 50,20);
   
	basket1.addActionListener(this);
	basket2.addActionListener(this);
	
	basket1.setBackground(Color.cyan);
	basket2.setBackground(Color.cyan);

	setBounds(0,0,500,400);
	
	Item item1=new Item();
	Item item2=new Item();
	Item item3=new Item();
	Item item4=new Item();
	item1.ID="1";
	item1.name="printer";
	item1.Description="Hp2012";
	item1.price="15000";
	item1.quality="";
	item1.picloc="\\Image\\printer.jpg";

	item2.ID="2";
	item2.name="Mouse";
	item2.Description="Dell";
	item2.price="160";
	item2.quality=" ";
	item2.picloc="\\Image\\printer.jpg";

	item3.ID="21";
	item3.name="KeyBoard";
	item3.Description="HP";
	item3.price="300";
	item3.quality=" ";
	item3.picloc="\\Image\\printer.jpg";

	item4.ID="22";
	item4.name="Moniter";
	item4.Description="Compaq 2012";
	item4.price="3000";
	item4.quality=" ";
	item4.picloc="\\Image\\printer.jpg";

	list.addListSelectionListener(this);
	Vector v=new Vector();
	v.addElement(item1);
	v.addElement(item2);
	v.addElement(item3);
	v.addElement(item4);
	
	list.setListData(v);
	show();
	}	
	
  
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
Item item=(Item)list.getSelectedValue();
if(item==null)return;
t1.setText(item.ID);
t2.setText(item.Description);
t3.setText(item.price);
t4.setText(item.quality);

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==basket1){
			Hashtable t=new Hashtable();
			t.put(t1.getText(), t4.getText());
			
			
		}
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]){
	new E_shop();
}



		
}

