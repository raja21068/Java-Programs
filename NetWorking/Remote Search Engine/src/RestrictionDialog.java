
/**
 *
 * @author Jay Kumar
 */
public class RestrictionDialog extends PermissionDialog{
    RestrictionDialog(){
        System.out.println("Entered");
        Label.setText("Restrict Permission");
        permissionBtn.setText("Restrict");
        permissionBtn.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent e){
        		try {
				DBManager.addIP(jTextField1.getText());
				updateCombo();
				} catch (Exception e1) {e1.printStackTrace();}
        	}
        });
    }
}
