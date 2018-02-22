
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {

   AccountsFrame account  = new AccountsFrame();
   ProductFrame product = new ProductFrame();
   DayFrame day = new DayFrame();
   YearFrame year = new YearFrame();
   SaleBookFrame sales = new SaleBookFrame();
   PurchaseBookFrame purchase = new PurchaseBookFrame();
   CashBookFrame cashBook = new CashBookFrame();
   DayClosingFrame dayClosing = new DayClosingFrame();
   AccountSummaryFrame accountSummary = new AccountSummaryFrame(); 
    public MainFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        accountsButton = new javax.swing.JButton();
        accountSummaryButton = new javax.swing.JButton();
        dayButton = new javax.swing.JButton();
        salesBookButton = new javax.swing.JButton();
        productsButton = new javax.swing.JButton();
        dayClosingButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        accountsMenu = new javax.swing.JMenu();
        accountsMenuItem = new javax.swing.JMenuItem();
        yearMenuItem = new javax.swing.JMenuItem();
        dayMenuItem = new javax.swing.JMenuItem();
        productsMenuItem = new javax.swing.JMenuItem();
        dayClosingMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        transactionMenu = new javax.swing.JMenu();
        salesBookMenuItem = new javax.swing.JMenuItem();
        purchaseBookMenuItem = new javax.swing.JMenuItem();
        cashBookMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        accountSummaryMenuItem = new javax.swing.JMenuItem();
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

        accountSummaryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account summary.png"))); // NOI18N
        accountSummaryButton.setToolTipText("Accout Summary");
        accountSummaryButton.setFocusable(false);
        accountSummaryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accountSummaryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        accountSummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountSummaryButtonActionPerformed(evt);
            }
        });
        toolBar.add(accountSummaryButton);

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

        dayClosingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/run-icon2.png"))); // NOI18N
        dayClosingButton.setToolTipText("Day Closing");
        dayClosingButton.setFocusable(false);
        dayClosingButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dayClosingButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dayClosingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayClosingButtonActionPerformed(evt);
            }
        });
        toolBar.add(dayClosingButton);

        getContentPane().add(toolBar);
        toolBar.setBounds(810, 0, 80, 590);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/B M S.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 600);

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

        dayClosingMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        dayClosingMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/run-icon.png"))); // NOI18N
        dayClosingMenuItem.setText("Day Closing");
        dayClosingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayClosingMenuItemActionPerformed(evt);
            }
        });
        accountsMenu.add(dayClosingMenuItem);
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

        jMenuBar.add(transactionMenu);

        jMenu1.setText("Summary");

        accountSummaryMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        accountSummaryMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/account summary 2.png"))); // NOI18N
        accountSummaryMenuItem.setText("Account Summary");
        accountSummaryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountSummaryMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(accountSummaryMenuItem);

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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-901)/2, (screenSize.height-649)/2, 901, 649);
    }// </editor-fold>//GEN-END:initComponents

    private void accountsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsMenuItemActionPerformed
        account.setVisible(true);

    }//GEN-LAST:event_accountsMenuItemActionPerformed

    private void accountSummaryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountSummaryMenuItemActionPerformed
        accountSummary.setVisible(true);
    }//GEN-LAST:event_accountSummaryMenuItemActionPerformed

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

    private void accountSummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountSummaryButtonActionPerformed
        accountSummaryMenuItemActionPerformed(evt);
    }//GEN-LAST:event_accountSummaryButtonActionPerformed

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
        JOptionPane.showMessageDialog(this, "This software is developed by : JAY KUMAR\njay_tharwani1992@yahoo.com (+92-315-3028704)");
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void purchaseBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBookMenuItemActionPerformed
        purchase.setVisible(true);
    }//GEN-LAST:event_purchaseBookMenuItemActionPerformed

    private void cashBookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashBookMenuItemActionPerformed
        cashBook.setVisible(true);
    }//GEN-LAST:event_cashBookMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int i=JOptionPane.showConfirmDialog(this, "Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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

    private void dayClosingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayClosingMenuItemActionPerformed
       dayClosing.setVisible(true);
    }//GEN-LAST:event_dayClosingMenuItemActionPerformed

    private void dayClosingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayClosingButtonActionPerformed
        this.dayClosing.setVisible(true);
    }//GEN-LAST:event_dayClosingButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws Exception{
       setLookAndFeel();        
       new MainFrame().setVisible(true);
        
    }
    public static void setLookAndFeel(){
       try {
           java.util.Properties props = new java.util.Properties();
           props.put("logoString","J.K");
           props.put("menuSelectionBackgroundColor", "255 128 200");
           com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(props);
           javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (Exception ex) {ex.printStackTrace(); } 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton accountSummaryButton;
    private javax.swing.JMenuItem accountSummaryMenuItem;
    private javax.swing.JButton accountsButton;
    private javax.swing.JMenu accountsMenu;
    private javax.swing.JMenuItem accountsMenuItem;
    private javax.swing.JMenuItem cashBookMenuItem;
    private javax.swing.JButton dayButton;
    private javax.swing.JButton dayClosingButton;
    private javax.swing.JMenuItem dayClosingMenuItem;
    private javax.swing.JMenuItem dayMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton productsButton;
    private javax.swing.JMenuItem productsMenuItem;
    private javax.swing.JMenuItem purchaseBookMenuItem;
    private javax.swing.JButton salesBookButton;
    private javax.swing.JMenuItem salesBookMenuItem;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JMenu transactionMenu;
    private javax.swing.JMenuItem yearMenuItem;
    // End of variables declaration//GEN-END:variables
}
