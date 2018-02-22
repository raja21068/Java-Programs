
import java.awt.Component;
import java.io.File;
import javax.swing.JTree;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;


public class Render extends DefaultTreeCellRenderer{
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        FileSystemView fsv = FileSystemView.getFileSystemView();

        if(value.toString().contains("Computer")){
//            setIcon(fsv.getSystemIcon(fsv.getHomeDirectory()));
            setIcon(fsv.getSystemIcon(fsv.getParentDirectory(new File("C:/"))));

            return this;
        }
        
        String path = Render.getAbsolutePath(value);
        
        setIcon(fsv.getSystemIcon(new File(path)));
        return this;
    }       
    
        public static String getAbsolutePath(Object ob){
            JTree.DynamicUtilTreeNode node = (JTree.DynamicUtilTreeNode)ob;
        
            TreeNode[] parents = node.getPath();
            String path="";
            for(int i=1;i<parents.length;i++){
                path+=parents[i];
                if(i<parents.length-1){path+="\\";}
            }
            return path;
        }
}
