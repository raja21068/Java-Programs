
import java.awt.*;
import java.awt.event.*;
class Starlist implements ActionListener{

Frame win=new Frame("StarList");
Label row=new Label("Enter Row:");
Label patern=new Label("Enter Patern:");
TextField text1=new TextField(); 
TextField text2=new TextField();
Button result=new Button("Result");
Button about=new Button("About");
Button clear=new Button("Clear");
List l=new List();
Starlist(){
	win.setBackground(Color.pink);
	win.setLayout(null);
	win.setBounds(0,0,500,400);
	row.setBounds(320,50,100,50);
	text1.setBounds(320,100,100,25);
	text2.setBounds(320,200,100,25);
	clear.setBounds(300,250,70,25);
	about.setBounds(375,250,70,25);
	patern.setBounds(320,150,100,50);
	result.setBounds(345, 300, 100, 25);
	l.setBounds(30, 50,250, 300);
	win.setVisible(true);
	win.add(row);
	win.add(text1);
	win.add(text2);
	win.add(clear);
	win.add(about);
	win.add(patern);
	win.add(result);
	win.add(l);
	l.add("Jay Kumar");
	l.addActionListener(this);
	clear.addActionListener(this);
	about.addActionListener(this);
	result.addActionListener(this);
	
}

@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
	
	Object obj=e.getSource();	
	l.addActionListener(this);
	text1.addActionListener(this);
   if(obj==about){ 
	   
	   l.add("This program is of\nprinting stars with differnt style");}	
   if(obj==clear){ l.clear(); 
   text1.setText(null);
   text2.setText(null); }//end of clear
   
   if(obj==result){ String num=text1.getText();
         String num2=text2.getText();
         int i=Integer.parseInt(num);
         int p=Integer.parseInt(num2);
                 if(p==1){
                   for(int j=1;j<=i;j++){
	                   String str="";
                      for(int k=j;k>=1;k--){
    	                       str+="*";
                             }	//end of 2nd loop
		             l.add(str, j);
   	   
                          }//end of 1st loop
                }//end of 2nd if condition
 
   if(p==2){
	 for(int a=1;a<=i;a++){
         String str1="";
         for(int b=a;b<=i;b++){
        str1+="*";	 
         }
        
       l.add(str1, a);

            }//end of 1st loop	 
 }
   }//end of result if condition
   }//action perform
public static void main(String args[]){
	new Starlist();
}
}