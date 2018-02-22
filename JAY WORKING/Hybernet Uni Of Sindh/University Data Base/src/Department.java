class Department{
  // Variables declaration - do not modify
    private int factId;
    private int deptID;
    private String deptName;
    private String remarks;

    public Department(){}
    public Department(int factId, String deptName, String remarks){
this.factId = factId;
this.deptName = deptName;
this.remarks = remarks;}



//Setter Methods Generated
    public void setFactId(int factId){
        this.factId = factId ;
    }
    public void setDeptID(int deptID){
        this.deptID = deptID ;
    }
    public void setDeptName(String deptName){
        this.deptName = deptName ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getFactId(){
        return this.factId ;
    }
    public int getDeptID(){
        return this.deptID ;
    }
    public String getDeptName(){
        return this.deptName ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return deptName;
       }
}
