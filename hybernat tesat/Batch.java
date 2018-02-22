class Batch{
  // Variables declaration - do not modify
    private int progId;
    private int batchId;
    private int batchYear;
    private String shift;
    private String groupDesc;
    private String remarks;
    private String session;

    public Batch(){}
public Batch(int progId, int batchYear, String shift, String groupDesc, String remarks, String session){
this.progId = progId;
this.batchYear = batchYear;
this.shift = shift;
this.groupDesc = groupDesc;
this.remarks = remarks;
this.session = session;}



//Setter Methods Generated
    public void setProgId(int progId){
        this.progId = progId ;
    }
    public void setBatchId(int batchId){
        this.batchId = batchId ;
    }
    public void setBatchYear(int batchYear){
        this.batchYear = batchYear ;
    }
    public void setShift(String shift){
        this.shift = shift ;
    }
    public void setGroupDesc(String groupDesc){
        this.groupDesc = groupDesc ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }
    public void setSession(String session){
        this.session = session ;
    }




//Getter Methods Generated
    public int getProgId(){
        return this.progId ;
    }
    public int getBatchId(){
        return this.batchId ;
    }
    public int getBatchYear(){
        return this.batchYear ;
    }
    public String getShift(){
        return this.shift ;
    }
    public String getGroupDesc(){
        return this.groupDesc ;
    }
    public String getRemarks(){
        return this.remarks ;
    }
    public String getSession(){
        return this.session ;
    }

    public String toString(){
        return "";
       }
}
