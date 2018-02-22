
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnection {
    Connection connection; 
    public DatabaseConnection(String s){
        try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+s);
        }catch(Exception e){e.printStackTrace();}
    }
    public java.util.ArrayList getContacts()throws Exception{
        String sql = "SELECT * from contacts";
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            ContactBean bean = new ContactBean();
            bean.setName(rs.getString("contact_name"));
            bean.setNumber(rs.getString("phone_number"));
            System.out.println(bean.getName());
            list.add(bean);
        }
        return list;
    }
}
