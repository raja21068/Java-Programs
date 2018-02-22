
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author DELL
 */
public class SmsSender extends javax.swing.JFrame {

    public static Connect connection;
    JFileChooser choose;
    public SmsSender() {
        initComponents();
        list = new ArrayList();
        choose = new JFileChooser();
        setting = new SettingDialog(this,true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        portsComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        detectButton = new javax.swing.JButton();
        phoneNoComboBox = new javax.swing.JComboBox();
        phoneNumberTextField = new javax.swing.JFormattedTextField();
        connectButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        simContactButton = new javax.swing.JButton();
        mobileCheckBox = new javax.swing.JCheckBox();
        simCheckBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        fileTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        databaseButton = new javax.swing.JButton();
        addToSendingButton = new javax.swing.JButton();
        totalContactLabel = new javax.swing.JLabel();
        fileTextField1 = new javax.swing.JTextField();
        openButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionMenu = new javax.swing.JMenu();
        settingMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMS SENDER");
        setMinimumSize(new java.awt.Dimension(550, 460));
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().add(portsComboBox);
        portsComboBox.setBounds(50, 70, 130, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ports");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 70, 40, 14);

        detectButton.setText("Detect Ports");
        detectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(detectButton);
        detectButton.setBounds(190, 70, 110, 35);

        phoneNoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "03332836704" }));
        phoneNoComboBox.setEnabled(false);
        getContentPane().add(phoneNoComboBox);
        phoneNoComboBox.setBounds(10, 170, 170, 30);

        phoneNumberTextField.setEnabled(false);
        phoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(phoneNumberTextField);
        phoneNumberTextField.setBounds(10, 120, 170, 30);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(connectButton);
        connectButton.setBounds(190, 120, 110, 35);

        removeAllButton.setText("<html>Remove All<br>From list");
        removeAllButton.setEnabled(false);
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });
        getContentPane().add(removeAllButton);
        removeAllButton.setBounds(190, 170, 110, 35);

        jScrollPane1.setEnabled(false);

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 280, 70);

        jLabel2.setText("Message:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 220, 60, 14);

        sendButton.setText("SEND");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton);
        sendButton.setBounds(10, 310, 280, 40);

        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(10, 360, 280, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("MOBILE CONTROL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 10, 120, 40);

        simContactButton.setText("Contacts");
        simContactButton.setEnabled(false);
        simContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simContactButtonActionPerformed(evt);
            }
        });
        getContentPane().add(simContactButton);
        simContactButton.setBounds(320, 280, 80, 30);

        buttonGroup1.add(mobileCheckBox);
        mobileCheckBox.setText("Mobile");
        mobileCheckBox.setEnabled(false);
        mobileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(mobileCheckBox);
        mobileCheckBox.setBounds(400, 250, 80, 23);

        buttonGroup1.add(simCheckBox);
        simCheckBox.setText("Sim");
        simCheckBox.setEnabled(false);
        simCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(simCheckBox);
        simCheckBox.setBounds(340, 250, 60, 23);

        jScrollPane2.setEnabled(false);

        contactList.setEnabled(false);
        contactList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                contactListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(contactList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(320, 20, 160, 230);

        fileTextField.setEditable(false);
        getContentPane().add(fileTextField);
        fileTextField.setBounds(400, 340, 80, 22);

        browseButton.setText("Browse");
        browseButton.setEnabled(false);
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton);
        browseButton.setBounds(320, 340, 80, 23);

        databaseButton.setText("Move to Database");
        databaseButton.setEnabled(false);
        databaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(databaseButton);
        databaseButton.setBounds(320, 370, 160, 23);

        addToSendingButton.setText("<html>Add to Sending");
        addToSendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToSendingButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addToSendingButton);
        addToSendingButton.setBounds(320, 312, 160, 23);

        totalContactLabel.setText("0");
        totalContactLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(totalContactLabel);
        totalContactLabel.setBounds(440, 0, 40, 20);
        getContentPane().add(fileTextField1);
        fileTextField1.setBounds(590, 20, 40, 22);

        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        getContentPane().add(openButton);
        openButton.setBounds(400, 280, 80, 30);

        optionMenu.setText("Option");

        settingMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Settings-icon.png"))); // NOI18N
        settingMenuItem.setText("Setting");
        settingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(settingMenuItem);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/exit.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        optionMenu.add(exitMenuItem);

        jMenuBar1.add(optionMenu);

        aboutMenu.setText("Help");

        aboutMenuItem.setText("about");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuItem);

        helpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Help-icon.png"))); // NOI18N
        helpMenuItem.setText("help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(helpMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detectButtonActionPerformed
        Enumeration e = CommPortIdentifier.getPortIdentifiers();
        this.portsComboBox.removeAllItems();
        while (e.hasMoreElements()) {
            CommPortIdentifier portId = (CommPortIdentifier) e.nextElement();
            String name = portId.getName();
            this.portsComboBox.addItem(name);
        }
    }//GEN-LAST:event_detectButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        String portNo = this.portsComboBox.getSelectedItem().toString();
        if(portNo==null)return;
        try{
            connection = new Connect(portNo);
            JOptionPane.showMessageDialog(null, "connection estblisted");
            
            this.phoneNumberTextField.setEnabled(true);
            this.phoneNoComboBox.setEnabled(true);
            this.removeAllButton.setEnabled(true);
            this.messageTextArea.setEnabled(true);
            this.sendButton.setEnabled(true);
            this.simContactButton.setEnabled(true);
            this.connectButton.setEnabled(true);
            this.simCheckBox.setEnabled(true);
            this.mobileCheckBox.setEnabled(true);
            this.contactList.setEnabled(true);
            this.browseButton.setEnabled(true);
        }catch (javax.comm.PortInUseException e){
           System.out.println("Port In Use " + e);
        }catch (java.io.IOException e){
           System.out.println("Error writing to output stream " + e);
        }catch (javax.comm.UnsupportedCommOperationException e){
           e.printStackTrace();
        }catch(Exception ex){ex.printStackTrace();}
        
    }//GEN-LAST:event_connectButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        this.phoneNoComboBox.removeAllItems();
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        for(int i=0;i<phoneNoComboBox.getItemCount();i++){
            String mobileNo = this.phoneNoComboBox.getItemAt(i).toString();
            String msg = this.messageTextArea.getText();
            connection.send(mobileNo, msg);
        }
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void phoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextFieldActionPerformed
        this.phoneNoComboBox.addItem(this.phoneNumberTextField.getText().trim());
    }//GEN-LAST:event_phoneNumberTextFieldActionPerformed

    private void simContactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simContactButtonActionPerformed
        new Thread(){
            public void run(){
                list = new ArrayList();
                progressBar.setMinimum(0);
                
                if(simCheckBox.isSelected()){
                    progressBar.setMaximum(setting.simContacts);
                    for(int i=1;i<=setting.simContacts;i++){
                    connection.contactEntries(i);
                    progressBar.setValue(i);
                  }
                }
                if(mobileCheckBox.isSelected()){
                  progressBar.setMaximum(setting.mobileContacts);  
                  for(int i=1;i<=setting.mobileContacts;i++){
                    connection.contactEntries(i);
                    progressBar.setValue(i);
                  }
                }
                 
               contactList.setListData(list.toArray());
               totalContactLabel.setText(""+list.size());
          }
        }.start();
        
    }//GEN-LAST:event_simContactButtonActionPerformed

    private void mobileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileCheckBoxActionPerformed
        connection.executeCmd("AT+CPBS=\"ME\"");
        try{
            Thread.sleep(500);
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_mobileCheckBoxActionPerformed

    private void simCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simCheckBoxActionPerformed
        connection.executeCmd("AT+CPBS=\"SM\"");
        try{
            Thread.sleep(500);
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_simCheckBoxActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        choose.showSaveDialog(this);
        String s = choose.getSelectedFile().getAbsolutePath();
        fileTextField.setText(s+".mdb");
        this.databaseButton.setEnabled(true);
    }//GEN-LAST:event_browseButtonActionPerformed

    private void databaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseButtonActionPerformed
        if(fileTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "select path where you want to save");
            return;
        }
            
        try {
            
            for(int i=0;i<list.size();i++){
                ContactBean b=(ContactBean)list.get(i);
                String s  = (b.getName().replace('\'',' '));
                s = (s.replace(',',' '));
                System.out.println("Name:"+s);
                DatabaseManager.addContact(i+1,s, b.getNumber());
            }
            new File(fileTextField.getText()).createNewFile();
            FileInputStream in = new FileInputStream("data.mdb");
            FileOutputStream out = new FileOutputStream(fileTextField.getText());
           
            int size=in.available();
            int packet = 10000;
            int packs = size/packet;
            int last = size%packet;
            System.out.println(size);
            System.out.println(packet);
            System.out.println(packs);
            System.out.println(last);
            byte[] data = new byte[packet]; 
            for(int i=1;i<=packs;i++){
                in.read(data, 0, data.length);
                out.write(data, 0, data.length);
            }
            in.read(data, 0, last);
            out.write(data, 0, last);
            Thread.sleep(1000);
            in.close();
            out.close();
            
            DatabaseManager.deleteContacts();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace();
        }catch (IOException ex) {
                 ex.printStackTrace();
        }catch (Exception ex) {
                 ex.printStackTrace();
         }
    }//GEN-LAST:event_databaseButtonActionPerformed

    private void settingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingMenuItemActionPerformed
        setting.setVisible(true);
    }//GEN-LAST:event_settingMenuItemActionPerformed

    private void addToSendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToSendingButtonActionPerformed
        
        java.util.List list = contactList.getSelectedValuesList();
        for(int i=0;i<list.size();i++){
            ContactBean bean = (ContactBean)list.get(i);
      
            this.phoneNoComboBox.addItem(bean.getNumber());
        }
        
    }//GEN-LAST:event_addToSendingButtonActionPerformed

    private void contactListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_contactListValueChanged
        ContactBean bean = (ContactBean)this.contactList.getSelectedValue();
        if(bean==null)return;
        this.phoneNumberTextField.setText(bean.getNumber());
    }//GEN-LAST:event_contactListValueChanged

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This Project is developed by : JAY KUMAR 2k11/csm/25 (Computer Science) University Of Sindh");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"README.txt");
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "mdb", "mdb");
        choose.setFileFilter(filter);
        choose.showOpenDialog(this);
        String s = choose.getSelectedFile().getAbsolutePath();
        fileTextField1.setText(s);
        data=new DatabaseConnection(s);
        try {
            java.util.ArrayList list = data.getContacts();
            System.out.println(list.size());
            contactList.setListData(list.toArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_openButtonActionPerformed

    public static void main(String arg[]){
        new SmsSender().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addToSendingButton;
    private javax.swing.JButton browseButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton connectButton;
    private javax.swing.JList contactList;
    private javax.swing.JButton databaseButton;
    private javax.swing.JButton detectButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JTextField fileTextField1;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JCheckBox mobileCheckBox;
    private javax.swing.JButton openButton;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JComboBox phoneNoComboBox;
    private javax.swing.JFormattedTextField phoneNumberTextField;
    private javax.swing.JComboBox portsComboBox;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JMenuItem settingMenuItem;
    private javax.swing.JCheckBox simCheckBox;
    private javax.swing.JButton simContactButton;
    private javax.swing.JLabel totalContactLabel;
    // End of variables declaration//GEN-END:variables
    public static ArrayList list;
    private SettingDialog setting;
    DatabaseConnection data;
}
