import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class DynamicFileDownloadProtocol extends JFrame implements ActionListener, MouseListener
{

	JButton addButton = new JButton(new ImageIcon("images\\newDownloadIcon.png"));
	JButton pauseButton = new JButton(new ImageIcon("images\\resumeIcon.png"));
	JButton deleteButton = new JButton(new ImageIcon("images\\deleteIcon.png"));
	
	JTable table = new JTable();
	static DefaultTableModel tableModel = new DefaultTableModel();
	
	boolean rowInAction[] = new boolean[50];
	ContinueRowProgress continueProgress[] = new ContinueRowProgress[50];
	
	Container c;
	
	DynamicFileDownloadProtocol()
	{
		setTitle("Dynamic File Download Protocol");
		setBounds(200,100,700,500);
		setResizable(false);
		c = getContentPane();
		c.setLayout(null);
		
		addButton.setBounds(50,30,160,40);
		addButton.setText("New Download");
		c.add(addButton);
		
		
		pauseButton.setBounds(250,30,160,40);
		pauseButton.setText("Resume");
		c.add(pauseButton);
		
		deleteButton.setBounds(450,30,160,40);
		deleteButton.setText("Delete");
		c.add(deleteButton);
		
		JScrollPane jsp;
		setTable();
		jsp = new JScrollPane(table);
		jsp.setBounds(20,100,650,330);
		c.add(jsp);
		
		addButton.addActionListener(this);
		pauseButton.addActionListener(this);
		deleteButton.addActionListener(this);
		table.addMouseListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void setTable()
	{ 
	      table.setModel(tableModel);
	      
	      tableModel.addColumn ("Name");
	      tableModel.addColumn ("%");
	      tableModel.addColumn ("Date");
	      tableModel.addColumn("Source");
	      tableModel.addColumn("Destination"); 
	      
	      TableColumnModel columnModel = table.getColumnModel();
	      TableColumn c1 = columnModel.getColumn(0);
	      c1.setPreferredWidth(200);
	      TableColumn c2 = columnModel.getColumn(1);
	      c2.setPreferredWidth(50);
	      TableColumn c3 = columnModel.getColumn(2);
	      c3.setPreferredWidth(60);
	      TableColumn c4 = columnModel.getColumn(3);
	      c4.setPreferredWidth(150);
	      TableColumn c5 = columnModel.getColumn(4);
	      c5.setPreferredWidth(150);
	      
	      
	      try{
	    	  History.addRecordToTable();
	      }catch(Exception e){System.out.println(e);}
	       
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addButton)
		{
			new NewDownload(this).setVisible(true);
		}
		
		else if(e.getSource() == deleteButton)
		{
			int rowNumber = table.getSelectedRow();
			
			if(!(rowNumber<0))
			{
				String fileName = String.valueOf(tableModel.getValueAt(rowNumber, 0));
				String source = String.valueOf(tableModel.getValueAt(rowNumber, 3));
				String destination = String.valueOf(tableModel.getValueAt(rowNumber, 4));
				
				try{
					History.deleteRecord(source, destination, fileName);
				}catch(Exception ex){System.out.println(e);}
				
				shiftRowInAction(rowNumber);
				tableModel.removeRow(rowNumber);
			}
			
			else return;
		}
		
		else if(e.getSource() == pauseButton)
		{
			int rowNumber = table.getSelectedRow();
			
			if(!(rowNumber<0))
			{
				if(pauseButton.getText().equals("Resume"))
				{
					continueProgress[rowNumber] = new ContinueRowProgress((String)table.getValueAt(rowNumber,3),(String)table.getValueAt(rowNumber,4),rowNumber);
					continueProgress[rowNumber].rowThread.start();
					
					pauseButton.setIcon(new ImageIcon("images\\pauseIcon.png"));
					pauseButton.setText("Pause");
					rowInAction[rowNumber] = true;
				}
				
				else
				{
					continueProgress[rowNumber].rowThread.stop();
					
					pauseButton.setIcon(new ImageIcon("images\\resumeIcon.png"));
					pauseButton.setText("Resume");
					rowInAction[rowNumber] = false;
				}
			}
		}
		
	}
	
	
	private void shiftRowInAction(int rowNumber)
	{
		for(int k=rowNumber ; k<table.getRowCount()-1 ; k++)
		{
			rowInAction[k] = rowInAction[k+1];
			continueProgress[k] = continueProgress[k+1];
		}
		rowInAction[table.getRowCount()-1] = false;
	}
	
	
	public void mouseClicked(MouseEvent me)
	{
		Object ob = me.getSource();
		
		if(ob==table)
		{
			int rowSelected = table.getSelectedRow();

			if(!rowInAction[rowSelected])
			{
				pauseButton.setIcon(new ImageIcon("images\\resumeIcon.png"));
				pauseButton.setText("Resume");
			}
			
			else
			{
				pauseButton.setIcon(new ImageIcon("images\\pauseIcon.png"));
				pauseButton.setText("Pause");
			}
		}
		
	}
	
	public void mousePressed(MouseEvent me)
	{
		
	}
	
	public void mouseReleased(MouseEvent me)
	{
		
	}
	
	public void mouseExited(MouseEvent me)
	{
		
	}
	
	public void mouseEntered(MouseEvent me)
	{
		
	}
	
	public static void main(String[] args)
	{
		new DynamicFileDownloadProtocol().setVisible(true);
	}

}
