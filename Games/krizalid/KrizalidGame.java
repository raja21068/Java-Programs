import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KrizalidGame implements ActionListener {

	JFrame win=new JFrame();
	JButton newgame=new JButton("New Game");
	JButton keys=new JButton("Control Keys");
	JButton exit=new JButton("EXIT");
	JLabel back=new JLabel(new ImageIcon("kof1.jpg"));
	
	KrizalidGame(){
		Container con=win.getContentPane();
		con.setLayout(null);
		win.setBounds(0,0,920,600);
		newgame.setBackground(Color.magenta);
		newgame.setBounds(100, 100, 200, 60);
		con.add(newgame);
		keys.setBackground(Color.magenta);
		keys.setBounds(100, 200, 200, 60);
		con.add(keys);
		exit.setBackground(Color.magenta);
		exit.setBounds(100, 300, 200, 60);
		con.add(exit);
		back.setBounds(0, 0, 920, 600);
		con.add(back);
		newgame.addActionListener(this);
		keys.addActionListener(this);
		exit.addActionListener(this);
		
		win.show();
	}
	
	public void actionPerformed(ActionEvent e){
		Object ob=e.getSource();
		if(ob==newgame){ win.hide(); Krizalid g=new Krizalid();  }
		if(ob==keys){ JOptionPane.showMessageDialog(null, " LEFT   -->\nRIGHT<--\n fire  f "); }
		if(ob==exit){ win.hide(); }
	}
	
	public static void main(String[] args) {
		new KrizalidGame();

	}

}
