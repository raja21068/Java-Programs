import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TestWin extends JWindow implements ActionListener {

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	ImageIcon pic1=(new ImageIcon("e:/pictures/puzzlepic/iori1.jpg"));
	ImageIcon pic2=(new ImageIcon("e:/pictures/puzzlepic/iori2.jpg"));
	ImageIcon pic3=(new ImageIcon("e:/pictures/puzzlepic/iori3.jpg"));
	ImageIcon pic4=(new ImageIcon("e:/pictures/puzzlepic/iori4.jpg"));
	ImageIcon pic5=(new ImageIcon("e:/pictures/puzzlepic/iori5.jpg"));
	ImageIcon pic6=(new ImageIcon("e:/pictures/puzzlepic/iori6.jpg"));
	ImageIcon pic7=(new ImageIcon("e:/pictures/puzzlepic/iori7.jpg"));
	ImageIcon pic8=(new ImageIcon("e:/pictures/puzzlepic/iori8.jpg"));
	ImageIcon pic9=(new ImageIcon("e:/pictures/puzzlepic/iori9.jpg"));
	ImageIcon pic10=(new ImageIcon("e:/pictures/puzzlepic/iori10.jpg"));
	ImageIcon pic11=(new ImageIcon("e:/pictures/puzzlepic/iori11.jpg"));
	ImageIcon pic12=(new ImageIcon("e:/pictures/puzzlepic/iori12.jpg"));
	ImageIcon pic13=(new ImageIcon("e:/pictures/puzzlepic/iori3.jpg"));
	ImageIcon pic14=(new ImageIcon("e:/pictures/puzzlepic/iori4.jpg"));
	ImageIcon pic15=(new ImageIcon("e:/pictures/puzzlepic/iori15.jpg"));
	JFrame win=new JFrame();

	public TestWin() {
		super(new JFrame());
		Container con=win.getContentPane();
		setBounds(0,0,500,500);
		con.setLayout(new GridLayout(4,4));
		b1=new JButton(pic2);
		b1.setText("2");
		b2=new JButton(pic3);
		b2.setText("3");
		b3=new JButton(pic15);
		b3.setText("15");
		b4=new JButton(pic9);
		b4.setText("9");
		b5=new JButton(pic1);
		b5.setText("1");
		b6=new JButton(pic6);
		b6.setText("6");
		b7=new JButton(pic7);
		b7.setText("7");
		b8=new JButton(pic8);
		b8.setText("8");
		b9=new JButton(pic12);
		b9.setText("12");
		b10=new JButton(pic14);
		b10.setText("14");
		b11=new JButton(pic5);
		b11.setText("5");
		b12=new JButton(pic13);
		b12.setText("13");
		b13=new JButton(pic10);
		b13.setText("10");
		b14=new JButton(pic4);
		b14.setText("4");
		b15=new JButton(pic11);
		b15.setText("11");
		b16=new JButton("");
		con.add(b1);
		con.add(b2);
		con.add(b3);
		con.add(b4);
		con.add(b5);
		con.add(b6);
		con.add(b7);
		con.add(b8);
		con.add(b9);
		con.add(b10);
		con.add(b11);
		con.add(b12);
		con.add(b13);
		con.add(b14);
		con.add(b15);
		con.add(b16);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		
		show();
	}

	public static void main(String[] args) {
		new TestWin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
