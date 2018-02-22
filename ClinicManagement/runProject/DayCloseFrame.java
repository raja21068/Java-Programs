
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Jay
 */
public class DayCloseFrame extends javax.swing.JFrame {

    public DayCloseFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        closeDayButton = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel.setText("Date");

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("REMARKS");

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        closeDayButton.setText("Close Day");
        closeDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDayButtonActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("DAILY CLOSING");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(closeDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarksScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(closeDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeDayButtonActionPerformed
        DayBean bean = (DayBean)dayComboBox.getSelectedItem();
        if(bean==null)return;
        try{
            DatabaseManager.updateDay(bean.getYearId(), bean.getDayId(),DateFormatter.dateToStringMonthFormat(bean.getDay()), true, remarksTextArea.getText());
            refreshDay();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_closeDayButtonActionPerformed

    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        try{
            refreshDay();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showInternalMessageDialog(this, ex);
        }
        
    }
    void refreshDay()throws Exception{
        dayComboBox.removeAllItems();
        ArrayList list = DatabaseManager.getAllUnclosedDay();
        for(int i=0;i<list.size();i++){
            dayComboBox.addItem(list.get(i));
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeDayButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    // End of variables declaration//GEN-END:variables
}
