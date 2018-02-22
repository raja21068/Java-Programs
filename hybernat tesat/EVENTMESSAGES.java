class EVENTMESSAGES{
  // Variables declaration - do not modify
    private int eventId;
    private int batchId;
    private String eventDesc;
    private String eventTittle;
    private java.util.Date dateOfSend;
    private String remarks;

    public EVENTMESSAGES(){}
public EVENTMESSAGES(int batchId, String eventDesc, String eventTittle, java.util.Date dateOfSend, String remarks){
this.batchId = batchId;
this.eventDesc = eventDesc;
this.eventTittle = eventTittle;
this.dateOfSend = dateOfSend;
this.remarks = remarks;}



//Setter Methods Generated
    public void setEventId(int eventId){
        this.eventId = eventId ;
    }
    public void setBatchId(int batchId){
        this.batchId = batchId ;
    }
    public void setEventDesc(String eventDesc){
        this.eventDesc = eventDesc ;
    }
    public void setEventTittle(String eventTittle){
        this.eventTittle = eventTittle ;
    }
    public void setDateOfSend(java.util.Date dateOfSend){
        this.dateOfSend = dateOfSend ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getEventId(){
        return this.eventId ;
    }
    public int getBatchId(){
        return this.batchId ;
    }
    public String getEventDesc(){
        return this.eventDesc ;
    }
    public String getEventTittle(){
        return this.eventTittle ;
    }
    public java.util.Date getDateOfSend(){
        return this.dateOfSend ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
