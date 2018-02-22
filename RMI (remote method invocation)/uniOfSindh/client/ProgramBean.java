import java.io.*;
/**
 *
 * @author Jay Kumar
 */
public class ProgramBean implements Serializable{
    private int progID;
    private int dept_ID;
    private String progName;
    private int duration;
    private String remarks;
    
    public void setProgID(int id){
        progID = id;
    }
    public void setDeptID(int id){
        dept_ID = id;
    }
    public void setProgName(String name){
        progName = name;
    }
    public void setDuration(int duration){
    this.duration = duration;
    }
    public void setRemarks(String remarks){
    this.remarks = remarks;
    }
    
    public int getProgID(){
        return progID;
    }
    public int getDeptID(){
        return dept_ID;
    }
    public String getProgName(){
        return progName;
    }
     public int getDuration(){
        return duration;
    }
    public String getRemarks(){
        return remarks;
    }
    public String toString(){
        return progName;
    }
}
