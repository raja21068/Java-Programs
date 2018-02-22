import javax.swing.*;
import java.io.*;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.table.*;

public class FileWordsCount extends JFrame implements ActionListener{

	JTextArea textArea;
	JScrollPane ScrollTextArea;
	JButton BrowseBtn;
	JButton CountBtn;
	JLabel CountWithoutLbl,withoutLbl;
	JLabel TotalWords,totalLbl;
	JTable table;
	DefaultTableModel TModel;
	JScrollPane TableScroll;
	FileDialog dialog;
	String fileData=new String();
	String[] rows={"Words","repeated"};
	
	FileWordsCount(){
	
		//**Declaration Of Components**
		textArea=new JTextArea();
		ScrollTextArea=new JScrollPane(textArea);
		BrowseBtn=new JButton("Browse");
		CountBtn=new JButton("Count Words");
		CountWithoutLbl=new JLabel("Without repeat:");
		table=new JTable();
		TModel=(DefaultTableModel)table.getModel();
		TableScroll=new JScrollPane(table);
		dialog=new FileDialog(this,"open",FileDialog.LOAD);
		TotalWords=new JLabel("Total Words:");
		totalLbl=new JLabel();
		withoutLbl=new JLabel();
		
		//Frame Attribute Setting
		setBounds(0,0,600,700);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		show();
		
		//setting table
		TModel.addColumn(rows[0]);
		TModel.addColumn(rows[1]);
		
		//Setting bounds Of Components
		ScrollTextArea.setBounds(30, 20, 500, 400);
		BrowseBtn.setBounds(50, 430,160,25);
		CountBtn.setBounds(220,430,160,25);
		TotalWords.setBounds(50,470,100,25);
		totalLbl.setBounds(150,470,50, 25);
		CountWithoutLbl.setBounds(50,500,100,25);
		withoutLbl.setBounds(150,500,50,25);
		TableScroll.setBounds(30,530,500,100);
		
		//font of text area
		textArea.setFont(new Font("Comic Sans MS",Font.BOLD,12));
		
		//Adding Components In Frame
		getContentPane().add(ScrollTextArea);
		getContentPane().add(BrowseBtn);
		getContentPane().add(CountBtn);
		getContentPane().add(CountWithoutLbl);
		getContentPane().add(TotalWords);
		getContentPane().add(totalLbl);
		getContentPane().add(withoutLbl);
		getContentPane().add(TableScroll);
		
		//Register Components With Listener
		BrowseBtn.addActionListener(this);
		CountBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		//Condition Of Browse Button 
		if(ob==BrowseBtn){
			dialog.show();
			 try {
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String file=dialog.getDirectory()+dialog.getFile();
			String s;
			try{
				DataInputStream in=new DataInputStream(new FileInputStream(file));
				while((s=in.readLine())!=null){
					fileData+=s;
					fileData+="\n";
					}
				textArea.setText(fileData);
				
			}catch(Exception e1){}
		}//end of condition of browse button
		
		//Condition Of Count Button
		if(ob==CountBtn){
			if(textArea.getText().equals("")){
				totalLbl.setText("0");
				return;
			}
			
			String str2[]=textArea.getText().split("\n");
			java.util.Vector<String> words = new java.util.Vector<String>();
			
			for(int i=0;i<str2.length;i++){
				if(str2[i].trim().length() < 1) continue;
				String str[]=str2[i].split(" ");
				for(int j=0; j<str.length; j++){
					if(str[j].trim().length() > 0){
//						if(!words.contains(str2[i].trim() )){
						words.addElement(str[j].trim());
					}
				}
			}
			java.util.Vector<String> wRepeatWords = new java.util.Vector<String>();
			java.util.Vector<String> repeated = new java.util.Vector<String>();
			for(int i=0;i<words.size();i++){
				boolean b = true;
				boolean contain = true;
				for(int j=0; j<wRepeatWords.size(); j++){
					if(wRepeatWords.contains(words.elementAt(i))){	
						b = false;
						break;
					}
				}
				if(b) wRepeatWords.addElement(words.elementAt(i));
			}
			
			totalLbl.setText(""+words.size());
			this.withoutLbl.setText(""+wRepeatWords.size());
			
			/////////////////////////seperating///////////////////////
			String rR[][]=new String[words.size()][2];
			System.out.println(wRepeatWords.size()+": wRepeatWords.size()");
			int index=-1;
			for(int i=0;i<words.size();i++){
				boolean b = true;
				boolean contain = true;
				for(int j=0; j<wRepeatWords.size(); j++){
					if(wRepeatWords.contains(words.elementAt(i))){
						for(int k=0;k<rR.length;k++){
							if(rR[k][0]==null)break;
							if(rR[k][0].equals(words.elementAt(i))){			
								int l;
								try{
								l=Integer.parseInt(rR[k][1]);
								}
								catch(Exception e1){l=1;  }
								l++;
								rR[k][1]=""+l;
								contain = false;
							}
						}
						if(contain){ rR[++index][0]=words.elementAt(i);}
						b = false;
						break;
					}
				}
			}
			/////////////////////////////////////////////////////////
			
			////////////////////********//visiting//////////////////////
			for(int i=0;i<rR.length;i++){
				System.out.println();
				if(rR[i][1]!=null){ TModel.addRow(rR[i]); }
			//	for(int j=0;j<2;j++){
				//	System.out.print(rR[i][j]+"        ");
			//	}
			}
			///////////////////***************////////////////////////////
			
			
		}//end of condition of count button
	}//end of actionPerformed
	public static void main(String arg[]){
		new FileWordsCount();
	}
}//end of class

