/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import forms.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raja Kumar
 */
public class Main {
    public static void main(String arg[]){
        try{
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
        
        new MainFrame().setVisible(true);
        
    }
}
