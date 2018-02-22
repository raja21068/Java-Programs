import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.IOException;
 class first extends Frame implements ActionListener{

	
	


	 TextField t1,t2;
	 int b;
	 Button show,clear,about;
	 Label l1,l2;
	// Frame f=new Frame("Petruns");
	 List n=new List();
	 int j;

	first(){
		
		
		
		
		
		
		
	
		
		
		
		
	
	setBounds(250, 100, 400, 600);
	setLayout(null);
	
	
	
	
	
	l1=new Label(" No Of Rows");
	l1.setBounds(275,50,100,50);
	add(l1);
	l2=new Label("Petrun Type");
	l2.setBounds(275,125,100,50);
	add(l2);
	about=new Button("About");
	about.setBounds(275,350,100,40);
	add(about);
	clear=new Button("Show");
	clear.setBounds(275,250,100,40);
	add(clear);
	show=new Button("Clear");
	show.setBounds(275,300,100,40);
	add(show);
	t1=new TextField();
	t1.setBounds(275,100,100,25);
	add(t1);
	t2=new TextField();
	t2.setBounds(275,175,100,25);
	add(t2);
	setBackground(Color.yellow);
	
	int style = Font.BOLD | Font.ITALIC;
	Font font = new Font ("Garamond", style , 20);
	Font font1 = new Font ("Garamond", style , 15);
	l1.setFont(font1);
	l2.setFont(font1);
	show.setFont(font);
	about.setFont(font);
	clear.setFont(font);
	show.setBackground(Color.red);
	about.setBackground(Color.red);
	clear.setBackground(Color.red);
	
	n.setFont(font);

	
	n.setBounds(25,50,225,500);
	
	add(n);
	
	show();
	n.addItem("salman");
	
	//
	show.addActionListener(this);
	about.addActionListener(this);
	clear.addActionListener(this);
	n.addActionListener(this);
	t1.addActionListener(this);
			
	}
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		 String str="";
		
		if(ob==clear){
			n.clear();
		}
	}

	



public static void main(String[] args){
	 first obj=new first();
}
 }
