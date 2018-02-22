package form;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import utility.MonthlyChart;
import javax.swing.JOptionPane;
import setting.MenuSetting;

public class MainFrame extends javax.swing.JFrame {

   AccountsFrame account  = new AccountsFrame();
   ProductFrame product = new ProductFrame();
   DayFrame day = new DayFrame();
   YearFrame year = new YearFrame();
   SaleBookFrame sales = new SaleBookFrame();
   PurchaseBookFrame purchase = new PurchaseBookFrame();
   CashBookFrame cashBook = new CashBookFrame();
   TransactionSummaryFrame accountSummary = new TransactionSummaryFrame(); 
   MonthlyChart monthlyChart = new MonthlyChart();
   CategoryFrame categoryFrame = new CategoryFrame();
   UnitFrame unitFrame = new UnitFrame();
   ChequeFrame chequeFrame = new ChequeFrame();
   ExportDatabaseFrame export = new ExportDatabaseFrame();
   UserFrame userFrame = new UserFrame();
   SettingFrame setting;
   JFrame parent;
   
   public MainFrame(JFrame p) {
        initComponents();
        setting = new SettingFrame(this);
        parent = p;
        try{
            setAllMenuItemVisible();
        }catch(FileNotFoundException ex){
            try{
                MenuSetting.createSettingFile();
                setAllMenuItemVisible();
            }catch(Exception ex1){
                JOptionPane.showMessageDialog(this, "Cannot Create File, Please Change the drive of Project..\n"+ex1);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
            ex.printStackTrace(System.err);
        }
    }

   
   final public void setAllMenuItemVisible()throws Exception{
       accountsMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.ACCOUNT));
       categoryMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.CATEGORY));
       yearMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.YEAR));
       dayMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.DAY));
       productsMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.PRODUCTS));
       unitMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.MEASUREMENTUNIT));
       salesBookMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.SALESBOOK)); 
       purchaseBookMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.PURCHASEBOOK)); 
       cashBookMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.CASHBOOK)); 
       chequeBookMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.CHEQUEBOOK)); 
       transactionSummaryMenuItem.setVisible(MenuSetting.getFrameVisiblity(MenuSetting.TRANSACTIONSUMMARY)); 
   }
   
   public void setAccountVisible(boolean b){
        accountsMenuItem.setVisible(b);
   }
   public void setCategoryVisible(boolean b){
       categoryMenuItem.setVisible(b);
   }
   public void setYearVisible(boolean b){
       yearMenuItem.setVisible(b);
   }
   public void setDayVisible(boolean b){
       dayMenuItem.setVisible(b);
   }
   public void setProductVisible(boolean b){
       productsMenuItem.setVisible(b);
   }
   public void setMeasurementUnitVisible(boolean b){
       unitMenuItem.setVisible(b);
   }
   public void setSalesBookUnitVisible(boolean b){
       salesBookMenuItem.setVisible(b);  
   }
   public void setPurchaseBookUnitVisible(boolean b){
       purchaseBookMenuItem.setVisible(b); 
   }
   public void setCashBookUnitVisible(boolean b){
       cashBookMenuItem.setVisible(b); 
   }
   public void setChequeBookUnitVisible(boolean b){
       chequeBookMenuItem.setVisible(b); 
   }
   public void setTransactionUnitVisible(boolean b){
       transactionSummaryMenuItem.setVisible(b); 
   }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Database = new javax.swing.JButton();
        toolBar = new javax.swing.JToolBar();
        accountsButton = new javax.swing.JButton();
        transactionSummaryButton = new javax.swing.JButton();
        dayButton = new javax.swing.JButton();
        salesBookButton = new javax.swing.JButton();
        productsButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        accountsMenu = new javax.swing.JMenu();
        accountsMenuItem = new javax.swing.JMenuItem();
        categoryMenuItem = new javax.swing.JMenuItem();
        yearMenuItem = new javax.swing.JMenuItem();
        dayMenuItem = new javax.swing.JMenuItem();
        productsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        unitMenuItem = new javax.swing.JMenuItem();
        userMenuItem = new javax.swing.JMenuItem();
        transactionMenu = new javax.swing.JMenu();
        salesBookMenuItem = new javax.swing.JMenuItem();
        purchaseBookMenuItem = new javax.swing.JMenuItem();
        cashBookMenuItem = new javax.swing.JMenuItem();
        chequeBookMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        transactionSummaryMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BUSSINESS MANAGEMENT");
        setMinimumSize(new java.awt.Dimension(870, 650));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(null);

        Database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Misc-Database-3-icon.png"))); // NOI18N
        Database.setText("Database");
        Database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseActionPerformed(evt);
            }
        });
        getContentPane().add(Database);
        Database.setBounds(20, 140, 130, 60);

        toolBar.setBackground(new java.awt.Color(153, 153, 255));
        toolBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        toolBar.setFloatable(false);
        toolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        toolBar.setRollover(true);
        toolBar.setToolTipText("Tool bar");
        toolBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        toolBar.setOpaque(false);

        accountsButton.setBackground(new java.awt.Color(255, 255, 255));
        accountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account.png"))); // NOI18N
        accountsButton.setToolTipText("Account");
        accountsButton.setFocusable(false);
        accountsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accountsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        accountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsButtonActionPerformed(evt);
            }
        });
        toolBar.add(accountsButton);

        transactionSummaryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account summary.png"))); // NOI18N
        transactionSummaryButton.setToolTipText("Accout Summary");
        transactionSummaryButton.setFocusable(false);
        transactionSummaryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        transactionSummaryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transactionSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionSummaryButtonActionPerformed(evt);
            }
        });
        toolBar.add(transactionSummaryButton);

        dayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/date.png"))); // NOI18N
        dayButton.setToolTipText("Daily Sheet");
        dayButton.setFocusable(false);
        dayButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dayButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButtonActionPerformed(evt);
            }
        });
        toolBar.add(dayButton);

        salesBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/transaction (2).png"))); // NOI18N
        salesBookButton.setToolTipText("Tarnasaction");
        salesBookButton.setFocusable(false);
        salesBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salesBookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salesBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBookButtonActionPerformed(evt);
            }
        });
        toolBar.add(salesBookButton);

        productsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/product.png"))); // NOI18N
        productsButton.setToolTipText("Product");
        productsButton.setFocusable(false);
        productsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        productsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsButtonActionPerformed(evt);
            }
        });
        toolBar.add(productsButton);

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Settings-icon.png"))); // NOI18N
        settingButton.setFocusable(false);
        settingButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settingButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });
        toolBar.add(settingButton);

        getContentPane().add(toolBar);
        toolBar.setBounds(810, 0, 80, 590);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logout-icon.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton);
        logoutButton.setBounds(20, 220, 130, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/K K S.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 910, 650);

        accountsMenu.setText("Setup");

        accountsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        accountsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account2.png"))); // NOI18N
        accountsMenuItem.setText("Accounts");
        accountsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(accountsMenuItem);

        categoryMenuItem.setText("Category");
        categoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(categoryMenuItem);

        yearMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        yearMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/calender2.png"))); // NOI18N
        yearMenuItem.setText("Year");
        yearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(yearMenuItem);

        dayMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        dayMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/date2.png"))); // NOI18N
        dayMenuItem.setText("Day");
        dayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(dayMenuItem);

        productsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        productsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/product_icon_large.png"))); // NOI18N
        productsMenuItem.setText("Products");
        productsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(productsMenuItem);
        accountsMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/glossy-3d-blue-delete-icon.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(exitMenuItem);

        unitMenuItem.setText("M. Unit");
        unitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(unitMenuItem);

        userMenuItem.setText("Users");
        userMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(userMenuItem);

        jMenuBar.add(accountsMenu);

        transactionMenu.setText("Transations");

        salesBookMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/transaction2.png"))); // NOI18N
        salesBookMenuItem.setText("Sales Book");
        salesBookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBookMenuItemActionPerformed(evt);
            }
        });
        transactionMenu.add(salesBookMenuItem);

        purchaseBookMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Book-icon (1).png"))); // NOI18N
        purchaseBookMenuItem.setText("Purchase Book");
        purchaseBookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBookMenuItemActionPerformed(evt);
            }
        });
        transactionMenu.add(purchaseBookMenuItem);

        cashBookMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/dollar-icon.png"))); // NOI18N
        cashBookMenuItem.setText("Cash Book");
        cashBookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashBookMenuItemActionPerformed(evt);
            }
        });
        transactionMenu.add(cashBookMenuItem);

        chequeBookMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Bank-Check-icon.png"))); // NOI18N
        chequeBookMenuItem.setText("Cheque Book");
        chequeBookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeBookMenuItemActionPerformed(evt);
            }
        });
        transactionMenu.add(chequeBookMenuItem);

        jMenuBar.add(transactionMenu);

        jMenu1.setText("Summary");

        transactionSummaryMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        transactionSummaryMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account summary 2.png"))); // NOI18N
        transactionSummaryMenuItem.setText("Transaction Summary");
        transactionSummaryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionSummaryMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(transactionSummaryMenuItem);

        jMenuBar.add(jMenu1);

        helpMenu.setText("Help");

        helpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Help-icon.png"))); // NOI18N
        helpMenuItem.setText("help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Help-icon.png"))); // NOI18N
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        jMenuBar.add(helpMenu);

        setJMenuBar(jMenuBar);

        setSize(new java.awt.Dimension(901, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accountsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsMenuItemActionPerformed
        account.setVisible(true);

    }//GEN-LAST:event_accountsMenuItemActionPerformed

    private void transactionSummaryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionSummaryMenuItemActionPerformed
        accountSummary.setVisible(true);
    }//GEN-LAST:event_transactionSummaryMenuItemActionPerformed

    private void yearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearMenuItemActionPerformed
        year.setVisible(true);

    }//GEN-LAST:event_yearMenuItemActionPerformed

    private void dayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayMenuItemActionPerformed
        day.setVisible(true);

    }//GEN-LAST:event_dayMenuItemActionPerformed

    private void productsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsMenuItemActionPerformed
        product.setVisible(true);

    }//GEN-LAST:event_productsMenuItemActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        int x = evt.getX();
        if(x<750){
            toolBar.setVisible(false);
        }
        else{
            toolBar.setVisible(true);
        }
    }//GEN-LAST:event_formMouseMoved

    private void accountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsButtonActionPerformed
        accountsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_accountsButtonActionPerformed

    private void transactionSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionSummaryButtonActionPerformed
        transactionSummaryMenuItemActionPerformed(evt);
    }//GEN-LAST:event_transactionSummaryButtonActionPerformed

    private void dayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButtonActionPerformed
        dayMenuItemActionPerformed(evt);
    }//GEN-LAST:event_dayButtonActionPerformed

    private void salesBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBookButtonActionPerformed
       salesBookMenuItemActionPerformed(evt);
    }//GEN-LAST:event_salesBookButtonActionPerformed

    private void salesBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBookMenuItemActionPerformed
        sales.setVisible(true);
    }//GEN-LAST:event_salesBookMenuItemActionPerformed

    private void productsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsButtonActionPerformed
        productsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_productsButtonActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"Help.txt");
        }catch(Exception ex){ex.printStackTrace();}
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "This software is developed by : JK TEAM"
                + "\njay_tharwani1992@yahoo.com (+92-333-2836704)");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void purchaseBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBookMenuItemActionPerformed
        purchase.setVisible(true);
    }//GEN-LAST:event_purchaseBookMenuItemActionPerformed

    private void cashBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashBookMenuItemActionPerformed
        cashBook.setVisible(true);
    }//GEN-LAST:event_cashBookMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int i=JOptionPane.showConfirmDialog(this, "Do you want to exit?");
        if(i==0){System.exit(1);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       if(this.toolBar.isVisible()){
           this.toolBar.setVisible(false);
       }else{
           this.toolBar.setVisible(true);
       }
    }//GEN-LAST:event_formMouseClicked

    private void categoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryMenuItemActionPerformed
        categoryFrame.setVisible(true);
    }//GEN-LAST:event_categoryMenuItemActionPerformed

    private void unitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitMenuItemActionPerformed
        unitFrame.setVisible(true);
    }//GEN-LAST:event_unitMenuItemActionPerformed

    private void chequeBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeBookMenuItemActionPerformed
        chequeFrame.setVisible(true);
    }//GEN-LAST:event_chequeBookMenuItemActionPerformed

    private void DatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabaseActionPerformed
        export.setVisible(true);
    }//GEN-LAST:event_DatabaseActionPerformed

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        setting.setVisible(true);
    }//GEN-LAST:event_settingButtonActionPerformed

    private void userMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuItemActionPerformed
        userFrame.setVisible(true);
    }//GEN-LAST:event_userMenuItemActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        parent.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_logoutButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Database;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton accountsButton;
    private javax.swing.JMenu accountsMenu;
    private javax.swing.JMenuItem accountsMenuItem;
    private javax.swing.JMenuItem cashBookMenuItem;
    private javax.swing.JMenuItem categoryMenuItem;
    private javax.swing.JMenuItem chequeBookMenuItem;
    private javax.swing.JButton dayButton;
    private javax.swing.JMenuItem dayMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton productsButton;
    private javax.swing.JMenuItem productsMenuItem;
    private javax.swing.JMenuItem purchaseBookMenuItem;
    private javax.swing.JButton salesBookButton;
    private javax.swing.JMenuItem salesBookMenuItem;
    private javax.swing.JButton settingButton;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JMenu transactionMenu;
    private javax.swing.JButton transactionSummaryButton;
    private javax.swing.JMenuItem transactionSummaryMenuItem;
    private javax.swing.JMenuItem unitMenuItem;
    private javax.swing.JMenuItem userMenuItem;
    private javax.swing.JMenuItem yearMenuItem;
    // End of variables declaration//GEN-END:variables
}
