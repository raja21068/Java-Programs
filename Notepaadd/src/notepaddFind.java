import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class notepaddFind extends JDialog implements ActionListener,KeyListener{
	JLabel l=new JLabel("Find what:");
	JButton findnext=new JButton("Find Next");
	JButton cancel=new JButton("Cancel");
	JTextField tf=new JTextField();
	JRadioButton rbu=new JRadioButton("Up");
	JRadioButton rbd=new JRadioButton("Down");
	JCheckBox cb =new JCheckBox("Match Case");
	ButtonGroup bg=new ButtonGroup();
	String s2;
	int i=1,loc=0,loc2,count=0;
	

	
	notepadd note;
	notepaddFind(notepadd n){
		bg.add(rbu);
		bg.add(rbd);
		note=n;
		setTitle("Find");
		setBounds(200,200,355,130);
		Font f=new Font("arial",Font.PLAIN,11);
		Container con=getContentPane();
		con.setLayout(null);
		
		l.setBounds(7, 13, 60, 10);
		l.setFont(f);
		con.add(l);
		tf.setBounds(60,10,190,22);
		con.add(tf);
		findnext.setBounds(265,10,80,20);
		findnext.setFont(f);
		con.add(findnext);
		cancel.setBounds(265,35,80,20);
		cancel.setFont(f);
		con.add(cancel);
		cb.setBounds(10,60,90,25);
		cb.setFont(f);
		con.add(cb);
		
		rbu.setBounds(160,60,40,25);
		rbu.setFont(f);
		con.add(rbu);
		rbd.setBounds(200,60,60,25);
		rbd.setFont(f);
		con.add(rbd);
		findnext.addActionListener(this);
		cancel.addActionListener(this);
		rbu.addActionListener(this);
		rbd.addActionListener(this);
		setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		if(ob==rbd){ i=1; System.out.println("Radio button down is selected"); }
		if(ob==rbu){ i=0; System.out.println("Radio button up is selected"); }
		
		if(ob==findnext){
			String s=tf.getText();
			s2=note.txt.getText();
			if(i==1){
				int h=s2.indexOf(s,loc);
				System.out.println(h); 
				if(h==-1){ JOptionPane.showMessageDialog(getParent(), "Not found"); }
				if(h>-1){ loc=h+1;
					note.txt.select(h,h+s.length());
				}
				}
			if(count==0){ loc2=s2.length()-1; }
			if(i==0){ int l=s2.lastIndexOf(s,loc2);
				System.out.println(l);
				if(l>-1){ loc2=l-1; count++; }
				else {JOptionPane.showMessageDialog(getParent(), "Not found");}
				}
			}//end of find next
		
		if(ob==cancel){ dispose(); }
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("typed");
		loc=0;
		loc2=s2.length()-1;
		
	}


	

}
