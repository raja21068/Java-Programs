import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Client extends JFrame implements ActionListener
{
	
	private Container c;
	JTextField ipText = new JTextField("127.0.0.1");
	JTextField browseText = new JTextField();
	private JButton browseButton = new JButton("Browse");
	private JButton transferButton = new JButton("Transfer File");
	
	private Client()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();
		
		setBounds(width/4,height/10,600,240);
		setTitle("Client");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		
		JLabel enterIP = new JLabel("Enter I.P :");
		enterIP.setBounds(30,20,100,30);
		enterIP.setForeground(Color.red);
		enterIP.setFont(new Font("Arial",Font.BOLD,20));
		c.add(enterIP);
		ipText.setBounds(150,20,150,30);
		ipText.setForeground(Color.blue);
		ipText.setFont(new Font("Century",Font.BOLD,18));
		ipText.setCaretPosition(ipText.getText().length());
		c.add(ipText);
		
		JPanel p = new JPanel();
		p.setBounds(25,60,550,80);
		p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Browse"));
		p.setLayout(null);
		c.add(p);
		
		browseText.setBounds(10,35,420,30);
		browseText.setFont(new Font("Century",Font.BOLD,15));
		p.add(browseText);
		browseButton.setBounds(437,39,100,25);
		p.add(browseButton);
		
		transferButton.setBounds(150,150,300,40);
		c.add(transferButton);
		
		browseButton.addActionListener(this);
		transferButton.addActionListener(this);
		setVisible(true);
	}
	
	public static void main(String arg[])
	{
		new Client();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == browseButton)
		{
			String filePath = openFile();
			if(!filePath.equals(""))
				browseText.setText(filePath);
		}
		
		else if(e.getSource() == transferButton)
		{
			if(!ipText.getText().equals("") && !browseText.getText().equals(""))
			{
				if(new java.io.File(browseText.getText()).exists())
					new SendingThread(this);
				
				else
					JOptionPane.showMessageDialog(null, "No such file exist in your system...");
			}
			else
				JOptionPane.showMessageDialog(null, "Either File Path of I.P is missing...");
		}
	}
	
	
	private String openFile()
	{
		String filePath = "";
		
		FileDialog d = new FileDialog(new JDialog(),"Browse...",FileDialog.LOAD);
		d.setVisible(true);
		
		if(d.getDirectory() != null)
			filePath = d.getDirectory() + d.getFile();
		
		return filePath;
	}
}
