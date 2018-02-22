import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
class Puzzle extends JFrame implements ActionListener{
JButton b[]=new JButton[16];
MenuBar bar=new MenuBar();
Menu option=new Menu("Option");
MenuItem newgame=new MenuItem("New Game");

Puzzle(){
		Container con=getContentPane();
		setBounds(0,0,500,500);
		setMenuBar(bar);
		bar.add(option);
		option.add(newgame);
		con.setLayout(new GridLayout(4,4));
		setTitle("Puzzle");
		b[0]=new JButton("2");
		b[1]=new JButton("3");
		b[2]=new JButton("15");
		b[3]=new JButton("13");
		b[4]=new JButton("14");
		b[5]=new JButton("12");
		b[6]=new JButton("5");
		b[7]=new JButton("9");
		b[8]=new JButton("1");
		b[9]=new JButton("10");
		b[10]=new JButton("11");
		b[11]=new JButton("4");
		b[12]=new JButton("8");
		b[13]=new JButton("7");
		b[14]=new JButton("6");
		b[15]=new JButton("");

		con.add(b[0]);
		con.add(b[1]);
		con.add(b[2]);
		con.add(b[3]);
		con.add(b[4]);
		con.add(b[5]);
		con.add(b[6]);
		con.add(b[7]);
		con.add(b[8]);
		con.add(b[9]);
		con.add(b[10]);
		con.add(b[11]);
		con.add(b[12]);
		con.add(b[13]);
		con.add(b[14]);
		con.add(b[15]);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		b[9].addActionListener(this);
		b[10].addActionListener(this);
		b[11].addActionListener(this);
		b[12].addActionListener(this);
		b[13].addActionListener(this);
		b[14].addActionListener(this);
		b[15].addActionListener(this);
		newgame.addActionListener(this);
		
		show();
	}

	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		if(ob==newgame){
			int index;
			String s=new String();
			int a;
			double c;
			for(int i=0;i<15;){
			c=Math.random()*20;
			a=(int)c+1;
			index=s.indexOf(" "+a+" ");
			
			System.out.println(s+" its index: "+index);
			if(index==-1 && a<16){
				s+=" "+a+" ";
				b[i].setText(""+a);
				System.out.println(s);
				i++; }
			}
			b[15].setText("");
		}//end of new game********************************8
		if(ob==b[0]){
			if(b[1].getText().equals("")){
				String s=b[0].getText();
				b[0].setText("");
				b[1].setText(s);
			}
			if(b[4].getText().equals("")){
				String s=b[0].getText();
				b[0].setText("");
				b[4].setText(s);
			}
			
		}//end of condition of button 1
//***********************************************************************		
		if(ob==b[1]){
			if(b[2].getText().equals("")){
				String s=b[1].getText();
				b[1].setText("");
				b[2].setText(s);
			}
			if(b[5].getText().equals("")){
				String s=b[1].getText();
				b[1].setText("");
				b[5].setText(s);
			}
			if(b[0].getText().equals("")){
				String s=b[1].getText();
				b[1].setText("");
				b[0].setText(s);
			}
			
		}//end of condition of button 2
//***************************************************************************		
		if(ob==b[2]){
			if(b[1].getText().equals("")){
				String s=b[2].getText();
				b[2].setText("");
				b[1].setText(s);
			}
			if(b[3].getText().equals("")){
				String s=b[2].getText();
				b[2].setText("");
				b[3].setText(s);
			}
			if(b[6].getText().equals("")){
				String s=b[2].getText();
				b[2].setText("");
				b[6].setText(s);
			}
			
		}//end of condition of button 3
//****************************************************************************		
		if(ob==b[3]){
			if(b[2].getText().equals("")){
				String s=b[3].getText();
				b[3].setText("");
				b[2].setText(s);
			}
			if(b[7].getText().equals("")){
				String s=b[3].getText();
				b[3].setText("");
				b[7].setText(s);
			}
			
		}//end of condition of button 4
//****************************************************************************		
		if(ob==b[4]){
			if(b[0].getText().equals("")){
				String s=b[4].getText();
				b[4].setText("");
				b[0].setText(s);
			}
			if(b[5].getText().equals("")){
				String s=b[4].getText();
				b[4].setText("");
				b[5].setText(s);
			}
			if(b[8].getText().equals("")){
				String s=b[4].getText();
				b[4].setText("");
				b[8].setText(s);
			}
			
		}//end of condition of button 5
//****************************************************************************		
		if(ob==b[5]){
			if(b[1].getText().equals("")){
				String s=b[5].getText();
				b[5].setText("");
				b[1].setText(s);
			}
			if(b[4].getText().equals("")){
				String s=b[5].getText();
				b[5].setText("");
				b[4].setText(s);
			}
			if(b[6].getText().equals("")){
				String s=b[5].getText();
				b[5].setText("");
				b[6].setText(s);
			}
			if(b[9].getText().equals("")){
				String s=b[5].getText();
				b[5].setText("");
				b[9].setText(s);
			}
		}//end of condition of button 6
//**************************************************************************		
		if(ob==b[6]){
			if(b[2].getText().equals("")){
				String s=b[6].getText();
				b[6].setText("");
				b[2].setText(s);
			}
			if(b[5].getText().equals("")){
				String s=b[6].getText();
				b[6].setText("");
				b[5].setText(s);
			}
			if(b[7].getText().equals("")){
				String s=b[6].getText();
				b[6].setText("");
				b[7].setText(s);
			}
			if(b[10].getText().equals("")){
				String s=b[6].getText();
				b[6].setText("");
				b[10].setText(s);
			}
		}//end of condition of button 7
//**************************************************************************		
		if(ob==b[7]){
			if(b[3].getText().equals("")){
				String s=b[7].getText();
				b[7].setText("");
				b[3].setText(s);
			}
			if(b[6].getText().equals("")){
				String s=b[7].getText();
				b[7].setText("");
				b[6].setText(s);
			}
			if(b[11].getText().equals("")){
				String s=b[7].getText();
				b[7].setText("");
				b[11].setText(s);
			}
		}//end of condition of button 8
//**************************************************************************		
		if(ob==b[8]){
			if(b[4].getText().equals("")){
				String s=b[8].getText();
				b[8].setText("");
				b[4].setText(s);
			}
			if(b[9].getText().equals("")){
				String s=b[8].getText();
				b[8].setText("");
				b[9].setText(s);
			}
			if(b[12].getText().equals("")){
				String s=b[8].getText();
				b[8].setText("");
				b[12].setText(s);
			}
		}//end of condition of button 9
//**************************************************************************		
		if(ob==b[9]){
			if(b[5].getText().equals("")){
				String s=b[9].getText();
				b[9].setText("");
				b[5].setText(s);
			}
			if(b[8].getText().equals("")){
				String s=b[9].getText();
				b[9].setText("");
				b[8].setText(s);
			}
			if(b[10].getText().equals("")){
				String s=b[9].getText();
				b[9].setText("");
				b[10].setText(s);
			}
			if(b[13].getText().equals("")){
				String s=b[9].getText();
				b[9].setText("");
				b[13].setText(s);
			}
		}//end of condition of button 10
//**************************************************************************		
		if(ob==b[10]){
			if(b[6].getText().equals("")){
				String s=b[10].getText();
				b[10].setText("");
				b[6].setText(s);
			}
			if(b[9].getText().equals("")){
				String s=b[10].getText();
				b[10].setText("");
				b[9].setText(s);
			}
			if(b[11].getText().equals("")){
				String s=b[10].getText();
				b[10].setText("");
				b[11].setText(s);
			}
			if(b[14].getText().equals("")){
				String s=b[10].getText();
				b[10].setText("");
				b[14].setText(s);
			}
						
		}//end of condition of button 11
//**************************************************************************		
		if(ob==b[11]){
			if(b[7].getText().equals("")){
				String s=b[11].getText();
				b[11].setText("");
				b[7].setText(s);
			}
			if(b[10].getText().equals("")){
				String s=b[11].getText();
				b[11].setText("");
				b[10].setText(s);
			}
			if(b[15].getText().equals("")){
				String s=b[11].getText();
				b[11].setText("");
				b[15].setText(s);
			}
		}//end of condition of button 12
//**************************************************************************		
		if(ob==b[12]){
			if(b[8].getText().equals("")){
				String s=b[12].getText();
				b[12].setText("");
				b[8].setText(s);
			}
			if(b[13].getText().equals("")){
				String s=b[12].getText();
				b[12].setText("");
				b[13].setText(s);
			}
		}//end of condition of button 13
//**************************************************************************		
		if(ob==b[13]){
			if(b[9].getText().equals("")){
				String s=b[13].getText();
				b[13].setText("");
				b[9].setText(s);
			}
			if(b[12].getText().equals("")){
				String s=b[13].getText();
				b[13].setText("");
				b[12].setText(s);
			}
			if(b[14].getText().equals("")){
				String s=b[13].getText();
				b[13].setText("");
				b[14].setText(s);
			}
		}//end of condition of button 14
//**************************************************************************		
		if(ob==b[14]){
			if(b[13].getText().equals("")){
				String s=b[14].getText();
				b[14].setText("");
				b[13].setText(s);
			}
			if(b[15].getText().equals("")){
				String s=b[14].getText();
				b[14].setText("");
				b[15].setText(s);
			}
			if(b[10].getText().equals("")){
				String s=b[14].getText();
				b[14].setText("");
				b[10].setText(s);
			}
			}//end of condition of button 15
//*****************************************************************************		
		if(ob==b[15]){
			if(b[11].getText().equals("")){
				String s=b[15].getText();
				b[15].setText("");
				b[11].setText(s);
			}
			if(b[14].getText().equals("")){
				String s=b[15].getText();
				b[15].setText("");
				b[14].setText(s);
			}
		}//end of condition of button 16
//**************************************************************************		
cheking();
	
	}//end of action performed
	void cheking(){
		if(b[0].getText().equals("1")&&b[1].getText().equals("2")&&b[2].getText().equals("3")&&b[3].getText().equals("4")&&b[4].getText().equals("5")&&b[5].getText().equals("6")&&b[6].getText().equals("7")&&b[7].getText().equals("8")&&b[8].getText().equals("9")&&b[9].getText().equals("10")&&b[10].getText().equals("11")&&b[11].getText().equals("12")&&b[12].getText().equals("13")&&b[13].getText().equals("14")&&b[14].getText().equals("15")){
			JOptionPane.showMessageDialog(null, "Congats...!\nYou Win The Game");
		}
	}
	public static void main(String[] args) {
		new Puzzle();

	}
	

}
