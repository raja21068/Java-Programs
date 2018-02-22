/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jay
 */

import java.awt.event.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Jay Kumar
 */
public class ClientFrame extends javax.swing.JFrame {

    /** Creates new form ClientFrame */
    public ClientFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        driveLabel = new javax.swing.JLabel();
        driveComboBox = new javax.swing.JComboBox();
        filesScrollPane = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList();
        refreshButton = new javax.swing.JButton();
        shareButton = new javax.swing.JButton();
        sharedListScrollPane = new javax.swing.JScrollPane();
        sharedFileList = new javax.swing.JList();
        removeButton = new javax.swing.JButton();
        folderTreeLabel = new javax.swing.JLabel();
        fileListLabel = new javax.swing.JLabel();
        shareListLabel = new javax.swing.JLabel();
        onlineUserScrollPane = new javax.swing.JScrollPane();
        onlineUserList = new javax.swing.JList();
        userListLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        permissionButton = new javax.swing.JButton();
        restrictionButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        totalPacketLabel = new javax.swing.JLabel();
        lastPacketLabel = new javax.swing.JLabel();
        packetNoLabel = new javax.swing.JLabel();
        treePanel = new javax.swing.JPanel();
        permissionDialog = new PermissionDialog();
        restrictionDialog = new RestrictionDialog();
        pathLabel = new JLabel();
        tree = new JTree();
        treeScrollPane = new JScrollPane(tree);
        treePanel.add(treeScrollPane);
        
                
         permissionDialog.permissionBtn.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent e){
        		try {
					DBManager.deleteIp((String)permissionDialog.comboBox.getSelectedItem());
					permissionDialog.updateCombo();
				} catch (Exception e1) {e1.printStackTrace();}
        	}
        });
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(680, 370));
        getContentPane().setLayout(null);

        driveLabel.setText("Local Drives");
        getContentPane().add(driveLabel);
        driveLabel.setBounds(10, 10, 80, 16);

        driveComboBox.setToolTipText("");
        getContentPane().add(driveComboBox);
        driveComboBox.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                driveComboBoxItemChanged(e);
            }
        });
        driveComboBox.setBounds(10, 30, 100, 22);

        filesScrollPane.setViewportView(filesList);

        getContentPane().add(filesScrollPane);
        filesScrollPane.setBounds(150, 70, 120, 200);

        refreshButton.setText("Refresh");
        getContentPane().add(refreshButton);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshButtonActionPerformed(e);
            }
        });
        refreshButton.setBounds(110, 30, 100, 20);

        shareButton.setText("Share Selected");
        getContentPane().add(shareButton);
        shareButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                shareButtonActionPerformed(e);
            }
        });
        shareButton.setBounds(150, 270, 120, 25);

        sharedListScrollPane.setViewportView(sharedFileList);
        try{
        sharedFileList.setListData(DBManager.getAllFiles());}catch(Exception e){}

        getContentPane().add(sharedListScrollPane);
        sharedListScrollPane.setBounds(280, 70, 120, 200);

        removeButton.setText("Remove ");
        getContentPane().add(removeButton);
        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                removeButtonActionPerformed(e);
                }catch(Exception e1){e1.printStackTrace();}
            }
        });
        removeButton.setBounds(280, 270, 120, 25);

        folderTreeLabel.setText("Folder Tree");
        getContentPane().add(folderTreeLabel);
        folderTreeLabel.setBounds(30, 50, 70, 16);

        fileListLabel.setText("Files");
        getContentPane().add(fileListLabel);
        fileListLabel.setBounds(170, 50, 50, 16);

        shareListLabel.setText("Shared Resoures");
        getContentPane().add(shareListLabel);
        shareListLabel.setBounds(282, 50, 98, 16);

        onlineUserScrollPane.setViewportView(onlineUserList);

        getContentPane().add(onlineUserScrollPane);
        onlineUserScrollPane.setBounds(410, 70, 100, 200);

        userListLabel.setText("Online User");
        getContentPane().add(userListLabel);
        userListLabel.setBounds(420, 50, 70, 16);
        getContentPane().add(progressBar);
        progressBar.setBounds(410, 274, 260, 20);

        permissionButton.setText("Permission");
        getContentPane().add(permissionButton);
        permissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                permissionButtonActionPerformed();
            }
        });
        permissionButton.setBounds(510, 60, 150, 25);

        restrictionButton.setText("Restriction");
        getContentPane().add(restrictionButton);
        restrictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restrictButtonActionPerformed();
            }
        });
        restrictionButton.setBounds(510, 90, 150, 25);

        downloadButton.setText("Download");
        getContentPane().add(downloadButton);
        downloadButton.setBounds(510, 120, 150, 25);

        fileNameLabel.setText("File Name:");
        getContentPane().add(fileNameLabel);
        fileNameLabel.setBounds(515, 150, 140, 16);

        fileSizeLabel.setText("File Size: ");
        getContentPane().add(fileSizeLabel);
        fileSizeLabel.setBounds(515, 170, 150, 16);

        packetSizeLabel.setText("Packet Size:");
        getContentPane().add(packetSizeLabel);
        packetSizeLabel.setBounds(515, 190, 150, 16);

        totalPacketLabel.setText("Total Packet:");
        getContentPane().add(totalPacketLabel);
        totalPacketLabel.setBounds(515, 210, 150, 16);

        lastPacketLabel.setText("Last Packet:");
        getContentPane().add(lastPacketLabel);
        lastPacketLabel.setBounds(515, 230, 150, 16);

        packetNoLabel.setText("Packet #");
        getContentPane().add(packetNoLabel);
        packetNoLabel.setBounds(520, 250, 150, 16);

        getContentPane().add(treePanel);
        treePanel.setBounds(10, 70, 130, 220);
        treePanel.setLayout(new java.awt.BorderLayout());
       
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void refreshButtonActionPerformed(java.awt.event.ActionEvent e){
        driveComboBox.removeAllItems();
        getAllDirectories();
    }
    
    public void permissionButtonActionPerformed(){
        permissionDialog.setVisible(true);
    }
    
    public void restrictButtonActionPerformed(){
        restrictionDialog.setVisible(true);
    }
    public void driveComboBoxItemChanged(java.awt.event.ItemEvent e){
        Object ob = driveComboBox.getSelectedItem();
        String s = String.valueOf(ob);

        top = new DefaultMutableTreeNode(s);
        setTree(s);
    }
    void setTree(String s)
    {
        JTree newTree;
        JScrollPane newSp;

        tree.setVisible(false);
        treeScrollPane.setVisible(false);

        File f = new File(s);
        if(f.isDirectory() ){
            File subF[] = f.listFiles();
            for(int k=0 ; k<subF.length ;k++){
                System.out.println(subF[k].getName());

                if(subF[k].isDirectory() || subF[k].isFile()){
                    try{
                        top.add(getSubDirs(subF[k]));
                        }catch(Exception e){}
                }
            }
        }

        newTree = new JTree(top);
        newSp = new JScrollPane(newTree);
        treePanel.setBounds(10, 50, 130, 220);
        treePanel.setLayout(new java.awt.BorderLayout());
        newSp.setBounds(10, 50, 130, 220);
        newTree.setBounds(treePanel.getBounds());
        //newSp.setBounds(25,60,200,400);
        //newTree.setBounds(0,0,200,400);
        treePanel.add(newSp);

        tree = newTree;
        treeScrollPane = newSp;

        tree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {

            @Override
            public void treeExpanded(TreeExpansionEvent event) {
              TreePath treePath = event.getPath();
              MutableTreeNode node = (MutableTreeNode)treePath.getLastPathComponent();
              System.out.println(node);
              System.out.println(node.getChildCount());

              Object ob[] = treePath.getPath();
              String s = "";
              for(int k=0 ; k<ob.length ; k++)
                    s = s + "//" + ob[k];

              File f = new File(s);

            if(f.isDirectory())
            {
                File dirsF[] = f.listFiles();

                for(int k=0 ; k<dirsF.length ; k++)
                {
                    if(dirsF[k].isDirectory() || dirsF[k].isFile())
                    {
                        try{
                           model.insertNodeInto(getSubDirs(dirsF[k]), node, node.getChildCount());
                           model.removeNodeFromParent((MutableTreeNode)node.getChildAt(0));
                        }catch(Exception e){}
                    }
                }
                System.out.println(node.getChildCount());
            }
        }
            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                
            }
        });
                
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener(){
            public void valueChanged(TreeSelectionEvent te)
            {
                TreePath path = te.getPath();
                Object ob[] = path.getPath();
                String s = "";
                for(int k=0 ; k<ob.length ; k++)
                {
                    s = s + ob[k];
                    if(k!=ob.length-1)
                    s = s + "\\";
                }
                pathLabel.setText(s);
                System.out.println(s);

                File f = new File(s);
                if(f.isDirectory())
                {
                    File folders[] = f.listFiles();
                    Vector v = new Vector();
                    for(int k=0 ; k<folders.length ; k++)
                    {
                        v.addElement(folders[k].getName());
                    }
                filesList.setListData(v);
                }
        }

        });
        model = (DefaultTreeModel)tree.getModel();
    }

    public void getAllDirectories(){
        
        File drives[] = File.listRoots();

        for(int k=0 ; k<drives.length ; k++){
            if(drives[k].isDirectory()){
                System.out.println(String.valueOf(drives[k]));
                driveComboBox.addItem(String.valueOf(drives[k]));
            }
        }
        /*driveComboBox.removeAllItems();
        java.io.File f= new java.io.File("C:\\");
        java.io.File[] drive = f.listRoots();
        for(int i=0 ; i<drive.length; i++){
            driveComboBox.addItem(String.valueOf(drive[i]));
            System.out.println(drive[i].getAbsolutePath());
        }*/
    }
   DefaultMutableTreeNode getSubDirs(File f)throws Exception{

       
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(f.getName());

        if(f.isDirectory()){
            File subF[] = f.listFiles();

            for(int k=0 ; k<subF.length ; k++){
                if(subF[k].isDirectory() || subF[k].isFile())
                 {
                    node.add(new DefaultMutableTreeNode(subF[k].getName()));
                 }
            }
        }

        return node;
    }
   public void shareButtonActionPerformed(ActionEvent e){
       Object ob =filesList.getSelectedValue();
       String str = String.valueOf(ob);
       if(str.equals("null")){return;}
       System.out.println(pathLabel.getText()+"\\"+str);
       try{
       DBManager.addFile(pathLabel.getText()+"\\"+str);
       refreshShareFiles();
       }catch(Exception e1){ e1.printStackTrace(); }
   }
   public void removeButtonActionPerformed(ActionEvent e)throws Exception{
       String str=(String)sharedFileList.getSelectedValue();
       System.out.println(str);
       DBManager.deleteFile(str);
       try{
           refreshShareFiles();
       }catch(Exception e1){ e1.printStackTrace(); }
   }
   public void refreshShareFiles()throws Exception{
       sharedFileList.removeAll();
       sharedFileList.setListData(DBManager.getAllFiles());
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton downloadButton;
    javax.swing.JComboBox driveComboBox;
    javax.swing.JLabel driveLabel;
    javax.swing.JLabel fileListLabel;
    javax.swing.JLabel fileNameLabel;
    javax.swing.JLabel fileSizeLabel;
    javax.swing.JList filesList;
    javax.swing.JScrollPane filesScrollPane;
    javax.swing.JLabel folderTreeLabel;
    javax.swing.JLabel lastPacketLabel;
    javax.swing.JList onlineUserList;
    javax.swing.JScrollPane onlineUserScrollPane;
    javax.swing.JLabel packetNoLabel;
    javax.swing.JLabel packetSizeLabel;
    javax.swing.JButton permissionButton;
    javax.swing.JProgressBar progressBar;
    javax.swing.JButton refreshButton;
    javax.swing.JButton removeButton;
    javax.swing.JButton restrictionButton;
    javax.swing.JButton shareButton;
    javax.swing.JLabel shareListLabel;
    javax.swing.JList sharedFileList;
    javax.swing.JScrollPane sharedListScrollPane;
    javax.swing.JLabel totalPacketLabel;
    javax.swing.JPanel treePanel;
    javax.swing.JLabel userListLabel;
    javax.swing.JScrollPane treeScrollPane;
    PermissionDialog permissionDialog;
    RestrictionDialog restrictionDialog;
    JTree tree;
    DefaultMutableTreeNode top;
    DefaultTreeModel model;
    JLabel pathLabel;
    // End of variables declaration//GEN-END:variables
    
}
