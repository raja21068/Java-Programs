package form;

import bean.User;
import database.DatabaseManager;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JAY KUMAR
 */
public class LoginFrame extends javax.swing.JFrame {

    MainFrame mainFrame;
    
    public LoginFrame() {
        initComponents();
        mainFrame = new MainFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        loginButton.setText("LOG IN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordField))
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try{
            login();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..!\n"+ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        try{
            login();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..!\n"+ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void login()throws Exception{
        String userName = usernameTextField.getText();
        String pass = passwordField.getText();
        
        if( userName.contains("%") || userName.contains("'") || userName.contains(",") || pass.contains("%") || pass.contains("'") || pass.contains(",") ){
            errorLabel.setText("% , '     are not allowed in Username or Password..");
            return;
        }
        List list = DatabaseManager.getData(User.class.getName(), " userName='"+userName+"'  AND password='"+pass+"'", " userName asc ");
        if(list.size()>0){
            mainFrame.setVisible(true);
            setVisible(false);
        }else{
            errorLabel.setText("Invalid UserName or Password..");
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if(b){
            usernameTextField.setText("");
            passwordField.setText("");
            errorLabel.setText("");
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
