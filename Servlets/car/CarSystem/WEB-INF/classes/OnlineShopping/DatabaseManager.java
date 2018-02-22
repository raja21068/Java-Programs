import java.sql.*;

class DatabaseManager{

static Connection connection;

  static{
   try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     connection = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\Tomcat6.0\\webapps\\ROOT\\WEB-INF\\shopping.mdb");
     } catch(Exception e){ e.printStackTrace(); }
  }
//----------------Queries of vehicle table----------------
public static java.util.ArrayList getAllvehicle()throws  Exception{

     
 String query = "SELECT ID, company, model, color, register, price, ac, cng, power_window, transmission, owner, contact_no, email, address, pictures FROM vehicle";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       VehicleBean rec = new VehicleBean();
           rec.setId(result.getInt("ID"));
           rec.setCompany(result.getString("company"));
           rec.setModel(result.getString("model"));
           rec.setColor(result.getString("color"));
           rec.setRegister(result.getString("register"));
           rec.setPrice(result.getString("price"));
           rec.setAc(result.getBoolean("ac"));
           rec.setCng(result.getBoolean("cng"));
           rec.setPowerWindow(result.getBoolean("power_window"));
           rec.setTransmission(result.getInt("transmission"));
           rec.setOwner(result.getString("owner"));
           rec.setContactNo(result.getString("contact_no"));
           rec.setEmail(result.getString("email"));
           rec.setAddress(result.getString("address"));
           rec.setPictures(result.getString("pictures"));
		   vec.add(rec);
      }//end of while

		st.close();

     return vec;

   }

public static int addVehicle(String company, String model, String color, String register, String price, boolean ac, boolean cng, boolean powerWindow, int transmission, String owner, String contactNo, String email, String address, String pictures)throws  Exception{
  
   String query = "INSERT INTO vehicle(company, model, color, register, price, ac, cng, power_window, transmission, owner, contact_no, email, address, pictures) VALUES ('"+company+"', '"+model+"', '"+color+"', '"+register+"', '"+price+"', "+ac+", "+cng+", "+powerWindow+", "+transmission+", '"+owner+"', '"+contactNo+"', '"+email+"', '"+address+"', '"+pictures+"')";
      System.out.println(query);
	  System.out.println();
	  System.out.println();
	  System.out.println();
	  System.out.println();
	  System.out.println("connection: "+connection);
	  java.sql.Statement st = connection.createStatement();
	  System.out.println();
	  System.out.println();
	  System.out.println();
      int i = st.executeUpdate(query);
	  return i;
	}

public static void deletevehicle(int id)throws  Exception{
     
   String query = "DELETE FROM vehicle WHERE ID="+id;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
   }


}
