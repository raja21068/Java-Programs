

public class DayBean{
    private int yearId;
    private int dayId;
    private java.util.Date day;
    private boolean closed;
    private String remarks;


    /*Setter Methods*/
    public void setYearId(int yearId){
        this.yearId = yearId;
    }
    public void setDayId(int dayId){
        this.dayId = dayId;
    }
    public void setDay(java.util.Date day){
        this.day = day;
    }
    public void setClosed(boolean closed){
        this.closed = closed;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    /*Getter Methods*/
    public int getYearId(){
        return this.yearId;
    }
    public int getDayId(){
        return this.dayId;
    }
    public java.util.Date getDay(){
        return this.day;
    }
    public boolean getClosed(){
        return this.closed;
    }
    public String getRemarks(){
        return this.remarks;
    }

    //@Override
    public String toString(){
        return DateFormatter.dateToString(day);
    }
}
