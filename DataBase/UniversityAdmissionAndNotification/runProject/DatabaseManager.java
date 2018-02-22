import java.sql.*;
import java.util.*;
/**
 * @author Jay Kumar
 */
public class DatabaseManager {
   private static Connection connection;
    static {
        try{
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=UniOfSindh.mdb");
        }catch(Exception e){e.printStackTrace();}
   } 
    public static Vector getAllFaculty()throws Exception{
        Vector vec= new Vector();
        ArrayList array = new ArrayList();
        String query = "SELECT * from faculty";
        System.out.println(query);
        try(Statement st =connection.createStatement();
             ResultSet result =st.executeQuery(query)){
            while(result.next()){
                FacultyBean fb = new FacultyBean();
                fb.setFacultyId(result.getInt("fact_id"));
                fb.setFacultyName(result.getString("Fact_Name"));
                fb.setRemarks(result.getString("Remarks"));

                vec.addElement(fb);
            }
        }
        return vec;
    }
    
    public static int updateFaculty(String facName, String remarks , int id)throws Exception{
        String query = "UPDATE faculty SET Fact_Name = '"+facName+"' , Remarks = '"+remarks+"'  where fact_id ="+id;
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//      connection.close();
        return i;
    }
    public static int deleteFaculty(int id)throws Exception{
        String query = "DELETE from faculty where fact_id = "+id;
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
        return i;
    }
    public static int addFaculty(FacultyBean bean)throws Exception{
        String query = "INSERT into faculty (Fact_Name , Remarks) values ('"+bean.getFacultyName()+" ' , '"+bean.getRemarks()+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
        return i;
    }
    
     public static Vector getAllDepartments()throws Exception{
        Vector vec= new Vector();
        String query = "SELECT * from department ORDER by Dept_Name ASC";
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            DepartmentBean db = new DepartmentBean();
            db.setfacultyID(result.getInt("fact_id")); 
            db.setDeptID(result.getInt("Dept_ID"));
            db.setDeptName(result.getString("Dept_Name"));
            db.setRemarks(result.getString("Remarks"));
            vec.addElement(db);
        }
       st.close();
//       connection.close();
        return vec;
    }
     public static Vector getAllDepartments(int facID)throws Exception{
        Vector vec= new Vector();
        String query = "SELECT * from department where fact_id = "+facID;
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            DepartmentBean db = new DepartmentBean();
            db.setfacultyID(result.getInt("fact_id")); 
            db.setDeptID(result.getInt("Dept_ID"));
            db.setDeptName(result.getString("Dept_Name"));
            db.setRemarks(result.getString("Remarks"));
            vec.addElement(db);
        }
       st.close();
//       connection.close();
        return vec;
    }
    
    public static void addDepartment(DepartmentBean dBean)throws Exception{
        String query = "INSERT into department (fact_id , Dept_Name , Remarks ) "
                + "values('"+dBean.getFacultyID()+"' , '"+dBean.getDeptName()+"' , '"+dBean.getRemarks()+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    
    public static void deleteDepartment(String depName)throws Exception{
        String query = "DELETE from department where Dept_Name = '"+depName+"'";
        System.out.println(query);
        Statement st = connection.createStatement();
        int  i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
     
    public static void updateDepartment(DepartmentBean dBean)throws Exception{
        String query = "UPDATE department SET  fact_id = '"+dBean.getFacultyID()+"' , Dept_Name = '"+dBean.getDeptName()+"' , Remarks = '"+dBean.getRemarks()+"' where Dept_ID = "+dBean.getDeptID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
            
    public static Vector getAllProgram(int dep_ID)throws Exception{
        Vector vec= new Vector();
        String query = "SELECT * from program where Dept_ID = "+dep_ID;
        System.out.println(query);
        Statement st =connection.createStatement();
        ResultSet result =st.executeQuery(query);
        while(result.next()){
            ProgramBean pb = new ProgramBean();
            pb.setDeptID(result.getInt("Dept_ID"));
            pb.setProgID(result.getInt("Prog_ID"));
            pb.setProgName(result.getString("Prog_Name"));
            pb.setDuration(result.getInt("Duration"));
            pb.setRemarks(result.getString("Remarks"));
            vec.addElement(pb);
        }
        st.close();
//        connection.close();
        return vec;
    }
    
    public static void addProgram(ProgramBean progBean)throws Exception{
        String query = "INSERT into program (Dept_ID , Prog_Name , Duration , Remarks) values "
                + "('"+progBean.getDeptID()+"' , '"+progBean.getProgName() +"' , '"+progBean.getDuration()+"' , '"+progBean.getRemarks()+"')";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void deleteProgram(ProgramBean progBean)throws Exception{
        String query ="DELETE from program where Prog_ID = "+progBean.getProgID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void updateProgram(ProgramBean progBean)throws Exception{
        String query = "UPDATE program SET Dept_ID = '"+progBean.getDeptID()+"' , Prog_Name = '"+progBean.getProgName()
            +"' , Duration = '"+progBean.getDuration()+"' , Remarks = '"+progBean.getRemarks()+"' where Prog_ID = "+progBean.getProgID();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static Vector getAllBatches(int prog_Id)throws Exception{
        String query = "SELECT * from batch where Prog_ID = "+prog_Id ;
        System.out.println(query);
        Vector v = new Vector();
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        while(result.next()){
            BatchBean batBean = new BatchBean();
            batBean.setProgId(result.getInt("Prog_ID"));
            batBean.setBatchId(result.getInt("Batch_ID"));
            batBean.setBatchYear(result.getInt("Batch_year"));
            batBean.setShift(result.getInt("Shift"));
            batBean.setGroup(result.getInt("Group"));
            batBean.setSession(result.getInt("session"));
            batBean.setRemarks(result.getString("Remarks"));
            v.addElement(batBean);
        }
        st.close();
//        connection.close();
        return v;
    }
    
    public static void addBatch(BatchBean batBean)throws Exception{
        String query = "INSERT INTO batch ( Prog_ID, Batch_year, Shift, [Group], session ,Remarks )  values"
                + " ("+batBean.getProgramId()+" , "+batBean.getBatchYear()+" , '"+batBean.getShift()+"' , "
                + "'"+batBean.getGroup()+"',"+batBean.getSession()+" ,'"+batBean.getRemarks()+"' )";
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void deleteBatch(BatchBean batBean)throws Exception{
        String query = "DELETE from batch where Batch_ID = "+batBean.getBatchId();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void updateBatch(BatchBean batBean)throws Exception{
        String query = "UPDATE batch SET Prog_ID= "+batBean.getProgramId()+" , Batch_year= "+batBean.getBatchYear() +" , "
                + "Shift='"+batBean.getShift()+"' , [Group] ='"+batBean.getGroup()+"', session = "+batBean.getSession()+" , Remarks='"+batBean.getRemarks()+"' where Batch_ID = "+batBean.getBatchId();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    
    public static Vector getAllStudents(int batId)throws Exception{
        String query = "SELECT * from student where Batch_ID = "+batId;
        System.out.println(query);
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        Vector vec = new Vector();
        while(result.next()){
            StudentBean stdBean = new StudentBean();
           
            stdBean.setBatchId(result.getInt("Batch_ID"));
            stdBean.setStudentId(result.getInt("student_id"));
            stdBean.setStudentName(result.getString("student_name"));
            stdBean.setFatherName(result.getString("FName"));
            stdBean.setSurname(result.getString("Surname"));
            stdBean.setCNIC(result.getString("CNIC"));
            stdBean.setRollNo(result.getString("Roll_No"));
            stdBean.setCellNo(result.getString("cell_no"));
            stdBean.setGroup(result.getInt("Group"));
            stdBean.setShift(result.getInt("Shift"));
            stdBean.setAddress(result.getString("Address"));
            stdBean.setRemarks(result.getString("Remarks"));
            
            vec.addElement(stdBean);
        }
        st.close();
//        connection.close();
        return vec;
    }
    public static void addStudent(StudentBean bean)throws Exception{
        String query = "INSERT INTO student (Batch_ID , student_name , FName , Surname , CNIC , Roll_No ,cell_no ,[Group], Shift , Address , Remarks)"
                + " values ( "+bean.getBatchId()+" , '"+bean.getStudentName()+"' , '"+bean.getFatherName()+"' , '"+bean.getSurname()
                +"' , '"+bean.getCNIC()+"' ,'"+bean.getRollNo()+"','"+bean.getCellNo()+"', '"+bean.getGroup()+"' ,'"+bean.getShift()+"' , '"+bean.getAddress()+"' , '"+bean.getRemarks()+"') ";
        
        System.out.println(query);
        Statement st = connection.createStatement();
        int i =st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void deleteStudent(StudentBean bean)throws Exception{
        String query = "DELETE from student where student_id = "+bean.getStudentId();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static void updateStudent(StudentBean bean)throws Exception{
        String query = "UPDATE student SET Batch_ID = "+bean.getBatchId()+", student_name = '"+bean.getStudentName()+"', FName = '"+bean.getFatherName()+"', Surname = '"+bean.getSurname()+"', CNIC = '"+bean.getCNIC()+"' , Roll_No = '"+bean.getRollNo()+"' , "
                + "cell_no = '"+bean.getCellNo()+"',[Group] ='"+bean.getGroup()+"', Shift='"+bean.getShift()+"' , Address='"+bean.getAddress()+"' , Remarks='"+bean.getRemarks()+"' where  student_id = "+bean.getStudentId();
        System.out.println(query);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(query);
        st.close();
//        connection.close();
    }
    public static int addAllParts(int batchId , int year , int parts ,String remarks)throws Exception{
        Statement st = connection.createStatement();
        int r=0;
        for(int i=1;i<=parts;i++){
            String sql = "INSERT into parts (batch_id , part , part_year , remarks) values ( "+batchId+" , "+i+" , "+(year++)+" , '"+remarks+"') ";
            System.out.println(sql);
            r = st.executeUpdate(sql);
        }
        return r;
    }
    public static java.util.ArrayList<PartBean> getAllParts(int batchId)throws Exception{
        String sql = "SELECT * from parts where batch_id = "+batchId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        java.util.ArrayList<PartBean> list = new java.util.ArrayList<PartBean>();
        while(rs.next()){
            PartBean b = new PartBean();
            b.setBatchId(rs.getInt("batch_id"));
            b.setPart(rs.getInt("part"));
            b.setPartId(rs.getInt("part_id"));
            b.setPartYear(rs.getInt("part_year"));
            b.setRemarks(rs.getString("remarks"));
            list.add(b);
        }
        return list;
    }
    public static int deletePart(int partId)throws Exception{
        String sql = "DELETE from parts where part_id = "+partId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }
    public static int updatePart(int partId , int part , int partYear , String remarks)throws Exception{
        String sql = "Update parts SET part = "+part+" , part_year = "+partYear+" , remarks = '"+remarks+"'  where part_id = "+partId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }
    
    public static int addScratchCard(int factId,java.util.ArrayList list ,int amount ,int status , int purpose , String validate , String remarks)throws Exception{
        Statement st = connection.createStatement();
        String sql;
        int r=0;
        for(int i=0;i<list.size();i++){
            sql = "Insert into scratch_card (fact_id , amount , status , card_no , purpose , valid_upto_date , remarks) values ("+factId+" , "+amount+" ,"+status+",'"+list.get(i)+"' ,"+purpose+" ,#"+validate+"#,'"+remarks+"')";
            System.out.println(sql);
            r = st.executeUpdate(sql); 
        }
        return r;
    }
    public static java.util.ArrayList getExpiredScratchCards(int facultyId ,int status,String currentDate)throws Exception{
        String sql = "SELECT * from scratch_card where [valid_upto_date]< #"+currentDate+"# AND status= "+status+" AND fact_id = "+facultyId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            ScratchCardBean card = new ScratchCardBean();
            card.setAmount(rs.getInt("amount"));
            card.setScratchCardNo(rs.getString("card_no"));
            card.setValidUptoDate(rs.getDate("valid_upto_date"));
            card.setPurpose(rs.getInt("purpose"));
            card.setRemarks(rs.getString("remarks"));
            card.setScratchCardId(rs.getInt("scratch_card_id"));
            card.setStatus(rs.getInt("status"));
            
            list.add(card);
        }
        return list;
    }  
    public static java.util.ArrayList getUnusedScratchCards(int facultyId ,int status,String currentDate)throws Exception{
        String sql = "SELECT * from scratch_card where [valid_upto_date]>= #"+currentDate+"# AND status= "+status+" AND fact_id = "+facultyId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            ScratchCardBean card = new ScratchCardBean();
            card.setAmount(rs.getInt("amount"));
            card.setScratchCardNo(rs.getString("card_no"));
            card.setValidUptoDate(rs.getDate("valid_upto_date"));
            card.setPurpose(rs.getInt("purpose"));
            card.setRemarks(rs.getString("remarks"));
            card.setScratchCardId(rs.getInt("scratch_card_id"));
            card.setStatus(rs.getInt("status"));
            
            list.add(card);
        }
        return list;
    }  
    public static java.util.ArrayList getUsedScratchCards(int facultyId ,int status)throws Exception{
        String sql = "SELECT * from scratch_card where status= "+status+" AND fact_id = "+facultyId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            ScratchCardBean card = new ScratchCardBean();
            card.setAmount(rs.getInt("amount"));
            card.setScratchCardNo(rs.getString("card_no"));
            card.setValidUptoDate(rs.getDate("valid_upto_date"));
            card.setPurpose(rs.getInt("purpose"));
            card.setRemarks(rs.getString("remarks"));
            card.setScratchCardId(rs.getInt("scratch_card_id"));
            card.setStatus(rs.getInt("status"));
            
            list.add(card);
        }
        return list;
    }
    public static int deleteScratchCard(int scratchCardId)throws Exception{
        String sql = "DELETE from scratch_card where  scratch_card_id = "+scratchCardId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r = st.executeUpdate(sql);
        return r;
    }
    public static int UpdateScratchCard(int ScratchCardId,int amount ,int status , String cardNo ,int purpose , String validate , String remarks)throws Exception{
        String sql = "Update scratch_card SET amount = "+amount+", status = "+status+", card_no = '"+cardNo+"', purpose = "+purpose+", valid_upto_date =  #"+validate+"#, remarks = '"+remarks+"' where scratch_card_id = "+ScratchCardId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r=st.executeUpdate(sql);     
        return r;
    }
    public static int addStudentPartRegistration(int studentId , int partId , int status)throws Exception{
        String sql="INSERT into student_part_reg (student_id , part_id , status ) values ("+studentId+" ,"+partId+","+status+") ";
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r=st.executeUpdate(sql);     
        return r;
    }
    
    public static java.util.ArrayList getStudentsFromPartRgistration(int partId)throws Exception{
        String sql = "SELECT * from student_part_reg spr , student s , parts p where p.part_id = "+partId+" AND p.part_id=spr.part_id AND spr.student_id=s.student_id";
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            StudentPartRegistrationBean bean = new StudentPartRegistrationBean();
            bean.setStudentPartRegId(rs.getInt("std_part_reg_id"));
            bean.setStudentName(rs.getString("student_name"));
            bean.setFatherName(rs.getString("FName"));
            bean.setSurname(rs.getString("Surname"));
            bean.setCNIC(rs.getString("CNIC"));
            bean.setRollNo(rs.getString("Roll_No"));
            bean.setPart(rs.getInt("part"));
            bean.setAmount(rs.getInt("amount"));
            bean.setSratchCardId(rs.getInt("scratch_card_id"));
            bean.setStatus(rs.getInt("status"));
            bean.setChallanNo(rs.getInt("challan_no"));
            bean.setDateOfPaid(rs.getDate("date_of_paid"));
            bean.setRemarks(rs.getString("remarks"));
            
            list.add(bean);
        }
        return list;
    }
    
    public static ScratchCardBean getScratchCard(int id)throws Exception{
        String sql = "SELECT * from scratch_card where scratch_card_id ="+id;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ScratchCardBean bean = null;
        if(rs.next()){
            bean = new ScratchCardBean();
            bean.setScratchCardNo(rs.getString("card_no"));
            bean.setAmount(rs.getInt("amount"));
            bean.setPurpose(rs.getInt("purpose"));
            bean.setStatus(rs.getInt("status"));
            bean.setValidUptoDate(rs.getDate("valid_upto_date"));
        }
        return bean;
    }
    public static int updateStudentPartRegistration(int studentRegId , int status,int challanNo, int amount ,String dateOfPaid ,String remarks)throws Exception{
        String sql="Update student_part_reg SET status="+status+" ,challan_no = "+challanNo+",amount="+amount+",date_of_paid = #"+dateOfPaid+"# , remarks='"+remarks+"' where std_part_reg_id ="+studentRegId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r=st.executeUpdate(sql);     
        return r;
    }
    public static int updateStudentPartRegistration(int studentRegId , int status,int scratchCardId,String dateOfPaid ,String remarks)throws Exception{
        String sql="Update student_part_reg SET status="+status+",scratch_card_id="+scratchCardId+" ,date_of_paid = #"+dateOfPaid+"# , remarks='"+remarks+"' where std_part_reg_id ="+studentRegId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r=st.executeUpdate(sql);     
        return r;
    }
    public static int deleteStudentPartRegistration(int studentRegId)throws Exception{
        String sql = "Delete from student_part_reg where std_part_reg_id ="+studentRegId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        int r=st.executeUpdate(sql);     
        return r;
    }
    public static BiodataBean getBiodata(String rollNo)throws Exception{
        String sql = "SELECT * from student s , student_part_reg spr , parts p"+ 
         " Where s.student_id=spr.student_id  AND spr.part_id=p.part_id AND s.Roll_No = '"+rollNo+"'";
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<BiodataBean> list = new ArrayList<BiodataBean>();
        while(rs.next()){
            BiodataBean bean = new BiodataBean();
            bean.setStudentId(rs.getInt("student_id"));
            bean.setStudentPartRegId(rs.getInt("std_part_reg_id"));
            bean.setStatus(rs.getInt("status"));
            bean.setPart(rs.getInt("part"));
            bean.setStudentName(rs.getString("student_name"));
            bean.setSurname(rs.getString("Surname"));
            bean.setRollNo(rs.getString("Roll_No"));
            bean.setFatherName(rs.getString("FName"));
            bean.setRollNo(rollNo);
            list.add(bean);
        }
        if(list.size()==1){
            BiodataBean rBean = list.get(0);
            if(rBean.getStatus()==Constant.LEGAL){
                rBean.setMessage("paid");
            }
            return rBean;
        }
        if(list.size()>1){
            System.out.println("Entered in list>size()");
            BiodataBean rBean=null;
            int temp=0;
            int legal=0;
            for(int i=0;i<list.size();i++){
                BiodataBean bean = list.get(i);
                if(bean.getStatus()==Constant.TEMPERARY){ rBean=bean; temp++;}
                if(bean.getStatus()==Constant.LEGAL)legal++;
            }
            if(temp>1){
                rBean.setMessage("error");
                return rBean;
            }
            else if(legal==list.size()){
                rBean = list.get(list.size()-1);
                rBean.setMessage("paid");
                return rBean;
            }
            else{
                return rBean;
            }
        }
        return null;
    }
    public static int getStudentFacultyId(int stdId)throws Exception{
        String sql = "SELECT * from student s, batch b, program p, department d"
        +" WHERE s.student_id=24 AND s.Batch_ID=b.Batch_ID AND b.Prog_ID=p.Prog_ID AND p.Dept_ID=d.Dept_ID";
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int facId = 0;
        if(rs.next()){
            facId = rs.getInt("fact_id");
        }
        return facId;
    }
    
    public static ScratchCardBean verifyCard(String cardNo , int purpose , int facId , String date)throws Exception{
        String sql = "SELECT * from scratch_card WHERE card_no = '"+cardNo+"' AND valid_upto_date>=#"+date+"# AND status="+Constant.LEGAL+" AND fact_id="+facId+" AND purpose="+purpose;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ScratchCardBean bean =null; 
        if(rs.next()){
            bean = new ScratchCardBean();
            bean.setScratchCardId(rs.getInt("scratch_card_id"));
            bean.setScratchCardNo(rs.getString("card_no"));
            bean.setAmount(rs.getInt("amount"));
            bean.setPurpose(rs.getInt("purpose"));
            bean.setStatus(rs.getInt("status"));
            bean.setValidUptoDate(rs.getDate("valid_upto_date"));
        }
        return bean;
    }
    
    public static String getFacultyName(int id)throws Exception{
        String sql = "SELECT * from faculty WHERE fact_id="+id;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String facultyName= null;
        if(rs.next()){
            facultyName = rs.getString("Fact_Name");
        }
        return facultyName;
    }
    
    public static int addMessageEvent(int batchId , String title , String desc , String date)throws Exception{
        String sql = "INSERT into event_messages (batch_id , event_title , event_desc, date_of_send) values ("+batchId+" , '"+title+"' , '"+desc+"' , #"+date+"#)";
        System.out.println(sql);
        Statement st = connection.createStatement();
        int i = st.executeUpdate(sql);
        return i;
    }
 
    public static ArrayList getAllEventMessages(int batchId)throws Exception {
        String sql = "SELECT * from event_messages WHERE batch_id="+batchId;
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        java.util.ArrayList list = new java.util.ArrayList();
        while(rs.next()){
            EventMessageBean b= new EventMessageBean();
            b.setBatchId(rs.getInt("batch_id"));
            b.setEventId(rs.getInt("event_id"));
            b.setTitle(rs.getString("event_title"));
            b.setDesciption(rs.getString("event_desc"));
            b.setDate(rs.getDate("date_of_send"));
            list.add(b);
        }
        return list;
    }
    
 
    public static void connectionClose()throws Exception{
        connection.close();
    }
   
}



