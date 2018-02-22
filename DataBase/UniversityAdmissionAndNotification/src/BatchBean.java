/**
 *
 * @author Jay Kumar
 */
public class BatchBean {
    private int progID;
    private int batID;
    private int batYear;
    private int shift;
    private int group;
    private int session;
    private String remarks;
    
    public int getProgramId(){
        return progID;
    }
    
    public int getBatchId(){
        return batID;
    }
    
    public int getBatchYear(){
        return batYear;
    }
    
    public int getShift(){
        return shift;
    }
    
    public int getGroup(){
        return group;
    }

    public int getSession(){
        return session;
    }    
    
    public String getRemarks(){
        return remarks;
    }
    public void setProgId(int progId){
        progID = progId;
    } 
    public void setBatchId(int batId){
        batID = batId;
    }
    public void setBatchYear(int year){
        batYear = year;
    }
    
    public void setShift(int shift){
        this.shift = shift;
    }
    
    public void setGroup(int grp){
        group = grp;
    }
    
    public void setSession(int session){
        this.session = session;
    }
    
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    public String toString(){
    return ""+batYear;
    }
}
