import java.util.*;


public class HashtableDemo {

    public static void main(String[] args) {
        
        
        Hashtable table=new Hashtable();
        
        
        table.put("ali", "netlync");
        table.put("ali imran", "bell");
        table.put("ali khan", "mit");
        table.put("ali shan", "123");
        table.put("hitesh", "xyz");
        table.put("yougesh", "faith");
        table.put("kantesh", "aptech");
        table.put("vikesh", "sun");
        table.put("mukesh", "micro");
        table.put("haresh", "jdbc");

        
        //String value=(String)table.get("yougesh");
        //Object value=table.get("yougesh");
       //System.out.println(value);
       //System.out.println(table.get("ali"));
        
       
        
        Enumeration e=table.keys();
        
        while(e.hasMoreElements()){
         
           String key=(String) e.nextElement();
       String value=(String) table.get(key);
       
           System.out.println(key);
           System.out.println(value);
           System.out.println("-----------------");
        }
        // TODO code application logic here
    }
}
