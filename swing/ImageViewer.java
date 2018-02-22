import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageViewer extends JFrame implements ActionListener {
 
	JButton next,previous,zoomin,zoomout,turnc,turna;
	JPanel buttonpanel=new JPanel(); 
	JPanel imagepanel=new JPanel();
	Toolkit k=Toolkit.getDefaultToolkit();
	String[] str={"e:/pictures/runing.png","e:/pictures/ryu.png","e:/pictures/level 2.jpg","e:/pictures/wall.jpg"};
	ImageIcon icon=new ImageIcon(str[0]);
	int i=0;
	JLabel label=new JLabel(icon);
	
	ImageViewer(){
	Container con=getContentPane();
	setSize(k.getScreenSize());
	previous=new JButton("<");
	next=new JButton(">");
	zoomin=new JButton("0+");
	zoomout=new JButton("0-");
	turnc=new JButton("/^");
	turna=new JButton("^\\");
	buttonpanel.setLayout(new FlowLayout());
	imagepanel.setLayout(new BorderLayout());
	imagepanel.add(label);
	con.add(buttonpanel,BorderLayout.SOUTH);
	con.add(imagepanel);
	
	next.addActionListener(this);
	previous.addActionListener(this);
	zoomin.addActionListener(this);
	zoomout.addActionListener(this);
	turnc.addActionListener(this);
	turna.addActionListener(this);
	
	buttonpanel.add(previous);
	buttonpanel.add(next);	
	buttonpanel.add(zoomin);
	buttonpanel.add(zoomout);
	buttonpanel.add(turnc);
	buttonpanel.add(turna);
	
	show();
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==next){
			if(i==str.length-1){i=-1;}
			label.hide();
			icon=new ImageIcon(str[++i]);
			label=new JLabel(icon);
		System.out.println("picture["+i+"]is called");
		imagepanel.add(label);
		show();
		}
		
		if(obj==previous){
			if(i==0){i=str.length;}
			label.hide();
			icon=new ImageIcon(str[--i]);
			label=new JLabel(icon);
			imagepanel.add(label);
			System.out.println("picture["+i+"]is called");
			show();
				
		}
	}

	public static void main(String[] args) {
		new ImageViewer();

	}

}
