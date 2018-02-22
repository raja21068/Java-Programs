import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Browser extends JFrame implements ActionListener,MouseListener{
	JEditorPane editPane=new JEditorPane();
	Toolkit tool=Toolkit.getDefaultToolkit();
	
	Browser(){
		setLayout(new FlowLayout());
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setSize(tool.getScreenSize());
		getContentPane().add(editPane);
		try{
		editPane.setPage("http://www.yahoo.com");
		}
		catch(Exception e){ System.out.println(e); }
		addMouseListener(this);
		show();
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	public static void main(String arg[]){
		new Browser();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
