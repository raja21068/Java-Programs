package database;


import java.util.List;
import org.hibernate.*;

// Referenced classes of package admission.controller:
//            HibernateUtil

public class DatabaseManager
{

    public DatabaseManager()
    {
    }

    public static void load()
    {
        System.out.println("Loaded successfully");
    }

    public static void refresh(Object object)
    {
        session.refresh(object);
    }

    public static List getData(String className, String orderBy)
        throws HibernateException
    {
        Transaction trancaction = null;
        try
        {
            trancaction = session.beginTransaction();
            String hql = (new StringBuilder()).append("FROM ").append(className).append(" ORDER BY ").append(orderBy).toString();
            Query query = session.createQuery(hql);
            List list = query.list();
            trancaction.commit();
            return list;
        }
        catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
    }
    

    public static List getData(String hql)
        throws HibernateException
    {
        Transaction trancaction = null;
        try
        {
            trancaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List list = query.list();
            trancaction.commit();
            return list;
        }
        catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
    }
    
    public static List getData(String className,String where ,  String orderBy)
        throws HibernateException
    {
        Transaction trancaction = null;
        try
        {
            trancaction = session.beginTransaction();
            String hql = (new StringBuilder()).append("FROM ").append(className).append(" WHERE ").append(where).append(" ORDER BY ").append(orderBy).toString();
            Query query = session.createQuery(hql);
            List list = query.list();
            trancaction.commit();
            return list;
        }
        catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
    }

    public static int addData(Object object)
        throws HibernateException
    {
        Transaction trancaction = null;
        try
        {
            trancaction = session.beginTransaction();
            Integer id = (Integer)session.save(object);
            trancaction.commit();
            return id.intValue();
        }
        catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
    }

    public static void updateData(Object object)
    {
        Transaction trancaction = null;
        try
        {
            trancaction = session.beginTransaction();
            session.merge(object);
            trancaction.commit();
        }
        catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
    }

    public static int deleteData(Class clas , int id){
        Transaction trancaction = null;
        try{
            trancaction = session.beginTransaction();
            session.delete(session.get(clas, id));
        }catch(HibernateException he)
        {
            if(trancaction != null)
                trancaction.rollback();
            throw he;
        }
        return 0; 
    }

    private static Session session;

    static 
    {
        System.out.println("Please wait...");
        try
        {
            session = HibernateUtil.openSession();
        }
        catch(HibernateException he)
        {
            he.printStackTrace();
            throw he;
        }
    }
}