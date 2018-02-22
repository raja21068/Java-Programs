import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.*;

class notepadd extends JFrame implements ActionListener,KeyListener,WindowListener{
	boolean saved=true;
	
	JTextArea txt=new JTextArea();
	JPanel panel= new JPanel();
	JMenuBar bar=new JMenuBar();

	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu format=new JMenu("Format");
	JMenu view=new JMenu("View");
	JMenu help=new JMenu("Help");

	JMenuItem newf=new JMenuItem("new         ctrl+N");
	JMenuItem open=new JMenuItem("open        ctrl+O");
	JMenuItem save=new JMenuItem("Save         ctrl+s");
	JMenuItem saveas=new JMenuItem("Save As...");
	JMenuItem page=new JMenuItem("Page setup...");
	JMenuItem prnt=new JMenuItem("Print...      ctrl+P");
	JMenuItem exit=new JMenuItem("Exit");

	JMenuItem undo=new JMenuItem("Undo");
	JMenuItem cut=new JMenuItem("cut");
	JMenuItem copy=new JMenuItem("copy");
	JMenuItem paste=new JMenuItem("Paste");
	JMenuItem delete=new JMenuItem("delete");
	JMenuItem find=new JMenuItem("Find..");
	JMenuItem next=new JMenuItem("Find Next");
	JMenuItem replace=new JMenuItem("Replace");
	JMenuItem got=new JMenuItem("Goto...  ");
	JMenuItem select=new JMenuItem("Select All");
	JMenuItem time=new JMenuItem("Time/Date");

	JCheckBox word=new JCheckBox("Word Wrap");
	JMenuItem font=new JMenuItem("Font...");

	JMenuItem color = new JMenuItem("Color");
	JCheckBox status= new JCheckBox("Status Bar");
	JMenuItem vhelp=new JMenuItem("View Help");
	JMenuItem about=new JMenuItem("About notepad");
	
		
		notepaddFind obfind=new notepaddFind(this);
		notepaddFont obfont=new notepaddFont(this);
		notepaddGoto obgoto=new notepaddGoto(this);
		notepaddReplace obreplace=new notepaddReplace(this);
		
		notepadd(){
		Container con=getContentPane();
		try{
                setIconImage(ImageIO.read(new File("index.jpeg")));
               }catch(Exception e){}
		setTitle("(\u0627\u0631\u062F\u0648 \u0646\u0648\u0679 ( \u062C\u06D2 \u06A9\u0645\u0625\u0631 ");
		setBounds(0,0,500,500); 

		bar.add(file);
		bar.add(edit);
		bar.add(format);
		bar.add(view);
		bar.add(help);

		file.add(newf);
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(new JSeparator());
		file.add(page);
		file.add(prnt);
		file.add(new JSeparator());
		file.add(exit);
		
		edit.add(undo);
		edit.add(new JSeparator());
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.add(new JSeparator());
		edit.add(find);
		edit.add(next);
		edit.add(replace);
		edit.add(got);
		edit.add(new JSeparator());
		edit.add(select);
		edit.add(time);

		format.add(word);
		format.add(font);
		view.add(color);
		view.add(status);
		help.add(vhelp);
		help.add(new JSeparator());
		help.add(about);
 
		
		JScrollPane pan=new JScrollPane(txt);
		pan.getHorizontalScrollBar();
		pan.getVerticalScrollBar();
		con.add(panel);
		con.add(pan);
		//panel.setSize(getWidth(), 25);
		//panel.setAlignmentX(BOTTOM_ALIGNMENT);
		//panel.setAlignmentY(BOTTOM_ALIGNMENT);
		
		
		setJMenuBar(bar);
		
		newf.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		page.addActionListener(this);
		exit.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		find.addActionListener(this);
		next.addActionListener(this);
		replace.addActionListener(this);
		got.addActionListener(this);
		font.addActionListener(this);
		word.addActionListener(this);
		status.addActionListener(this);
		txt.addKeyListener(this);
		txt.setEditable(false);
		color.addActionListener(this);
		addKeyListener(this);
		addWindowListener(this);
		txt.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		txt.setFont(new Font("",Font.BOLD,30));
		txt.getCaret().setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		show();
		}
		
		public static void main(String arg[])throws Exception {
			notepadd obj=new notepadd();

			}

	
	
	//*********************Override ETHODS*******************************************

		public void actionPerformed(ActionEvent e){
			Object ob=e.getSource();
			txt.getCaret().setVisible(true);
			//***********FILE********************************************
			if(ob==newf){ NewFile();	}							//	*
			if(ob==open){ open();	}								//	*
			if(ob==save){ saveFile();	}							//  *
			if(ob==exit){ System.exit(0);  }						//  *
		//****************END OF FILE************************************
		
		//*****************EDIT***************************************
			if(ob==find){ obfind.show(); }
			if(ob==font){ obfont.show(); }		
			if(ob==got){ obgoto.show(); }
			if(ob==cut){ txt.cut(); }
			if(ob==paste){ txt.paste(); }
			if(ob==copy){ txt.copy(); }
			if(ob==replace){obreplace.show();}	
			if(ob==color){colour();}
			if(word.isSelected()){ txt.setLineWrap(true); }
			if(status.isSelected()){ statusBar();}

		}//end of actionListener			

	@Override
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		saved=false;
		char c = e.getKeyChar();
		System.out.println(c);
		char ch = unicodeConvert(c);
		int convert=(int)c;
		if(convert==8){
			
		}
		else if(convert==127){
			if(txt.getCaretPosition()>0){
				txt.replaceRange("",txt.getCaretPosition()-1 ,txt.getCaretPosition());
			}
		}
		else if(ch!=0){txt.insert(ch+"", txt.getCaretPosition());}
		txt.getCaret().setVisible(true);
	}//end of keyTyped
	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		NewFile();
		System.exit(0);}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}
	
	//*******************************METHODs*******************************
	void open(){
		Frame win=new Frame();
		FileDialog dialog=new FileDialog(win,"open....",FileDialog.LOAD);
		dialog.show();
		String s=dialog.getDirectory() + dialog.getFile();
		//txt.setText(s);
		try{
			File f=new File(s);
			InputStreamReader in=new InputStreamReader(new FileInputStream(f),"UTF8");
			String str="";
			int code=in.read();
			while(code!=-1){
				str= str+(char)code;
				txt.setText(str);
				code=in.read();
			}
				//System.out.println(str);
			
			txt.setText(str);
		}catch(Exception e1){}
	}


	////////////Unicode Converter Method\\\\\\\\\\\\\
	char unicodeConvert(char c){
		int con = (int)c;
		switch(con){
		case 8: return 0;//for Backspace
		case 127: return 0; //for delete
		case 32: return c;//for space 
		case 33: return c;//for !
		case 34: return c;//for "
		case 35: return c;//for #
		case 36: return c;//for $
		case 37: return c;//for %
		case 39: return c;//for '
		case 40: return c;//for (
		case 41: return c;//for )
		case 42: return c;//for *
		case 44: return '\u060c';//for ,
		case 46: return '\u06D4';//for .
		case 48: return '\u0660';//for 0
		case 49: return '\u0661';//for 1
		case 50: return '\u0662';//for 2
		case 51: return '\u0663';//for 3
		case 52: return '\u0664';//for 4
		case 53: return '\u0665';//for 5
		case 54: return '\u0666';//for 6
		case 55: return '\u0667';//for 7
		case 56: return '\u0668';//for 8
		case 57: return '\u0669';//for 9
		case 59: return '\u061B';//for ;
		case 60: return '\u064E';//for <
		case 62: return '\u0650';//for >
		case 63: return '\u061F';//for ?
		case 65: return '\u0622';//for A
		case 66: return '\u0613';//for B
		case 67: return '\u062B';//for C
		case 68: return '\u0688';//for D
		case 69: return '\u061F';//for E
		case 70: return '\u0670';//for F
		case 71: return '\u063A';//for G
		case 72: return '\u062D';//for H
		case 73: return '\u0627';//for I(***************************)reserved
		case 74: return '\u0636';//for J
		case 75: return '\u062E';//for K
		case 76: return '\u0612';//for L
		case 77: return '\u0622';//for M(***************************)reserved
		case 78: return '\u06BA';//for N
		case 79: return '\u0629';//for O
		case 80: return '\u064F';//for P
		case 81: return '\u0622';//for Q(***************************)
		case 82: return '\u0691';//for R
		case 83: return '\u0635';//for S
		case 84: return '\u0679';//for T
		case 85: return '\u060c';//for U
		case 86: return '\u0638';//for V
		case 87: return '\u0622';//for W(***************************)
		case 88: return '\u0698';//for X
		case 89: return '\u0601';//for Y
		case 90: return '\u0630';//for Z
		case 94: return '\u0600';//for ^
		case 92:return '\u0602';//for \
		case 95: return '\u0651';//for _
		case 97: return '\u0627';//for a
		case 98: return '\u0628';//for b
		case 99: return '\u0686';//for c
		case 100: return '\u062F';//for d
		case 101: return '\u0639';//for e
		case 102: return '\u0641';//for f
		case 103: return '\u06AF';//for g
		case 104: return '\u06BE';//for h
		case 105: return '\u06CC';//for i
		case 106: return '\u062C';//for j
		case 107: return '\u06A9';//for k
		case 108: return '\u0644';//for l
		case 109: return '\u0645';//for m
		case 110: return '\u0646';//for n	
		case 111: return '\u0647';//for o
		case 112: return '\u067E';//for p
		case 113: return '\u0642';//for q
		case 114: return '\u0631';//for r
		case 115: return '\u0633';//for s
		case 116: return '\u062A';//for t
		case 117: return '\u0621';//for u
		case 118: return '\u0637';//for v
		case 119: return '\u0648';//for w
		case 120: return '\u0634';//for x
		case 121: return '\u06D2';//for y
		case 122: return '\u0632';//for z
		case 124: return '\u0614';//for |
		default: return (char)con;
		}
	  
		}//end of unicode convert method
	///////////////////New File\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	void NewFile(){
		if(!saved){int s=JOptionPane.showConfirmDialog(null, "Text is not saved,Do you want to save? ", "Not saved", 0, 0, null);
		System.out.println(s);
		if(s==0){ saveFile(); }}
	txt.setText(""); saved =true;
	}
	
	///////////////////SAVE FILE METHOD\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
     void saveFile(){
    		JFrame win=new JFrame();							
			FileDialog dialog=new FileDialog(win,"Save",FileDialog.SAVE);	
			dialog.show();												
			String s=dialog.getDirectory() + dialog.getFile();		
			try{
			File f=new File(s);										
			if(!f.exists()){ f.createNewFile(); }					
			String str=txt.getText();								
			OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(f),"UTF8");
			out.write(str);										
			out.close();												
			}catch(Exception e1){}	
     } 
///////////////////STATUS BAR\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
     void statusBar(){
    	 
     }
	////////////Color Method\\\\\\\\\
	void colour(){
		Color c= JColorChooser.showDialog(getParent(),"Font color", Color.BLACK );
		txt.setForeground(c);
	
	}

}