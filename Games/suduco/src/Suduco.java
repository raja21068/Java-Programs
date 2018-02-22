import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Suduco extends JFrame implements ActionListener{
	
	File f=new File("save.txt");
	JButton tf[]=new JButton[25];
	ImageIcon image=new ImageIcon("check.jpg");
	JButton chek=new JButton(image);
	ImageIcon icon1=new ImageIcon("suduco_001.jpg");
	ImageIcon icon2=new ImageIcon("suduco_002.jpg");
	JLabel image1=new JLabel(icon1);
	JLabel image2=new JLabel(icon2);
	JMenuBar bar=new JMenuBar();
	JMenu op=new JMenu("Options");
	JMenuItem newgame=new JMenuItem("New Game");
	JMenuItem save=new JMenuItem("Save");
	
	//TODO*******CONSTRUCTOR****************
	Suduco()throws Exception{
		DataInputStream reed=new DataInputStream(new FileInputStream(f));
		setJMenuBar(bar);
		bar.add(op);
		op.add(newgame);
		op.add(save);
	Container con=getContentPane();
	Font f=new Font("arial",Font.BOLD,100);
	setBounds(0,0,600,600);
	con.setLayout(new GridLayout(6,5));
	for(int i=0;i<tf.length;i++){
		tf[i]=new JButton(" ");
		tf[i].setFont(f);
		tf[i].setBackground(Color.green);
		con.add(tf[i]);
	}//end of for loop
	chek.setBackground(Color.red);
	con.add(chek);
	con.add(image1);
	con.add(image2);
	chek.addActionListener(this);
	newgame.addActionListener(this);
	save.addActionListener(this);
	for(int i=0;i<tf.length;i++){
		tf[i].addActionListener(this);
	}
	String s=reed.readLine();
	System.out.println(s);
	if(s!=null){
		String st[]=s.split(",");
		for(int i=0;i<tf.length;i++){
		tf[i].setText(st[i]);
	}}
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	show();
	}//end of constructor
	
public static void main(String arg[])throws Exception{
	new Suduco();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object ob=e.getSource();
	for(int i=0;i<tf.length;i++){
		if(ob==tf[i]){ 
			System.out.println("Button "+i+" is clicked");
			String s=tf[i].getText(); 
			if(s.equals(" ")||s==null||s==""){ tf[i].setText("1");}
			else if(s.equals("1")){ tf[i].setText("2"); }
			else if(s.equals("2")){ tf[i].setText("3"); }
			else if(s.equals("3")){ tf[i].setText("4"); }
			else if(s.equals("4")){ tf[i].setText("5"); }
			else { tf[i].setText(" "); }
		}//end of if 
	}//end of for loop
	
	String s;
	String s1[]=new String[4];
	if(ob==newgame){ random(); }
	if(ob==save){ try{saveOption();}catch(Exception e1){}  }
	if(ob==chek){
		for(int i=0;i<25;i++){
			String str=tf[i].getText();
			if(str.isEmpty()){ JOptionPane.showMessageDialog(getParent(),"Empty boxes"); return; }
		}
			s=tf[0].getText();
			s1[0]=tf[1].getText();
			s1[1]=tf[2].getText();
			s1[2]=tf[3].getText();
			s1[3]=tf[4].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[0].getText();
			s1[0]=tf[5].getText();
			s1[1]=tf[10].getText();
			s1[2]=tf[15].getText();
			s1[3]=tf[20].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[1].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[2].getText();
			s1[2]=tf[3].getText();
			s1[3]=tf[4].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			
			s=tf[1].getText();
			s1[0]=tf[6].getText();
			s1[1]=tf[11].getText();
			s1[2]=tf[16].getText();
			s1[3]=tf[21].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[2].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[1].getText();
			s1[2]=tf[3].getText();
			s1[3]=tf[4].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[2].getText();
			s1[0]=tf[7].getText();
			s1[1]=tf[12].getText();
			s1[2]=tf[17].getText();
			s1[3]=tf[22].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[3].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[1].getText();
			s1[2]=tf[2].getText();
			s1[3]=tf[4].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			
			s=tf[3].getText();
			s1[0]=tf[8].getText();
			s1[1]=tf[13].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[23].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[4].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[1].getText();
			s1[2]=tf[2].getText();
			s1[3]=tf[3].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[4].getText();
			s1[0]=tf[9].getText();
			s1[1]=tf[14].getText();
			s1[2]=tf[19].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){box(); return;}
			
			s=tf[5].getText();
			s1[0]=tf[6].getText();
			s1[1]=tf[7].getText();
			s1[2]=tf[8].getText();
			s1[3]=tf[9].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[5].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[10].getText();
			s1[2]=tf[15].getText();
			s1[3]=tf[20].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[6].getText();
			s1[0]=tf[5].getText();
			s1[1]=tf[7].getText();
			s1[2]=tf[8].getText();
			s1[3]=tf[9].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[6].getText();
			s1[0]=tf[1].getText();
			s1[1]=tf[4].getText();
			s1[2]=tf[16].getText();
			s1[3]=tf[21].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[7].getText();
			s1[0]=tf[5].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[8].getText();
			s1[3]=tf[9].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[7].getText();
			s1[0]=tf[2].getText();
			s1[1]=tf[12].getText();
			s1[2]=tf[17].getText();
			s1[3]=tf[22].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[8].getText();
			s1[0]=tf[5].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[7].getText();
			s1[3]=tf[9].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[8].getText();
			s1[0]=tf[3].getText();
			s1[1]=tf[13].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[23].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[9].getText();
			s1[0]=tf[5].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[7].getText();
			s1[3]=tf[8].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[9].getText();
			s1[0]=tf[4].getText();
			s1[1]=tf[14].getText();
			s1[2]=tf[19].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			

			s=tf[10].getText();
			s1[0]=tf[11].getText();
			s1[1]=tf[12].getText();
			s1[2]=tf[13].getText();
			s1[3]=tf[14].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[10].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[5].getText();
			s1[2]=tf[15].getText();
			s1[3]=tf[20].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[11].getText();
			s1[0]=tf[10].getText();
			s1[1]=tf[12].getText();
			s1[2]=tf[13].getText();
			s1[3]=tf[14].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[11].getText();
			s1[0]=tf[1].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[16].getText();
			s1[3]=tf[21].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[12].getText();
			s1[0]=tf[10].getText();
			s1[1]=tf[11].getText();
			s1[2]=tf[13].getText();
			s1[3]=tf[14].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[12].getText();
			s1[0]=tf[2].getText();
			s1[1]=tf[7].getText();
			s1[2]=tf[17].getText();
			s1[3]=tf[22].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[13].getText();
			s1[0]=tf[10].getText();
			s1[1]=tf[11].getText();
			s1[2]=tf[12].getText();
			s1[3]=tf[14].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[13].getText();
			s1[0]=tf[3].getText();
			s1[1]=tf[8].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[23].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[14].getText();
			s1[0]=tf[10].getText();
			s1[1]=tf[11].getText();
			s1[2]=tf[12].getText();
			s1[3]=tf[13].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[14].getText();
			s1[0]=tf[4].getText();
			s1[1]=tf[9].getText();
			s1[2]=tf[19].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			
			s=tf[15].getText();
			s1[0]=tf[16].getText();
			s1[1]=tf[17].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[19].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[15].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[5].getText();
			s1[2]=tf[10].getText();
			s1[3]=tf[20].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			

			s=tf[16].getText();
			s1[0]=tf[15].getText();
			s1[1]=tf[17].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[19].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[16].getText();
			s1[0]=tf[1].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[11].getText();
			s1[3]=tf[21].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			

			s=tf[17].getText();
			s1[0]=tf[15].getText();
			s1[1]=tf[16].getText();
			s1[2]=tf[18].getText();
			s1[3]=tf[19].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[17].getText();
			s1[0]=tf[2].getText();
			s1[1]=tf[7].getText();
			s1[2]=tf[12].getText();
			s1[3]=tf[22].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			

			s=tf[18].getText();
			s1[0]=tf[15].getText();
			s1[1]=tf[16].getText();
			s1[2]=tf[17].getText();
			s1[3]=tf[19].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[18].getText();
			s1[0]=tf[3].getText();
			s1[1]=tf[8].getText();
			s1[2]=tf[13].getText();
			s1[3]=tf[23].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			

			s=tf[19].getText();
			s1[0]=tf[15].getText();
			s1[1]=tf[16].getText();
			s1[2]=tf[17].getText();
			s1[3]=tf[18].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[19].getText();
			s1[0]=tf[4].getText();
			s1[1]=tf[9].getText();
			s1[2]=tf[14].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[20].getText();
			s1[0]=tf[21].getText();
			s1[1]=tf[22].getText();
			s1[2]=tf[23].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[20].getText();
			s1[0]=tf[0].getText();
			s1[1]=tf[5].getText();
			s1[2]=tf[10].getText();
			s1[3]=tf[15].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[21].getText();
			s1[0]=tf[20].getText();
			s1[1]=tf[22].getText();
			s1[2]=tf[23].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[21].getText();
			s1[0]=tf[1].getText();
			s1[1]=tf[6].getText();
			s1[2]=tf[11].getText();
			s1[3]=tf[16].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }


			s=tf[22].getText();
			s1[0]=tf[20].getText();
			s1[1]=tf[21].getText();
			s1[2]=tf[23].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[22].getText();
			s1[0]=tf[2].getText();
			s1[1]=tf[7].getText();
			s1[2]=tf[12].getText();
			s1[3]=tf[17].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[23].getText();
			s1[0]=tf[20].getText();
			s1[1]=tf[21].getText();
			s1[2]=tf[22].getText();
			s1[3]=tf[24].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[23].getText();
			s1[0]=tf[3].getText();
			s1[1]=tf[8].getText();
			s1[2]=tf[13].getText();
			s1[3]=tf[18].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
			
			s=tf[24].getText();
			s1[0]=tf[20].getText();
			s1[1]=tf[21].getText();
			s1[2]=tf[22].getText();
			s1[3]=tf[23].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }

			s=tf[24].getText();
			s1[0]=tf[4].getText();
			s1[1]=tf[9].getText();
			s1[2]=tf[14].getText();
			s1[3]=tf[19].getText();
			if(s.equals(s1[0])||s.equals(s1[1])||s.equals(s1[2])||s.equals(s1[3])){ box(); return; }
						
			JOptionPane.showMessageDialog(getParent(), "Win the game");	random();
			
		}//end of chek
	}//end of action performed
	void box(){
		JOptionPane.showMessageDialog(getParent(), "Error...!\n Please Correct it..");
	}
	void random(){
		
		for(int i=0;i<tf.length;i++){
			tf[i].setText("");
			tf[i].enable();
		}
		String ss="";
		for(int i=0;i<6;){
			int s1[]={0,0,0,0,0,0,0,0};
			String store[]=new String[8];
			double db=Math.random()*25+1;
			int btn=(int)db;
			if(ss.indexOf(" "+btn+" ")==-1){
				ss+=" "+btn+" ";
				System.out.println("Button:"+btn);
				for(int j=0;j<1;){
					double d=Math.random()*5+1;
					int bt=(int)d;
					System.out.println("digit:: "+bt);
					if(btn==0){
						store[0]=tf[1].getText();
						if(!store[0].equals("")){s1[0]=Integer.parseInt(store[0]);}
						store[1]=tf[2].getText();
						if(!store[1].equals("")){s1[1]=Integer.parseInt(store[1]);}
						store[2]=tf[3].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[4].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[5].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[10].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[15].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[20].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					}
					if(btn==1){
						//TODO
						store[0]=tf[0].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[2].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[3].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[4].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[6].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[11].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[16].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[21].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==2){
						//TODO
						store[0]=tf[0].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[1].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[3].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[4].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[7].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[12].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[17].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[22].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==3){
						//TODO
						store[0]=tf[0].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[1].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[2].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[4].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[8].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[13].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[18].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[23].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==4){
						//TODO
						store[0]=tf[0].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[1].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[2].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[3].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[9].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[14].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[19].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[24].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==5){
						//TODO
						store[0]=tf[6].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[7].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[8].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[9].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[0].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[10].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[15].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[20].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==6){
						//TODO
						store[0]=tf[5].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[7].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[8].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[9].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[1].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[4].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[6].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[21].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					}
					if(btn==7){
						//TODO
						store[0]=tf[5].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[6].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[8].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[9].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[2].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[12].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[17].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[22].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						
					}
					if(btn==8){
						//TODO
						store[0]=tf[5].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[6].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[7].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[9].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[3].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[13].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[18].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[23].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==9){
						//TODO
						store[0]=tf[5].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[6].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[7].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[8].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[4].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[14].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[19].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[24].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						}
					if(btn==10){
						//TODO
						store[0]=tf[11].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[12].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[13].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[14].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[0].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[5].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[15].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[20].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
						
					}
					if(btn==11){
						//TODO
						store[0]=tf[10].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[12].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[13].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[14].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[1].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[6].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[16].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[21].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==12){
						//TODO
						store[0]=tf[10].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[11].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[13].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[14].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[2].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[7].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[17].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[22].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false);}
					
					}
					if(btn==13){
						//TODO
						store[0]=tf[10].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[11].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[12].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[14].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[3].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[8].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[18].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[23].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==14){
						//TODO
						store[0]=tf[10].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[11].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[12].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[13].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[4].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[9].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[19].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[24].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==15){
						//TODO
						
						store[0]=tf[16].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[17].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[18].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[19].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[0].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[5].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[10].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[20].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false);}
					
					}
					if(btn==16){
						//TODO
						
						store[0]=tf[15].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[17].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[18].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[19].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[1].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[6].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[11].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[21].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==17){
						
						store[0]=tf[15].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[16].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[18].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[19].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[2].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[7].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[12].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[22].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);						
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
									}
					if(btn==18){
						store[0]=tf[15].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[16].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[17].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[19].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[3].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[6].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[13].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[23].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==19){
						store[0]=tf[15].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[16].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[17].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[18].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[4].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[9].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[14].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[24].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==20){
						store[0]=tf[21].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[22].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[23].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[24].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[0].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[5].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[10].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[15].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==21){
						store[0]=tf[20].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[22].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[23].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[24].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[1].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[6].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[11].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[16].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==22){
						store[0]=tf[20].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[21].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[23].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[24].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[2].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[7].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[12].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[17].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==23){
						store[0]=tf[20].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[21].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[22].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[24].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[3].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[8].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[13].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[18].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }
					
					}
					if(btn==24){
						store[0]=tf[20].getText();
						if(!store[0].equals(""))s1[0]=Integer.parseInt(store[0]);
						store[1]=tf[21].getText();
						if(!store[1].equals(""))s1[1]=Integer.parseInt(store[1]);
						store[2]=tf[22].getText();
						if(!store[2].equals(""))s1[2]=Integer.parseInt(store[2]);
						store[3]=tf[23].getText();
						if(!store[3].equals(""))s1[3]=Integer.parseInt(store[3]);
						store[4]=tf[4].getText();
						if(!store[4].equals(""))s1[4]=Integer.parseInt(store[4]);
						store[5]=tf[9].getText();
						if(!store[5].equals(""))s1[5]=Integer.parseInt(store[5]);
						store[6]=tf[14].getText();
						if(!store[6].equals(""))s1[6]=Integer.parseInt(store[6]);
						store[7]=tf[19].getText();
						if(!store[7].equals(""))s1[7]=Integer.parseInt(store[7]);
						if(bt==s1[0]||bt==s1[1]||bt==s1[2]||bt==s1[3]||bt==s1[4]||bt==s1[5]||bt==s1[6]||bt==s1[7]){ return; }
						else { tf[btn].setText(""+bt);  tf[btn].setEnabled(false); }				
					
					}	
				j++;
				}
				
			}//end of if condition
			i++;
		}//end of for loop
		
	}//end of random
	void saveOption()throws Exception{
		if(!f.exists()){ f.createNewFile(); }
		PrintStream prntinfile=new PrintStream(new FileOutputStream(f));
		String s="";
		for(int i=0;i<tf.length;i++){
			if(tf[i].getText()==""||tf[i].getText()==" "||tf[i].getText()==null){ s+=" "+","; }
			else s+=tf[i].getText()+",";
		}
		prntinfile.print(s);
	}
}

