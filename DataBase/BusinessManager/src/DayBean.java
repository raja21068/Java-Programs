import java.util.Date;
public class DayBean {
    private int yearId;
    private int dayId;
    private Date day;
    private int closingBalance;
    private boolean closed;
    private String remarks;
    
    public void setYearId(int yearId){
        this.yearId = yearId;
    }
    public void setDayId(int dayId){
        this.dayId = dayId;
    }
    public void setDay(Date day){
        this.day = day;
    }
    public void setClosingBalance(int closingBalance){
        this.closingBalance = closingBalance;
    }
    public void setClosed(boolean clos){
        this.closed = clos;
    }
    public void setRemarks(String remark){
        this.remarks = remark;
    }
    //Getter Methods**
    public int getYearId(){
       return this.yearId; 
    }
    public int getdayId(){
       return this.dayId; 
    }
    public Date getday(){
       return this.day; 
    }
    public int getClosingBalance(){
       return this.closingBalance; 
    }
    public boolean isClosed(){
       return this.closed; 
    }
    public String getRemarks(){
        return this.remarks;
    }
     public String toString(){
        return DateFormatter.dateToString(day);
    }
   
}
