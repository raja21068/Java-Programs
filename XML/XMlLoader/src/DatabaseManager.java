
import java.sql.Statement;

/**
 *
 * @author Jay
 */
public class DatabaseManager {
    static java.sql.Connection connection;
    static{
    try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=database/database.mdb");
    } catch(Exception e){ e.printStackTrace(); }
    }
    
    public static void addStudent(String name,String subject ,String rollNo, String marks)throws Exception{
        String query="Insert into student (student_name,student_subject,student_rollno,student_marks) values('"+name+"', '"+subject+"' , '"+rollNo+"' ,'"+marks+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        st.executeUpdate(query);
    }
}
