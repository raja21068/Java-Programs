import java.sql.*;

class DatabaseManager{

static java.sql.Connection connection;
  static{
   try{
     Class.forName("com.mysql.jdbc.Driver");
     // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/examdata","root","");
     // connection = java.sql.DriverManager.getConnection("jdbc:odbc:examdata");
     
	 } catch(Exception e){ e.printStackTrace(); }
  }
//----------------Queries of Options table----------------
public static java.util.ArrayList getAllOptions(int questionId)throws  Exception{

     
	String query = "SELECT option_id, question_id, option_name, correct, remarks FROM Options where question_id="+questionId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       OptionsBean rec = new OptionsBean();
           rec.setOptionId(result.getInt("option_id"));
           rec.setQuestionId(result.getInt("question_id"));
           rec.setOptionName(result.getString("option_name"));
           rec.setCorrect(result.getString("correct"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addOptions(int questionId, String optionName, String correct, String remarks)throws  Exception{


     
   String query = "INSERT INTO Options(question_id, option_name, correct, remarks) VALUES ("+questionId+", '"+optionName+"', '"+correct+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateOptions(int optionId, int questionId, String optionName, String correct, String remarks)throws  Exception{     

   String query = "UPDATE Options SET question_id="+questionId+", option_name='"+optionName+"', correct='"+correct+"', remarks='"+remarks+"' WHERE option_id="+optionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteOptions(int optionId)throws  Exception{
     
   String query = "DELETE FROM Options WHERE option_id="+optionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Questions table----------------
public static java.util.ArrayList getAllQuestions(int subId)throws  Exception{

     
 String query = "SELECT question_id, sub_id, questions, remarks FROM Questions where sub_id="+subId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       QuestionsBean rec = new QuestionsBean();
           rec.setQuestionId(result.getInt("question_id"));
           rec.setSubId(result.getInt("sub_id"));
           rec.setQuestions(result.getString("questions"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();
	
	 System.out.println(vec.size()+" questions is fetched..");
     return vec;

   }

public static void addQuestions(int subId, String questions, String remarks)throws  Exception{


     
	  String query = "INSERT INTO Questions(sub_id, questions, remarks) VALUES ("+subId+", '"+questions+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateQuestions(int questionId, int subId, String questions, String remarks)throws  Exception{     

   String query = "UPDATE Questions SET sub_id="+subId+", questions='"+questions+"', remarks='"+remarks+"' WHERE question_id="+questionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteQuestions(int questionId)throws  Exception{
     
   String query = "DELETE FROM Questions WHERE question_id="+questionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Subjects table----------------
public static java.util.ArrayList getAllSubjects()throws  Exception{

     
 String query = "SELECT sub_id, sub_name, remarks FROM Subjects";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       SubjectsBean rec = new SubjectsBean();
           rec.setSubId(result.getInt("sub_id"));
           rec.setSubName(result.getString("sub_name"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addSubjects(String subName, String remarks)throws  Exception{


     
	  String query = "INSERT INTO Subjects(sub_name, remarks) VALUES ('"+subName+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
	  System.out.println("\nstatement:"+st+"\n connection:"+connection);
      st.executeUpdate(query);
      }

public static void updateSubjects(int subId, String subName, String remarks)throws  Exception{     

   String query = "UPDATE Subjects SET sub_name='"+subName+"', remarks='"+remarks+"' WHERE sub_id="+subId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteSubjects(int subId)throws  Exception{
     
   String query = "DELETE FROM Subjects WHERE sub_id="+subId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static int getCorrectOptionId(int questionId)throws Exception{
	String query="SELECT * from options where question_id="+questionId+" AND correct='C'";
	System.out.println(query);
    java.sql.Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery(query);
	int id  =0 ;
	if(rs.next()){
			id = rs.getInt("option_id");
	}
	System.out.println("Got the id from database "+id);
	return id;
}
}
