/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay Kumar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class JavaConnect {
    
    Connection conn = null;
    public static Connection connectDB(){
    
        try{
            Class.forName("org.sqlite.JDBC");//com.mysql.jdbc.Driver
            Connection conn = DriverManager.getConnection("jdbc:sqlite:E:/JAY KUMAR/Java Programms/PROGRMS/TestProject/TestDatabase.sqlite");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mysqlname","username","pasword");
//            JOptionPane.showMessageDialog(null,"Connection established..");
            return conn;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
            return null;
        }
        
    }
}
