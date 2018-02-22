import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class TreeDrive extends JFrame implements ActionListener,ItemListener {
	JComboBox combo=new JComboBox();
	JButton refresh=new JButton("Refresh");
	List flist=new List();
	int action=0;
	DefaultMutableTreeNode t=new DefaultMutableTreeNode("m2");
	JTree tmain=new JTree(t);
	static int count=-1;
	File f=new File("C:");
	JScrollPane pane=new JScrollPane(tmain);
	 DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	
	TreeDrive(){
		Container con=getContentPane();		
		con.setLayout(null);
		combo.setBounds(39, 39, 92, 29);
		con.add(combo);	
		refresh.setBounds(180, 39, 100, 30);
		con.add(refresh);
		refresh.addActionListener(this);
		flist.setBounds(500, 40, 200, 600);
		con.add(flist);
		tmain.setBounds(39, 70, 400, 600);
		con.add(tmain);
		combo.addItemListener(this);
		con.add(pane);
		setBounds(0,0,800,800);
		show();
	}
	public static void main(String arg[]){
		new TreeDrive();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==refresh){
			File f2[]=f.listRoots();
			if(action==0){
			for(int i=0;i<f2.length;i++){
				
				combo.addItem(f2[i]);
				show();
				action++;
			}//end of for
			}//end of if action
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		Object ob=combo.getSelectedItem();
		flist.clear();
		tmain.clearSelection();
		String s=ob.toString();
		f=new File(s);
		teree(f);
	}
	void teree(File f){
		
		String str[]=f.list();
		String s=f.getPath();
		for(int i=0;i<str.length;i++){
			System.out.println(s+str[i]);
			if(new File(s+str[i]).isDirectory()){
			DefaultMutableTreeNode tee=new DefaultMutableTreeNode(str[i]);
			renderer.setLeafIcon((Icon) tee);
				//JTree teee=new JTree(new DefaultMutableTreeNode(str[i]));
				t.add(tee);
			}
			else { flist.add(str[i]); }
			
		}
		show();
	}
}
