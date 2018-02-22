/**
 *
 * @author Jay Kumar
 */
public class BatchBean {
    int batID;
    int batYear;
    String shift;
    String groupDesc;
    String remarks;
    
    public int getBatID(){
        return batID;
    }
    
    public int getBatYear(){
        return batYear;
    }
    
    public String getShift(){
        return shift;
    }
    
    public String getGroupDesc(){
        return groupDesc;
    }
    
    public String getRemarks(){
        return remarks;
    }
     public void setBatYear(int year){
        batYear = year;
    }
    
    public void setShift(String shift){
        this.shift = shift;
    }
    
    public void setGroupDesc(String desc){
        groupDesc = desc;
    }
    
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    
}
