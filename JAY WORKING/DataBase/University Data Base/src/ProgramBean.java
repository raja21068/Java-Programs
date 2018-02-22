/**
 *
 * @author Jay Kumar
 */
public class ProgramBean {
    int progID;
    String progName;
    String duration;
    String remarks;
    public void setprogName(String name){
        progName = name;
    }
    public void setDuration(String duration){
    this.duration = duration;
    }
    public void setRemarks(String remarks){
    this.remarks = remarks;
    }
    
    public int getprogtID(){
        return progID;
    }
    public String getprogtName(){
        return progName;
    }
     public String getDuration(){
        return duration;
    }
    public String getReamrks(){
        return remarks;
    }
    public String toString(){
        return progName;
    }
}
