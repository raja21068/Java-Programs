import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TutorialSearchSmallest extends JFrame implements ActionListener {

	JLabel s=new JLabel("Search Particular Item");
	JLabel defaultitem=new JLabel("Default Items");
	JLabel index=new JLabel("  0               1                2             3              4             5");
	JButton[] b=new JButton[6];
	JLabel loc=new JLabel("Location:");
	JButton search=new JButton("search smallest");
	JButton search2=new JButton("search largest");
	JButton rand=new JButton("random");	
	JTextField l=new JTextField();
	Label check=new Label();
	int[] array={90,20,80,60,70,65};
	JTextField item=new JTextField();
	JLabel i=new JLabel("Item");
	Font font=new Font("arial",Font.BOLD,25);
	Font font2=new Font("arial",Font.BOLD,20);
	
	
	TutorialSearchSmallest(){
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
		search.setBounds(100,200,130,30);
		con.add(search);
		search2.setBounds(240, 200, 130, 30);
		con.add(search2);
		rand.setBounds(200, 350, 100, 30);
		con.add(rand);
		loc.setBounds(200, 300, 70, 30);
		con.add(loc);
		l.setBounds(275,300,50,30);
		con.add(l);
		con.add(check);
		item.setBounds(270,250,45,35);
		con.add(item);
		i.setBounds(200, 250, 40, 30);
		con.add(i);
		search.addActionListener(this);
		rand.addActionListener(this);
		search2.addActionListener(this);
		show();
	}
	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		if(ob==rand){
			for(int i=0;i<b.length;i++){
				double c=Math.random()*100;
				int a=(int)c;
				b[i].setText(""+a);
				array[i]=a;
			}
		}//end of random button
		
		if(ob==search){
			int temp=array[0];
			int location=0;
			try{
			for(int i=0,x=120;i<b.length;i++,x+=50){			
				check.setText(""+temp);
				check.setBounds(x, 160,20,20);
				if(temp>array[i]){
					temp=array[i];
					location=i;
				}	
			Thread.sleep(1000);	
			}}catch(Exception e1){}
				l.setText(""+location);	
				item.setText(""+temp);
		}//end of button smallest search
	
		if(ob==search2){
			int temp=array[0];
			int location=0;
			try{
			for(int i=0,x=120;i<b.length;i++,x+=50){			
				check.setText(""+temp);
				check.setBounds(x, 160,20,20);
				if(temp<array[i]){
					temp=array[i];
					location=i;
				}	
			Thread.sleep(1000);	
			}}catch(Exception e1){}
				l.setText(""+location);	
			item.setText(""+temp);
		}//end of button largest search
	}

	public static void main(String[] args) {
		new TutorialSearchSmallest();
	}

}
