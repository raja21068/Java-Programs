import java.sql.*;
class DatabaseManager{

static java.sql.Connection connection;
  static{
   try{
     Class.forName("com.mysql.jdbc.Driver");
     connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/state","root","");
	 } catch(Exception e){ e.printStackTrace(); }
  }

  //----------------Queries of Area table----------------
public static java.util.ArrayList getAllArea(int cityId)throws  Exception{

     
	  String query = "SELECT area_id, city_id, Area_name, Remarks FROM Area where city_id="+cityId;
	  System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       AreaBean rec = new AreaBean();
           rec.setAreaId(result.getInt("area_id"));
           rec.setCityId(result.getInt("city_id"));
           rec.setAreaName(result.getString("Area_name"));
           rec.setRemarks(result.getString("Remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static java.util.ArrayList getAllArea()throws Exception{
	String query = "SELECT a.area_id, a.city_id,  c.City_name ,CONCAT(c.City_name,CONCAT(\"/ \",a.Area_name)) AS Area_name ,a.Remarks FROM city c , area a WHERE c.City_id = a.City_id order by City_name";
	System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       AreaBean rec = new AreaBean();
           rec.setAreaId(result.getInt("area_id"));
           rec.setCityId(result.getInt("city_id"));
           rec.setAreaName(result.getString("Area_name"));
           rec.setRemarks(result.getString("Remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;


}   
public static void addArea(int cityId, String areaName, String remarks)throws  Exception{


     
	 String query = "INSERT INTO Area(city_id, Area_name, Remarks) VALUES ("+cityId+", '"+areaName+"', '"+remarks+"')";
	System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateArea(int areaId, int cityId, String areaName, String remarks)throws  Exception{     

   String query = "UPDATE Area SET city_id="+cityId+", Area_name='"+areaName+"', Remarks='"+remarks+"' WHERE area_id="+areaId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteArea(int areaId)throws  Exception{
     
   String query = "DELETE FROM Area WHERE area_id="+areaId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of City table----------------
public static java.util.ArrayList getAllCity()throws  Exception{

     
 String query = "SELECT City_id, City_name, Remarks FROM City";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       CityBean rec = new CityBean();
           rec.setCityId(result.getInt("City_id"));
           rec.setCityName(result.getString("City_name"));
           rec.setRemarks(result.getString("Remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addCity(String cityName, String remarks)throws  Exception{


     
   String query = "INSERT INTO City(City_name, Remarks) VALUES ('"+cityName+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateCity(int cityId, String cityName, String remarks)throws  Exception{     

   String query = "UPDATE City SET City_name='"+cityName+"', Remarks='"+remarks+"' WHERE City_id="+cityId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteCity(int cityId)throws  Exception{
     
   String query = "DELETE FROM City WHERE City_id="+cityId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Customer table----------------
public static java.util.ArrayList getAllCustomer()throws  Exception{

     
	  String query = "SELECT customer_id, First_name, Last_Name, City, Address, Contact_No, email, User, Password FROM Customer";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       CustomerBean rec = new CustomerBean();
           rec.setCustomerId(result.getInt("customer_id"));
           rec.setFirstName(result.getString("First_name"));
           rec.setLastName(result.getString("Last_Name"));
           rec.setCity(result.getString("City"));
           rec.setAddress(result.getString("Address"));
           rec.setContactNo(result.getString("Contact_No"));
           rec.setEmail(result.getString("email"));
           rec.setUser(result.getString("User"));
           rec.setPassword(result.getString("Password"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addCustomer(String firstName, String lastName, String city, String address, String contactNo, String email, String user, String password)throws  Exception{


     
   String query = "INSERT INTO Customer(First_name, Last_Name, City, Address, Contact_No, email, User, Password) VALUES ('"+firstName+"', '"+lastName+"', '"+city+"', '"+address+"', '"+contactNo+"', '"+email+"', '"+user+"', '"+password+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateCustomer(int customerId, String firstName, String lastName, String city, String address, String contactNo, String email, String user, String password)throws  Exception{     

   String query = "UPDATE Customer SET First_name='"+firstName+"', Last_Name='"+lastName+"', City='"+city+"', Address='"+address+"', Contact_No='"+contactNo+"', email='"+email+"', User='"+user+"', Password='"+password+"' WHERE customer_id="+customerId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteCustomer(int customerId)throws  Exception{
     
   String query = "DELETE FROM Customer WHERE customer_id="+customerId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

	public static CustomerBean getCustomer(String username , String pass)throws Exception{
		String query = "SELECT customer_id, First_name, Last_Name, City, Address, Contact_No, email, User, Password FROM Customer where User='"+username+"' AND Password='"+pass+"'";
        System.out.println(query);
        
		java.sql.Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
		CustomerBean bean = null;
		if(result.next()){
			bean = new CustomerBean();
			bean.setCustomerId(result.getInt("customer_id"));
            bean.setFirstName(result.getString("First_name"));
            bean.setLastName(result.getString("Last_Name"));
            bean.setCity(result.getString("City"));
            bean.setAddress(result.getString("Address"));
            bean.setContactNo(result.getString("Contact_No"));
            bean.setEmail(result.getString("email"));
            bean.setUser(result.getString("User"));
            bean.setPassword(result.getString("Password"));
		}
		
		return bean;
	}  

//----------------Queries of Media_detail table----------------
public static java.util.ArrayList getAllMediaDetail(int propsId)throws  Exception{

     
 String query = "SELECT Media_id, Property_detail_id, Media_name FROM Media_detail where Property_detail_id="+propsId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       MediaDetailBean rec = new MediaDetailBean();
           rec.setMediaId(result.getInt("Media_id"));
           rec.setPropertyDetailId(result.getInt("Property_detail_id"));
           rec.setMediaName(result.getString("Media_name"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addMediaDetail(int propertyDetailId, String mediaName)throws  Exception{


     
   String query = "INSERT INTO Media_detail(Property_detail_id, Media_name) VALUES ("+propertyDetailId+", '"+mediaName+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateMedia_detail(int mediaId, int propertyDetailId, String mediaName)throws  Exception{     

   String query = "UPDATE Media_detail SET Property_detail_id="+propertyDetailId+", Media_name='"+mediaName+"' WHERE Media_id="+mediaId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteMediaDetail(int mediaId)throws  Exception{
     
   String query = "DELETE FROM Media_detail WHERE Media_id="+mediaId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Property_detail table----------------
public static java.util.ArrayList getAllProperty_detail(int areaId , String propertyType , String forWhat)throws  Exception{

     
 String query = "SELECT Property_datail_id, Area_id, Area_square_feet, Single_double_story, Number_room, Kitchen, Property_type, Location, price, date_upload, Description, For_what, Address, Customer_id FROM Property_detail where  Area_id="+areaId+"  AND Property_type like '"+propertyType+"' AND For_what like '"+forWhat+"'";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       PropertyDetailBean rec = new PropertyDetailBean();
           rec.setPropertyDatailId(result.getInt("Property_datail_id"));
           rec.setAreaId(result.getInt("Area_id"));
           rec.setAreaSquareFeet(result.getString("Area_square_feet"));
           rec.setSingleDoubleStory(result.getString("Single_double_story"));
           rec.setNumberRoom(result.getString("Number_room"));
           rec.setKitchen(result.getString("Kitchen"));
           rec.setPropertyType(result.getString("Property_type"));
           rec.setLocation(result.getString("Location"));
           rec.setPrice(result.getString("price"));
           rec.setDateUpload(result.getString("date_upload"));
           rec.setDescription(result.getString("Description"));
           rec.setForWhat(result.getString("For_what"));
           rec.setAddress(result.getString("Address"));
           rec.setCustomerId(result.getInt("Customer_id"));
       vec.add(rec);
      }//end of while
	
	System.out.println(vec.size()+" property has fetched");
     st.close();

     return vec;

   }

public static PropertyDetailBean getAllPropertyDetail(int propsId )throws  Exception{
		String query = "SELECT Property_datail_id, Area_id, Area_square_feet, Single_double_story, Number_room, Kitchen, Property_type, Location, price, date_upload, Description, For_what, Address, Customer_id FROM Property_detail where  Property_datail_id="+propsId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
		PropertyDetailBean rec=null;	
	if(result.next()){
		   rec = new PropertyDetailBean();
           rec.setPropertyDatailId(result.getInt("Property_datail_id"));
           rec.setAreaId(result.getInt("Area_id"));
           rec.setAreaSquareFeet(result.getString("Area_square_feet"));
           rec.setSingleDoubleStory(result.getString("Single_double_story"));
           rec.setNumberRoom(result.getString("Number_room"));
           rec.setKitchen(result.getString("Kitchen"));
           rec.setPropertyType(result.getString("Property_type"));
           rec.setLocation(result.getString("Location"));
           rec.setPrice(result.getString("price"));
           rec.setDateUpload(result.getString("date_upload"));
           rec.setDescription(result.getString("Description"));
           rec.setForWhat(result.getString("For_what"));
           rec.setAddress(result.getString("Address"));
           rec.setCustomerId(result.getInt("Customer_id"));
      
      }//end of while
	
	
     st.close();

     return rec;

}
   
   
public static int addPropertyDetail(int areaId, String areaSquareFeet, String singleDoubleStory, String numberRoom, String kitchen, String propertyType, String location, String price, String dateUpload, String description, String forWhat, String address, int customerId)throws  Exception{


     
   String query = "INSERT INTO Property_detail(Area_id, Area_square_feet, Single_double_story, Number_room, Kitchen, Property_type, Location, price, date_upload, Description, For_what, Address, Customer_id) VALUES ("+areaId+", '"+areaSquareFeet+"', '"+singleDoubleStory+"', '"+numberRoom+"', '"+kitchen+"', '"+propertyType+"', '"+location+"', '"+price+"', '"+dateUpload+"', '"+description+"', '"+forWhat+"', '"+address+"', "+customerId+")";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
	  
	  query = "SELECT MAX(Property_datail_id) from Property_detail";
	  System.out.println(query);
      ResultSet result = st.executeQuery(query);
	  System.out.println("Query Executed...!");
	  if(result.next()){
		return result.getInt(1);
	  }
      return 0;
	}

public static void updatePropertyDetail(int propertyDatailId, int areaId, String areaSquareFeet, String singleDoubleStory, String numberRoom, String kitchen, String propertyType, String location, String price, String dateUpload, String description, String forWhat, String address, int customerId)throws  Exception{     

   String query = "UPDATE Property_detail SET Area_id="+areaId+", Area_square_feet='"+areaSquareFeet+"', Single_double_story='"+singleDoubleStory+"', Number_room='"+numberRoom+"', Kitchen='"+kitchen+"', Property_type='"+propertyType+"', Location='"+location+"', price='"+price+"', date_upload='"+dateUpload+"', Description='"+description+"', For_what='"+forWhat+"', Address='"+address+"', Customer_id="+customerId+" WHERE Property_datail_id="+propertyDatailId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteProperty_detail(int propertyDatailId)throws  Exception{
     
   String query = "DELETE FROM Property_detail WHERE Property_datail_id="+propertyDatailId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static java.util.ArrayList getDistinctPropertyType(int areaId)throws Exception{
	String query = "SELECT distinct(Property_type) FROM Property_detail where Area_id="+areaId;
	System.out.println(query);
    java.util.ArrayList list = new java.util.ArrayList();
    java.sql.Statement st = connection.createStatement();
    ResultSet result = st.executeQuery(query);
    while(result.next()){
		list.add(result.getString("Property_type"));
	}
    System.out.println(list.size()+" property type have fetched from database");   
	return list;
}

public static int getMaxMediaId()throws Exception{
	String query="SELECT MAX(Media_id) FROM media_detail";
	System.out.println(query);
    java.sql.Statement st = connection.createStatement();
    ResultSet result = st.executeQuery(query);
    if(result.next()){
		return result.getInt(1);
	}
	
	return 0;
} 
}
