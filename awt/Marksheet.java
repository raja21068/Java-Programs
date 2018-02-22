import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Marksheet extends Frame implements ActionListener{
	Label title=new Label("MARKS SHEET");
	Font font=new Font("Lucida Calligraphy",Font.BOLD,30);
	Label jm=new Label("Enter java marks");
	TextField jmtext=new TextField();
	Label cm=new Label("Enter C Marks");
	TextField cmtext=new TextField();
	Label phpm=new Label("Enter PHP marks  ");
	TextField phptext=new TextField();
	Label om=new Label("Enter Oracle marks  ");
	TextField otext=new TextField();
	Label am=new Label("Enter Aseembly marks  ");
	TextField atext=new TextField();
	Label obtainm=new Label("Enter Obtained marks  ");
	TextField obtaintext=new TextField();
	Label totalm=new Label("Total marks:                    500  ");
	Label per=new Label("Percentage ");
	TextField pertext=new TextField();
	Label grade=new Label("Grade");
	TextField gradetext=new TextField();
	Button about=new Button("About");
	Button cal=new Button("Calculate");
	Button clear=new Button("Clear");

	Marksheet(){	
setBounds(0,0,500,500); 
	title.setFont(font);
 title.setBounds(60, 40, 250, 25);
 title.setBackground(Color.LIGHT_GRAY);
 add(title);
 setLayout(null);
    jm.setBounds(60,80,100,25);
	add(jm);
	jmtext.setBounds(180, 80, 80, 25);
	add(jmtext);
	cm.setBounds(60,110,100,25);
	add(cm);
	cmtext.setBounds(180, 110, 80, 25);
	add(cmtext);
	phpm.setBounds(60,140,100,25);
	add(phpm);
	phptext.setBounds(180, 140, 80, 25);
	add(phptext);
	om.setBounds(60,170,110,25);
	add(om);
	otext.setBounds(180, 170, 80, 25);
	add(otext);
	am.setBounds(60,200,120,25);
	add(am);
	atext.setBounds(180, 200, 80, 25);
	add(atext);
	obtainm.setBounds(60, 280, 120, 25);
	add(obtainm);
	obtaintext.setBounds(180, 280, 80, 25);
	add(obtaintext);
	totalm.setBounds(60, 310, 150, 25);
	add(totalm);
	per.setBounds(60, 340, 80, 25);
	add(per);
	pertext.setBounds(180, 340, 80, 25);
	add(pertext);
	grade.setBounds(60, 370, 80, 25);
	add(grade);
	gradetext.setBounds(180, 370, 80, 25);
	add(gradetext);
	about.setBounds(60, 400, 70, 25);
	add(about);
	cal.setBounds(130, 400, 80, 25);
	add(cal);
	clear.setBounds(210, 400, 70, 25);
	add(clear);
	clear.addActionListener(this);
	cal.addActionListener(this);
	about.addActionListener(this);
	show();}
	
	public void actionPerformed(ActionEvent e) {
	Object ob=e.getSource();
	if(ob==about){
		JOptionPane.showMessageDialog(null,"This is software of marks sheet..! \nBy: Jay Kumar");
	             }
	if(ob==cal){
		String str="";
		int a=Integer.parseInt(jmtext.getText());
		int b=Integer.parseInt(cmtext.getText());
		int c=Integer.parseInt(phptext.getText());
		int d=Integer.parseInt(otext.getText());
		int f=Integer.parseInt(atext.getText());
		obtaintext.setText(""+(a+b+c+d+f));
		float percentage=(float)(a+b+c+d+f)/500*100;
		pertext.setText(""+percentage);
		if(percentage<40){ str="FAIL"; }
		else	if(percentage<50){ str="E"; }
		else	if(percentage<60){ str="D"; }
		else	if(percentage<70){ str="C"; }
		else	if(percentage<80){ str="B"; }
		else	if(percentage<90){ str="A"; }
		else { str="A-1"; }
		gradetext.setText(str);
	}
	if(ob==clear){
		jmtext.setText(null);
		cmtext.setText(null);
		phptext.setText(null);
		otext.setText(null);
		atext.setText(null);
		atext.setText(null);
		obtaintext.setText(null);
		pertext.setText(null);
		gradetext.setText(null);
	}
	}//end of action perform
public static void main(String arg[]){
	new Marksheet();
}//end of main method
}
