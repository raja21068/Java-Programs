import java.applet.*;
import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class FacultyFrame extends Applet {
    
    MainFrame main;
    /** Creates new form FacultyFrame */
    public FacultyFrame(MainFrame main) {
		this.main = main;
        initComponents();
        refreshList();
	show();
	}
        public void init(){
	//this.main = main;
        initComponents();
        refreshList();
	show();
    }
    @SuppressWarnings("unchecked")
   
    public void initComponents() {

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
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
       
        //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setLayout(null);

        mainLabel.setFont(new java.awt.Font("Tahoma", 3, 14));
        mainLabel.setForeground(new java.awt.Color(153, 0, 204));
        mainLabel.setText("F a c u l t y   I n f o r m a t i o n");
        add(mainLabel);
        mainLabel.setBounds(110, 10, 220, 30);

        listScroll.setViewportView(list);
        add(listScroll);
        listScroll.setBounds(260, 90, 160, 160);
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
        add(facNameLbl);
        facNameLbl.setBounds(20, 100, 90, 20);
        add(facNameTxt);
        facNameTxt.setBounds(20, 120, 230, 22);
        add(facIDTxt);
        facIDTxt.setEnabled(false);
        facIDTxt.setBounds(100, 70, 150, 22);

        facIdLbl.setFont(new java.awt.Font("Tahoma", 1, 13));
        facIdLbl.setText("Faculty ID :");
        add(facIdLbl);
        facIdLbl.setBounds(20, 70, 80, 20);

        remarkLbl.setText("Remarks");
        add(remarkLbl);
        remarkLbl.setBounds(20, 150, 50, 16);

        remarkScroll.setViewportView(remarkTxt);

        add(remarkScroll);
        remarkScroll.setBounds(20, 170, 230, 80);

        addButton.setText("ADD");
        add(addButton);
        addButton.setBounds(20, 260, 80, 25);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    addButtonActionPerformed(e);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        deleteButton.setText("DEL");
        add(deleteButton);
        deleteButton.setBounds(100, 260, 80, 25);
        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(list.getSelectedValue()==null)return;
                try{
                deleteButtonActionPerformed(e);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });
        
        updateButton.setText("Update");
        add(updateButton);
        updateButton.setBounds(180, 260, 80, 25);
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(list.getSelectedValue()==null)return; 
                try{
                    updateButtonActionPerformed(e);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        clearBtn.setText("Clear");
        add(clearBtn);
        clearBtn.setBounds(260, 260, 80, 25);
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearButtonActionPerformed(e);
            }
            });
        
        backButton.setText("Back");
        add(backButton);
        backButton.setBounds(340, 260, 80, 25);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });

        listLbl.setText("Faculty List");
        add(listLbl);
        listLbl.setBounds(300, 70, 70, 20);
       
        //pack();
       
    }
    
    public void addButtonActionPerformed(ActionEvent e)throws Exception{
          if((facNameTxt.getText().trim().length())<3 ){
              JOptionPane.showMessageDialog(null, "Invalid / Empty name..");
              return;
          }
          FacultyBean bean = new FacultyBean();
          bean.factName = facNameTxt.getText();
          bean.remarks = remarkTxt.getText();
          Vector v = DatabaseManager.getAllFaculty();
          boolean check = true;
          for(int i =0; i<v.size(); i++){
              FacultyBean b = (FacultyBean)v.elementAt(i);
              if(b.factName.trim().equals(bean.factName)){ 
                   JOptionPane.showMessageDialog(null, "This faculty is already n record...");
                   check =false;  break; }
                 }                
                    if(check)DatabaseManager.addFaculty(bean);
                    refreshList();
    }
    
    public void deleteButtonActionPerformed(ActionEvent e)throws Exception{
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null , "No faculty is selected from list...");
            return;
        }
        FacultyBean fb= (FacultyBean)list.getSelectedValue();
        DatabaseManager.deleteFaculty(fb.factID);
        JOptionPane.showMessageDialog(this, fb.getFactName()+" is deleted...");
        refreshList();
    }
    
    public void updateButtonActionPerformed(ActionEvent e)throws Exception{
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null , "No faculty is selected from list...");
            return;
        }
        if((facNameTxt.getText().trim().length())<3 ){
              JOptionPane.showMessageDialog(null, "Invalid / Empty name..");
              return;
         }
        FacultyBean fb=(FacultyBean)list.getSelectedValue();
        DatabaseManager.updateFaculty(facNameTxt.getText(), remarkTxt.getText(),fb.factID);
        refreshList();
    }
    
    public void clearButtonActionPerformed(ActionEvent e){
        facIDTxt.setText("");
        facNameTxt.setText("");
        remarkTxt.setText("");
    }
    
    public void refreshList(){
        list.removeAll();
        try{
        Vector v = DatabaseManager.getAllFaculty();
        list.setListData(v);
        }catch(Exception e){e.printStackTrace();}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton deleteButton;
    public javax.swing.JButton addButton;
    public javax.swing.JButton clearBtn;
    public javax.swing.JTextField facIDTxt;
    public javax.swing.JLabel facIdLbl;
    public javax.swing.JLabel facNameLbl;
    public javax.swing.JTextField facNameTxt;
    public javax.swing.JList list;
    public javax.swing.JLabel listLbl;
    public javax.swing.JScrollPane listScroll;
    public javax.swing.JLabel mainLabel;
    public javax.swing.JLabel remarkLbl;
    public javax.swing.JScrollPane remarkScroll;
    public javax.swing.JTextField remarkTxt;
    public javax.swing.JButton updateButton;
    public javax.swing.JButton backButton;
    // End of variables declaration//GEN-END:variables

    
}
