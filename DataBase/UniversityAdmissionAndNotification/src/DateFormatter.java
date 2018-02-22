
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
    public static String dateToString(java.util.Date d){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }
    public static String dateToStringMonthFormat(java.util.Date d){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(d);
    }
    public static String FlipDateAndMonth(String date){
        String dates[] = date.split("-");
        date = dates[1]+"-"+dates[0]+"-"+dates[2];
        return date;
    }
    public static String toDateAndTime(java.util.Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,k,m");
        String s =sdf.format(d);
        return s;
    }
}
