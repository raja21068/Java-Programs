import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

class NewDownload extends JDialog implements ActionListener
{
	JLabel sourceLabel = new JLabel("Source :");
	JLabel destinationLabel = new JLabel("Destination :");
	JTextField sourceText = new JTextField();
	JTextField destinationText = new JTextField();
	JButton browseButton1 = new JButton("Browse");
	JButton browseButton2 = new JButton("Browse");
	static JCheckBox deletionCheck = new JCheckBox("delete file from source after downloading file");
	static JCheckBox closingCheck = new JCheckBox("close dialog after downloading file");
	JProgressBar bar = new JProgressBar();
	JButton start = new JButton("start");
	JButton about = new JButton("About");
	JButton exit = new JButton("Exit");
	
	public String source, destination;
	private String fileName;
	private boolean isStarted = false;
	
	DynamicFileDownloadProtocol mainFrame;
	DownloadingThread downloadingThread;
	int myRow;
	
	NewDownload(DynamicFileDownloadProtocol a)
	{
		super(a,true);
		mainFrame = a;
		setBounds(250,150,550,320);
		setTitle("New Download");
		setResizable(false);
		setLayout(null);
		
		sourceLabel.setBounds(20,10,100,30);
		destinationLabel.setBounds(20,50,100,30);
		sourceText.setBounds(100,10,320,30);
		destinationText.setBounds(100,50,320,30);
		browseButton1.setBounds(430,10,100,30);
		browseButton2.setBounds(430,50,100,30);
		deletionCheck.setBounds(30,110,300,30);
			deletionCheck.setForeground(Color.red);
		closingCheck.setBounds(30,140,250,30);
			closingCheck.setForeground(Color.red);
		bar.setBounds(50,200,450,30);
		bar.setStringPainted(true);
		start.setBounds(50,240,100,30);
		about.setBounds(290,240,100,30);
		exit.setBounds(410,240,100,30);
		
		
		add(sourceLabel);	add(sourceText);	add(browseButton1);
		add(destinationLabel);	add(destinationText);	add(browseButton2);
		add(deletionCheck);	add(closingCheck);	add(bar);
		add(start);	
		add(about);	add(exit);
		
		browseButton1.addActionListener(this);
		browseButton2.addActionListener(this);
		start.addActionListener(this);

		about.addActionListener(this);
		exit.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Object ob = e.getSource();
		
		if(ob==browseButton1)
		{
			JDialog d = new JDialog();
			FileDialog dialog = new FileDialog(d,"Source...",FileDialog.LOAD);
			dialog.setVisible(true);
			source = dialog.getDirectory() + dialog.getFile();
			fileName = dialog.getFile();
			sourceText.setText(source);
		}
		
		else if(ob==browseButton2)
		{
			JDialog d = new JDialog();
			FileDialog dialog = new FileDialog(d,"Destination...",FileDialog.LOAD);
			dialog.setVisible(true);
			destination = dialog.getDirectory() + fileName;
			destinationText.setText(destination);
		}

		else if(ob==start)
		{
		
			if(!(sourceText.getText().equals("") || destinationText.getText().equals("")) && start.getText().equals("start"))
			{
				if(addRowInTable())
				{
					downloadingThread = new DownloadingThread(this);
					downloadingThread.t.start();
					start.setText("pause");
					isStarted = true;
				}
			}
			
			else if(start.getText().equals("pause"))
			{
				downloadingThread.t.suspend();
				start.setText("resume");
				isStarted = false;
			}
			
			else if(start.getText().equals("resume"))
			{
				downloadingThread.t.resume();
				start.setText("pause");
				isStarted = true;
			}
			
			else return;
		}

		else if(ob==about)
		{
			JOptionPane.showMessageDialog(null,"Designed By: Ali Asad Khowaja");
		}
		
		else if(ob==exit)
		{
			if(isStarted)
				shiftingThread();
			dispose();
		}

	}
	
	
	private boolean addRowInTable()
	{
		boolean recordExist = false;
		
		try{
			recordExist = History.checkIfAllreadyExists(sourceText.getText(), destinationText.getText(), fileName);
		}catch(Exception e){}
		
		if(!recordExist)
		{
			mainFrame.tableModel.addRow(new Object[]{fileName,"0%",new Date().getDate()+ "-" + new Date().getMonth() + "-2012",source,destination});
			addRecord();
			myRow = mainFrame.tableModel.getRowCount()-1;
			return true;
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"record Allready Exists");
			return false;
		}
	}
	
	private void addRecord()
	{
		try{
			History.addToHistory(source,destination,fileName);
		}catch(Exception e){}
	}
	
	
	private void shiftingThread()
	{
		downloadingThread.t.stop();
		mainFrame.rowInAction[myRow] = true;
		mainFrame.continueProgress[myRow] = new ContinueRowProgress(source,destination,myRow);
		mainFrame.continueProgress[myRow].rowThread.start();
		
	}
}
