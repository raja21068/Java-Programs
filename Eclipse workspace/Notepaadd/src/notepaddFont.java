import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import javax.swing.

class notepaddFont extends JDialog implements ListSelectionListener,ActionListener {
	
	JLabel lab=new JLabel("Font:                                       Font Style:                       Size:");
	JTextField f1=new JTextField();
	JTextField f2=new JTextField();
	JTextField f3=new JTextField();
	JList l1=new JList();
	JList l2=new JList();
	JList l3=new JList();	
	JScrollPane p1=new JScrollPane(l1);
	JScrollPane p2=new JScrollPane(l2);
	JScrollPane p3=new JScrollPane(l3);
	JButton fontok=new JButton("Ok");
	JButton fontcancel=new JButton("Cancel");
	JLabel fonttf=new JLabel();
	JLabel fonttf2=new JLabel();
	JComboBox combo=new JComboBox();
	
	int s5,s4; String s1;
	
		notepadd note;
		notepaddFont(notepadd n){
		super(n,true);
		note=n;
		Container con=getContentPane();
		
		setBounds(200,200,430,360);
		setTitle("Font");
		con.setLayout(null);
		Font f=new Font("arial",Font.PLAIN,11);
		
		lab.setBounds(10, 10, 300, 10);
		lab.setFont(f);
		con.add(lab);
		
		f1.setBounds(10, 23, 134, 20);
		con.add(f1);
		
		f2.setBounds(150, 23, 114, 20);
		con.add(f2);
		
		f3.setBounds(270, 23,59 , 20);
		con.add(f3);
		
		p1.setBounds(10, 44, 134, 90);
		con.add(p1);
		
		p2.setBounds(150, 44, 114, 90);
		con.add(p2);
		
		p3.setBounds(270, 44, 59, 90);
		con.add(p3);
		
		fontok.setBounds(342, 25, 67, 21);
		fontok.setFont(f);
		con.add(fontok);
		
		fontcancel.setBounds(342, 50, 67, 21);
		fontcancel.setFont(f);
		con.add(fontcancel);
		
		fonttf2.setBounds(120, 160, 200, 100);
		con.add(fonttf2);
		fonttf.setBounds(140, 180, 160, 60);
		con.add(fonttf);
		
		combo.setBounds(100, 280, 100, 20);
		con.add(combo);
		
		fonttf.setBorder(BorderFactory.createLoweredBevelBorder());
		fonttf2.setBorder(BorderFactory.createTitledBorder("Sample"));
		fontok.addActionListener(this);
		fontcancel.addActionListener(this);
		l1.addListSelectionListener(this);
		l2.addListSelectionListener(this);
		l3.addListSelectionListener(this);
		fontsize();
		fontstyle();
		fonttype();
		setResizable(false);
		
	}
	void fontsize(){ 
		Vector vs=new Vector();
		vs.addElement("8");
		vs.addElement("9");
		vs.addElement("10");
		vs.addElement("11");
		vs.addElement("12");
		vs.addElement("14");
		vs.addElement("16");
		vs.addElement("18");
		vs.addElement("20");
		vs.addElement("22");
		vs.addElement("24");
		vs.addElement("26");
		vs.addElement("28");
		vs.addElement("36");
		vs.addElement("48");
		vs.addElement("72");
		l3.setListData(vs);
	}
	
	void fontstyle(){
		Vector vst=new Vector();
		vst.addElement("Regular");
		vst.addElement("Bold");
		vst.addElement("Bold");
		vst.addElement("Regular");
		l2.setListData(vst);
	}
	
	void fonttype(){
		String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		Vector vft=new Vector();
		for(int i=0;i<fonts.length;i++){
			vft.addElement(fonts[i]);
		}
		l1.setListData(vft);
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		s1=(String) l1.getSelectedValue();
		if(s1==null){s1="arial";}
		f1.setText(s1);
		
		String s2=(String) l2.getSelectedValue();
		f2.setText(s2);
		if(s2==null||s2.equals("Regular")){s2="4";}
		if(s2.equals("Bold")){ s2="1"; }
		if(s2.equals("Regular")){ s2="2"; }
		if(s2.equals("Bold")){s2="3";}
		s4=Integer.parseInt(s2);
		
		String s3=(String) l3.getSelectedValue();
		f3.setText(s3);
		if(s3==null){s3="12";}
		s5=Integer.parseInt(s3);
		
		fonttf.setFont(new Font("",s4,s5));
		String s="\u0621 \u0628 \u0686";
		fonttf.setText(s);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==fontok){ note.txt.setFont(new Font("",s4,s5)); dispose(); }
		if(ob==fontcancel){ dispose(); }
		
	}
		
}//end of class

