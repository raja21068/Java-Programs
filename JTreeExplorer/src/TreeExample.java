import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;

class TreeExample extends JFrame
 {
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JScrollPane scrollPane;
        JTree tree;
	// Constructor of main frame
	public TreeExample()
	{
		// Set the frame characteristics
		setTitle( "Simple Tree Application" );
		setSize( 300, 100 );
		setBackground( Color.gray );
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
                DefaultMutableTreeNode node=new DefaultMutableTreeNode("D:/");
                mainDirectory(node);
                tree = new JTree(node);
                
		// Add the listbor to a scrolling pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( tree );
		
                topPanel.add( scrollPane, BorderLayout.CENTER );
	}
        private void mainDirectory(DefaultMutableTreeNode tNode){
            String src=tNode.toString();
            
            String[] files= new File(src).list();
            for (int i=0;i<files.length;i++){
//               System.out.println(src+files[i]); 
                if(new File(src+files[i]).isDirectory()){
                    DefaultMutableTreeNode n = new DefaultMutableTreeNode(files[i]);
                    dirHelp(src+files[i] , n);
                    tNode.add(n);
                }
                else{
                    tNode.add(new DefaultMutableTreeNode(files[i]));}
            }
            
        }
        private void dirHelp(String src , DefaultMutableTreeNode node){
            System.out.println(src);
            try{
            String files[]=new File(src).list();
            System.out.println(files.length); 
            for(int i=0;i<files.length;i++){
                if(new File(src+"/"+files[i]).isDirectory()){
                    DefaultMutableTreeNode no=new DefaultMutableTreeNode(files[i]);
                    dirHelp(src+"/"+files[i] , no);
                    node.add(no);
                }
                else node.add(new DefaultMutableTreeNode(files[i]));
            }
            }catch(NullPointerException ex){ex.printStackTrace();}
        }
      
	// Main entry point for this example
	public static void main( String args[] )throws Exception
	{
		// Create an instance of the test application
		TreeExample mainFrame	= new TreeExample();
		mainFrame.setVisible( true );
	}
}

