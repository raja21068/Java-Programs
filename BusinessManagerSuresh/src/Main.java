
import form.LoginFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Jay Kumar
 */
public class Main {
    public static void main(String args[])throws Exception{
       setLookAndFeel();        
       new LoginFrame().setVisible(true);
        
    }
         
    public static void setLookAndFeel(){
       try {
           java.util.Properties props = new java.util.Properties();
           props.put("logoString","J.K");
           props.put("menuSelectionBackgroundColor", "255 128 200");
           com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(props);
           javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error..!\n"+ex);
            ex.printStackTrace(System.err); } 
    }
}
