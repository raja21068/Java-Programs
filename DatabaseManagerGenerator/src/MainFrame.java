
import java.awt.Desktop;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jay Kumar
 */
public class MainFrame extends javax.swing.JFrame {

    JFileChooser choose;
    JFileChooser folderChoose;
    Desktop desktop = Desktop.getDesktop();
            
    
    public MainFrame() {
        initComponents();
        choose = new JFileChooser("/");
        choose.removeChoosableFileFilter(choose.getAcceptAllFileFilter());
        choose.addChoosableFileFilter(new FileNameExtensionFilter("(*.mdb)", "mdb"));
       
        folderChoose = new JFileChooser("/");
        folderChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dbTypeComboBoxBG = new javax.swing.JComboBox();
        browseTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        generateDbmButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        driverTextFieldBG = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        urlTextFieldBG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        usernameTextFieldBG = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        passwordTextFieldBG = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        javaRadioButton = new javax.swing.JRadioButton();
        vbRadioButton = new javax.swing.JRadioButton();
        csRadioButton = new javax.swing.JRadioButton();
        phpRadioButton = new javax.swing.JRadioButton();
        queryRadioButton = new javax.swing.JRadioButton();
        xmlRadioButton = new javax.swing.JRadioButton();
        csvRadioButton = new javax.swing.JRadioButton();
        vbGuiRadioButton = new javax.swing.JRadioButton();
        generateOtherFormatButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        urlTextField = new javax.swing.JTextField();
        driverTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        hybernetFileCheckBox = new javax.swing.JCheckBox();
        tableCheckBox = new javax.swing.JCheckBox();
        tableJavaCheckBox = new javax.swing.JCheckBox();
        methodsCheckBox = new javax.swing.JCheckBox();
        updateCheckBox = new javax.swing.JCheckBox();
        deleteCheckBox = new javax.swing.JCheckBox();
        insertCheckBox = new javax.swing.JCheckBox();
        selectCheckBox = new javax.swing.JCheckBox();
        hyberGenerateButton = new javax.swing.JButton();
        databaseTypeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Database Tools Generator");

        dbTypeComboBoxBG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".mdb", "Microsoft Access", "mysql", "sql server", "Oracle" }));
        dbTypeComboBoxBG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dbTypeComboBoxBGItemStateChanged(evt);
            }
        });

        browseTextField.setEditable(false);

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        generateButton.setText("Generate Beans");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        progressBar.setStringPainted(true);

        generateDbmButton.setText("Generate DB Manager");
        generateDbmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateDbmButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Driver");

        driverTextFieldBG.setText("sun.jdbc.odbc.JdbcOdbcDriver");

        jLabel8.setText("URL");

        urlTextFieldBG.setText("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=");

        jLabel9.setText("Username");

        usernameTextFieldBG.setText("root");

        jLabel10.setText("Password");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Language"));

        buttonGroup1.add(javaRadioButton);
        javaRadioButton.setSelected(true);
        javaRadioButton.setText("Java");
        javaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(vbRadioButton);
        vbRadioButton.setText("Visual basic");
        vbRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(csRadioButton);
        csRadioButton.setText("C#");
        csRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(phpRadioButton);
        phpRadioButton.setText("php");
        phpRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phpRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(queryRadioButton);
        queryRadioButton.setText("Queries");
        queryRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(xmlRadioButton);
        xmlRadioButton.setText("XML");
        xmlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xmlRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(csvRadioButton);
        csvRadioButton.setText("CSV");
        csvRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(vbGuiRadioButton);
        vbGuiRadioButton.setText("Vb GUI");
        vbGuiRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbGuiRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(queryRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xmlRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(csvRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(vbGuiRadioButton))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(javaRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vbRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phpRadioButton)
                        .addGap(10, 10, 10)
                        .addComponent(csRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(javaRadioButton)
                    .addComponent(vbRadioButton)
                    .addComponent(phpRadioButton)
                    .addComponent(csRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryRadioButton)
                    .addComponent(xmlRadioButton)
                    .addComponent(csvRadioButton)
                    .addComponent(vbGuiRadioButton)))
        );

        generateOtherFormatButton.setText("Generate");
        generateOtherFormatButton.setEnabled(false);
        generateOtherFormatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateOtherFormatButtonActionPerformed(evt);
            }
        });

        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(generateOtherFormatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(browseTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(dbTypeComboBoxBG, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(generateDbmButton, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(browseButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(19, 19, 19))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordTextFieldBG)
                                    .addComponent(urlTextFieldBG)
                                    .addComponent(usernameTextFieldBG)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(driverTextFieldBG, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dbTypeComboBoxBG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(browseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(browseButton)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(driverTextFieldBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(urlTextFieldBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usernameTextFieldBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordTextFieldBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(generateDbmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(generateOtherFormatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bean & DatabaseManager Generator", jPanel1);

        jLabel2.setText("Hybernet Conf Files Builder");

        usernameTextField.setText("root");

        urlTextField.setText("jdbc:mysql://localhost:3306/db");

        driverTextField.setText("com.mysql.jdbc.Driver");

        jLabel3.setText("Driver");

        jLabel4.setText("URL");

        jLabel5.setText("Password");

        jLabel6.setText("Username");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Generate"));

        hybernetFileCheckBox.setText("hibernate.cfg.xml");

        tableCheckBox.setText("tables.xml");

        tableJavaCheckBox.setText("tables.java");

        methodsCheckBox.setSelected(true);
        methodsCheckBox.setText("Methods");
        methodsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                methodsCheckBoxActionPerformed(evt);
            }
        });

        updateCheckBox.setSelected(true);
        updateCheckBox.setText("Update");

        deleteCheckBox.setSelected(true);
        deleteCheckBox.setText("Delete");

        insertCheckBox.setSelected(true);
        insertCheckBox.setText("Insert");

        selectCheckBox.setSelected(true);
        selectCheckBox.setText("Select");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hybernetFileCheckBox)
                    .addComponent(tableJavaCheckBox)
                    .addComponent(tableCheckBox))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(methodsCheckBox)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(deleteCheckBox)
                                .addGap(5, 5, 5)
                                .addComponent(selectCheckBox))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(updateCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertCheckBox)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hybernetFileCheckBox)
                    .addComponent(methodsCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableCheckBox)
                    .addComponent(updateCheckBox)
                    .addComponent(insertCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tableJavaCheckBox)
                    .addComponent(deleteCheckBox)
                    .addComponent(selectCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hyberGenerateButton.setText("Generate");
        hyberGenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hyberGenerateButtonActionPerformed(evt);
            }
        });

        databaseTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mysql", ".mdb", "MS Access" }));
        databaseTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                databaseTypeComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(hyberGenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(databaseTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(driverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(usernameTextField)))))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(urlTextField)
                                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(databaseTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(driverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(hyberGenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hybernet Conf Builder", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        choose.showOpenDialog(this);
        browseTextField.setText( choose.getSelectedFile().getAbsolutePath());
        urlTextFieldBG.setText("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+browseTextField.getText());
    }//GEN-LAST:event_browseButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
       new Thread(){

            @Override
            public void run() {
                String dbtype = (String)dbTypeComboBoxBG.getSelectedItem();
                if(dbtype.equals(".mdb") && browseTextField.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Please slelect a database");
                    return;
                }
                String driver = driverTextFieldBG.getText();
                String url = urlTextFieldBG.getText();
                String username = usernameTextFieldBG.getText();
                String pass =  passwordTextFieldBG.getText();
                folderChoose.showSaveDialog(browseButton);
                File des = folderChoose.getSelectedFile();
                if(!des.exists()){
                    des.mkdir();
                }
                 
                try{
                    System.out.println(des.getAbsolutePath());
                    if(javaRadioButton.isSelected()){
                        JavaMethodGenerator.createBean(driver,url,username,pass,des.getAbsolutePath(),statusLabel);
                    }else if(vbRadioButton.isSelected()){
                        VisualBasicMethodGenerator.createVbBean(driver, url, username, pass, des.getAbsolutePath(),statusLabel);
                    }else if(csRadioButton.isSelected()){
                        CSharpMthodGenerator.createCsBean(driver, url, username, pass, des.getAbsolutePath(), statusLabel);
                    }
                    statusLabel.setText("Done....");
                    JOptionPane.showMessageDialog(rootPane, "Beans Generated...");
                    desktop.open(des);
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
            }
       
       }.start();
       
        
        
       
    }//GEN-LAST:event_generateButtonActionPerformed

    private void generateDbmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateDbmButtonActionPerformed
        new Thread(){

            @Override
            public void run() {
                
                String dbtype = (String)dbTypeComboBoxBG.getSelectedItem();
                if(dbtype.equals(".mdb") && browseTextField.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Please slelect a database");
                    return;
                }
                String dbPath = urlTextFieldBG.getText().trim();
                String driver = driverTextFieldBG.getText();
                String url = urlTextFieldBG.getText();
                String username = usernameTextFieldBG.getText();
                String pass =  passwordTextFieldBG.getText();
                
                folderChoose.showSaveDialog(browseButton);
                File des = folderChoose.getSelectedFile();
                if(!des.exists()){
                    des.mkdir();
                }
                try{
                    if(javaRadioButton.isSelected()){
                        JavaMethodGenerator.generateDBM(des.getAbsolutePath(),driver, url,username,pass, statusLabel);
                    }else if(vbRadioButton.isSelected()){
                        VisualBasicMethodGenerator.generateDBM(des.getAbsolutePath(),driver, url,username,pass, statusLabel);
                    }else if(csRadioButton.isSelected()){
                        CSharpMthodGenerator.generateDBM(des.getAbsolutePath(),driver, url,username,pass, statusLabel);
                    }else if(phpRadioButton.isSelected()){
                        
                    } 
                    JOptionPane.showMessageDialog(null, "DatabaseManager generated..");
                    desktop.open(des);
                }catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex);
                }
        }
        
        }.start();
    }//GEN-LAST:event_generateDbmButtonActionPerformed

    private void hyberGenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hyberGenerateButtonActionPerformed
        folderChoose.showSaveDialog(this);
        File desFolder = folderChoose.getSelectedFile();
        if(!desFolder.exists())desFolder.mkdir();
        
        String driver = driverTextField.getText();
        String url = urlTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String dialact="";
        if(databaseTypeComboBox.getSelectedItem().toString().equals("mysql")){
            dialact = "org.hibernate.dialect.MySQLDialect";
        }
        else if(databaseTypeComboBox.getSelectedItem().toString().equals(".mdb")){
            dialact = "org.hibernate.dialect.SybaseAnywhereDialect";
        }
        else if(databaseTypeComboBox.getSelectedItem().toString().equals("MS Access")){
            dialact = "org.hibernate.dialect.SybaseAnywhereDialect";
        }
            
        try {
            String files = "";
            if(hybernetFileCheckBox.isSelected()){
                HybernetMethods.generateHibernetCnfXml(driver, url, username, password, desFolder.getAbsolutePath(),dialact);
                files +="hibernet.hbm.xml\n";
            }
            if(tableCheckBox.isSelected()){
               files+= HybernetMethods.generateTableXml(driver, url, username, password, desFolder.getAbsolutePath());
            }
            if(tableJavaCheckBox.isSelected()){
               files+= HybernetMethods.generateTableDotJava(driver, url, username, password, desFolder.getAbsolutePath());
            }
            if(methodsCheckBox.isSelected()){
                HybernetMethods.generateDBM(driver, url, username, password, desFolder.getAbsolutePath(), deleteCheckBox.isSelected(), updateCheckBox.isSelected(),insertCheckBox.isSelected(),selectCheckBox.isSelected());
            }
            JOptionPane.showMessageDialog(this, "Generated \n"+files);
            desktop.open(desFolder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_hyberGenerateButtonActionPerformed

    private void methodsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_methodsCheckBoxActionPerformed
        if(methodsCheckBox.isSelected()){
            deleteCheckBox.setEnabled(true);
            updateCheckBox.setEnabled(true);
            insertCheckBox.setEnabled(true);
            selectCheckBox.setEnabled(true);
        }else{
            deleteCheckBox.setEnabled(false);
            updateCheckBox.setEnabled(false);
            insertCheckBox.setEnabled(false);
            selectCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_methodsCheckBoxActionPerformed

    private void dbTypeComboBoxBGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dbTypeComboBoxBGItemStateChanged
        String str =  (String)dbTypeComboBoxBG.getSelectedItem();
        if(str == null)return;
        if(str.equals(".mdb")){
            driverTextFieldBG.setText("sun.jdbc.odbc.JdbcOdbcDriver");
            urlTextFieldBG.setText("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=");
            usernameTextFieldBG.setText("");
            passwordTextFieldBG.setText("");
            browseButton.setEnabled(true);
        }else if(str.equals("mysql")){
            driverTextFieldBG.setText("com.mysql.jdbc.Driver");
            urlTextFieldBG.setText("jdbc:mysql://localhost:3306/");
            usernameTextFieldBG.setText("root");
            passwordTextFieldBG.setText("");
            browseButton.setEnabled(false);
        
        }else if(str.equals("Microsoft Access")){
            driverTextFieldBG.setText("sun.jdbc.odbc.JdbcOdbcDriver");
            urlTextFieldBG.setText("jdbc:odbc:db");
            usernameTextFieldBG.setText("");
            passwordTextFieldBG.setText("");
            browseButton.setEnabled(false);
        }else if(str.equals("sql server")){
            driverTextFieldBG.setText("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            urlTextFieldBG.setText("jdbc:odbc:db");
            usernameTextFieldBG.setText("");
            passwordTextFieldBG.setText("");
            browseButton.setEnabled(false);
        }else if(str.equals("Oracle")){
            driverTextFieldBG.setText("oracle.jdbc.driver.OracleDriver");
            urlTextFieldBG.setText("jdbc:odbc:db");
            usernameTextFieldBG.setText("hr");
            passwordTextFieldBG.setText("hr");
            browseButton.setEnabled(false);
        }
    }//GEN-LAST:event_dbTypeComboBoxBGItemStateChanged

    private void queryRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryRadioButtonActionPerformed
            generateDbmButton.setEnabled(false);
            generateButton.setEnabled(false);
            generateOtherFormatButton.setEnabled(true);
        
    }//GEN-LAST:event_queryRadioButtonActionPerformed

    private void xmlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xmlRadioButtonActionPerformed
            generateDbmButton.setEnabled(false);
            generateButton.setEnabled(false);
            generateOtherFormatButton.setEnabled(true);
        
    }//GEN-LAST:event_xmlRadioButtonActionPerformed

    private void csvRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvRadioButtonActionPerformed
            generateDbmButton.setEnabled(false);
            generateButton.setEnabled(false);
            generateOtherFormatButton.setEnabled(true);
        
    }//GEN-LAST:event_csvRadioButtonActionPerformed

    private void javaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaRadioButtonActionPerformed
            generateDbmButton.setEnabled(true);
            generateButton.setEnabled(true);
            generateOtherFormatButton.setEnabled(false);
        
    }//GEN-LAST:event_javaRadioButtonActionPerformed

    private void vbRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbRadioButtonActionPerformed
            generateDbmButton.setEnabled(true);
            generateButton.setEnabled(true);
            generateOtherFormatButton.setEnabled(false);
        
    }//GEN-LAST:event_vbRadioButtonActionPerformed

    private void phpRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phpRadioButtonActionPerformed
            generateDbmButton.setEnabled(true);
            generateButton.setEnabled(true);
            generateOtherFormatButton.setEnabled(false);
        
    }//GEN-LAST:event_phpRadioButtonActionPerformed

    private void csRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csRadioButtonActionPerformed
            generateButton.setEnabled(true);
            generateDbmButton.setEnabled(true);
            generateOtherFormatButton.setEnabled(false);
        
    }//GEN-LAST:event_csRadioButtonActionPerformed

    private void generateOtherFormatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateOtherFormatButtonActionPerformed
        new Thread(){

            @Override
            public void run() {
               String dbtype = (String)dbTypeComboBoxBG.getSelectedItem();
                if(dbtype.equals(".mdb") && browseTextField.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Please slelect a database");
                    return;
                }
                String dbPath = browseTextField.getText().trim();
                folderChoose.showSaveDialog(browseButton);
                File des = folderChoose.getSelectedFile();
                if(!des.exists()){
                    des.mkdir();
                }
                String driver = driverTextFieldBG.getText();
                String url = urlTextFieldBG.getText();
                String username = usernameTextFieldBG.getText();
                String pass =  passwordTextFieldBG.getText();

                try{
                    if(queryRadioButton.isSelected()){
                        QueriesGenerator.generateDBM(driver, url, username, pass,des.getAbsolutePath(), dbPath,statusLabel);
                    }else if(xmlRadioButton.isSelected()){
                        XMLGenerator.DBToXml(driver, url, username, pass, des, "xml",statusLabel);
                    }else if(csvRadioButton.isSelected()){
                        CSVGenerator.DBToCsv(driver, url, username, pass, des, "csv",statusLabel);
                    }else if(vbGuiRadioButton.isSelected()){
                        VisualBasicGUIGenerator.createGUI(driver, url, username, pass, des.getAbsolutePath(),statusLabel);
                    }
                    desktop.open(des);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                    ex.printStackTrace();
                } 
            }
            
        }.start();
        
    }//GEN-LAST:event_generateOtherFormatButtonActionPerformed

    private void vbGuiRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vbGuiRadioButtonActionPerformed
        generateButton.setEnabled(false);
        generateDbmButton.setEnabled(false);
        generateOtherFormatButton.setEnabled(true);
    }//GEN-LAST:event_vbGuiRadioButtonActionPerformed

    private void databaseTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_databaseTypeComboBoxItemStateChanged
         String dbType =(String) databaseTypeComboBox.getSelectedItem();
         if(dbType==null)return;
         System.out.println(dbType);
         if(dbType.equals("mysql")){
             driverTextField.setText("com.mysql.jdbc.Driver");
             urlTextField.setText("jdbc:mysql://localhost:3306/db");
             usernameTextField.setText("root");
             passwordTextField.setText("");
         }else if(dbType.equals(".mdb")){
             choose.showOpenDialog(this);
             driverTextField.setText("sun.jdbc.odbc.JdbcOdbcDriver");
             urlTextField.setText("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+choose.getSelectedFile().getAbsolutePath());
             usernameTextField.setText("");
             passwordTextField.setText("");
         }else if(dbType.equals("MS Access")){
             driverTextField.setText("sun.jdbc.odbc.JdbcOdbcDriver");
             urlTextField.setText("jdbc:odbc:db");
             usernameTextField.setText("");
             passwordTextField.setText("");
         }
    }//GEN-LAST:event_databaseTypeComboBoxItemStateChanged

    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField browseTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton csRadioButton;
    private javax.swing.JRadioButton csvRadioButton;
    private javax.swing.JComboBox databaseTypeComboBox;
    private javax.swing.JComboBox dbTypeComboBoxBG;
    private javax.swing.JCheckBox deleteCheckBox;
    private javax.swing.JTextField driverTextField;
    private javax.swing.JTextField driverTextFieldBG;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton generateDbmButton;
    private javax.swing.JButton generateOtherFormatButton;
    private javax.swing.JButton hyberGenerateButton;
    private javax.swing.JCheckBox hybernetFileCheckBox;
    private javax.swing.JCheckBox insertCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton javaRadioButton;
    private javax.swing.JCheckBox methodsCheckBox;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField passwordTextFieldBG;
    private javax.swing.JRadioButton phpRadioButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JRadioButton queryRadioButton;
    private javax.swing.JCheckBox selectCheckBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JCheckBox tableCheckBox;
    private javax.swing.JCheckBox tableJavaCheckBox;
    private javax.swing.JCheckBox updateCheckBox;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField urlTextFieldBG;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTextField usernameTextFieldBG;
    private javax.swing.JRadioButton vbGuiRadioButton;
    private javax.swing.JRadioButton vbRadioButton;
    private javax.swing.JRadioButton xmlRadioButton;
    // End of variables declaration//GEN-END:variables

    

//    private void generateJavaDBM(String desPath, String dbPath)throws Exception{
//        Connection connection= DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbPath);
//        DatabaseMetaData metaData = connection.getMetaData();
//        ResultSet rs = metaData.getTables(null, null, null,new String[]{"TABLE"});
//        
//        PrintStream fos = new PrintStream( new FileOutputStream(desPath+File.separator+"DatabaseManager.java"));
//        fos.println("// ** author @Jay K  ** \n");
//        fos.println("import java.util.*; ");
//        fos.println("import java.sql.Connection;\n" +
//                    "import java.sql.DatabaseMetaData;\n" +
//                    "import java.sql.ResultSet;\n" +"import java.sql.ResultSetMetaData;\n" +
//                    "import java.sql.Statement;\n");
//        fos.println("class DatabaseManager{");
//        fos.println("    static java.sql.Connection connection;");
//        fos.println("    static{");
//        fos.println("        try{");
//        fos.println("             Class.forName(\"sun.jdbc.odbc.JdbcOdbcDriver\");\n" +
//"            connection = java.sql.DriverManager.getConnection(\"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=database/database.mdb\");");        
//        fos.println("        } catch(Exception e){ e.printStackTrace(); }\n" +
//                    "    }");
//        while(rs.next()){
//            String tableName = rs.getString(3);
//            
//            // Checking if the table is repeated
//            // Some times is happens that a table is repeated
//            if(tableNames.contains(tableName)){
//               continue; 
//            }else{
//                tableNames.add(tableName);
//            }
//            
//            Statement st = connection.createStatement();
//            ResultSet tableRS = st.executeQuery("SELECT * from "+tableName);
//            ResultSetMetaData rsMetaData = tableRS.getMetaData();
//            String className = CamelNotationHandler.getTableType(tableName);
//            ResultSet primaryKeys = metaData.getIndexInfo(null, null, tableName, false, false);
//            String primaryKey = "";
//            
//            if(primaryKeys!=null){
//                while(primaryKeys.next()){
//                    String type = primaryKeys.getString("INDEX_NAME");
//                    if(type!=null && (type.equals("PrimaryKey")||type.equals("PRIMARY"))){
//                        primaryKey = primaryKeys.getString("COLUMN_NAME");
//                        break;
//                    }
//                }
//            }
//            
//            JavaMethodGenerator.createJavaSelectMethod(fos, rsMetaData, tableName, className);
//            JavaMethodGenerator.createJaveInsertMethod(fos, rsMetaData, tableName, className, primaryKey);
//            JavaMethodGenerator.createJavaDeleteMethod(fos, rsMetaData, tableName, className, primaryKey);
//            JavaMethodGenerator.createJavaUpdateMethod(fos, rsMetaData, tableName, className, primaryKey);
//        }
//        fos.println("}//end of class");
//        fos.close();
//        rs.close();
//        connection.close();
//    }

}
