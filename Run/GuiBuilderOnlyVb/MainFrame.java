
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
    private class GeneratorThread extends Thread
    {
        private File folder;
        GeneratorThread(File folder){
            this.folder = folder;
        }
        public void run()
        {
            String classDriver = classDriverTextField.getText();
            String url = urlTextField.getText();
            String user = userTextField.getText();
            String password = passwordTextField.getText();
            try
            {
                DatabaseManager manager = new DatabaseManager(classDriver, url, user, password);
                Vector tablesName = manager.getTable();
                Hashtable columnsName = manager.getColumn();
                Hashtable columnsType = manager.getColumnType();
                staticalReportTextArea.setText("");
                progressBar.setMaximum(tablesName.size());
                loadButton.setEnabled(false);
                PrintStream out = null;
               
                if(vbCheckBox.isSelected())
                    out = new PrintStream(new FileOutputStream((new StringBuilder()).append(folder.toString()).append("\\DatabaseManager.vb").toString()));
       
                
                for(int i = 0; i < tablesName.size(); i++)
                {
                    progressBar.setValue(i);
                    Thread.sleep(500L);
                    if(vbCheckBox.isSelected()){
                        generateVb(out, manager.getPrimeryKeyColumn((String)tablesName.elementAt(i)), (String)tablesName.elementAt(i), (Vector)columnsName.get(tablesName.elementAt(i)), (Vector)columnsType.get(tablesName.elementAt(i)));
                        if(i==(tablesName.size())-1){out.println("End Class");}
                    }
                         
                }

                out.close();
                JOptionPane.showMessageDialog(MainFrame.this, " Queries.sql file generated successfully...");
                progressBar.setValue(progressBar.getMaximum());
                Desktop desktop = Desktop.getDesktop();
                desktop.open(folder);
                loadButton.setEnabled(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("generate() : ").append(e).toString());
                e.printStackTrace();
            }
        }

    }


    public MainFrame()
    {
        initComponents();
        userConstructor();
    }

    private void userConstructor()
    {
        aboutBox = new AboutBox(this);
        setLocationRelativeTo(null);
        dbSoftwareComboBox.addItem(new ComboBoxItem("MS Access", "sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:db", "", ""));
        this.dbSoftwareComboBox.addItem(new ComboBoxItem("MS Access(.mdb Direct)", "sun.jdbc.odbc.JdbcOdbcDriver", "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= name", "", ""));
        dbSoftwareComboBox.addItem(new ComboBoxItem("MySQL", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/db", "root", ""));
        dbSoftwareComboBox.addItem(new ComboBoxItem("SQL Server", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost:1433/db", "", ""));
        dbSoftwareComboBox.addItem(new ComboBoxItem("Oracle", "oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@localhost:1521/db", "scott", "tiger"));
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(1);
    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        classDriverTextField = new JTextField();
        loadButton = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        staticalReportTextArea = new JTextArea();
        dbSoftwareComboBox = new JComboBox();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        urlTextField = new JTextField();
        userTextField = new JTextField();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        passwordTextField = new JTextField();
        progressBar = new JProgressBar();
        jLabel3 = new JLabel();
        aboutButton = new JButton();
        jLabel4 = new JLabel();
        vbCheckBox = new JCheckBox("VB");
        cSharpCheckBox = new JCheckBox("C#");
        queryBuilderCheckBox=new JCheckBox("QueryBulder");
        optionPanel = new JPanel();
        javaPanel = new JPanel();
        csVbPanel = new JPanel();
        javaCheckBox=new JCheckBox("Java");
        
        setDefaultCloseOperation(3);
        setTitle("Database Bean Generator");
        setBackground(new Color(255, 255, 255));
        setResizable(false);
        jLabel1.setFont(new Font("Matura MT Script Capitals", 1, 30));
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setText("Gui Coding Generator");
        optionPanel.setLayout(new java.awt.GridLayout(3,1));
        optionPanel.add(jLabel1);
        javaPanel.setLayout(new GridLayout(1,2));
        javaPanel.add(queryBuilderCheckBox);
        javaPanel.add(javaCheckBox);
        
        vbCheckBox.setSelected(true);
        
        optionPanel.add(javaPanel);
        csVbPanel.setLayout(new GridLayout(1,2));
        csVbPanel.add(cSharpCheckBox);
        csVbPanel.add(vbCheckBox);
        optionPanel.add(csVbPanel);
        jLabel2.setFont(new Font("Tahoma", 1, 12));
        jLabel2.setText("Select Database Software");
        classDriverTextField.setFont(new Font("Tahoma", 0, 14));
        loadButton.setFont(new Font("Tahoma", 1, 24));
        loadButton.setText("Generate");
        loadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                loadButtonActionPerformed(evt);
            }

            
        }
);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Statical Report"));
        staticalReportTextArea.setColumns(20);
        staticalReportTextArea.setEditable(false);
        staticalReportTextArea.setFont(new Font("Monospaced", 0, 14));
        staticalReportTextArea.setLineWrap(true);
        staticalReportTextArea.setRows(5);
        staticalReportTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(staticalReportTextArea);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, -1, 558, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, -1, 175, 32767).addContainerGap()));
        dbSoftwareComboBox.setFont(new Font("Tahoma", 1, 12));
        dbSoftwareComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                dbSoftwareComboBoxActionPerformed(evt);
            }
        }
);
        jLabel5.setFont(new Font("Tahoma", 1, 12));
        jLabel5.setText("Class Driver");
        jLabel6.setFont(new Font("Tahoma", 1, 12));
        jLabel6.setText("URL");
        urlTextField.setFont(new Font("Tahoma", 0, 14));
        userTextField.setFont(new Font("Tahoma", 0, 14));
        jLabel7.setFont(new Font("Tahoma", 1, 12));
        jLabel7.setText("User");
        jLabel8.setFont(new Font("Tahoma", 1, 12));
        jLabel8.setText("Password");
        passwordTextField.setFont(new Font("Tahoma", 0, 14));
        progressBar.setFont(new Font("Tahoma", 1, 12));
        progressBar.setStringPainted(true);
//        jLabel3.setIcon(new ImageIcon("C:/Users/RAJA/Desktop/Jay Working/QueryBuilder/logo_sql2.png"));
        jLabel3.setIcon(new ImageIcon(getClass().getResource("logo_sql2.png")));
        aboutButton.setFont(new Font("Tahoma", 1, 12));
        aboutButton.setText("About");
        aboutButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                aboutButtonActionPerformed(evt);
            }

        }
);
        jLabel4.setIcon(new ImageIcon(getClass().getResource("/images/query2.png")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(optionPanel, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4, -2, 139, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel2).addGap(10, 10, 10).addComponent(dbSoftwareComboBox, -2, 328, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(aboutButton, -2, 80, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel5).addGap(10, 10, 10).addComponent(classDriverTextField, -2, 210, -2).addGap(10, 10, 10).addComponent(jLabel6).addGap(39, 39, 39).addComponent(urlTextField, -2, 220, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel7).addGap(54, 54, 54).addComponent(userTextField, -2, 210, -2).addGap(10, 10, 10).addComponent(jLabel8).addGap(4, 4, 4).addComponent(passwordTextField, -2, 220, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(progressBar, -2, 586, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(loadButton, -2, 586, -2)).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jPanel2, -2, -1, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel3, -1, -1, 32767).addComponent(optionPanel, -1, -1, 32767).addComponent(jLabel4, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(jLabel2)).addComponent(dbSoftwareComboBox, -2, 29, -2).addComponent(aboutButton, -2, 29, -2)).addGap(11, 11, 11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(classDriverTextField, -2, 29, -2).addComponent(urlTextField, -2, 29, -2).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5).addComponent(jLabel6)))).addGap(11, 11, 11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(jLabel7)).addComponent(userTextField, -2, 29, -2).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(jLabel8)).addComponent(passwordTextField, -2, 29, -2)).addGap(18, 18, 18).addComponent(progressBar, -2, 30, -2).addGap(11, 11, 11).addComponent(loadButton, -2, 51, -2).addGap(7, 7, 7).addComponent(jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        urlTextField.setBounds(373, 187, 222, 29);
        passwordTextField.setBounds(373, 227, 222, 29);
        pack();
    }

    private void loadButtonActionPerformed(ActionEvent evt)
    {
        if(JFileChooser.APPROVE_OPTION == this.fileChooser.showSaveDialog(this)){
            File folder = fileChooser.getSelectedFile();
            if(folder.isDirectory()){
                new GeneratorThread(folder).start();
            }
        }
    }
    private void dbSoftwareComboBoxActionPerformed(ActionEvent evt)
    {
        ComboBoxItem comboBoxItem = (ComboBoxItem)dbSoftwareComboBox.getSelectedItem();
        if(comboBoxItem == null)
        {
            return;
        } else
        {
            if(comboBoxItem.getDBName().contains(".mdb")){
                JFileChooser dialog = new JFileChooser();
                dialog.showOpenDialog(rootPane);
                String path =  dialog.getSelectedFile().getAbsolutePath();
                System.out.println(path);
                this.urlTextField.setText(comboBoxItem.getURL().replace("name", path));
            }
            classDriverTextField.setText(comboBoxItem.getDriverClass());
            if((this.urlTextField.getText().length())<3)
            {this.urlTextField.setText(comboBoxItem.getURL());}
            userTextField.setText(comboBoxItem.getUser());
            passwordTextField.setText(comboBoxItem.getPassword());
            return;
        }
    }

    private void aboutButtonActionPerformed(ActionEvent evt)
    {
        aboutBox.setVisible(true);
    }

    private void generateVb(PrintStream out, String primeryKey, String tableName, Vector columns, Vector types)
        throws Exception
    {
        String className = CamelNotationLogic.getClass(tableName);
        String text = "";
        text = (new StringBuilder()).append(text).append("--------------------------------------------------------------------").toString();
        text = (new StringBuilder()).append(text).append("\n").append(className).append("\n").toString();
        text = (new StringBuilder()).append(text).append("--------------------------------------------------------------------\n").toString();
        text = (new StringBuilder()).append(text).append("In this table ").append(columns.size()).append(" columns, on bases of these columns this application generates four queries SELECT, INSERT, UPDATE and DELETE...\n").toString();
        staticalReportTextArea.append(text);
        out.println((new StringBuilder()).append("'----------------Queries of ").append(tableName).append(" table----------------").toString()); 
        
        
        out.println(" Private Sub AddButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AddButton.Click");
        out.print("Dim rows As Integer = DataBaseManager.add" +tableName+"(");
        out.print(""+CamelNotationLogic.getVaraible((String)columns.elementAt(1)));
        for(int i=2;i<columns.size();i++){
            out.print("TextBox.Text,");
            out.print(CamelNotationLogic.getVaraible((String)columns.elementAt(i)));
        }
        out.println("TextBox.Text ) ");
        out.println("If rows >= 1 Then");
        out.println(" MsgBox(\" record saved......\")");
        out.println("get"+tableName+"()");    
        out.println("clearAll()");
        out.println(" End If");
        out.println("End Sub");
        
        
   out.println(" Private Sub DeleteButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DeleteButton.Click");
   out.println("Dim rec As "+tableName+"Bean = "+tableName+"ListBox.SelectedItem");
   out.println(" Dim rows As Integer = DataBaseManager.delete"+tableName+"(rec.get"+ CamelNotationLogic.getVaraible((String)columns.elementAt(0))+"())");
   out.println("If rows >= 1 Then");
   out.println(" MsgBox(\" Record Removed......\")");
   out.println("get"+tableName+"()");    
   out.println("clearAll()");
   out.println(" End If");
   out.println("End Sub");
   
   
      out.println(" Private Sub UpdateButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles UpdateButton.Click");
      out.println("Dim rec As "+tableName+"Bean = "+tableName+"ListBox.SelectedItem");
      out.print("Dim rows As Integer = DataBaseManager.update"+tableName+"(");
      out.print("rec.get"+CamelNotationLogic.getVaraible((String)columns.elementAt(0))+"(),");
      out.print(""+CamelNotationLogic.getVaraible((String)columns.elementAt(1)));
       for(int i=2;i<columns.size();i++){
           out.print("TextBox.Text,");
            out.print(CamelNotationLogic.getVaraible((String)columns.elementAt(i)));
            
        }  
       out.println("TextBox.Text) ");
        out.println("If rows >= 1 Then");
        out.println(" MsgBox(\" Record Upadate......\")");
        out.println("get"+tableName+"()");    
        out.println("clearAll()");
        out.println(" End If");
        out.println("End Sub");
        
        
        out.println("Private Sub ClearButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ClearButton.Click");
        out.println(" ClearAll()");
        out.println("End Sub");
       
        
        
        out.println("Private Sub clearAll()");
        for(int i=0;i<columns.size();i++){
            
            out.println(""+CamelNotationLogic.getVaraible((String)columns.elementAt(i))+"TextBox.Text=\"\"");
        }
       
        out.println("End Sub");
        
        out.println("Public Sub get"+tableName+"()");
        out.println("Dim v As ArrayList = DataBaseManager.getAll"+tableName+"()");
        out.println(tableName+"ListBox.Items.Clear()");
        out.println("Dim size As Integer = v.Count");
        out.println("Dim index As Integer");
        out.println("For index = 0 To size - 1");
        out.println(tableName+"ListBox.Items.Add(v.Item(index))");
        out.println(" Next");
        out.println("End Sub");
        
        
        
        out.println("Private Sub "+tableName+"ListBox_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles EquimentListBox.SelectedIndexChanged");
        out.println("Dim rec As "+tableName+"Bean = "+tableName+"ListBox.SelectedItem");
        out.println("If IsNothing(rec) Then Exit Sub");
        for(int i=0;i<columns.size();i++){
            
            out.println(""+CamelNotationLogic.getVaraible((String)columns.elementAt(i))+"TextBox.Text=rec.get"+CamelNotationLogic.getVaraible((String)columns.elementAt(i))+"()");
        }
        out.println("End Sub");
        out.println("\n");
        out.println("\n");
        out.println("\n");
        out.println("\n");
        
    }


    
    
    private JButton aboutButton;
    private ButtonGroup buttonGroup1;
    private JTextField classDriverTextField;
    private JComboBox dbSoftwareComboBox;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JButton loadButton;
    private JTextField passwordTextField;
    private JProgressBar progressBar;
    private JTextArea staticalReportTextArea;
    private JTextField urlTextField;
    private JTextField userTextField;
    private JFileChooser fileChooser;
    private AboutBox aboutBox;
    private JCheckBox vbCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox queryBuilderCheckBox;
    private JPanel optionPanel;
    private JCheckBox javaCheckBox;
    private JPanel javaPanel;
    private JPanel csVbPanel;
    
}
