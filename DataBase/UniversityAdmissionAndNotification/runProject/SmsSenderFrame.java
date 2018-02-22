


/*
 * SmsSenderFrame.java
 *
 * Created on Jan 14, 2013, 7:51:50 PM
 */
public class SmsSenderFrame extends javax.swing.JFrame {

    SmsSender smsSender;
    public SmsSenderFrame() {
        initComponents();
        smsSender  = new SmsSender();
    }
    
    public void setVisible(boolean b){
        if(b){
            getDepartments();
        }
        super.setVisible(b);
    }
    
    private void getDepartments(){
        
            this.departmentComboBox.removeAllItems();
        try{
            java.util.Vector vector = DatabaseManager.getAllDepartments();
            for(int i =0 ;i<vector.size() ; i++){
                departmentComboBox.addItem(vector.elementAt(i));
            }
        }catch(Exception e){e.printStackTrace();}
   }
    
    private void getPrograms(){
        DepartmentBean dBean = (DepartmentBean)departmentComboBox.getSelectedItem();
        if(dBean==null)return;
        this.programComboBox.removeAllItems();
        try{
            java.util.Vector vec = DatabaseManager.getAllProgram(dBean.getDeptID());
            for(int i=0; i<vec.size(); i++){
                programComboBox.addItem(vec.elementAt(i));
            }
        }catch(Exception ex){ex.printStackTrace();}
   }
    private void getBatches(){
        ProgramBean progBean = (ProgramBean)programComboBox.getSelectedItem();
        if(progBean==null)return;
        batchComboBox.removeAllItems();
        try {
            java.util.Vector vec = DatabaseManager.getAllBatches(progBean.getProgID());
            for(int i=0; i<vec.size() ; i++){
                batchComboBox.addItem(vec.elementAt(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
          }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        batchLabel = new javax.swing.JLabel();
        batchComboBox = new javax.swing.JComboBox();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        programLabel = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        shiftLabel = new javax.swing.JLabel();
        shiftComboBox = new javax.swing.JComboBox();
        groupComboBox = new javax.swing.JComboBox();
        sessionLabel = new javax.swing.JLabel();
        sessionComboBox = new javax.swing.JComboBox();
        groupLabel = new javax.swing.JLabel();
        eventIdLabel = new javax.swing.JLabel();
        eventIdTextField = new javax.swing.JTextField();
        dateOfSendLabel = new javax.swing.JLabel();
        dateOfSendTextField = new javax.swing.JFormattedTextField();
        eventTitleLabel = new javax.swing.JLabel();
        eventTitleTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        remarksLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventsList = new javax.swing.JList();
        totalStudentsLabel = new javax.swing.JLabel();
        totalStudentValueLabel = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        serviceMenu = new javax.swing.JMenu();
        portConnectorMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 530));
        setResizable(false);
        getContentPane().setLayout(null);

        batchLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        batchLabel.setText("Batch");
        getContentPane().add(batchLabel);
        batchLabel.setBounds(10, 220, 70, 20);

        batchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(batchComboBox);
        batchComboBox.setBounds(100, 210, 120, 30);

        departmentLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        departmentLabel.setText("Department");
        getContentPane().add(departmentLabel);
        departmentLabel.setBounds(10, 90, 80, 20);

        departmentComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(100, 80, 300, 30);

        programLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        programLabel.setText("Program");
        getContentPane().add(programLabel);
        programLabel.setBounds(10, 150, 70, 20);

        programComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programComboBoxItemStateChanged(evt);
            }
        });
        getContentPane().add(programComboBox);
        programComboBox.setBounds(100, 150, 300, 30);

        shiftLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        shiftLabel.setText("Shift");
        getContentPane().add(shiftLabel);
        shiftLabel.setBounds(220, 210, 50, 30);

        shiftComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning", "Noon", "Evening" }));
        getContentPane().add(shiftComboBox);
        shiftComboBox.setBounds(270, 210, 130, 30);

        groupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pre-Engineering", "Pre-Medical", "Pre-Commerce", "No Group" }));
        getContentPane().add(groupComboBox);
        groupComboBox.setBounds(100, 270, 120, 30);

        sessionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sessionLabel.setText("Session");
        getContentPane().add(sessionLabel);
        sessionLabel.setBounds(220, 270, 50, 30);

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spring", "Fall" }));
        getContentPane().add(sessionComboBox);
        sessionComboBox.setBounds(270, 270, 130, 30);

        groupLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        groupLabel.setText("Group");
        getContentPane().add(groupLabel);
        groupLabel.setBounds(10, 280, 70, 20);

        eventIdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        eventIdLabel.setText("Event ID");
        getContentPane().add(eventIdLabel);
        eventIdLabel.setBounds(10, 326, 70, 14);

        eventIdTextField.setEditable(false);
        getContentPane().add(eventIdTextField);
        eventIdTextField.setBounds(100, 320, 120, 20);

        dateOfSendLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dateOfSendLabel.setText("Date Of Send");
        getContentPane().add(dateOfSendLabel);
        dateOfSendLabel.setBounds(220, 320, 80, 20);

        dateOfSendTextField.setEditable(false);
        try {
            dateOfSendTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(dateOfSendTextField);
        dateOfSendTextField.setBounds(300, 320, 100, 20);

        eventTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        eventTitleLabel.setText("Event Title");
        getContentPane().add(eventTitleLabel);
        eventTitleLabel.setBounds(10, 360, 70, 14);
        getContentPane().add(eventTitleTextField);
        eventTitleTextField.setBounds(100, 360, 300, 20);

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 400, 310, 70);

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remarksLabel.setText("<Html>Event<br>Discription");
        getContentPane().add(remarksLabel);
        remarksLabel.setBounds(10, 400, 70, 30);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(20, 480, 630, 20);

        eventsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eventsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(eventsList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 70, 230, 320);

        totalStudentsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalStudentsLabel.setText("Total Student :");
        getContentPane().add(totalStudentsLabel);
        totalStudentsLabel.setBounds(420, 400, 90, 14);

        totalStudentValueLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalStudentValueLabel.setForeground(new java.awt.Color(51, 0, 255));
        totalStudentValueLabel.setText("0");
        getContentPane().add(totalStudentValueLabel);
        totalStudentValueLabel.setBounds(510, 400, 110, 14);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(420, 420, 170, 50);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Back-icon.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(590, 420, 67, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Broadcast Event Notifivation Through Cell Phone Service");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 20, 560, 20);

        serviceMenu.setText("Service");

        portConnectorMenuItem.setText("Port Connector");
        portConnectorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portConnectorMenuItemActionPerformed(evt);
            }
        });
        serviceMenu.add(portConnectorMenuItem);

        jMenuBar1.add(serviceMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchComboBoxItemStateChanged
        BatchBean bean = (BatchBean)this.batchComboBox.getSelectedItem();
        if(bean==null)return;
        this.sessionComboBox.setSelectedItem(TypeDecoder.decode(bean.getSession()));
        this.groupComboBox.setSelectedItem(TypeDecoder.decode(bean.getGroup()));
        this.shiftComboBox.setSelectedItem(TypeDecoder.decode(bean.getShift()));
        try{
            java.util.ArrayList list = DatabaseManager.getAllEventMessages(bean.getBatchId());
            this.eventsList.setListData(list.toArray());
        }catch(Exception ex){ex.printStackTrace();}
}//GEN-LAST:event_batchComboBoxItemStateChanged

    private void departmentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboBoxItemStateChanged
        getPrograms();
}//GEN-LAST:event_departmentComboBoxItemStateChanged

    private void programComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programComboBoxItemStateChanged
        getBatches();
}//GEN-LAST:event_programComboBoxItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void portConnectorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portConnectorMenuItemActionPerformed
        smsSender.setVisible(true);
    }//GEN-LAST:event_portConnectorMenuItemActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if(smsSender.connection==null){
           javax.swing.JOptionPane.showMessageDialog(null,"no any connection..\nPlease click the service and connect with the Mobile (port)..");
           return;
        }
        new Thread(){
            public void run(){
                try{
                    BatchBean bean = (BatchBean)batchComboBox.getSelectedItem();
                    int r= DatabaseManager.addMessageEvent(bean.getBatchId(), eventTitleTextField.getText(), descriptionTextArea.getText(), DateFormatter.dateToStringMonthFormat(new java.util.Date()));
                
                    java.util.Vector list = DatabaseManager.getAllStudents(bean.getBatchId());
                    for(int i=0;i<list.size();i++){
                        StudentBean stdBean = (StudentBean)list.get(i);

                        if(stdBean.getCellNo().length()>2){
                            System.out.println("Phone # "+stdBean.getCellNo());
                            smsSender.connection.send(stdBean.getCellNo(), eventTitleTextField.getText()+"\n"+descriptionTextArea.getText());
                        }
                    }
                }catch(Exception ex){ex.printStackTrace();}
            }
        }.start();
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void eventsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eventsListValueChanged
       EventMessageBean b = (EventMessageBean)eventsList.getSelectedValue();
       if(b==null)return;
       
       this.eventTitleTextField.setText(b.getDesciption());
       this.descriptionTextArea.setText(b.getTitle());
        
    }//GEN-LAST:event_eventsListValueChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox batchComboBox;
    private javax.swing.JLabel batchLabel;
    private javax.swing.JLabel dateOfSendLabel;
    private javax.swing.JFormattedTextField dateOfSendTextField;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel eventIdLabel;
    private javax.swing.JTextField eventIdTextField;
    private javax.swing.JLabel eventTitleLabel;
    private javax.swing.JTextField eventTitleTextField;
    private javax.swing.JList eventsList;
    private javax.swing.JComboBox groupComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem portConnectorMenuItem;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JLabel programLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JMenu serviceMenu;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox shiftComboBox;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JLabel totalStudentValueLabel;
    private javax.swing.JLabel totalStudentsLabel;
    // End of variables declaration//GEN-END:variables
}
