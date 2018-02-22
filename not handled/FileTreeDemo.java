import javax.swing.*;
    import javax.swing.event.*;
    import javax.swing.tree.*;
    import java.io.File;
    import java.util.Collections;
    import java.util.Vector;

    public class FileTreeDemo {
    public static void main(String[] args) {
    try{                                              
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
    System.out.println("cant done"); 
    }
    // Create a JTree and tell it to display our model
    JTree tree = new JTree();

    // The JTree can get big, so allow it to scroll
    JScrollPane scrollpane = new JScrollPane(tree);
    // Figure out where in the filesystem to start displaying       
    File[] roots = File.listRoots();  
    FileTreeModel model = new FileTreeModel(null); 
    model = new FileTreeModel(roots[0]);
    tree.setModel(model);
    CheckTreeManager checkTreeManager = new CheckTreeManager(tree); 
    TreePath checkedPaths[]=checkTreeManager.getSelectionModel().getSelectionPaths();
    int j = checkedPaths.length;
    System.out.println("Tree Path :"+j);
    for(int i=0; i<checkedPaths.length;i++){
    System.out.println("Tree Path :"+checkedPaths[i]);
    }
    // Display it all in a window and make the window appear
    JFrame frame = new JFrame("FileTreeDemo");
    frame.getContentPane().add(scrollpane, "Center");
    frame.setSize(400,600);
    frame.setVisible(true);
    }  
    }
