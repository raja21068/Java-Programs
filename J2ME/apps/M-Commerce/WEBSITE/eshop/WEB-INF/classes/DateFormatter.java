
public class DateFormatter {
   
    public static String dateToString(java.util.Date d , String format){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
        return sdf.format(d);
    }
}
