
/*
 * PermissionDialog.java
 *
 * Created on Oct 6, 2012, 3:30:47 AM
 */

/**
 *
 * @author Jay Kumar
 */
public class PermissionDialog extends javax.swing.JDialog {

    /** Creates new form PermissionDialog */
    public PermissionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

    	Label = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        permissionBtn = new javax.swing.JButton();
        comboLabel = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("dialog"); // NOI18N

        Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label.setText("Grant Permission");

        ipLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        ipLabel.setText("Remote IP");

        permissionBtn.setText("Permit");

        comboLabel.setText("Restrict Remote IP's");

        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(permissionBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(ipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permissionBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	jTextField1.setText((String)comboBox.getSelectedItem());
    }
    public void  setVisible(boolean b){
    	try{
    	updateCombo();}catch(Exception e){e.printStackTrace();}
    	super.setVisible(b);
    }
    public void updateCombo()throws Exception{
    	comboBox.removeAllItems();
    	java.util.Vector v = DBManager.getAllIps();
    	for(int i=0 ; i<v.size(); i++){ comboBox.addItem((String)v.elementAt(i)); } 
    }
    
    // Variables declaration - do not modify
    javax.swing.JComboBox comboBox;
    javax.swing.JLabel comboLabel;
    javax.swing.JLabel ipLabel;
    javax.swing.JLabel Label;
    javax.swing.JTextField jTextField1;
    javax.swing.JButton permissionBtn;
    // End of variables declaration
}
