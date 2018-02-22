import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Vector;

class CategoryForm extends JDialog implements ActionListener, ListSelectionListener
{
	JLabel catIDLabel = new JLabel("Cat_ID");
	JLabel catNameLabel = new JLabel("Cat_Name");
	JTextField catIDText = new JTextField();
	JTextField catNameText = new JTextField();
	JList list = new JList();
	JButton addButton = new JButton("Add");
	JButton deleteButton = new JButton("Delete");
	JButton updateButton = new JButton("Update");
	JButton clearButton = new JButton("Clear");
	
	CategoryForm(NewsDistributer nd)
	{
		super(nd,true);
		setBounds(400,100,450,250);
		setResizable(false);
		setTitle("Catogory Form");
		setLayout(null);
		
		catIDLabel.setBounds(30,30,70,30);
		catIDText.setBounds(100,30,150,30);	catIDText.setEditable(false);
		catNameLabel.setBounds(30,70,70,30);
		catNameText.setBounds(100,70,150,30);
		add(catIDLabel);
		add(catIDText);
		add(catNameLabel);
		add(catNameText);
		
		
		JScrollPane jsp = new JScrollPane(list);
		jsp.setBounds(270,10,150,200);
		add(jsp);
		setList();
		
		addButton.setBounds(30,120,100,25);
		deleteButton.setBounds(140,120,100,25);
		updateButton.setBounds(30,150,100,25);
		clearButton.setBounds(140,150,100,25);
		add(addButton);
		add(deleteButton);
		add(updateButton);
		add(clearButton);
		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		updateButton.addActionListener(this);
		clearButton.addActionListener(this);
		list.addListSelectionListener(this);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addButton && !catNameText.getText().equals(""))
		{
			try{
			int i = DataBaseManager.insertCategory(catNameText.getText());
			if(i>0){
				JOptionPane.showMessageDialog(null, "Record successfully Added!!");
				setList();
				clearAll();
			}
			}catch(Exception ex){ex.printStackTrace();}
		}
		
		else if(e.getSource() == deleteButton && !catIDText.getText().equals(""))
		{
			try{
			int i = DataBaseManager.deleteCategory(Integer.parseInt(catIDText.getText()));
			if(i>0){
				JOptionPane.showMessageDialog(null, "Record successfully Deleted!!");
				list.removeListSelectionListener(this);
				setList();
				list.addListSelectionListener(this);
				clearAll();
			}
			}catch(Exception ex){ex.printStackTrace();}
		}
		
		else if(e.getSource() == updateButton && !catIDText.getText().equals("") && !catNameText.getText().equals(""))
		{
			try{
			int i = DataBaseManager.updateCategory(Integer.parseInt(catIDText.getText()), catNameText.getText());
			if(i>0){
				JOptionPane.showMessageDialog(null, "Record successfully Updated!!");
				setList();
			}
			}catch(Exception ex){ex.printStackTrace();}
		}
		
		else if(e.getSource() == clearButton)
		{
			clearAll();
		}
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		if(e.getSource() == list)
		{
			CategoryBean bean = (CategoryBean)list.getSelectedValue();
			if(bean == null)
				return;
			catIDText.setText(""+bean.getCatID());
			catNameText.setText(bean.getCatName());
		}
	}
	
	private void clearAll()
	{
		catIDText.setText("");
		catNameText.setText("");
	}
	
	private void setList()
	{
		Vector v = new Vector();
		try{
		v = DataBaseManager.getCategory();
		}catch(Exception ex){ex.printStackTrace();}
		list.setListData(v);
	}
}
