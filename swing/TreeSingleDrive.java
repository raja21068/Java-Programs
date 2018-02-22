import javax.swing.tree.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

class TreeSingleDrive {

	JFrame win=new JFrame();
	DefaultMutableTreeNode t=new DefaultMutableTreeNode("main2");
	DefaultMutableTreeNode tee[];
	static int count=-1;
	File edrive=new File("D:\\");
	
	TreeSingleDrive(){
				String s[]=edrive.list();
				
				for(int i=0;i<s.length;i++){
					System.out.println(s[i]);
					if(!s[i].contains(".")){ 
						String ss[];
							ss=new File(s[i]).list();
						//String st[]=new File(ss).list();
						System.out.println(ss);
					//for(int inn=0;inn<st.length;inn++)       
					//System.out.println("in "+s[i]+":"+st[inn]);
						}
					
				}
		
				JTree te=new JTree(t);
		win.add(te);
		win.setBounds(0,0,800,800);
		win.show();
		
	}
		void getf(File f){ 
			String temp[]=f.list();
			DefaultMutableTreeNode add[]=new DefaultMutableTreeNode[temp.length];
			for(int i=0;i<temp.length;i++){
				add[i].add(new DefaultMutableTreeNode(temp[i]));		
			}
			DefaultMutableTreeNode a=new DefaultMutableTreeNode(f);
			JTree te=new JTree(a);
			win.add(te);
		}
	public static void main(String arg[]){
		new TreeSingleDrive();
	}
}
