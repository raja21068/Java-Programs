import java.sql.*;

class DatabaseManager{


static java.sql.Connection connection;
  static{
   try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     //connection = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\Jay Kumar\\Desktop\\Sale & Purchase (Jay)\\OnlineShopping\\shopping.mdb");
     connection = java.sql.DriverManager.getConnection("jdbc:odbc:shopping");
     } catch(Exception e){ e.printStackTrace(); }
  }
//----------------Queries of Picture table----------------
public static java.util.ArrayList getAllPictures(int vehicleId)throws  Exception{
    
     String query = "SELECT picture_id, vehical_id, picture_path, remarks FROM Picture where vehical_id="+vehicleId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      System.out.println("connection: "+connection);
      System.out.println("Statement: "+st);
      ResultSet result = st.executeQuery(query);
      System.out.println("ResultSet: "+result);
      while(result.next()){
       PictureBean rec = new PictureBean();
           rec.setPictureId(result.getInt("picture_id"));
           rec.setVehicalId(result.getInt("vehical_id"));
           rec.setPicturePath(result.getString("picture_path"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();
     System.out.println(vec.size()+" items found from database...");
     return vec;

   }

public static void addPicture(int vehicalId, String picturePath, String remarks)throws  Exception{


     
   String query = "INSERT INTO Picture(vehical_id, picture_path, remarks) VALUES ("+vehicalId+", '"+picturePath+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updatePicture(int pictureId, int vehicalId, String picturePath, String remarks)throws  Exception{     

   String query = "UPDATE Picture SET vehical_id="+vehicalId+", picture_path='"+picturePath+"', remarks='"+remarks+"' WHERE picture_id="+pictureId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deletePicture(int pictureId)throws  Exception{
     
   String query = "DELETE FROM Picture WHERE picture_id="+pictureId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static int addUsers(String firstName, String lastName, String email, String password, String userName, String address, String contactNo, String city, String state, String country)throws  Exception{
     
   String query = "INSERT INTO users(first_name, last_name, email, password, user_name, address, contact_no, city, state, country) VALUES ('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"', '"+userName+"', '"+address+"', '"+contactNo+"', '"+city+"', '"+state+"', '"+country+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      
      query = "SELECT user_id from users Order by user_id DESC";
      System.out.println(query);
      ResultSet rs = st.executeQuery(query);
      int id =0;
      if(rs.next()){
        id = Integer.parseInt(rs.getString("user_id"));
        System.out.println("\n\nId: "+id);
        
      }
      return id;
     }

public static int login(String user,String password)throws Exception{
      String query = "SELECT * FROM users where password='"+password+"' AND user_name='"+user+"'";
      System.out.println(query);
      
      java.sql.Statement st = connection.createStatement();
      System.out.println("connection: "+connection);
      System.out.println("Statement: "+st);
      ResultSet result = st.executeQuery(query);
      System.out.println("Resultset created: "+result);
      int id= 0;
      
      while(result.next()){
          try{
            id = Integer.parseInt(result.getString("user_id"));
          }catch(Exception ex){System.out.println("\n\nExcdeption ocuured in DBM in login while()");}
      }
      
      System.out.println("got the value of user id");
      return id;
}

public static void updateUsers(int userId, String firstName, String lastName, String email, String password, String userName, String address, String contactNo, String city, String state, String country)throws  Exception{     

   String query = "UPDATE Users SET first_name='"+firstName+"', last_name='"+lastName+"', email='"+email+"', password='"+password+"', user_name='"+userName+"', address='"+address+"', contact_no='"+contactNo+"', city='"+city+"', state='"+state+"', country='"+country+"' WHERE user_id="+userId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

//----------------Queries of Vehicle table----------------
public static java.util.ArrayList getAllVehicle(String company , String modelYear, String vehicalType,String vehicalName ,String color ,String registerCity,String price,String window,String transmission ,String AdditionalQuery)throws  Exception{

     
 String query = "SELECT * FROM Vehicle v, users u where v.company_make like '%"+company+"%' AND v.vehical_name like '%"+vehicalName+"%' AND v.vehical_type like '%"+vehicalType+"%' AND v.model_year like '%"+modelYear+"%' AND v.color like '%"+color+"%' AND  v.registered_city like '%"+registerCity+"%' AND v.price_demand <= "+price+" AND v.transmission like '%"+transmission+"%' AND v.user_id=u.user_id "+AdditionalQuery+" Order by date_of_upload desc ";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      System.out.println("statement: "+st+"\nConnectoin: "+connection);
      ResultSet result = st.executeQuery(query);
      System.out.println("Got result set..");
      while(result.next()){
       VehicleDataBean rec = new VehicleDataBean();
           
           rec.setName(result.getString("first_name"));
           rec.setEmail(result.getString("email"));
           rec.setCity(result.getString("city"));
           rec.setContactNo(result.getString("contact_no"));
           rec.setVehicalId(result.getInt("vehical_id"));
           rec.setCompanyMake(result.getString("company_make"));
           rec.setVehicalName(result.getString("vehical_name"));
           rec.setVehicalType(result.getString("vehical_type"));
           rec.setModelYear(result.getString("model_year"));
           rec.setColor(result.getString("color"));
           rec.setRegisteredYear(result.getString("registered_year"));
           rec.setRegisteredCity(result.getString("registered_city"));
           rec.setPriceDemand(result.getInt("price_demand"));
           rec.setAc(result.getBoolean("ac"));
           rec.setFuleType(result.getString("fule_type"));
           rec.setPowerWindow(result.getBoolean("power_window"));
           rec.setTransmission(result.getString("transmission"));
           rec.setCondition(result.getString("condition"));
           rec.setMileage(result.getString("mileage"));
           rec.setDoorCount(result.getString("door_count"));
           rec.setEngineType(result.getString("engine_type"));
           rec.setRemarks(result.getString("remarks"));
           rec.setDateOfUpload(result.getDate("date_of_upload"));
       vec.add(rec);
      }//end of while
     System.out.println(vec.size()+" items search from database..");
     
     st.close();

     return vec;

   }

public static java.util.ArrayList<VehicleBean> getAllVehicles(int id)throws Exception{
    String query = "SELECT * from vehicle where user_id="+id;
    System.out.println(query);
    Statement st = connection.createStatement();
    System.out.println("\nConnection: "+connection+"  Statement : "+st);
    ResultSet result = st.executeQuery(query);
    System.out.println("ResultSet created "+result);
    
    java.util.ArrayList<VehicleBean> list = new java.util.ArrayList();
    while(result.next()){
        VehicleBean bean = new VehicleBean();
        bean.setVehicalId(result.getInt("vehical_id"));
           bean.setCompanyMake(result.getString("company_make"));
           bean.setVehicalName(result.getString("vehical_name"));
           bean.setVehicalType(result.getString("vehical_type"));
           bean.setModelYear(result.getString("model_year"));
           bean.setColor(result.getString("color"));
           bean.setRegisteredYear(result.getString("registered_year"));
           bean.setRegisteredCity(result.getString("registered_city"));
           bean.setPriceDemand(result.getInt("price_demand"));
           bean.setAc(result.getBoolean("ac"));
           bean.setFuleType(result.getString("fule_type"));
           bean.setPowerWindow(result.getBoolean("power_window"));
           bean.setTransmission(result.getString("transmission"));
           bean.setCondition(result.getString("condition"));
           bean.setMileage(result.getString("mileage"));
           bean.setDoorCount(result.getString("door_count"));
           bean.setEngineType(result.getString("engine_type"));
           bean.setRemarks(result.getString("remarks"));
           bean.setDateOfUpload(result.getDate("date_of_upload"));
       list.add(bean);
    }
    
    return list;
}

public static VehicleDataBean getVehicle(int vehicalId)throws  Exception{

     
 String query = "SELECT * FROM Vehicle where vehical_id="+vehicalId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      System.out.println("statement: "+st+"\nConnectoin: "+connection);
      ResultSet result = st.executeQuery(query);
      System.out.println("Got result set..");
      VehicleDataBean rec = new VehicleDataBean();
      if(result.next()){
       
           rec.setVehicalId(result.getInt("vehical_id"));
           rec.setCompanyMake(result.getString("company_make"));
           rec.setVehicalName(result.getString("vehical_name"));
           rec.setVehicalType(result.getString("vehical_type"));
           rec.setModelYear(result.getString("model_year"));
           rec.setColor(result.getString("color"));
           rec.setRegisteredYear(result.getString("registered_year"));
           rec.setRegisteredCity(result.getString("registered_city"));
           rec.setPriceDemand(result.getInt("price_demand"));
           rec.setAc(result.getBoolean("ac"));
           rec.setFuleType(result.getString("fule_type"));
           rec.setPowerWindow(result.getBoolean("power_window"));
           rec.setTransmission(result.getString("transmission"));
           rec.setCondition(result.getString("condition"));
           rec.setMileage(result.getString("mileage"));
           rec.setDoorCount(result.getString("door_count"));
           rec.setEngineType(result.getString("engine_type"));
           rec.setRemarks(result.getString("remarks"));
           rec.setDateOfUpload(result.getDate("date_of_upload"));
       vec.add(rec);
      }//end of while
     System.out.println(vec.size()+" items search from database..");
     
     st.close();

     return rec;

   }

public static int addVehicle(int userId, String companyMake, String vehicalName, String vehicalType, String modelYear, String color, String registeredYear, String registeredCity, String priceDemand, boolean ac, String fuleType, boolean powerWindow, String transmission, String condition, String mileage, String doorCount, String engineType, String remarks, String dateOfUpload)throws  Exception{

      String query = "INSERT INTO Vehicle(user_id, company_make, vehical_name, vehical_type, model_year, color, registered_year, registered_city, price_demand, ac, fule_type, power_window, transmission, condition, mileage, door_count, engine_type, remarks, date_of_upload) VALUES ("+userId+", '"+companyMake+"', '"+vehicalName+"', '"+vehicalType+"', '"+modelYear+"', '"+color+"', '"+registeredYear+"', '"+registeredCity+"', "+priceDemand+", "+ac+", '"+fuleType+"', "+powerWindow+", '"+transmission+"', '"+condition+"', '"+mileage+"', '"+doorCount+"', '"+engineType+"', '"+remarks+"', #"+dateOfUpload+"#)";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      
      query = "SELECT vehical_id from Vehicle order by vehical_id desc";
      System.out.println(query);
      ResultSet rs =st.executeQuery(query);
      System.out.println("resultset created..");
      int id=0;
      if(rs.next()){
          id = rs.getInt("vehical_id");
          System.out.println("got vehical id: "+id);
      }
      return id;
}


public static void deleteVehicle(int vehicalId)throws  Exception{
     
      String query = "DELETE FROM Vehicle WHERE vehical_id="+vehicalId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      System.out.println("Query Executed..");
}

public static java.util.ArrayList getAllYears()throws Exception{
    String query = "SELECT * from years order by year desc";
    System.out.println(query);
    
    Statement st = connection.createStatement();
    System.out.println("\nConnection: "+connection+"\nStatement: "+st+"\n");
    ResultSet rs = st.executeQuery(query);
    java.util.ArrayList<Integer> list =new java.util.ArrayList<Integer>();
    
    while(rs.next()){
        list.add(rs.getInt("year"));
    }
    
    System.out.println(list.size()+" items are collected from database");
    return list;
}

public static java.util.ArrayList<String> getAllRegisteredCities()throws Exception{
String query = "SELECT DISTINCT(registered_city) from vehicle";
    System.out.println(query);
    
    Statement st = connection.createStatement();
    System.out.println("\nConnection: "+connection+"\nStatement: "+st+"\n");
    ResultSet rs = st.executeQuery(query);
    java.util.ArrayList<String> list =new java.util.ArrayList<>();
    
    while(rs.next()){
        list.add(rs.getString("registered_city"));
    }
    
    System.out.println(list.size()+" items are collected from database");
    return list;

}

public static boolean isEmailExist(String email)throws Exception{
    String query = "SELECT * from users where email='"+email+"'";
    System.out.println(query);
    
    Statement st = connection.createStatement();
    System.out.println("Statement created.. "+st);
    ResultSet rs = st.executeQuery(query);
    boolean check = false;
    if(rs.next()){
        check = true;
    }
    return check;
}

}
