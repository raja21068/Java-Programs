/**
 *
 * @author Jay Kumar
 */
public class DepartmentBean {
    int deptID;
    String deptName;
    String remarks;
    public void setDeptName(String name){
        deptName = name;
    }
    public void setReamrks(String remarks){
    this.remarks = remarks;
    }
    public int getDeptID(){
        return deptID;
    }
     public String getDeptName(){
        return deptName;
    }
    public String getReamrks(){
    return remarks;
    }
    public String toString(){
        return deptName;
    }
}
