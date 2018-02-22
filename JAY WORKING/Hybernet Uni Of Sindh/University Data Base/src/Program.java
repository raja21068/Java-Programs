class Program{
  // Variables declaration - do not modify
    private int deptID;
    private int progID;
    private String progName;
    private int duration;
    private String remarks;

    public Program(int deptID, String progName, int duration, String remarks){
this.deptID = deptID;
this.progName = progName;
this.duration = duration;
this.remarks = remarks;}



//Setter Methods Generated
    public void setDeptID(int deptID){
        this.deptID = deptID ;
    }
    public void setProgID(int progID){
        this.progID = progID ;
    }
    public void setProgName(String progName){
        this.progName = progName ;
    }
    public void setDuration(int duration){
        this.duration = duration ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getDeptID(){
        return this.deptID ;
    }
    public int getProgID(){
        return this.progID ;
    }
    public String getProgName(){
        return this.progName ;
    }
    public int getDuration(){
        return this.duration ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return progName;
       }
}
