
public class EventMessageBean {
    private int batchId;
    private int eventId;
    private String title;
    private String desciption;
    private java.util.Date date;
    
    public String toString(){
    
        return DateFormatter.dateToString(date);
    }
    
    public int getBatchId(){
        return batchId;
    }
    
    public int getEventId(){
        return eventId;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDesciption(){
        return desciption;
    }
    
    public java.util.Date getDate(){
        return date;
    }
    
    public void setBatchId(int id){
        batchId= id;
    }
    
    public void setEventId(int id){
        eventId = id;
    }
    
    public void setTitle(String s){
        title= s;
    }
    
    public void setDesciption(String s){
        desciption = s;
    }
    
    public void setDate(java.util.Date d){
        date = d;
    }
}
