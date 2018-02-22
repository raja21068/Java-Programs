
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseManager {
   public static Connection connection;
   static{
       try{
           
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=data.mdb");
        }catch(Exception e){e.printStackTrace();}
   }
    public static int deleteContacts()throws Exception{
        String query = "DELETE * from contacts";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
        return i;
    }
    public static int Contacts()throws Exception{
        String query = "SELECT * from contacts";
        System.out.println(query);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        st.close();
        return 0;
    }
   public static int addContact(int sNo,String name,String no)throws Exception{
        String query = "INSERT into contacts (s_no ,contact_name,phone_number) values ("+sNo+" ,'"+name+"','"+no+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
        return i;
   } 
}
