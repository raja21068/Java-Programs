import java.awt.*;
import java.awt.event.*;



class  TestAction1 implements ActionListener{
	Frame win=new Frame("Calculator");
	Label l1=new Label("Edit");
	Label l2=new Label("View");
	Label l3=new Label("Help");
	TextField t1=new TextField();
	TextField t2=new TextField();
	TextField t3=new TextField();
	Button b1=new Button("Backspace");
	Button b2=new Button("CE");
	Button b3=new Button("C");
	Button b4=new Button("MC");
	Button b5=new Button("7");
	Button b6=new Button("8");
	Button b7=new Button("9");
	Button b8=new Button("/");
	Button b9=new Button("sqrt");
	Button b10=new Button("MR");
	Button b11=new Button("4");
	Button b12=new Button("5");
	Button b13=new Button("6");
	Button b14=new Button("*");
	Button b15=new Button("%");
	Button b16=new Button("MS");
	Button b17=new Button("1");
	Button b18=new Button("2");
	Button b19=new Button("3");
	Button b20=new Button("-");
	Button b21=new Button("1/x");
	Button b22=new Button("M+");
	Button b23=new Button("0");
	Button b24=new Button("+/-");
	Button b25=new Button(".");
	Button b26=new Button("+");
	Button b27=new Button("=");



  

   TestAction1(){
     win.setLayout(null);
     
     l1.setBounds(5, 35, 30, 10);
		l2.setBounds(35, 35, 30, 10);
		l3.setBounds(65, 35, 30, 13);
		t1.setBounds(10, 50, 73,25);
		t2.setBounds(93, 50, 73,25);
		t3.setBounds(176, 50, 73,25);
		b1.setBounds(50, 90, 70, 25);
		b2.setBounds(125, 90, 60, 25);
		b3.setBounds(190, 90, 60, 25);
		b4.setBounds(10, 125, 30, 25);
		b5.setBounds(60, 125, 30, 25);
		b6.setBounds(100, 125, 30, 25);
		b7.setBounds(140, 125, 30, 25);
		b8.setBounds(180, 125, 30, 25);
		b9.setBounds(220, 125, 30, 25);
		b10.setBounds(10, 155, 30, 25);
		b11.setBounds(60, 155, 30, 25);
		b12.setBounds(100, 155, 30, 25);
		b13.setBounds(140, 155, 30, 25);
		b14.setBounds(180, 155, 30, 25);
		b15.setBounds(220, 155, 30, 25);
		b16.setBounds(10, 185, 30, 25);
		b17.setBounds(60, 185, 30, 25);
		b18.setBounds(100, 185, 30, 25);
		b19.setBounds(140, 185, 30, 25);
		b20.setBounds(180, 185, 30, 25);
		b21.setBounds(220, 185, 30, 25);
		b22.setBounds(10, 215, 30, 25);
		b23.setBounds(60, 215, 30, 25);
		b24.setBounds(100, 215, 30, 25);
		b25.setBounds(140, 215, 30, 25);
		b26.setBounds(180, 215, 30, 25);
		b27.setBounds(220, 215, 30, 25);
		
		
		win.add(b1);
   	    win.add(b2);
   	    win.add(b3);
		win.add(b4);
		win.add(b5);
		win.add(b6);
		win.add(b7);
		win.add(b8);
		win.add(b9);
		win.add(b10);
		win.add(b11);
		win.add(b12);
		win.add(b13);
		win.add(b14);
		win.add(b15);
		win.add(b16);
		win.add(b17);
		win.add(b18);
		win.add(b19);
		win.add(b20);
		win.add(b21);
		win.add(b22);
		win.add(b23);
		win.add(b24);
		win.add(b25);
		win.add(b26);
		win.add(b27); 
		win.add(l1);
		win.add(l2);
		win.add(l3);
		win.add(t1);
		win.add(t2);
		win.add(t3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
		b26.addActionListener(this);
		b27.addActionListener(this);
		t1.addActionListener(this);
		l1.addKeyListener(null);
		l2.addKeyListener(null);
		l3.addKeyListener(null);
     
		
		
		
		
		
		

   
    

     win.setBounds(375,250,260,250);
     win.setVisible(true);
   }


   public void actionPerformed(ActionEvent e){

    Object ob=e.getSource();
    String str="7";
    int a=Integer.parseInt(t1.getText());
    int b=Integer.parseInt(t2.getText());

    if(ob==b1)t1.setText(""+(a+b));
    if(ob==b2)t1.setText(""+(a-b));
    if(ob==b3)t3.setText(""+(a*b));
    if(ob==b4)t1.setText(""+(a/b));
    if(ob==b5)t1.setText(str);
    if(ob==b6)t1.setText(""+(a+b));
    if(ob==b7)t1.setText(""+(a-b));
    if(ob==b8)t1.setText(""+(a*b));
    if(ob==b9)t3.setText(""+(a*a));
    if(ob==b10)t1.setText(""+(a%b));
    if(ob==b11)t1.setText(""+(a+b));
    if(ob==b12)t1.setText(""+(a-b));
    if(ob==b13)t1.setText(""+(a*b));
    if(ob==b14)t3.setText(""+(a*b));
    if(ob==b15)t1.setText(""+(a%b));
    if(ob==b16)t1.setText(""+(a+b));
    if(ob==b17)t1.setText(""+(a-b));
    if(ob==b18)t1.setText(""+(a*b));
    if(ob==b19)t1.setText(""+(a/b));
    if(ob==b20)t1.setText(""+(a%b));
    if(ob==b21)t1.setText(""+(a+b));
    if(ob==b22)t1.setText(""+(a-b));
    if(ob==b23)t1.setText(""+(a*b));
    if(ob==b24)t1.setText(""+(a/b));
    if(ob==b25)t1.setText(""+(a%b));
    if(ob==b26)t3.setText(""+(a+b));
    if(ob==b27)t1.setText(""+(a+b));
    if(ob==l1)t1.setText(""+(a-b));
    if(ob==l2)t1.setText(""+(a*b));
    if(ob==l3)t1.setText(""+(a/b));
    

   }
  

   public static void main(String arg[]){
       TestAction1 obj=new TestAction1();
   }



}
