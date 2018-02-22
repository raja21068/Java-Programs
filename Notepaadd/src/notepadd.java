import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.*;

class notepadd extends JFrame implements ActionListener{
 
	JTextArea txt=new JTextArea();

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
		setTitle("Notepad");
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
		view.add(status);
		help.add(vhelp);
		help.add(new JSeparator());
		help.add(about);
 
		JScrollPane pan=new JScrollPane(txt);
		pan.getHorizontalScrollBar();
		pan.getVerticalScrollBar();
		con.add(pan);
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		show();
		}

	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		//***********FILE********************************************
		if(ob==newf){}											//	*
																//  *
		if(ob==open){											//  *
			open();												//  *	
		}//end of open												*
		if(ob==save){	
			JFrame win=new JFrame();							//  *
			FileDialog dialog=new FileDialog(win,"Save",FileDialog.SAVE);	
			dialog.show();											//*	
			String s=dialog.getDirectory() + dialog.getFile();		//*
			try{
			File f=new File(s);										//*
			if(!f.exists()){ f.createNewFile(); }					//*
			String str=txt.getText();								//*
			PrintStream out=new PrintStream(new FileOutputStream(f));
			out.println(str);										//*
																	//*
			}catch(Exception e1){}									//*
									}								//*
		if(ob==exit){ System.exit(0);  }							//*
	//****************END OF FILE**************************************
	
	//*****************EDIT***************************************
		if(ob==find){ obfind.show(); }
		if(ob==font){ obfont.show(); }		
		if(ob==got){ obgoto.show(); }
		if(ob==cut){ txt.cut(); }
		if(ob==paste){ txt.paste(); }
		if(ob==copy){ txt.copy(); }
		if(ob==replace){obreplace.show();}	
		if(word.isSelected()){ txt.setLineWrap(true); }

	}//end of actionListener			

	public static void main(String arg[])throws Exception {
	notepadd obj=new notepadd();

	}
	
	//*********************METHODS*******************************************
	//***********************************************************************
	void open(){
		Frame win=new Frame();
		FileDialog dialog=new FileDialog(win,"open....",FileDialog.LOAD);
		dialog.show();
		String s=dialog.getDirectory() + dialog.getFile();
		//txt.setText(s);
		try{
			File f=new File(s);
			DataInputStream in=new DataInputStream(new FileInputStream(f));
			String str="";
			s="";
			while((str=in.readLine())!=null){
				//System.out.println(str);
				s+=str;
				s+="\n";
			}
			txt.setText(s);
		}catch(Exception e1){}
	}

void cut(){
	
}
}