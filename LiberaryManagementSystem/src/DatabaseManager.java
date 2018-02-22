import java.sql.*;
class DatabaseManager{
//'* @author Raja 
//' * @date 02-Dec-2012 02:00:57 PM
static java.sql.Connection connection = null;
  static{
   try{
     // Class.forName("sun.odbc.jdbc.JdbcOdbcDriver");
     connection = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=LiberaryRecord.mdb");
     } catch(Exception e){ e.printStackTrace(); }
  }
//----------------Queries of book_issue table----------------
public static java.util.Vector getAllbook_issue()throws  Exception{

     
 String query = "SELECT issue_id, cat_detail_id, date_of_issue, date_of_return, fine_amount, remarks, Department_name, Batch_year, student_name, roll_no FROM book_issue";
      System.out.println(query);
      java.util.Vector vec = new java.util.Vector();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       BookIssueBean rec = new BookIssueBean();
           rec.setIssueId ( result.getInt("issue_id"));
           rec.setCatDetailId (result.getInt("cat_detail_id"));
           rec.setDateOfIssue(result.getDate("date_of_issue")) ;
           rec.setDateOfReturn (result.getDate("date_of_return")) ;
           rec.setFineAmount (result.getInt("fine_amount"));
           rec.setRemarks (result.getString("remarks")) ;
           rec.setDepartmentName( result.getString("Department_name"));
           rec.setBatchYear ( result.getInt("Batch_year"));
           rec.setStudentName (result.getString("student_name")) ;
           rec.setRollNo (result.getString("roll_no"));
       vec.addElement(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addbook_issue(int catDetailId, java.util.Date dateOfIssue, java.util.Date dateOfReturn, int fineAmount, String remarks, String departmentName, int batchYear, String studentName, String rollNo)throws  Exception{


     
   String query = "INSERT INTO book_issue(cat_detail_id, date_of_issue, date_of_return, fine_amount, remarks, Department_name, Batch_year, student_name, roll_no) VALUES ("+catDetailId+", '"+(dateOfIssue.getDate()+"/"+(1+dateOfIssue.getMonth())+"/"+(dateOfIssue.getYear()+1900))+"', '"+(dateOfReturn.getDate()+"/"+(1+dateOfReturn.getMonth())+"/"+(dateOfReturn.getYear()+1900))+"', "+fineAmount+", '"+remarks+"', '"+departmentName+"', "+batchYear+", '"+studentName+"', '"+rollNo+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updatebook_issue(int issueId, int catDetailId, java.util.Date dateOfIssue, java.util.Date dateOfReturn, int fineAmount, String remarks, String departmentName, int batchYear, String studentName, String rollNo)throws  Exception{     

   String query = "UPDATE book_issue SET cat_detail_id="+catDetailId+", date_of_issue='"+(dateOfIssue.getDate()+"/"+(1+dateOfIssue.getMonth())+"/"+(dateOfIssue.getYear()+1900))+"', date_of_return='"+(dateOfReturn.getDate()+"/"+(1+dateOfReturn.getMonth())+"/"+(dateOfReturn.getYear()+1900))+"', fine_amount="+fineAmount+", remarks='"+remarks+"', Department_name='"+departmentName+"', Batch_year="+batchYear+", student_name='"+studentName+"', roll_no='"+rollNo+"' WHERE issue_id="+issueId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deletebook_issue(int issueId)throws  Exception{
     
   String query = "DELETE FROM book_issue WHERE issue_id="+issueId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of category_detial table----------------
public static java.util.Vector getAllcategory_detial()throws  Exception{

     
 String query = "SELECT cat_detail_id, name, publisher, author, Edition, Volume, year_of_publishing, isbn, access_no, Dras_no, prise, purchase_from, date_of_purchase, remarks FROM category_detial";
      System.out.println(query);
      java.util.Vector vec = new java.util.Vector();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       CategoryDetialBean rec = new CategoryDetialBean();
           rec.setCatDetailId( result.getInt("cat_detail_id"));
           rec.setName (result.getString("name")) ;
           rec.setPublisher( result.getString("publisher"));
           rec.setAuthor (result.getString("author")) ;
           rec.setEdition ( result.getString("Edition"));
           rec.setVolume(result.getString("Volume"));
           rec.setYearOfPublishing( result.getInt("year_of_publishing"));
           rec.setIsbn (result.getString("isbn")) ;
           rec.setAccessNo ( result.getString("access_no"));
           rec.setDrasNo (result.getString("Dras_no")) ;
           rec.setPrise ( result.getInt("prise"));
           rec.setPurchaseFrom (result.getString("purchase_from"));
           rec.setDateOfPurchase (result.getDate("date_of_purchase"));
           rec.setRemarks (result.getString("remarks"));
       vec.addElement(rec);
      }//end of while

     st.close();

     return vec;

   }

public static CategoryDetialBean getCategory_detail(int catId)throws Exception{
    String query = "SELECT  *  from category_detial where cat_detail_id = "+catId;
    System.out.println(query);
    CategoryDetialBean rec = new CategoryDetialBean();
    java.sql.Statement st = connection.createStatement();
    ResultSet result  = st.executeQuery(query);
    if(result.next()){
           rec.setCatDetailId( result.getInt("cat_detail_id"));
           rec.setName (result.getString("name")) ;
           rec.setPublisher( result.getString("publisher"));
           rec.setAuthor (result.getString("author")) ;
           rec.setEdition ( result.getString("Edition"));
           rec.setVolume(result.getString("Volume"));
           rec.setYearOfPublishing( result.getInt("year_of_publishing"));
           rec.setIsbn (result.getString("isbn")) ;
           rec.setAccessNo ( result.getString("access_no"));
           rec.setDrasNo (result.getString("Dras_no")) ;
           rec.setPrise ( result.getInt("prise"));
           rec.setPurchaseFrom (result.getString("purchase_from"));
           rec.setDateOfPurchase (result.getDate("date_of_purchase"));
           rec.setRemarks (result.getString("remarks"));
      }//end of while
    return rec;
}

public static void addcategory_detial(String name, String publisher, String author, String edition, String volume, int yearOfPublishing, String isbn, String accessNo, String drasNo, int prise, String purchaseFrom, java.util.Date dateOfPurchase, String remarks)throws  Exception{


     
   String query = "INSERT INTO category_detial(name, publisher, author, Edition, Volume, year_of_publishing, isbn, access_no, Dras_no, prise, purchase_from, date_of_purchase, remarks) VALUES ('"+name+"', '"+publisher+"', '"+author+"', '"+edition+"', '"+volume+"', "+yearOfPublishing+", '"+isbn+"', '"+accessNo+"', '"+drasNo+"', "+prise+", '"+purchaseFrom+"', '"+(dateOfPurchase.getDate()+"/"+(1+dateOfPurchase.getMonth())+"/"+(dateOfPurchase.getYear()+1900))+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updatecategory_detial(int catDetailId, String name, String publisher, String author, String edition, String volume, int yearOfPublishing, String isbn, String accessNo, String drasNo, int prise, String purchaseFrom, java.util.Date dateOfPurchase, String remarks)throws  Exception{     

   String query = "UPDATE category_detial SET name='"+name+"', publisher='"+publisher+"', author='"+author+"', Edition='"+edition+"', Volume='"+volume+"', year_of_publishing="+yearOfPublishing+", isbn='"+isbn+"', access_no='"+accessNo+"', Dras_no='"+drasNo+"', prise="+prise+", purchase_from='"+purchaseFrom+"', date_of_purchase= '"+(dateOfPurchase.getDate()+"/"+(1+dateOfPurchase.getMonth())+"/"+(dateOfPurchase.getYear()+1900))+"' , remarks='"+remarks+"' WHERE cat_detail_id="+catDetailId;

      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deletecategory_detial(int catDetailId)throws  Exception{
     
   String query = "DELETE FROM category_detial WHERE cat_detail_id="+catDetailId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


}
