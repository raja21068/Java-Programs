import java.io.*;
/**
 *
 * @author Jay Kumar
 */
public class BatchBean implements Serializable{
    private int progID;
    private int batID;
    private int batYear;
    private String shift;
    private String group;
    private String remarks;
    
    public int getProgID(){
        return progID;
    }
    
    public int getBatID(){
        return batID;
    }
    
    public int getBatYear(){
        return batYear;
    }
    
    public String getShift(){
        return shift;
    }
    
    public String getGroup(){
        return group;
    }
    
    public String getRemarks(){
        return remarks;
    }
    public void setProgId(int progId){
        progID = progId;
    } 
    public void setBatId(int batId){
        batID = batId;
    }
    public void setBatYear(int year){
        batYear = year;
    }
    
    public void setShift(String shift){
        this.shift = shift;
    }
    
    public void setGroup(String desc){
        group = desc;
    }
    
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public String toString(){
    return ""+batYear;
    }
}
