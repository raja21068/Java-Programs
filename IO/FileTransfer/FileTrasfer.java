
//class ThreadDemo {

//}
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class FileTrasfer extends JFrame implements ActionListener{
    
    //Boolean Instance Variables
    boolean pauseBool;
    boolean checkBoxBool;
    boolean isStarted;

    //Required Components Instance Variables
    JButton start;
    JButton pause;
    JButton stop;
    JButton about;
    JButton exit;
    JButton srcBrowse;
    JButton desBrowse;
    JCheckBox checkBox;
    JTextField srcText;
    JTextField desText;
    JProgressBar progressBar;
    
    DataInputStream in;
    PrintStream out;
    
    //File Dialog Instance Variables
    FileDialog srcDialog;
    FileDialog desDialog;

    MyThread myThread;    
    FileTrasfer()
    {
        //Frame Settings
        super("FileTransfer");
        setBounds(10,10,420,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
    
        //Change The Look And Feel OF Frame
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex){}
     
        srcDialog = new FileDialog(this, "Open", FileDialog.LOAD);
        desDialog = new FileDialog(this,"Save",FileDialog.SAVE);
        
        //ProgressBar Component
        progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 10000);
        
        //Source and Destination Label
        JLabel srcLabel = new JLabel("Source");
        JLabel desLabel = new JLabel("Destination");
        
        //CheckBox Component
        JCheckBox checkBox = new JCheckBox("Delete File From Source After Copied");
        
        //Button Components
        start = new JButton("Start");
        pause = new JButton("Pause");
        stop = new JButton("Stop");
        about = new JButton("About");
        exit = new JButton("Exit");
        srcBrowse = new JButton("Browse");
        desBrowse = new JButton("Browse");
        srcText = new JTextField();
        desText = new JTextField();
        
        //Setting the Starting State of Components
        pause.setEnabled(false);
        stop.setEnabled(false); 
        
        //Registering buttons with ActionListener And ItemListener
        start.addActionListener(this);
        pause.addActionListener(this);
        stop.addActionListener(this);
        about.addActionListener(this);
        exit.addActionListener(this);
        srcBrowse.addActionListener(this);
        desBrowse.addActionListener(this);

        checkBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED)
                    checkBoxBool = true;
                else
                    checkBoxBool = false;     
            }
        });
        
        //ProgressBar Settings
               

        //Setting Bounds of Components
        srcLabel.setBounds(10,10,50,50);
        srcText.setBounds(90,25,200,20);
        srcBrowse.setBounds(300,25,100,20);
        desLabel.setBounds(10,30,70,50);
        desText.setBounds(90,45,200,20);
        desBrowse.setBounds(300,45,100,20);
        checkBox.setBounds(10,80,250,20);
        progressBar.setBounds(10,120,400,20);
        start.setBounds(10,150,70,20);
        pause.setBounds(80,150,70,20);
        stop.setBounds(150,150,70,20);
        about.setBounds(220,150,70,20);
        exit.setBounds(290,150,70,20);
        
        //Adding Components On Frame
        getContentPane().add(srcLabel);
        getContentPane().add(desLabel);
        getContentPane().add(srcText);
        getContentPane().add(desText);
        getContentPane().add(checkBox);
        getContentPane().add(start);
        getContentPane().add(stop);
        getContentPane().add(pause);
        getContentPane().add(about);
        getContentPane().add(exit);
        getContentPane().add(srcBrowse);
        getContentPane().add(desBrowse);
        getContentPane().add(progressBar);
        
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(false);
        pause.setEnabled(false);

        //Show Frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == start)
        {
                myThread = new MyThread();
                myThread.start();
                start.setEnabled(false);
                pause.setEnabled(!false);
        }
        
        else if(e.getSource() == srcBrowse)
        {
            srcDialog.setVisible(true);
            srcText.setText(srcDialog.getDirectory() + srcDialog.getFile());
        }
        
        else if(e.getSource() == desBrowse)
        {
            desDialog.setVisible(true);
            desText.setText(desDialog.getDirectory() + desDialog.getFile());
        }
        
        else if(e.getSource() == pause)
        {       
            
            if(pause.getText().equals("Pause")){
                pause.setText("Resume");
                myThread.suspend();
            }
            else if(pause.getText().equals("Resume")){
                pause.setText("Pause");
                myThread.resume();
            }
        }
        
        else if(e.getSource() == stop)
        {
            myThread = null;
            srcText.setText("");
            desText.setText("");
            start.setText("Start");
            pause.setEnabled(false);
            stop.setEnabled(false);
            start.setEnabled(true);
        }
        
        else if(e.getSource() == exit)
            System.exit(0);
        
        else if(e.getSource() == about)
            JOptionPane.showMessageDialog(null,"Created By:\n\tABDUL GHAFFAR MALLAH","About",JOptionPane.INFORMATION_MESSAGE);
    }
    
class MyThread extends Thread{
    public void run()
    {
        if(srcText.getText().equals("") || desText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Enter An Address In Boxes","FileTransfer",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        

        try
        {
                in = new DataInputStream(new FileInputStream(srcText.getText()));

                //Destination
                File f = new File(desText.getText());
                if(!f.exists()) f.createNewFile();
                out = new PrintStream(new FileOutputStream(f));
                
            int size = in.available();
            int packetSize = 10000;
            int totalPackets = size / packetSize;
            int lastPacketSize = size % packetSize;
   
	progressBar.setMinimum(0);
        progressBar.setMaximum(totalPackets); 

            byte []b = new byte[packetSize];
//		progressBar.validate();   
    
            for(int i = 1; i<=totalPackets; i++){
                in.readFully(b, 0, b.length);
                out.write(b, 0, b.length);
                
                progressBar.setValue(i);
                Thread.sleep(100);
                
            }
            
            in.readFully(b, 0, lastPacketSize);
            out.write(b, 0, lastPacketSize);
    
            in.close();
            out.close();
            JOptionPane.showMessageDialog(null, "Copied Successfully..!!!");

        }catch(Exception ex){}
        
    }
}// end MyThread class
    
    public static void main(String[] args) 
    {
        new FileTrasfer();
    }

}
