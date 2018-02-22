import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
class Item{
	String ID,name,Discription,price,quantity,picloc;
	int itemIndex;
	public String toString(){
		return name;
	}
	
}
public class e_Shop extends JFrame implements ListSelectionListener,ActionListener {
	
	//Components
	JList itemlist,selectList;
	JTextField id,quantity;
	JTextArea discrip;
	JButton addBasket,viewBasket,removeItem,purchase,about;
	JScrollPane itemscrol,selectscrol,discripscrol;
	JLabel itemLabel,idLabel,discripLabel,priceLabel,price,quantityLabel,viewItemLabel,pic;
	Vector v; int index=-1;
	Object[] obArray=new Object[20]; 
	
		e_Shop(){
			//Frame Setting
			setBounds(100,100,600,500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(null);
			setTitle("e-Shop");
			setIconImage(Toolkit.getDefaultToolkit().getImage("vista.png"));
			setResizable(false);
			try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch(Exception e){}
			
			//Initializing components
			itemlist=new JList();
			selectList=new JList();
			id=new JTextField();
			quantity=new JTextField();
			discrip=new JTextArea();
			addBasket=new JButton("Add Basket",new ImageIcon("bask.png"));
			viewBasket=new JButton("View Basket",new ImageIcon("view.png"));
			removeItem=new JButton("Remove",new ImageIcon("remove.png"));
			itemscrol=new JScrollPane(itemlist);
			selectscrol=new JScrollPane(selectList);
			discripscrol=new JScrollPane(discrip);
			itemLabel=new JLabel("ITEMS");
			idLabel=new JLabel("ITEM ID:");
			discripLabel=new JLabel("DISCRPTION");
			priceLabel=new JLabel("PRICE RS:");
			price=new JLabel("0");
			quantityLabel=new JLabel("QUANTITY:");
			viewItemLabel=new JLabel("VIEW BASKET ITEMS");
			pic=new JLabel();
			purchase=new JButton("Purchase");
			about=new JButton("About",new ImageIcon("aboutb.jpg"));
			
			//add a container in Frame
			Container con=getContentPane();
			
			//setting font of labels
			price.setFont(new Font("arial",Font.ITALIC,15));
			price.setBorder(BorderFactory.createEtchedBorder(new Color(10,100,180),Color.yellow));
			
			//setting bounds of Components
			itemLabel.setBounds(65, 10,30 ,20);
			itemscrol.setBounds(30,30,140,360);
			idLabel.setBounds(190,35,50,10);
			id.setBounds(245,30,40,20);
			discripLabel.setBounds(190, 55, 70, 20);
			discripscrol.setBounds(190,80,150,150);
			priceLabel.setBounds(190,260,50,10);
			price.setBounds(260, 255, 50, 20);
			quantityLabel.setBounds(190, 295, 70, 10);
			quantity.setBounds(250, 290, 50, 20);
			addBasket.setBounds(190,320,130,30);
			viewBasket.setBounds(190,360,130,30);
			viewItemLabel.setBounds(400, 170, 140, 10);
			selectscrol.setBounds(390, 190, 150, 200);
			pic.setBounds(390, 10, 150, 150);
			removeItem.setBounds(415, 380, 100, 30);
			purchase.setBounds(190,400,130,30);
			about.setBounds(30,400,130,30);
			
			//adding components on container of frame
			con.add(itemLabel);
			con.add(itemscrol);
			con.add(idLabel);
			con.add(id);
			con.add(discripLabel);
			con.add(discripscrol);
			con.add(priceLabel);
			con.add(price);
			con.add(quantityLabel);
			con.add(quantity);
			con.add(addBasket);
			con.add(viewBasket);
			con.add(viewItemLabel);
			con.add(selectscrol);
			con.add(removeItem);
			con.add(pic);
			con.add(purchase);
			con.add(about);
			
			//register components with listeners
			itemlist.addListSelectionListener(this);
			selectList.addListSelectionListener(this);
			addBasket.addActionListener(this);
			viewBasket.addActionListener(this);
			removeItem.addActionListener(this);
			purchase.addActionListener(this);
			about.addActionListener(this);
			
			ItemsList();
			show();
		}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==itemlist){
			quantity.setText("");
			Item item=(Item) itemlist.getSelectedValue();
			if(item==null)return;
			id.setText(item.ID);
			discrip.setText(item.Discription);
			price.setText(item.price);
			pic.setIcon(new ImageIcon(item.picloc));
		}
		if(ob==selectList){
			Item item=(Item) selectList.getSelectedValue();
			if(item==null)return;
			id.setText(item.ID);
			discrip.setText(item.Discription);
			price.setText(item.price);
			pic.setIcon(new ImageIcon(item.picloc));
			quantity.setText(item.quantity);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==addBasket){ 
							if(quantity.getText().equals("")||quantity.getText()==null){ JOptionPane.showMessageDialog(this, "Quantity box is empty", "Requirement....", ICONIFIED, null); return; }
							obArray[++index]=itemlist.getSelectedValue();
							Item i=(Item)obArray[index];
							i.itemIndex=index;
							i.quantity=quantity.getText();
							
		}
		else if(ob==viewBasket){ selectList.setListData(obArray); }
		else if(ob==removeItem){ Object obj=selectList.getSelectedValue();
										Item i=(Item) obj;
										obArray[i.itemIndex]=null;
											}
		else if(ob==purchase){}
		if(ob==about){ JOptionPane.showMessageDialog(this, "Programed By: JAY KUMAR", "About...",HEIGHT, new ImageIcon("about.jpg"));	}
	}
	void ItemsList(){
		Item printer=new Item();
		Item scanner=new Item();
		Item mouse=new Item();
		Item webcame=new Item();
		Item keybord=new Item();
		Item mic=new Item();
		Item joystick=new Item();
		Item hardisk=new Item();
		Item speaker=new Item();
		Item woofer=new Item();
		
		printer.ID="1";
		printer.name="PRINTER";
		printer.Discription="HP DESKJET PRINTER\n MODEL NO: 1050 \n SCANNER WITH PHOTCOPY FACILTY\nTWO CARTAGE COLORED AND BLACK ARE FREE";
		printer.price="8000";
		printer.quantity="";
		printer.picloc="printer.png";
			
		scanner.ID="2";
		scanner.name="SCANNER";
		scanner.Discription="CONON \n MODEL: 5600f \n SCANNING WITH HIGH DEFINITION";
		scanner.price="5000";
		scanner.quantity="";
		scanner.picloc="scanner.png";
			
		mouse.ID="3";
		mouse.name="MOUSE";
		mouse.Discription="MICROSOFT\nLEZER MOUSE \nWITH USB PORT PIN";
		mouse.price="500";
		mouse.quantity="";
		mouse.picloc="mouse.png";
			
		keybord.ID="4";
		keybord.name="KEYBOARD";
		keybord.Discription="MULTIMEDIA KEYBOARD\n 1 YEAR WARENTY";
		keybord.price="1500";
		keybord.quantity="";
		keybord.picloc="keybord2.png";
			
		mic.ID="5";
		mic.name="M.I.C";
		mic.Discription="";
		mic.price="1000";
		mic.quantity="";
		mic.picloc="mic.png";
		
		webcame.ID="6";
		webcame.name="WEBCAME";
		webcame.Discription="DIGITECH\n HD WEBCAME\nMODEL: C525\nGLAMOUR IMAGE MD";
		webcame.price="2000";
		webcame.quantity="";
		webcame.picloc="webcam.png";
		
		joystick.ID="7";
		joystick.name="JOYSTICK";
		joystick.Discription="USB AND PS3 ATTACHMENT PINS \n1 YEAR WARENTY";
		joystick.price="2000";
		joystick.quantity="";
		joystick.picloc="joystick.png";
			
		hardisk.ID="8";
		hardisk.name="ADDITION HARDISK";
		hardisk.Discription="TOSHIBA \n HDD EXTERNAL \n 320 GB\n 1 YEAR WARRENTY";
		hardisk.price="10000";
		hardisk.quantity="";
		hardisk.picloc="hard.png";
		
		speaker.ID="9";
		speaker.name="SPEAKERS";
		speaker.Discription="";
		speaker.price="3000";
		speaker.quantity="";
		speaker.picloc="speakers.png";
		
		woofer.ID="10";
		woofer.name="WOOFERS";
		woofer.Discription="";
		woofer.price="5000";
		woofer.quantity="";
		woofer.picloc="woofers.png";
		
		v=new Vector();
		v.addElement(printer);
		v.addElement(scanner);
		v.addElement(mouse);
		v.addElement(keybord);
		v.addElement(mic);
		v.addElement(webcame);
		v.addElement(joystick);
		v.addElement(hardisk);
		v.addElement(speaker);
		v.addElement(woofer);
		
		itemlist.setListData(v);
		/*ID="1";
		name=
		Discription
		price=
		quanity=
		picloc=
			
		*/
	}
	public static void main(String arg[]){
		new e_Shop();
	}

}
