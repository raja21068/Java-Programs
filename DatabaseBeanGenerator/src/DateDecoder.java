/**
 * Created on Oct 11, 2011, 2:27:04 PM
 * 
 * @author Yougeshwar Khatri
 */

public class DateDecoder {
    public static String getDateFormat(java.util.Date date){
        if(date==null)return "";
        
        java.text.SimpleDateFormat format=new java.text.SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        String str=format.format(date);
        
        return str;
    }
}
