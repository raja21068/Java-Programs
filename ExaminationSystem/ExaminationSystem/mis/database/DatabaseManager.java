package database;
// ** author @Jay K  ** 

import bean.BatchBean;
import bean.CertificateBean;
import bean.CheckingBean;
import bean.ProgramBean;
import bean.ScratchCardBean;
import bean.StudentBean;
import bean.TransationBean;
import java.util.*; 
import java.sql.ResultSet;
import java.sql.Statement;

class DatabaseManager{
    static java.sql.Connection connection;
    static{
        try{
             Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system");
        } catch(Exception e){ e.printStackTrace(); }
    }
    // batch methods
    public static ArrayList getAllBatch()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from batch";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            BatchBean bean = new BatchBean();
            bean.setBatchId(rs.getInt("BATCH_ID") );
            bean.setProgId(rs.getInt("PROG_ID") );
            bean.setYear(rs.getString("YEAR") );
            bean.setShift(rs.getString("SHIFT") );
            bean.setGroupDesc(rs.getString("GROUP_DESC") );
            bean.setRemarks(rs.getString("REMARKS") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addBatch(int progId, String year, String shift, String groupDesc, String remarks)throws Exception{
        String query = "Insert into batch (PROG_ID, YEAR, SHIFT, GROUP_DESC, REMARKS) values ('"+progId+"', '"+year+"', '"+shift+"', '"+groupDesc+"', '"+remarks+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteBatch(int batchId)throws Exception{
        String query = "DELETE from batch WHERE BATCH_ID = "+batchId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateBatch(int batchId, int progId, String year, String shift, String groupDesc, String remarks)throws Exception{

        String query = "UPDATE batch SET PROG_ID = '"+progId+"', YEAR = '"+year+"', SHIFT = '"+shift+"', GROUP_DESC = '"+groupDesc+"', REMARKS = '"+remarks+"' WHERE BATCH_ID ="+ batchId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // certificate methods
    public static ArrayList getAllCertificate()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from certificate";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            CertificateBean bean = new CertificateBean();
            bean.setCertificateId(rs.getInt("CERTIFICATE_ID") );
            bean.setCertificateName(rs.getString("CERTIFICATE_NAME") );
            bean.setRate(rs.getInt("RATE") );
            bean.setRemarks(rs.getString("REMARKS") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addCertificate(String certificateName, int rate, String remarks)throws Exception{
        String query = "Insert into certificate (CERTIFICATE_NAME, RATE, REMARKS) values ('"+certificateName+"', '"+rate+"', '"+remarks+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteCertificate(int certificateId)throws Exception{
        String query = "DELETE from certificate WHERE CERTIFICATE_ID = "+certificateId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateCertificate(int certificateId, String certificateName, int rate, String remarks)throws Exception{

        String query = "UPDATE certificate SET CERTIFICATE_NAME = '"+certificateName+"', RATE = '"+rate+"', REMARKS = '"+remarks+"' WHERE CERTIFICATE_ID ="+ certificateId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // checking methods
    public static ArrayList getAllChecking()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from checking";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            CheckingBean bean = new CheckingBean();
            bean.setCheackingId(rs.getInt("CHEACKING_ID") );
            bean.setTransationId(rs.getInt("TRANSATION_ID") );
            bean.setDateOfCheacking(rs.getDate("DATE_OF_CHEACKING") );
            bean.setRemarks(rs.getString("REMARKS") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addChecking(int transationId, Date dateOfCheacking, String remarks)throws Exception{
        String query = "Insert into checking (TRANSATION_ID, DATE_OF_CHEACKING, REMARKS) values ('"+transationId+"', '"+dateOfCheacking+"', '"+remarks+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteChecking(int cheackingId)throws Exception{
        String query = "DELETE from checking WHERE CHEACKING_ID = "+cheackingId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateChecking(int cheackingId, int transationId, Date dateOfCheacking, String remarks)throws Exception{

        String query = "UPDATE checking SET TRANSATION_ID = '"+transationId+"', DATE_OF_CHEACKING = '"+dateOfCheacking+"', REMARKS = '"+remarks+"' WHERE CHEACKING_ID ="+ cheackingId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // program methods
    public static ArrayList getAllProgram()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from program";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            ProgramBean bean = new ProgramBean();
            bean.setProgId(rs.getInt("PROG_ID") );
            bean.setProgramTitle(rs.getString("PROGRAM_TITLE") );
            bean.setSemDuration(rs.getInt("SEM_DURATION") );
            bean.setRemarks(rs.getString("REMARKS") );
            bean.setDegreeTitle(rs.getString("DEGREE_TITLE") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addProgram(String programTitle, int semDuration, String remarks, String degreeTitle)throws Exception{
        String query = "Insert into program (PROGRAM_TITLE, SEM_DURATION, REMARKS, DEGREE_TITLE) values ('"+programTitle+"', '"+semDuration+"', '"+remarks+"', '"+degreeTitle+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteProgram(int progId)throws Exception{
        String query = "DELETE from program WHERE PROG_ID = "+progId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateProgram(int progId, String programTitle, int semDuration, String remarks, String degreeTitle)throws Exception{

        String query = "UPDATE program SET PROGRAM_TITLE = '"+programTitle+"', SEM_DURATION = '"+semDuration+"', REMARKS = '"+remarks+"', DEGREE_TITLE = '"+degreeTitle+"' WHERE PROG_ID ="+ progId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // scratch_card methods
    public static ArrayList getAllScratchCard()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from scratch_card";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            ScratchCardBean bean = new ScratchCardBean();
            bean.setScratchCardId(rs.getInt("SCRATCH_CARD_ID") );
            bean.setScratchCardNo(rs.getString("SCRATCH_CARD_NO") );
            bean.setAmount(rs.getInt("AMOUNT") );
            bean.setDateOfCreate(rs.getDate("DATE_OF_CREATE") );
            bean.setDateOfExpire(rs.getDate("DATE_OF_EXPIRE") );
            bean.setDateOfUsed(rs.getDate("DATE_OF_USED") );
            bean.setRemarks(rs.getString("REMARKS") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addScratchCard(String scratchCardNo, int amount, Date dateOfCreate, Date dateOfExpire, Date dateOfUsed, String remarks)throws Exception{
        String query = "Insert into scratch_card (SCRATCH_CARD_NO, AMOUNT, DATE_OF_CREATE, DATE_OF_EXPIRE, DATE_OF_USED, REMARKS) values ('"+scratchCardNo+"', '"+amount+"', '"+dateOfCreate+"', '"+dateOfExpire+"', '"+dateOfUsed+"', '"+remarks+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteScratchCard(int scratchCardId)throws Exception{
        String query = "DELETE from scratch_card WHERE SCRATCH_CARD_ID = "+scratchCardId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateScratchCard(int scratchCardId, String scratchCardNo, int amount, Date dateOfCreate, Date dateOfExpire, Date dateOfUsed, String remarks)throws Exception{

        String query = "UPDATE scratch_card SET SCRATCH_CARD_NO = '"+scratchCardNo+"', AMOUNT = '"+amount+"', DATE_OF_CREATE = '"+dateOfCreate+"', DATE_OF_EXPIRE = '"+dateOfExpire+"', DATE_OF_USED = '"+dateOfUsed+"', REMARKS = '"+remarks+"' WHERE SCRATCH_CARD_ID ="+ scratchCardId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // student methods
    public static ArrayList getAllStudent()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from student";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            StudentBean bean = new StudentBean();
            bean.setBatchId(rs.getInt("BATCH_ID") );
            bean.setRollNo(rs.getString("ROLL_NO") );
            bean.setName(rs.getString("NAME") );
            bean.setFname(rs.getString("FNAME") );
            bean.setSurname(rs.getString("SURNAME") );
            bean.setGender(rs.getString("GENDER") );
            bean.setCell(rs.getString("CELL") );
            bean.setPhone(rs.getString("PHONE") );
            bean.setHomeAddress(rs.getString("HOME_ADDRESS") );
            bean.setPermanentAddress(rs.getString("PERMANENT_ADDRESS") );
            bean.setStudentId(rs.getInt("STUDENT_ID") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addStudent(int batchId, String rollNo, String name, String fname, String surname, String gender, String cell, String phone, String homeAddress, String permanentAddress)throws Exception{
        String query = "Insert into student (BATCH_ID, ROLL_NO, NAME, FNAME, SURNAME, GENDER, CELL, PHONE, HOME_ADDRESS, PERMANENT_ADDRESS ) values ('"+batchId+"', '"+rollNo+"', '"+name+"', '"+fname+"', '"+surname+"', '"+gender+"', '"+cell+"', '"+phone+"', '"+homeAddress+"', '"+permanentAddress+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteStudent(int studentId)throws Exception{
        String query = "DELETE from student WHERE STUDENT_ID = "+studentId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateStudent(int batchId, String rollNo, String name, String fname, String surname, String gender, String cell, String phone, String homeAddress, String permanentAddress, int studentId)throws Exception{

        String query = "UPDATE student SET BATCH_ID = '"+batchId+"', ROLL_NO = '"+rollNo+"', NAME = '"+name+"', FNAME = '"+fname+"', SURNAME = '"+surname+"', GENDER = '"+gender+"', CELL = '"+cell+"', PHONE = '"+phone+"', HOME_ADDRESS = '"+homeAddress+"', PERMANENT_ADDRESS = '"+permanentAddress+"',  WHERE STUDENT_ID ="+ studentId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    // transation methods
    public static ArrayList getAllTransation()throws Exception{
        ArrayList list = new ArrayList();
        String query="SELECT * from transation";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            TransationBean bean = new TransationBean();
            bean.setStudentId(rs.getInt("STUDENT_ID") );
            bean.setTransationId(rs.getInt("TRANSATION_ID") );
            bean.setTransationDate(rs.getDate("TRANSATION_DATE") );
            bean.setCertifacateId(rs.getInt("CERTIFACATE_ID") );
            bean.setDateOfRecieve(rs.getDate("DATE_OF_RECIEVE") );
            bean.setRemarks(rs.getString("REMARKS") );
            list.add(bean);

        }

        st.close();

        return list;

    }

    public static int addTransation(int studentId, Date transationDate, int certifacateId, Date dateOfRecieve, String remarks)throws Exception{
        String query = "Insert into transation (STUDENT_ID, TRANSATION_DATE, CERTIFACATE_ID, DATE_OF_RECIEVE, REMARKS) values ('"+studentId+"', '"+transationDate+"', '"+certifacateId+"', '"+dateOfRecieve+"', '"+remarks+"')";
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        st.close();
        return r;
    }
    public static int deleteTransation(int transationId)throws Exception{
        String query = "DELETE from transation WHERE TRANSATION_ID = "+transationId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
    public static int updateTransation(int studentId, int transationId, Date transationDate, int certifacateId, Date dateOfRecieve, String remarks)throws Exception{

        String query = "UPDATE transation SET STUDENT_ID = '"+studentId+"', TRANSATION_DATE = '"+transationDate+"', CERTIFACATE_ID = '"+certifacateId+"', DATE_OF_RECIEVE = '"+dateOfRecieve+"', REMARKS = '"+remarks+"' WHERE TRANSATION_ID ="+ transationId;
        Statement st = connection.createStatement();
        int r = st.executeUpdate(query);
        return r;
    }
}//end of class
