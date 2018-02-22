

import javax.swing.JOptionPane;

public class DayClosingFrame extends javax.swing.JFrame {

    public DayClosingFrame() {
        initComponents();
        try{
            setIconImage(javax.imageio.ImageIO.read(getClass().getResource("/pictures/run-icon.png")));
        }catch(Exception ex){ex.printStackTrace();}
    }
    public void setVisible(boolean b){
        if(b){
           getYears();
              
        }
        super.setVisible(b);
    }
    private void getYears(){
        try{
            yearComboBox.removeAllItems();
            java.util.ArrayList list = DatabaseManager.getYears();
            for(int i=0;i<list.size();i++){
                yearComboBox.addItem(list.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
    }
    private void getDays(){
        YearBean bean = (YearBean)yearComboBox.getSelectedItem();
        if(bean==null)return;
        dayComboBox.removeAllItems();
        try{
            java.util.ArrayList dayList = DatabaseManager.getDays(bean.getYearId());
            for(int i=0;i<dayList.size();i++){
                dayComboBox.addItem(dayList.get(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        openingBalanceLabel = new javax.swing.JLabel();
        openingBalanceTextField = new javax.swing.JTextField();
        closingBalanceLabel = new javax.swing.JLabel();
        closingBalanceTextField = new javax.swing.JTextField();
        remarksLabel = new javax.swing.JLabel();
        remarksScrollPane = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        closeDayButton = new javax.swing.JButton();
        dayComboBox = new javax.swing.JComboBox();
        dateLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        backgroudLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 400));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainLabel.setForeground(new java.awt.Color(255, 0, 51));
        mainLabel.setText("DAILY CLOSING");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(140, 10, 170, 40);

        openingBalanceLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        openingBalanceLabel.setText("Opening Balance");
        getContentPane().add(openingBalanceLabel);
        openingBalanceLabel.setBounds(50, 140, 110, 20);

        openingBalanceTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        getContentPane().add(openingBalanceTextField);
        openingBalanceTextField.setBounds(160, 130, 210, 40);

        closingBalanceLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        closingBalanceLabel.setText("Closing Balance");
        getContentPane().add(closingBalanceLabel);
        closingBalanceLabel.setBounds(50, 180, 100, 30);

        closingBalanceTextField.setFont(new java.awt.Font("Tahoma", 1, 12));
        getContentPane().add(closingBalanceTextField);
        closingBalanceTextField.setBounds(160, 180, 210, 40);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        remarksLabel.setText("REMARKS");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(50, 230, 70, 20);

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksScrollPane.setViewportView(remarksTextArea);

        getContentPane().add(remarksScrollPane);
        remarksScrollPane.setBounds(110, 230, 270, 90);

        closeDayButton.setText("Close Day");
        closeDayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(closeDayButton);
        closeDayButton.setBounds(60, 330, 340, 40);

        dayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(dayComboBox);
        dayComboBox.setBounds(160, 90, 210, 30);

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        dateLabel.setText("Date");
        getContentPane().add(dateLabel);
        dateLabel.setBounds(50, 90, 110, 40);

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        yearLabel.setText("Year");
        getContentPane().add(yearLabel);
        yearLabel.setBounds(50, 50, 110, 40);

        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(yearComboBox);
        yearComboBox.setBounds(160, 50, 210, 30);

        backgroudLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/blue-white-abstract-backgrounds-wallpapers.jpg"))); // NOI18N
        getContentPane().add(backgroudLabel);
        backgroudLabel.setBounds(-6, -6, 480, 390);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-483)/2, (screenSize.height-413)/2, 483, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void closeDayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeDayButtonActionPerformed
       DayBean daybean = (DayBean)this.dayComboBox.getSelectedItem();
       if(daybean==null)return;
       try{
           DatabaseManager.updateDay(daybean.getYearId(), daybean.getdayId(), DateFormatter.dateToStringMonthFormat(daybean.getday()),Integer.parseInt(closingBalanceTextField.getText()) , true , remarksTextArea.getText());
           this.closeDayButton.setEnabled(false);
           JOptionPane.showMessageDialog(null, "day is closed..");
           getDays();
       }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_closeDayButtonActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        getDays();
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void dayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBoxActionPerformed
        YearBean yearbean = (YearBean)this.yearComboBox.getSelectedItem();
        DayBean daybean=(DayBean)dayComboBox.getSelectedItem();
        if(yearbean==null || daybean==null)return;
        DayBean previous=null;
        try {
            previous = DatabaseManager.getPreviousDayOf(DateFormatter.dateToStringMonthFormat(daybean.getday()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(daybean.getClosingBalance()==0){    
            daybean.setClosingBalance(yearbean.getCurrentAmount());
        }
        if(previous!=null && previous.getClosingBalance()!=0)
            openingBalanceTextField.setText(""+previous.getClosingBalance());
        else 
            openingBalanceTextField.setText(""+daybean.getClosingBalance());
        
        this.closingBalanceTextField.setText(""+daybean.getClosingBalance());
        if(daybean.isClosed()){
             this.closeDayButton.setEnabled(false);
        }
        else{
             this.closeDayButton.setEnabled(true);
            }
        
    }//GEN-LAST:event_dayComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroudLabel;
    private javax.swing.JButton closeDayButton;
    private javax.swing.JLabel closingBalanceLabel;
    private javax.swing.JTextField closingBalanceTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JComboBox dayComboBox;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel openingBalanceLabel;
    private javax.swing.JTextField openingBalanceTextField;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JScrollPane remarksScrollPane;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
