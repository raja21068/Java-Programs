import javax.swing.*;
public class DownloadingFrame extends JFrame {

    /** Creates new form DownloadingFrame */
    public DownloadingFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        newDownload = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dynamic File Download Protocol");

        newDownload.setFont(new java.awt.Font("Cambria", 1, 10)); // NOI18N
        newDownload.setText("New Download");
        newDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDownloadActionPerformed(evt);
            }
        });

        resume.setFont(new java.awt.Font("Cambria", 1, 10)); // NOI18N
        resume.setText("Resume");
        resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Cambria", 1, 10)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "%age copleted", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(table);
        table.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resume, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(resume, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
    }//GEN-LAST:event_deleteActionPerformed

    private void resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resumeActionPerformed

    private void newDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDownloadActionPerformed
        new FileCopyInGUI();
    }//GEN-LAST:event_newDownloadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DownloadingFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JButton newDownload;
    javax.swing.JButton resume;
    javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
