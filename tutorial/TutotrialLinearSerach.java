import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class TutotrialLinearSerach extends JFrame implements ActionListener{

	JLabel s=new JLabel("Search Particular Item");
	JLabel defaultitem=new JLabel("Default Items");
	JLabel index=new JLabel("  0               1                2             3              4             5");
	JButton[] b=new JButton[6];
	JLabel enteritem=new JLabel("Enter item  which you want to search:");
	JTextField item=new JTextField();
	JLabel loc=new JLabel("Location:");
	JButton search=new JButton("search");
	JTextField l=new JTextField();
	Label check=new Label();
	Font font=new Font("arial",Font.BOLD,25);
	Font font2=new Font("arial",Font.BOLD,20);
	
	TutotrialLinearSerach(){
		Container con=getContentPane();
		setBounds(40,40,600,600);
		b[0]=new JButton("90");
		b[1]=new JButton("20");
		b[2]=new JButton("80");
		b[3]=new JButton("60");
		b[4]=new JButton("70");
		b[5]=new JButton("65");
		con.setLayout(null);
		s.setBounds(100, 20, 300, 30);
		s.setFont(font);
		defaultitem.setBounds(140, 60, 140, 20);
		defaultitem.setFont(font2);
		con.add(defaultitem);
		con.add(s);
		index.setBounds(110,90,400,20);
		con.add(index);
		b[0].setBounds(100,110,50,40);
		b[1].setBounds(150,110,50,40);
		b[2].setBounds(200,110,50,40);
		b[3].setBounds(250,110,50,40);
		b[4].setBounds(300,110,50,40);
		b[5].setBounds(350,110,50,40);
		con.add(b[0]);
		con.add(b[1]);
		con.add(b[2]);
		con.add(b[3]);
		con.add(b[4]);
		con.add(b[5]);
		enteritem.setBounds(100, 200, 220, 30);
		con.add(enteritem);
		item.setBounds(320, 200, 40, 30);
		con.add(item);
		search.setBounds(200,250,100,30);
		con.add(search);
		loc.setBounds(200, 300, 70, 30);
		con.add(loc);
		l.setBounds(275,300,50,30);
		con.add(l);
		con.add(check);
		search.addActionListener(this);
		show();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(search)){
			String s=item.getText();
			check.setText(s);
			try{
			for(int i=0,x=120;i<b.length;i++,x+=50){
				check.setBounds(x, 160, 20,20);
				if(b[i].getText().equals(s)){
					b[i].setBackground(Color.GREEN);
					l.setText(""+i);
					break;}
				Thread.sleep(1000);
				if(i==b.length-1){
					JOptionPane.showMessageDialog(null, "Item not found");
				}
			}//end of for
			}catch(Exception e1){}
		}//end of button search 
	}//end of action performed
	
	public static void main(String[] args) {
		new TutotrialLinearSerach();
	}

}
