/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class MyLabel extends javax.swing.JLabel{
    @Override
    public void paint(java.awt.Graphics g){
        g.setColor(java.awt.Color.WHITE);
        g.fillOval(0, 0, 10, 10); 
    }
}
