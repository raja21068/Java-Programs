/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import bean.User;
import database.DatabaseManager;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author JAY KUMAR
 */
public class UserFrame extends javax.swing.JFrame {

    public UserFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deletButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        backButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(153, 0, 51));
        mainLabel.setText("USERS");

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deletButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        deletButton.setText("Delete");
        deletButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletButtonActionPerformed(evt);
            }
        });

        userList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                userListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(userList);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(mainLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(usernameTextField)
                                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deletButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addComponent(errorLabel)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String userName = usernameTextField.getText();
        String password = passwordTextField.getText();
        
        if(userName.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Username is empty..");
            return;
        }
        if(password.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Password is empty..");
            return;
        }
        if( userName.contains("%") || userName.contains("'") || userName.contains(",") || password.contains("%") || password.contains("'") || password.contains(",") ){
            errorLabel.setText("% , '     are not allowed in Username or Password..");
            return;
        }
        
        try{
            User user = new User(userName, password);
            DatabaseManager.addData(user);
        
            refreshUser();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..\n"+ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void userListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userListValueChanged
        User user = (User)userList.getSelectedValue();
        if(user == null){ return;}
        usernameTextField.setText(user.getUserName());
        passwordTextField.setText(user.getPassword());
    }//GEN-LAST:event_userListValueChanged

    private void deletButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletButtonActionPerformed
        User user = (User)userList.getSelectedValue();
        if(user == null){ return;}
       try{ 
           DatabaseManager.deleteData(User.class,user.getUserId());
           refreshUser();
       }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "Error Ocuured.. \n"+ex);
           ex.printStackTrace(System.err);
       }
    }//GEN-LAST:event_deletButtonActionPerformed

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        try{
            refreshUser();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..\n"+ex);
            ex.printStackTrace(System.err);
        }
    }

    private void refreshUser()throws Exception{
        List list = DatabaseManager.getData(User.class.getName(), " userName ASC ");
        userList.setListData(list.toArray());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deletButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JList userList;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
