/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jay
 */

import java.awt.Color;
import java.awt.event.*;
import javax.swing.tree.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Jay Kumar
 */
public class ClientFrame extends javax.swing.JFrame {
    private JLabel mainLabel;
    JTextField fileNameTextField;
    JButton searchNameButton;

    /** Creates new form ClientFrame */
    public ClientFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        driveLabel = new javax.swing.JLabel();
        driveComboBox = new javax.swing.JComboBox();
        fileNameTextField = new javax.swing.JTextField();
        filesScrollPane = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList();
        fileListLabel = new javax.swing.JLabel();
        onlineUserScrollPane = new javax.swing.JScrollPane();
        onlineUserList = new javax.swing.JList();
        userListLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        packetSizeLabel = new javax.swing.JLabel();
        totalPacketLabel = new javax.swing.JLabel();
        lastPacketLabel = new javax.swing.JLabel();
        packetNoLabel = new javax.swing.JLabel();
        permissionButton = new javax.swing.JButton();
        restrictionButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        searchNameButton = new JButton();
        permissionDialog = new PermissionDialog();
        restrictionDialog = new RestrictionDialog();
                
         permissionDialog.permissionBtn.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent e){
        		try {
					DBManager.deleteIp((String)permissionDialog.comboBox.getSelectedItem());
					permissionDialog.updateCombo();
				} catch (Exception e1) {e1.printStackTrace();}
        	}
        });
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(255, 102, 102));
        mainLabel.setText("Remote Search Engine");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(170, 10, 150, 15);

        driveLabel.setText("Drives");
        getContentPane().add(driveLabel);
        driveLabel.setBounds(10, 30, 50, 14);

        getContentPane().add(driveComboBox);
        driveComboBox.setBounds(10, 50, 100, 20);

        searchNameButton.setText("Search File Name:");
        getContentPane().add(searchNameButton);
        searchNameButton.setBounds(10, 80, 130, 14);
        getContentPane().add(fileNameTextField);
        fileNameTextField.setBounds(10, 100, 100, 20);

        filesScrollPane.setViewportView(filesList);

        getContentPane().add(filesScrollPane);
        filesScrollPane.setBounds(190, 50, 140, 250);

        onlineUserScrollPane.setViewportView(onlineUserList);

        getContentPane().add(onlineUserScrollPane);
        onlineUserScrollPane.setBounds(340, 50, 120, 220);

        fileNameLabel.setText("File Name:");
        getContentPane().add(fileNameLabel);
        fileNameLabel.setBounds(10, 130, 170, 14);

        refreshButton.setText("Refresh");
        
        getContentPane().add(refreshButton);
        refreshButton.setBounds(110, 50, 80, 20);

        fileSizeLabel.setText("File Size:");
        getContentPane().add(fileSizeLabel);
        fileSizeLabel.setBounds(10, 160, 170, 14);

        packetSizeLabel.setText("Packet size:");
        getContentPane().add(packetSizeLabel);
        packetSizeLabel.setBounds(10, 190, 170, 14);

        totalPacketLabel.setText("Total Packet:");
        getContentPane().add(totalPacketLabel);
        totalPacketLabel.setBounds(10, 220, 170, 14);

        lastPacketLabel.setText("Last Packet:");
        getContentPane().add(lastPacketLabel);
        lastPacketLabel.setBounds(10, 250, 170, 14);

        packetNoLabel.setText("Packet #");
        getContentPane().add(packetNoLabel);
        packetNoLabel.setBounds(10, 280, 170, 14);

        permissionButton.setText("Permission");
        permissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(permissionButton);
        permissionButton.setBounds(340, 280, 120, 23);

        restrictionButton.setText("Restriction");
        restrictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restrictionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restrictionButton);
        restrictionButton.setBounds(340, 310, 120, 23);

        downloadButton.setText("Download");
 
        getContentPane().add(downloadButton);
        downloadButton.setBounds(190, 310, 140, 23);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setForeground(Color.PINK);
        progressBar.setBounds(10, 310, 170, 20);

        userListLabel.setText("Online User ");
        getContentPane().add(userListLabel);
        userListLabel.setBounds(360, 30, 70, 14);

        fileListLabel.setText("Searched Files");
        getContentPane().add(fileListLabel);
        fileListLabel.setBounds(210, 30, 100, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void permissionButtonActionPerformed(ActionEvent evt){
        permissionDialog.setVisible(true);
    }
    
    public void restrictionButtonActionPerformed(ActionEvent evt){
        restrictionDialog.setVisible(true);
    }
    public void driveComboBoxItemChanged(java.awt.event.ItemEvent e){
        Object ob = driveComboBox.getSelectedItem();
        String s = String.valueOf(ob);
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
    javax.swing.JLabel lastPacketLabel;
    javax.swing.JList onlineUserList;
    javax.swing.JScrollPane onlineUserScrollPane;
    javax.swing.JLabel packetNoLabel;
    javax.swing.JLabel packetSizeLabel;
    javax.swing.JButton permissionButton;
    javax.swing.JProgressBar progressBar;
    javax.swing.JButton refreshButton;
    javax.swing.JButton restrictionButton;
    javax.swing.JLabel totalPacketLabel;
    javax.swing.JLabel userListLabel;
    PermissionDialog permissionDialog;
    RestrictionDialog restrictionDialog;
    JLabel pathLabel;
    // End of variables declaration//GEN-END:variables
    
}
