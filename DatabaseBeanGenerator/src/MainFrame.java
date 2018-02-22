/*
 * MainFrame.java
 *
 * Created on Sep 12, 2011, 6:11:44 PM
 */
/**
 *
 * @author Yougeshwar Khatri
 */
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));
        
        initComponents();
        userConstructor();
    }
    
    private void userConstructor(){
        aboutBox = new AboutBox(this);
        this.getContentPane().setBackground(Color.white);
        this.setSize(612, 637);
        this.setLocationRelativeTo(null);
        
        this.dbSoftwareComboBox.addItem(new ComboBoxItem("MS Access", "sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:db", "", ""));
        this.dbSoftwareComboBox.addItem(new ComboBoxItem("MySQL", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/db", "root", ""));
        this.dbSoftwareComboBox.addItem(new ComboBoxItem("SQL Server", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost:1433/db", "", ""));
        this.dbSoftwareComboBox.addItem(new ComboBoxItem("Oracle", "oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521/db", "scott", "tiger"));
        
        this.fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        classDriverTextField = new javax.swing.JTextField();
        loadButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staticalReportTextArea = new javax.swing.JTextArea();
        dbSoftwareComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Bean Generator");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Database Bean Generator");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(149, 11, 304, 118);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Select Database Software");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 154, 159, 15);

        classDriverTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        classDriverTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray)));
        getContentPane().add(classDriverTextField);
        classDriverTextField.setBounds(90, 187, 210, 29);

        loadButton.setFont(new java.awt.Font("Tahoma", 1, 24));
        loadButton.setText("Generate");
        loadButton.setBorder(border);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton);
        loadButton.setBounds(10, 315, 586, 51);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Statical Report"));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        staticalReportTextArea.setColumns(20);
        staticalReportTextArea.setEditable(false);
        staticalReportTextArea.setFont(new java.awt.Font("Monospaced", 0, 14));
        staticalReportTextArea.setLineWrap(true);
        staticalReportTextArea.setRows(5);
        staticalReportTextArea.setWrapStyleWord(true);
        staticalReportTextArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(staticalReportTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(6, 373, 590, 220);

        dbSoftwareComboBox.setFont(new java.awt.Font("Tahoma", 1, 12));
        dbSoftwareComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dbSoftwareComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbSoftwareComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(dbSoftwareComboBox);
        dbSoftwareComboBox.setBounds(179, 147, 320, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Class Driver");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 194, 70, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("URL");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 194, 24, 15);

        urlTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        urlTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray)));
        getContentPane().add(urlTextField);
        urlTextField.setBounds(373, 187, 220, 29);
        urlTextField.setBounds(373, 187, 222, 29);

        userTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        userTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray)));
        getContentPane().add(userTextField);
        userTextField.setBounds(90, 227, 210, 29);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("User");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 235, 26, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(310, 234, 59, 15);

        passwordTextField.setFont(new java.awt.Font("Tahoma", 0, 14));
        passwordTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.white, new java.awt.Color(58, 110, 165), java.awt.Color.darkGray)));
        getContentPane().add(passwordTextField);
        passwordTextField.setBounds(373, 227, 220, 29);
        passwordTextField.setBounds(373, 227, 222, 29);

        progressBar.setFont(new java.awt.Font("Tahoma", 1, 12));
        progressBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(10, 274, 586, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bean2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 11, 133, 118);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bean1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(463, 11, 133, 118);

        aboutButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        aboutButton.setText("About");
        aboutButton.setBorder(border);
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(aboutButton);
        aboutButton.setBounds(505, 147, 91, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
    if(JFileChooser.APPROVE_OPTION == this.fileChooser.showSaveDialog(this)){
        File folder = fileChooser.getSelectedFile();
        if(folder.isDirectory()){
            new GeneratorThread(folder).start();
        }
    }
}//GEN-LAST:event_loadButtonActionPerformed

private void dbSoftwareComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbSoftwareComboBoxActionPerformed
    ComboBoxItem comboBoxItem = (ComboBoxItem) this.dbSoftwareComboBox.getSelectedItem();
    if(comboBoxItem == null) return;
    
    this.classDriverTextField.setText(comboBoxItem.getDriverClass());
    this.urlTextField.setText(comboBoxItem.getURL());
    this.userTextField.setText(comboBoxItem.getUser());
    this.passwordTextField.setText(comboBoxItem.getPassword());
}//GEN-LAST:event_dbSoftwareComboBoxActionPerformed

private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
    aboutBox.show();
}//GEN-LAST:event_aboutButtonActionPerformed

    private class GeneratorThread extends Thread{
        private File folder;
        private GeneratorThread(File folder){
            this.folder = folder;
        }
        @Override
        public void run(){
            String classDriver = classDriverTextField.getText();
            String url = urlTextField.getText();
            String user = userTextField.getText();
            String password = passwordTextField.getText();
            try{
                DatabaseManager manager = new DatabaseManager(classDriver, url, user, password);
                Vector<String> tablesName = manager.getTable();
                Hashtable<String, Vector<String>> columnsName = manager.getColumn();
                Hashtable<String, Vector<String>> columnsType = manager.getColumnType();
                
                staticalReportTextArea.setText("");
                progressBar.setMaximum(tablesName.size()); 
                loadButton.setEnabled(false);
                for(int i = 0; i < tablesName.size(); i++){
                    progressBar.setValue(i);
                    Thread.sleep(500);
                    generate(folder.toString(), tablesName.elementAt(i), columnsName.get(tablesName.elementAt(i)), columnsType.get(tablesName.elementAt(i)));
                }
                JOptionPane.showMessageDialog(null, tablesName.size() + " Bean files are created successfully...");
                progressBar.setValue(progressBar.getMaximum());
                Desktop desktop = Desktop.getDesktop();
                desktop.open(folder);
                loadButton.setEnabled(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "generate() : " + e);
                e.printStackTrace();
            }
        }
    }
    
    private void generate(String path, String tableName, Vector<String> columns, Vector<String> types)throws Exception{
        String className = CamelNotationLogic.getClass(tableName) + "Bean";
        String text = staticalReportTextArea.getText();
        
        text += "--------------------------------------------------------------------";
        text += "\n" + className + "\n";
        text += "--------------------------------------------------------------------\n";
        text += "In this class " + columns.size() + " variables declared private, each variables have two methods first one is 'Setter' and second one is 'Getter' and in this class also overrided the mehtod of Object class that is toString() which return empty string value...\n";
        
        staticalReportTextArea.setText(text);
        
        PrintStream out = new PrintStream(new FileOutputStream(path + "\\" + className + ".java"));
        out.println("/*");
        out.println("* " + className + ".java");
        out.println("*");
        out.println("* Created on " + DateDecoder.getDateFormat(new Date()));
        out.println("*");
        out.println("*");
        out.println("* @author Yougeshwar Khatri");
        out.println("*/\n");

        out.println("public class " + className + "{");
                        
        for(int i = 0; i < columns.size(); i++){
            String variableName = CamelNotationLogic.getVaraible(columns.elementAt(i));
            String type = TypeCasting.getJavaType(types.elementAt(i));

            out.println("    private " + type + " " + variableName + ";");
        }
        out.println("\n    /*Constructor*/");
        out.println("    public " + className + "() {}");

        out.println("\n    /*Setter Methods*/");

        for(int i = 0; i < columns.size(); i++){
            String variable = CamelNotationLogic.getVaraible(columns.elementAt(i));
            String type = TypeCasting.getJavaType(types.elementAt(i));
            String method = CamelNotationLogic.getClass(columns.elementAt(i));
            
            out.println("    public void set" + method + "(" + type + " " + variable + "){");
            out.println("        this." + variable + " = "+ variable + ";");
            out.println("    }");
        }
        out.println("\n    /*Getter Methods*/");
        for(int i = 0; i < columns.size(); i++){
            String variable = CamelNotationLogic.getVaraible(columns.elementAt(i));
            String type = TypeCasting.getJavaType(types.elementAt(i));
            String method = CamelNotationLogic.getClass(columns.elementAt(i));
            
            out.println("    public "+ type +" get" + method + "(){");
            out.println("        return this." + variable+ ";");
            out.println("    }");
        }
        
        out.println("\n    @Override");
        out.println("    public String toString(){");
        out.println("        return \"\";");
        out.println("    }");
        out.println("}");
        
        out.close();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JTextField classDriverTextField;
    private javax.swing.JComboBox dbSoftwareComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextArea staticalReportTextArea;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
    private Border border;
    private JFileChooser fileChooser;
    private AboutBox aboutBox;
}
