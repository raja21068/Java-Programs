import java.util.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class FacultyFrame extends javax.swing.JFrame {
    
    MainFrame main;
    /** Creates new form FacultyFrame */
    public FacultyFrame(MainFrame main) {
        this.main = main;
        initComponents();
    }
    public void setVisible(boolean b){
        if(b){
            refreshList();
        }
        super.setVisible(b);
    }
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        listScroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        facultyLabel = new javax.swing.JLabel();
        facultyTextField = new javax.swing.JTextField();
        facultyIdTextField = new javax.swing.JTextField();
        facultyIdLabel = new javax.swing.JLabel();
        remarkLbl = new javax.swing.JLabel();
        remarkScroll = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        listLbl = new javax.swing.JLabel();
       
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        listScroll.setBounds(260, 90, 160, 160);
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(e.getSource() == null) return;
                FacultyBean fb = (FacultyBean)list.getSelectedValue();
                facultyIdTextField.setText(""+fb.getFacultyId());
                facultyTextField.setText(fb.getFacultyName());
                remarksTextArea.setText(fb.getRemarks());
            }
        });
        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facultyLabel.setText("Faculty Name:");
        getContentPane().add(facultyLabel);
        facultyLabel.setBounds(20, 100, 90, 20);
        getContentPane().add(facultyTextField);
        facultyTextField.setBounds(20, 120, 230, 22);
        getContentPane().add(facultyIdTextField);
        facultyIdTextField.setEnabled(false);
        facultyIdTextField.setBounds(100, 70, 150, 22);

        facultyIdLabel.setFont(new java.awt.Font("Tahoma", 1, 13));
        facultyIdLabel.setText("Faculty ID :");
        getContentPane().add(facultyIdLabel);
        facultyIdLabel.setBounds(20, 70, 80, 20);

        remarkLbl.setText("Remarks");
        getContentPane().add(remarkLbl);
        remarkLbl.setBounds(20, 150, 50, 16);

        remarkScroll.setViewportView(remarksTextArea);

        getContentPane().add(remarkScroll);
        remarkScroll.setBounds(20, 170, 230, 80);

        addButton.setText("ADD");
        getContentPane().add(addButton);
        addButton.setBounds(20, 260, 80, 25);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    addButtonActionPerformed(e);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        deleteButton.setText("DEL");
        getContentPane().add(deleteButton);
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
        getContentPane().add(updateButton);
        updateButton.setBounds(180, 260, 80, 25);
        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(list.getSelectedValue()==null)return; 
                try{
                    updateButtonActionPerformed(e);
                }catch(Exception e1){ e1.printStackTrace(); }
            }
            });

        clearButton.setText("Clear");
        getContentPane().add(clearButton);
        clearButton.setBounds(260, 260, 80, 25);
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearButtonActionPerformed(e);
            }
            });
        
        backButton.setText("Back");
        getContentPane().add(backButton);
        backButton.setBounds(340, 260, 80, 25);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });

        listLbl.setText("Faculty List");
        getContentPane().add(listLbl);
        listLbl.setBounds(300, 70, 70, 20);
       
        pack();
       
    }
    
    private void addButtonActionPerformed(ActionEvent e)throws Exception{
          if((facultyTextField.getText().trim().length())<3 ){
              JOptionPane.showMessageDialog(rootPane, "Invalid / Empty name..");
              return;
          }
          FacultyBean bean = new FacultyBean();
          bean.setFacultyName(facultyTextField.getText());
          bean.setRemarks(remarksTextArea.getText());
          Vector v = DatabaseManager.getAllFaculty();
          boolean check = true;
          for(int i =0; i<v.size(); i++){
              FacultyBean b = (FacultyBean)v.elementAt(i);
              if(b.getFacultyName().trim().equals(bean.getFacultyName())){ 
                   JOptionPane.showMessageDialog(rootPane, "This faculty is already n record...");
                   check =false;  break; }
                 }                
                    if(check)DatabaseManager.addFaculty(bean);
                    refreshList();
    }
    
    private void deleteButtonActionPerformed(ActionEvent e)throws Exception{
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane , "No faculty is selected from list...");
            return;
        }
        FacultyBean fb= (FacultyBean)list.getSelectedValue();
        DatabaseManager.deleteFaculty(fb.getFacultyId());
        JOptionPane.showMessageDialog(this, fb.getFacultyName()+" is deleted...");
        refreshList();
    }
    
    private void updateButtonActionPerformed(ActionEvent e)throws Exception{
        if(list.isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane , "No faculty is selected from list...");
            return;
        }
        if((facultyTextField.getText().trim().length())<3 ){
              JOptionPane.showMessageDialog(rootPane, "Invalid / Empty name..");
              return;
         }
        FacultyBean fb=(FacultyBean)list.getSelectedValue();
        DatabaseManager.updateFaculty(facultyTextField.getText(), remarksTextArea.getText(),fb.getFacultyId());
        refreshList();
    }
    
    private void clearButtonActionPerformed(ActionEvent e){
        facultyIdTextField.setText("");
        facultyTextField.setText("");
        remarksTextArea.setText("");
    }
    
    public void refreshList(){
        list.removeAll();
        try{
        Vector v = DatabaseManager.getAllFaculty();
        list.setListData(v);
        }catch(Exception e){e.printStackTrace();}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField facultyIdTextField;
    private javax.swing.JLabel facultyIdLabel;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JTextField facultyTextField;
    private javax.swing.JList list;
    private javax.swing.JLabel listLbl;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel remarkLbl;
    private javax.swing.JScrollPane remarkScroll;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton backButton;
    // End of variables declaration//GEN-END:variables

    
}
