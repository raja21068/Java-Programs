import java.awt.*;
import javax.swing.text.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.*;
public class Editor extends JFrame{
	JTextArea ta;
	JLabel lb;
	Editor(){              
                
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
                this.setSize((int)d.getWidth(),(int)d.getHeight()-30);
                this.setTitle("Urdu Text Editor");
		ta=new JTextArea();                                       
		ta.applyComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);


		addWindowListener(new WindowAdapter(){
			public void windowActivated(WindowEvent a){
				Caret c=ta.getCaret();
				c.setVisible(true);
			}
			public void windowClosing(WindowEvent w){
				System.exit(0);
			}
		});


		JScrollPane scroll=new JScrollPane(ta);
		this.add(scroll);
		this.add(lb=new JLabel("Rows=1"),BorderLayout.SOUTH);
		CreateMenus c=new CreateMenus(this,ta);
		JMenuBar bar=c.getMenuBar();
		this.setJMenuBar(bar);
		ta.setLineWrap(true);
		ta.addKeyListener(c);
		ta.setEditable(false);
		ta.setFont(new Font("Arial",Font.PLAIN,24));	
	        setVisible(true);

	}

             

	public static void main(String args[]){
		new Editor();
	}
}


//////////////////////////////CreateMenus  Class\\\\\\\\\\\\\\\\\\\\\\\\\\\\


class CreateMenus implements KeyListener{
	JMenuBar bar;
	JFrame frame;
	JTextArea ta;
        
      String copy1;
	boolean isDirty=false;
	String filePath="";

	CreateMenus(JFrame f,JTextArea ta){
		frame=f;
		this.ta=ta;
		bar=new JMenuBar();
		addFileMenu();
	}
	private void addFileMenu(){

	JMenu file,edit,format,view,help;
	JMenuItem n,o,s,sa,e,cut,copy,paste,sal,time,ca,bc,tc,fs,print,about_editor;
	JMenuItem saveHTML;
	file=new JMenu("File");
        edit=new JMenu("Edit");
        format=new JMenu("Format");
        view=new JMenu("view");
        help=new JMenu("Help");
        help.add(about_editor=new JMenuItem("About Editor"));

	        final Editor parent=(Editor)this.frame;
        
                file.add(n=new JMenuItem("New  "));
	
		file.setMnemonic((int)'F');




/////////////////////////////////////////New File\\\\\\\\\\\\\\\\\\\\\\\\\\


                n.setMnemonic((int)'N');

		n.addActionListener(new ActionListener(){ //Anonymouse class New_File
			public void actionPerformed(ActionEvent a){
				if(isDirty){
					int x=JOptionPane.showConfirmDialog(parent,"Text in the file has been changed! Do you want to save it?");
					if(x==0){
						saveFile();
						ta.setText("");
					}
					if(x==1){
						ta.setText("");

					}
				}
			}
		});



///////////////////////////////////////Open File\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

               


		file.add(o=new JMenuItem("Open  "));
                file.setMnemonic((int)'O');

		o.addActionListener(new ActionListener(){ //Anonymouse class Open_File
			public void actionPerformed(ActionEvent a){ 
				if(isDirty){
					int x=JOptionPane.showConfirmDialog(parent,"Text in the file has been changed! Do you want to save it?");
					if(x==0){
						saveFile();
						openFile();
					}
					if(x==1){
						openFile();

					}
				}
				else{
					openFile();
				}
			}
		});

  
         
//////////////////////////////////Save File\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


       
		file.add(s=new JMenuItem("Save  "));
                s.setMnemonic((int)'S');

                s.addActionListener(new ActionListener(){ //Anonymouse class Save_File
			public void actionPerformed(ActionEvent a){
				saveFile();

			}
		});

/////////////////////////////////Save As\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


                 file.add(sa=new JMenuItem("Save As"));

                 
                 sa.addActionListener(new ActionListener(){ //Anonymouse class Save_File
			public void actionPerformed(ActionEvent a){
				saveFile();

			}
		});


///////////////////////////////////Exit\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


//////////////////////////////// Save HTML /////////////////////////
		
		file.add(saveHTML=new JMenuItem("Save as HTML"));
		saveHTML.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				JTextPane jt=new JTextPane();
				jt.applyComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
				jt.setText(ta.getText());
				
/*********************************************************/
      JFileChooser chooser = new JFileChooser();
      if (chooser.showSaveDialog(parent) !=
            JFileChooser.APPROVE_OPTION)
        return;
      File file = chooser.getSelectedFile();
	String fName=file.getPath();
	if(fName.endsWith(".html")==false) fName=fName+".html";		
      if (file == null)
        return;
      OutputStreamWriter writer = null;
      try {
        writer = new OutputStreamWriter(new FileOutputStream(fName),"UTF16");
          MinimalHTMLWriter htmlWriter = new MinimalHTMLWriter(writer, 
            (StyledDocument)jt.getDocument());
        htmlWriter.write();
	writer.close();
      }
      catch (Exception ex) {
        JOptionPane.showMessageDialog(parent,
            "HTML File Not Saved", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
	

/*********************************************************/


			}
		});

		file.add(e=new JMenuItem("Exit"));
                e.addActionListener(new ActionListener(){ //Anonymouse class Save_File
			public void actionPerformed(ActionEvent a){
				System.exit(0);

			}
		});



/////////////////////////////////////Help\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                 about_editor.addActionListener(new ActionListener(){ //Anonymouse class Save_File
			public void actionPerformed(ActionEvent a){
				String text="Urdu Text Editor.\nThis Text Editor is developed in Java (jdk1.6)\nJAY KUMAR ";
				JOptionPane.showMessageDialog(parent,text);
	       											
			}
		});

///////////////////////////////////////Cut Code)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

               
                edit.add(cut=new JMenuItem("Cut "));
                cut.addActionListener(new ActionListener(){ //Anonymouse class cut_File 
                  public void actionPerformed(ActionEvent e)
                   {
			ta.setEditable(true);
			ta.cut();
			ta.setEditable(false);
			ta.getCaret().setVisible(true);

}
                });
		

////////////////////////////////////Copy Code\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


                edit.add(copy=new JMenuItem("Copy  "));
               copy.addActionListener(new ActionListener(){ //Anonymouse class copy_File
               public void actionPerformed(ActionEvent e)
                   {
			ta.setEditable(true);
			ta.copy();
			ta.setEditable(false);
			ta.getCaret().setVisible(true);

			}
                });
	       
                        


/////////////////////////////////Paste code\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                edit.add(paste=new JMenuItem("Paste  "));
                paste.addActionListener(new ActionListener(){ //Anonymouse class Paste_File
		public void actionPerformed(ActionEvent e)
                   {         
			ta.setEditable(true);
			ta.paste();
			ta.setEditable(false);
			ta.getCaret().setVisible(true);
		}

		});
                

//////////////////////////////////Select All\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


                 
                edit.add(sal=new JMenuItem("Select All  "));
                sal.addActionListener(new ActionListener(){ //Anonymouse class select_all_File
		public void actionPerformed(ActionEvent e)
                 {String seltext=ta.getText();
                  ta.select(0,seltext.length());
}

		});
///////////////////////////////////Time/Date\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



                edit.add(time=new JMenuItem("Time/Date  "));
                time.addActionListener(new ActionListener(){ //Anonymouse class Time\Date_File
		public void actionPerformed(ActionEvent e)
                 {ta.insert(new java.util.Date().toString(),ta.getSelectionStart());
	}

		});
                
/////////////////////////////////////Clear All\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


                edit.add(ca=new JMenuItem("Clear All"));
                ca.addActionListener(new ActionListener(){ //Anonymouse class Clear_all_ File
		public void actionPerformed(ActionEvent e)
                 {String seltext=ta.getText();
                  ta.replaceRange("",0,seltext.length());
}

		});

		JMenuItem goTo;
		edit.add(goTo=new JMenuItem("Go To"));
                goTo.addActionListener(new ActionListener(){ //Anonymouse class Clear_all_ File
		public void actionPerformed(ActionEvent e)
                 {
			String s=JOptionPane.showInputDialog(parent,"Enter the line number to go:");
			int go,lineCount=0,i;
			try{
				go=Integer.parseInt(s);
			}catch(Exception ee){
				return ;
			}
			String content=ta.getText();
			int l=content.length();
			for(i=0;i<l;i++){
				if(content.charAt(i)==13){
					lineCount++;
					if(lineCount>=go) break;
				}
			}
			ta.setCaretPosition(i);	
		 }
		});
///////////////////////////////////Color Code\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



                format.add(bc=new JMenuItem("Background"));
                bc.addActionListener(new ActionListener(){ //Anonymouse class_Color_file
			public void actionPerformed(ActionEvent a){
			Color c=JColorChooser.showDialog(parent,"Edit Colors",Color.black);
			        ta.setBackground(c);	
	        }
		});
                format.add(tc=new JMenuItem("Text Color"));
		tc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
                        	Color c=JColorChooser.showDialog(parent,"Edit Colors",Color.black);
			        ta.setForeground(c);
                   }
		});


//////////////////////////////////Font Size Style\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


                
                format.add(fs=new JMenuItem("Font"));
		fs.addActionListener(new ActionListener(){ //Anonymouse class Font_Size_File
			public void actionPerformed(ActionEvent a){
				final JDialog d=new JDialog(parent,"Font",true);
				d.setBounds(170,150,470,285);
                JLabel ft=new JLabel();
                ft.setText("Font Names");
                JLabel fs=new JLabel();
                ft.setText("Font Size");
                GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		String s[]=ge.getAvailableFontFamilyNames();
                String f[]={"10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
		String styles[]={"PLAIN","BOLD","ITALIC","BOLD ITALIC"};

                final JList fontNames=new JList(s);
                JScrollPane scroll1=new JScrollPane(fontNames);
		fontNames.setVisibleRowCount(8);

		final JList fontSize=new JList(f);
		JScrollPane scroll2=new JScrollPane(fontSize);
		fontSize.setVisibleRowCount(8);

		final JList fontStyle=new JList(styles);
		JScrollPane scroll3=new JScrollPane(fontStyle);
		fontStyle.setVisibleRowCount(8);

		Box box1=Box.createVerticalBox();
		Box box2=Box.createVerticalBox();
		Box box3=Box.createVerticalBox();
		Box box4=Box.createVerticalBox();

		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Font Name"));
		box1.add(scroll1);
		box2.add(Box.createVerticalStrut(10));
		box2.add(new JLabel("Font Size"));
		box2.add(scroll2);
		box3.add(Box.createVerticalStrut(10));
		box3.add(new JLabel("Font Style"));
		box3.add(scroll3);

		JButton ok,cancel;
		box4.add(ok=new JButton("OK"));
		box4.add(cancel=new JButton("CANCEL"));
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				d.dispose();
			}
		});
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				String name=(String)fontNames.getSelectedValue();
				String size=(String)fontSize.getSelectedValue();
				String style=(String)fontStyle.getSelectedValue();

				Font f=null;
				int sz=Integer.parseInt(size);
				if(style=="PLAIN"){
					f=new Font(name,Font.PLAIN,sz);
				}
				else if(style=="BOLD"){
					f=new Font(name,Font.BOLD,sz);
				}
				else if(style=="ITALIC"){
					f=new Font(name,Font.ITALIC,sz);
				}
				else if(style=="BOLD ITALIC"){
					f=new Font(name,Font.BOLD+Font.ITALIC,sz);
				}

				parent.ta.setFont(f);
			}
		});
		box4.add(Box.createVerticalStrut(50));

          
                

      		Box line=Box.createHorizontalBox();
		line.add(Box.createHorizontalStrut(10));
		line.add(box1);
		line.add(Box.createHorizontalStrut(10));
		line.add(box2);
		line.add(Box.createHorizontalStrut(10));
		line.add(box3);
		line.add(Box.createHorizontalStrut(10));
		line.add(box4);
		d.setLayout(new FlowLayout());
		d.add(line);


		d.setVisible(true);
			}
		});
               
                view.add(print=new JMenuItem("Print"));
                print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				try{
					ta.print();
				}catch(Exception e){
					JOptionPane.showMessageDialog(parent,e.toString());
				}
			}
		});
               
		bar.add(file);
                bar.add(edit);
                bar.add(format);
                bar.add(view);
                bar.add(help);
	}
	private void addEditMenu(){
	}
	public JMenuBar getMenuBar(){
		return bar;
	}

	private void saveFile(){
		JFrame parent=frame;
		if(isDirty==true){
			if(filePath==""){
				JFileChooser f=new JFileChooser();
                                f.showSaveDialog(parent);			
				File file=f.getSelectedFile();
				filePath=file.getPath();
			        try{

					FileOutputStream fos=new FileOutputStream(file);
					OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF8");
					String content=ta.getText();
					char ch[]=content.toCharArray();
					osw.write(ch,0,ch.length);
					osw.close();
					fos.close();

				}catch(Exception e){
			                System.out.print("Exception");	
				}
			}
			else{
			        try{

					FileOutputStream fos=new FileOutputStream(filePath);
					OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF8");
					char ch[]=ta.getText().toCharArray();
					osw.write(ch,0,ch.length);
					osw.close();
					fos.close();
				}catch(Exception e){
			                System.out.print("Exception");	
				}

			}
			isDirty=false;
		}
	}
	private void openFile(){
            JFrame parent=frame;
            JFileChooser f=new JFileChooser();
            f.showOpenDialog(parent);			
		File file=f.getSelectedFile();
            try{

		FileInputStream fis=new FileInputStream(file.getPath());
		InputStreamReader isr=new InputStreamReader(fis,"UTF8");
		int x=0;
		String text="";
		while(x!=-1){
			x=isr.read();
			if(x!=-1)
				text=text + (char) x;
		}
		ta.setText(text);
		isr.close();
		fis.close();
		isDirty=false;
		}catch(Exception e){
	                System.out.println("Exception");
		}
	}
/////////////////////////key listeners\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		public void keyPressed(KeyEvent k){}
		public void keyReleased(KeyEvent k){}
		public void keyTyped(KeyEvent k){
			
			int code=k.getKeyChar();
			String newLine= ""+ (char)13 + (char)10;
			int l=ta.getText().length();
			if(code==8){
				int pos=ta.getCaretPosition();

				if(pos<l){
					ta.replaceRange("",pos,pos+1);
				}
			}
			else if(code==127){
				int pos=ta.getCaretPosition();

				if(pos>0){
					ta.replaceRange("",pos-1,pos);
				}
			}
			else if(code==10){
				ta.insert(newLine,ta.getCaretPosition());
			}
			else{
				char ch=convert(code);
				if(ch!=0){
					ta.insert(ch+"",ta.getCaretPosition());
				}
			}
			isDirty=true;

			Editor e=(Editor)frame; 
			e.lb.setText("Rows="+ta.getLineCount());

		}
///////////////////////////////////////Print Code ////////////////////////////////////////////////

                     //  parent.print(ta);


//////////////////////////////////mapping\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
public char convert(int x){
	char AsciiToUnicode=0;
	switch(x){
	        case 13:  AsciiToUnicode = 13;break;
	        case 63:  AsciiToUnicode = '\u061F';break;
        	case 65:  AsciiToUnicode = '\u0622';break;
	        case 66:  AsciiToUnicode = '\u0698';break;
        	case 67:  AsciiToUnicode = '\u062B';break;
	        case 68:  AsciiToUnicode = '\u0688';break;
	        case 71:  AsciiToUnicode = '\u063A';break;
	        case 72:  AsciiToUnicode = '\u062D';break;
        case 73:  AsciiToUnicode = '\u0651';break;
        case 74:  AsciiToUnicode = '\u0636';break;
        case 75:  AsciiToUnicode = '\u062E';break;
        case 78:  AsciiToUnicode = '\u06BA';break;
        case 79:  AsciiToUnicode = '\u0629';break;
        case 80:  AsciiToUnicode = '\u06C1';break;
        case 82:  AsciiToUnicode = '\u0691';break;
        case 83:  AsciiToUnicode = '\u0635';break;
        case 84:  AsciiToUnicode = '\u0679';break;
        case 85:  AsciiToUnicode = '\u0626';break;
        case 86:  AsciiToUnicode = '\u0638';break;
        case 87:  AsciiToUnicode = '\u0676';break;
        case 88:  AsciiToUnicode = '\u0670';break;
        case 89:  AsciiToUnicode = '\u06D2';break;
        case 90:  AsciiToUnicode = '\u0630';break;
        case 97:  AsciiToUnicode = '\u0627';break;
        case 98:  AsciiToUnicode = '\u0628';break;
        case 99:  AsciiToUnicode = '\u0686';break;
        case 100: AsciiToUnicode = '\u062F';break;
        case 101: AsciiToUnicode = '\u0639';break;
        case 102: AsciiToUnicode = '\u0641';break;
        case 103: AsciiToUnicode = '\u06AF';break;
        case 104: AsciiToUnicode = '\u06BE';break;
        case 105: AsciiToUnicode = '\u06D3';break;
        case 106: AsciiToUnicode = '\u062C';break;
        case 107: AsciiToUnicode = '\u06A9';break;
        case 108: AsciiToUnicode = '\u0644';break;
        case 109: AsciiToUnicode = '\u0645';break;
        case 110: AsciiToUnicode = '\u0646';break;
        case 111: AsciiToUnicode = '\u0647';break;
        case 112: AsciiToUnicode = '\u067E';break;
        case 113: AsciiToUnicode = '\u0642';break;
        case 114: AsciiToUnicode = '\u0631';break;
        case 115: AsciiToUnicode = '\u0633';break;
        case 116: AsciiToUnicode = '\u062A';break;
        case 117: AsciiToUnicode = '\u0621';break;
        case 118: AsciiToUnicode = '\u0637';break;
        case 119: AsciiToUnicode = '\u0648';break;
        case 120: AsciiToUnicode = '\u0634';break;
        case 121: AsciiToUnicode = '\u06CC';break;
        case 122: AsciiToUnicode = '\u0632';break;
//        case 63:  AsciiToUnicode = '\u061F';break;
        case 59:  AsciiToUnicode = '\u061B';break;


        case 48:  AsciiToUnicode = '\u0660';break;
        case 49:  AsciiToUnicode = '\u0661';break;
        case 50:  AsciiToUnicode = '\u0662';break;
        case 51:  AsciiToUnicode = '\u0663';break;
        case 52:  AsciiToUnicode = '\u0664';break;
        case 53:  AsciiToUnicode = '\u0665';break;
        case 54:  AsciiToUnicode = '\u0666';break;
        case 55:  AsciiToUnicode = '\u0667';break;
        case 56:  AsciiToUnicode = '\u0668';break;
        case 57:  AsciiToUnicode = '\u0669';break;



        case 44:  AsciiToUnicode = '\u060C';break;
        case 37:  AsciiToUnicode = '\u066A';break;
        case 69:  AsciiToUnicode = '\u0674';break;
        case 46:  AsciiToUnicode = '\u06D4';break;
        case 77:  AsciiToUnicode = '\u064E';break;
        case 76:  AsciiToUnicode = '\u0650';break;
        case 81:  AsciiToUnicode = '\u064F';break;
        case 58:  AsciiToUnicode = '\u003A';break;
        case 34:  AsciiToUnicode = '\u0022';break;


       case 39:  AsciiToUnicode = 39;break;


        case 47:  AsciiToUnicode = '\u002F';break;

        case 60:  AsciiToUnicode = '\u003C';break;
        case 62:  AsciiToUnicode = '\u003E';break;

        case 92:  AsciiToUnicode = 92;break;

        case 91:  AsciiToUnicode = '\u005B';break;
        case 93:  AsciiToUnicode = '\u005D';break;
        case 123: AsciiToUnicode = '\u007B';break;
        case 125: AsciiToUnicode = '\u007D';break;
        case 166: AsciiToUnicode = '\u00A6';break;
        case 33:  AsciiToUnicode = '\u0021';break;
        case 64:  AsciiToUnicode = '\u0040';break;
        case 35:  AsciiToUnicode = '\u0023';break;
        case 36:  AsciiToUnicode = '\u0024';break;
        case 94:  AsciiToUnicode = '\u005E';break;
        case 38:  AsciiToUnicode = '\u0026';break;
        case 42:  AsciiToUnicode = '\u002A';break;
        case 40:  AsciiToUnicode = '\u0028';break;
        case 41:  AsciiToUnicode = '\u0029';break;
        case 45:  AsciiToUnicode = '\u002D';break;
	        case 43:  AsciiToUnicode = '\u002B';break;
        	case 61:  AsciiToUnicode = '\u003D';break;
		case 32:  AsciiToUnicode = '\u0020';break;
		default:
        	    AsciiToUnicode = 0;break;
		}
		return AsciiToUnicode;
	}

}   
       

