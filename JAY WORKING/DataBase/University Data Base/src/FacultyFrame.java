import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class FacultyFrame extends javax.swing.JFrame {

    /** Creates new form FacultyFrame */
    public FacultyFrame() {
        initComponents();
         refreshList();
    }
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        facNameLbl = new javax.swing.JLabel();
        facNameTxt = new javax.swing.JTextField();
        facIDTxt = new javax.swing.JTextField();
        facIdLbl = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarkTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        depMenuItem = new javax.swing.JMenuItem();
        progMenuItem = new javax.swing.JMenuItem();
        batchMenuItem = new javax.swing.JMenuItem();
        stdMenuItem = new javax.swing.JMenuItem();
        department = new DepartmentFrame(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        setMinimumSize(new java.awt.Dimension(450, 350));
        getContentPane().setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("F a c u l t y   I n f o r m a t i o n");
        getContentPane().add(mainLabel);
        mainLabel.setBounds(110, 10, 220, 30);

        listScroll.setViewportView(list);
        getContentPane().add(listScroll);
        listScroll.setBounds(260, 90, 160, 140);
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource() == null) return;
                FacultyBean fb = (FacultyBean)list.getSelectedValue();
                facIDTxt.setText(""+fb.factID);
                facNameTxt.setText(fb.factName);
                remarkTxt.setText(fb.remarks);
            }
        });
        facNameLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        facNameLbl.setText("Faculty Name:");
        getContentPane().add(facNameLbl);
        facNameLbl.setBounds(20, 100, 90, 20);
        getContentPane().add(facNameTxt);
        facNameTxt.setBounds(20, 120, 230, 22);
        getContentPane().add(facIDTxt);
        facIDTxt.setBounds(100, 70, 150, 22);

        facIdLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        facIdLbl.setText("Faculty ID :");
        getContentPane().add(facIdLbl);
        facIdLbl.setBounds(20, 70, 80, 20);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(20, 150, 50, 16);

        remarkScroll.setViewportView(remarkTxt);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(20, 170, 230, 60);

        addBtn.setText("ADD");
        getContentPane().add(addBtn);
        addBtn.setBounds(20, 240, 80, 25);
        addBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    FacultyBean bean = new FacultyBean();
                    bean.factName = facNameTxt.getText();
                    bean.remarks = remarkTxt.getText();
                    Vector v = DatabaseManager.getAllFaculty();
                    boolean check = true;
                    for(int i =0; i<v.size(); i++){
                    FacultyBean b = (FacultyBean)v.elementAt(i);
                    if(b.factName.trim().equals(bean.factName)){ 
                        JOptionPane.showMessageDialog(rootPane, "This faculty is already n record...");
                        check =false;  break; }
                    }
                    
                    if(check)DatabaseManager.addFaculty(bean);
                     
                    refreshList();
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        DelBtn.setText("DEL");
        getContentPane().add(DelBtn);
        DelBtn.setBounds(110, 240, 80, 25);
        DelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(list.getSelectedValue()==null)return;
                try{
                FacultyBean fb= (FacultyBean)list.getSelectedValue();
                DatabaseManager.deleteFaculty(fb.factID);
                refreshList();
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });
        
        updateBtn.setText("Update");
        getContentPane().add(updateBtn);
        updateBtn.setBounds(200, 240, 90, 25);
        updateBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(list.getSelectedValue()==null)return; 
                try{
                    FacultyBean fb=(FacultyBean)list.getSelectedValue();
                    DatabaseManager.updateFaculty(facNameTxt.getText(), remarkTxt.getText(),fb.factID);
                    refreshList();
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        clearBtn.setText("Clear");
        getContentPane().add(clearBtn);
        clearBtn.setBounds(300, 240, 90, 25);
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                facIDTxt.setText("");
                facNameTxt.setText("");
                remarkTxt.setText("");
            }
            });

        listLbl.setText("Faculty List");
        getContentPane().add(listLbl);
        listLbl.setBounds(300, 70, 70, 20);

        menu.setText("Option");

        depMenuItem.setText("Department");
        menu.add(depMenuItem);
         depMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                department.setVisible(true);
                setVisible(false);
            }
            });

        progMenuItem.setText("Program");
        menu.add(progMenuItem);

        batchMenuItem.setText("Batch");
        menu.add(batchMenuItem);

        stdMenuItem.setText("Student");
        menu.add(stdMenuItem);

        menuBar.add(menu);

        setJMenuBar(menuBar);
        pack();
       
    }// </editor-fold>//GEN-END:initComponents

    public void refreshList(){
        list.removeAll();
        try{
        Vector v = DatabaseManager.getAllFaculty();
        list.setListData(v);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void main(String args[]) {
         new FacultyFrame().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JMenuItem batchMenuItem;
    private javax.swing.JButton clearBtn;
    private javax.swing.JMenuItem depMenuItem;
    private javax.swing.JTextField facIDTxt;
    private javax.swing.JLabel facIdLbl;
    private javax.swing.JLabel facNameLbl;
    private javax.swing.JTextField facNameTxt;
    private javax.swing.JList list;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem progMenuItem;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JMenuItem stdMenuItem;
    private javax.swing.JButton updateBtn;
    DepartmentFrame department;
    // End of variables declaration//GEN-END:variables
}
