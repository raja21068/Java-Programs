class Program{
  // Variables declaration - do not modify
    private int deptId;
    private int progId;
    private String progName;
    private int duration;
    private String remarks;

    public Program(){}
public Program(int deptId, String progName, int duration, String remarks){
this.deptId = deptId;
this.progName = progName;
this.duration = duration;
this.remarks = remarks;}



//Setter Methods Generated
    public void setDeptId(int deptId){
        this.deptId = deptId ;
    }
    public void setProgId(int progId){
        this.progId = progId ;
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
    public int getDeptId(){
        return this.deptId ;
    }
    public int getProgId(){
        return this.progId ;
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
        return "";
       }
}
