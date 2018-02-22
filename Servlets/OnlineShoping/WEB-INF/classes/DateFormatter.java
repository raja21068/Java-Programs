
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
}
