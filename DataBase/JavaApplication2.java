import java.sql.*;

public class JavaApplication2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Students");
        try (Statement st = con.createStatement()) {
        //    int r = st.executeUpdate("into students(name, fName, rollNo, dept, dateOfBirth)values('Yougeshwar', 'Pirbhdas Khatri', '2k10-cse-86', 'BSCS', '24-Oct-1990')");
       //     r = st.executeUpdate("UPDATE students SET name='Yougeshwar', fName='Pirbhdas Khatri', rollNo='2k10-cse-86', dept='BSCS', dateOfBirth='24-April-1990' where studentId=11");
     //       r = st.executeUpdate("DELETE FROM students where studentId=11");
            ResultSet rs = st.executeQuery("SELECT name from Data");
            
            while(rs.next()){
                System.out.println(rs.getString("name"));
           }
            
            rs.close();
            con.close();
          //  System.out.println(r);
        }
    }
}
