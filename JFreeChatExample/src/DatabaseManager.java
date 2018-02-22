import java.sql.*;
class DatabaseManager{
//'* @author Raja 
//' * @date 04-Nov-2012 01:08:01 AM
static java.sql.Connection connection;
  static{
   try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     connection = java.sql.DriverManager.getConnection("jdbc:odbc:Customer");
     } catch(Exception e){ e.printStackTrace(); }
  }
//----------------Queries of Customer table----------------
public static java.util.Vector getAllCustomer()throws  Exception{

     
 String query = "SELECT ID, castomer_name, jan, feb, march, april, may, june, july, august, september, october, november, december FROM Customer";
      System.out.println(query);
      java.util.Vector vec = new java.util.Vector();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       CustomerBean rec = new CustomerBean();
           rec.setId(result.getInt("ID"));
           rec.setCastomerName(result.getString("castomer_name"));
           rec.setJan (result.getString("jan")) ;
           rec.setFeb (result.getString("feb")) ;
           rec.setMarch (result.getString("march"));
           rec.setApril(result.getString("april"));
           rec.setMay(result.getString("may"));
           rec.setJune (result.getString("june"));
           rec.setJuly (result.getString("july"));
           rec.setAugust (result.getString("august"));
           rec.setSeptember(result.getString("september"));
           rec.setOctober(result.getString("october"));
           rec.setNovember(result.getString("november"));
           rec.setDecember(result.getString("december"));
       vec.addElement(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addCustomer(String castomerName, String jan, String feb, String march, String april, String may, String june, String july, String august, String september, String october, String november, String december)throws  Exception{


     
   String query = "INSERT INTO Customer(castomer_name, jan, feb, march, april, may, june, july, august, september, october, november, december) VALUES ('"+castomerName+"', "+jan+", "+feb+", "+march+", "+april+", "+may+", "+june+", "+july+", "+august+", "+september+", "+october+", "+november+", "+december+")";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateCustomer(int id, String castomerName, String jan, String feb, String march, String april, String may, String june, String july, String august, String september, String october, String november, String december)throws  Exception{     

   String query = "UPDATE Customer SET castomer_name='"+castomerName+"', jan="+jan+", feb="+feb+", march="+march+", april="+april+", may="+may+", june="+june+", july="+july+", august="+august+", september="+september+", october="+october+", november="+november+", december="+december+" WHERE ID="+id;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteCustomer(int id)throws  Exception{
     
   String query = "DELETE FROM Customer WHERE ID="+id;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


}
