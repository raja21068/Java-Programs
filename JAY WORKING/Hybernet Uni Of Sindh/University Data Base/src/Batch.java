class Batch{
  // Variables declaration - do not modify
    private int progID;
    private int batchID;
    private int batchYear;
    private int shift;
    private int group;
    private int session;
    private String remarks;

    public Batch(int progID, int batchYear, int shift, int group, int session, String remarks){
this.progID = progID;
this.batchYear = batchYear;
this.shift = shift;
this.group = group;
this.session = session;
this.remarks = remarks;}



//Setter Methods Generated
    public void setProgID(int progID){
        this.progID = progID ;
    }
    public void setBatchID(int batchID){
        this.batchID = batchID ;
    }
    public void setBatchYear(int batchYear){
        this.batchYear = batchYear ;
    }
    public void setShift(int shift){
        this.shift = shift ;
    }
    public void setGroup(int group){
        this.group = group ;
    }
    public void setSession(int session){
        this.session = session ;
    }
    public void setRemarks(String remarks){
        this.remarks = remarks ;
    }




//Getter Methods Generated
    public int getProgID(){
        return this.progID ;
    }
    public int getBatchID(){
        return this.batchID ;
    }
    public int getBatchYear(){
        return this.batchYear ;
    }
    public int getShift(){
        return this.shift ;
    }
    public int getGroup(){
        return this.group ;
    }
    public int getSession(){
        return this.session ;
    }
    public String getRemarks(){
        return this.remarks ;
    }

    public String toString(){
        return ""+batchYear;
       }
}
