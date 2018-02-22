import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.applet.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

class PuzzlePic extends JFrame implements ActionListener{
JButton b[]=new JButton[16];
ImageIcon pic[]=new ImageIcon[15];
ImageIcon castlepic[]=new ImageIcon[15];
ImageIcon motherpic[]=new ImageIcon[15];
ImageIcon icon=new ImageIcon("");
JPanel panel=new JPanel();
MenuBar bar=new MenuBar();
Menu option=new Menu("Option");
Menu game=new Menu("Game");
MenuItem castle=new MenuItem("Castle");
MenuItem iori=new MenuItem("Iori");
MenuItem mother=new MenuItem("Mother");
MenuItem newgame=new MenuItem("New Game");
MenuItem open=new MenuItem("Open..");
MenuItem imag=new MenuItem("Image");
MenuItem picslid=new MenuItem("Picture slide");
MenuItem number=new MenuItem("Number slide");
MenuItem about=new MenuItem("About");
MenuItem exit=new MenuItem("Exit");
JLabel time=new JLabel("TIME:");
JLabel hour=new JLabel("0.");
JLabel min=new JLabel("0.");
JLabel sec=new JLabel("0");
JLabel mov=new JLabel("MOVE:");
JLabel movc=new JLabel("0");
int count=0;
int s=0,m=0,h=0;
static int select=0;
ImageIcon[] fileimage=new ImageIcon[15];

PuzzlePic(){
		Container con=getContentPane();
		setBounds(0,0,530,750);
		con.setLayout(new GridLayout(5,4));
		setTitle("Puzzle");
		
		
		pic[0]=new ImageIcon("iori_001.jpg");
		pic[1]=new ImageIcon("iori_002.jpg");
		pic[2]=new ImageIcon("iori_003.jpg");
		pic[3]=new ImageIcon("iori_004.jpg");
		pic[4]=new ImageIcon("iori_005.jpg");
		pic[5]=new ImageIcon("iori_006.jpg");
		pic[6]=new ImageIcon("iori_007.jpg");
		pic[7]=new ImageIcon("iori_008.jpg");
		pic[8]=new ImageIcon("iori_009.jpg");
		pic[9]=new ImageIcon("iori_010.jpg");
		pic[10]=new ImageIcon("iori_011.jpg");
		pic[11]=new ImageIcon("iori_012.jpg");
		pic[12]=new ImageIcon("iori_013.jpg");
		pic[13]=new ImageIcon("iori_014.jpg");
		pic[14]=new ImageIcon("iori_015.jpg");
		
		castlepic[0]=new ImageIcon("castle_001.jpg");
		castlepic[1]=new ImageIcon("castle_002.jpg");
		castlepic[2]=new ImageIcon("castle_003.jpg");
		castlepic[3]=new ImageIcon("castle_004.jpg");
		castlepic[4]=new ImageIcon("castle_005.jpg");
		castlepic[5]=new ImageIcon("castle_006.jpg");
		castlepic[6]=new ImageIcon("castle_007.jpg");
		castlepic[7]=new ImageIcon("castle_008.jpg");
		castlepic[8]=new ImageIcon("castle_009.jpg");
		castlepic[9]=new ImageIcon("castle_010.jpg");
		castlepic[10]=new ImageIcon("castle_011.jpg");
		castlepic[11]=new ImageIcon("castle_012.jpg");
		castlepic[12]=new ImageIcon("castle_013.jpg");
		castlepic[13]=new ImageIcon("castle_014.jpg");
		castlepic[14]=new ImageIcon("castle_015.jpg");
		
		motherpic[0]=new ImageIcon("mother_001.jpg");
		motherpic[1]=new ImageIcon("mother_002.jpg");
		motherpic[2]=new ImageIcon("mother_003.jpg");
		motherpic[3]=new ImageIcon("mother_004.jpg");
		motherpic[4]=new ImageIcon("mother_005.jpg");
		motherpic[5]=new ImageIcon("mother_006.jpg");
		motherpic[6]=new ImageIcon("mother_007.jpg");
		motherpic[7]=new ImageIcon("mother_008.jpg");
		motherpic[8]=new ImageIcon("mother_009.jpg");
		motherpic[9]=new ImageIcon("mother_010.jpg");
		motherpic[10]=new ImageIcon("mother_011.jpg");
		motherpic[11]=new ImageIcon("mother_012.jpg");
		motherpic[12]=new ImageIcon("mother_013.jpg");
		motherpic[13]=new ImageIcon("mother_014.jpg");
		motherpic[14]=new ImageIcon("mother_015.jpg");
		
		
		bar.add(option);
		bar.add(game);
		game.add(castle);
		game.add(iori);
		game.add(mother);
		option.add(newgame);
		option.add(open);
		option.add(imag);
		option.add(number);
		option.add(picslid);
		option.add(about);
		option.add(exit);
		setMenuBar(bar);
		
		for(int i=0;i<b.length;i++){
		b[i]=new JButton();
		con.add(b[i]);
		b[i].addActionListener(this);
		}
		
		Font f=new Font("arial",Font.BOLD,15);
		time.setFont(f);
		hour.setFont(f);
		min.setFont(f);
		sec.setFont(f);
		FlowLayout flow=new FlowLayout();
		panel.setLayout(flow);
		panel.add(time);
		panel.add(hour);
		panel.add(min);
		panel.add(sec);
		panel.add(mov);
		panel.add(movc);
		
		
		
		add(panel,BorderLayout.SOUTH);
		castle.addActionListener(this);
		imag.addActionListener(this);
		newgame.addActionListener(this);
		open.addActionListener(this);
		picslid.addActionListener(this);
		number.addActionListener(this);
		about.addActionListener(this);
		exit.addActionListener(this);
		iori.addActionListener(this);
		mother.addActionListener(this);
		
		picTest();//Random();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try{Timer();}catch(Exception e){}
		show();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		try{ play();}catch(Exception e1){}
		if(ob==iori){ select=0; Random(); moveReset(); timeReset(); }
		if(ob==castle){ select=1; Random(); moveReset(); timeReset();}
		if(ob==mother){ select=2; Random(); moveReset(); timeReset();}
		if(ob==newgame){ 
			
			Random();
			moveReset();
			timeReset();
		}//end of new game*************************************
		if(ob==open){
			//TODO open
			try{openn();}catch(Exception e1){}
			
		}//end of open
		if(ob==imag){ puzz(); }
		if(ob==picslid){ 
			String s;
			int index;
			for(int i=0;i<16;i++){ 
				s=b[i].getText();
				for(int j=1;j<16;j++){
					index=s.indexOf(""+j);
					if(index>-1){ b[i].setIcon(pic[j-1]); }
				}
			}
		}
		
		if(ob==number){  for(int i=0;i<16;i++){ b[i].setIcon(null);} 
		}
		if(ob==about){ JOptionPane.showMessageDialog(null, "This is a puuzle game....!\n made by: Jay Kumar 2k11/csm/25 "); }		
		if(ob==exit){ System.exit(0); }
		
		if(ob==b[0]){
			
			if(b[1].getText().equals("")){
				move();
				String s=b[0].getText();
				b[0].setText("");
				b[1].setText(s);
				Icon i=b[0].getIcon();
				b[1].setIcon(i);
				b[0].setIcon(null);
			}
			if(b[4].getText().equals("")){
				move();
				String s=b[0].getText();
				b[0].setText("");
				b[4].setText(s);
				Icon i=b[0].getIcon();
				b[4].setIcon(i);
				b[0].setIcon(null);
			}
				
		}//end of condition of button 1
//***********************************************************************		
		if(ob==b[1]){
			if(b[2].getText().equals("")){
				move();
				String s=b[1].getText();
				b[1].setText("");
				b[2].setText(s);
				Icon i=b[1].getIcon();
				b[2].setIcon(i);
				b[1].setIcon(null);
			}
			if(b[5].getText().equals("")){
				move();
				String s=b[1].getText();
				b[1].setText("");
				b[5].setText(s);
				Icon i=b[1].getIcon();
				b[5].setIcon(i);
				b[1].setIcon(null);
			}
			if(b[0].getText().equals("")){
				move();
				String s=b[1].getText();
				b[1].setText("");
				b[0].setText(s);
				Icon i=b[1].getIcon();
				b[0].setIcon(i);
				b[1].setIcon(null);
			}
			
		}//end of condition of button 2
//***************************************************************************		
		if(ob==b[2]){
			if(b[1].getText().equals("")){
				move();
				String s=b[2].getText();
				b[2].setText("");
				b[1].setText(s);
				Icon i=b[2].getIcon();
				b[1].setIcon(i);
				b[2].setIcon(null);
			}
			if(b[3].getText().equals("")){
				move();
				String s=b[2].getText();
				b[2].setText("");
				b[3].setText(s);
				Icon i=b[2].getIcon();
				b[3].setIcon(i);
				b[2].setIcon(null);
			}
			if(b[6].getText().equals("")){
				move();
				String s=b[2].getText();
				b[2].setText("");
				b[6].setText(s);
				Icon i=b[2].getIcon();
				b[6].setIcon(i);
				b[2].setIcon(null);
			}
			
		}//end of condition of button 3
//****************************************************************************		
		if(ob==b[3]){
			if(b[2].getText().equals("")){
				move();
				String s=b[3].getText();
				b[3].setText("");
				b[2].setText(s);
				Icon i=b[3].getIcon();
				b[2].setIcon(i);
				b[3].setIcon(null);
			}
			if(b[7].getText().equals("")){
				move();
				String s=b[3].getText();
				b[3].setText("");
				b[7].setText(s);
				Icon i=b[3].getIcon();
				b[7].setIcon(i);
				b[3].setIcon(null);
			}
			
		}//end of condition of button 4
//****************************************************************************		
		if(ob==b[4]){
			if(b[0].getText().equals("")){
				move();
				String s=b[4].getText();
				b[4].setText("");
				b[0].setText(s);
				Icon i=b[4].getIcon();
				b[0].setIcon(i);
				b[4].setIcon(null);
			}
			if(b[5].getText().equals("")){
				move();
				String s=b[4].getText();
				b[4].setText("");
				b[5].setText(s);
				Icon i=b[4].getIcon();
				b[5].setIcon(i);
				b[4].setIcon(null);
			}
			if(b[8].getText().equals("")){
				move();
				String s=b[4].getText();
				b[4].setText("");
				b[8].setText(s);
				Icon i=b[4].getIcon();
				b[8].setIcon(i);
				b[4].setIcon(null);
			}
			
		}//end of condition of button 5
//****************************************************************************		
		if(ob==b[5]){
			if(b[1].getText().equals("")){
				move();
				String s=b[5].getText();
				b[5].setText("");
				b[1].setText(s);
				Icon i=b[5].getIcon();
				b[1].setIcon(i);
				b[5].setIcon(null);
			}
			if(b[4].getText().equals("")){
				move();
				String s=b[5].getText();
				b[5].setText("");
				b[4].setText(s);
				Icon i=b[5].getIcon();
				b[4].setIcon(i);
				b[5].setIcon(null);
			}
			if(b[6].getText().equals("")){
				move();
				String s=b[5].getText();
				b[5].setText("");
				b[6].setText(s);
				Icon i=b[5].getIcon();
				b[6].setIcon(i);
				b[5].setIcon(null);
			}
			if(b[9].getText().equals("")){
				move();
				String s=b[5].getText();
				b[5].setText("");
				b[9].setText(s);
				Icon i=b[5].getIcon();
				b[9].setIcon(i);
				b[5].setIcon(null);
			}
		}//end of condition of button 6
//**************************************************************************		
		if(ob==b[6]){
			if(b[2].getText().equals("")){
				move();
				String s=b[6].getText();
				b[6].setText("");
				b[2].setText(s);
				Icon i=b[6].getIcon();
				b[2].setIcon(i);
				b[6].setIcon(null);
			}
			if(b[5].getText().equals("")){
				move();
				String s=b[6].getText();
				b[6].setText("");
				b[5].setText(s);
				Icon i=b[6].getIcon();
				b[5].setIcon(i);
				b[6].setIcon(null);
			}
			if(b[7].getText().equals("")){
				move();
				String s=b[6].getText();
				b[6].setText("");
				b[7].setText(s);
				Icon i=b[6].getIcon();
				b[7].setIcon(i);
				b[6].setIcon(null);
			}
			if(b[10].getText().equals("")){
				move();
				String s=b[6].getText();
				b[6].setText("");
				b[10].setText(s);
				Icon i=b[6].getIcon();
				b[10].setIcon(i);
				b[6].setIcon(null);
			}
		}//end of condition of button 7
//**************************************************************************		
		if(ob==b[7]){
			if(b[3].getText().equals("")){
				move();
				String s=b[7].getText();
				b[7].setText("");
				b[3].setText(s);
				Icon i=b[7].getIcon();
				b[3].setIcon(i);
				b[7].setIcon(null);
			}
			if(b[6].getText().equals("")){
				move();
				String s=b[7].getText();
				b[7].setText("");
				b[6].setText(s);
				Icon i=b[7].getIcon();
				b[6].setIcon(i);
				b[7].setIcon(null);
			}
			if(b[11].getText().equals("")){
				move();
				String s=b[7].getText();
				b[7].setText("");
				b[11].setText(s);
				Icon i=b[7].getIcon();
				b[11].setIcon(i);
				b[7].setIcon(null);
			}
		}//end of condition of button 8
//**************************************************************************		
		if(ob==b[8]){
			if(b[4].getText().equals("")){
				move();
				String s=b[8].getText();
				b[8].setText("");
				b[4].setText(s);
				Icon i=b[8].getIcon();
				b[4].setIcon(i);
				b[8].setIcon(null);
			}
			if(b[9].getText().equals("")){
				move();
				String s=b[8].getText();
				b[8].setText("");
				b[9].setText(s);
				Icon i=b[8].getIcon();
				b[9].setIcon(i);
				b[8].setIcon(null);
			}
			if(b[12].getText().equals("")){
				move();
				String s=b[8].getText();
				b[8].setText("");
				b[12].setText(s);
				Icon i=b[8].getIcon();
				b[12].setIcon(i);
				b[8].setIcon(null);
			}
		}//end of condition of button 9
//**************************************************************************		
		if(ob==b[9]){
			if(b[5].getText().equals("")){
				move();
				String s=b[9].getText();
				b[9].setText("");
				b[5].setText(s);
				Icon i=b[9].getIcon();
				b[5].setIcon(i);
				b[9].setIcon(null);
			}
			if(b[8].getText().equals("")){
				move();
				String s=b[9].getText();
				b[9].setText("");
				b[8].setText(s);
				Icon i=b[9].getIcon();
				b[8].setIcon(i);
				b[9].setIcon(null);
			}
			if(b[10].getText().equals("")){
				move();
				String s=b[9].getText();
				b[9].setText("");
				b[10].setText(s);
				Icon i=b[9].getIcon();
				b[10].setIcon(i);
				b[9].setIcon(null);
			}
			if(b[13].getText().equals("")){
				move();
				String s=b[9].getText();
				b[9].setText("");
				b[13].setText(s);
				Icon i=b[9].getIcon();
				b[13].setIcon(i);
				b[9].setIcon(null);
			}
		}//end of condition of button 10
//**************************************************************************		
		if(ob==b[10]){
			if(b[6].getText().equals("")){
				move();
				String s=b[10].getText();
				b[10].setText("");
				b[6].setText(s);
				Icon i=b[10].getIcon();
				b[6].setIcon(i);
				b[10].setIcon(null);
			}
			if(b[9].getText().equals("")){
				move();
				String s=b[10].getText();
				b[10].setText("");
				b[9].setText(s);
				Icon i=b[10].getIcon();
				b[9].setIcon(i);
				b[10].setIcon(null);
			}
			if(b[11].getText().equals("")){
				move();
				String s=b[10].getText();
				b[10].setText("");
				b[11].setText(s);
				Icon i=b[10].getIcon();
				b[11].setIcon(i);
				b[10].setIcon(null);
			}
			if(b[14].getText().equals("")){
				move();
				String s=b[10].getText();
				b[10].setText("");
				b[14].setText(s);
				Icon i=b[10].getIcon();
				b[14].setIcon(i);
				b[10].setIcon(null);
			}
						
		}//end of condition of button 11
//**************************************************************************		
		if(ob==b[11]){
			if(b[7].getText().equals("")){
				move();
				String s=b[11].getText();
				b[11].setText("");
				b[7].setText(s);
				Icon i=b[11].getIcon();
				b[7].setIcon(i);
				b[11].setIcon(null);
			}
			if(b[10].getText().equals("")){
				move();
				String s=b[11].getText();
				b[11].setText("");
				b[10].setText(s);
				Icon i=b[11].getIcon();
				b[10].setIcon(i);
				b[11].setIcon(null);
			}
			if(b[15].getText().equals("")){
				move();
				String s=b[11].getText();
				b[11].setText("");
				b[15].setText(s);
				Icon i=b[11].getIcon();
				b[15].setIcon(i);
				b[11].setIcon(null);
				}
		}//end of condition of button 12
//**************************************************************************		
		if(ob==b[12]){
			if(b[8].getText().equals("")){
				move();
				String s=b[12].getText();
				b[12].setText("");
				b[8].setText(s);
				Icon i=b[12].getIcon();
				b[8].setIcon(i);
				b[12].setIcon(null);
			}
			if(b[13].getText().equals("")){
				move();
				String s=b[12].getText();
				b[12].setText("");
				b[13].setText(s);
				Icon i=b[12].getIcon();
				b[13].setIcon(i);
				b[12].setIcon(null);
			}
		}//end of condition of button 13
//**************************************************************************		
		if(ob==b[13]){
			if(b[9].getText().equals("")){
				move();
				String s=b[13].getText();
				b[13].setText("");
				b[9].setText(s);
				Icon i=b[13].getIcon();
				b[9].setIcon(i);
				b[13].setIcon(null);
			}
			if(b[12].getText().equals("")){
				move();
				String s=b[13].getText();
				b[13].setText("");
				b[12].setText(s);
				Icon i=b[13].getIcon();
				b[12].setIcon(i);
				b[13].setIcon(null);
			}
			if(b[14].getText().equals("")){
				move();
				String s=b[13].getText();
				b[13].setText("");
				b[14].setText(s);
				Icon i=b[13].getIcon();
				b[14].setIcon(i);
				b[13].setIcon(null);
			}
		}//end of condition of button 14
//**************************************************************************		
		if(ob==b[14]){
			if(b[13].getText().equals("")){
				move();
				String s=b[14].getText();
				b[14].setText("");
				b[13].setText(s);
				Icon i=b[14].getIcon();
				b[13].setIcon(i);
				b[14].setIcon(null);
			}
			if(b[15].getText().equals("")){
				move();
				String s=b[14].getText();
				b[14].setText("");
				b[15].setText(s);
				Icon i=b[14].getIcon();
				b[15].setIcon(i);
				b[14].setIcon(null);
				
			}
			if(b[10].getText().equals("")){
				move();
				String s=b[14].getText();
				b[14].setText("");
				b[10].setText(s);
				Icon i=b[14].getIcon();
				b[10].setIcon(i);
				b[14].setIcon(null);
			}
			}//end of condition of button 15
//*****************************************************************************		
		if(ob==b[15]){
			if(b[11].getText().equals("")){
				move();
				String s=b[15].getText();
				b[15].setText("");
				b[11].setText(s);
				Icon i=b[15].getIcon();
				b[11].setIcon(i);
				b[15].setIcon(null);
			}
			if(b[14].getText().equals("")){
				move();
				String s=b[15].getText();
				b[15].setText("");
				b[14].setText(s);
				Icon i=b[15].getIcon();
				b[14].setIcon(i);
				b[15].setIcon(null);
			}
		}//end of condition of button 16
//**************************************************************************		
cheking();
	
	}//end of action performed
	
	public static void main(String[] args) {
		new PuzzlePic();

	}
	
	//TODO *************METHODS*******USING*********IN*****PROGRAM***************
	
	void cheking(){
		try{
		if(b[0].getText().equals("1")&&b[1].getText().equals("2")&&b[2].getText().equals("3")&&b[3].getText().equals("4")&&b[4].getText().equals("5")&&b[5].getText().equals("6")&&b[6].getText().equals("7")&&b[7].getText().equals("8")&&b[8].getText().equals("9")&&b[9].getText().equals("10")&&b[10].getText().equals("11")&&b[11].getText().equals("12")&&b[12].getText().equals("13")&&b[13].getText().equals("14")&&b[14].getText().equals("15")){
			JOptionPane.showMessageDialog(null, "Congats...!\nYou Win The Game");
			Thread.sleep(3000);
			Random();
			moveReset();
			timeReset();
		}}catch(Exception e){}
	}
	
	
	
	
	void puzz()
	{
		JFrame w=new JFrame();
		JLabel pic=new JLabel(new ImageIcon("ioripuz.jpg"));
		JLabel castlepic1=new JLabel(new ImageIcon("castlepuzz.jpg"));
		JLabel motherpic=new JLabel(new ImageIcon("motherpuzz.jpg"));
		Container con=w.getContentPane();
		con.setLayout(null);
		w.setBounds(100,100,400,400);
		pic.setBounds(0,0, 400, 400);
		castlepic1.setBounds(0,0, 400, 400);
		motherpic.setBounds(0,0, 400, 400);
		if(select==1){ con.add(castlepic1); }
		else if(select==0){ con.add(pic); }
		else if(select==2){ con.add(motherpic); } 
		w.setDefaultCloseOperation(1);
		w.show();
	}
	// this Random method is for generate random numbers and pictures on buttons
	void Random(){
		int index;
		String s=new String();
		int a;
		double c;
		for(int i=0;i<15;){
		c=Math.random()*20;
		a=(int)c+1;
		index=s.indexOf(" "+a+" ");
		
		if(index==-1 && a<16){
			s+=" "+a+" ";
			b[i].setText(""+a);
			if(select==0){b[i].setIcon(pic[a-1]);}
			if(select==1){b[i].setIcon(castlepic[a-1]);}
			if(select==2){ b[i].setIcon(motherpic[a-1]);}
			i++; }
		}
		b[15].setText("");
		b[15].setIcon(icon);
	
	}//TODO end of random method

	void picTest(){
		int index;
		for(int i=0; i<14;)
		{
			b[i].setText(""+(i+1));
		b[i].setIcon(pic[i]);
			i++; }
		b[14].setText("");
		b[14].setIcon(icon);
		b[15].setText("15");
		b[15].setIcon(pic[14]);
		
	}
	
	public void play()throws Exception{
		File f=new File("puzz.wav");
		AudioClip clip=Applet.newAudioClip(f.toURL());
		clip.play();
	}
	public void Timer()throws Exception{
		
			for(s=0;s<61;s++){
				sec.setText(""+s);
				min.setText(""+m+".");
				hour.setText(""+h+".");
				Thread.sleep(1000);
				if(s==59){ s=-1; m++; }
				if(m==60){ m=0; h++; }
				show();
			}
	}//end of timer 
	public void timeReset(){
		s=0;
		m=0;
		h=0;
	}
	public void moveReset(){
		count=0;
		movc.setText(""+count);
		show();
	}
	public void move(){
		count++;
		movc.setText(""+count);
		show();
	}
//TODO RANDOM***IMAGE ICON********************
	void Random(ImageIcon[] ob){
		System.out.println("entered in random method");
		int index;
		String s=new String();
		int a;
		double c;
		for(int i=0;i<15;){
		c=Math.random()*20;
		a=(int)c+1;
		index=s.indexOf(" "+a+" ");
		
		if(index==-1 && a<16){
			s+=" "+a+" ";
			b[i].setText(""+a);
			b[i].setIcon(ob[a-1]);
			//if(select==0){b[i].setIcon(pic[a-1]);}
			//if(select==1){b[i].setIcon(castlepic[a-1]);}
			//if(select==2){ b[i].setIcon(motherpic[a-1]);}
			i++; }
		}
		b[15].setText("");
		b[15].setIcon(icon);
		show();
	
	}//TODO end of random method
	
	void openn()throws Exception{
		FileDialog d=new FileDialog(this,"Open",FileDialog.LOAD);
		d.show();
		String s=d.getDirectory()+d.getFile();
		File f=new File(s);
		FileInputStream fs=new FileInputStream(f);
		BufferedImage bi=ImageIO.read(f);
		int col=4,rows=4;
		int chunks=col*rows;
		int chunkwidth=bi.getWidth()/col;
		int chunkheight=bi.getWidth()/rows;
		int count =0;
		BufferedImage barray[]=new BufferedImage[chunks];
		   for(int x=0;x<rows;x++){
			   for(int y=0;y<col;y++){
				   barray[count]=new BufferedImage(chunkwidth,chunkheight,bi.getType());
				   Graphics2D gr=barray[count++].createGraphics();
				   gr.drawImage(bi,0, 0,chunkwidth,chunkheight,chunkwidth*y, chunkheight*x, chunkwidth*y+chunkwidth, chunkheight*x+chunkheight, null);
				   gr.dispose();
			   }
		   }
	System.out.println("Spliting Done....!");	
	
	for(int i=0;i<barray.length;i++){
		ImageIO.write(barray[i], "jpg", new File("D:/image"+i+".jpg"));
			}
	System.out.println("Mini images Created");
	ImageIcon ppp=new ImageIcon(s);
	setBounds(0,0,ppp.getIconWidth(),ppp.getIconHeight());
	for(int i=0;i<barray.length;i++){
		fileimage[i]=new ImageIcon("D://image"+i+".jpg");
			
	//fileimage[i]=new ImageIcon("E:/puzzle/image"+i+".jpg");
	System.out.println("image"+i+".jpg");}

	Random(fileimage);
	moveReset();
	timeReset();
	}
	//TODO end of openn method...
	//***********



}