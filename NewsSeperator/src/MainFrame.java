import java.awt.FileDialog;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/*
 * MainFrame.java
 *
 * Created on Sep 15, 2012, 1:47:16 PM
 */
/**
 *
 * @author Jay Kumar
 */
public class MainFrame extends javax.swing.JFrame {

	javax.swing.table.DefaultTableModel tm;
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilePanel = new javax.swing.JPanel();
        OpenBtn = new javax.swing.JButton();
        FileTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        GramLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        biGramTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ResultScroll2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        triGramTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        FileList = new javax.swing.JList();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        DistributeBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        C_FormItem = new javax.swing.JMenuItem();
        N_FormItem = new javax.swing.JMenuItem();
        ClearItem = new javax.swing.JMenuItem();
        ExitItem = new javax.swing.JMenuItem();
        c_form = new CategoryForm();
        g_form = new GramForm();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 0, 12))); // NOI18N
        progressBar.setMinimum(0);
		progressBar.setStringPainted(true);
        OpenBtn.setText("Open");
        OpenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilePanelLayout = new javax.swing.GroupLayout(FilePanel);
        FilePanel.setLayout(FilePanelLayout);
        FilePanelLayout.setHorizontalGroup(
            FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OpenBtn)
                .addGap(18, 18, 18)
                .addComponent(FileTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        FilePanelLayout.setVerticalGroup(
            FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilePanelLayout.createSequentialGroup()
                .addGroup(FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpenBtn)
                    .addComponent(FileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Document", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Console", 0, 11))); // NOI18N

        GramLabel.setText("Bi Gram Result");

        biGramTable.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "Add", "Count", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(biGramTable);

        jScrollPane1.setViewportView(jScrollPane2);

        jLabel1.setText("Tri Gram Result");

        tm=new javax.swing.table.DefaultTableModel(
                null,
                new String [] {
                    "Add", "Count", "Category"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
        	triGramTable.setModel(tm);
        jScrollPane4.setViewportView(triGramTable);

        ResultScroll2.setViewportView(jScrollPane4);

        jScrollPane3.setViewportView(FileList);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(GramLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ResultScroll2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GramLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResultScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        DistributeBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DistributeBtn.setText("Distribute");
        DistributeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DistributeBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        //C_FormItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("E:\\javaProgramms\\News Seprator\\notebookicon4.png"))); // NOI18N
        C_FormItem.setText("Category form ");
        C_FormItem.setIconTextGap(0);
        C_FormItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_FormItemActionPerformed(evt);
            }
        });
        jMenu1.add(C_FormItem);

        N_FormItem.setText("N-Gram Form");
        N_FormItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_FormItemActionPerformed(evt);
            }
        });
        jMenu1.add(N_FormItem);

        ClearItem.setText("Clear");
        ClearItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearItemActionPerformed(evt);
            }
        });
        jMenu1.add(ClearItem);

        ExitItem.setText("Exit");
        ExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });
        jMenu1.add(ExitItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DistributeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DistributeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBtnActionPerformed
       java.awt.FileDialog dialog = new FileDialog(this,"Open",FileDialog.LOAD);
       dialog.setVisible(true);
       String path = dialog.getDirectory();
       if(path!=null)FileTxt.setText(path);
       
    	// TODO add your handling code here:
    }//GEN-LAST:event_OpenBtnActionPerformed

    private void ExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitItemActionPerformed
        int yes=JOptionPane.showConfirmDialog(this,"Exit?","Do ypu want to exit?",0,0,null);
        if(yes==0){ System.exit(0);}
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitItemActionPerformed

    private void C_FormItemActionPerformed(java.awt.event.ActionEvent evt) {
    	c_form.setVisible(true);
    	c_form.listRefresh();
    }
    
    private void N_FormItemActionPerformed(java.awt.event.ActionEvent evt) {
    	g_form.setVisible(true);
    	}

    private void ClearItemActionPerformed(java.awt.event.ActionEvent evt) {}

    private void DistributeBtnActionPerformed(java.awt.event.ActionEvent evt){
    	new Thread(){
    			public void run(){
    				String s[]=setFilesInList(FileTxt.getText());
    	    		progressBar.setMaximum(s.length-1);
    	    		try {
    	    			for(int h=0 ; h<s.length ; h++){
    	    				
    	    				java.util.Vector v=DataBaseManager.CompareNGram(FileTxt.getText()+s[h]);
    	    				for(int i=0;i<v.size();i++){
    	    					CatMatchBean cb = (CatMatchBean)v.elementAt(i);
    	    					tm.addRow(new Object[]{s[h],cb.matches,cb.category});
    	    				}
    	    				progressBar.setValue(h);
    	    			}
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    	}.start();	
    	
    }
    
    public String[] setFilesInList(String filePath){
  
    	FileList.removeAll();
    	java.io.File f = new java.io.File(filePath);
    	String s[] = f.list();
    	java.util.Vector v = new java.util.Vector();
    	for(int i=0 ; i<s.length ;i++){
    		v.addElement(s[i]);
    	}
    	FileList.setListData(v);
    	return s;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem C_FormItem;
    private javax.swing.JMenuItem ClearItem;
    private javax.swing.JButton DistributeBtn;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JList FileList;
    private javax.swing.JPanel FilePanel;
    private javax.swing.JTextField FileTxt;
    private javax.swing.JLabel GramLabel;
    private javax.swing.JMenuItem N_FormItem;
    private javax.swing.JButton OpenBtn;
    private javax.swing.JScrollPane ResultScroll2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable biGramTable;
    private javax.swing.JTable triGramTable;
    private javax.swing.JTextArea jTextArea1;
    private CategoryForm c_form;
    private GramForm g_form;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}