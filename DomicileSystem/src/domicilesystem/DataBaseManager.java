/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domicilesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Jetander
 */
public class DataBaseManager {
    static Connection con;
    static Statement st;
    static ResultSet rs ;
    
    
    //************************Conection************************
    static{
        try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\Database\\DomicileManagSys.mdb");
        if(con==null){
        System.out.println("connection not established..........");
        }
        } catch(ClassNotFoundException | SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }    
    }// static block
   
    public static Vector login() throws SQLException{
        String query = "select * from User";
        System.out.println(query);
        if(con==null){System.out.println("conection failed"); return null;}
        try{ 
            st = con.createStatement();
            rs = st.executeQuery(query);
        }catch(Exception e){}
        Vector v = new Vector();
        while(rs.next()){
            System.out.println("database loop");
            LoginBean bean = new LoginBean();
            bean.setId(rs.getInt("user_id"));
            bean.setUser(rs.getString("user_name"));
            bean.setPassword(rs.getString("user_password"));
            v.add(bean);
        }
        System.out.println("vector size in database manager:    "+v.size());
        rs.close();
        st.close();
        return v;
    }
    
    public static Vector getDataEntry() throws SQLException{
        String query = "SELECT * FROM Entry";
        System.out.println(query);
        if(con == null){
            System.out.println("Connection faild"); 
            return null;
        }
        try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        }catch(Exception e){e.printStackTrace();}
        
        Vector v = new Vector();
        while(rs.next()){
            DataEntryBean bean = new DataEntryBean();
            bean.setFormNo(rs.getInt("form_no"));
            bean.setId(rs.getInt("applicant_id"));
            bean.setName(rs.getString("applicant_name"));
            bean.setFather(rs.getString("father_name"));
            bean.setGender(rs.getString("gender"));
            bean.setReligion(rs.getString("religion"));
            bean.setCnicNo(rs.getString("cnic_no"));
            bean.setDateOfBirth(rs.getString("date_of_birth"));
            bean.setPlaceOfBirth(rs.getString("place_of_birth"));
            bean.setEducatedAt(rs.getString("educated_at"));
            bean.setPresAdres(rs.getString("present_adress"));
            bean.setPermAdres(rs.getString("permanant_adress"));
            bean.setOutsideAdres(rs.getString("outside_adress"));
            bean.setOccupation(rs.getString("place_of_Domicile"));
            bean.setProvince(rs.getString("province"));
            bean.setTaluka(rs.getString("taluka"));
            bean.setDateOfArrival(rs.getString("date_of_arrival"));
            bean.setWifeHusbandName(rs.getString("name_of_wife_husband"));
            bean.setStatus(rs.getString("occupation"));
            bean.setQualification(rs.getString("qualification"));
            bean.setIdentification(rs.getString("identification"));
            v.add(bean);
        }
        rs.close();
        st.close();
        return v;

        
    }
    public static Vector searDataEntry(int applicantId) throws SQLException{
        String query = "SELECT * FROM Entry where applicant_id="+applicantId;
        System.out.println(query);
        if(con == null){
            System.out.println("Connection faild"); 
            return null;
        }
        try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        }catch(Exception e){e.printStackTrace();}
        
        Vector v = new Vector();
        while(rs.next()){
            DataEntryBean bean = new DataEntryBean();
            bean.setFormNo(rs.getInt("form_no"));
            bean.setId(rs.getInt("applicant_id"));
            bean.setName(rs.getString("applicant_name"));
            bean.setFather(rs.getString("father_name"));
            bean.setGender(rs.getString("gender"));
            bean.setReligion(rs.getString("religion"));
            bean.setCnicNo(rs.getString("cnic_no"));
            bean.setDateOfBirth(rs.getString("date_of_birth"));
            bean.setPlaceOfBirth(rs.getString("place_of_birth"));
            bean.setEducatedAt(rs.getString("educated_at"));
            bean.setPresAdres(rs.getString("present_adress"));
            bean.setPermAdres(rs.getString("permanant_adress"));
            bean.setOutsideAdres(rs.getString("outside_adress"));
            bean.setOccupation(rs.getString("place_of_Domicile"));
            bean.setProvince(rs.getString("province"));
            bean.setTaluka(rs.getString("taluka"));
            bean.setDateOfArrival(rs.getString("date_of_arrival"));
            bean.setWifeHusbandName(rs.getString("name_of_wife_husband"));
            bean.setStatus(rs.getString("occupation"));
            bean.setQualification(rs.getString("qualification"));
            bean.setIdentification(rs.getString("identification"));
            v.add(bean);
        }
        rs.close();
        st.close();
        return v;

        
    }
    
    public static int addDataEntry(int id, String name, String father, String gender, String religion, String cnicno, String dateOfBirth, String placeOfBirth,String placeOfDomicile, String educatedAt, String presAdres, String permAdres,String outsideAdres, String taluka,  String province, String dateOfArrival, String status, String husbandWifeName,String occupation, String qualification, String identification ) throws Exception {
        String query = "INSERT INTO Entry(applicant_id, applicant_name, father_name, gender, religion, cnic_no, date_of_Birth, place_of_birth,place_of_domicile, educated_at, present_adress, permanant_adress, outside_adress, taluka, province, date_of_arrival, status, name_of_wife_husband,occupation, qualification,identification) VALUES("+id+",'"+name+"','"+father+"','" + gender + "','" + religion + "','" + cnicno + "','" + dateOfBirth + "','" + placeOfBirth + "','"+placeOfDomicile+"','" + educatedAt + "','" + presAdres + "','" + permAdres + "','" + outsideAdres + "','" + taluka + "','" + province + "','" +dateOfArrival + "','" + status + "','" + husbandWifeName + "','" + occupation + "','" + qualification + "','" + identification + "')";
        System.out.println(query);
        st = con.createStatement();
        int rows = st.executeUpdate(query);
        st.close();
        return rows;
    }

    public static int updateDataEntry(int formId, int id, String name, String father,String gender, String religion, String cnicno, String dateOfBirth, String placeOfBirth,String placeOfDomicile, String educatedAt, String presAdres, String permAdres,String outsideAdres, String taluka,  String province, String dateOfArrival, String status, String husbandWifeName,String occupation, String qualification, String identification) throws SQLException {
        String query = "UPDATE Entry SET applicant_id = "+id+",applicant_name='" + name + "',father_name='" + father + "', gender='" + gender + "' ,religion='" + religion + "' ,cnic_no='" +cnicno+ "' ,date_of_birth='" +dateOfBirth+ "',place_of_birth='" +placeOfBirth+ "',place_of_domicile='" +placeOfDomicile+ "',educated_at='" +educatedAt+ "',present_adress='" +presAdres+ "',permanant_adress='" +permAdres+ "',outside_adress='" +outsideAdres+ "',taluka='" +taluka+ "',province='" +province+ "',date_of_arrival='" +dateOfArrival+ "',status='" +status+ "',name_of_wife_husband='" +husbandWifeName+ "',occupation='" +occupation+ "',qualification='" +qualification+ "',identification='" +identification+ "' where form_no =" + formId;
        System.out.println(query);
        st = con.createStatement();
        int rows = st.executeUpdate(query);
        st.close();
        return rows;
}
    
    public static int deleteDataEntry(int formId) throws Exception {
        String query = "DELETE  FROM Entry WHERE form_no=" + formId;
        System.out.println(query);
        st = con.createStatement();
        int rows = st.executeUpdate(query);
        st.close();
        return rows;

    }
   
    
    public static Vector getChild()throws Exception {
    String query = "SELECT * FROM Child";
    System.out.println(query);
        try{
        st = con.createStatement();
        rs=st.executeQuery(query);
        }catch(Exception e){}
        Vector v = new Vector();
        while(rs.next()){
            ChildBean bean = new ChildBean();
            bean.setId(rs.getInt("child_id"));
            bean.setFormId(rs.getInt("form_no"));
            bean.setName(rs.getString("child_name"));
            bean.setAge(rs.getInt("age"));
            bean.setRemarks(rs.getString("remarks"));  
            v.add(bean);
        }
        rs.close();
        st.close();
    return v;
    }   
    
    public static int addChild(int formNo, String name, int age, String remarks) throws Exception {
        String query = "INSERT INTO Child(form_no, child_name, age, remarks) VALUES(" + formNo + ",'" + name + "'," + age + ",'" + remarks + "')";
        System.out.println(query);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);
        st.close();
        return rows;
    }

    public static int updateChild(int childId, int formNo, String name, int age, String remarks) throws Exception {

        String query = "UPDATE Child SET form_no="+formNo+",child_name='" + name + "',age="+ age+",remarks='" + remarks + "' Where child_ID =" + childId;
        System.out.println(query);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);
        st.close();
        return rows;
    }

    public static int deleteChild(int childId) throws Exception {
        String query = "DELETE  From Child WHERE child_id=" + childId;
        System.out.println(query);
        int rows;
        Statement st = con.createStatement();
        rows = st.executeUpdate(query);

        st.close();
        return rows;

    }
}
