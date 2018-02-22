
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

class TreeTest2{
    public static void main(String arg[]){
        JFrame win = new JFrame();

        DefaultMutableTreeNode mainV = new DefaultMutableTreeNode("Main Page");
        DefaultMutableTreeNode v1 = new DefaultMutableTreeNode("Books for Java Programmers");
        DefaultMutableTreeNode v2 = new DefaultMutableTreeNode("Books for C Programmers");
        DefaultMutableTreeNode v3 = new DefaultMutableTreeNode("Books for PHP Programmers");
    
        v1.add(new DefaultMutableTreeNode("A"));
        v1.add(new DefaultMutableTreeNode("B"));
        v1.add(new DefaultMutableTreeNode("C"));
        v2.add(new DefaultMutableTreeNode("D"));
        v2.add(new DefaultMutableTreeNode("E"));
        v2.add(new DefaultMutableTreeNode("F"));
        v3.add(new DefaultMutableTreeNode("G"));
        v3.add(new DefaultMutableTreeNode("H"));
        v3.add(new DefaultMutableTreeNode("I"));
        mainV.add(v1);
        mainV.add(v2);
        mainV.add(v3);
        JTree t = new JTree(mainV);

        //win.getContentPane().setLayout(null);
        win.getContentPane().add(t);
        t.setBounds(20,20, 150, 300);
        win.setSize(300,300);
        win.show();
    }
}
