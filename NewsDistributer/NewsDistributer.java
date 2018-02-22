import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Font;

public class NewsDistributer extends JFrame implements ActionListener
{
	private Container c;
	private JPanel openFilePanel = new JPanel();
	JTextField openFileText = new JTextField();
	private JButton openFileButton = new JButton("Open");
	private JButton distributionButton = new JButton("Distribute");
	private JPanel distributionPanel = new JPanel();
	JList list = new JList();
	private JLabel availableDocsLabel = new JLabel("Available Documents");
	private JLabel bigramLabel = new JLabel("Bi-gram");
	private JLabel trigramLabel = new JLabel("Tri-gram");
	private JTable bigramTable = new JTable();
	private JTable trigramTable = new JTable();
	private DefaultTableModel bigramModel = new DefaultTableModel();
	private DefaultTableModel trigramModel = new DefaultTableModel();
	private JProgressBar bar = new JProgressBar();
	private JTextArea area = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem categoryForm, ngramForm, clearAll, exit;
	
	private NewsDistributer()
	{
		setBounds(300,50,500,650);
		setTitle("Daily News Distributer");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		
		menuBar.setBounds(0,0,500,20);
		JMenu file = new JMenu("File");
		file.add(categoryForm = new JMenuItem("Category Form"));
		file.add(ngramForm = new JMenuItem("N-gram Form"));
		file.add(clearAll = new JMenuItem("Clear All "));
		file.add(exit = new JMenuItem("Exit"));
		menuBar.add(file);
		c.add(menuBar);
		
		openFilePanel.setLayout(null);
		openFilePanel.setBounds(10,30,470,100);
		openFilePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Open File"));
		openFileText.setBounds(20,40,320,30);
		openFilePanel.add(openFileText);
		openFileButton.setBounds(350,44,100,25);
		openFilePanel.add(openFileButton);
		c.add(openFilePanel);
		
		distributionButton.setBounds(10,135,470,30);
		c.add(distributionButton);
		
		distributionPanel.setLayout(null);
		distributionPanel.setBounds(10,170,470,300);
		distributionPanel.setBorder(BorderFactory.createEtchedBorder());
		availableDocsLabel.setBounds(30,5,230,30);
		availableDocsLabel.setFont(new Font("arial",Font.BOLD,18));
		distributionPanel.add(availableDocsLabel);
		JScrollPane jsp1 = new JScrollPane(list);
		jsp1.setBounds(10,30,230,220);
		distributionPanel.add(jsp1);
		bigramLabel.setBounds(320,5,150,30);
		bigramLabel.setFont(new Font("arial",Font.BOLD,18));
		distributionPanel.add(bigramLabel);
		trigramLabel.setBounds(320,125,150,30);
		trigramLabel.setFont(new Font("arial",Font.BOLD,18));
		distributionPanel.add(trigramLabel);
		initTables();
		bar.setBounds(10,265,450,25);
		bar.setStringPainted(true);
		distributionPanel.add(bar);
		c.add(distributionPanel);
		
		area.setEditable(false);
		JScrollPane jsp2 = new JScrollPane(area);
		jsp2.setBounds(10,480,470,130);
		c.add(jsp2);
		
		openFileButton.addActionListener(this);
		ngramForm.addActionListener(this);
		categoryForm.addActionListener(this);
		exit.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == openFileButton)
			new Open(this);
		
		else if(e.getSource() == ngramForm)
			new NGramsForm(this);
		
		else if(e.getSource() == categoryForm)
			new CategoryForm(this);
		
		else if(e.getSource() == exit)
			System.exit(0);
	}
	
	private void initTables()
	{
		bigramTable.setModel(bigramModel);
		bigramModel.addColumn("Category");
		bigramModel.addColumn("Quantity");
		bigramModel.addColumn("Entity");
		JScrollPane jsp1 = new JScrollPane(bigramTable);
		jsp1.setBounds(250,30,205,100);
		distributionPanel.add(jsp1);
		
		trigramTable.setModel(trigramModel);
		trigramModel.addColumn("Category");
		trigramModel.addColumn("Quantity");
		trigramModel.addColumn("Entity");
		JScrollPane jsp2 = new JScrollPane(trigramTable);
		jsp2.setBounds(250,150,205,100);
		distributionPanel.add(jsp2);
		
	}
	
	public static void main(String arg[])
	{
		new NewsDistributer();
	}
}
