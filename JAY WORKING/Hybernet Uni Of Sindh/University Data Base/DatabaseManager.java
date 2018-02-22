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
             List employees = session.createQuery("FROM Employee").list(); 
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
    public static Integer addBatch(int progID, int batchYear, int shift, int group, int session, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Batch ob = new Batch(progID, batchYear, shift, group, session, remarks);
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

    public static void updateBatch(int progID, int id, int batchYear, int shift, int group, int session, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Batch ob = (Batch)ses.get(Batch.class, id); 
        ob.setProgID( progID);
        ob.setBatchID(id);
        ob.setBatchYear( batchYear);
        ob.setShift( shift);
        ob.setGroup( group);
        ob.setSession( session);
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
             List employees = session.createQuery("FROM Employee").list(); 
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
    public static Integer addDepartment(int factId, String deptName, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Department ob = new Department(factId, deptName, remarks);
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

    public static void updateDepartment(int factId, int id, String deptName, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Department ob = (Department)ses.get(Department.class, id); 
        ob.setFactId( factId);
        ob.setDeptID(id);
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

    public static java.util.ArrayList getEmployee(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Employee").list(); 
             for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                  Employee bean = (Employee) iterator.next();
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
    public static Integer addEmployee(String firstName, String lastName, int salary){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Employee ob = new Employee(firstName, lastName, salary);
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

    public static void deleteEmployee(int id){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Employee ob = (Employee)ses.get(Employee.class, id); 
            ses.delete(ob); 
            tx.commit();
        }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally { 
           ses.close(); 
        } 
    } 

    public static void updateEmployee(int id, String firstName, String lastName, int salary){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Employee ob = (Employee)ses.get(Employee.class, id); 
        ob.setId(id);
        ob.setFirstName( firstName);
        ob.setLastName( lastName);
        ob.setSalary( salary);
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
             List employees = session.createQuery("FROM Employee").list(); 
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
    public static Integer addFaculty(String factName, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Faculty ob = new Faculty(factName, remarks);
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

    public static void updateFaculty(int id, String factName, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Faculty ob = (Faculty)ses.get(Faculty.class, id); 
        ob.setFactId(id);
        ob.setFactName( factName);
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
             List employees = session.createQuery("FROM Employee").list(); 
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
    public static Integer addProgram(int deptID, String progName, int duration, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Program ob = new Program(deptID, progName, duration, remarks);
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

    public static void updateProgram(int deptID, int id, String progName, int duration, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Program ob = (Program)ses.get(Program.class, id); 
        ob.setDeptID( deptID);
        ob.setProgID(id);
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

    public static java.util.ArrayList getStudent(){
        Session session = factory.openSession();
        Transaction tx = null;
        java.util.ArrayList list = new java.util.ArrayList();
        try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM Employee").list(); 
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
    public static Integer addStudent(int batchID, String studentName, String fName, String surname, String cNIC, String rollNo, String cellNo, int group, int shift, String address, String remarks){ 
        Session ses = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try{
            tx = ses.beginTransaction();
            Student ob = new Student(batchID, studentName, fName, surname, cNIC, rollNo, cellNo, group, shift, address, remarks);
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

    public static void updateStudent(int batchID, int id, String studentName, String fName, String surname, String cNIC, String rollNo, String cellNo, int group, int shift, String address, String remarks){
        Session ses = factory.openSession();
        Transaction tx = null;
        try{ 
            tx = ses.beginTransaction(); 
            Student ob = (Student)ses.get(Student.class, id); 
        ob.setBatchID( batchID);
        ob.setStudentId(id);
        ob.setStudentName( studentName);
        ob.setFName( fName);
        ob.setSurname( surname);
        ob.setCNIC( cNIC);
        ob.setRollNo( rollNo);
        ob.setCellNo( cellNo);
        ob.setGroup( group);
        ob.setShift( shift);
        ob.setAddress( address);
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

}
