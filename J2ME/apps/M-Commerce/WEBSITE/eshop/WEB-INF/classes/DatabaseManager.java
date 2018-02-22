import java.sql.*;

class DatabaseManager{

static java.sql.Connection connection;
  static{
   try{
     Class.forName("com.mysql.jdbc.Driver");
     // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop","root","");
     // connection = java.sql.DriverManager.getConnection("jdbc:odbc:examdata");
     
	 } catch(Exception e){ e.printStackTrace(); }
  }
  
  public static java.util.ArrayList getAllType()throws Exception{
	String query="SELECT * from type";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	java.util.ArrayList list = new java.util.ArrayList();
	while(result.next()){
		TypeBean bean = new TypeBean();
		bean.setTypeId(result.getInt("type_id"));
		bean.setTypeName(result.getString("type_name"));
		bean.setRemarks(result.getString("remarks"));
		list.add(bean);
	}  
	System.out.println(list.size()+" types retrived from database");
	return list;
  }
  
  public static int addType(String type , String remarks)throws Exception{
	String query="INSERT INTO type (`type_name` , `remarks`) values ('"+type+"' , '"+remarks+"')";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	int r =st.executeUpdate(query);
	return r;
  }
  public static int updateType(int typeId,String type , String remarks)throws Exception{
	String query="";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
    int r =st.executeUpdate(query);
	return r;	
  }
  public static int deleteType(int typeId)throws Exception{
	String query="Delete from type where type_id="+typeId;
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
    int r =st.executeUpdate(query);  
	return r;
  }
  
  public static java.util.ArrayList getAllProduct(int typeId)throws Exception{
	String query="SELECT * from product where type_id="+typeId;
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	java.util.ArrayList list = new java.util.ArrayList();
	while(result.next()){
		ProductBean bean = new ProductBean();
		bean.setTypeId(result.getInt("type_id"));
		bean.setProductId(result.getInt("product_id"));
		bean.setProductName(result.getString("product_name"));
		bean.setPrice(result.getDouble("price"));
		bean.setDescription(result.getString("description"));
		list.add(bean);
	}  
	System.out.println(list.size()+" products retrived from database");
	return list;
  }
    public static int addProduct(int typeId , String productName , double price , String description)throws Exception{
		String query="INSERT into product (type_id , product_name , price , description) values ("+typeId+" , '"+productName+"', "+price+" , '"+description+"')";
		System.out.println(query);
		java.sql.Statement st = connection.createStatement();
		int r =st.executeUpdate(query);
		return r;
  }
  
  
    public static int deleteProduct(int productId )throws Exception{
		String query="DELETE from product where product_id="+productId;
		System.out.println(query);
		java.sql.Statement st = connection.createStatement();
		int r =st.executeUpdate(query);
		return r;
  }
  
  
  public static java.util.ArrayList getAllCreditCards()throws Exception{
	String query="SELECT * from credit_cards";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	java.util.ArrayList list = new java.util.ArrayList();
	while(result.next()){
		CreditCardsBean bean = new CreditCardsBean();
		bean.setCardId(result.getInt("card_id"));
		bean.setCardName(result.getString("card_name"));
		list.add(bean);
	}  
	System.out.println(list.size()+" cards retrived from database");
	return list;
  }
  
  public static CustomerBean getCustomer(String username , String password)throws Exception{
	String query = "SELECT * FROM `customer` WHERE `user_name` = '"+username+"' AND `user_password`='"+password+"' "; 
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	CustomerBean bean = null;
	if(result.next()){
		bean = new CustomerBean();
		bean.setCustomerId(result.getInt("customer_id"));
		bean.setFirstName(result.getString("first_name"));
		bean.setLastName(result.getString("last_name"));
		bean.setCity(result.getString("city"));
		bean.setStreet(result.getString("street"));
		bean.setState(result.getString("state"));
		bean.setCountry(result.getString("country"));
		bean.setAddress1(result.getString("address1"));
		bean.setAddress2(result.getString("address2"));
		bean.setEmail(result.getString("email"));
		bean.setContactNo(result.getString("contact_no"));
		bean.setDateOfRegistry(result.getDate("date_of_registry"));
		//bean.setRemarks(result.getString("remarks"));
	}  
	System.out.println(bean+" customer retrived from database");
	return bean;
  }
  
  public static CreditCardNumberBean getCreditCardNumberBean(int cardId , String cardNo)throws Exception{
	String query = "SELECT * from credit_card_number where card_number='"+cardNo+"' AND card_id="+cardId;
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	CreditCardNumberBean bean = null;
	if(result.next()){
		bean = new CreditCardNumberBean();
		bean.setCardId(result.getInt("card_id"));
		bean.setCardNoId(result.getInt("card_no_id"));
		bean.setCardNumber(result.getString("card_number"));
		bean.setAmount(result.getDouble("amount"));
		//bean.setRemarks(result.getString("remarks"));
	}
	System.out.println(bean+" card number bean retrived from database");
	return bean;
  }
  
  public static int updateCreditCardNumber(int cardNoId ,double amount, String remarks)throws Exception{
	String query = "UPDATE credit_card_number SET amount = '"+amount+"' , remarks='"+remarks+"' WHERE card_no_id="+cardNoId;
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	int r = st.executeUpdate(query);
	return r;
  }
  
  public static int addTansaction(int customerId , int productId , int cardNoId , double amount , int quantity , String date , String shipingStatus , double shipingCharges , String remarks )throws Exception{
	String query="INSERT INTO transaction (`customer_id`,`product_id`,`card_no_id`,`amount`,`quantity`,`date_of_trans`,`ship_status`,`shiping_charges`,`remarks`) values ( "+customerId+" , "+productId+" , "+cardNoId+" , "+amount+" , "+quantity+" , '"+date+"' , '"+shipingStatus+"' ,  "+shipingCharges+" , '"+remarks+"')";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	int r = st.executeUpdate(query);
	return r;
  }
  
  public static AdminBean getAdmin(String name , String password)throws Exception{
	String query="SELECT * from admin where admin_name='"+name+"' AND admin_password='"+password+"'";
	System.out.println(query);
	java.sql.Statement st = connection.createStatement();
	System.out.println("statement created.: "+st);
	ResultSet result = st.executeQuery(query);
	AdminBean bean = null;
	if(result.next()){
		bean = new AdminBean();
		bean .setAdminId(result.getInt("admin_id"));
		bean .setAdminName(result.getString("admin_name"));
		bean .setAdminPassword(result.getString("admin_password"));
		bean .setAdminPrivilage(result.getString("admin_privilage"));
	}
	System.out.println(bean +" ADMINBEAN is retrived");
	return bean;
  } 
  
  }