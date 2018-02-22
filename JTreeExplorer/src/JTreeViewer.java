
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;


public class JTreeViewer extends JFrame implements TreeWillExpandListener,TreeSelectionListener{
    
    
    public JTreeViewer(){
        
        tree = new JTree();
        tree.setModel(treeModel());
        tree.setCellRenderer(new Render());
        tree.setShowsRootHandles(true);
        tree.addTreeWillExpandListener(this);
        tree.addTreeSelectionListener(this);

        label = new JLabel("SELECT PICTURE");
        
        setSize(800,600);
        getContentPane().setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(new JScrollPane(tree));
        getContentPane().add(new JScrollPane(label));
        setVisible(true);
    }
    
    public DefaultTreeModel treeModel(){
        DefaultTreeModel model = new DefaultTreeModel(null);
        
        JTree.DynamicUtilTreeNode node = new JTree.DynamicUtilTreeNode("Computer", null);
        node.setAllowsChildren(true);
        
        File[] f = File.listRoots();
        for(int i=0;i<f.length;i++){
            JTree.DynamicUtilTreeNode dir = new JTree.DynamicUtilTreeNode(f[i], null);
            dir.setAllowsChildren(true);
            node.add(dir);
        }
        
        model.setRoot(node);
        return model;
    }
    
    public void setChildrens(String path ,JTree.DynamicUtilTreeNode parent ){
        path = path.substring(1, path.length()-1);
        path = getAbsolutePath(path);
        File f = new File(path.trim());
        File[] files =f.listFiles();
        if(f.toString().equals("")){
            File[] d = File.listRoots();
            for(int i=0;i<d.length;i++){
                JTree.DynamicUtilTreeNode dir = new JTree.DynamicUtilTreeNode(d[i], null);
                dir.setAllowsChildren(true);
                parent.add(dir);
            }
            return;
        }
        for(int i=0;i<files.length;i++){
            if(files[i].canRead()){
                JTree.DynamicUtilTreeNode dir = new JTree.DynamicUtilTreeNode(files[i].getName(), null);
                if(files[i].isDirectory()){
                    dir.setAllowsChildren(true);
                }
                parent.add(dir);
            }
        }
    }
    
    public String getAbsolutePath(String path){
        String[] p=path.split(",");
        path="";
        for(int i=1;i<p.length;i++){
            path+=p[i].trim();
            if(i<p.length-1){path+="/";}
        }
        return path;
    }

    @Override
    public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
        
        TreePath path=event.getPath();
        JTree.DynamicUtilTreeNode parent =(JTree.DynamicUtilTreeNode)path.getLastPathComponent();
        setChildrens(path.toString() , parent);
    }

    @Override
    public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
        
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        String path = Render.getAbsolutePath(e.getPath().getLastPathComponent());
        System.out.println(path);
        if(path.contains(".png")||path.contains(".jpg")||path.contains(".gif")){
            label.setIcon(new javax.swing.ImageIcon(path));
        }
    }
    
    public static void main(String arg[]){
        new JTreeViewer();
    }
    
    //variables
     JTree tree;
     JLabel label;
}
