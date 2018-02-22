class Department{
  // Variables declaration - do not modify
    private int facId;
    private int deptId;
    private String deptName;
    private String remarks;

    public Department(){}
public Department(int facId, String deptName, String remarks){
this.facId = facId;
this.deptName = deptName;
this.remarks = remarks;}



//Setter Methods Generated
    public void setFacId(int facId){
        this.facId = facId ;
    }
    public void setDeptId(int deptId){
        this.deptId = deptId ;
    }
    public void setDeptName(String deptName){
        this.deptName = deptName ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getFacId(){
        return this.facId ;
    }
    public int getDeptId(){
        return this.deptId ;
    }
    public String getDeptName(){
        return this.deptName ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return "";
       }
}
