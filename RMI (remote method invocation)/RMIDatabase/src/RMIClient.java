import java.rmi.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class RMIClient extends javax.swing.JFrame {

	DatabaseManager ob;
        public RMIClient()throws Exception {
        initComponents();
	ob = (DatabaseManager) Naming.lookup("rmi://192.168.1.2:1099/ali");
        nameList.setListData(ob.getAllData().toArray());
    }
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        listScrollPane = new javax.swing.JScrollPane();
        nameList = new javax.swing.JList();
        nameListLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        subjectTextField = new javax.swing.JTextField();
        SubjectLabel = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        rollNoLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RMI Client");
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        listScrollPane.setViewportView(nameList);
        
        nameList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                nameListValueChanged(e);
            }
        });
                
        getContentPane().add(listScrollPane);
        listScrollPane.setBounds(303, 51, 160, 290);

        nameListLabel.setText("Names");
        getContentPane().add(nameListLabel);
        nameListLabel.setBounds(340, 20, 50, 20);
        getContentPane().add(nameTextField);
        nameTextField.setBounds(100, 70, 190, 30);

        nameLabel.setText("Name:");
        getContentPane().add(nameLabel);
        nameLabel.setBounds(10, 70, 80, 30);
        getContentPane().add(subjectTextField);
        subjectTextField.setBounds(100, 140, 190, 30);

        SubjectLabel.setText("Subject:");
        getContentPane().add(SubjectLabel);
        SubjectLabel.setBounds(10, 140, 80, 30);
        getContentPane().add(rollNoTextField);
        rollNoTextField.setBounds(100, 210, 190, 30);

        rollNoLabel.setText("Roll #");
        getContentPane().add(rollNoLabel);
        rollNoLabel.setBounds(10, 210, 80, 30);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(10, 280, 100, 30);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(150, 280, 110, 30);

        pack();
    }// </editor-fold> 

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try{
	int num = ob.add(nameTextField .getText(), subjectTextField.getText(), rollNoTextField.getText());
        System.out.println("Record is added successfully");
	javax.swing.JOptionPane.showMessageDialog(null,"Record is added successfully");
	clearTextFields();
        nameList.setListData(ob.getAllData().toArray());
	}catch(Exception ex){ javax.swing.JOptionPane.showMessageDialog(null,ex); }
    }
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try{
            int num = ob.delete(nameTextField.getText().trim());
            javax.swing.JOptionPane.showMessageDialog(null,"Record is deleted successfully");
            nameList.setListData(ob.getAllData().toArray());
            clearTextFields();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void nameListValueChanged(javax.swing.event.ListSelectionEvent e){
        BiodataBean bean = (BiodataBean)nameList.getSelectedValue();
        if(bean==null)return;
        nameTextField.setText(bean.getStudentName());
	subjectTextField.setText(bean.getSubject());
	rollNoTextField.setText(bean.getRollNo());
    }

   private void clearTextFields(){
	nameTextField.setText("");
	subjectTextField.setText("");
	rollNoTextField.setText("");
   }
   

    public static void main(String args[]) throws Exception{
            com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(new java.util.Properties());
         UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                new RMIClient().setVisible(true);
            
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane listScrollPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JList nameList;
    private javax.swing.JLabel nameListLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JTextField subjectTextField;
    // End of variables declaration//GEN-END:variables
}
