
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JExplorer extends JFrame implements ActionListener, ItemListener, TreeExpansionListener, TreeSelectionListener {

    Container c;
    JPanel treePanel = new JPanel();
    JPanel dirPanel = new JPanel();
    JList foldersList = new JList();
    JComboBox comboBox = new JComboBox();
    JTree tree = new JTree();
    JScrollPane sp;
    JButton reset = new JButton("Reset");
    JLabel l = new JLabel("Designed By: Ali Asad Khowaja");
    JLabel dirLabel = new JLabel();
    DefaultMutableTreeNode top;
    DefaultTreeModel model;

    JExplorer() {
        setSystemLookAndFeel();
        setBounds(200, 50, 700, 600);
        setResizable(false);
        setTitle("JExplorer");

        c = getContentPane();
        c.setLayout(null);

        comboBox.setBounds(25, 25, 200, 30);

        sp = new JScrollPane(tree);
        sp.setBounds(25, 60, 200, 400);
        tree.setBounds(0, 0, 200, 400);
        treePanel.add(sp);
        reset.setBounds(65, 470, 100, 25);
        reset.addActionListener(this);
        treePanel.add(reset);
        l.setBounds(20, 530, 220, 30);
        l.setFont(new Font("arial", Font.BOLD, 14));
        l.setForeground(Color.red);
        treePanel.add(l);
        treePanel.setLayout(null);
        treePanel.add(comboBox);
        treePanel.setBackground(Color.BLACK);
        treePanel.setBounds(0, 0, 250, 600);
        c.add(treePanel);

        dirLabel.setBounds(0, 0, 450, 50);
        dirLabel.setBackground(Color.YELLOW);
        dirPanel.add(dirLabel);
        dirPanel.setBounds(250, 0, 450, 50);
        c.add(dirPanel);

        JScrollPane jsp;

        foldersList.setBackground(Color.GRAY);
        foldersList.setBounds(0, 0, 450, 550);
        jsp = new JScrollPane(foldersList);
        jsp.setBounds(250, 50, 445, 520);
        c.add(jsp);

        comboBox.addItemListener(this);
        getDirectories();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void getDirectories() {
        File drives[] = File.listRoots();

        for (int k = 0; k < drives.length; k++) {
            if (drives[k].isDirectory()) {
                System.out.println(String.valueOf(drives[k]));
                comboBox.addItem(String.valueOf(drives[k]));
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reset) {
            comboBox.removeAllItems();
            getDirectories();
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        Object ob = comboBox.getSelectedItem();
        String s = String.valueOf(ob);

        dirLabel.setText(s);
        top = new DefaultMutableTreeNode(s);
        setTree(s);
    }

    void setTree(String s) {
        JTree newTree;
        JScrollPane newSp;

        tree.setVisible(false);
        sp.setVisible(false);

        File f = new File(s);
        if (f.isDirectory()) {
            File subF[] = f.listFiles();
            for (int k = 0; k < subF.length; k++) {
                System.out.println(subF[k].getName());

                if (subF[k].isDirectory() || subF[k].isFile()) {
                    try {
                        top.add(getSubDirs(subF[k]));
                    } catch (Exception e) {
                    }
                }

            }

        }

        newTree = new JTree(top);
        newSp = new JScrollPane(newTree);
        newSp.setBounds(25, 60, 200, 400);
        newTree.setBounds(0, 0, 200, 400);
        treePanel.add(newSp);

        tree = newTree;
        sp = newSp;

        tree.addTreeExpansionListener(this);
        tree.addTreeSelectionListener(this);
        model = (DefaultTreeModel) tree.getModel();
    }

    DefaultMutableTreeNode getSubDirs(File f) throws Exception {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(f.getName());

        if (f.isDirectory()) {
            File subF[] = f.listFiles();

            for (int k = 0; k < subF.length; k++) {
                if (subF[k].isDirectory() || subF[k].isFile()) {
                    node.add(new DefaultMutableTreeNode(subF[k].getName()));
                }

            }
        }

        return node;
    }

    public void treeExpanded(TreeExpansionEvent te) {
        TreePath treePath = te.getPath();
        MutableTreeNode node = (MutableTreeNode) treePath.getLastPathComponent();
        System.out.println(node);
        System.out.println(node.getChildCount());

        Object ob[] = treePath.getPath();
        String s = "";
        for (int k = 0; k < ob.length; k++) {
            s = s + "//" + ob[k];
        }

        File f = new File(s);

        if (f.isDirectory()) {
            File dirsF[] = f.listFiles();

            for (int k = 0; k < dirsF.length; k++) {
                if (dirsF[k].isDirectory() || dirsF[k].isFile()) {
                    try {
                        model.insertNodeInto(getSubDirs(dirsF[k]), node, node.getChildCount());
                        model.removeNodeFromParent((MutableTreeNode) node.getChildAt(0));
                    } catch (Exception e) {
                    }
                }

            }

            System.out.println(node.getChildCount());

        }
    }

    public void treeCollapsed(TreeExpansionEvent te) {
    }

    public void valueChanged(TreeSelectionEvent te) {
        TreePath path = te.getPath();
        Object ob[] = path.getPath();
        String s = "";
        for (int k = 0; k < ob.length; k++) {
            s = s + ob[k];
            if (k != ob.length - 1) {
                s = s + "\\";
            }
        }

        System.out.println(s);
        dirLabel.setText(s);

        File f = new File(s);
        if (f.isDirectory()) {
            File folders[] = f.listFiles();
            Vector v = new Vector();
            for (int k = 0; k < folders.length; k++) {
                v.addElement(folders[k].getName());
            }

            foldersList.setListData(v);
        }
    }

    void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }

    }

    public static void main(String arg[]) {
        JExplorer obj = new JExplorer();
    }
}
