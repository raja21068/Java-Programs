import java.sql.*;
import java.util.ArrayList;

class DatabaseManager{

    static java.sql.Connection connection;
    static{
    try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = java.sql.DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=database/ClinicData.mdb");
    } catch(Exception e){ e.printStackTrace(); }
    }

    //----------------Queries of Day table----------------
public static java.util.ArrayList getAllDay(int yearId)throws  Exception{

      String query = "SELECT * FROM Day Where year_id="+yearId;
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       DayBean rec = new DayBean();
           rec.setYearId(result.getInt("year_id"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDay(result.getDate("day"));
           rec.setClosed(result.getBoolean("closed"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }
public static java.util.ArrayList getAllUnclosedDay()throws  Exception{

      String query = "SELECT * FROM Day Where closed=false";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       DayBean rec = new DayBean();
           rec.setYearId(result.getInt("year_id"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDay(result.getDate("day"));
           rec.setClosed(result.getBoolean("closed"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static DayBean getMaxDay()throws Exception{
    String query="SELECT * from Day where day=(SELECT MAX(day) from Day)";
    DayBean bean = null;
    System.out.println(query);
    java.util.ArrayList vec = new java.util.ArrayList();
    java.sql.Statement st = connection.createStatement();
    ResultSet result = st.executeQuery(query);
    if(result.next()){  
        bean = new DayBean();
        bean.setYearId(result.getInt("year_id"));
        bean.setDayId(result.getInt("day_id"));
        bean.setDay(result.getDate("day"));
        bean.setClosed(result.getBoolean("closed"));
        bean.setRemarks(result.getString("remarks"));
    }        
    return bean;
}


public static void addDay(int yearId,String day, boolean closed, String remarks)throws  Exception{

    String query = "INSERT INTO Day(year_id , day, closed, remarks) VALUES ("+yearId+",#"+day+"#, "+closed+", '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateDay(int yearId ,int dayId, String day, boolean closed, String remarks)throws  Exception{     

   String query = "UPDATE Day SET year_id="+yearId+", day=#"+day+"#, closed="+closed+", remarks='"+remarks+"' WHERE day_id="+dayId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteDay(int dayId)throws  Exception{
     
   String query = "DELETE FROM Day WHERE day_id="+dayId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Doctors table----------------
public static java.util.ArrayList getAllDoctors()throws  Exception{

     
 String query = "SELECT doctor_id, doctor_name, remarks FROM Doctors";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       DoctorsBean rec = new DoctorsBean();
           rec.setDoctorId(result.getInt("doctor_id"));
           rec.setDoctorName(result.getString("doctor_name"));
           rec.setRemarks(result.getString("remarks"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static void addDoctors(String doctorName, String remarks)throws  Exception{


     
   String query = "INSERT INTO Doctors(doctor_name, remarks) VALUES ('"+doctorName+"', '"+remarks+"')";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static void updateDoctors(int doctorId, String doctorName, String remarks)throws  Exception{     

   String query = "UPDATE Doctors SET doctor_name='"+doctorName+"', remarks='"+remarks+"' WHERE doctor_id="+doctorId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteDoctors(int doctorId)throws  Exception{
     
   String query = "DELETE FROM Doctors WHERE doctor_id="+doctorId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


//----------------Queries of Transaction table----------------
public static java.util.ArrayList getAllTransaction()throws  Exception{
     
 String query = "SELECT transaction_id, day_id, doctor_id, patient_name, dispancy, disease, dignosic, lab, payment FROM Transaction";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       TransactionBean rec = new TransactionBean();
           rec.setTransactionId(result.getInt("transaction_id"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDoctorId(result.getInt("doctor_id"));
           rec.setPatientName(result.getString("patient_name"));
           rec.setDispancy(result.getString("dispancy"));
           rec.setDisease(result.getString("disease"));
           rec.setDignosic(result.getString("dignosic"));
           rec.setLab(result.getString("lab"));
           rec.setPayment(result.getInt("payment"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }
public static java.util.ArrayList getAllTransaction(int dayId)throws  Exception{
     
// String query = "SELECT transaction_id, day_id, doctor_id, patient_name, dispancy, disease, dignosic, lab, payment FROM Transaction Where day_id="+dayId;
 String query = "SELECT * from doctors d, transaction t where t.day_id="+dayId+" AND t.doctor_id=d.doctor_id;";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       PatientBean rec = new PatientBean();
           rec.setTransactionId(result.getInt("transaction_id"));
           rec.setDoctorName(result.getString("doctor_name"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDoctorId(result.getInt("doctor_id"));
           rec.setPatientName(result.getString("patient_name"));
           rec.setDispancy(result.getString("dispancy"));
           rec.setDisease(result.getString("disease"));
           rec.setDignosic(result.getString("dignosic"));
           rec.setLab(result.getString("lab"));
           rec.setPayment(result.getInt("payment"));
       vec.add(rec);
      }//end of while

     st.close();

     return vec;

   }

public static int addTransaction(int dayId, int doctorId, String patientName, String dispancy, String disease, String dignosic, String lab, int payment)throws  Exception{

   String query = "INSERT INTO Transaction(day_id, doctor_id, patient_name, dispancy, disease, dignosic, lab, payment) VALUES ("+dayId+", "+doctorId+", '"+patientName+"', '"+dispancy+"', '"+disease+"', '"+dignosic+"', '"+lab+"', "+payment+")";
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      
      query="SELECT MAX(transaction_id) from Transaction";
      ResultSet result = st.executeQuery(query);
      int id=0;
      if(result.next()){
          id = result.getInt(1);
      }
      System.out.println("Transaction Id: "+id);
      return id;
}

public static void updateTransaction(int transactionId, int dayId, int doctorId, String patientName, String dispancy, String disease, String dignosic, String lab, int payment)throws  Exception{     

   String query = "UPDATE Transaction SET day_id="+dayId+", doctor_id="+doctorId+", patient_name='"+patientName+"', dispancy='"+dispancy+"', disease='"+disease+"', dignosic='"+dignosic+"', lab='"+lab+"', payment="+payment+" WHERE transaction_id="+transactionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }


public static void deleteTransaction(int transactionId)throws  Exception{
     
   String query = "DELETE FROM Transaction WHERE transaction_id="+transactionId;
      System.out.println(query);
      java.sql.Statement st = connection.createStatement();
      st.executeUpdate(query);
      }

public static ArrayList getYears()throws Exception{
        String sql = "SELECT * from years ORDER by year_name DESC";
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(sql);
        ArrayList<YearBean> list = new ArrayList();
        while(result.next()){
            YearBean bean = new YearBean();
            bean.setYearId(result.getInt("year_id"));
            bean.setYear(result.getInt("year_name"));
            bean.setRemarks(result.getString("remarks"));
            list.add(bean);
        }
        return list;
    }

public static int addYear(int year, String remarks)throws Exception{
        String sql = "INSERT into years (year_name , remarks) values ( "+year+" , '"+remarks+"' ) ";
        System.out.println(sql);
        Statement st = connection.createStatement();
        int result = st.executeUpdate(sql);
        
        return result;
 }
public static int updateYear(int yearId ,int year, String remarks)throws Exception{
        String sql = "Update years SET  year_name = "+year+" ,  remarks = '"+remarks+"'  where year_id = "+yearId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
public static int deleteYear(int id)throws Exception{
        String sql = "DELETE from years where year_id = "+id;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int result = st.executeUpdate(sql);
        return result;
    }
public static ArrayList getPatientsSummary(String date , String toDate)throws Exception{
String query = "SELECT * from doctors d, transaction t,day dt where dt.day BETWEEN #"+date+"# AND #"+toDate+"# AND t.doctor_id=d.doctor_id AND dt.day_id=t.day_id";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
       PatientBean rec = new PatientBean();
           rec.setDate(result.getDate("day"));
           rec.setTransactionId(result.getInt("transaction_id"));
           rec.setDoctorName(result.getString("doctor_name"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDoctorId(result.getInt("doctor_id"));
           rec.setPatientName(result.getString("patient_name"));
           rec.setDispancy(result.getString("dispancy"));
           rec.setDisease(result.getString("disease"));
           rec.setDignosic(result.getString("dignosic"));
           rec.setLab(result.getString("lab"));
           rec.setPayment(result.getInt("payment"));
       vec.add(rec);
      }//end of while
     System.out.println(vec.size()+" summuries have been fetched...");
     st.close();
     return vec;

}
public static ArrayList getPatientsSummary(String patientName)throws Exception{
String query = "SELECT * from doctors d, transaction t,day dt where t.patient_name like '%"+patientName+"%' AND t.doctor_id=d.doctor_id AND dt.day_id=t.day_id";
      System.out.println(query);
      java.util.ArrayList vec = new java.util.ArrayList();
      java.sql.Statement st = connection.createStatement();
      ResultSet result = st.executeQuery(query);
      while(result.next()){
           PatientBean rec = new PatientBean();
           rec.setDate(result.getDate("day"));
           rec.setTransactionId(result.getInt("transaction_id"));
           rec.setDoctorName(result.getString("doctor_name"));
           rec.setDayId(result.getInt("day_id"));
           rec.setDoctorId(result.getInt("doctor_id"));
           rec.setPatientName(result.getString("patient_name"));
           rec.setDispancy(result.getString("dispancy"));
           rec.setDisease(result.getString("disease"));
           rec.setDignosic(result.getString("dignosic"));
           rec.setLab(result.getString("lab"));
           rec.setPayment(result.getInt("payment"));
       vec.add(rec);
      }//end of while
     System.out.println(vec.size()+" summuries have been fetched...");
     st.close();
     return vec;

}

}
