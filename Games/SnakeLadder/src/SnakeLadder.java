import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

public class SnakeLadder extends JFrame implements ActionListener{
JLabel back=new JLabel(new ImageIcon("Snakeback.jpg"));
ImageIcon jug1=new ImageIcon("jug.png");
JLabel goti=new JLabel(new ImageIcon("goti.png"));
JLabel goti2=new JLabel(new ImageIcon("goti2.png"));
JLabel dice1=new JLabel(new ImageIcon("1.png"));
JLabel dice2=new JLabel(new ImageIcon("2.png"));
JLabel dice3=new JLabel(new ImageIcon("3.png"));
JLabel dice4=new JLabel(new ImageIcon("4.png"));
JLabel dice5=new JLabel(new ImageIcon("5.png"));
JLabel dice6=new JLabel(new ImageIcon("6.png"));
int player=1;
static int ladder1=0,ladder2=0;
int x1=20,x2=20,y1=600,y2=600,count1=0,count2=0;;
JButton j1;

	SnakeLadder(){
		Container con=getContentPane();
		j1=new JButton(jug1);
		setBounds(0,0,900,750);
		goti.setBounds(x1,y1,40,27);
		con.add(goti);
		goti2.setBounds(x2,y2,40,27);
		con.add(goti2);
		dice1.setBounds(700, 660, 50,50);
		con.add(dice1);
		dice2.setBounds(700, 660, 50,50);
		con.add(dice2);
		dice3.setBounds(700, 660, 50,50);
		con.add(dice3);
		dice4.setBounds(700, 660, 50,50);
		con.add(dice4);
		dice5.setBounds(700, 660, 50,50);
		con.add(dice5);
		dice6.setBounds(700, 660, 50,50);
		con.add(dice6);
		j1.setBounds(850, 660, 30, 35);
		con.add(j1);
		back.setBounds(20,20,800,800);
		con.add(back);
		j1.addActionListener(this);
		dice1.hide();
		dice2.hide();
		dice3.hide();
		dice4.hide();
		dice5.hide();
		dice6.hide();
		con.setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		show();
	}
	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		dice1.hide();
		dice2.hide();
		dice3.hide();
		dice4.hide();
		dice5.hide();
		dice6.hide();
		double b=Math.random()*6+1;
		int a=(int)b;
		System.out.println(a);
		if(ob==j1){
			try{DiceSound(); Thread.sleep(3000); }catch(Exception e1){}
		if(a==1){ dice1.show(); }
		if(a==2){ dice2.show(); }
		if(a==3){ dice3.show(); }
		if(a==4){ dice4.show(); }
		if(a==5){ dice5.show(); }
		if(a==6){ dice6.show();  }
		}//end of button1
	
		if(player==1){
			if(a!=6)player=2;
			if(count1<=100)count1+=a;
			 System.out.println("Player 1:" +count1); //TODO
			if(count1==13){ try{count1=34; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==21){ try{count1=42; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==62){ try{count1=79; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==73){ try{count1=94; Thread.sleep(1000); }catch(Exception e1){} }
			
			if(count1==38){ try{count1=16; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==51){ try{count1=33; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==64){ try{count1=46; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1==96){ try{count1=78; Thread.sleep(1000); }catch(Exception e1){} }
			if(count1<=10){ x1+=a*75; }
			else if(count1>10 && count1<21){ a=count1-10; x1=750;  x1-=(a-1)*75; y1=560; }
			else if(count1>20 && count1<31){ a=count1-20; x1=20; x1+=a*75; y1=500; }
			else if(count1>30 && count1<41){ a=count1-30; x1=750;  x1-=(a-1)*75; y1=440; }
			else if(count1>40 && count1<51){ a=count1-40; x1=20; x1+=a*75; y1=380; }
			else if(count1>50 && count1<61){ a=count1-50; x1=750;  x1-=(a-1)*75; y1=320; }
			else if(count1>60 && count1<71){ a=count1-60; x1=20; x1+=a*75; y1=260; }
			else if(count1>70 && count1<81){ a=count1-70; x1=750;  x1-=(a-1)*75; y1=200; }
			else if(count1>80 && count1<91){ a=count1-80; x1=20; x1+=a*75; y1=140; }
			else if(count1>90 && count1<100){ a=count1-90; x1=750;  x1-=(a-1)*75; y1=80; }
			else if(count1==100){JOptionPane.showMessageDialog(null,"PLAYER 1 WIN..");}
			goti.setBounds(x1,y1,40,27);
			 }//end of player1
		
		else if(player==2){  
			if(a!=6){player=1;}
			if(count2<=100)count2+=a;
			System.out.println("Player 1:" +count2); //TODO
			if(count2==13){ try{count2=34; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==21){ try{count2=42; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==62){ try{count2=79; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==73){ try{count2=94; Thread.sleep(1000); }catch(Exception e1){} }
			
			if(count2==38){ try{count2=16; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==51){ try{count2=33; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==64){ try{count2=46; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2==96){ try{count2=78; Thread.sleep(1000); }catch(Exception e1){} }
			if(count2<=10){ x2+=a*75; }
			else if(count2>10 && count2<21){ a=count2-10; x2=750; x2-=(a-1)*75; y2=560; }
			else if(count2>20 && count2<31){ a=count2-20; x2=20; x2+=a*75; y2=500; }
			else if(count2>30 && count2<41){ a=count2-30; x2=750; x2-=(a-1)*75; y2=440; }
			else if(count2>40 && count2<51){ a=count2-40; x2=20; x2+=a*75; y2=380; }
			else if(count2>50 && count2<61){ a=count2-50; x2=750; x2-=(a-1)*75; y2=320; }
			else if(count2>60 && count2<71){ a=count2-60; x2=20; x2+=a*75; y2=260; }
			else if(count2>70 && count2<81){ a=count2-70; x2=750; x2-=(a-1)*75; y2=200; }
			else if(count2>80 && count2<91){ a=count2-80; x2=20; x2+=a*75; y2=140; }
			else if(count2>90 && count2<100){ a=count2-90; x2=750; x2-=(a-1)*75; y2=80; }
			else if(count2==100){ JOptionPane.showMessageDialog(null,"PLAYER 2 WIN.."); }
			else if(count2>100){count2-=a;}
			goti2.setBounds(x2,y2,40,27);
			}//end of player2
	}//end of action performed
	void DiceSound()throws Exception{
		AudioClip clip=Applet.newAudioClip(new File("dicesound.wav").toURL());
		clip.play();
	}
	
	public static void main(String[] args) {
		new SnakeLadder();
	}

}
