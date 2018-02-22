import javax.swing.*;
import javax.swing.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;

class NGramsForm extends JDialog implements ActionListener, ItemListener
{
	 JLabel gramsFormLabel = new JLabel("N-Grams Form");
	 JPanel browsePanel = new JPanel();
	 JLabel sourceLabel = new JLabel("Source");
	 JTextField browseText = new JTextField();
	 JButton browseButton = new JButton("Browse");
	 JButton generateButton = new JButton("Generate Grams");
	 JList list = new JList();
	 JButton clearButton = new JButton("Clear");
	 JButton addButton = new JButton("Add");
	 JProgressBar bar = new JProgressBar();
	 JLabel selectCatLabel = new JLabel("Select Category :");
	 JComboBox catCombo = new JComboBox();
	 Vector gramsVector = new Vector();
	 
	NGramsForm(NewsDistributer nd)
	{
		super(nd,true);
		setBounds(350,80,600,500);
		setTitle("N-Grams Form");
		setResizable(false);
		setLayout(null);
		gramsVector = null;
		
		gramsFormLabel.setFont(new Font("arial",Font.BOLD,25));
		gramsFormLabel.setBounds(220,15,200,30);
		add(gramsFormLabel);
		
		browsePanel.setBounds(50,50,500,80);
		browsePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(1),"Browse"));
		browsePanel.setLayout(null);
		add(browsePanel);
		
		sourceLabel.setBounds(15,25,50,30);
		sourceLabel.setForeground(Color.red);
		browsePanel.add(sourceLabel);
		browseText.setBounds(70,25,300,30);
		browsePanel.add(browseText);
		browseButton.setBounds(380,28,100,25);
		browsePanel.add(browseButton);
		browseButton.addActionListener(this);
		
		generateButton.setBounds(50,135,130,30);
		add(generateButton);
		generateButton.addActionListener(this);
		
		selectCatLabel.setBounds(250,135,100,30);
		add(selectCatLabel);
		catCombo.setBounds(350,138,200,25);
		add(catCombo);
		setCombo();
		
		list.setLayoutOrientation((int)list.RIGHT_ALIGNMENT);
		JScrollPane jsp = new JScrollPane(list);
		jsp.setBounds(50,175,500,230);
		add(jsp);
		
		bar.setStringPainted(true);
		bar.setBounds(50,415,270,30);
		add(bar);
		
		clearButton.setBounds(340,415,100,30);
		add(clearButton);
		addButton.setBounds(450,415,100,30);
		add(addButton);
		
		addButton.addActionListener(this);
		clearButton.addActionListener(this);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == browseButton)
			browseText.setText(Open.openFile());
		
		else if(e.getSource() == generateButton)
		{
			if(new File(browseText.getText()).exists())
				new GenerateGrams(this);
			
			else
				JOptionPane.showMessageDialog(null,"No such file exists!!");
		}
		
		else if(e.getSource() == addButton)
		{
			CategoryBean catBean = (CategoryBean)catCombo.getSelectedItem();
			if(catBean == null)
				return;
			if(gramsVector == null)
				return;
			
			new AddingGramsThread(this,catBean.getCatID()).start();
		}
		
		else if(e.getSource() == clearButton)
			clearAll();
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource() == catCombo)
		{
			GramsBean bean = (GramsBean)catCombo.getSelectedItem();
			Vector v = DatBaseManager.getGrams(bean.getCatID());
			list.setListData(v);
		}
	}
	
	private void setCombo()
	{
		Vector v = new Vector();
		try{
		v = DataBaseManager.getCategory();
		}catch(Exception ex){ex.printStackTrace();}
		catCombo.removeAllItems();
		for(int k=0 ; k<v.size(); k++)
			catCombo.addItem(v.elementAt(k));
	}
	
	void clearAll()
	{
		gramsVector = null;
		list.setListData(new Vector());
	}
}
