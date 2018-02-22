import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Hesco extends Frame implements ActionListener{
		Label unit=new Label("Enter units");
		Label unitcharge=new Label("Unit Charge");
		Label total=new Label("Total Money:");
		TextField money=new TextField();

		Button cal=new Button("Calculator");
TextField unittext=new TextField();
Font font=new Font("arial",Font.ITALIC,17);
Button about=new Button("About");
Button clear=new Button("Clear");
List list=new List();
Hesco(){
	setLayout(null);
	setBounds(0, 0, 400, 200);
	list.addItem("       1-100 x 2");
	list.addItem("    101-200 x 4");
	list.addItem("    201-300 x 6");
	list.addItem("    301-400 x 8");
	list.addItem("above 400 x 10");
	unit.setBounds(250,50, 100,25);
	unit.setFont(font);
	unit.setBackground(Color.orange);
	unitcharge.setFont(font);
	unitcharge.setBounds(50, 50, 100, 25);
	unittext.setBounds(250, 80, 100, 25);
	cal.setBounds(250, 105, 100, 25);
	clear.setBounds(250, 130, 100, 25);
	about.setBounds(250, 155, 100, 25);
	list.setBounds(40, 77, 150, 80);
	total.setBounds(30, 163, 70, 25);
	money.setBounds(110, 163, 60, 25);
	add(money);
	add(total);
	add(list);
	add(unitcharge);
	add(about);
	add(clear);
	add(cal);
	add(unit);
	add(unittext);
	cal.addActionListener(this);
	clear.addActionListener(this);
	about.addActionListener(this);
	show();
}
	@Override
	public void actionPerformed(ActionEvent e) {
	Object ob=e.getSource();
	if(ob==clear){
		unittext.setText(null);
		money.setText(null);
	}//end of clear button
	if(ob==about){
		JOptionPane.showMessageDialog(null, "This program is a HESCO bill calculator...!");
	}//end of about button
if(ob==cal){
	int u=Integer.parseInt(unittext.getText());
	int m;
	if(u<100){ m=u*2;}
	else if(u<200){ m=(u*4)-200; }
	else if(u<300){ m=(u*6)-600; }
	else if(u<400){ m=(u*8)-1200; }
	else{ m=(u*10)-2000; }
	money.setText(""+m);
}//end of calculation..
	}//end of action performed
public static void main(String arg[]){
	new Hesco();
}
}
