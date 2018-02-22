import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.SybaseAnywhereDialect;
class DatabaseManager{
    private static SessionFactory factory; 
    static{        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch(Exception ex){ex.printStackTrace();}
    }

    public static java.util.ArrayList getBatch(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Batch").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Batch bean = (Batch) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addBatch(int progId, int batchYear, String shift, String groupDesc, String remarks, String session){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Batch ob = new Batch(progId, batchYear, shift, groupDesc, remarks, session);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteBatch(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Batch ob = (Batch)ses.get(Batch.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateBatch(int progId, int id, int batchYear, String shift, String groupDesc, String remarks, String session){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Batch ob = (Batch)ses.get(Batch.class, id); 
        ob.setProgId( progId);
        ob.setBatchId(id);
        ob.setBatchYear( batchYear);
        ob.setShift( shift);
        ob.setGroupDesc( groupDesc);
        ob.setRemarks( remarks);
        ob.setSession( session);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getBookIssue(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM BookIssue").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  BookIssue bean = (BookIssue) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addBookIssue(int catDetailId, Date dateOfIssue, Date dateOfReturn, int fineAmount, int stdId, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            BookIssue ob = new BookIssue(catDetailId, dateOfIssue, dateOfReturn, fineAmount, stdId, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteBookIssue(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            BookIssue ob = (BookIssue)ses.get(BookIssue.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateBookIssue(int id, int catDetailId, Date dateOfIssue, Date dateOfReturn, int fineAmount, int stdId, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            BookIssue ob = (BookIssue)ses.get(BookIssue.class, id); 
        ob.setIssueId(id);
        ob.setCatDetailId( catDetailId);
        ob.setDateOfIssue( dateOfIssue);
        ob.setDateOfReturn( dateOfReturn);
        ob.setFineAmount( fineAmount);
        ob.setStdId( stdId);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getCategory(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Category").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Category bean = (Category) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addCategory(String catName, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Category ob = new Category(catName, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteCategory(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Category ob = (Category)ses.get(Category.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateCategory(int id, String catName, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Category ob = (Category)ses.get(Category.class, id); 
        ob.setCatId(id);
        ob.setCatName( catName);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getCategoryDetial(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM CategoryDetial").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  CategoryDetial bean = (CategoryDetial) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addCategoryDetial(int catId, String bookName, String publisher, String authir, String edition, String volume, String yearOfPublishing, String isbn, String accessNo, String drasNo, int prise, String purchaseFrom, String dateOfPurchase, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            CategoryDetial ob = new CategoryDetial(catId, bookName, publisher, authir, edition, volume, yearOfPublishing, isbn, accessNo, drasNo, prise, purchaseFrom, dateOfPurchase, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteCategoryDetial(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            CategoryDetial ob = (CategoryDetial)ses.get(CategoryDetial.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateCategoryDetial(int id, int catId, String bookName, String publisher, String authir, String edition, String volume, String yearOfPublishing, String isbn, String accessNo, String drasNo, int prise, String purchaseFrom, String dateOfPurchase, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            CategoryDetial ob = (CategoryDetial)ses.get(CategoryDetial.class, id); 
        ob.setCatDetailId(id);
        ob.setCatId( catId);
        ob.setBookName( bookName);
        ob.setPublisher( publisher);
        ob.setAuthir( authir);
        ob.setEdition( edition);
        ob.setVolume( volume);
        ob.setYearOfPublishing( yearOfPublishing);
        ob.setIsbn( isbn);
        ob.setAccessNo( accessNo);
        ob.setDrasNo( drasNo);
        ob.setPrise( prise);
        ob.setPurchaseFrom( purchaseFrom);
        ob.setDateOfPurchase( dateOfPurchase);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getDepartment(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Department").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Department bean = (Department) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addDepartment(int facId, String deptName, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Department ob = new Department(facId, deptName, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteDepartment(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Department ob = (Department)ses.get(Department.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateDepartment(int facId, int id, String deptName, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Department ob = (Department)ses.get(Department.class, id); 
        ob.setFacId( facId);
        ob.setDeptId(id);
        ob.setDeptName( deptName);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getEVENTMESSAGES(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM EVENTMESSAGES").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  EVENTMESSAGES bean = (EVENTMESSAGES) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addEVENTMESSAGES(int batchId, String eventDesc, String eventTittle, Date dateOfSend, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            EVENTMESSAGES ob = new EVENTMESSAGES(batchId, eventDesc, eventTittle, dateOfSend, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteEVENTMESSAGES(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            EVENTMESSAGES ob = (EVENTMESSAGES)ses.get(EVENTMESSAGES.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateEVENTMESSAGES(int id, int batchId, String eventDesc, String eventTittle, Date dateOfSend, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            EVENTMESSAGES ob = (EVENTMESSAGES)ses.get(EVENTMESSAGES.class, id); 
        ob.setEventId(id);
        ob.setBatchId( batchId);
        ob.setEventDesc( eventDesc);
        ob.setEventTittle( eventTittle);
        ob.setDateOfSend( dateOfSend);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getFaculty(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Faculty").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Faculty bean = (Faculty) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addFaculty(String facName, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Faculty ob = new Faculty(facName, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteFaculty(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Faculty ob = (Faculty)ses.get(Faculty.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateFaculty(int id, String facName, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Faculty ob = (Faculty)ses.get(Faculty.class, id); 
        ob.setFacId(id);
        ob.setFacName( facName);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getPARTS(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM PARTS").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  PARTS bean = (PARTS) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addPARTS(int batchId, int part, int partYear, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            PARTS ob = new PARTS(batchId, part, partYear, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deletePARTS(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            PARTS ob = (PARTS)ses.get(PARTS.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updatePARTS(int batchId, int id, int part, int partYear, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            PARTS ob = (PARTS)ses.get(PARTS.class, id); 
        ob.setBatchId( batchId);
        ob.setPartId(id);
        ob.setPart( part);
        ob.setPartYear( partYear);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getProgram(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Program").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Program bean = (Program) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addProgram(int deptId, String progName, int duration, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Program ob = new Program(deptId, progName, duration, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteProgram(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Program ob = (Program)ses.get(Program.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateProgram(int deptId, int id, String progName, int duration, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Program ob = (Program)ses.get(Program.class, id); 
        ob.setDeptId( deptId);
        ob.setProgId(id);
        ob.setProgName( progName);
        ob.setDuration( duration);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getSCRATCHCARD(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM SCRATCHCARD").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  SCRATCHCARD bean = (SCRATCHCARD) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addSCRATCHCARD(int facId, int amount, String status, String cardNo, String purpose, Date vaildUpToDate, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            SCRATCHCARD ob = new SCRATCHCARD(facId, amount, status, cardNo, purpose, vaildUpToDate, remarks);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteSCRATCHCARD(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            SCRATCHCARD ob = (SCRATCHCARD)ses.get(SCRATCHCARD.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateSCRATCHCARD(int id, int facId, int amount, String status, String cardNo, String purpose, Date vaildUpToDate, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            SCRATCHCARD ob = (SCRATCHCARD)ses.get(SCRATCHCARD.class, id); 
        ob.setScratchCardId(id);
        ob.setFacId( facId);
        ob.setAmount( amount);
        ob.setStatus( status);
        ob.setCardNo( cardNo);
        ob.setPurpose( purpose);
        ob.setVaildUpToDate( vaildUpToDate);
        ob.setRemarks( remarks);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getStudent(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Student").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Student bean = (Student) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addStudent(int batchId, String fname, String surname, String rollNo, String remarks, String stdName, String cellNo, byte[] stdPic){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Student ob = new Student(batchId, fname, surname, rollNo, remarks, stdName, cellNo, stdPic);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteStudent(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Student ob = (Student)ses.get(Student.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateStudent(int batchId, int id, String fname, String surname, String rollNo, String remarks, String stdName, String cellNo, byte[] stdPic){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Student ob = (Student)ses.get(Student.class, id); 
        ob.setBatchId( batchId);
        ob.setStdId(id);
        ob.setFname( fname);
        ob.setSurname( surname);
        ob.setRollNo( rollNo);
        ob.setRemarks( remarks);
        ob.setStdName( stdName);
        ob.setCellNo( cellNo);
        ob.setStdPic( stdPic);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static java.util.ArrayList getSTUDENTPARTREG(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM STUDENTPARTREG").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  STUDENTPARTREG bean = (STUDENTPARTREG) iterator.next();
                  list.add(bean);
             }
             tx.commit();
          }catch (HibernateException e) {
              if (tx!=null) tx.rollback();
                  e.printStackTrace(); 
          }finally {
               session.close();
          }
          return list;
       }
    public static Integer addSTUDENTPARTREG(int partId, int stdId, int scractchCardId, int status, Date dataOfPaid, String remarks, String chalanNo, int amount){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            STUDENTPARTREG ob = new STUDENTPARTREG(partId, stdId, scractchCardId, status, dataOfPaid, remarks, chalanNo, amount);
            id = (Integer) ses.save(ob);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
         }finally {
            ses.close();
         };
        return id;
    }

    public static void deleteSTUDENTPARTREG(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            STUDENTPARTREG ob = (STUDENTPARTREG)ses.get(STUDENTPARTREG.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateSTUDENTPARTREG(int id, int partId, int stdId, int scractchCardId, int status, Date dataOfPaid, String remarks, String chalanNo, int amount){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            STUDENTPARTREG ob = (STUDENTPARTREG)ses.get(STUDENTPARTREG.class, id); 
        ob.setStdPartRegId(id);
        ob.setPartId( partId);
        ob.setStdId( stdId);
        ob.setScractchCardId( scractchCardId);
        ob.setStatus( status);
        ob.setDataOfPaid( dataOfPaid);
        ob.setRemarks( remarks);
        ob.setChalanNo( chalanNo);
        ob.setAmount( amount);
            ses.update(ob); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
                e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

}
