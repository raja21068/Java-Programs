import java.io.*;
/**
 *
 * @author Jay Kumar
 */
public class DepartmentBean implements Serializable{
    private int facultyID;
    private int deptID;
    private String deptName;
    private String remarks;
    
    public void setDeptID(int id){
        deptID = id;
    }
    
    public void setDeptName(String name){
        deptName = name;
    }
    public void setRemarks(String remarks){
    this.remarks = remarks;
    }
    public void setfacultyID(int fac_ID){
        facultyID = fac_ID;
    }
    public int getFacultyID(){
        return facultyID;
    }
    public int getDeptID(){
        return deptID;
    }
     public String getDeptName(){
        return deptName;
    }
    public String getRemarks(){
    return remarks;
    }
    public String toString(){
        return deptName;
    }
}
