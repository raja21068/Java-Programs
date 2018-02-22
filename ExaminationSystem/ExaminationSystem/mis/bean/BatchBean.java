package bean;
// ** author @Jay K  **

public class BatchBean{
  // Variables declaration - do not modify
    private int batchId;
    private int progId;
    private String year;
    private String shift;
    private String groupDesc;
    private String remarks;




//Setter Methods Generated
    public void setBatchId(int batchId){
        this.batchId = batchId ;
    }
    public void setProgId(int progId){
        this.progId = progId ;
    }
    public void setYear(String year){
        this.year = year ;
    }
    public void setShift(String shift){
        this.shift = shift ;
    }
    public void setGroupDesc(String groupDesc){
        this.groupDesc = groupDesc ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getBatchId(){
        return this.batchId ;
    }
    public int getProgId(){
        return this.progId ;
    }
    public String getYear(){
        return this.year ;
    }
    public String getShift(){
        return this.shift ;
    }
    public String getGroupDesc(){
        return this.groupDesc ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
